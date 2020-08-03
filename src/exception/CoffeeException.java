package exception;

public class CoffeeException extends Exception {

	private static final long serialVersionUID = -6753620307448534265L;

	public CoffeeException() {
		super();
	}

	public CoffeeException(String message, Throwable cause, boolean enableSupression, boolean writableStackTrace) {
		super(message, cause, enableSupression, writableStackTrace);
	}

	public CoffeeException(String message, Throwable cause) {
		super(message, cause);
	}

	public CoffeeException(String message) {
		super(message);
	}

	public CoffeeException(Throwable cause) {
		super(cause);
	}
}
