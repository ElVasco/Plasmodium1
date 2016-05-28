package ve.com.plasmodium.exception;
import org.apache.log4j.Logger;

public class DAOException extends Exception {

    public static final Logger logger = Logger.getLogger(DAOException.class);
	/**
	 *
	 */
	private static final long serialVersionUID = 280758703104105576L;

	public DAOException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public DAOException(String message) {
		super(message);
	}
}