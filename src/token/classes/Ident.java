package token.classes;

import token.enums.Terminals;

public class Ident extends Base {
	private final CharSequence ident;
	
	public Ident(CharSequence ident, int line) {
		super(Terminals.IDENT,line);
		this.ident=ident;
	}
	
	private Ident(Ident ident) {
		super(ident);
		this.ident=ident.ident;
	}
	
	public CharSequence getIdent() {
		return ident;
	}
	
	@Override
	public String toString() {
		return "(" + super.toString() + ", \"" + ident + "\")";
	}
	
	public Object clone() {
		return new Ident(this);
	}
	
}
