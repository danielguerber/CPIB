package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepExpr;

public class RepExprEps implements IRepExpr {

	@Override
	public abstsyn.IAbstSyn.IExprList toAbstrSyntax() {
		return new abstsyn.implementation.ExprListEps();
	}

	@Override
	public String toString(String indent) {
		return indent + "<RepExprEps/>\n";
	}
}
