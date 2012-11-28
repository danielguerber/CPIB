package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepTerm2;

public final class RepTerm2Eps implements IRepTerm2 {

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax(
	        final abstsyn.IAbstSyn.IExpr expr) {
		return expr;
	}

	@Override
	public String toString(final String indent) {
		return indent + "<RepTerm2Eps/>\n";
	}
}
