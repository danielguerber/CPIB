package ch.fhnw.cpib.dgu.token.classes;

import ch.fhnw.cpib.dgu.token.enums.Operators;
import ch.fhnw.cpib.dgu.token.enums.Terminals;

public abstract class Operator extends Base {
	private final Operators operator;
	
	private Operator(final Terminals terminal, final Operators operator) {
		super(terminal);
		this.operator = operator;
	}
	
	private Operator(final Operator operator) {
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
	
	public static final class RelOpr extends Operator {
		public RelOpr(final Operators operator) {
			super(Terminals.RELOPR, operator);
		}
		
		private RelOpr(final Operator operator) {
			super(operator);
		}
		
		@Override
        public Object clone() {
			return new RelOpr(this);
		}
	}
	
	public static final class AddOpr extends Operator {
		public AddOpr(final Operators operator) {
			super(Terminals.ADDOPR, operator);
		}
		
		private AddOpr(final Operator operator) {
			super(operator);
		}
		
		@Override
        public Object clone() {
			return new AddOpr(this);
		}
	}
	
	public static final class MultOpr extends Operator {
		public MultOpr(final Operators operator) {
			super(Terminals.MULTOPR, operator);
		}
		
		private MultOpr(final Operator operator) {
			super(operator);
		}
		
		@Override
        public Object clone() {
			return new MultOpr(this);
		}
	}
	
	public static final class BoolOpr extends Operator {
		public BoolOpr(final Operators operator) {
			super(Terminals.BOOLOPR, operator);
		}
		
		private BoolOpr(final Operator operator) {
			super(operator);
		}
		
		@Override
        public Object clone() {
			return new BoolOpr(this);
		}
	}

	public String toString(final String indent) {
		return indent
				+ "<Operator operator=\""
				+ this.operator.toString()
				+ "\" line=\""
				+ super.getLine()
				+ "\"/>\n";
	}
}
