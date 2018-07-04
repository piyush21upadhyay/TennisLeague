/*
 * UserSecurityAdviceTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service;

import org.acegisecurity.AccessDeniedException;
import org.acegisecurity.Authentication;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.context.SecurityContext;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.context.SecurityContextImpl;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.acegisecurity.providers.dao.UserCache;
import com.sageconsulting.Constants;
import com.sageconsulting.dao.UserDao;
import com.sageconsulting.model.Role;
import com.sageconsulting.model.User;
import org.jmock.Mock;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserSecurityAdviceTest extends BaseManagerTestCase
{
    Mock userDao = null;

    ApplicationContext ctx = null;

    SecurityContext initialSecurityContext = null;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        // store initial security context for later restoration
        this.initialSecurityContext = SecurityContextHolder.getContext();

        SecurityContext context = new SecurityContextImpl();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("user", "password", //$NON-NLS-1$ //$NON-NLS-2$
            new GrantedAuthority[] { new GrantedAuthorityImpl(Constants.USER_ROLE) });
        context.setAuthentication(token);
        SecurityContextHolder.setContext(context);
    }

    @Override
    protected void tearDown()
    {
        SecurityContextHolder.setContext(this.initialSecurityContext);
    }

    public void testAddUserWithoutAdminRole() throws Exception
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        assertTrue(auth.isAuthenticated());
        UserManager userManager = makeInterceptedTarget();
        User user = new User("admin"); //$NON-NLS-1$

        try
        {
            userManager.saveUser(user);
            fail("AccessDeniedException not thrown"); //$NON-NLS-1$
        }
        catch (AccessDeniedException expected)
        {
            assertNotNull(expected);
            assertEquals(expected.getMessage(), UserSecurityAdvice.ACCESS_DENIED);
        }
    }

    public void testAddUserAsAdmin() throws Exception
    {
        SecurityContext context = new SecurityContextImpl();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("admin", "password", //$NON-NLS-1$ //$NON-NLS-2$
            new GrantedAuthority[] { new GrantedAuthorityImpl(Constants.ADMIN_ROLE) });
        context.setAuthentication(token);
        SecurityContextHolder.setContext(context);

        UserManager userManager = makeInterceptedTarget();
        User user = new User("admin"); //$NON-NLS-1$

        this.userDao.expects(once()).method("saveUser"); //$NON-NLS-1$
        userManager.saveUser(user);
        this.userDao.verify();
    }

    public void testUpdateUserProfile() throws Exception
    {
        UserManager userManager = makeInterceptedTarget();
        User user = new User("user"); //$NON-NLS-1$
        user.getRoles().add(new Role(Constants.USER_ROLE));

        this.userDao.expects(once()).method("saveUser"); //$NON-NLS-1$
        userManager.saveUser(user);
        this.userDao.verify();
    }

    public void testChangeToAdminRoleFromUserRole() throws Exception
    {
        UserManager userManager = makeInterceptedTarget();
        User user = new User("user"); //$NON-NLS-1$
        user.getRoles().add(new Role(Constants.ADMIN_ROLE));

        try
        {
            userManager.saveUser(user);
            fail("AccessDeniedException not thrown"); //$NON-NLS-1$
        }
        catch (AccessDeniedException expected)
        {
            assertNotNull(expected);
            assertEquals(expected.getMessage(), UserSecurityAdvice.ACCESS_DENIED);
        }
    }

    public void testAddAdminRoleWhenAlreadyHasUserRole() throws Exception
    {
        UserManager userManager = makeInterceptedTarget();
        User user = new User("user"); //$NON-NLS-1$
        user.getRoles().add(new Role(Constants.ADMIN_ROLE));
        user.getRoles().add(new Role(Constants.USER_ROLE));

        try
        {
            userManager.saveUser(user);
            fail("AccessDeniedException not thrown"); //$NON-NLS-1$
        }
        catch (AccessDeniedException expected)
        {
            assertNotNull(expected);
            assertEquals(expected.getMessage(), UserSecurityAdvice.ACCESS_DENIED);
        }
    }

    public void testAddUserRoleWhenHasAdminRole() throws Exception
    {
        SecurityContext context = new SecurityContextImpl();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("user", "password", //$NON-NLS-1$ //$NON-NLS-2$
            new GrantedAuthority[] { new GrantedAuthorityImpl(Constants.ADMIN_ROLE) });
        context.setAuthentication(token);
        SecurityContextHolder.setContext(context);

        UserManager userManager = makeInterceptedTarget();
        User user = new User("user"); //$NON-NLS-1$
        user.getRoles().add(new Role(Constants.ADMIN_ROLE));
        user.getRoles().add(new Role(Constants.USER_ROLE));

        this.userDao.expects(once()).method("saveUser"); //$NON-NLS-1$
        userManager.saveUser(user);
        this.userDao.verify();
    }

    public void testUpdateUserWithUserRole() throws Exception
    {
        UserManager userManager = makeInterceptedTarget();
        User user = new User("user"); //$NON-NLS-1$
        user.getRoles().add(new Role(Constants.USER_ROLE));

        this.userDao.expects(once()).method("saveUser"); //$NON-NLS-1$
        userManager.saveUser(user);
        this.userDao.verify();
    }

    // Test removing user from cache after update
    public void testRemoveUserFromCache() throws Exception
    {
        SecurityContext context = new SecurityContextImpl();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("user", "password", //$NON-NLS-1$ //$NON-NLS-2$
            new GrantedAuthority[] { new GrantedAuthorityImpl(Constants.ADMIN_ROLE) });
        context.setAuthentication(token);
        SecurityContextHolder.setContext(context);

        UserManager userManager = makeInterceptedTarget();

        UserCache cache = (UserCache) this.ctx.getBean("userCache"); //$NON-NLS-1$
        User user = new User("cacheduser"); //$NON-NLS-1$
        user.setVersion(new Integer(1));
        user.getRoles().add(new Role(Constants.USER_ROLE));
        cache.putUserInCache(user);

        assertNotNull(cache.getUserFromCache(user.getUsername().toLowerCase()));

        this.userDao.expects(once()).method("saveUser"); //$NON-NLS-1$
        userManager.saveUser(user);
        assertNull(cache.getUserFromCache(user.getUsername()));
    }

    private UserManager makeInterceptedTarget()
    {
        this.ctx = new ClassPathXmlApplicationContext("com/sageconsulting/service/applicationContext-test.xml"); //$NON-NLS-1$

        UserManager userManager = (UserManager) this.ctx.getBean("target"); //$NON-NLS-1$

        // Mock the userDao
        this.userDao = new Mock(UserDao.class);
        userManager.setUserDao((UserDao) this.userDao.proxy());
        return userManager;
    }
}
