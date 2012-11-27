package parser.concsyn.implementation;

import abstsyn.IAbstSyn.IGlobInit;
import parser.concsyn.IConcSyn.IRepIdent;

public class RepIdentEps implements IRepIdent {

	@Override
	public IGlobInit toAbstrSyntax() {
		return new abstsyn.implementation.GlobInitEps();
	}
	
	@Override
	public String toString(String indent) {
		return indent + "<RepIdentEps/>\n";
	}
}
