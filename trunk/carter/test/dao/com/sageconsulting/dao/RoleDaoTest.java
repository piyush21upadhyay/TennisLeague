/*
 * RoleDaoTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao;

import com.sageconsulting.Constants;
import com.sageconsulting.model.Role;

public class RoleDaoTest extends BaseDaoTestCase
{
    private RoleDao roleDao;

    public void setRoleDao(RoleDao dao)
    {
        this.roleDao = dao;
    }

    public void testGetRoleInvalid() throws Exception
    {
        Role role = this.roleDao.getRoleByName("badrolename"); //$NON-NLS-1$
        assertNull(role);
    }

    public void testGetRole() throws Exception
    {
        Role role = this.roleDao.getRoleByName(Constants.USER_ROLE);
        assertNotNull(role);
    }

    public void testUpdateRole() throws Exception
    {
        Role role = this.roleDao.getRoleByName("user"); //$NON-NLS-1$
        this.log.debug(role);
        role.setDescription("test descr"); //$NON-NLS-1$

        this.roleDao.saveRole(role);
        assertEquals(role.getDescription(), "test descr"); //$NON-NLS-1$
    }

    public void testAddAndRemoveRole() throws Exception
    {
        Role role = new Role("testrole"); //$NON-NLS-1$
        role.setDescription("new role descr"); //$NON-NLS-1$
        this.roleDao.saveRole(role);
        setComplete(); // change behavior from rollback to commit
        endTransaction();

        startNewTransaction();
        role = this.roleDao.getRoleByName("testrole"); //$NON-NLS-1$
        assertNotNull(role.getDescription());

        this.roleDao.removeRole("testrole"); //$NON-NLS-1$
        setComplete();
        endTransaction(); // deletes role from database

        role = this.roleDao.getRoleByName("testrole"); //$NON-NLS-1$
        assertNull(role);
    }
}
