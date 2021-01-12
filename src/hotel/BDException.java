package hotel;

public class BDException extends Exception {
	private static final long serialVersionUID = 1L;

	public BDException(String message) {
		super(message);
	}
	
	public BDException(String message, Throwable e) {
		super(message, e);
	}
}
