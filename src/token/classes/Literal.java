package token.classes;

import token.enums.Terminals;
import token.enums.Types;

public class Literal extends Base {
	private final int literal;
	private final Types type;
	
	public Literal(int literal, Types type) {
		super(Terminals.LITERAL);
		this.literal = literal;
		this.type = type;
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
	
}
