package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.implementation.CpsDeclEps;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxGlobCpsDecl;

public final class AuxGlobCpsDeclEps implements IAuxGlobCpsDecl {

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.ICpsDecl toAbstrSyntax() {
		return new CpsDeclEps();
	}
	
	@Override
	public String toString(final String indent) {
		return indent + "<AuxGlobCpsDeclEps/>\n";
	}
}
