package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxParamList;
import parser.concsyn.IConcSyn.IParam;
import parser.concsyn.IConcSyn.IRepParam;

public class AuxParamList implements IAuxParamList {
	private IParam param;
	private IRepParam repParam;
	
	public AuxParamList(IParam param, IRepParam repParam) {
		this.param = param;
		this.repParam = repParam;
	}
}
