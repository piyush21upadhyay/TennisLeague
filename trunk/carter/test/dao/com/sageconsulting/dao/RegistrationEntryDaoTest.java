/*
 * RegistrationEntryDaoTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao;

import java.util.GregorianCalendar;

import org.springframework.dao.DataIntegrityViolationException;

import com.sageconsulting.model.City;
import com.sageconsulting.model.Registration;
import com.sageconsulting.model.RegistrationEntry;
import com.sageconsulting.model.User;

public class RegistrationEntryDaoTest extends BaseDaoTestCase
{
    private RegistrationDao registrationDao;
    private RegistrationEntryDao registrationEntryDao;
    private UserDao userDao;
    private CityDao cityDao;
    
    private Registration registration;
    
    public void setRegistrationDao(RegistrationDao dao)
    {
        this.registrationDao = dao;
    }
    
    public void setRegistrationEntryDao(RegistrationEntryDao dao)
    {
        this.registrationEntryDao = dao;
    }
    
    public void setUserDao(UserDao dao)
    {
        this.userDao = dao;
    }
    
    public void setCityDao(CityDao dao)
    {
        this.cityDao = dao;
    }
    
    @Override
    public void onSetUpBeforeTransaction()
    {
        City portland = this.cityDao.getCity(Long.valueOf(1));
        this.registration = new Registration();
        this.registration.setCity(portland);
        this.registration.setDisplayName("Test Registration"); //$NON-NLS-1$
        this.registration.setEarlyRegistrationStart(new GregorianCalendar(2007, 6, 10).getTime());
        this.registration.setRegularRegistrationStart(new GregorianCalendar(2007, 6, 17).getTime());
        this.registration.setRegistrationEnd(new GregorianCalendar(2007, 6, 24).getTime());
        this.registrationDao.saveRegistration(this.registration);
    }
    
    @Override
    public void onTearDownAfterTransaction()
    {
        this.registrationDao.removeRegistration(this.registration.getId());
    }
    
    public void testSaveRegistrationEntry()
    {
        RegistrationEntry r = createRegistrationEntry();
        this.registrationEntryDao.saveRegistrationEntry(r);
    }
    
    public void testSaveRegistrationEntryInvalid()
    {
        try
        {
            RegistrationEntry r = createRegistrationEntry();
            r.setRegistration(null);
            this.registrationEntryDao.saveRegistrationEntry(r);
            fail("Shouldn't be able to save registration entry with null registration"); //$NON-NLS-1$
        }
        catch (DataIntegrityViolationException e)
        {
            assertNotNull(e);
        }
    }
    
    public void testGetRegistrationEntry()
    {
        RegistrationEntry r = createRegistrationEntry();
        this.registrationEntryDao.saveRegistrationEntry(r);
        
        RegistrationEntry reg2 = this.registrationEntryDao.getRegistrationEntry(r.getId());
        assertNotNull(reg2);
        assertNotNull(reg2.getUser());
        assertNotNull(reg2.getRegistration());
        assertEquals(reg2.getRegistration(), this.registration);
    }
    
    public void testRemoveRegistrationEntry()
    {
        RegistrationEntry r = createRegistrationEntry();
        this.registrationEntryDao.saveRegistrationEntry(r);
        RegistrationEntry reg2 = this.registrationEntryDao.getRegistrationEntry(r.getId());
        assertNotNull(reg2);
        this.registrationEntryDao.removeRegistrationEntry(reg2.getId());
        reg2 = this.registrationEntryDao.getRegistrationEntry(reg2.getId());
        assertNull(reg2);
    }
    
    private RegistrationEntry createRegistrationEntry()
    {
        User u = this.userDao.getUser(Long.valueOf(2));
        RegistrationEntry r = new RegistrationEntry();
        r.setUser(u);
        r.setRegistration(this.registration);
        r.setPaymentType(Integer.valueOf(1));
        return r;
    }
}
