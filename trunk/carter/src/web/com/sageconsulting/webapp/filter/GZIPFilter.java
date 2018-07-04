/*
 * GZIPFilter.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.displaytag.tags.TableTagParameters;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Filter that compresses output with gzip (assuming that browser supports
 * gzip). Code from <a
 * href="http://www.onjava.com/pub/a/onjava/2003/11/19/filters.html">
 * http://www.onjava.com/pub/a/onjava/2003/11/19/filters.html</a>.
 * 
 * &copy; 2003 Jayson Falkner You may freely use the code both commercially and
 * non-commercially.
 * 
 * @web.filter name="compressionFilter"
 */
public class GZIPFilter extends OncePerRequestFilter
{
    private final transient Log log = LogFactory.getLog(GZIPFilter.class);

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
        throws IOException, ServletException
    {

        if (isGZIPSupported(request))
        {
            if (this.log.isDebugEnabled())
            {
                this.log.debug("GZIP supported, compressing response"); //$NON-NLS-1$
            }

            GZIPResponseWrapper wrappedResponse = new GZIPResponseWrapper(response);

            chain.doFilter(request, wrappedResponse);
            wrappedResponse.finishResponse();

            return;
        }

        chain.doFilter(request, response);
    }

    /**
     * Convenience method to test for GZIP cababilities
     * 
     * @param req
     *            The current user request
     * @return boolean indicating GZIP support
     */
    private boolean isGZIPSupported(HttpServletRequest req)
    {

        // disable gzip filter for exporting from displaytag
        String exporting = req.getParameter(TableTagParameters.PARAMETER_EXPORTING);

        if (exporting != null)
        {
            this.log.debug("detected excel export, disabling filter..."); //$NON-NLS-1$
            return false;
        }

        String browserEncodings = req.getHeader("accept-encoding"); //$NON-NLS-1$
        boolean supported = ((browserEncodings != null) && (browserEncodings.indexOf("gzip") != -1)); //$NON-NLS-1$

        String userAgent = req.getHeader("user-agent"); //$NON-NLS-1$

        if ((userAgent != null) && userAgent.startsWith("httpunit")) //$NON-NLS-1$
        {
            this.log.debug("httpunit detected, disabling filter..."); //$NON-NLS-1$

            return false;
        }
        return supported;
    }
}
