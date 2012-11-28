package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepDecl;

public final class RepDeclEps implements IRepDecl {

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.ICpsDecl toAbstrSyntax() {
		return new ch.fhnw.cpib.dgu.abstsyn.implementation.CpsDeclEps();
	}
	
	@Override
	public String toString(final String indent) {
		return indent + "<RepDeclEps/>\n";
	}
}
