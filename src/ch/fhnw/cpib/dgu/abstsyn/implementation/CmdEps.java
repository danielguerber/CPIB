package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.ICmd;
import ch.fhnw.lederer.virtualmachineHS2010.IVirtualMachine.CodeTooSmallError;

public final class CmdEps implements ICmd {
	@Override
    public String toString(final String indent) {
		return indent + "<CmdEps/>\n";
	}
	
	@Override
	public int getLine() {
	    return -1;
	}

    @Override
    public void check(final boolean canInit) { }

    @Override
    public int code(final int loc) throws CodeTooSmallError {
        return loc;
    }
}
