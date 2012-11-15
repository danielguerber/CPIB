package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IBlockCmd;
import parser.concsyn.IConcSyn.ICmd;
import parser.concsyn.IConcSyn.IRepCmd;

public class BlockCmd implements IBlockCmd {
	private ICmd cmd;
	private IRepCmd repCmd;
	
	public BlockCmd(ICmd cmd, IRepCmd repCmd) {
		this.cmd = cmd;
		this.repCmd = repCmd;
	}
}
