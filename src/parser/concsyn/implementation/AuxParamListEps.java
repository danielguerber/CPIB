package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxParamList;

public final class AuxParamListEps implements IAuxParamList {

	@Override
	public abstsyn.IAbstSyn.IParam toAbstrSyntax() {
		return new abstsyn.implementation.ParamEps();
	}

	@Override
	public String toString(final String indent) {
		return indent + "<AuxParamListEps/>\n";
	}
}
