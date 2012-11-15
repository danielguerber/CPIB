package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IGlobImp;
import parser.concsyn.IConcSyn.IRepGlobImp;

public class RepGlobImp implements IRepGlobImp {
	private IGlobImp globImp;
	private IRepGlobImp repGlobImp;
	
	public RepGlobImp(IGlobImp globImp, IRepGlobImp repGlobImp) {
		this.globImp = globImp;
		this.repGlobImp = repGlobImp;
	}	
}
