/*
 * UserDaoTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao;

import com.sageconsulting.Constants;
import com.sageconsulting.model.Address;
import com.sageconsulting.model.Role;
import com.sageconsulting.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;

public class UserDaoTest extends BaseDaoTestCase
{
    private UserDao userDao = null;
    private RoleDao roleDao = null;

    public void setUserDao(UserDao dao)
    {
        this.userDao = dao;
    }

    public void setRoleDao(RoleDao rdao)
    {
        this.roleDao = rdao;
    }

    public void testGetUserInvalid() throws Exception
    {
        try
        {
            this.userDao.getUser(new Long(1000));
            fail("'badusername' found in database, failing test..."); //$NON-NLS-1$
        }
        catch (DataAccessException d)
        {
            assertNotNull(d);
        }
    }

    public void testGetUser() throws Exception
    {
        User user = this.userDao.getUser(new Long(1));

        assertNotNull(user);
        assertEquals(1, user.getRoles().size());
        assertTrue(user.isEnabled());
    }

    public void testUpdateUser() throws Exception
    {
        User user = this.userDao.getUser(new Long(1));

        Address address = user.getAddress();
        address.setAddress("new address"); //$NON-NLS-1$

        this.userDao.saveUser(user);

        assertEquals(user.getAddress(), address);
        assertEquals("new address", user.getAddress().getAddress()); //$NON-NLS-1$

        // verify that violation occurs when adding new user with same username
        user.setId(null);

        endTransaction();

        try
        {
            this.userDao.saveUser(user);
            fail("saveUser didn't throw DataIntegrityViolationException"); //$NON-NLS-1$
        }
        catch (DataIntegrityViolationException e)
        {
            assertNotNull(e);
            this.log.debug("expected exception: " + e.getMessage()); //$NON-NLS-1$
        }
    }

    public void testAddUserRole() throws Exception
    {
        User user = this.userDao.getUser(new Long(2));
        assertEquals(1, user.getRoles().size());

        Role role = this.roleDao.getRoleByName(Constants.ADMIN_ROLE);
        user.addRole(role);
        this.userDao.saveUser(user);

        assertEquals(2, user.getRoles().size());

        // add the same role twice - should result in no additional role
        user.addRole(role);
        this.userDao.saveUser(user);

        assertEquals("more than 2 roles", 2, user.getRoles().size()); //$NON-NLS-1$

        user.getRoles().remove(role);
        this.userDao.saveUser(user);

        assertEquals(1, user.getRoles().size());
    }

    public void testAddAndRemoveUser() throws Exception
    {
        User user = new User("testuser"); //$NON-NLS-1$
        user.setPassword("testpass"); //$NON-NLS-1$
        user.setFirstName("Test"); //$NON-NLS-1$
        user.setLastName("Last"); //$NON-NLS-1$
        Address address = new Address();
        address.setCity("Denver"); //$NON-NLS-1$
        address.setProvince("CO"); //$NON-NLS-1$
        address.setCountry("USA"); //$NON-NLS-1$
        address.setPostalCode("80210"); //$NON-NLS-1$
        user.setAddress(address);
        user.setEmail("testuser@citygolfleague.com"); //$NON-NLS-1$
        /*user.setGhinNumber("9695943"); //$NON-NLS-1$
        user.setHandicap(Double.valueOf(2.2));*/

        Role role = this.roleDao.getRoleByName(Constants.USER_ROLE);
        assertNotNull(role.getId());
        user.addRole(role);

        this.userDao.saveUser(user);

        assertNotNull(user.getId());
        assertEquals("testpass", user.getPassword()); //$NON-NLS-1$

        this.userDao.removeUser(user.getId());

        try
        {
            user = this.userDao.getUser(user.getId());
            fail("getUser didn't throw DataAccessException"); //$NON-NLS-1$
        }
        catch (DataAccessException d)
        {
            assertNotNull(d);
        }
    }
}
