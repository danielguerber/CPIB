package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepTerm2;
import token.classes.Operator.RelOpr;
import abstsyn.implementation.ExprDyadic;

public class RepTerm2 implements IRepTerm2 {
	private RelOpr relOpr;
	private ITerm2 term2;
	private IRepTerm2 repTerm2;
	
	public RepTerm2(RelOpr relOpr, ITerm2 term2, IRepTerm2 repTerm2) {
		this.relOpr = relOpr;
		this.term2 = term2;
		this.repTerm2 = repTerm2;
	}

	//TODO: Check if CAND should be inserted here
	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax(abstsyn.IAbstSyn.IExpr expr) {
		ExprDyadic exprDya = new ExprDyadic(relOpr, expr, term2.toAbstrSyntax());
		return repTerm2.toAbstrSyntax(exprDya);
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<RepTerm2>\n" +
				relOpr.toString(indent + '\t') +
				term2.toString(indent + '\t') +
				repTerm2.toString(indent + '\t') +
				indent +
				"</RepTerm2>\n";
	}
}
