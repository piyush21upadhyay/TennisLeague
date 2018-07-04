/*
 * RegistrationDao.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao;

import java.util.List;

import com.sageconsulting.model.Registration;

public interface RegistrationDao extends Dao
{
    public Registration getRegistration(Long id);
    
    public List<Registration> getRegistrations();
    
    public List<Registration> getOpenRegistrations();
    
    public List<Registration> getOpenRegistrationsForCity(Long cityId);
    
    public List<Registration> getClosedRegistrations();
    
    public void saveRegistration(Registration registration);
    
    public void removeRegistration(Long id);
}
