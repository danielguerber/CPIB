package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IFactor;

public final class FactorExpr implements IFactor {
	private final IExpr expr;
	
	public FactorExpr(final IExpr expr) {
		this.expr = expr;
	}

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr toAbstrSyntax() {
		return expr.toAbstrSyntax();
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<FactorExpr>\n"
				+ expr.toString(indent + '\t')
				+ indent
				+ "</FactorExpr>\n";
	}
}
