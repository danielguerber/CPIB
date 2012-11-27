package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IFactor;

public class FactorExpr implements IFactor {
	private IExpr expr;
	
	public FactorExpr(IExpr expr) {
		this.expr = expr;
	}

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax() {
		return expr.toAbstrSyntax();
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<FactorExpr>\n" +
				expr.toString(indent + '\t') +
				indent +
				"</FactorExpr>\n";
	}
}
