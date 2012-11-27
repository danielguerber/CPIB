package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxChangeMode;
import token.classes.Mode.ChangeMode;

public class AuxChangeMode implements IAuxChangeMode {
	private ChangeMode changeMode;
	public AuxChangeMode(ChangeMode changeMode) {
		this.changeMode = changeMode;
	}
	
	@Override
	public ChangeMode toAbstrSyntax() {
		return changeMode;
	}

	@Override
	public String toString(String indent) {
		return indent +
				"<AuxChangeMode>\n" +
				changeMode.toString(indent + '\t') +
				indent +
				"</AuxChangeMode>\n";
	}
}
