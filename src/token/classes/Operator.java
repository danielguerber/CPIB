package token.classes;

import token.enums.Operators;
import token.enums.Terminals;

public abstract class Operator extends Base {
	private final Operators operator;
	
	public Operator(Terminals terminal, Operators operator) {
		super(terminal);
		this.operator = operator;
	}
	
	public Operators getOperator() {
		return operator;
	}

	@Override
	public String toString() {
		return "(" + super.toString() + ", " + operator.toString() + ")";
	}
	
	public static class RelOpr extends Operator {
		public RelOpr( Operators operator) {
			super(Terminals.RELOPR, operator);
		}
	}
	
	public static class AddOpr extends Operator {
		public AddOpr( Operators operator) {
			super(Terminals.ADDOPR, operator);
		}
	}
	
	public static class MultOpr extends Operator {
		public MultOpr( Operators operator) {
			super(Terminals.MULTOPR, operator);
		}
	}
	
	public static class BoolOpr extends Operator {
		public BoolOpr( Operators operator) {
			super(Terminals.BOOLOPR, operator);
		}
	}
}
