package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepFactor;
import token.classes.Operator.MultOpr;
import abstsyn.implementation.ExprDyadic;

public class RepFactor implements IRepFactor {
	private MultOpr multOpr;
	private IFactor factor;
	private IRepFactor repFactor;
	
	public RepFactor(MultOpr multOpr, IFactor factor, IRepFactor repFactor) {
		this.multOpr = multOpr;
		this.factor = factor;
		this.repFactor = repFactor;
	}

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax(abstsyn.IAbstSyn.IExpr expr) {
		ExprDyadic exprDya = new ExprDyadic(multOpr, expr, factor.toAbstrSyntax());
		return repFactor.toAbstrSyntax(exprDya);
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<RepFactor>\n" +
				multOpr.toString(indent + '\t') +
				factor.toString(indent + '\t') +
				repFactor.toString(indent + '\t') +
				indent +
				"</RepFactor>\n";
	}
}
