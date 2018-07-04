/*
 * PasswordHintControllerTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.dumbster.smtp.SimpleSmtpServer;

public class PasswordHintControllerTest extends BaseControllerTestCase
{
    private PasswordHintController c;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp(); // needed to initialize a user
        this.c = (PasswordHintController) ctx.getBean("passwordHintController"); //$NON-NLS-1$
    }

    @Override
    protected void tearDown() throws Exception
    {
        super.tearDown();
        this.c = null;
    }

    public void testExecute() throws Exception
    {
        MockHttpServletRequest request = newGet("/passwordHint.html"); //$NON-NLS-1$
        request.addParameter("username", "tcarter"); //$NON-NLS-1$ //$NON-NLS-2$

        SimpleSmtpServer server = SimpleSmtpServer.start(2525);

        this.c.handleRequest(request, new MockHttpServletResponse());

        // verify an account information e-mail was sent
        server.stop();
        assertTrue(server.getReceivedEmailSize() == 1);

        // verify that success messages are in the session
        assertNotNull(request.getSession().getAttribute("messages")); //$NON-NLS-1$
    }
}
