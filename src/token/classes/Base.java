package token.classes;

import token.enums.Terminals;

public class Base {
	private final Terminals terminal;
	private int line=-1;
	
	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}
	
	public Base(Terminals terminal) {
		this.terminal = terminal;
	}
	
	public Base(Terminals terminal,int line) {
		this(terminal);
		this.line=line;
	}
	
	public Base(Base base) {
		this(base.terminal, base.line);
	}

	public final Terminals getTerminal() {
		return terminal;
	}
	
	public String toString() {
		return terminal.toString();
	}
	
	public Object clone() {
		return new Base(this);
	}
}
