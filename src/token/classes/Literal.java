package token.classes;

import token.enums.Terminals;
import token.enums.Types;

public class Literal extends Base {
	private final int literal;
	private final Types type;
	
	public Literal(int literal, Types type) {
		this(literal,type,-1);
	}
	
	public Literal(int literal, Types type, int line) {
		super(Terminals.LITERAL, line);
		this.literal = literal;
		this.type = type;
	}
	
	private Literal(Literal literal) {
		super(literal);
		this.literal = literal.literal;
		this.type = literal.type;
	}
	
	public int getLiteral() {
		return literal;
	}
	
	@Override
	public String toString() {
		switch (type) {
		case INT32:
			return "(" + super.toString() + ", IntValue " + literal + ")";
		case BOOL:
			return "(" + super.toString() + ", BoolValue " + ((literal==0) ? "false" : "true") + ")";
		default:
			return "(" + super.toString() + ", " + type.toString() + " " + literal + ")";
		}
	}
	
	public Object clone() {
		return new Literal(this);
	}
	
}
