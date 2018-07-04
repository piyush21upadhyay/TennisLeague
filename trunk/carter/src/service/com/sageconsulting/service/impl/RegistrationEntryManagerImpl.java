/*
 * RegistrationEntryManagerImpl.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service.impl;

import java.util.List;

import com.sageconsulting.dao.RegistrationEntryDao;
import com.sageconsulting.model.RegistrationEntry;
import com.sageconsulting.service.RegistrationEntryManager;

public class RegistrationEntryManagerImpl extends BaseManager implements RegistrationEntryManager
{
    public void setRegistrationEntryDao(RegistrationEntryDao registrationEntryDao)
    {
        super.setDao(registrationEntryDao);
    }
    
    private RegistrationEntryDao getRegistrationEntryDao()
    {
        return (RegistrationEntryDao)this.dao;
    }

    public RegistrationEntry getRegistrationEntry(Long id)
    {
        return this.getRegistrationEntryDao().getRegistrationEntry(id);
    }
    
    public List<RegistrationEntry> getRegistrationEntries()
    {
        return getRegistrationEntryDao().getRegistrationEntries();
    }
    
    public List<RegistrationEntry> getRegistrationEntriesForUser(Long userid)
    {
        return getRegistrationEntryDao().getRegistrationEntriesForUser(userid);
    }
    
    public List<RegistrationEntry> getRegistrationEntriesForRegistration(Long registrationid)
    {
        return getRegistrationEntryDao().getRegistrationEntriesForRegistration(registrationid);
    }

    public void saveRegistrationEntry(RegistrationEntry entry)
    {
        this.getRegistrationEntryDao().saveRegistrationEntry(entry);
    }

    public void removeRegistrationEntry(Long id)
    {
        this.getRegistrationEntryDao().removeRegistrationEntry(id);
    }
}
