package fr.formation.Gardens.exceptions;

public class InternalServerErrorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8550270015233397996L;

	public InternalServerErrorException() {

	}

	public InternalServerErrorException(String message) {
		super(message);
	}

}
