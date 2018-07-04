/*
 * BaseResourceTag.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.taglib;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.web.servlet.support.RequestContext;

/**
 * This is a base class for tags that need to get a localized resource
 * string by key.  It exposes a 'key' property that is required
 * and that is used to look up the resource.
 *
 */
abstract public class BaseResourceTag extends TagSupport
{
	private static final long serialVersionUID = -4733173564582988681L;

	private String key;
	private RequestContext requestContext;
	
	protected String getKey()
	{
		return this.key;
	}
	
    /**
     * @jsp.attribute required="true" rtexprvalue="false"
     */
	public void setKey(String k)
	{
		this.key = k;
	}
	
	/**
	 * Get the current request context.
	 * @return The current request context.
	 */
	protected RequestContext getRequestContext()
	{
		if (null != this.requestContext)
		{
			return this.requestContext;
		}
		
        try
        {
            this.requestContext = new RequestContext((HttpServletRequest) this.pageContext.getRequest());
        }
        catch (RuntimeException ex)
        {
            throw ex;
        }
        catch (Exception ex)
        {
            this.pageContext.getServletContext().log("Exception in custom tag", ex); //$NON-NLS-1$
        }
        return this.requestContext;
	}

    /**
     * Use the application context itself for default message resolution.
     */
    protected MessageSource getMessageSource()
    {
        return getRequestContext().getWebApplicationContext();
    }
    
    protected String getResourceString()
    {
        Locale locale = this.pageContext.getRequest().getLocale();
        String message = null;
        try
        {
            message = getMessageSource().getMessage(this.key, null, locale);
        }
        catch (NoSuchMessageException nsm)
        {
            message = "???" + this.key + "???"; //$NON-NLS-1$ //$NON-NLS-2$
        }
        return message;
    }

    /**
     * Release all allocated resources.
     */
    @Override
    public void release()
    {
        super.release();
        this.key = null;
    }

}
