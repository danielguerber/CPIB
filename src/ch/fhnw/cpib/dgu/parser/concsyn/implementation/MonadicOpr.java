package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IMonadicOpr;
import ch.fhnw.cpib.dgu.token.classes.Operator;

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
