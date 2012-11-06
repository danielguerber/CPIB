package scanner.states;

import scanner.IState;
import scanner.LexicalError;
import scanner.Scanner;

public class StartState implements IState {

	@Override
	public int handeLetter(char c, Scanner context) throws LexicalError {
		context.setLexAccu(new StringBuffer());
		context.setState(new LetterState());
		return 0;
	}

	@Override
	public int handleDigit(char c, Scanner context) throws LexicalError {
		context.setState(new NumberState());
		return 0;
	}

	@Override
	public int handleSymbol(char c, Scanner context) throws LexicalError {
		context.setLexAccu(new StringBuffer());
		context.getLexAccu().append(c);
		context.setState(new SymbolState());
		return 1;
	}

	@Override
	public int handleWhitespace(Scanner context) throws LexicalError {
		return 1;
	}


}
