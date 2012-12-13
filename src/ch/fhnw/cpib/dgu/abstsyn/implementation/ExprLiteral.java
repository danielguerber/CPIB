package ch.fhnw.cpib.dgu.abstsyn.implementation;

import ch.fhnw.cpib.dgu.abstsyn.IAbstSyn.IExpr;
import ch.fhnw.cpib.dgu.token.classes.Literal;
import ch.fhnw.cpib.dgu.token.enums.Types;

public final class ExprLiteral implements IExpr {
private final Literal literal;
	
	public ExprLiteral(final Literal literal) {
		this.literal = literal;
	}
	
	@Override
	public String toString(final String indent) {
		return indent
				+ "<ExprLiteral>\n"
				+ literal.toString(indent + '\t')
				+ indent
				+ "</ExprLiteral>\n";
	}
	
	@Override
    public int getLine() {
        return literal.getLine();
    }

    @Override
    public Types check() throws ContextError {
        return literal.getType();
    }
    
    @Override
    public Types checkAssign() throws ContextError {
        throw new ContextError(
                "Found literal " 
                + literal.getLiteral() 
                + "in the left part of an assignement",
                literal.getLine());
    }
}
