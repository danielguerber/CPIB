package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IMonadicOpr;
import token.classes.Operator.AddOpr;

public class MonadicOprAddOpr implements IMonadicOpr {
	private AddOpr addOpr;
	
	public MonadicOprAddOpr(AddOpr addOpr) {
		this.addOpr = addOpr;
	}
}
