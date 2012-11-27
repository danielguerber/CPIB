package abstsyn.implementation;

import abstsyn.IAbstSyn.ICmd;

public class CmdIn implements ICmd {
	private IExpr expr;
	
	public CmdIn(IExpr expr) {
		this.expr = expr;
	}
}
