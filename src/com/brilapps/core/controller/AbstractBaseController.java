package com.brilapps.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.brilapps.core.exceptions.ApplicationException;
import com.brilapps.core.exceptions.BusinessException;
import com.brilapps.core.resouces.ExceptionResource;
import com.brilapps.core.resouces.ExceptionResourceAssembler;

public abstract class AbstractBaseController {

    @ExceptionHandler(AccessDeniedException.class)
    ResponseEntity<ExceptionResource> handleAccessDeniedException(final Exception e) {
	final ExceptionResource exceptionResource = ExceptionResourceAssembler.toResource(e);
	return new ResponseEntity<ExceptionResource>(exceptionResource, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ApplicationException.class)
    ResponseEntity<ExceptionResource> handleApplicationException(
	    final ApplicationException e) {
	final ExceptionResource exceptionResource = ExceptionResourceAssembler.toResource(e);
	return new ResponseEntity<ExceptionResource>(exceptionResource, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessException.class)
    ResponseEntity<ExceptionResource> handleBusinessException(final BusinessException e) {
	final ExceptionResource exceptionResource = ExceptionResourceAssembler.toResource(e);
	return new ResponseEntity<ExceptionResource>(exceptionResource, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<ExceptionResource> handleRuntimeException(final RuntimeException e) {
	final ExceptionResource exceptionResource = ExceptionResourceAssembler.toResource(e);
	return new ResponseEntity<ExceptionResource>(exceptionResource, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<ExceptionResource> handleUnHandledException(final Exception e) {
	final ExceptionResource exceptionResource = ExceptionResourceAssembler.toResource(e);
	return new ResponseEntity<ExceptionResource>(exceptionResource, HttpStatus.BAD_REQUEST);
    }

}
