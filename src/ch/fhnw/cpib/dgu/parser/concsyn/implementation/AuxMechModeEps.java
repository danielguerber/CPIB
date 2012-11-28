package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxMechMode;
import ch.fhnw.cpib.dgu.token.classes.Mode.MechMode;
import ch.fhnw.cpib.dgu.token.enums.Modes;

public final class AuxMechModeEps implements IAuxMechMode {

	@Override
	public MechMode toAbstrSyntax() {
		return new MechMode(Modes.REF); //TODO: Check if this is the default
	}
	
	@Override
	public String toString(final String indent) {
		return indent + "<AuxMechModeEps/>\n";
	}
}
