package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IParam;
import ch.fhnw.cpib.dgu.context.Routine;
import ch.fhnw.lederer.virtualmachineHS2010.IVirtualMachine.CodeTooSmallError;

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

    @Override
    public int calculateAddress(final int count, final int locals) {
        return locals;
    }

    @Override
    public int codeIn(final int loc, final int count, final int locals) 
            throws CodeTooSmallError {
        return loc;
    }

    @Override
    public int codeOut(final int loc, final int count, final int locals) 
            throws CodeTooSmallError {
        return loc;
    }
}
