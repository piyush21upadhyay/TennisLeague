/*
 * RegistrationEntryManager.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service;

import java.util.List;

import com.sageconsulting.model.RegistrationEntry;

public interface RegistrationEntryManager extends Manager
{
    public RegistrationEntry getRegistrationEntry(Long id);
    
    public List<RegistrationEntry> getRegistrationEntries();
    
    public List<RegistrationEntry> getRegistrationEntriesForUser(Long userid);
    
    public List<RegistrationEntry> getRegistrationEntriesForRegistration(Long registrationid);
    
    public void saveRegistrationEntry(RegistrationEntry entry);
    
    public void removeRegistrationEntry(Long id);
}
