package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IParam;
import parser.concsyn.IConcSyn.IParamList;
import parser.concsyn.IConcSyn.IRepParam;

public class ParamList implements IParamList {
	private IParam param;
	private IRepParam repParam;
	
	public ParamList(IParam param, IRepParam repParam) {
		this.param = param;
		this.repParam = repParam;
	}
}
