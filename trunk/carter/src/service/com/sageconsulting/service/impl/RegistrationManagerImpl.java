/*
 * RegistrationManagerImpl.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service.impl;

import java.util.List;

import com.sageconsulting.dao.RegistrationDao;
import com.sageconsulting.model.Registration;
import com.sageconsulting.service.RegistrationManager;

public class RegistrationManagerImpl extends BaseManager implements RegistrationManager
{
    public void setRegistrationDao(RegistrationDao registrationDao)
    {
        super.setDao(registrationDao);
    }
    
    private RegistrationDao getRegistrationDao()
    {
        return (RegistrationDao)this.dao;
    }

    public Registration getRegistration(Long id)
    {
        return this.getRegistrationDao().getRegistration(id);
    }
    
    public List<Registration> getRegistrations()
    {
        return this.getRegistrationDao().getRegistrations();
    }
    
    public List<Registration> getOpenRegistrations()
    {
        return this.getRegistrationDao().getOpenRegistrations();
    }
    
    public List<Registration> getOpenRegistrationsForCity(Long cityId)
    {
        return this.getRegistrationDao().getOpenRegistrationsForCity(cityId);
    }
    
    public List<Registration> getClosedRegistrations()
    {
        return this.getRegistrationDao().getClosedRegistrations();
    }

    public void saveRegistration(Registration registration)
    {
        this.getRegistrationDao().saveRegistration(registration);
    }

    public void removeRegistration(Long id)
    {
        this.getRegistrationDao().removeRegistration(id);
    }
}
