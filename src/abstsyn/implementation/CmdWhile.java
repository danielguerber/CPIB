package abstsyn.implementation;

import abstsyn.IAbstSyn.ICmd;

public class CmdWhile implements ICmd {
	private IExpr expr;
	private ICmd cmd;
	
	public CmdWhile(IExpr expr, ICmd cmd) {
		this.expr = expr;
		this.cmd = cmd;
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<CmdWhile>\n" +
				expr.toString(indent + '\t') +
				cmd.toString(indent + '\t') +
				indent +
				"</CmdWhile>\n";
	}
}
