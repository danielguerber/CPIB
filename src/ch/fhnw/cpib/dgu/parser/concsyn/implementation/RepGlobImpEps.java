package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepGlobImp;

public final class RepGlobImpEps implements IRepGlobImp {

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IGlobImp toAbstrSyntax() {
		return new ch.fhnw.cpib.dgu.abstsyn.implementation.GlobImpEps();
	}
	
	@Override
	public String toString(final String indent) {
		return indent + "<RepGlobImpEps />\n";
	}
}
