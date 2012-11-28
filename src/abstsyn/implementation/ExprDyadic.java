package abstsyn.implementation;

import token.classes.Operator;
import abstsyn.IAbstSyn.IExpr;

public final class ExprDyadic implements IExpr {
	private final Operator operator;
	private final IExpr expr1;
	private final IExpr expr2;
	
	public ExprDyadic(final Operator operator, 
	        final IExpr expr1, 
	        final IExpr expr2) {
		this.operator = operator;
		this.expr1 = expr1;
		this.expr2 = expr2;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<ExprDyadic>\n"
				+ operator.toString(indent + '\t')
				+ expr1.toString(indent + '\t')
				+ expr2.toString(indent + '\t')
				+ indent
				+ "</ExprDyadic>\n";
	}
}
