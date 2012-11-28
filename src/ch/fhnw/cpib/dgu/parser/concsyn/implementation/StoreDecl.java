package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IStoreDecl;
import ch.fhnw.cpib.dgu.token.classes.Ident;
import ch.fhnw.cpib.dgu.token.classes.Type;

public final class StoreDecl implements IStoreDecl {
	private final IAuxChangeMode auxChangeMode;
	private final Ident ident;
	private final Type type;
	
	public StoreDecl(
	        final IAuxChangeMode auxChangeMode, 
	        final Ident ident, 
	        final Type type) {
		this.auxChangeMode = auxChangeMode;
		this.ident = ident;
		this.type = type;
	}

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IStoreDecl toAbstrSyntax() {
		return new ch.fhnw.cpib.dgu.abstsyn.implementation.StoreDecl(
				auxChangeMode.toAbstrSyntax(),
				ident,
				type);
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<StoreDecl>\n"
				+ auxChangeMode.toString(indent + '\t')
				+ ident.toString(indent + '\t')
				+ type.toString(indent + '\t')
				+ indent
				+ "</StoreDecl>\n";
	}
}
