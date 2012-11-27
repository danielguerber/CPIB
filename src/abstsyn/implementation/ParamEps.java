package abstsyn.implementation;

import abstsyn.IAbstSyn.IParam;

public class ParamEps implements IParam {
	@Override
	public String toString(String indent) {
		return indent + "<ParamEps/>\n";
	}
}
