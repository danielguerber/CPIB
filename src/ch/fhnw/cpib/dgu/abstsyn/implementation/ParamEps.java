package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IParam;

public final class ParamEps implements IParam {
	@Override
	public String toString(final String indent) {
		return indent + "<ParamEps/>\n";
	}
}
