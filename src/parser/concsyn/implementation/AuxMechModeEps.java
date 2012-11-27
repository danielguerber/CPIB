package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxMechMode;
import token.classes.Mode.MechMode;
import token.enums.Modes;

public class AuxMechModeEps implements IAuxMechMode {

	@Override
	public MechMode toAbstrSyntax() {
		return new MechMode(Modes.REF); //TODO: Check if this is the default
	}
	
	@Override
	public String toString(String indent) {
		return indent + "<AuxMechModeEps/>\n";
	}
}
