package abstsyn.implementation;

import abstsyn.IAbstSyn.ICmd;

public final class CmdEps implements ICmd {
	@Override
    public String toString(final String indent) {
		return indent + "<CmdEps/>\n";
	}
}
