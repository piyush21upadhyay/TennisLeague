package com.sageconsulting.webapp.util;

import java.beans.PropertyEditorSupport;

public class CustomHandicapEditor extends PropertyEditorSupport
{
    /**
     * 
     * @see java.beans.PropertyEditorSupport#setAsText(java.lang.String)
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException
    {
        Double value = Double.valueOf(0.0);
        if (null != text)
        {
            try
            {
                String trimmed = text.trim();
                if (trimmed.charAt(0) == '+')
                {
                	trimmed = trimmed.replace('+', '-');
                }
                value = Double.valueOf(trimmed);
            }
            catch (NumberFormatException e)
            {
                //ignore and return 0.0
            }
        }
        setValue(value);
    }
    
    @Override
    public String getAsText()
    {
        Object val = getValue();
        if (val instanceof Double)
        {
        	double dblVal = ((Double)val).doubleValue();
        	StringBuilder sb = new StringBuilder(val.toString());
        	if (dblVal < 0)
        	{
        		sb.replace(0, 1, "+"); //$NON-NLS-1$
        	}
        	return sb.toString();
        }
        return ""; //$NON-NLS-1$
    }
}
