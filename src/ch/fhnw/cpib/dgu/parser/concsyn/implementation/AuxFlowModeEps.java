package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxFlowMode;
import ch.fhnw.cpib.dgu.token.classes.Mode.FlowMode;
import ch.fhnw.cpib.dgu.token.enums.Modes;

public final class AuxFlowModeEps implements IAuxFlowMode {

	@Override
	public FlowMode toAbstrSyntax() {
		return new FlowMode(Modes.IN); //TODO: Check if this is the default
	}
	
	@Override
	public String toString(final String indent) {
		return indent + "<AuxFlowModeEps/>\n";
	}
}
