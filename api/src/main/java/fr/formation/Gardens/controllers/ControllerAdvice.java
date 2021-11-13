package fr.formation.Gardens.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import fr.formation.Gardens.errors.ApiErrors;
import fr.formation.Gardens.errors.ValidationError;
import fr.formation.Gardens.exceptions.BadRequestException;
import fr.formation.Gardens.exceptions.ForbiddenException;
import fr.formation.Gardens.exceptions.InternalServerErrorException;
import fr.formation.Gardens.exceptions.ResourceNotFoundException;
import fr.formation.Gardens.exceptions.UnauthorizedExcetion;

/**
 * A controller advice to handle API exceptions in one place and override
 * default behavior.
 */
@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

	private final static Logger LOGGER = LoggerFactory.getLogger(ControllerAdvice.class);

	protected ControllerAdvice() {
		// TODO Auto-generated constructor stub
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	protected ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, HttpHeaders headers,
			WebRequest request) {
		LOGGER.debug("Ressource not found, Error 404... " + ex.getMessage());
		HttpStatus status = HttpStatus.NOT_FOUND;
		return super.handleExceptionInternal(ex, null, headers, status, request);
	}

	@ExceptionHandler(UnauthorizedExcetion.class)
	protected ResponseEntity<Object> handleUnauthorizedException(UnauthorizedExcetion ex, HttpHeaders headers,
			WebRequest request) {
		LOGGER.debug("Unauthorized, Error 401... " + ex.getMessage());
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		return super.handleExceptionInternal(ex, null, headers, status, request);
	}

	@ExceptionHandler(BadRequestException.class)
	protected ResponseEntity<Object> handleBadRequestException(BadRequestException ex, HttpHeaders headers,
			WebRequest request) {
		LOGGER.debug("Bad request, Error 400... " + ex.getMessage());
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return super.handleExceptionInternal(ex, null, headers, status, request);
	}

	@ExceptionHandler(InternalServerErrorException.class)
	protected ResponseEntity<Object> handleInternalServerErrorException(InternalServerErrorException ex,
			HttpHeaders headers, WebRequest request) {
		LOGGER.debug("Internal Server Error, Error 500... " + ex.getMessage());
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		return super.handleExceptionInternal(ex, null, headers, status, request);
	}

	@ExceptionHandler(ForbiddenException.class)
	protected ResponseEntity<Object> handleInternalForbiddenException(ForbiddenException ex, HttpHeaders headers,
			WebRequest request) {
		LOGGER.debug("Forbidden,Error 403... " + ex.getMessage());
		HttpStatus status = HttpStatus.FORBIDDEN;
		return super.handleExceptionInternal(ex, null, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		BindingResult result = ex.getBindingResult();
		// Convert each FieldError to ValidationError
		List<FieldError> fieldErrors = result.getFieldErrors();
		List<ValidationError> errors = fieldErrors.stream()
				.map(e -> ValidationError.ofFieldType(e.getObjectName(), e.getField(), e.getDefaultMessage()))
				.collect(Collectors.toList());
		// Convert each ObjectError to ValidationError
		List<ObjectError> globalErrors = result.getGlobalErrors();
		globalErrors.stream()
				.map(e -> ValidationError.ofGlobalType(e.getObjectName(), e.getCode(), e.getDefaultMessage()))
				.forEach(errors::add);
		// Encapsulate ValidationError into ApiErrors
		ApiErrors<ValidationError> apiErrors = new ApiErrors<>(errors, status.value(), getMethod(), getRequestURI());
		return new ResponseEntity<>(apiErrors, status);
	}

	private static String getRequestURI() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attr.getRequest().getRequestURI();
	}

	private static String getMethod() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attr.getRequest().getMethod();
	}

}
