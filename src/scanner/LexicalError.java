package scanner;

@SuppressWarnings("serial")
public class LexicalError extends Throwable {
	public LexicalError(final String message, final int line) {
		super(message + "\n\tat line:" + line);
	}
}
