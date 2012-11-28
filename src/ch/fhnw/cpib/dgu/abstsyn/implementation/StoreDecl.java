package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IStoreDecl;
import ch.fhnw.cpib.dgu.token.classes.Ident;
import ch.fhnw.cpib.dgu.token.classes.Type;
import ch.fhnw.cpib.dgu.token.classes.Mode.ChangeMode;

public final class StoreDecl implements IStoreDecl {
	private final ChangeMode changeMode;
	private final Ident ident;
	private final Type type;
	
	public StoreDecl(final ChangeMode changeMode, 
	        final Ident ident, 
	        final Type type) {
		this.changeMode = changeMode;
		this.ident = ident;
		this.type = type;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<StoreDecl>\n"
				+ changeMode.toString(indent + '\t')
				+ ident.toString(indent + '\t')
				+ type.toString(indent + '\t')
				+ indent
				+ "</StoreDecl>\n";
	}
}
