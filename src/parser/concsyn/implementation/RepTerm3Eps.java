package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepTerm3;

public final class RepTerm3Eps implements IRepTerm3 {

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax(
	        final abstsyn.IAbstSyn.IExpr expr) {
		return expr;
	}
	
	@Override
	public String toString(final String indent) {
		return indent + "<RepTerm3Eps/>\n";
	}
}
