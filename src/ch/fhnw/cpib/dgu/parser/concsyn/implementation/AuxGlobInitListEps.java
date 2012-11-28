package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IGlobInit;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxGlobInitList;

public final class AuxGlobInitListEps implements IAuxGlobInitList {

	@Override
	public IGlobInit toAbstrSyntax() {
		return new ch.fhnw.cpib.dgu.abstsyn.implementation.GlobInitEps();
	}

	@Override
	public String toString(final String indent) {
		return indent + "<AuxGlobInitListEps/>\n";
	}
}
