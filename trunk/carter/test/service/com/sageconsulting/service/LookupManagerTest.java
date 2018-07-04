/*
 * LookupManagerTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service;

import java.util.ArrayList;
import java.util.List;

import com.sageconsulting.dao.LookupDao;
import com.sageconsulting.model.LabelValue;
import com.sageconsulting.model.Role;
import com.sageconsulting.service.impl.LookupManagerImpl;
import org.jmock.Mock;

public class LookupManagerTest extends BaseManagerTestCase
{
    private LookupManager mgr = new LookupManagerImpl();

    private Mock lookupDao = null;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        this.lookupDao = new Mock(LookupDao.class);
        this.mgr.setLookupDao((LookupDao) this.lookupDao.proxy());
    }

    public void testGetAllRoles()
    {
        if (this.log.isDebugEnabled())
        {
            this.log.debug("entered 'testGetAllRoles' method"); //$NON-NLS-1$
        }

        // set expected behavior on dao
        Role role = new Role("admin"); //$NON-NLS-1$
        List<Role> testData = new ArrayList<Role>();
        testData.add(role);
        this.lookupDao.expects(once()).method("getRoles").withNoArguments().will(returnValue(testData)); //$NON-NLS-1$

        List<LabelValue> roles = this.mgr.getAllRoles();
        assertTrue(roles.size() > 0);
        // verify expectations
        this.lookupDao.verify();
    }
}
