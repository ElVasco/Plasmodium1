package ve.com.plasmodium.exception;

import org.apache.log4j.Logger;

public class CustomException extends Exception {

    public static final Logger logger = Logger.getLogger(CustomException.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = -8987356163830154027L;

	/**
	 *
	 */
	public CustomException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public CustomException(String message) {
		super(message);
	}
}