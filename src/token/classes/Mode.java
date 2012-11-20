package token.classes;

import token.enums.Modes;
import token.enums.Terminals;

public abstract class Mode extends Base {
	private final Modes mode;
	
	private Mode(Terminals terminal,Modes mode) {
		super(terminal);
		this.mode = mode;
	}
	
	private Mode(Mode mode) {
		super(mode);
		this.mode = mode.mode;
	}
	
	public Modes getMode() {
		return mode;
	}
	
	@Override
	public String toString() {
		return "(" + super.toString() + ", " + mode.toString() + ")";
	}
	
	public static class ChangeMode extends Mode {
		public ChangeMode(Modes mode) {
			super(Terminals.CHANGEMODE,mode);
		}
		
		private ChangeMode(Mode mode) {
			super(mode);
		}
		
		@Override
		public Object clone() {
			return new ChangeMode(this);
		}
	}
	
	public static class MechMode extends Mode {
		public MechMode(Modes mode) {
			super(Terminals.MECHMODE, mode);
		}
		
		private MechMode(Mode mode) {
			super(mode);
		}
		
		@Override
		public Object clone() {
			return new MechMode(this);
		}
	}
	
	public static class FlowMode extends Mode {
		public FlowMode(Modes mode) {
			super(Terminals.FLOWMODE, mode);
		}
		
		private FlowMode(Mode mode) {
			super(mode);
		}
		
		@Override
		public Object clone() {
			return new FlowMode(this);
		}
	}
}