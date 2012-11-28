package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxGlobImpList;

public final class AuxGlobImpList implements IAuxGlobImpList {
	private final IGlobImpList globImpList;
	
	public AuxGlobImpList(final IGlobImpList globImpList) {
		this.globImpList = globImpList;
	}

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IGlobImp toAbstrSyntax() {
		return globImpList.toAbstrSyntax();
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<AuxGlobImpList>\n"
				+ globImpList.toString(indent + '\t')
				+ indent
				+ "</AuxGlobImpList>\n";
	}
}
