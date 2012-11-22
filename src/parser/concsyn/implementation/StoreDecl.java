package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IAuxChangeMode;
import parser.concsyn.IConcSyn.IStoreDecl;
import token.classes.Ident;
import token.classes.Type;

public class StoreDecl implements IStoreDecl {
	private IAuxChangeMode auxChangeMode;
	private Ident ident;
	private Type type;
	
	public StoreDecl(IAuxChangeMode auxChangeMode, Ident ident, Type type) {
		this.auxChangeMode = auxChangeMode;
		this.ident = ident;
		this.type = type;
	}
}
