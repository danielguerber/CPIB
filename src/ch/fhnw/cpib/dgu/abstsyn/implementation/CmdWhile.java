package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.ICmd;

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
}
