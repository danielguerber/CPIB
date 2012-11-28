package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn;
import ch.fhnw.cpib.dgu.abstsyn.implementation.ExprStore;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxIdent;
import ch.fhnw.cpib.dgu.token.classes.Ident;

public final class AuxIdentInit implements IAuxIdent {

	@Override
	public IAbstSyn.IExpr toAbstrSyntax(final Ident ident) {
		return new ExprStore(ident, true);
	}

	@Override
	public String toString(final String indent) {
		return indent + "<AuxIdentInit/>\n";
	}
}
