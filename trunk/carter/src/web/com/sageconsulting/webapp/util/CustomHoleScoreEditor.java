/*
 * CustomHoleScoreEditor.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.util;

import java.beans.PropertyEditorSupport;

public class CustomHoleScoreEditor extends PropertyEditorSupport
{
    /**
     * 
     * @see java.beans.PropertyEditorSupport#setAsText(java.lang.String)
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException
    {
        Byte b = null;
        if (null != text)
        {
            try
            {
                b = Byte.valueOf(text);
            }
            catch (NumberFormatException e)
            {
                b = Byte.valueOf((byte)0);
            }
        }
        setValue(b);
    }
    
    @Override
    public String getAsText()
    {
        Object val = getValue();
        return (null == val) ? "" : val.toString(); //$NON-NLS-1$
    }
}
