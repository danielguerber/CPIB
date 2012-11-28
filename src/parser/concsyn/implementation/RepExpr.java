package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepExpr;

public final class RepExpr implements IRepExpr {
	private final IExpr expr;
	private final IRepExpr repExpr;
	
	public RepExpr(final IExpr expr, final IRepExpr repExpr) {
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
	public String toString(final String indent) {
		return indent
				+ "<RepExpr>\n"
				+ expr.toString(indent + '\t')
				+ repExpr.toString(indent + '\t')
				+ indent
				+ "</RepExpr>\n";
	}
}
