/*
 * Dao.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Data Access Object (Dao) interface. This is an interface used to tag our Dao
 * classes and to provide common methods to all Daos.
 */
public interface Dao
{

    /**
     * Generic method used to get all objects of a particular type. This is the
     * same as lookup up all rows in a table.
     * 
     * @param clazz
     *            the type of objects (a.k.a. while table) to get data from
     * @return List of populated objects
     */
    @SuppressWarnings("unchecked")
    public List<Object> getObjects(Class clazz);

    /**
     * Generic method to get an object based on class and identifier. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if nothing is
     * found.
     * 
     * @param clazz
     *            model class to lookup
     * @param id
     *            the identifier (primary key) of the class
     * @return a populated object
     * @see org.springframework.orm.ObjectRetrievalFailureException
     */
    @SuppressWarnings("unchecked")
    public Object getObject(Class clazz, Serializable id);

    /**
     * Generic method to save an object - handles both update and insert.
     * 
     * @param o
     *            the object to save
     */
    public void saveObject(Object o);

    /**
     * Generic method to delete an object based on class and id
     * 
     * @param clazz
     *            model class to lookup
     * @param id
     *            the identifier (primary key) of the class
     */
    @SuppressWarnings("unchecked")
    public void removeObject(Class clazz, Serializable id);
}
