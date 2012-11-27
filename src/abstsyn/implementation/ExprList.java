package abstsyn.implementation;

import abstsyn.IAbstSyn.IExprList;

public class ExprList implements IExprList {
	private IExpr expr;
	private IExprList exprList;
	
	public ExprList(IExpr expr, IExprList exprList) {
		this.expr = expr;
		this.exprList = exprList;
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<ExprList>\n" +
				expr.toString(indent + '\t') +
				exprList.toString(indent + '\t') +
				indent +
				"</ExprList>\n";
	}
}
