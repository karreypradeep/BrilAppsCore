/**
 * This document is a part of the source code and related artifacts.
 * www.brilapps.com
 * Copyright © 2015 brilapps
 *
 */
package com.brilapps.core.resouces;

/**
 * @author pradeep created date 27-Jan-2015
 */
public class ExceptionResourceAssembler   {

    public static ExceptionResource toResource(final Exception exception) {
	final ExceptionResource exceptionResource = new ExceptionResource();
	exceptionResource.setMessage(exception.getMessage());
	exceptionResource.setExceptiontype(exception.getClass().getName());
	return exceptionResource;
    }

}
