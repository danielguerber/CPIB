package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxGlobImpList;

public class AuxGlobImpListEps implements IAuxGlobImpList {

	@Override
	public abstsyn.IAbstSyn.IGlobImp toAbstrSyntax() {
		return new abstsyn.implementation.GlobImpEps();
	}
	
	@Override
	public String toString(String indent) {
		return indent + "<AuxGlobImpListEps/>\n";
	}
}
