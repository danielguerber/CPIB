package abstsyn.implementation;

import token.classes.Operator;
import abstsyn.IAbstSyn.IExpr;

public class ExprMonadic implements IExpr {
	private Operator operator;
	private IExpr expr;
	
	public ExprMonadic(Operator operator, IExpr expr) {
		this.operator = operator;
		this.expr = expr;
	}
}
