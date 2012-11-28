package scanner;

import scanner.states.StartState;
import token.ITokenList;
import token.TokenList;
import token.classes.Base;
import token.enums.Terminals;

public final class Scanner {
	
	private StringBuffer lexAccu = null;
	private long numAccu = 0L;
	private IState currentState;
	private final ITokenList tokens = new TokenList();
	private int line = 1;
	
	public StringBuffer getLexAccu() {
		return lexAccu;
	}

	public void setLexAccu(final StringBuffer lexAccu) {
		this.lexAccu = lexAccu;
	}

	public long getNumAccu() {
		return numAccu;
	}

	public void setNumAccu(final long numAccu) {
		this.numAccu = numAccu;
	}
	
	public IState getState() {
		return currentState;
	}
	
	public void setState(final IState state) {
		currentState = state;
	}
	
	public ITokenList getTokens() {
		return tokens;
	}
	
	public void addToken(final Base token) {
		tokens.add(token);
	}
	
	public int getLine() {
		return line;
	}
	
	private void nextLine() {
		line++;
	}
	
	public static ITokenList scan(final CharSequence cs) throws LexicalError {
		assert cs.length() == 0 || cs.charAt(cs.length() - 1) == '\n';
		final Scanner scanner = new Scanner();
		scanner.setState(new StartState());
		int i = 0;
		while (i < cs.length()) {
		    final char c = cs.charAt(i);
			if (isLetter(c)) {
				i += scanner.getState().handeLetter(c, scanner);
			} else if (Character.isDigit(c)) {
				i += scanner.getState().handleDigit(c, scanner);
			} else if (LexemeDictionary.getDictionary().containsKey(
			            Character.toString(c)) 
			        || c == '/') {
				i += scanner.getState().handleSymbol(c, scanner);
			} else if (Character.isWhitespace(c)) {
				if (c == '\n') {
					scanner.nextLine();
				}
				i += scanner.getState().handleWhitespace(scanner);
			} else {
				throw new LexicalError(
				        "Illegar character: " + c,
				        scanner.getLine());
			}
					
		} 
		assert scanner.getState() instanceof StartState;
		scanner.addToken(new token.classes.Base(Terminals.SENTINEL));
		return scanner.getTokens();
	}
	
	private static boolean isLetter(final Character c) {
		return ('A' <= c &&  c <= 'Z') || ('a' <= c &&  c <= 'z');
	}
	
}
