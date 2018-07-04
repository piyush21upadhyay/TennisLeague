/*
 * CustomUserEditor.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.util;

import java.beans.PropertyEditorSupport;

import com.sageconsulting.model.User;
import com.sageconsulting.service.UserManager;

public class CustomUserEditor extends PropertyEditorSupport
{
    private UserManager userManager;
    
    public CustomUserEditor(UserManager mgr)
    {
        super();
        this.userManager = mgr;
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
            throw new IllegalArgumentException("Null user value"); //$NON-NLS-1$
        }
        setValue(this.userManager.getUser(text));
    }
    
    /**
     * 
     * @see java.beans.PropertyEditorSupport#getAsText()
     */
    @Override
    public String getAsText()
    {
        Object val = getValue();
        if ((null == val) || !(val instanceof User))
        {
            return ""; //$NON-NLS-1$
        }
        return ((User)val).getId().toString();
    }
}
