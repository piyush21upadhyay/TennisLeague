/*
 * HomeAwayColumnDecorator.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.decorators;

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.jstl.fmt.LocaleSupport;

import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;

public class HomeAwayColumnDecorator implements DisplaytagColumnDecorator
{
    public Object decorate(Object value, PageContext pageContext, MediaTypeEnum mediaType) throws DecoratorException
    {
        Boolean home = (Boolean)value;
        if (home.booleanValue())
        {
            return LocaleSupport.getLocalizedMessage(pageContext, "schedule.home"); //$NON-NLS-1$
        }
        return LocaleSupport.getLocalizedMessage(pageContext, "schedule.away"); //$NON-NLS-1$
    }
}
