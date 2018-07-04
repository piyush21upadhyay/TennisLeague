/*
 * LocaleFilter.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.filter;

import com.sageconsulting.Constants;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

/**
 * Filter to wrap request with a request including user preferred locale.
 */
public class LocaleFilter extends OncePerRequestFilter
{

    @SuppressWarnings("unchecked")
    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
        throws IOException, ServletException
    {
        HttpServletRequest curRequest = request;
        String locale = curRequest.getParameter("locale"); //$NON-NLS-1$
        Locale preferredLocale = null;

        if (locale != null)
        {
            preferredLocale = new Locale(locale);
        }

        HttpSession session = curRequest.getSession(false);

        if (session != null)
        {
            if (preferredLocale == null)
            {
                preferredLocale = (Locale) session.getAttribute(Constants.PREFERRED_LOCALE_KEY);
            }
            else
            {
                session.setAttribute(Constants.PREFERRED_LOCALE_KEY, preferredLocale);
                Config.set(session, Config.FMT_LOCALE, preferredLocale);
            }

            if ((preferredLocale != null) && !(curRequest instanceof LocaleRequestWrapper))
            {
                curRequest = new LocaleRequestWrapper(curRequest, preferredLocale);
                LocaleContextHolder.setLocale(preferredLocale);
            }
        }

        // I removed the allowance for theme changing for now.
        // Instead we set it to "user" for all users
        Map<String, Object> config = (Map<String, Object>)getServletContext().getAttribute(Constants.CONFIG);
        config.put(Constants.CSS_THEME, "user"); //$NON-NLS-1$

        chain.doFilter(curRequest, response);

        // Reset thread-bound LocaleContext.
        LocaleContextHolder.setLocaleContext(null);
    }
}
