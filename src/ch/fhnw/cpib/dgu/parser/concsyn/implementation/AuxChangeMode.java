package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxChangeMode;
import ch.fhnw.cpib.dgu.token.classes.Mode.ChangeMode;

public final class AuxChangeMode implements IAuxChangeMode {
	private final ChangeMode changeMode;
	public AuxChangeMode(final ChangeMode changeMode) {
		this.changeMode = changeMode;
	}
	
	@Override
	public ChangeMode toAbstrSyntax() {
		return changeMode;
	}

	@Override
	public String toString(final String indent) {
		return indent
				+ "<AuxChangeMode>\n"
				+ changeMode.toString(indent + '\t')
				+ indent
				+ "</AuxChangeMode>\n";
	}
}
