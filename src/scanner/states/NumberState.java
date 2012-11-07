package scanner.states;

import scanner.IState;
import scanner.LexicalError;
import scanner.Scanner;
import token.classes.Literal;
import token.enums.Types;

public class NumberState implements IState {

	@Override
	public int handeLetter(char c, Scanner context) throws LexicalError {
		return addLiteral(context);
	}

	@Override
	public int handleDigit(char c, Scanner context) throws LexicalError {
		context.setNumAccu(context.getNumAccu()*10 + Character.digit(c,10));
		if (context.getNumAccu() > Integer.MAX_VALUE) {
			throw new LexicalError
			("Integer literal too large!", context.getLine());
		} 
		return 1;
	}
	
	private int addLiteral(Scanner context) {
		context.addToken(new Literal((int) context.getNumAccu(),Types.INT32, context.getLine()));
		context.setState(new StartState());
		return 0;
	}

	@Override
	public int handleSymbol(char c, Scanner context) throws LexicalError {
		return addLiteral(context);
	}

	@Override
	public int handleWhitespace(Scanner context) throws LexicalError {
		return addLiteral(context);
	}

}
