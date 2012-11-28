package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IAuxFlowMode;
import ch.fhnw.cpib.dgu.token.classes.Mode.FlowMode;

public final class AuxFlowMode implements IAuxFlowMode {
	private final FlowMode flowMode;
	
	public AuxFlowMode(final FlowMode flowMode) {
		this.flowMode = flowMode;
	}

	@Override
	public FlowMode toAbstrSyntax() {
		return flowMode;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<AuxFlowMode>\n"
				+ flowMode.toString(indent + '\t')
				+ indent
				+ "</AuxFlowMode>\n";
	}
}
