/*
 * BaseDaoHibernate.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sageconsulting.dao.Dao;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * This class serves as the Base class for all other Daos - namely to hold
 * common methods that they might all use. Can be used for standard CRUD
 * operations.
 * </p>
 * 
 */
public class BaseDaoHibernate extends HibernateDaoSupport implements Dao
{
    protected final Log log = LogFactory.getLog(getClass());

    /**
     * @see com.sageconsulting.dao.Dao#saveObject(java.lang.Object)
     */
    public void saveObject(Object o)
    {
        getHibernateTemplate().saveOrUpdate(o);
    }

    /**
     * @see com.sageconsulting.dao.Dao#getObject(java.lang.Class,
     *      java.io.Serializable)
     */
    @SuppressWarnings("unchecked")
    public Object getObject(Class clazz, Serializable id)
    {
        Object o = getHibernateTemplate().get(clazz, id);

        if (o == null)
        {
            throw new ObjectRetrievalFailureException(clazz, id);
        }

        return o;
    }

    /**
     * @see com.sageconsulting.dao.Dao#getObjects(java.lang.Class)
     */
    @SuppressWarnings("unchecked")
    public List<Object> getObjects(Class clazz)
    {
        return getHibernateTemplate().loadAll(clazz);
    }

    /**
     * @see com.sageconsulting.dao.Dao#removeObject(java.lang.Class,
     *      java.io.Serializable)
     */
    @SuppressWarnings("unchecked")
    public void removeObject(Class clazz, Serializable id)
    {
        getHibernateTemplate().delete(getObject(clazz, id));
    }
}
