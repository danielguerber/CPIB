package scanner.states;

import scanner.IState;
import scanner.LexemeDictionary;
import scanner.LexicalError;
import scanner.Scanner;
import token.classes.Base;

public final class SymbolState implements IState {

	@Override
	public int handeLetter(final char c, final Scanner context)
	        throws LexicalError {
		return handleChar(c, context);
	}

	@Override
	public int handleDigit(final char c, final Scanner context)
	        throws LexicalError {
		return handleChar(c, context);
	}

	@Override
	public int handleSymbol(final char c, final Scanner context)
	        throws LexicalError {
		return handleChar(c, context);
	}

	@Override
	public int handleWhitespace(final Scanner context) throws LexicalError {
		return handleChar(' ', context);
	}

	private int handleChar(final char c, final Scanner context)
	        throws LexicalError {
		if (LexemeDictionary.getDictionary().containsKey(
		        context.getLexAccu().toString() + c)) {
			final Base token = (Base) LexemeDictionary.getDictionary().get(
			        context.getLexAccu().toString() + c).clone();
			token.setLine(context.getLine());
			context.addToken(token);
			context.setState(new StartState());
			return 1;
		} else if (LexemeDictionary.getDictionary().containsKey(
		        context.getLexAccu().toString())) {
			final Base token = (Base) LexemeDictionary.getDictionary().get(
			        context.getLexAccu().toString()).clone();
			token.setLine(context.getLine());
			context.addToken(token);
			context.setState(new StartState());
			return 0;
		} else {
			throw new LexicalError("Invalid Symbol: "
			        + context.getLexAccu().toString(), context.getLine());
		}
	}
}
