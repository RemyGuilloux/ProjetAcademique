package fr.formation.Gardens.exceptions;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException() {
		
	    }

	    public ResourceNotFoundException(String message) {
		super(message);
	    }

}
