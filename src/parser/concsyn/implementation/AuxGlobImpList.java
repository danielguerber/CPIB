package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxGlobImpList;
import parser.concsyn.IConcSyn.IGlobImpList;

public class AuxGlobImpList implements IAuxGlobImpList {
	private IGlobImpList globImpList;
	
	public AuxGlobImpList(IGlobImpList globImpList) {
		this.globImpList = globImpList;
	}
}
