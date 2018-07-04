/*
 * BaseObject.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.model;


/**
 * Base class for Model objects. Child objects should implement toString(),
 * equals() and hashCode();
 */
public abstract class BaseObject
{
    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();
}
