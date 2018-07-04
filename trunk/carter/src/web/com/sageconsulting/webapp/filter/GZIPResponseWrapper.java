/*
 * GZIPResponseWrapper.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.filter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Wraps Response for GZipFilter
 */
public class GZIPResponseWrapper extends HttpServletResponseWrapper
{
    private static final Log log = LogFactory.getLog(GZIPResponseWrapper.class);

    protected HttpServletResponse origResponse = null;
    protected ServletOutputStream stream = null;
    protected PrintWriter writer = null;
    protected int error = 0;

    public GZIPResponseWrapper(HttpServletResponse response)
    {
        super(response);
        this.origResponse = response;
    }

    public ServletOutputStream createOutputStream() throws IOException
    {
        return (new GZIPResponseStream(this.origResponse));
    }

    public void finishResponse()
    {
        try
        {
            if (this.writer != null)
            {
                this.writer.close();
            }
            else
            {
                if (this.stream != null)
                {
                    this.stream.close();
                }
            }
        }
        catch (IOException e)
        {
            log.error("Caught exception trying to close output stream.", e); //$NON-NLS-1$
        }
    }

    @Override
    public void flushBuffer() throws IOException
    {
        if (this.stream != null)
        {
            this.stream.flush();
        }
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException
    {
        if (this.writer != null)
        {
            throw new IllegalStateException("getWriter() has already been called!"); //$NON-NLS-1$
        }

        if (this.stream == null)
        {
            this.stream = createOutputStream();
        }

        return (this.stream);
    }

    @Override
    public PrintWriter getWriter() throws IOException
    {
        if ((this.origResponse != null) && this.origResponse.isCommitted())
        {
            return super.getWriter();
        }

        if (this.writer != null)
        {
            return (this.writer);
        }

        if (this.stream != null)
        {
            throw new IllegalStateException("getOutputStream() has already been called!"); //$NON-NLS-1$
        }

        this.stream = createOutputStream();
        this.writer = new PrintWriter(new OutputStreamWriter(this.stream, this.origResponse.getCharacterEncoding()));

        return (this.writer);
    }

    @Override
    public void setContentLength(int length)
    {
        // nothing to do
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#sendError(int,
     *      java.lang.String)
     */
    @Override
    public void sendError(int err, String message) throws IOException
    {
        super.sendError(err, message);
        this.error = err;

        if (log.isDebugEnabled())
        {
            log.debug("sending error: " + err + " [" + message + "]"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        }
    }
}
