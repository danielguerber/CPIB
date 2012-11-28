package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxFlowMode;
import token.classes.Mode.FlowMode;

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
