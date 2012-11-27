package abstsyn.implementation;

import abstsyn.IAbstSyn.IExprList;

public class ExprList implements IExprList {
	private IExpr expr;
	private IExprList exprList;
	
	public ExprList(IExpr expr, IExprList exprList) {
		this.expr = expr;
		this.exprList = exprList;
	}
}
