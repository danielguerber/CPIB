package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxExprCmd;

public class AuxExprCmdBecomes implements IAuxExprCmd {
	private IExpr expr;
	
	public AuxExprCmdBecomes(IExpr expr) {
		this.expr = expr;
	}

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax() {
		return expr.toAbstrSyntax();
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<AuxExprCmdBecomes>\n" +
				expr.toString(indent + '\t') +
				indent +
				"</AuxExprCmdBecomes>\n";
	}
}
