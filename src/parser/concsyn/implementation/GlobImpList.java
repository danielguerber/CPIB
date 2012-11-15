package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IGlobImp;
import parser.concsyn.IConcSyn.IGlobImpList;
import parser.concsyn.IConcSyn.IRepGlobImp;

public class GlobImpList implements IGlobImpList {
	private IGlobImp globImp;
	private IRepGlobImp repGlobImp;
	
	public GlobImpList(IGlobImp globImp, IRepGlobImp repGlobImp) {
		this.globImp = globImp;
		this.repGlobImp = repGlobImp;
	}	
}
