package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepTerm3;
import token.classes.Operator.AddOpr;
import abstsyn.implementation.ExprDyadic;

public class RepTerm3 implements IRepTerm3 {
	private AddOpr addOpr;
	private ITerm3 term3;
	private IRepTerm3 repTerm3;
	
	public RepTerm3(AddOpr addOpr, ITerm3 term3, IRepTerm3 repTerm3) {
		this.addOpr = addOpr;
		this.term3 = term3;
		this.repTerm3 = repTerm3;
	}

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax(abstsyn.IAbstSyn.IExpr expr) {
		ExprDyadic exprDya = new ExprDyadic(addOpr, expr, term3.toAbstrSyntax());
		return repTerm3.toAbstrSyntax(exprDya);
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<RepTerm3>\n" +
				addOpr.toString(indent + '\t') +
				term3.toString(indent + '\t') +
				repTerm3.toString(indent + '\t') +
				indent +
				"</RepTerm3>\n";
	}
}
