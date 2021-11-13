package fr.formation.Gardens.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fr.formation.Gardens.services.UserService;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
	
	private UserService service;

	public UniqueUsernameValidator(UserService service) { this.service = service; }

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		if (null == username || username.isEmpty())
            return true;
        boolean valid = true;
        if (service.existsByUserName(username))
            valid = false;
        return valid;
    
	}

}
