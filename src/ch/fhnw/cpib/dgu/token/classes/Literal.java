package ch.fhnw.cpib.dgu.token.classes;

import ch.fhnw.cpib.dgu.token.enums.Terminals;
import ch.fhnw.cpib.dgu.token.enums.Types;

public final class Literal extends Base {
	private final int literal;
	private final Types type;
	
	public Literal(final int literal, final Types type) {
		this(literal, type, -1);
	}
	
	public Literal(final int literal, final Types type, final int line) {
		super(Terminals.LITERAL, line);
		this.literal = literal;
		this.type = type;
	}
	
	private Literal(final Literal literal) {
		super(literal);
		this.literal = literal.literal;
		this.type = literal.type;
	}
	
	public int getLiteral() {
		return literal;
	}
	
	public Types getType() {
	    return type;
	}
	
	@Override
	public String toString() {
		switch (type) {
		case INT32:
			return "(" + super.toString() + ", IntValue " + literal + ")";
		case BOOL:
			return "(" + super.toString() + ", BoolValue "
			    + String.valueOf(literal != 0) + ")";
		default:
			return "(" + super.toString() + ", "
			    + type.toString() + " " + literal + ")";
		}
	}
	
	@Override
    public Object clone() {
		return new Literal(this);
	}

	public String toString(final String indent) {
		return indent
				+ "<Literal literal=\""
				+ this.literal
				+ "\" type=\""
				+ this.type.toString()
				+ "\" line=\""
				+ super.getLine()
				+ "\"/>\n";
	}
	
}
