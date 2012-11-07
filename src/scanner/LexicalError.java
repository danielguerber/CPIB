package scanner;

@SuppressWarnings("serial")
public class LexicalError extends Throwable {
	public LexicalError(String message, int line) {
		super(message + "\n\tat line:" + line);
	}
}
