package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxParamList;

public class AuxParamListEps implements IAuxParamList {

	@Override
	public abstsyn.IAbstSyn.IParam toAbstrSyntax() {
		return new abstsyn.implementation.ParamEps();
	}

	@Override
	public String toString(String indent) {
		return indent + "<AuxParamListEps/>\n";
	}
}
