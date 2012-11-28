package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxLocCpsDecl;

public final class AuxLocCpsDeclEps implements IAuxLocCpsDecl {

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.ICpsDecl toAbstrSyntax() {
		return new ch.fhnw.cpib.dgu.abstsyn.implementation.CpsDeclEps();
	}

	@Override
	public String toString(final String indent) {
		return indent + "<AuxLocCpsDeclEps/>\n";
	}
}
