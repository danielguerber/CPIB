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
	
	@Override
	public String toString(String indent) {
		return indent +
				"<CmdIf>\n" +
				expr.toString(indent + '\t') +
				ifCmd.toString(indent + '\t') +
				elseCmd.toString(indent + '\t') +
				indent +
				"</CmdIf>\n";
	}
}
