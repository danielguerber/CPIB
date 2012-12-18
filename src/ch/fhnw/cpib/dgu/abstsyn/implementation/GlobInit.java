package ch.fhnw.cpib.dgu.abstsyn.implementation;

import java.util.Set;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IGlobInit;
import ch.fhnw.cpib.dgu.token.classes.Ident;

public final class GlobInit implements IGlobInit {
	private final Ident ident;
	private final IGlobInit globInit;
	
	public GlobInit(final Ident ident, final IGlobInit globInit) {
		this.ident = ident;
		this.globInit = globInit;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<GlobInit>\n"
				+ ident.toString(indent + '\t')
				+ globInit.toString(indent + '\t')
				+ indent
				+ "</GlobInit>\n";
	}
	
	@Override
	public int getLine() {
	    return ident.getLine();
	}

    @Override
    public Set<String> check(final Set<String> initList) throws ContextError {
        if (initList.contains(ident.getIdent().toString())) {
            throw new ContextError(
                    "Global init already declared!" 
                        + " Ident: " + ident.getIdent(), 
                    ident.getLine());
        } else {
            initList.add(ident.getIdent().toString());
        }
        return globInit.check(initList);
    }
}
