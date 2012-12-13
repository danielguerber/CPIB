package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.ICmd;

public final class CmdIn implements ICmd {
	private final IExpr expr;
	private final ICmd repCmd;
	
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
}
