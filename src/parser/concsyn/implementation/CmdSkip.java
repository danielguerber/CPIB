package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.ICmd;

public class CmdSkip implements ICmd{

	@Override
	public abstsyn.IAbstSyn.ICmd toAbstrSyntax(IRepCmd repCmd) {
		return new abstsyn.implementation.CmdSkip();
	}

	@Override
	public String toString(String indent) {
		return indent +"<CmdSkip/>\n";
	}
}
