package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepCmd;

public final class RepCmdEps implements IRepCmd {

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.ICmd toAbstrSyntax() {
		return new ch.fhnw.cpib.dgu.abstsyn.implementation.CmdEps();
	}
	
	@Override
	public String toString(final String indent) {
		return indent + "<RepCmdEps/>\n";
	}
}
