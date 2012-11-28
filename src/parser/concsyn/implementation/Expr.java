package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IExpr;

public final class Expr implements IExpr {
	private final ITerm1 term1;
	private final IRepTerm1 repTerm1;
	
	public Expr(final ITerm1 term1, final IRepTerm1 repTerm1) {
		this.term1 = term1;
		this.repTerm1 = repTerm1;
	}

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax() {
		return repTerm1.toAbstrSyntax(term1.toAbstrSyntax());
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<Expr>\n"
				+ term1.toString(indent + '\t')
				+ repTerm1.toString(indent + '\t')
				+ indent
				+ "</Expr>\n";
	}
}
