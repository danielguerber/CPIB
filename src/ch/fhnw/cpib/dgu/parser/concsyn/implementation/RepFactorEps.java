package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepFactor;

public final class RepFactorEps implements IRepFactor {

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr toAbstrSyntax(
	        final ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr expr) {
		return expr;
	}

	@Override
	public String toString(final String indent) {
		return indent + "<RepFactorEps/>\n";
	}
}
