package com.smartship.mds.keyclock.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomControllerAdvice extends ResponseEntityExceptionHandler {

	/**
	 * Exception Handler for Cph Exceptions.
	 *
	 * @param ade the CphException
	 * @return the error response for CphException
	 */
	@ResponseBody
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorResponse> handleAccessDeniedException(final AccessDeniedException ade) {
		final ErrorResponse error = new ErrorResponse();
		return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
	}
}
