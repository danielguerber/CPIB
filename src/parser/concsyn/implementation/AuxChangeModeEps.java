package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxChangeMode;
import token.classes.Mode.ChangeMode;
import token.enums.Modes;

public class AuxChangeModeEps implements IAuxChangeMode {

	@Override
	public ChangeMode toAbstrSyntax() {
		return new ChangeMode(Modes.CONST);
	}
	
	@Override
	public String toString(String indent) {
		return indent + "<AuxChangeModeEps/>\n";
	}
	
}
