/*
 * LabelTag.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.taglib;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.Field;
import org.apache.commons.validator.Form;
import org.apache.commons.validator.ValidatorResources;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.validation.Errors;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.DispatcherServlet;
import org.springmodules.validation.commons.ValidatorFactory;

/**
 * <p>
 * This class is designed to render a <label> tag for labeling your forms and
 * adds an asterik (*) for required fields. It was originally written by Erik
 * Hatcher (http://www.ehatchersolutions.com/JavaDevWithAnt/).
 * 
 * <p>
 * It is designed to be used as follows:
 * 
 * <pre>
 * &lt;tag:label key=&quot;userForm.username&quot;/&gt;
 * </pre>
 * 
 * @jsp.tag name="label" bodycontent="empty"
 */
public class LabelTag extends BaseResourceTag
{
    private static final long serialVersionUID = -5310144023136517119L;

    protected transient final Log log = LogFactory.getLog(LabelTag.class);

    protected String styleClass = null;
    protected String errorClass = null;
    protected boolean colon = false;

    @SuppressWarnings("unchecked")
    @Override
    public int doStartTag() throws JspException
    {
        // Look up this key to see if its a field of the current form
        boolean requiredField = false;
        boolean validationError = false;

        ValidatorResources resources = getValidatorResources();

        Locale locale = this.pageContext.getRequest().getLocale();

        if (locale == null)
        {
            locale = Locale.getDefault();
        }

        // get the name of the bean from the key
        String formName = getKey().substring(0, getKey().indexOf('.'));
        String fieldName = getKey().substring(formName.length() + 1);

        if (resources != null)
        {
            Form form = resources.getForm(locale, formName);

            if (form != null)
            {
                Field field = form.getField(fieldName);

                if (field != null)
                {
                    if (field.isDependency("required") || field.isDependency("validwhen")) //$NON-NLS-1$ //$NON-NLS-2$
                    {
                        requiredField = true;
                    }
                }
            }
        }

        Errors errors = getRequestContext().getErrors(formName, false);
        List fes = null;
        if (errors != null)
        {
            fes = errors.getFieldErrors(fieldName);
            // String errorMsg = getErrorMessages(fes);
        }

        if ((fes != null) && (fes.size() > 0))
        {
            validationError = true;
        }

        // Retrieve the message string we are looking for
    	String text = super.getResourceString();

        String cssClass = null;
        if (this.styleClass != null)
        {
            cssClass = this.styleClass;
        }
        else if (requiredField)
        {
            cssClass = "required"; //$NON-NLS-1$
        }

        String cssErrorClass = (this.errorClass != null) ? this.errorClass : "error"; //$NON-NLS-1$
        StringBuffer label = new StringBuffer();

        if ((text == null) || "".equals(text.trim())) //$NON-NLS-1$
        {
            label.append(""); //$NON-NLS-1$
        }
        else
        {
            label.append("<label for=\"").append(fieldName).append("\""); //$NON-NLS-1$ //$NON-NLS-2$

            if (validationError)
            {
                label.append(" class=\"").append(cssErrorClass).append("\""); //$NON-NLS-1$ //$NON-NLS-2$
            }
            else if (cssClass != null)
            {
                label.append(" class=\"").append(cssClass).append("\""); //$NON-NLS-1$ //$NON-NLS-2$
            }

            label.append(">").append(text); //$NON-NLS-1$
            label.append((requiredField) ? " <span class=\"req\">*</span>" : ""); //$NON-NLS-1$ //$NON-NLS-2$
            label.append((this.colon) ? ":" : ""); //$NON-NLS-1$ //$NON-NLS-2$
            label.append("</label>"); //$NON-NLS-1$

            if (validationError)
            {
                label.append("<img class=\"validationWarning\" alt=\""); //$NON-NLS-1$
                label.append(getMessageSource().getMessage("icon.warning", null, locale)); //$NON-NLS-1$
                label.append("\""); //$NON-NLS-1$

                String context = ((HttpServletRequest) this.pageContext.getRequest()).getContextPath();

                label.append("src=\"" + context); //$NON-NLS-1$
                label.append(getMessageSource().getMessage("icon.warning.img", null, locale)); //$NON-NLS-1$
                label.append("\" />"); //$NON-NLS-1$
            }
        }

        // Print the retrieved message to our output writer
        try
        {
            writeMessage(label.toString());
        }
        catch (IOException io)
        {
            io.printStackTrace();
            throw new JspException("Error writing label: " + io.getMessage()); //$NON-NLS-1$
        }

        // Continue processing this page
        return (SKIP_BODY);
    }

    /**
     * Extract the error messages from the given ObjectError list.
     */
    /*
     * private String getErrorMessages(List fes) throws NoSuchMessageException {
     * StringBuffer message = new StringBuffer(); for (int i = 0; i <
     * fes.size(); i++) { ObjectError error = (ObjectError) fes.get(i);
     * message.append(this.requestContext.getMessage(error, true)); } return
     * message.toString(); }
     */

    /**
     * Write the message to the page.
     * 
     * @param msg
     *            the message to write
     * @throws IOException
     *             if writing failed
     */
    protected void writeMessage(String msg) throws IOException
    {
        this.pageContext.getOut().write(msg);
    }

    /**
     * Setter for specifying whether to include colon
     * 
     * @jsp.attribute required="false" rtexprvalue="true"
     */
    public void setColon(boolean c)
    {
        this.colon = c;
    }

    /**
     * Setter for assigning a CSS class, default is label.
     * 
     * @jsp.attribute required="false" rtexprvalue="true"
     */
    public void setStyleClass(String style)
    {
        this.styleClass = style;
    }

    /**
     * Setter for assigning a CSS class when errors occur, defaults to
     * labelError.
     * 
     * @jsp.attribute required="false" rtexprvalue="true"
     */
    public void setErrorClass(String errorCls)
    {
        this.errorClass = errorCls;
    }

    /**
     * Release all allocated resources.
     */
    @Override
    public void release()
    {
        super.release();
        this.colon = false;
        this.styleClass = null;
        this.errorClass = null;
    }

    /**
     * Get the validator resources from a ValidatorFactory defined in the web
     * application context or one of its parent contexts. The bean is resolved
     * by type (org.springframework.validation.commons.ValidatorFactory).
     * 
     * @return ValidatorResources from a ValidatorFactory.
     */
    private ValidatorResources getValidatorResources()
    {
        // look in servlet beans definition (i.e. action-servlet.xml)
        WebApplicationContext ctx = (WebApplicationContext) this.pageContext.getRequest().getAttribute(
            DispatcherServlet.WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        ValidatorFactory factory = null;
        try
        {
            factory = (ValidatorFactory) BeanFactoryUtils.beanOfTypeIncludingAncestors(ctx, ValidatorFactory.class,
                true, true);
        }
        catch (NoSuchBeanDefinitionException e)
        {
            // look in main application context (i.e. applicationContext.xml)
            ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this.pageContext.getServletContext());
            factory = (ValidatorFactory) BeanFactoryUtils.beanOfTypeIncludingAncestors(ctx, ValidatorFactory.class,
                true, true);
        }
        return factory.getValidatorResources();
    }
}
