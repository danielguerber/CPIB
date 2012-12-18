package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.ICmd;

public final class CmdSkip implements ICmd {
	private final ICmd repCmd;
	
	public CmdSkip(final ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.ICmd repCmd) {
		this.repCmd = repCmd;
	}

	@Override
    public String toString(final String indent) {
		return indent
				+ "<CmdSkip>\n"
				+ repCmd.toString(indent + '\t')
				+ indent
				+ "</CmdSkip>\n";
	}
	
	@Override
	public int getLine() {
	    return -1;
	}

    @Override
    public void check(final boolean canInit) throws ContextError {
        repCmd.check(canInit);
    }
}
