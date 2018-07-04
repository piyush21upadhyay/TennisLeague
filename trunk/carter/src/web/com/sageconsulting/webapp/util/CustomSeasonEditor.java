/*
 * CustomSeasonEditor.java
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

import com.sageconsulting.model.Season;

public class CustomSeasonEditor extends PropertyEditorSupport
{
    private Map<Long, Season> seasonMap;
    
    public CustomSeasonEditor(List<Season> seasons)
    {
        this.seasonMap = new HashMap<Long, Season>(seasons.size());
        for (Season season : seasons)
        {
            this.seasonMap.put(season.getId(), season);
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
            throw new IllegalArgumentException("Null season value"); //$NON-NLS-1$
        }
        else if (text.length() == 0)
        {
            setValue(null);
            return;
        }
        setValue(this.seasonMap.get(Long.valueOf(text)));
    }
    
    /**
     * 
     * @see java.beans.PropertyEditorSupport#getAsText()
     */
    @Override
    public String getAsText()
    {
        Object val = getValue();
        if ((null == val) || !(val instanceof Season))
        {
            return ""; //$NON-NLS-1$
        }
        return ((Season)val).getId().toString();
    }
}
