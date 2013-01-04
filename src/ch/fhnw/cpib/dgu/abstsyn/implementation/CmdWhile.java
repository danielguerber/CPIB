package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.IMLCompiler;
import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.ICmd;
import ch.fhnw.cpib.dgu.token.enums.Types;
import ch.fhnw.lederer.virtualmachineHS2010.IVirtualMachine.CodeTooSmallError;

public final class CmdWhile implements ICmd {
	private final IExpr expr;
	private final ICmd cmd;
	private final ICmd repCmd;
	
	public CmdWhile(final IExpr expr, 
	        final ICmd cmd, 
	        final ICmd repCmd) {
		this.expr = expr;
		this.cmd = cmd;
		this.repCmd = repCmd;
	}
	
	@Override
    public String toString(final String indent) {
		return indent
				+ "<CmdWhile>\n"
				+ expr.toString(indent + '\t')
				+ cmd.toString(indent + '\t')
				+ repCmd.toString(indent + '\t')
				+ indent
				+ "</CmdWhile>\n";
	}
	
	@Override
	public int getLine() {
	    return expr.getLine();
	}

    @Override
    public void check(final boolean canInit) throws ContextError {
        if (!expr.checkR().equals(Types.BOOL)) {
            throw new ContextError(
                    "WHILE condition must be a boolean! ",
                     expr.getLine());
        }
        
        cmd.check(true);
        repCmd.check(canInit);
    }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        int loc1 = expr.code(loc);
        int loc2 = cmd.code(loc1 + 1);
        IMLCompiler.getVM().CondJump(loc1, loc2 + 1);
        IMLCompiler.getVM().UncondJump(loc2, loc);
        return repCmd.code(loc2 + 1);
    }
}
