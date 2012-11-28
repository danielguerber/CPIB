package ch.fhnw.cpib.dgu.token.classes;

import ch.fhnw.cpib.dgu.token.enums.Terminals;

public class Base {
	private final Terminals terminal;
	private int line = -1;
	
	public final int getLine() {
		return line;
	}

	public final void setLine(final int line) {
		this.line = line;
	}
	
	public Base(final Terminals terminal) {
		this.terminal = terminal;
	}
	
	Base(final Terminals terminal, final int line) {
		this(terminal);
		this.line = line;
	}
	
	Base(final Base base) {
		this(base.terminal, base.line);
	}

	public final Terminals getTerminal() {
		return terminal;
	}
	
	//CHECKSTYLE:OFF Has to be extended!
	@Override
    public String toString() {
		return terminal.toString();
	}
	
	@Override
    public Object clone() {
		return new Base(this);
	}
	//CHECKSTYLE.ON
}
