package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.ICmd;
import parser.concsyn.IConcSyn.IRepCmd;

public class RepCmd implements IRepCmd {
	private ICmd cmd;
	private IRepCmd repCmd;
	
	public RepCmd(ICmd cmd, IRepCmd repCmd) {
		this.cmd = cmd;
		this.repCmd = repCmd;
	}
}
