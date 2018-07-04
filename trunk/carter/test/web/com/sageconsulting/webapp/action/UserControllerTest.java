/*
 * UserControllerTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sageconsulting.Constants;
import org.springframework.web.servlet.ModelAndView;

public class UserControllerTest extends BaseControllerTestCase
{

    @SuppressWarnings("unchecked")
    public void testHandleRequest() throws Exception
    {
        UserController c = (UserController) ctx.getBean("userController"); //$NON-NLS-1$
        ModelAndView mav = c.handleRequest((HttpServletRequest) null, (HttpServletResponse) null);
        Map m = mav.getModel();
        assertNotNull(m.get(Constants.USER_LIST));
        assertEquals(mav.getViewName(), "userList"); //$NON-NLS-1$
    }
}
