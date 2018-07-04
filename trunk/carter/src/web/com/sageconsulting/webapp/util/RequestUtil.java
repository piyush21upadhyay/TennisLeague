/*
 * RequestUtil.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Convenience class for setting and retrieving cookies.
 */
public class RequestUtil
{
    private transient static Log log = LogFactory.getLog(RequestUtil.class);

    /**
     * Convenience method to set a cookie
     * 
     * @param response
     * @param name
     * @param value
     * @param path
     */
    public static void setCookie(HttpServletResponse response, String name, String value, String path)
    {
        if (log.isDebugEnabled())
        {
            log.debug("Setting cookie '" + name + "' on path '" + path + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        }

        Cookie cookie = new Cookie(name, value);
        cookie.setSecure(false);
        cookie.setPath(path);
        cookie.setMaxAge(3600 * 24 * 30); // 30 days

        response.addCookie(cookie);
    }

    /**
     * Convenience method to get a cookie by name
     * 
     * @param request
     *            the current request
     * @param name
     *            the name of the cookie to find
     * 
     * @return the cookie (if found), null if not found
     */
    public static Cookie getCookie(HttpServletRequest request, String name)
    {
        Cookie[] cookies = request.getCookies();
        Cookie returnCookie = null;

        if (cookies == null)
        {
            return returnCookie;
        }

        for (Cookie thisCookie : cookies)
        {
            if (thisCookie.getName().equals(name))
            {
                // cookies with no value do me no good!
                if (!thisCookie.getValue().equals("")) //$NON-NLS-1$
                {
                    returnCookie = thisCookie;

                    break;
                }
            }
        }

        return returnCookie;
    }

    /**
     * Convenience method for deleting a cookie by name
     * 
     * @param response
     *            the current web response
     * @param cookie
     *            the cookie to delete
     * @param path
     *            the path on which the cookie was set (i.e. /carter)
     */
    public static void deleteCookie(HttpServletResponse response, Cookie cookie, String path)
    {
        if (cookie != null)
        {
            // Delete the cookie by setting its maximum age to zero
            cookie.setMaxAge(0);
            cookie.setPath(path);
            response.addCookie(cookie);
        }
    }

    /**
     * Convenience method to get the application's URL based on request
     * variables.
     */
    public static String getAppURL(HttpServletRequest request)
    {
        StringBuffer url = new StringBuffer();
        int port = request.getServerPort();
        if (port < 0)
        {
            port = 80; // Work around java.net.URL bug
        }
        String scheme = request.getScheme();
        url.append(scheme);
        url.append("://"); //$NON-NLS-1$
        url.append(request.getServerName());
        if ((scheme.equals("http") && (port != 80)) || (scheme.equals("https") && (port != 443))) //$NON-NLS-1$ //$NON-NLS-2$
        {
            url.append(':');
            url.append(port);
        }
        url.append(request.getContextPath());
        return url.toString();
    }
}
