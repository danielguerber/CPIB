package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxChangeMode;
import token.classes.Mode.ChangeMode;
import token.enums.Modes;

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
