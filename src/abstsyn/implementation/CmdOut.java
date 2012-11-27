package abstsyn.implementation;

import abstsyn.IAbstSyn.ICmd;

public class CmdOut implements ICmd {
	private IExpr expr;
	
	public CmdOut(IExpr expr) {
		this.expr = expr;
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<CmdOut>\n" +
				expr.toString(indent + '\t') +
				indent +
				"</CmdOut>\n";
	}
}
