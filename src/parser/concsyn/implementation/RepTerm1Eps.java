package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepTerm1;

public final class RepTerm1Eps implements IRepTerm1 {

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax(
	        final abstsyn.IAbstSyn.IExpr expr) {
		return expr;
	}

	@Override
	public String toString(final String indent) {
		return indent + "<RepTerm1Eps/>\n";
	}
}
