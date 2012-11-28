package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxGlobImpList;

public final class AuxGlobImpListEps implements IAuxGlobImpList {

	@Override
	public abstsyn.IAbstSyn.IGlobImp toAbstrSyntax() {
		return new abstsyn.implementation.GlobImpEps();
	}
	
	@Override
	public String toString(final String indent) {
		return indent + "<AuxGlobImpListEps/>\n";
	}
}
