package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IFactor;
import token.classes.Literal;

public final class FactorLiteral implements IFactor {
	private final Literal literal;
	
	public FactorLiteral(final Literal literal) {
		this.literal = literal;
	}

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax() {
		return new abstsyn.implementation.ExprLiteral(literal);
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<FactorLiteral>\n"
				+ literal.toString(indent + '\t')
				+ indent
				+ "</FactorLiteral>\n";
	}
}
