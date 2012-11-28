package abstsyn.implementation;

import abstsyn.IAbstSyn.IGlobInit;

public final class GlobInitEps implements IGlobInit {
	@Override
	public String toString(final String indent) {
		return indent + "<GlobInitEps/>\n";
	}
}
