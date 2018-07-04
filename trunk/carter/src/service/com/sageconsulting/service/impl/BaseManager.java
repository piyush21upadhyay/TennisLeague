/*
 * BaseManager.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sageconsulting.dao.Dao;
import com.sageconsulting.service.Manager;

/**
 * Base class for Business Services - use this class for utility methods and
 * generic CRUD methods.
 */
public class BaseManager implements Manager
{
    protected final Log log = LogFactory.getLog(getClass());

    protected Dao dao = null;

    /**
     * @see com.sageconsulting.service.Manager#setDao(com.sageconsulting.dao.Dao)
     */
    public void setDao(Dao daoObject)
    {
        this.dao = daoObject;
    }

    /**
     * @see com.sageconsulting.service.Manager#getObject(java.lang.Class,
     *      java.io.Serializable)
     */
    @SuppressWarnings("unchecked")
    public Object getObject(Class clazz, Serializable id)
    {
        return this.dao.getObject(clazz, id);
    }

    /**
     * @see com.sageconsulting.service.Manager#getObjects(java.lang.Class)
     */
    @SuppressWarnings("unchecked")
    public List<Object> getObjects(Class clazz)
    {
        return this.dao.getObjects(clazz);
    }

    /**
     * @see com.sageconsulting.service.Manager#removeObject(java.lang.Class,
     *      java.io.Serializable)
     */
    @SuppressWarnings("unchecked")
    public void removeObject(Class clazz, Serializable id)
    {
        this.dao.removeObject(clazz, id);
    }

    /**
     * @see com.sageconsulting.service.Manager#saveObject(java.lang.Object)
     */
    public void saveObject(Object o)
    {
        this.dao.saveObject(o);
    }
}
