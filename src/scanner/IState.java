package scanner;

public interface IState {
	int handeLetter(char c, Scanner context) throws LexicalError;
	int handleDigit(char c, Scanner context) throws LexicalError;
	int handleSymbol(char c, Scanner context) throws LexicalError;
	int handleWhitespace(Scanner context) throws LexicalError;
}
