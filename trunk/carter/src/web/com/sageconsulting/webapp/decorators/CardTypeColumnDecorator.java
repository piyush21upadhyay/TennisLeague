/*
 * CardTypeColumnDecorator.java
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

public class CardTypeColumnDecorator implements DisplaytagColumnDecorator
{
    public Object decorate(Object state, PageContext pageContext, MediaTypeEnum mediaType) throws DecoratorException
    {
        Integer regState = (Integer)state;
        switch (regState.intValue())
        {
            case 1:
                return LocaleSupport.getLocalizedMessage(pageContext, "registrationEntry.visa"); //$NON-NLS-1$
            case 2:
                return LocaleSupport.getLocalizedMessage(pageContext, "registrationEntry.mastercard"); //$NON-NLS-1$
        }
        return ""; //$NON-NLS-1$
    }
}
