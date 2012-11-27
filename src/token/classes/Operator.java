package token.classes;

import token.enums.Operators;
import token.enums.Terminals;

public abstract class Operator extends Base {
	private final Operators operator;
	
	private Operator(Terminals terminal, Operators operator) {
		super(terminal);
		this.operator = operator;
	}
	
	private Operator(Operator operator) {
		super(operator);
		this.operator = operator.operator;
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
		
		private RelOpr(Operator operator) {
			super(operator);
		}
		
		@Override
		public Object clone() {
			return new RelOpr(this);
		}
	}
	
	public static class AddOpr extends Operator {
		public AddOpr( Operators operator) {
			super(Terminals.ADDOPR, operator);
		}
		
		private AddOpr(Operator operator) {
			super(operator);
		}
		
		@Override
		public Object clone() {
			return new AddOpr(this);
		}
	}
	
	public static class MultOpr extends Operator {
		public MultOpr( Operators operator) {
			super(Terminals.MULTOPR, operator);
		}
		
		private MultOpr(Operator operator) {
			super(operator);
		}
		
		@Override
		public Object clone() {
			return new MultOpr(this);
		}
	}
	
	public static class BoolOpr extends Operator {
		public BoolOpr( Operators operator) {
			super(Terminals.BOOLOPR, operator);
		}
		
		private BoolOpr(Operator operator) {
			super(operator);
		}
		
		@Override
		public Object clone() {
			return new BoolOpr(this);
		}
	}

	public String toString(String indent) {
		return indent +
				"<Operator operator=\"" +
				this.operator.toString() + 
				"\" line=\"" +
				super.getLine() +
				"\"/>\n";
	}
}
