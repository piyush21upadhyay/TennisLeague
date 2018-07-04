/*
 * UserManagerTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service;

import com.sageconsulting.Constants;
import com.sageconsulting.dao.RoleDao;
import com.sageconsulting.dao.UserDao;
import com.sageconsulting.model.Role;
import com.sageconsulting.model.User;
import com.sageconsulting.service.impl.RoleManagerImpl;
import com.sageconsulting.service.impl.UserManagerImpl;
import org.jmock.Mock;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.ArrayList;
import java.util.List;

public class UserManagerTest extends BaseManagerTestCase
{
    private UserManagerImpl userManager = new UserManagerImpl();
    private RoleManagerImpl roleManager = new RoleManagerImpl();
    private Mock userDao = null;
    private Mock roleDao = null;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        this.userDao = new Mock(UserDao.class);
        this.userManager.setUserDao((UserDao) this.userDao.proxy());
        this.roleDao = new Mock(RoleDao.class);
        this.roleManager.setRoleDao((RoleDao) this.roleDao.proxy());
    }

    public void testGetUser() throws Exception
    {
        User testData = new User("1"); //$NON-NLS-1$
        testData.getRoles().add(new Role("user")); //$NON-NLS-1$
        // set expected behavior on dao
        this.userDao.expects(once()).method("getUser").with(eq(new Long(1))).will(returnValue(testData)); //$NON-NLS-1$

        User user = this.userManager.getUser("1"); //$NON-NLS-1$
        assertNotNull(user);
        assertTrue(user.getRoles().size() == 1);
        this.userDao.verify();
    }

    public void testSaveUser() throws Exception
    {
        User testData = new User("1"); //$NON-NLS-1$
        testData.getRoles().add(new Role("user")); //$NON-NLS-1$
        // set expected behavior on dao
        this.userDao.expects(once()).method("getUser").with(eq(new Long(1))).will(returnValue(testData)); //$NON-NLS-1$

        User user = this.userManager.getUser("1"); //$NON-NLS-1$
        user.setHomePhone("303-555-1212"); //$NON-NLS-1$
        this.userDao.verify();

        // reset expectations
        this.userDao.reset();
        this.userDao.expects(once()).method("saveUser").with(same(user)); //$NON-NLS-1$

        this.userManager.saveUser(user);
        assertTrue(user.getHomePhone().equals("303-555-1212")); //$NON-NLS-1$
        assertTrue(user.getRoles().size() == 1);
        this.userDao.verify();
    }

    public void testAddAndRemoveUser() throws Exception
    {
        User user = new User();

        // call populate method in super class to populate test data
        // from a properties file matching this class name
        user = (User) populate(user);

        // set expected behavior on role dao
        this.roleDao.expects(once()).method("getRoleByName").with(eq("user")). //$NON-NLS-1$ //$NON-NLS-2$
            will(returnValue(new Role("user"))); //$NON-NLS-1$

        Role role = this.roleManager.getRole(Constants.USER_ROLE);
        this.roleDao.verify();
        user.addRole(role);

        // set expected behavior on user dao
        this.userDao.expects(once()).method("saveUser").with(same(user)); //$NON-NLS-1$

        this.userManager.saveUser(user);
        assertTrue(user.getUsername().equals("john")); //$NON-NLS-1$
        assertTrue(user.getRoles().size() == 1);
        this.userDao.verify();

        // reset expectations
        this.userDao.reset();

        this.userDao.expects(once()).method("removeUser").with(eq(new Long(5))); //$NON-NLS-1$
        this.userManager.removeUser("5"); //$NON-NLS-1$
        this.userDao.verify();

        // reset expectations
        this.userDao.reset();
        this.userDao.expects(once()).method("getUser").will(returnValue(null)); //$NON-NLS-1$
        user = this.userManager.getUser("5"); //$NON-NLS-1$
        assertNull(user);
        this.userDao.verify();
    }

    public void testUserExistsException()
    {
        // set expectations
        User user = new User("admin"); //$NON-NLS-1$
        user.setEmail("admin@citygolfleague.com"); //$NON-NLS-1$
        List<User> users = new ArrayList<User>();

        users.add(user);
        Exception ex = new DataIntegrityViolationException(""); //$NON-NLS-1$
        this.userDao.expects(once()).method("saveUser").with(same(user)).will(throwException(ex)); //$NON-NLS-1$

        // run test
        try
        {
            this.userManager.saveUser(user);
            fail("Expected UserExistsException not thrown"); //$NON-NLS-1$
        }
        catch (UserExistsException e)
        {
            this.log.debug("expected exception: " + e.getMessage()); //$NON-NLS-1$
            assertNotNull(e);
        }
    }
}
