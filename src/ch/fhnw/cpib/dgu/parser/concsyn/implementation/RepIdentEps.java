package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IGlobInit;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepIdent;

public final class RepIdentEps implements IRepIdent {

	@Override
	public IGlobInit toAbstrSyntax() {
		return new ch.fhnw.cpib.dgu.abstsyn.implementation.GlobInitEps();
	}
	
	@Override
	public String toString(final String indent) {
		return indent + "<RepIdentEps/>\n";
	}
}
