package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxMechMode;
import token.classes.Mode.MechMode;

public class AuxMechMode implements IAuxMechMode {
	private MechMode mechMode;
	
	public AuxMechMode(MechMode mechMode) {
		this.mechMode = mechMode;
	}
}
