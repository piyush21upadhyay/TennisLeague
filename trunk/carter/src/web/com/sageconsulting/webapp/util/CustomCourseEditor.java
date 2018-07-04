/*
 * CustomCourseEditor.java
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

import com.sageconsulting.model.Course;

public class CustomCourseEditor extends PropertyEditorSupport
{
    private Map<Long, Course> courseMap;
    
    public CustomCourseEditor(List<Course> courses)
    {
        this.courseMap = new HashMap<Long, Course>(courses.size());
        for (Course course : courses)
        {
            this.courseMap.put(course.getId(), course);
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
            throw new IllegalArgumentException("Null course value"); //$NON-NLS-1$
        }
        Long id = getId(text);
        if (null == id)
        {
            throw new IllegalArgumentException("Invalid text: "+text); //$NON-NLS-1$
        }
        setValue(this.courseMap.get(getId(text)));
    }

    // This just seems wrong but for some reason, we get the toString() value of course
    // instead of the getAsText() value.  This will handle either one.
    // TODO: figure out why it is doing that in ResultsController
    private Long getId(String text)
    {
        Long id = null;
        int idx = text.indexOf("id="); //$NON-NLS-1$
        if (idx > 0)
        {
            idx += 3;
            int idx2 = text.indexOf("\r", idx); //$NON-NLS-1$
            String idStr = text.substring(idx, idx2);
            try
            {
                id = Long.valueOf(idStr);
            }
            catch (NumberFormatException e)
            {
                // nothing to do here. just return null
            }
        }
        else
        {
            try
            {
                id = Long.valueOf(text);
            }
            catch (NumberFormatException e)
            {
                // nothing to do here. just return null
            }
        }
        
        return id;
    }
    
    /**
     * 
     * @see java.beans.PropertyEditorSupport#getAsText()
     */
    @Override
    public String getAsText()
    {
        Object val = getValue();
        if ((null == val) || !(val instanceof Course))
        {
            return ""; //$NON-NLS-1$
        }
        return ((Course)val).getId().toString();
    }
}