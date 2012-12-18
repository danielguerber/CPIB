package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IParam;
import ch.fhnw.cpib.dgu.context.Routine;

public final class ParamEps implements IParam {
	@Override
	public String toString(final String indent) {
		return indent + "<ParamEps/>\n";
	}
	
	@Override
	public int getLine() {
	    return -1;
	}

    @Override
    public void check(final Routine routine) throws ContextError { }

    @Override
    public void checkInit() throws ContextError { }
}
