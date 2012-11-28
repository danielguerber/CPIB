package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.ICmd;

public final class CmdSkip implements ICmd {

	@Override
	public IAbstSyn.ICmd toAbstrSyntax(final IAbstSyn.ICmd repCmd) {
		return new ch.fhnw.cpib.dgu.abstsyn.implementation.CmdSkip(repCmd);
	}

	@Override
	public String toString(final String indent) {
		return indent + "<CmdSkip/>\n";
	}
}
