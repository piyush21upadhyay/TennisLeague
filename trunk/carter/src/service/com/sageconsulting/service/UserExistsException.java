/*
 * UserExistsException.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service;

/**
 * An exception that is thrown by classes wanting to trap unique constraint
 * violations. This is used to wrap Spring's DataIntegrityViolationException so
 * it's checked in the web layer.
 */
public class UserExistsException extends Exception
{
    private static final long serialVersionUID = 4050482305178810162L;

    /**
     * Constructor for UserExistsException.
     * 
     * @param message
     */
    public UserExistsException(String message)
    {
        super(message);
    }
}
