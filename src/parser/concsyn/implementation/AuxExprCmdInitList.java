package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxExprCmd;
import parser.concsyn.IConcSyn.IAuxGlobInitList;

public class AuxExprCmdInitList implements IAuxExprCmd {
	private IAuxGlobInitList auxGlobInitList;
	
	public AuxExprCmdInitList(IAuxGlobInitList auxGlobInitList) {
		this.auxGlobInitList = auxGlobInitList;
	}

}
