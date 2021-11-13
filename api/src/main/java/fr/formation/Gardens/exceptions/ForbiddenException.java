package fr.formation.Gardens.exceptions;

public class ForbiddenException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1546961453688561703L;

	public ForbiddenException() {

	}

	public ForbiddenException(String message) {
		super(message);
	}

}
