package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepCmd;

public class RepCmd implements IRepCmd {
	private ICmd cmd;
	private IRepCmd repCmd;
	
	public RepCmd(ICmd cmd, IRepCmd repCmd) {
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
				"<RepCmd>\n" +
				cmd.toString(indent + '\t') +
				repCmd.toString(indent + '\t') +
				indent +
				"</RepCmd>\n";
	}
}
