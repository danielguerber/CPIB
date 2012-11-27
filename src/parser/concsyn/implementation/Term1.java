package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.ITerm1;

public class Term1 implements ITerm1 {
	private ITerm2 term2;
	private IRepTerm2 repTerm2;
	
	public Term1(ITerm2 term2, IRepTerm2 repTerm2) {
		this.term2 = term2;
		this.repTerm2 = repTerm2;
	}

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax() {
		return repTerm2.toAbstrSyntax(term2.toAbstrSyntax());
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<Term1>\n" +
				term2.toString(indent + '\t') +
				repTerm2.toString(indent + '\t') +
				indent +
				"</Term1>\n";
	}
}
