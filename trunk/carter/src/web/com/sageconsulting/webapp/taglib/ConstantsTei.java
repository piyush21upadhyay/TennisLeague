/*
 * ConstantsTei.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.taglib;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sageconsulting.Constants;

/**
 * Implementation of <code>TagExtraInfo</code> for the <b>constants</b> tag,
 * identifying the scripting object(s) to be made visible.
 */
public class ConstantsTei extends TagExtraInfo
{
    private final Log log = LogFactory.getLog(ConstantsTei.class);

    /**
     * Return information about the scripting variables to be created.
     */
    @Override
    public VariableInfo[] getVariableInfo(TagData data)
    {
        // loop through and expose all attributes
        List<VariableInfo> vars = new ArrayList<VariableInfo>();

        try
        {
            String clazz = data.getAttributeString("className"); //$NON-NLS-1$

            if (clazz == null)
            {
                clazz = Constants.class.getName();
            }

            Class<?> c = Class.forName(clazz);

            // if no var specified, get all
            if (data.getAttributeString("var") == null) //$NON-NLS-1$
            {
                Field[] fields = c.getDeclaredFields();

                AccessibleObject.setAccessible(fields, true);

                for (Field element : fields)
                {
                    String type = element.getType().getName();
                    vars.add(new VariableInfo(element.getName(), ((element.getType().isArray()) ?
                        type.substring(2, type.length() - 1) + "[]" : type), true, VariableInfo.AT_END)); //$NON-NLS-1$
                }
            }
            else
            {
                String var = data.getAttributeString("var"); //$NON-NLS-1$
                String type = c.getField(var).getType().getName();
                vars.add(new VariableInfo(c.getField(var).getName(), ((c.getField(var).getType().isArray()) ?
                    type.substring(2, type.length() - 1) + "[]" : //$NON-NLS-1$
                    type), true, VariableInfo.AT_END));
            }
        }
        catch (Exception cnf)
        {
            this.log.error(cnf.getMessage());
            cnf.printStackTrace();
        }

        return vars.toArray(new VariableInfo[] {});
    }
}
