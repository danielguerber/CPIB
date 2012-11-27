package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepFactor;

public class RepFactorEps implements IRepFactor {

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax(abstsyn.IAbstSyn.IExpr expr) {
		return expr;
	}

	@Override
	public String toString(String indent) {
		return indent + "<RepFactorEps/>\n";
	}
}
