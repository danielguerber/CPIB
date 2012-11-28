package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IGlobInit;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxGlobInitList;

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
