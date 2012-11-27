package abstsyn.implementation;

import abstsyn.IAbstSyn.ICmd;

public class CmdSkip implements ICmd {
	@Override
	public String toString(String indent) {
		return indent + "<CmdSkip/>\n";
	}
}
