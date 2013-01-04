package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.IMLCompiler;
import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.ICmd;
import ch.fhnw.cpib.dgu.token.enums.Types;
import ch.fhnw.lederer.virtualmachineHS2010.IVirtualMachine.CodeTooSmallError;

public final class CmdIn implements ICmd {
	private final IExpr expr;
	private final ICmd repCmd;
	private Types type;
	
	public CmdIn(final IExpr expr, final ICmd repCmd) {
		this.expr = expr;
		this.repCmd = repCmd;
	}
	
	@Override
    public String toString(final String indent) {
		return indent
				+ "<CmdIn>\n"
				+ expr.toString(indent + '\t')
				+ repCmd.toString(indent + '\t')
				+ indent
				+ "</CmdIn>\n";
	}
	
	@Override
	public int getLine() {
	    return expr.getLine();
	}

    @Override
    public void check(final boolean canInit) throws ContextError {
        type = expr.checkL(canInit);
        if (!(expr instanceof ExprStore)) {
            throw new ContextError(
                    "Input needs to be assigned to a store!",
                     expr.getLine());
        }
        repCmd.check(canInit);
    }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        int loc1 = ((ExprStore) expr).codeRef(loc);
        if (type == Types.BOOL) {
            IMLCompiler.getVM().BoolInput(
                    loc1++, ((ExprStore) expr).getIdent());
        } else {
            IMLCompiler.getVM().IntInput(
                    loc1++, ((ExprStore) expr).getIdent());
        }
        return repCmd.code(loc1);
    }
}
