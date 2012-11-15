package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IFactor;
import parser.concsyn.IConcSyn.IMonadicOpr;

public class FactorMonadicOpr implements IFactor {
	private IMonadicOpr monadicOpr;
	private IFactor factor;
	
	public FactorMonadicOpr(IMonadicOpr monadicOpr, IFactor factor) {
		this.monadicOpr = monadicOpr;
		this.factor = factor;
	}
}
