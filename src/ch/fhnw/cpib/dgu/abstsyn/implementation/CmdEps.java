package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.ICmd;

public final class CmdEps implements ICmd {
	@Override
    public String toString(final String indent) {
		return indent + "<CmdEps/>\n";
	}
}
