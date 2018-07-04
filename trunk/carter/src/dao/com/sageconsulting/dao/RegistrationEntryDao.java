/*
 * RegistrationEntryDao.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao;

import java.util.List;

import com.sageconsulting.model.RegistrationEntry;

public interface RegistrationEntryDao extends Dao
{
    public RegistrationEntry getRegistrationEntry(Long id);
    
    public List<RegistrationEntry> getRegistrationEntries();
    
    public List<RegistrationEntry> getRegistrationEntriesForUser(Long userId);
    
    public List<RegistrationEntry> getRegistrationEntriesForRegistration(Long registrationId);
    
    public void saveRegistrationEntry(RegistrationEntry entry);
    
    public void removeRegistrationEntry(Long id);
}
