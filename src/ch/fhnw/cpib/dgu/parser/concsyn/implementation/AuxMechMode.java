package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxMechMode;
import ch.fhnw.cpib.dgu.token.classes.Mode.MechMode;

public final class AuxMechMode implements IAuxMechMode {
	private final MechMode mechMode;
	
	public AuxMechMode(final MechMode mechMode) {
		this.mechMode = mechMode;
	}

	@Override
	public MechMode toAbstrSyntax() {
		return mechMode;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<AuxMechMode>\n"
				+ mechMode.toString(indent + '\t')
				+ indent
				+ "</AuxMechMode>\n";
	}
}
