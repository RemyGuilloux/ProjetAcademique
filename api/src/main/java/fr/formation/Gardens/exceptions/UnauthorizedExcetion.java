package fr.formation.Gardens.exceptions;

public class UnauthorizedExcetion extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4747869840511704372L;

	public UnauthorizedExcetion() {

	}

	public UnauthorizedExcetion(String message) {
		super(message);
	}
}
