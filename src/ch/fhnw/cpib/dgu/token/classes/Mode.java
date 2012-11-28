package ch.fhnw.cpib.dgu.token.classes;

import ch.fhnw.cpib.dgu.token.enums.Modes;
import ch.fhnw.cpib.dgu.token.enums.Terminals;

public abstract class Mode extends Base {
	private final Modes mode;
	
	private Mode(final Terminals terminal, final Modes mode) {
		super(terminal);
		this.mode = mode;
	}
	
	private Mode(final Mode mode) {
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
	
	public static final class ChangeMode extends Mode {
		public ChangeMode(final Modes mode) {
			super(Terminals.CHANGEMODE, mode);
		}
		
		private ChangeMode(final Mode mode) {
			super(mode);
		}
		
		@Override
        public Object clone() {
			return new ChangeMode(this);
		}

		public Object toString(final String indent) {
			return indent
				+ 	"<ChangeMode mode=\""
				+ 	super.getMode().toString()
				+ 	"\" line=\""
				+ 	super.getLine()
				+ 	"\"/>\n";
		}
	}
	
	public static final class MechMode extends Mode {
		public MechMode(final Modes mode) {
			super(Terminals.MECHMODE, mode);
		}
		
		private MechMode(final Mode mode) {
			super(mode);
		}
		
		@Override
        public Object clone() {
			return new MechMode(this);
		}

		public String toString(final String indent) {
			return indent
				+ 	"<MechMode mode=\""
				+ 	super.getMode().toString()
				+ 	"\" line=\""
				+ 	super.getLine()
				+ 	"\"/>\n";
		}
	}
	
	public static final class FlowMode extends Mode {
		public FlowMode(final Modes mode) {
			super(Terminals.FLOWMODE, mode);
		}
		
		private FlowMode(final Mode mode) {
			super(mode);
		}
		
		@Override
        public Object clone() {
			return new FlowMode(this);
		}

		public String toString(final String indent) {
			return indent
				+ 	"<FlowMode mode=\""
				+ 	super.getMode().toString()
				+ 	"\" line=\""
				+ 	super.getLine()
				+ 	"\"/>\n";
		}
	}
}