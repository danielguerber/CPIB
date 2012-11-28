package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxFlowMode;
import token.classes.Mode.FlowMode;
import token.enums.Modes;

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
