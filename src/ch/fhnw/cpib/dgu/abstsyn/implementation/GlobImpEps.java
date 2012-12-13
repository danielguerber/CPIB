package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IGlobImp;

public final class GlobImpEps implements IGlobImp {
	@Override
	public String toString(final String indent) {
		return indent + "<GlobImpEps/>\n";
	}
	
	@Override
	public int getLine() {
	    return -1;
	}

    @Override
    public void check() throws ContextError { }
}
