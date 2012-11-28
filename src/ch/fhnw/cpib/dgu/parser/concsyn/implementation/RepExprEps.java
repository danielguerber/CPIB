package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepExpr;

public final class RepExprEps implements IRepExpr {

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExprList toAbstrSyntax() {
		return new ch.fhnw.cpib.dgu.abstsyn.implementation.ExprListEps();
	}

	@Override
	public String toString(final String indent) {
		return indent + "<RepExprEps/>\n";
	}
}
