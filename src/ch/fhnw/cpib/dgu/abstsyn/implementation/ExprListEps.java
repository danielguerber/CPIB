package ch.fhnw.cpib.dgu.abstsyn.implementation;

import java.util.List;
import java.util.Set;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExprList;
import ch.fhnw.cpib.dgu.context.Parameter;

public final class ExprListEps implements IExprList {
	@Override
	public String toString(final String indent) {
		return indent + "<ExprListEps/>\n";
	}
	
	@Override
	public int getLine() {
	    return -1;
	}

    @Override
    public void check(
            final List<Parameter> paramList, 
            final Set<String> aliasList,
            final boolean canInit) throws ContextError {

        if (paramList.size() > 0) {
            throw new ContextError(
                    "Missing parameter!", 
                    -1);
        }
    }
}
