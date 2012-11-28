package ch.fhnw.cpib.dgu.token.classes;

import ch.fhnw.cpib.dgu.token.enums.Terminals;

public final class Ident extends Base {
	private final CharSequence ident;
	
	public Ident(final CharSequence ident, final int line) {
		super(Terminals.IDENT, line);
		this.ident = ident;
	}
	
	private Ident(final Ident ident) {
		super(ident);
		this.ident = ident.ident;
	}
	
	public CharSequence getIdent() {
		return ident;
	}
	
	@Override
    public String toString() {
		return "(" + super.toString() + ", \"" + ident + "\")";
	}
	
	@Override
    public Object clone() {
		return new Ident(this);
	}

	public String toString(final String indent) {
		return indent
				+ "<Ident ident=\""
				+ ident
				+ "\" line=\""
				+ super.getLine()
				+ "\"/>\n";
	}
	
}
