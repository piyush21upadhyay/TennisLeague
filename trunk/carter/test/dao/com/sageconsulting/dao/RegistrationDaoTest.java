/*
 * RegistrationDaoTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.sageconsulting.model.City;
import com.sageconsulting.model.Registration;

/**
 * Unit tests for the {@link RegistrationDao} implementation.
 */
public class RegistrationDaoTest extends BaseDaoTestCase
{
    private RegistrationDao registrationDao;
    //private UserDao userDao;
    private CityDao cityDao;
    
    public void setRegistrationDao(RegistrationDao dao)
    {
        this.registrationDao = dao;
    }
    
//    public void setUserDao(UserDao dao)
//    {
//        this.userDao = dao;
//    }
    
    public void setCityDao(CityDao dao)
    {
        this.cityDao = dao;
    }
    
    public void testSaveRegistration()
    {
        Registration r = createRegistration("Portland Fall 2007"); //$NON-NLS-1$
        this.registrationDao.saveRegistration(r);
    }
    
    public void testSaveRegistrationInvalid()
    {
        Registration r = createRegistration("Portland Fall 2007"); //$NON-NLS-1$
        this.registrationDao.saveRegistration(r);
        try
        {
            r = createRegistration("Portland Fall 2007"); //$NON-NLS-1$
            this.registrationDao.saveRegistration(r);
            fail("Shouldn't be able to save two registrations with same display name"); //$NON-NLS-1$
        }
        catch (DataIntegrityViolationException e)
        {
            assertNotNull(e);
        }
    }
    
    public void testGetRegistration()
    {
        Registration r = createRegistration("Portland Fall 2007"); //$NON-NLS-1$
        this.registrationDao.saveRegistration(r);
        
        Registration reg2 = this.registrationDao.getRegistration(r.getId());
        assertNotNull(reg2);
        assertNotNull(reg2.getCity());
        assertEquals(reg2.getCity(), r.getCity());
    }
    
    public void testGetRegistrations()
    {
        Registration r = createRegistration("Portland Fall 2007"); //$NON-NLS-1$
        this.registrationDao.saveRegistration(r);
        r = createRegistration("Vancouver Fall 2007"); //$NON-NLS-1$
        this.registrationDao.saveRegistration(r);
        List<Registration> list = this.registrationDao.getRegistrations();
        assertTrue(list.size() == 3);
    }
    
    public void testGetOpenRegistrations()
    {
        Registration r = createRegistration("Portland Fall 2007"); //$NON-NLS-1$
        this.registrationDao.saveRegistration(r);
        r = createRegistration("Vancouver Fall 2007"); //$NON-NLS-1$
        r.setRegistrationEnd(new GregorianCalendar(2007, 1, 1).getTime());
        this.registrationDao.saveRegistration(r);
        List<Registration> list = this.registrationDao.getOpenRegistrations();
        assertTrue(list.size() == 1);
    }
    
    public void testRemoveRegistration()
    {
        Registration r = createRegistration("Portland Fall 2007"); //$NON-NLS-1$
        this.registrationDao.saveRegistration(r);
        Registration reg2 = this.registrationDao.getRegistration(r.getId());
        assertNotNull(reg2);
        this.registrationDao.removeRegistration(reg2.getId());
        reg2 = this.registrationDao.getRegistration(reg2.getId());
        assertNull(reg2);
    }
    
    private Registration createRegistration(String displayName)
    {
        City portland = this.cityDao.getCity(Long.valueOf(1));
        Registration r = new Registration();
        r.setCity(portland);
        r.setDisplayName(displayName);
        r.setEarlyRegistrationStart(new GregorianCalendar(2007, 6, 10).getTime());
        r.setRegularRegistrationStart(new GregorianCalendar(2007, 6, 17).getTime());
        r.setRegistrationEnd(new GregorianCalendar(2007, 6, 24).getTime());
        return r;
    }
}
