package abstsyn.implementation;

import token.classes.Ident;
import abstsyn.IAbstSyn.IExpr;

public class ExprCall implements IExpr {
	private Ident ident;
	private IExprList exprList;
	private IGlobInit globInit;
	
	public ExprCall(Ident ident, IExprList exprList, IGlobInit globInit) {
		this.ident = ident;
		this.exprList = exprList;
		this.globInit = globInit;
	}
}
