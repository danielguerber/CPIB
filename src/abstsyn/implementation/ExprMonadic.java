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
	
	@Override
	public String toString(String indent) {
		return indent +
				"<ExprMonadic>\n" +
				operator.toString(indent + '\t') +
				expr.toString(indent + '\t') +
				indent +
				"</ExprMonadic>\n";
	}
}
