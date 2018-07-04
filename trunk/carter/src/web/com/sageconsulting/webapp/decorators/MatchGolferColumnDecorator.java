/*
 * MatchGolferColumnDecorator.java
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

public class MatchGolferColumnDecorator implements DisplaytagColumnDecorator
{
    public static final String BYE = "byeAttribute"; //$NON-NLS-1$
    
    public Object decorate(Object object, PageContext pageContext, MediaTypeEnum mediaType) throws DecoratorException
    {
        String name = (String)object;
        if (null == name)
        {
            return pageContext.getRequest().getAttribute(BYE);
        }
        return name;
    }
}
