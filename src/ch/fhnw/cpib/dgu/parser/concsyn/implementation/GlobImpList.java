package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IGlobImpList;

public final class GlobImpList implements IGlobImpList {
	private final IGlobImp globImp;
	private final IRepGlobImp repGlobImp;
	
	public GlobImpList(final IGlobImp globImp, final IRepGlobImp repGlobImp) {
		this.globImp = globImp;
		this.repGlobImp = repGlobImp;
	}

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IGlobImp toAbstrSyntax() {
		return globImp.toAbstrSyntax(repGlobImp);
	}	
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<GlobImpList>\n"
				+ globImp.toString(indent + '\t')
				+ repGlobImp.toString(indent + '\t')
				+ indent
				+ "</GlobImpList>\n";
	}
}
