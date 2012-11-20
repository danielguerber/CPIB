package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxGlobInitList;
import parser.concsyn.IConcSyn.IGlobInitList;

public class AuxGlobInitList implements IAuxGlobInitList {
	private IGlobInitList globInitList;
	
	public AuxGlobInitList(IGlobInitList globInitList) {
		this.globInitList = globInitList;
	}
}
