/*
 * MatchDateColumnDecorator.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.decorators;

import java.text.DateFormat;
import java.util.Date;

import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;

public class MatchDateColumnDecorator implements DisplaytagColumnDecorator
{
    public Object decorate(Object object, PageContext pageContext, MediaTypeEnum mediaType) throws DecoratorException
    {
        if (null == object)
        {
            return ""; //$NON-NLS-1$
        }
        if (object instanceof Date)
        {
            return DateFormat.getDateInstance().format((Date)object);
        }
        return object.toString();
    }
}
