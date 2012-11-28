package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxExprList;

public final class AuxExprListEps implements IAuxExprList {

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExprList toAbstrSyntax() {
		return new ch.fhnw.cpib.dgu.abstsyn.implementation.ExprListEps();
	}

	@Override
	public String toString(final String indent) {
		return indent + "<AuxExprListEps/>\n";
	}
}
