package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxParamList;
import parser.concsyn.IConcSyn.IParamList;

public class ParamList implements IParamList {
	private IAuxParamList auxParamList;
	
	public ParamList(IAuxParamList auxParamList) {
		this.auxParamList=auxParamList;
	}
}
