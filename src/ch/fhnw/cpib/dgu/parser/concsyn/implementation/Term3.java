package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.ITerm3;

public final class Term3 implements ITerm3 {
	private final IFactor factor;
	private final IRepFactor repFactor;
	
	public Term3(final IFactor factor, final IRepFactor repFactor) {
		this.factor = factor;
		this.repFactor = repFactor;
	}

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr toAbstrSyntax() {
		return repFactor.toAbstrSyntax(factor.toAbstrSyntax());
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<Term3>\n"
				+ factor.toString(indent + '\t')
				+ repFactor.toString(indent + '\t')
				+ indent
				+ "</Term3>\n";
	}
}
