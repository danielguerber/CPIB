package abstsyn.implementation;

import abstsyn.IAbstSyn.ICmd;

public class CmdIn implements ICmd {
	private IExpr expr;
	
	public CmdIn(IExpr expr) {
		this.expr = expr;
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<CmdIn>\n" +
				expr.toString(indent + '\t') +
				indent +
				"</CmdIn>\n";
	}
}
