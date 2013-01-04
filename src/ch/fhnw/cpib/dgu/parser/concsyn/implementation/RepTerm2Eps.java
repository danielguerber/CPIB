package ch.fhnw.cpib.dgu.parser.concsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn;
import ch.fhnw.cpib.dgu.parser.concsyn.IConcSyn.IRepTerm2;

public final class RepTerm2Eps implements IRepTerm2 {

	@Override
	public ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr toAbstrSyntax(
	        final IAbstSyn.IExpr relExpr,
	        final IAbstSyn.IExpr boolExpr,
	        final int direction) {
	    
	    if (boolExpr != null) {
	        return boolExpr;
	    } else {
	        return relExpr;
	    }
	}

	@Override
	public String toString(final String indent) {
		return indent + "<RepTerm2Eps/>\n";
	}
}
