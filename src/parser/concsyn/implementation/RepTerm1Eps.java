package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepTerm1;

public class RepTerm1Eps implements IRepTerm1 {

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax(abstsyn.IAbstSyn.IExpr expr) {
		return expr;
	}

	@Override
	public String toString(String indent) {
		return indent + "<RepTerm1Eps/>\n";
	}
}
