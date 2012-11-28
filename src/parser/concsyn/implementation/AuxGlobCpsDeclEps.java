package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxGlobCpsDecl;
import abstsyn.implementation.CpsDeclEps;

public final class AuxGlobCpsDeclEps implements IAuxGlobCpsDecl {

	@Override
	public abstsyn.IAbstSyn.ICpsDecl toAbstrSyntax() {
		return new CpsDeclEps();
	}
	
	@Override
	public String toString(final String indent) {
		return indent + "<AuxGlobCpsDeclEps/>\n";
	}
}
