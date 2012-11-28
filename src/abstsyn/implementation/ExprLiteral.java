package abstsyn.implementation;

import token.classes.Literal;
import abstsyn.IAbstSyn.IExpr;

public final class ExprLiteral implements IExpr {
private final Literal literal;
	
	public ExprLiteral(final Literal literal) {
		this.literal = literal;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<ExprLiteral>\n"
				+ literal.toString(indent + '\t')
				+ indent
				+ "</ExprLiteral>\n";
	}
}
