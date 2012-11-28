package scanner.states;

import scanner.IState;
import scanner.LexemeDictionary;
import scanner.LexicalError;
import scanner.Scanner;
import token.classes.Base;
import token.classes.Ident;

public final class LetterState implements IState {

	@Override
	public int handeLetter(final char c, final Scanner context) 
	        throws LexicalError {
		return addChar(c, context);
	}

	@Override
	public int handleDigit(final char c, final Scanner context) 
	        throws LexicalError {
		return addChar(c, context);
	}

	private int addChar(final char c, final Scanner context) {
		context.getLexAccu().append(c);
		return 1;
	}
	
	@Override
	public int handleSymbol(final char c, final Scanner context) 
	        throws LexicalError {
		return addToken(context);
	}

	@Override
	public int handleWhitespace(final Scanner context) throws LexicalError {
		return addToken(context);
	}
	
	private int addToken(final Scanner context) {
		if (LexemeDictionary.getDictionary().containsKey(
		        context.getLexAccu().toString())) {
			final Base token = (Base) LexemeDictionary.getDictionary().get(
			        context.getLexAccu().toString()).clone();
			token.setLine(context.getLine());
			context.addToken(token);
		} else {
			context.addToken(
			        new Ident(context.getLexAccu(),
			                context.getLine()));
		}
		context.setState(new StartState());
		return 0;
	}

}
