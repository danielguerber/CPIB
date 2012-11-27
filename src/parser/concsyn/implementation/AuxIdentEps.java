package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxIdent;
import token.classes.Ident;

public class AuxIdentEps implements IAuxIdent {
	
	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax(Ident ident) {
		return new abstsyn.implementation.ExprStore(ident, false);
	}

	@Override
	public String toString(String indent) {
		return indent + "<AuxIdentEps/>\n";
	}
}
