package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepIdent;
import abstsyn.IAbstSyn.IGlobInit;

public final class RepIdentEps implements IRepIdent {

	@Override
	public IGlobInit toAbstrSyntax() {
		return new abstsyn.implementation.GlobInitEps();
	}
	
	@Override
	public String toString(final String indent) {
		return indent + "<RepIdentEps/>\n";
	}
}
