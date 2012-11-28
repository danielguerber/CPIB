package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepCmd;

public final class RepCmdEps implements IRepCmd {

	@Override
	public abstsyn.IAbstSyn.ICmd toAbstrSyntax() {
		return new abstsyn.implementation.CmdEps();
	}
	
	@Override
	public String toString(final String indent) {
		return indent + "<RepCmdEps/>\n";
	}
}
