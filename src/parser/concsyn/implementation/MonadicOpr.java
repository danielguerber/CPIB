package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IMonadicOpr;
import token.classes.Operator;

public class MonadicOpr implements IMonadicOpr {
	private Operator operator;
	
	public MonadicOpr(Operator operator) {
		this.operator = operator;
	}

	@Override
	public Operator toAbstrSyntax() {
		return operator;
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<MonadicOpr>\n" +
				operator.toString(indent + '\t') +
				indent +
				"</MonadicOpr>\n";
	}
}
