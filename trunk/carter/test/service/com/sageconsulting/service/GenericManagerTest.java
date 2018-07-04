/*
 * GenericManagerTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service;

import com.sageconsulting.dao.Dao;
import com.sageconsulting.model.User;
import com.sageconsulting.service.impl.BaseManager;
import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

/**
 * This class tests the generic Manager and BaseManager implementation.
 */
public class GenericManagerTest extends BaseManagerTestCase
{
    protected Manager manager = new BaseManager();

    protected Mock dao;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        this.dao = new Mock(Dao.class);
        this.manager.setDao((Dao) this.dao.proxy());
    }

    @Override
    protected void tearDown() throws Exception
    {
        this.manager = null;
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

        // create
        // set expectations
        this.dao.expects(once()).method("saveObject").isVoid(); //$NON-NLS-1$

        this.manager.saveObject(user);
        this.dao.verify();

        // retrieve
        this.dao.reset();
        // expectations
        this.dao.expects(once()).method("getObject").will(returnValue(user)); //$NON-NLS-1$

        user = (User) this.manager.getObject(User.class, user.getUsername());
        this.dao.verify();

        // update
        this.dao.reset();
        this.dao.expects(once()).method("saveObject").isVoid(); //$NON-NLS-1$
        user.getAddress().setCountry("USA"); //$NON-NLS-1$
        this.manager.saveObject(user);
        this.dao.verify();

        // delete
        this.dao.reset();
        // expectations
        Exception ex = new ObjectRetrievalFailureException(User.class, "foo"); //$NON-NLS-1$
        this.dao.expects(once()).method("removeObject").isVoid(); //$NON-NLS-1$
        this.dao.expects(once()).method("getObject").will(throwException(ex)); //$NON-NLS-1$
        this.manager.removeObject(User.class, "foo"); //$NON-NLS-1$
        try
        {
            this.manager.getObject(User.class, "foo"); //$NON-NLS-1$
            fail("User 'foo' found in database"); //$NON-NLS-1$
        }
        catch (ObjectRetrievalFailureException e)
        {
            assertNotNull(e.getMessage());
        }
        this.dao.verify();
    }
}
