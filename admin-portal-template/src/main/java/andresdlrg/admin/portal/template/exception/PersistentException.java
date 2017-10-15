package andresdlrg.admin.portal.template.exception;

public class PersistentException extends Exception {

	private static final long serialVersionUID = -1724811772735891656L;

	public PersistentException() {
	}

	public PersistentException(String message) {
		super(message);
	}

	public PersistentException(Throwable cause) {
		super(cause);
	}

	public PersistentException(String message, Throwable cause) {
		super(message, cause);
	}

	public PersistentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
