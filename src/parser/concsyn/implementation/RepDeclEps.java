package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepDecl;

public final class RepDeclEps implements IRepDecl {

	@Override
	public abstsyn.IAbstSyn.ICpsDecl toAbstrSyntax() {
		return new abstsyn.implementation.CpsDeclEps();
	}
	
	@Override
	public String toString(final String indent) {
		return indent + "<RepDeclEps/>\n";
	}
}
