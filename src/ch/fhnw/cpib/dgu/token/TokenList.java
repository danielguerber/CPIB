package ch.fhnw.cpib.dgu.token;

import java.util.ArrayList;

public final class TokenList implements ITokenList {
	private final ArrayList<ch.fhnw.cpib.dgu.token.classes.Base> tokens 
	    = new ArrayList<ch.fhnw.cpib.dgu.token.classes.Base>();
	private int currentToken = 0;
	
	
	@Override
    public void add(final ch.fhnw.cpib.dgu.token.classes.Base token) {
		tokens.add(token);
	}

	@Override
	public void reset() {
		currentToken = 0;
	}

	@Override
	public ch.fhnw.cpib.dgu.token.classes.Base nextToken() {
		if (tokens.size() > currentToken) { 
			return tokens.get(currentToken++);
		} else {
			return null;
		}
	}
	
	@Override
	public String toString() {
		final StringBuffer out = new StringBuffer("[");
		if (tokens.size() > 0) {
			for (final ch.fhnw.cpib.dgu.token.classes.Base base : tokens) {
				out.append(base.toString());
				out.append(", ");
			}
			out.delete(out.length() - 2, out.length());
		}
		out.append("]");
		return out.toString();
	}
}
