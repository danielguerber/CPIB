package scanner;

import scanner.states.StartState;
import token.ITokenList;
import token.TokenList;
import token.classes.Base;
import token.enums.Terminals;

public class Scanner {
	
	private StringBuffer lexAccu=null;
	private long numAccu=0L;
	private IState currentState;
	private ITokenList tokens= new TokenList();
	
	public StringBuffer getLexAccu() {
		return lexAccu;
	}

	public void setLexAccu(StringBuffer lexAccu) {
		this.lexAccu = lexAccu;
	}

	public long getNumAccu() {
		return numAccu;
	}

	public void setNumAccu(long numAccu) {
		this.numAccu = numAccu;
	}
	
	public IState getState() {
		return currentState;
	}
	
	public void setState(IState state) {
		currentState = state;
	}
	
	public ITokenList getTokens() {
		return tokens;
	}
	
	public void addToken(Base token) {
		tokens.add(token);
	}
	
	
	

	public static ITokenList scan(CharSequence cs) throws LexicalError {
		assert cs.length() == 0 || cs.charAt(cs.length() - 1) == '\n';
		Scanner scanner = new Scanner();
		scanner.setState(new StartState());
		int i= 0;
		while (i < cs.length()) {
		    char c= cs.charAt(i);
			if (isLetter(c)) {
				i+=scanner.getState().handeLetter(c, scanner);
			} else if (Character.isDigit(c)) {
				i+=scanner.getState().handleDigit(c, scanner);
			} else if (LexemeDictionary.getDictionary().containsKey(Character.toString(c)) || c == '/') {
				i+=scanner.getState().handleSymbol(c, scanner);
			} else if (Character.isWhitespace(c)) {
				i+=scanner.getState().handleWhitespace(scanner);
			} else {
				throw new LexicalError("Illegar character: " + c);
			}
					
		} 
		assert scanner.getState() instanceof StartState;
		scanner.addToken(new token.classes.Base(Terminals.SENTINEL));
		return scanner.getTokens();
	}
	
	private static boolean isLetter(Character c) {
		return ('A' <= c &&  c <= 'Z') || ('a' <= c &&  c <= 'z');
	}
	
}
