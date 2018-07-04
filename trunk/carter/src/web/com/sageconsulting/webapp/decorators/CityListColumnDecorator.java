/*
 * CityListColumnDecorator.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.decorators;

import java.util.List;

import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;

import com.sageconsulting.model.City;

public final class CityListColumnDecorator implements DisplaytagColumnDecorator
{
    @SuppressWarnings("unchecked")
    public Object decorate(Object cityList, PageContext pageContext, MediaTypeEnum mediaType) throws DecoratorException
    {
        List<City> cities = (List<City>)cityList;
        StringBuilder sb = new StringBuilder();
        
        if (null != cities)
        {
            for (City city : cities)
            {
                if (sb.length() > 0)
                {
                    sb.append(", "); //$NON-NLS-1$
                }
                sb.append(city.getName());
            }
        }
        return sb.toString();
    }
}