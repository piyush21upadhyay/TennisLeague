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
import java.util.Iterator;
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
        //return getHibernateTemplate().find("from Registration r where r.registrationEnd >= ? order by r.registrationEnd", d); //$NON-NLS-1$
        return fetchFinalValidList(getHibernateTemplate().find("from Registration r order by r.registrationEnd"), false, true, false);
    }
    
    @SuppressWarnings("unchecked")
    public List<Registration> getOpenRegistrationsForCity(Long cityId)
    {
        Date d = new Date();
        /*GregorianCalendar gcalendar = new GregorianCalendar();
        Date time=gcalendar.getTime();
        return getHibernateTemplate().find("from Registration r where r.registrationEnd >= ? and r.city.id = ? order by r.registrationEnd", //$NON-NLS-1$
        		new Object[] { time, cityId });*/
        List<Registration> registrationsList=getHibernateTemplate().find("from Registration r where r.city.id = ? order by r.registrationEnd", //$NON-NLS-1$
        		new Object[] { cityId });
        return fetchFinalValidList(registrationsList, false, true, false);
        
    }
    
    @SuppressWarnings("unchecked")
    public List<Registration> getClosedRegistrations()
    {
        Date d = new Date();
        //return getHibernateTemplate().find("from Registration r where r.registrationEnd < ? order by r.registrationEnd", d); //$NON-NLS-1$
        return fetchFinalValidList(getHibernateTemplate().find("from Registration r order by r.registrationEnd"), false, false, true);
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
    
    /**
     * @param registrationsList
     * @param lessThanEqualTo
     * @param grtrThanEqualTo
     * @param lessThan
     * @return
     */
    private List<Registration> fetchFinalValidList(List<Registration> registrationsList, boolean lessThanEqualTo, boolean grtrThanEqualTo, boolean lessThan){
    	Iterator<Registration> itr=registrationsList.iterator();
        while (itr.hasNext()) {
			Registration registration = (Registration) itr.next();
			Date todaysDate = new Date();
			if(grtrThanEqualTo){
				if(registration.getRegistrationEnd().before(todaysDate)){ 
					itr.remove();
				}
			}else if(lessThanEqualTo){
				if(registration.getRegistrationEnd().after(todaysDate)){ 
					itr.remove();
				}
			}else {
				if(lessThan){
					continue;
				}else{
					itr.remove();
				}
			}
				
		}
        return registrationsList;
    }
}
