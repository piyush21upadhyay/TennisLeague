/*
 * LocaleFilterTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.filter;

import java.util.Locale;

import javax.servlet.jsp.jstl.core.Config;

import junit.framework.TestCase;

import com.sageconsulting.Constants;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mock.web.MockFilterConfig;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

public class LocaleFilterTest extends TestCase
{
    private LocaleFilter filter = null;

    @Override
    protected void setUp()
    {
        this.filter = new LocaleFilter();
        this.filter.setFilterConfig(new MockFilterConfig());
    }

    public void testSetLocaleInSessionWhenSessionIsNull() throws Exception
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addParameter("locale", "es"); //$NON-NLS-1$ //$NON-NLS-2$

        MockHttpServletResponse response = new MockHttpServletResponse();
        this.filter.doFilter(request, response, new MockFilterChain());

        // no session, should result in null
        assertNull(request.getSession().getAttribute(Constants.PREFERRED_LOCALE_KEY));
        // thread locale should always have it, regardless of session
        assertNotNull(LocaleContextHolder.getLocale());
    }

    public void testSetLocaleInSessionWhenSessionNotNull() throws Exception
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addParameter("locale", "es"); //$NON-NLS-1$ //$NON-NLS-2$

        MockHttpServletResponse response = new MockHttpServletResponse();
        request.setSession(new MockHttpSession(null));

        this.filter.doFilter(request, response, new MockFilterChain());

        // session not null, should result in not null
        Locale locale = (Locale) request.getSession().getAttribute(Constants.PREFERRED_LOCALE_KEY);
        assertNotNull(locale);
        assertNotNull(LocaleContextHolder.getLocale());
        assertEquals(new Locale("es"), locale); //$NON-NLS-1$
    }

    public void testSetInvalidLocale() throws Exception
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addParameter("locale", "foo"); //$NON-NLS-1$ //$NON-NLS-2$

        MockHttpServletResponse response = new MockHttpServletResponse();
        request.setSession(new MockHttpSession(null));

        this.filter.doFilter(request, response, new MockFilterChain());

        // a locale will get set regardless - there's no such thing as an
        // invalid one
        assertNotNull(request.getSession().getAttribute(Constants.PREFERRED_LOCALE_KEY));
    }

    public void testJstlLocaleIsSet() throws Exception
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addParameter("locale", "es"); //$NON-NLS-1$ //$NON-NLS-2$

        MockHttpServletResponse response = new MockHttpServletResponse();
        request.setSession(new MockHttpSession(null));

        this.filter.doFilter(request, response, new MockFilterChain());

        assertNotNull(Config.get(request.getSession(), Config.FMT_LOCALE));
    }
}
