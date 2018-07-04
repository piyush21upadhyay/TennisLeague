/*
 * LocaleRequestWrapper.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.filter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * HttpRequestWrapper overriding methods getLocale(), getLocales() to include
 * the user's preferred locale.
 */
public class LocaleRequestWrapper extends HttpServletRequestWrapper
{
    private final transient Log log = LogFactory.getLog(LocaleRequestWrapper.class);

    private final Locale preferredLocale;

    public LocaleRequestWrapper(HttpServletRequest decorated, Locale userLocale)
    {
        super(decorated);
        this.preferredLocale = userLocale;
        if (null == this.preferredLocale)
        {
            this.log.error("preferred locale = null, it is an unexpected value!"); //$NON-NLS-1$
        }
    }

    /**
     * @see javax.servlet.ServletRequestWrapper#getLocale()
     */
    @Override
    public Locale getLocale()
    {
        if (null != this.preferredLocale)
        {
            return this.preferredLocale;
        }
        return super.getLocale();
    }

    /**
     * @see javax.servlet.ServletRequestWrapper#getLocales()
     */
    @SuppressWarnings("unchecked")
    @Override
    public Enumeration getLocales()
    {
        if (null != this.preferredLocale)
        {
            List l = Collections.list(super.getLocales());
            if (l.contains(this.preferredLocale))
            {
                l.remove(this.preferredLocale);
            }
            l.add(0, this.preferredLocale);
            return Collections.enumeration(l);
        }
        return super.getLocales();
    }
}
