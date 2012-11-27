package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxExprList;

public class AuxExprListEps implements IAuxExprList {

	@Override
	public abstsyn.IAbstSyn.IExprList toAbstrSyntax() {
		return new abstsyn.implementation.ExprListEps();
	}

	@Override
	public String toString(String indent) {
		return indent + "<AuxExprListEps/>\n";
	}
}
