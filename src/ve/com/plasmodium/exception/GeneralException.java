package ve.com.plasmodium.exception;

import org.apache.log4j.Logger;

public class GeneralException extends RuntimeException {

    public static final Logger logger = Logger.getLogger(GeneralException.class);

	/**
	 * The Enum TipoExcepcion.
	 */

	TypeException typeException = TypeException.ERROR;

	public TypeException getTypeException() {
		return typeException;
	}

	public void setTypeException(TypeException typeException) {
		this.typeException = typeException;
	}

	public enum TypeException {
		WARNING, ERROR, INFO
	}

	private static final long serialVersionUID = 5087313500222644883L;

	public GeneralException() {
		super();
	}

	public GeneralException(String message, Throwable cause) {
		super(message, cause);
	}

	public GeneralException(String message) {
		super(message);
	}

	public GeneralException(Throwable cause) {
		super(cause);
	}

	public GeneralException(TypeException typeException) {
		super();
		this.typeException = typeException;
	}

	public GeneralException(TypeException typeException, String message,
			Throwable cause) {
		super(message, cause);
		this.typeException = typeException;
	}

	public GeneralException(TypeException typeException, String message) {
		super(message);
		this.typeException = typeException;
	}

	public GeneralException(TypeException typeException, Throwable cause) {
		super(cause);
		this.typeException = typeException;
	}

}
