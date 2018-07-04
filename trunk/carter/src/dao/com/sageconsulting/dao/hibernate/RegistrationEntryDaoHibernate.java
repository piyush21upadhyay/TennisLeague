/*
 * RegistrationEntryDaoHibernate.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao.hibernate;

import java.util.List;

import com.sageconsulting.dao.RegistrationEntryDao;
import com.sageconsulting.model.RegistrationEntry;

public class RegistrationEntryDaoHibernate extends BaseDaoHibernate implements RegistrationEntryDao
{

    public RegistrationEntry getRegistrationEntry(Long id)
    {
        return (RegistrationEntry)getHibernateTemplate().get(RegistrationEntry.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<RegistrationEntry> getRegistrationEntries()
    {
        return getHibernateTemplate().find("from RegistrationEntry"); //$NON-NLS-1$
    }
    
    @SuppressWarnings("unchecked")
    public List<RegistrationEntry> getRegistrationEntriesForUser(Long userId)
    {
        return getHibernateTemplate().find("from RegistrationEntry r where r.user.id=?", userId); //$NON-NLS-1$
    }
    
    @SuppressWarnings("unchecked")
    public List<RegistrationEntry> getRegistrationEntriesForRegistration(Long registrationId)
    {
        return getHibernateTemplate().find("from RegistrationEntry r where r.registration.id=?", registrationId); //$NON-NLS-1$
    }

    public void saveRegistrationEntry(RegistrationEntry entry)
    {
        getHibernateTemplate().saveOrUpdate(entry);
        // flush() is necessary to generate DataIntegrityException
        getHibernateTemplate().flush();
    }

    public void removeRegistrationEntry(Long id)
    {
        getHibernateTemplate().delete(getRegistrationEntry(id));
    }
}
