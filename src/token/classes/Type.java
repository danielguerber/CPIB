package token.classes;

import token.enums.Terminals;
import token.enums.Types;

public class Type extends Base{

	private final Types type;
	
	public Type(Types type) {
		this(type, -1);
	}
	
	private Type(Types type, int line) {
		super(Terminals.TYPE, line);
		this.type = type;
	}
	
	private Type(Type type) {
		super(type);
		this.type=type.type;
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
}
