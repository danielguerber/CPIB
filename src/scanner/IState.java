package scanner;

public interface IState {
	public int handeLetter(char c, Scanner context) throws LexicalError;
	public int handleDigit(char c, Scanner context) throws LexicalError;
	public int handleSymbol(char c, Scanner context) throws LexicalError;
	public int handleWhitespace(Scanner context) throws LexicalError;
}
