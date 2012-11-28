package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.ICmd;
import abstsyn.IAbstSyn;

public final class CmdSkip implements ICmd {

	@Override
	public abstsyn.IAbstSyn.ICmd toAbstrSyntax(final IAbstSyn.ICmd repCmd) {
		return new abstsyn.implementation.CmdSkip(repCmd);
	}

	@Override
	public String toString(final String indent) {
		return indent + "<CmdSkip/>\n";
	}
}
