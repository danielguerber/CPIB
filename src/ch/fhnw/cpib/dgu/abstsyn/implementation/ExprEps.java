package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr;
import ch.fhnw.cpib.dgu.token.enums.Types;

public final class ExprEps implements IExpr {
	@Override
	public String toString(final String indent) {
		return indent + "<ExprEps/>\n";
	}
	
	@Override
	public int getLine() {
	    return -1;
	}

    @Override
    public Types checkR() throws ContextError {
        throw new ContextError(
                "Right part of an assignement can not be empty!",
                -1);
    }
    
    @Override
    public Types checkL(final boolean canInit) throws ContextError {
        throw new ContextError(
                "Only stores are allowed in the left part of assignements",
                -1);
    }
    
    
}
