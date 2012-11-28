package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxChangeMode;
import ch.fhnw.cpib.dgu.token.classes.Mode.ChangeMode;
import ch.fhnw.cpib.dgu.token.enums.Modes;

public final class AuxChangeModeEps implements IAuxChangeMode {

	@Override
	public ChangeMode toAbstrSyntax() {
		return new ChangeMode(Modes.CONST);
	}
	
	@Override
	public String toString(final String indent) {
		return indent + "<AuxChangeModeEps/>\n";
	}
	
}
