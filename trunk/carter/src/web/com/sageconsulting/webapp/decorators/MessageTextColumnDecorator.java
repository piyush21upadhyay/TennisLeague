/*
 * MessageTextColumnDecorator.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.decorators;

import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;

/**
 * This is used to render the text in columns by truncating it and adding an ellipsis
 * if the text is to long to fit in the column.
 */
public class MessageTextColumnDecorator implements DisplaytagColumnDecorator
{
	private static final int MAX_LEN = 16;
	
	public Object decorate(Object object, PageContext pageContext, MediaTypeEnum mediaType) throws DecoratorException
	{
		if (object instanceof String)
		{
			return updateColumnElement((String)object);
		}
		return object;
	}

	private String updateColumnElement(String s)
	{
		if (isLink(s))
		{
			return updateLink(s);
		}
		return updateText(s);
	}
	
	private boolean isLink(String s)
	{
		return s.contains("<a"); //$NON-NLS-1$
	}
	
	private String updateLink(String s)
	{
		StringBuilder sb = new StringBuilder(s.trim());
		
		int txtStart = sb.indexOf(">") + 1; //$NON-NLS-1$
		int txtEnd = sb.indexOf("<", txtStart); //$NON-NLS-1$
		String subText = sb.substring(txtStart, txtEnd).trim();
		if (subText.length() > MAX_LEN)
		{
			String txt = subText.substring(0, MAX_LEN-1);
			sb.delete(txtStart, txtEnd);
			sb.insert(txtStart, txt + "&hellip;"); //$NON-NLS-1$
		}
		
		return sb.toString();
	}
	
	private String updateText(String s)
	{
		StringBuilder sb = new StringBuilder(s.trim());
		if (sb.length() > MAX_LEN)
		{
			return sb.substring(0, MAX_LEN-1) + "&hellip;"; //$NON-NLS-1$
		}
		
		return sb.toString();
	}
}
