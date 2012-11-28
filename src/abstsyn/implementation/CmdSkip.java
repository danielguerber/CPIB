package abstsyn.implementation;

import abstsyn.IAbstSyn.ICmd;

public final class CmdSkip implements ICmd {
	private final ICmd repCmd;
	
	public CmdSkip(final abstsyn.IAbstSyn.ICmd repCmd) {
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
}
