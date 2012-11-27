package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IParamList;

public class ParamList implements IParamList {
	private IAuxParamList auxParamList;
	
	public ParamList(IAuxParamList auxParamList) {
		this.auxParamList=auxParamList;
	}

	@Override
	public abstsyn.IAbstSyn.IParam toAbstrSyntax() {
		return auxParamList.toAbstrSyntax();
	}
	
	@Override
	public String toString(String indent) {
		return indent +
				"<ParamList>\n" +
				auxParamList.toString(indent + '\t') +
				indent +
				"</ParamList>\n";
	}
}
