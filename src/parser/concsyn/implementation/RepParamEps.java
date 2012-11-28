package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IRepParam;

public final class RepParamEps implements IRepParam {

	@Override
	public abstsyn.IAbstSyn.IParam toAbstrSyntax() {
		return new abstsyn.implementation.ParamEps();
	}

	@Override
	public String toString(final String indent) {
		return indent + "<RepParamEps/>\n";
	}
}
