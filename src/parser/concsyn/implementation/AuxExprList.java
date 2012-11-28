package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxExprList;

public final class AuxExprList implements IAuxExprList {
	private final IExpr expr;
	private final IRepExpr repExpr;

	public AuxExprList(final IExpr expr, final IRepExpr repExpr) {
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
				+ "<AuxExprList>\n"
				+ expr.toString(indent + '\t')
				+ repExpr.toString(indent + '\t')
				+ indent
				+ "</AuxExprList>\n";
	}
}
