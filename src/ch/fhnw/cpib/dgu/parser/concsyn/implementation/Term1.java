package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.ITerm1;

public final class Term1 implements ITerm1 {
	private final ITerm2 term2;
	private final IRepTerm2 repTerm2;
	
	public Term1(final ITerm2 term2, final IRepTerm2 repTerm2) {
		this.term2 = term2;
		this.repTerm2 = repTerm2;
	}

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr toAbstrSyntax() {
		return repTerm2.toAbstrSyntax(term2.toAbstrSyntax());
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<Term1>\n"
				+ term2.toString(indent + '\t')
				+ repTerm2.toString(indent + '\t')
				+ indent
				+ "</Term1>\n";
	}
}
