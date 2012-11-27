package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepDecl;

public class RepDeclEps implements IRepDecl {

	@Override
	public abstsyn.IAbstSyn.ICpsDecl toAbstrSyntax() {
		return new abstsyn.implementation.CpsDeclEps();
	}
	
	@Override
	public String toString(String indent) {
		return indent + "<RepDeclEps/>\n";
	}
}
