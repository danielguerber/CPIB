package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxGlobInitList;
import abstsyn.IAbstSyn.IGlobInit;

public final class AuxGlobInitListEps implements IAuxGlobInitList {

	@Override
	public IGlobInit toAbstrSyntax() {
		return new abstsyn.implementation.GlobInitEps();
	}

	@Override
	public String toString(final String indent) {
		return indent + "<AuxGlobInitListEps/>\n";
	}
}
