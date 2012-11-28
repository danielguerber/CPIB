package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxIdent;
import token.classes.Ident;

public final class AuxIdentEps implements IAuxIdent {
	
	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax(final Ident ident) {
		return new abstsyn.implementation.ExprStore(ident, false);
	}

	@Override
	public String toString(final String indent) {
		return indent + "<AuxIdentEps/>\n";
	}
}
