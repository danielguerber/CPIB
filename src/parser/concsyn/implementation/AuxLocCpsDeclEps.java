package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxLocCpsDecl;

public final class AuxLocCpsDeclEps implements IAuxLocCpsDecl {

	@Override
	public abstsyn.IAbstSyn.ICpsDecl toAbstrSyntax() {
		return new abstsyn.implementation.CpsDeclEps();
	}

	@Override
	public String toString(final String indent) {
		return indent + "<AuxLocCpsDeclEps/>\n";
	}
}
