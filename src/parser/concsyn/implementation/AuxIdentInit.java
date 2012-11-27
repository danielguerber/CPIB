package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxIdent;
import token.classes.Ident;

public class AuxIdentInit implements IAuxIdent {

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax(Ident ident) {
		return new abstsyn.implementation.ExprStore(ident, true);
	}

	@Override
	public String toString(String indent) {
		return indent + "<AuxIdentInit/>\n";
	}
}
