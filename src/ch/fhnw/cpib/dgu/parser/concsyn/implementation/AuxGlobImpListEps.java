package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxGlobImpList;

public final class AuxGlobImpListEps implements IAuxGlobImpList {

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IGlobImp toAbstrSyntax() {
		return new ch.fhnw.cpib.dgu.abstsyn.implementation.GlobImpEps();
	}
	
	@Override
	public String toString(final String indent) {
		return indent + "<AuxGlobImpListEps/>\n";
	}
}
