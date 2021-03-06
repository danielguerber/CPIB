package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.IMLCompiler;
import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.ICmd;
import ch.fhnw.cpib.dgu.token.enums.Types;
import ch.fhnw.lederer.virtualmachineHS2010.IVirtualMachine.CodeTooSmallError;

public final class CmdExpr implements ICmd {
	private final IExpr targetExpr;
	private final IExpr sourceExpr;
	private final ICmd repCmd;
	
	public CmdExpr(final IExpr targetExpr, 
	        final IExpr sourceExpr, 
	        final ICmd repCmd) {
		this.targetExpr = targetExpr;
		this.sourceExpr = sourceExpr;
		this.repCmd = repCmd;
	}
	
	@Override
    public String toString(final String indent) {
		return indent
				+ "<CmdExpr>\n"
				+ targetExpr.toString(indent + '\t')
				+ sourceExpr.toString(indent + '\t')
				+ repCmd.toString(indent + '\t')
				+ indent
				+ "</CmdExpr>\n";
	}
	
	@Override
	public int getLine() {
	    return targetExpr.getLine();
	}

    @Override
    public void check(final boolean canInit) throws ContextError {
        Types typeL = targetExpr.checkL(canInit);
        if (typeL == Types.PROC) {
            if (!(sourceExpr instanceof ExprEps)) {
                throw new ContextError(
                        "Procedure call can not be in an assignement!: "
                        , targetExpr.getLine());
            }
        } else {
            Types typeR = sourceExpr.checkR();
            if (typeR != typeL) {
                throw new ContextError(
                        "Types in assignemt don't match!: "
                        , targetExpr.getLine());
            }
        }
        repCmd.check(canInit);
    }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        int loc1 = sourceExpr.code(loc);
        if (!(targetExpr instanceof ExprStore)) {
            loc1 = targetExpr.code(loc1);
        } else {
            loc1 = ((ExprStore) targetExpr).codeRef(loc1);
            IMLCompiler.getVM().Store(loc1++);
        }
        return repCmd.code(loc1);
    }
}
