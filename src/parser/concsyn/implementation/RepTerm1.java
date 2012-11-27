package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepTerm1;
import token.classes.Operator.BoolOpr;
import abstsyn.implementation.ExprDyadic;

public class RepTerm1 implements IRepTerm1 {
	private BoolOpr boolOpr;
	private ITerm1 term1;
	private IRepTerm1 repTerm1;
	
	public RepTerm1(BoolOpr boolOpr, ITerm1 term1, IRepTerm1 repTerm1) {
		this.boolOpr = boolOpr;
		this.term1 = term1;
		this.repTerm1 = repTerm1;
	}

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax(abstsyn.IAbstSyn.IExpr expr) {
		ExprDyadic exprDya = new ExprDyadic(boolOpr,expr,term1.toAbstrSyntax());
		return repTerm1.toAbstrSyntax(exprDya);
	}	
	
	@Override
	public String toString(String indent) {
		return indent +
				"<RepTerm1>\n" +
				boolOpr.toString(indent + '\t') +
				term1.toString(indent + '\t') +
				repTerm1.toString(indent + '\t') +
				indent +
				"</RepTerm1>\n";
	}
}
