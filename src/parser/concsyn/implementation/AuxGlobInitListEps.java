package parser.concsyn.implementation;

import abstsyn.IAbstSyn.IGlobInit;
import parser.concsyn.IConcSyn.IAuxGlobInitList;

public class AuxGlobInitListEps implements IAuxGlobInitList {

	@Override
	public IGlobInit toAbstrSyntax() {
		return new abstsyn.implementation.GlobInitEps();
	}

	@Override
	public String toString(String indent) {
		return indent + "<AuxGlobInitListEps/>\n";
	}
}
