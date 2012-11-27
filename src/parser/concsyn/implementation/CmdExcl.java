package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.ICmd;

public class CmdExcl  implements ICmd {
	private IExpr expr;
	
	public CmdExcl(IExpr expr) {
		this.expr = expr;
	}

	@Override
	public abstsyn.IAbstSyn.ICmd toAbstrSyntax(IRepCmd repCmd) {
		return new abstsyn.implementation.CmdOut(expr.toAbstrSyntax());
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<CmdExcl>\n" +
				expr.toString(indent + '\t') +
				indent +
				"</CmdExcl>\n";
	}
}
