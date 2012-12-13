package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.ICpsDecl;

public final class CpsDecl implements ICpsDecl {
	private final IDecl decl;
	private final ICpsDecl cpsDecl;
	
	public CpsDecl(final IDecl decl, final ICpsDecl cpsDecl) {
		this.decl = decl;
		this.cpsDecl = cpsDecl;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<CpsDecl>\n"
				+ decl.toString(indent + '\t')
				+ cpsDecl.toString(indent + '\t')
				+ indent
				+ "</CpsDecl>\n";
	}
	
	@Override
	public int getLine() {
	    return decl.getLine();
	}

    @Override
    public void check(final boolean isGlobal) throws ContextError {
        decl.check(isGlobal);
        cpsDecl.check(isGlobal);
    }

    @Override
    public void checkDeclaration() throws ContextError {
        decl.checkDeclaration();
        cpsDecl.checkDeclaration();
    }
}
