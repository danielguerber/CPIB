package token.classes;

import token.enums.Terminals;

public class Base {
	private final Terminals terminal;
	
	public Base(Terminals terminal) {
		this.terminal = terminal;
	}
	
	public final Terminals getTerminal() {
		return terminal;
	}
	
	public String toString() {
		return terminal.toString();
	}
}
