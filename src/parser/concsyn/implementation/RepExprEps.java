package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepExpr;

public final class RepExprEps implements IRepExpr {

	@Override
	public abstsyn.IAbstSyn.IExprList toAbstrSyntax() {
		return new abstsyn.implementation.ExprListEps();
	}

	@Override
	public String toString(final String indent) {
		return indent + "<RepExprEps/>\n";
	}
}
