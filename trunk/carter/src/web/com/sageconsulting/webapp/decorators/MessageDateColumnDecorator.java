/*
 * MessageDateColumnDecorator.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.decorators;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;

public class MessageDateColumnDecorator implements DisplaytagColumnDecorator
{
    public Object decorate(Object object, PageContext pageContext, MediaTypeEnum mediaType) throws DecoratorException
    {
        if (null == object)
        {
            return ""; //$NON-NLS-1$
        }
        if (object instanceof Date)
        {
            return DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT,
            	Locale.getDefault()).format((Date)object);
        }
        if (object instanceof Timestamp)
        {
        	Date d = new Date(((Timestamp)object).getTime());
            return DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT,
            	Locale.getDefault()).format(d);
        }
        return object.toString();
    }
}
