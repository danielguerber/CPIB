package abstsyn.implementation;

import abstsyn.IAbstSyn.ICmd;

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
}
