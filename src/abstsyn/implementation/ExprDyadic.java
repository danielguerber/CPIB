package abstsyn.implementation;

import token.classes.Operator;
import abstsyn.IAbstSyn.IExpr;

public class ExprDyadic implements IExpr {
	private Operator operator;
	private IExpr expr1;
	private IExpr expr2;
	
	public ExprDyadic(Operator operator, IExpr expr1, IExpr expr2) {
		this.operator = operator;
		this.expr1 = expr1;
		this.expr2 = expr2;
	}
}
