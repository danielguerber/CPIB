package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxGlobInitList;
import abstsyn.IAbstSyn.IGlobInit;

public final class AuxGlobInitList implements IAuxGlobInitList {
	private final IGlobInitList globInitList;
	
	public AuxGlobInitList(final IGlobInitList globInitList) {
		this.globInitList = globInitList;
	}

	@Override
	public IGlobInit toAbstrSyntax() {
		return globInitList.toAbstrSyntax();
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<AuxGlobInitList>\n"
				+ globInitList.toString(indent + '\t')
				+ indent
				+ "</AuxGlobInitList>\n";
	}
}
