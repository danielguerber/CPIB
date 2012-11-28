package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IMonadicOpr;
import token.classes.Operator;

public final class MonadicOpr implements IMonadicOpr {
	private final Operator operator;
	
	public MonadicOpr(final Operator operator) {
		this.operator = operator;
	}

	@Override
	public Operator toAbstrSyntax() {
		return operator;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<MonadicOpr>\n"
				+ operator.toString(indent + '\t')
				+ indent
				+ "</MonadicOpr>\n";
	}
}
