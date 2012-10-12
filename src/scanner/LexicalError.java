package scanner;

@SuppressWarnings("serial")
public class LexicalError extends Throwable {
	public LexicalError(String message) {
		super(message);
	}
}
