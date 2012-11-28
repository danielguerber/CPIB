package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepGlobImp;

public final class RepGlobImp implements IRepGlobImp {
	private final IGlobImp globImp;
	private final IRepGlobImp repGlobImp;
	
	public RepGlobImp(final IGlobImp globImp, final IRepGlobImp repGlobImp) {
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
				+ "<RepGlobImp>\n"
				+ globImp.toString(indent + '\t')
				+ repGlobImp.toString(indent + '\t')
				+ indent
				+ "</RepGlobImp>\n";
	}
}
