package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.ICpsDecl;

public final class CpsDeclEps implements ICpsDecl {
	@Override
	public String toString(final String indent) {
		return indent + "<CpsDeclEps/>\n";
	}
	
	@Override
	public int getLine() {
	    return -1;
	}

    @Override
    public void checkDeclaration() { }

    @Override
    public void check(final boolean isGlobal) { }
}
