package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IBlockCmd;

public class BlockCmd implements IBlockCmd {
	private ICmd cmd;
	private IRepCmd repCmd;
	
	public BlockCmd(ICmd cmd, IRepCmd repCmd) {
		this.cmd = cmd;
		this.repCmd = repCmd;
	}

	@Override
	public abstsyn.IAbstSyn.ICmd toAbstrSyntax() {
		return cmd.toAbstrSyntax(repCmd);
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<BlockCmd>\n" +
				cmd.toString(indent + '\t') +
				repCmd.toString(indent + '\t') +
				indent +
				"</BlockCmd>\n";
	}
}
