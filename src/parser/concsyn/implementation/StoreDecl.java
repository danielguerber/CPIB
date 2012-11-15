package parser.concsyn.implementation;

import parser.concsyn.IConcSyn.IStoreDecl;
import token.classes.Ident;
import token.classes.Mode;
import token.classes.Mode.ChangeMode;
import token.classes.Type;

public class StoreDecl implements IStoreDecl {
	private Mode.ChangeMode changeMode;
	private Ident ident;
	private Type type;
	
	public StoreDecl(ChangeMode changeMode, Ident ident, Type type) {
		this.changeMode = changeMode;
		this.ident = ident;
		this.type = type;
	}
}
