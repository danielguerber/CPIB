package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxFlowMode;
import token.classes.Mode.FlowMode;

public class AuxFlowMode implements IAuxFlowMode {
	private FlowMode flowMode;
	
	public AuxFlowMode(FlowMode flowMode) {
		this.flowMode = flowMode;
	}
}
