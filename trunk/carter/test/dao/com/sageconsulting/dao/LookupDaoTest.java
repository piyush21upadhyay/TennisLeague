/*
 * LookupDaoTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao;

import java.util.List;

import com.sageconsulting.model.Role;

/**
 * This class tests the current LookupDao implementation class
 */
public class LookupDaoTest extends BaseDaoTestCase
{
    private LookupDao lookupDao;

    public void setLookupDao(LookupDao dao)
    {
        this.lookupDao = dao;
    }

    public void testGetRoles()
    {
        List<Role> roles = this.lookupDao.getRoles();
        this.log.debug(roles);
        assertTrue(roles.size() > 0);
    }
}
