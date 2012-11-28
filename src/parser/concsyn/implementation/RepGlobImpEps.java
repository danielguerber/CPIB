package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepGlobImp;

public final class RepGlobImpEps implements IRepGlobImp {

	@Override
	public abstsyn.IAbstSyn.IGlobImp toAbstrSyntax() {
		return new abstsyn.implementation.GlobImpEps();
	}
	
	@Override
	public String toString(final String indent) {
		return indent + "<RepGlobImpEps />\n";
	}
}
