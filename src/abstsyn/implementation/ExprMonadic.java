package abstsyn.implementation;

import token.classes.Operator;
import abstsyn.IAbstSyn.IExpr;

public final class ExprMonadic implements IExpr {
	private final Operator operator;
	private final IExpr expr;
	
	public ExprMonadic(final Operator operator, final IExpr expr) {
		this.operator = operator;
		this.expr = expr;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<ExprMonadic>\n"
				+ operator.toString(indent + '\t')
				+ expr.toString(indent + '\t')
				+ indent
				+ "</ExprMonadic>\n";
	}
}
