package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxIdent;
import token.classes.Ident;

public final class AuxIdentInit implements IAuxIdent {

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax(final Ident ident) {
		return new abstsyn.implementation.ExprStore(ident, true);
	}

	@Override
	public String toString(final String indent) {
		return indent + "<AuxIdentInit/>\n";
	}
}
