package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.ICpsDecl;

public final class CpsDeclEps implements ICpsDecl {
	@Override
	public String toString(final String indent) {
		return indent + "<CpsDeclEps/>\n";
	}
}
