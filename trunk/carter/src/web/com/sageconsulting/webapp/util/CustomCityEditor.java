/*
 * CustomCityEditor.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.util;

import java.beans.PropertyEditorSupport;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sageconsulting.model.City;

public class CustomCityEditor extends PropertyEditorSupport
{
    private Map<Long, City> cityMap;
    
    public CustomCityEditor(List<City> cities)
    {
        this.cityMap = new HashMap<Long, City>(cities.size());
        for (City city : cities)
        {
            this.cityMap.put(city.getId(), city);
        }
    }
    
    /**
     * 
     * @see java.beans.PropertyEditorSupport#setAsText(java.lang.String)
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException
    {
        if (null == text)
        {
            throw new IllegalArgumentException("Null city value"); //$NON-NLS-1$
        }
        setValue(this.cityMap.get(Long.valueOf(text)));
    }
    
    /**
     * 
     * @see java.beans.PropertyEditorSupport#getAsText()
     */
    @Override
    public String getAsText()
    {
        Object val = getValue();
        if ((null == val) || !(val instanceof City))
        {
            return ""; //$NON-NLS-1$
        }
        return ((City)val).getId().toString();
    }
}