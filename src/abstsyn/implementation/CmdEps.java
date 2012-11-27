package abstsyn.implementation;

import abstsyn.IAbstSyn.ICmd;

public class CmdEps implements ICmd {
	@Override
	public String toString(String indent) {
		return indent + "<CmdEps/>\n";
	}
}
