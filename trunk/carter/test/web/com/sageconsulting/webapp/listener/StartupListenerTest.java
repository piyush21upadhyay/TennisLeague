/*
 * StartupListenerTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.listener;

import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import junit.framework.TestCase;

import com.sageconsulting.Constants;
import org.springframework.mock.web.MockServletContext;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * This class tests the StartupListener class to verify that variables are
 * placed into the application context.
 */
public class StartupListenerTest extends TestCase
{
    private MockServletContext sc = null;

    private ServletContextListener listener = null;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        this.listener = new StartupListener();

        this.sc = new MockServletContext(""); //$NON-NLS-1$
        this.sc.addInitParameter("daoType", "hibernate"); //$NON-NLS-1$ //$NON-NLS-2$
        this.sc.addInitParameter(Constants.CSS_THEME, "standard"); //$NON-NLS-1$

        // initialize Spring
        String pkg = ClassUtils.classPackageAsResourcePath(Constants.class);
        this.sc.addInitParameter(ContextLoader.CONFIG_LOCATION_PARAM, "classpath*:/" + pkg //$NON-NLS-1$
            + "/dao/applicationContext-*.xml," + "classpath*:META-INF/applicationContext-*.xml"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    @Override
    protected void tearDown() throws Exception
    {
        super.tearDown();
        this.listener = null;
        this.sc = null;
    }

    @SuppressWarnings("unchecked")
    public void testContextInitialized()
    {
        ServletContextEvent event = new ServletContextEvent(this.sc);
        this.listener.contextInitialized(event);

        assertTrue(this.sc.getAttribute(Constants.CONFIG) != null);
        Map config = (Map) this.sc.getAttribute(Constants.CONFIG);
        assertEquals(config.get(Constants.CSS_THEME), "standard"); //$NON-NLS-1$

        assertTrue(this.sc.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE) != null);
        assertTrue(this.sc.getAttribute(Constants.AVAILABLE_ROLES) != null);
    }
}
