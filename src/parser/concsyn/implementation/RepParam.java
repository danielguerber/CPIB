package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IParam;
import parser.concsyn.IConcSyn.IRepParam;

public class RepParam implements IRepParam {
	private IParam param;
	private IRepParam repParam;
	
	public RepParam(IParam param, IRepParam repParam) {
		this.param = param;
		this.repParam = repParam;
	}
}
