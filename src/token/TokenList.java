package token;

import java.util.ArrayList;

public class TokenList implements ITokenList {
	private ArrayList<token.classes.Base> tokens = new ArrayList<token.classes.Base>();
	private int currentToken=0;
	
	
	@Override
	public void add(token.classes.Base token) {
		tokens.add(token);
	}

	@Override
	public void reset() {
		currentToken=0;
	}

	@Override
	public token.classes.Base nextToken() {
		if (tokens.size() > currentToken) 
			return tokens.get(currentToken);
		else
			return null;
	}

	@Override
	public String toString() {
		StringBuffer out = new StringBuffer("[");
		if (tokens.size() > 0) {
			for (token.classes.Base base : tokens) {
				out.append(base.toString());
				out.append(", ");
			}
			out.delete(out.length()-2, out.length());
		}
		out.append("]");
		return out.toString();
	}
}
