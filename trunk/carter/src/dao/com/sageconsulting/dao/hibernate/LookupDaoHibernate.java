/*
 * LookupDaoHibernate.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao.hibernate;

import java.util.List;

import com.sageconsulting.dao.LookupDao;
import com.sageconsulting.model.Role;

/**
 * Hibernate implementation of LookupDao.
 */
public class LookupDaoHibernate extends BaseDaoHibernate implements LookupDao
{

    /**
     * @see com.sageconsulting.dao.LookupDao#getRoles()
     */
    @SuppressWarnings("unchecked")
    public List<Role> getRoles()
    {
        this.log.debug("retrieving all role names..."); //$NON-NLS-1$

        return getHibernateTemplate().find("from Role order by name"); //$NON-NLS-1$
    }
}
