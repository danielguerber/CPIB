package abstsyn.implementation;

import abstsyn.IAbstSyn.ICmd;

public final class CmdIf implements ICmd {
	private final IExpr expr;
	private final ICmd ifCmd;
	private final ICmd elseCmd;
	private final ICmd repCmd;
	
	public CmdIf(final IExpr expr, 
	        final ICmd ifCmd, 
	        final ICmd elseCmd, 
	        final ICmd repCmd) {
		this.expr = expr;
		this.ifCmd = ifCmd;
		this.elseCmd = elseCmd;
		this.repCmd = repCmd;
	}
	
	@Override
    public String toString(final String indent) {
		return indent
				+ "<CmdIf>\n"
				+ expr.toString(indent + '\t')
				+ ifCmd.toString(indent + '\t')
				+ elseCmd.toString(indent + '\t')
				+ repCmd.toString(indent + '\t')
				+ indent
				+ "</CmdIf>\n";
	}
}
