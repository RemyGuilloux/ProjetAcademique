package fr.formation.Gardens.exceptions;

@SuppressWarnings("serial")
public class BadRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4789119302358949800L;

	public BadRequestException() {

	}

	public BadRequestException(String message) {
		super(message);
	}

}
