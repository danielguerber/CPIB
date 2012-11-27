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
	
	@Override
	public String toString(String indent) {
		return indent +
				"<ExprDyadic>\n" +
				operator.toString(indent + '\t') +
				expr1.toString(indent + '\t') +
				expr2.toString(indent + '\t') +
				indent +
				"</ExprDyadic>\n";
	}
}
