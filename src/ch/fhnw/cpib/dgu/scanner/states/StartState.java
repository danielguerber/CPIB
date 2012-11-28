package ch.fhnw.cpib.dgu.scanner.states;

import ch.fhnw.cpib.dgu.scanner.IState;
import ch.fhnw.cpib.dgu.scanner.LexicalError;
import ch.fhnw.cpib.dgu.scanner.Scanner;

public final class StartState implements IState {

	@Override
	public int handeLetter(final char c, final Scanner context)
	        throws LexicalError {
		context.setLexAccu(new StringBuffer());
		context.setState(new LetterState());
		return 0;
	}

	@Override
	public int handleDigit(final char c, final Scanner context)
	        throws LexicalError {
		context.setState(new NumberState());
		return 0;
	}

	@Override
	public int handleSymbol(final char c, final Scanner context)
	        throws LexicalError {
		context.setLexAccu(new StringBuffer());
		context.getLexAccu().append(c);
		context.setState(new SymbolState());
		return 1;
	}

	@Override
	public int handleWhitespace(final Scanner context) throws LexicalError {
		return 1;
	}


}
