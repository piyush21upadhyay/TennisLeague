/*
 * ConstantsTag.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.taglib;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sageconsulting.Constants;

/**
 * <p>
 * This class is designed to put all the public variables in a class to a
 * specified scope - designed for exposing a Constants class to Tag Libraries.
 * </p>
 * 
 * <p>
 * It is designed to be used as follows:
 * 
 * <pre>
 * &lt;tag:constants /&gt;
 * </pre>
 * 
 * </p>
 * 
 * <p>
 * Optional values are "className" (fully qualified) and "scope".
 * </p>
 * 
 * @jsp.tag name="constants" bodycontent="empty"
 *          tei-class="com.sageconsulting.webapp.taglib.ConstantsTei"
 */
public class ConstantsTag extends TagSupport
{
    private static final long serialVersionUID = 3258417209566116146L;

    private final Log log = LogFactory.getLog(ConstantsTag.class);

    /**
     * The class to expose the variables from.
     */
    public String clazz = Constants.class.getName();

    /**
     * The scope to be put the variable in.
     */
    protected String scope = null;

    /**
     * The single variable to expose.
     */
    protected String var = null;

    @SuppressWarnings("unchecked")
    @Override
    public int doStartTag() throws JspException
    {
        // Using reflection, get the available field names in the class
        Class c = null;
        int toScope = PageContext.PAGE_SCOPE;

        if (this.scope != null)
        {
            toScope = getScope(this.scope);
        }

        try
        {
            c = Class.forName(this.clazz);
        }
        catch (ClassNotFoundException cnf)
        {
            this.log.error("ClassNotFound - maybe a typo?"); //$NON-NLS-1$
            throw new JspException(cnf.getMessage());
        }

        try
        {
            // if var is null, expose all variables
            if (this.var == null)
            {
                Field[] fields = c.getDeclaredFields();

                AccessibleObject.setAccessible(fields, true);

                for (Field element : fields)
                {
                    /*
                     * if (log.isDebugEnabled()) { log.debug("putting '" +
                     * fields[i].getName() + "=" + fields[i].get(this) + "' into " +
                     * scope + " scope"); }
                     */
                    this.pageContext.setAttribute(element.getName(), element.get(this), toScope);
                }
            }
            else
            {
                try
                {
                    Object value = c.getField(this.var).get(this);
                    this.pageContext.setAttribute(c.getField(this.var).getName(), value, toScope);
                }
                catch (NoSuchFieldException nsf)
                {
                    this.log.error(nsf.getMessage());
                    throw new JspException(nsf);
                }
            }
        }
        catch (IllegalAccessException iae)
        {
            this.log.error("Illegal Access Exception - maybe a classloader issue?"); //$NON-NLS-1$
            throw new JspException(iae);
        }

        // Continue processing this page
        return (SKIP_BODY);
    }

    /**
     * @jsp.attribute
     */
    public void setClassName(String cls)
    {
        this.clazz = cls;
    }

    public String getClassName()
    {
        return this.clazz;
    }

    /**
     * @jsp.attribute
     */
    public void setScope(String scp)
    {
        this.scope = scp;
    }

    public String getScope()
    {
        return (this.scope);
    }

    /**
     * @jsp.attribute
     */
    public void setVar(String val)
    {
        this.var = val;
    }

    public String getVar()
    {
        return (this.var);
    }

    /**
     * Release all allocated resources.
     */
    @Override
    public void release()
    {
        super.release();
        this.clazz = null;
        this.scope = Constants.class.getName();
    }

    // ~========== From Struts' TagUtils class =====================

    /**
     * Maps lowercase JSP scope names to their PageContext integer constant
     * values.
     */
    private static final Map<String, Integer> scopes  = new HashMap<String, Integer>();

    /**
     * Initialize the scope names map and the encode variable with the Java 1.4
     * method if available.
     */
    static
    {
        scopes.put("page", new Integer(PageContext.PAGE_SCOPE)); //$NON-NLS-1$
        scopes.put("request", new Integer(PageContext.REQUEST_SCOPE)); //$NON-NLS-1$
        scopes.put("session", new Integer(PageContext.SESSION_SCOPE)); //$NON-NLS-1$
        scopes.put("application", new Integer(PageContext.APPLICATION_SCOPE)); //$NON-NLS-1$
    }

    /**
     * Converts the scope name into its corresponding PageContext constant
     * value.
     * 
     * @param scopeName Can be "page", "request", "session", or "application" in any case.
     * @return The constant representing the scope (ie. PageContext.REQUEST_SCOPE).
     * @throws JspException if the scopeName is not a valid name.
     */
    public int getScope(String scopeName) throws JspException
    {
        Integer curScope = scopes.get(scopeName.toLowerCase());

        if (curScope == null)
        {
            throw new JspException("Scope '" + scopeName + "' not a valid option"); //$NON-NLS-1$ //$NON-NLS-2$
        }

        return curScope.intValue();
    }
}
