package token.classes;

import token.enums.Terminals;
import token.enums.Types;

public class Type extends Base{

	private final Types type;
	
	public Type(Types type) {
		super(Terminals.TYPE);
		this.type = type;
	}
	
	public Types getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return "(" + super.toString() + ", " + type.toString() + ")";
	}
}
