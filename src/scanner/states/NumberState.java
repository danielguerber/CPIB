package scanner.states;

import scanner.IState;
import scanner.LexicalError;
import scanner.Scanner;
import token.classes.Literal;
import token.enums.Types;

public final class NumberState implements IState {
    private static final int NUMBER_BASE = 10;
    
	@Override
	public int handeLetter(final char c, 
	        final Scanner context) throws LexicalError {
		return addLiteral(context);
	}

	@Override
	public int handleDigit(final char c, 
	        final Scanner context) throws LexicalError {
		context.setNumAccu(context.getNumAccu()
		        * NUMBER_BASE
		        + Character.digit(c, NUMBER_BASE));
		if (context.getNumAccu() > Integer.MAX_VALUE) {
			throw new LexicalError(
					"Integer literal too large!", context.getLine());
		} 
		return 1;
	}
	
	private int addLiteral(final Scanner context) {
		context.addToken(new Literal((int) context.getNumAccu(),
		        Types.INT32, context.getLine()));
		context.setState(new StartState());
		return 0;
	}

	@Override
	public int handleSymbol(final char c, 
	        final Scanner context) throws LexicalError {
		return addLiteral(context);
	}

	@Override
	public int handleWhitespace(final Scanner context) throws LexicalError {
		return addLiteral(context);
	}

}
