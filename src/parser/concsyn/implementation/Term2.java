package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.ITerm2;

public final class Term2 implements ITerm2 {
	private final ITerm3 term3;
	private final IRepTerm3 repTerm3;
	
	public Term2(final ITerm3 term3, final IRepTerm3 repTerm3) {
		this.term3 = term3;
		this.repTerm3 = repTerm3;
	}

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax() {
		return repTerm3.toAbstrSyntax(term3.toAbstrSyntax());
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<Term2>\n"
				+ term3.toString(indent + '\t')
				+ repTerm3.toString(indent + '\t')
				+ indent
				+ "</Term2>\n";
	}
}
