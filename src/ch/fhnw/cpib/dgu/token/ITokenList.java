package ch.fhnw.cpib.dgu.token;

public interface ITokenList {
	// for constructing the token list by the scanner
	void add(ch.fhnw.cpib.dgu.token.classes.Base token);
	// for reading the token list by the parser (1)
	void reset();
	// for reading the token list by the parser (2)
	ch.fhnw.cpib.dgu.token.classes.Base nextToken();
	// for displaying the token list
	@Override
    String toString();
}
