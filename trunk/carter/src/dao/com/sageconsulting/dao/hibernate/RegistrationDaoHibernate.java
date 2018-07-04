/*
 * RegistrationDaoHibernate.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao.hibernate;

import java.util.Date;
import java.util.List;

import com.sageconsulting.dao.RegistrationDao;
import com.sageconsulting.model.Registration;

public class RegistrationDaoHibernate extends BaseDaoHibernate implements RegistrationDao
{

    public Registration getRegistration(Long id)
    {
        return (Registration)getHibernateTemplate().get(Registration.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<Registration> getRegistrations()
    {
        return getHibernateTemplate().find("from Registration r order by r.registrationEnd"); //$NON-NLS-1$
    }
    
    @SuppressWarnings("unchecked")
    public List<Registration> getOpenRegistrations()
    {
        Date d = new Date();
        return getHibernateTemplate().find("from Registration r where r.registrationEnd >= ? order by r.registrationEnd", d); //$NON-NLS-1$
    }
    
    @SuppressWarnings("unchecked")
    public List<Registration> getOpenRegistrationsForCity(Long cityId)
    {
        Date d = new Date();
        return getHibernateTemplate().find("from Registration r where r.registrationEnd >= ? and r.city.id = ? order by r.registrationEnd", //$NON-NLS-1$
        		new Object[] { d, cityId });
    }
    
    @SuppressWarnings("unchecked")
    public List<Registration> getClosedRegistrations()
    {
        Date d = new Date();
        return getHibernateTemplate().find("from Registration r where r.registrationEnd < ? order by r.registrationEnd", d); //$NON-NLS-1$
    }

    public void saveRegistration(Registration registration)
    {
        getHibernateTemplate().saveOrUpdate(registration);
        // flush() is necessary to generate DataIntegrityException
        getHibernateTemplate().flush();
    }

    public void removeRegistration(Long id)
    {
        getHibernateTemplate().delete(getRegistration(id));
    }
}
