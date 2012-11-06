package scanner.states;

import scanner.IState;
import scanner.LexemeDictionary;
import scanner.LexicalError;
import scanner.Scanner;

public class SymbolState implements IState {

	@Override
	public int handeLetter(char c, Scanner context) throws LexicalError {
		return handleChar(c, context);
	}

	@Override
	public int handleDigit(char c, Scanner context) throws LexicalError {
		return handleChar(c, context);
	}

	@Override
	public int handleSymbol(char c, Scanner context) throws LexicalError {
		return handleChar(c, context);
	}

	@Override
	public int handleWhitespace(Scanner context) throws LexicalError {
		return handleChar(' ', context);
	}

	private int handleChar(char c, Scanner context) throws LexicalError {
		if (LexemeDictionary.getDictionary().containsKey(context.getLexAccu().toString() + c)) {
			context.addToken(LexemeDictionary.getDictionary().get(context.getLexAccu().toString() + c));
			context.setState(new StartState());
			return 1;
		} else if (LexemeDictionary.getDictionary().containsKey(context.getLexAccu().toString())) {
			context.addToken(LexemeDictionary.getDictionary().get(context.getLexAccu().toString()));
			context.setState(new StartState());
			return 0;
		} else {
			throw new LexicalError("Invalid Symbol: " + context.getLexAccu().toString());
		}
	}
}
