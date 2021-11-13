package fr.formation.Gardens.validator;



import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = UniqueUsernameValidator.class)
public @interface UniqueUsername {
	 String message() default "Le nom de l'utilisateur doit être unique ";

	    Class<?>[] groups() default {};

	    Class<? extends Payload>[] payload() default {};

}
