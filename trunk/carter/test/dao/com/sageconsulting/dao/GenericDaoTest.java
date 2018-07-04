/*
 * GenericDaoTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao;

import com.sageconsulting.model.User;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.orm.ObjectRetrievalFailureException;

/**
 * This class tests the generic Dao and BaseDao implementation.
 */
public class GenericDaoTest extends BaseDaoTestCase
{
    protected Dao dao;

    /**
     * This method is used instead of setDao b/c setDao uses autowire byType
     * <code>setPopulateProtectedVariables(true)</code> can also be used, but
     * it's a little bit slower.
     */
    @Override
    public void onSetUpBeforeTransaction() throws Exception
    {
        this.dao = (Dao) this.applicationContext.getBean("dao"); //$NON-NLS-1$
    }

    @Override
    public void onTearDownAfterTransaction() throws Exception
    {
        this.dao = null;
    }

    /**
     * Simple test to verify BaseDao works.
     */
    public void testCRUD()
    {
        User user = new User();
        // set required fields
        user.setUsername("foo"); //$NON-NLS-1$
        user.setPassword("bar"); //$NON-NLS-1$
        user.setFirstName("first"); //$NON-NLS-1$
        user.setLastName("last"); //$NON-NLS-1$
        user.getAddress().setCity("Denver"); //$NON-NLS-1$
        user.getAddress().setPostalCode("80465"); //$NON-NLS-1$
        user.setEmail("foo@bar.com"); //$NON-NLS-1$
        /*user.setHandicap(Double.valueOf(1.2));
        user.setGhinNumber("8927483"); //$NON-NLS-1$
*/
        // create
        this.dao.saveObject(user);
        assertNotNull(user.getId());

        // retrieve
        user = (User) this.dao.getObject(User.class, user.getId());
        assertNotNull(user);
        assertEquals(user.getLastName(), "last"); //$NON-NLS-1$

        // update
        user.getAddress().setCountry("USA"); //$NON-NLS-1$
        this.dao.saveObject(user);
        assertEquals(user.getAddress().getCountry(), "USA"); //$NON-NLS-1$

        // delete
        this.dao.removeObject(User.class, user.getId());
        try
        {
            this.dao.getObject(User.class, user.getId());
            fail("User 'foo' found in database"); //$NON-NLS-1$
        }
        catch (ObjectRetrievalFailureException e)
        {
            assertNotNull(e.getMessage());
        }
        catch (InvalidDataAccessApiUsageException e)
        { // Spring 2.0 throws this one
            assertNotNull(e.getMessage());
        }
    }
}
