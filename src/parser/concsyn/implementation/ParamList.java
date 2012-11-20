package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxParamList;
import parser.concsyn.IConcSyn.IParam;
import parser.concsyn.IConcSyn.IParamList;
import parser.concsyn.IConcSyn.IRepParam;

public class ParamList implements IParamList {
	private IAuxParamList auxParamList;
	
	public ParamList(IAuxParamList auxParamList) {
		this.auxParamList=auxParamList;
	}
}
