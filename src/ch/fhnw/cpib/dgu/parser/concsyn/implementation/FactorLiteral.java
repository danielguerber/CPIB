package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IFactor;
import ch.fhnw.cpib.dgu.token.classes.Literal;

public final class FactorLiteral implements IFactor {
	private final Literal literal;
	
	public FactorLiteral(final Literal literal) {
		this.literal = literal;
	}

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr toAbstrSyntax() {
		return new ch.fhnw.cpib.dgu.abstsyn.implementation.ExprLiteral(literal);
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
