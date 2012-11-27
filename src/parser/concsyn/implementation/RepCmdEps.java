package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepCmd;

public class RepCmdEps implements IRepCmd {

	@Override
	public abstsyn.IAbstSyn.ICmd toAbstrSyntax() {
		return new abstsyn.implementation.CmdEps();
	}
	
	@Override
	public String toString(String indent) {
		return indent + "<RepCmdEps/>\n";
	}
}
