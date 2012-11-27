package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepParam;

public class RepParamEps implements IRepParam {

	@Override
	public abstsyn.IAbstSyn.IParam toAbstrSyntax() {
		return new abstsyn.implementation.ParamEps();
	}

	@Override
	public String toString(String indent) {
		return indent + "<RepParamEps/>\n";
	}
}
