package abstsyn.implementation;

import abstsyn.IAbstSyn.ICmd;

public class CmdIf implements ICmd {
	private IExpr expr;
	private ICmd ifCmd;
	private ICmd elseCmd;
	
	public CmdIf(IExpr expr, ICmd ifCmd, ICmd elseCmd) {
		this.expr = expr;
		this.ifCmd = ifCmd;
		this.elseCmd = elseCmd;
	}
}
