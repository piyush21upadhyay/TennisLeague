/*
 * UserExistsExceptionTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service;

import com.sageconsulting.Constants;
import com.sageconsulting.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;
import org.springframework.util.ClassUtils;

public class UserExistsExceptionTest extends AbstractTransactionalDataSourceSpringContextTests
{
    private UserManager manager = null;

    public void setUserManager(UserManager userManager)
    {
        this.manager = userManager;
    }

    @Override
    protected String[] getConfigLocations()
    {
        String pkg = ClassUtils.classPackageAsResourcePath(Constants.class);
        return new String[] { "classpath*:/" + pkg + "/dao/applicationContext-*.xml", //$NON-NLS-1$ //$NON-NLS-2$
            "classpath*:/" + pkg + "/service/applicationContext-service.xml", //$NON-NLS-1$ //$NON-NLS-2$
            "classpath*:META-INF/applicationContext-*.xml" }; //$NON-NLS-1$
    }

    public void testAddExistingUser() throws Exception
    {
        this.logger.debug("entered 'testAddExistingUser' method"); //$NON-NLS-1$
        assertNotNull(this.manager);

        User user = this.manager.getUser("1"); //$NON-NLS-1$

        // create new object with null id - Hibernate doesn't like setId(null)
        User user2 = new User();
        BeanUtils.copyProperties(user, user2);
        user2.setId(null);
        user2.setVersion(null);
        user2.setRoles(null);

        // try saving as new user, this should fail b/c of unique keys
        try
        {
            this.manager.saveUser(user2);
            fail("Duplicate user didn't throw UserExistsException"); //$NON-NLS-1$
        }
        catch (UserExistsException uee)
        {
            assertNotNull(uee);
        }
    }
}
