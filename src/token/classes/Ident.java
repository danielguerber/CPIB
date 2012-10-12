package token.classes;

import token.enums.Terminals;

public class Ident extends Base {
	private final CharSequence ident;
	
	public Ident(CharSequence ident) {
		super(Terminals.IDENT);
		this.ident=ident;
	}
	
	public CharSequence getIdent() {
		return ident;
	}
	
	@Override
	public String toString() {
		return "(" + super.toString() + ", \"" + ident + "\")";
	}
}
