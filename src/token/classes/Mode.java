package token.classes;

import token.enums.Modes;
import token.enums.Terminals;

public abstract class Mode extends Base {
	private final Modes mode;
	
	public Mode(Terminals terminal,Modes mode) {
		super(terminal);
		this.mode = mode;
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
	}
	
	public static class MechMode extends Mode {
		public MechMode(Modes mode) {
			super(Terminals.MECHMODE, mode);
		}
	}
	
	public static class FlowMode extends Mode {
		public FlowMode(Modes mode) {
			super(Terminals.FLOWMODE, mode);
		}
	}
}