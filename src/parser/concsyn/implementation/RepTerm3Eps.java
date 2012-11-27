package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepTerm3;

public class RepTerm3Eps implements IRepTerm3 {

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax(abstsyn.IAbstSyn.IExpr expr) {
		return expr;
	}
	
	@Override
	public String toString(String indent) {
		return indent + "<RepTerm3Eps/>\n";
	}
}
