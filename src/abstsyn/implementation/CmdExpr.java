package abstsyn.implementation;

import abstsyn.IAbstSyn.ICmd;

public class CmdExpr implements ICmd {
	private IExpr targetExpr;
	private IExpr sourceExpr;
	
	public CmdExpr(IExpr targetExpr, IExpr sourceExpr) {
		this.targetExpr = targetExpr;
		this.sourceExpr = sourceExpr;
	}
}
