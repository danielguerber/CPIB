package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IBlockCmd;

public final class BlockCmd implements IBlockCmd {
	private final ICmd cmd;
	private final IRepCmd repCmd;
	
	public BlockCmd(final ICmd cmd, final IRepCmd repCmd) {
		this.cmd = cmd;
		this.repCmd = repCmd;
	}

	@Override
	public abstsyn.IAbstSyn.ICmd toAbstrSyntax() {
		return cmd.toAbstrSyntax(repCmd.toAbstrSyntax());
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<BlockCmd>\n"
				+ cmd.toString(indent + '\t')
				+ repCmd.toString(indent + '\t')
				+ indent
				+ "</BlockCmd>\n";
	}
}
