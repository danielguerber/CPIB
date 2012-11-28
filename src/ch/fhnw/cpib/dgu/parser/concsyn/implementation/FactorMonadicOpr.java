package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IFactor;

public final class FactorMonadicOpr implements IFactor {
	private final IMonadicOpr monadicOpr;
	private final IFactor factor;
	
	public FactorMonadicOpr(
	        final IMonadicOpr monadicOpr, 
	        final IFactor factor) {
		this.monadicOpr = monadicOpr;
		this.factor = factor;
	}

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr toAbstrSyntax() {
		return new ch.fhnw.cpib.dgu.abstsyn.implementation.ExprMonadic(
				monadicOpr.toAbstrSyntax(),
				factor.toAbstrSyntax());
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<FactorMonadicOpr>\n"
				+ monadicOpr.toString(indent + '\t')
				+ factor.toString(indent + '\t')
				+ indent
				+ "</FactorMonadicOpr>\n";
	}
}
