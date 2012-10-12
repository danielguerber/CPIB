package token;

public interface ITokenList {
	// for constructing the token list by the scanner
	void add(token.classes.Base token);
	// for reading the token list by the parser (1)
	void reset();
	// for reading the token list by the parser (2)
	token.classes.Base nextToken();
	// for displaying the token list
	String toString();
}
