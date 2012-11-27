package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.ICmd;

public class CmdQuest implements ICmd {
	private IExpr expr;
	
	public CmdQuest(IExpr expr) {
		this.expr = expr;
	}

	@Override
	public abstsyn.IAbstSyn.ICmd toAbstrSyntax(IRepCmd repCmd) {
		return new abstsyn.implementation.CmdIn(expr.toAbstrSyntax());
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<CmdQuest>\n" +
				expr.toString(indent + '\t') +
				indent +
				"</CmdQuest>\n";
	}
}
