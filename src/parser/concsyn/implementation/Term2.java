package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.ITerm2;

public class Term2 implements ITerm2 {
	private ITerm3 term3;
	private IRepTerm3 repTerm3;
	
	public Term2(ITerm3 term3, IRepTerm3 repTerm3) {
		this.term3 = term3;
		this.repTerm3 = repTerm3;
	}

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax() {
		return repTerm3.toAbstrSyntax(term3.toAbstrSyntax());
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<Term2>\n" +
				term3.toString(indent + '\t') +
				repTerm3.toString(indent + '\t') +
				indent +
				"</Term2>\n";
	}
}
