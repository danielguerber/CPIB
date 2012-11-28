package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepTerm3;

public final class RepTerm3Eps implements IRepTerm3 {

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr toAbstrSyntax(
	        final ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr expr) {
		return expr;
	}
	
	@Override
	public String toString(final String indent) {
		return indent + "<RepTerm3Eps/>\n";
	}
}
