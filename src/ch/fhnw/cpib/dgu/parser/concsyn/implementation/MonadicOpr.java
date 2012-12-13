package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IMonadicOpr;
import ch.fhnw.cpib.dgu.token.classes.Base;

public final class MonadicOpr implements IMonadicOpr {
	private final Base operator;
	
	public MonadicOpr(final Base operator) {
		this.operator = operator;
	}

	@Override
	public Base toAbstrSyntax() {
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
