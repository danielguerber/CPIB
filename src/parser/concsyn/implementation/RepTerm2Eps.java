package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepTerm2;

public class RepTerm2Eps implements IRepTerm2 {

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax(abstsyn.IAbstSyn.IExpr expr) {
		return expr;
	}

	@Override
	public String toString(String indent) {
		return indent + "<RepTerm2Eps/>\n";
	}
}
