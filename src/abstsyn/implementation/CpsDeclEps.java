package abstsyn.implementation;

import abstsyn.IAbstSyn.ICpsDecl;

public class CpsDeclEps implements ICpsDecl {
	@Override
	public String toString(String indent) {
		return indent + "<CpsDeclEps/>\n";
	}
}
