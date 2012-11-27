package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxExprList;

public class AuxExprList implements IAuxExprList {
	private IExpr expr;
	private IRepExpr repExpr;

	public AuxExprList(IExpr expr, IRepExpr repExpr) {
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
				"<AuxExprList>\n" +
				expr.toString(indent + '\t') +
				repExpr.toString(indent + '\t') +
				indent +
				"</AuxExprList>\n";
	}
}
