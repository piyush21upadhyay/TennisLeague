/*
 * EscapeHtmlEntities.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.buildtools;

import java.io.IOException;
import java.io.Reader;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.tools.ant.filters.BaseParamFilterReader;
import org.apache.tools.ant.filters.ChainableReader;

public class EscapeHtmlEntities extends BaseParamFilterReader implements ChainableReader
{
    public static final String ESCAPE = "escape"; //$NON-NLS-1$
    public static final String UNESCAPE = "unescape"; //$NON-NLS-1$

    /** Data that must be read from, if not null. */
    private String queuedData = null;
    private String mode;

    public EscapeHtmlEntities()
    {
        super();
    }

    public EscapeHtmlEntities(final Reader rdr)
    {
        super(rdr);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.io.FilterReader#read()
     */
    @Override
    public int read() throws IOException
    {
        int ch = -1;

        if ((this.queuedData != null) && (this.queuedData.length() == 0))
        {
            this.queuedData = null;
        }

        if (this.queuedData != null)
        {
            ch = this.queuedData.charAt(0);
            this.queuedData = this.queuedData.substring(1);
            if (this.queuedData.length() == 0)
            {
                this.queuedData = null;
            }
        }
        else
        {
            this.queuedData = readFully();
            if (this.queuedData == null)
            {
                ch = -1;
            }
            else
            {
                this.queuedData = handleEntities(this.queuedData);
                return read();
            }
        }
        return ch;
    }

    /**
     * @param queuedData2
     * @return
     */
    private String handleEntities(String queuedData2)
    {
        if (ESCAPE.equalsIgnoreCase(this.mode))
        {
            return StringEscapeUtils.escapeHtml(queuedData2);
        }
        return StringEscapeUtils.unescapeHtml(queuedData2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.tools.ant.filters.ChainableReader#chain(java.io.Reader)
     */
    public Reader chain(Reader rdr)
    {
        EscapeHtmlEntities filter = new EscapeHtmlEntities(rdr);
        return filter;
    }

    /**
     * @return Returns the mode.
     */
    public String getMode()
    {
        return this.mode;
    }

    /**
     * @param m
     *            The mode to set.
     */
    public void setMode(String m)
    {
        this.mode = m;
    }

}
