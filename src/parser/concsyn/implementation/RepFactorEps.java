package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepFactor;

public final class RepFactorEps implements IRepFactor {

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax(
	        final abstsyn.IAbstSyn.IExpr expr) {
		return expr;
	}

	@Override
	public String toString(final String indent) {
		return indent + "<RepFactorEps/>\n";
	}
}
