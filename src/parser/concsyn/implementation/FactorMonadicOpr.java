package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IFactor;

public class FactorMonadicOpr implements IFactor {
	private IMonadicOpr monadicOpr;
	private IFactor factor;
	
	public FactorMonadicOpr(IMonadicOpr monadicOpr, IFactor factor) {
		this.monadicOpr = monadicOpr;
		this.factor = factor;
	}

	@Override
	public abstsyn.IAbstSyn.IExpr toAbstrSyntax() {
		return new abstsyn.implementation.ExprMonadic(
				monadicOpr.toAbstrSyntax(),
				factor.toAbstrSyntax());
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<FactorMonadicOpr>\n" +
				monadicOpr.toString(indent + '\t') +
				factor.toString(indent + '\t') +
				indent +
				"</FactorMonadicOpr>\n";
	}
}
