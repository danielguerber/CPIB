package abstsyn.implementation;

import abstsyn.IAbstSyn.IExprList;

public final class ExprList implements IExprList {
	private final IExpr expr;
	private final IExprList exprList;
	
	public ExprList(final IExpr expr, final IExprList exprList) {
		this.expr = expr;
		this.exprList = exprList;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<ExprList>\n"
				+ expr.toString(indent + '\t')
				+ exprList.toString(indent + '\t')
				+ indent
				+ "</ExprList>\n";
	}
}
