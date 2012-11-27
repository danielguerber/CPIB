package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepExpr;

public class RepExpr implements IRepExpr {
	private IExpr expr;
	private IRepExpr repExpr;
	
	public RepExpr(IExpr expr, IRepExpr repExpr) {
		this.expr = expr;
		this.repExpr = repExpr;
	}

	@Override
	public abstsyn.IAbstSyn.IExprList toAbstrSyntax() {
		return new abstsyn.implementation.ExprList(
				expr.toAbstrSyntax(), 
				repExpr.toAbstrSyntax());
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<RepExpr>\n" +
				expr.toString(indent + '\t') +
				repExpr.toString(indent + '\t') +
				indent +
				"</RepExpr>\n";
	}
}
