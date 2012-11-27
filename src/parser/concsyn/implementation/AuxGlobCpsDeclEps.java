package parser.concsyn.implementation;

import abstsyn.implementation.CpsDeclEps;
import parser.concsyn.IConcSyn.IAuxGlobCpsDecl;

public class AuxGlobCpsDeclEps implements IAuxGlobCpsDecl {

	@Override
	public abstsyn.IAbstSyn.ICpsDecl toAbstrSyntax() {
		return new CpsDeclEps();
	}
	
	@Override
	public String toString(String indent) {
		return indent + "<AuxGlobCpsDeclEps/>\n";
	}
}
