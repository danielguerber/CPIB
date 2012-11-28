package token.classes;

import token.enums.Terminals;
import token.enums.Types;

public final class Type extends Base {

	private final Types type;
	
	public Type(final Types type) {
		this(type, -1);
	}
	
	private Type(final Types type, final int line) {
		super(Terminals.TYPE, line);
		this.type = type;
	}
	
	private Type(final Type type) {
		super(type);
		this.type = type.type;
	}
	
	public Types getType() {
		return type;
	}
	
	@Override
    public String toString() {
		return "(" + super.toString() + ", " + type.toString() + ")";
	}
	
	@Override
    public Object clone() {
		return new Type(this);
	}

	public String toString(final String indent) {
		return indent
				+ "<Type type=\""
				+ type.toString()
				+ "\" line=\""
				+ super.getLine()
				+ "\"/>\n";
	}
}
