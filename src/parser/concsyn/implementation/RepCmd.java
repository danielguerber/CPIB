package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepCmd;

public final class RepCmd implements IRepCmd {
	private final ICmd cmd;
	private final IRepCmd repCmd;
	
	public RepCmd(final ICmd cmd, final IRepCmd repCmd) {
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
				+ "<RepCmd>\n"
				+ cmd.toString(indent + '\t')
				+ repCmd.toString(indent + '\t')
				+ indent
				+ "</RepCmd>\n";
	}
}
