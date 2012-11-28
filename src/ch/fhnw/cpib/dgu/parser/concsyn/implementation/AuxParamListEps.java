package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxParamList;

public final class AuxParamListEps implements IAuxParamList {

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IParam toAbstrSyntax() {
		return new ch.fhnw.cpib.dgu.abstsyn.implementation.ParamEps();
	}

	@Override
	public String toString(final String indent) {
		return indent + "<AuxParamListEps/>\n";
	}
}
