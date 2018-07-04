/*
 * BaseFormController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sageconsulting.Constants;
import com.sageconsulting.model.User;
import com.sageconsulting.service.MailEngine;
import com.sageconsulting.service.UserManager;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Implementation of <strong>SimpleFormController</strong> that contains
 * convenience methods for subclasses. For example, getting the current user and
 * saving messages/errors. This class is intended to be a base class for all
 * Form controllers.
 */
public class BaseFormController extends SimpleFormController
{
    protected final transient Log log = LogFactory.getLog(getClass());

    protected final String MESSAGES_KEY = "successMessages"; //$NON-NLS-1$

    private UserManager userManager = null;
    protected MailEngine mailEngine = null;
    protected SimpleMailMessage message = null;
    protected String templateName = null;
    protected String cancelView;

    public void setUserManager(UserManager mgr)
    {
        this.userManager = mgr;
    }

    public UserManager getUserManager()
    {
        return this.userManager;
    }

    @SuppressWarnings("unchecked")
    public void saveMessage(HttpServletRequest request, String msg)
    {
        List<String> messages = (List<String>)request.getSession().getAttribute(this.MESSAGES_KEY);

        if (messages == null)
        {
            messages = new ArrayList<String>();
        }

        messages.add(msg);
        request.getSession().setAttribute(this.MESSAGES_KEY, messages);
    }

    /**
     * Convenience method for getting a i18n key's value. Calling
     * getMessageSourceAccessor() is used because the RequestContext variable is
     * not set in unit tests b/c there's no DispatchServlet Request.
     * 
     * @param msgKey
     * @param locale the current locale
     * @return
     */
    public String getText(String msgKey, Locale locale)
    {
        return getMessageSourceAccessor().getMessage(msgKey, locale);
    }

    /**
     * Convenient method for getting a i18n key's value with a single string
     * argument.
     * 
     * @param msgKey
     * @param arg
     * @param locale the current locale
     * @return
     */
    public String getText(String msgKey, String arg, Locale locale)
    {
        return getText(msgKey, new Object[] { arg }, locale);
    }

    /**
     * Convenience method for getting a i18n key's value with arguments.
     * 
     * @param msgKey
     * @param args
     * @param locale
     *            the current locale
     * @return
     */
    public String getText(String msgKey, Object[] args, Locale locale)
    {
        return getMessageSourceAccessor().getMessage(msgKey, args, locale);
    }

    /**
     * Convenience method to get the Configuration HashMap from the servlet
     * context.
     * 
     * @return the user's populated form from the session
     */
    @SuppressWarnings("unchecked")
    public Map getConfiguration()
    {
        Map config = (HashMap)getServletContext().getAttribute(Constants.CONFIG);

        // so unit tests don't puke when nothing's been set
        if (config == null)
        {
            return new HashMap();
        }

        return config;
    }

    /**
     * Default behavior for FormControllers - redirect to the successView when
     * the cancel button has been pressed.
     */
    @Override
    public ModelAndView processFormSubmission(HttpServletRequest request, HttpServletResponse response, Object command,
        BindException errors) throws Exception
    {
        if (request.getParameter("cancel") != null) //$NON-NLS-1$
        {
            return new ModelAndView(getCancelView());
        }

        return super.processFormSubmission(request, response, command, errors);
    }

    /**
     * Set up a custom property editor for converting form inputs to real
     * objects
     */
    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
    {
        binder.registerCustomEditor(Integer.class, null, new CustomNumberEditor(Integer.class, null, true));
        binder.registerCustomEditor(Long.class, null, new CustomNumberEditor(Long.class, null, true));
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
        SimpleDateFormat dateFormat = new SimpleDateFormat(getText("date.format", request.getLocale())); //$NON-NLS-1$
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null, new CustomDateEditor(dateFormat, true));
    }

    /**
     * Convenience message to send messages to users, includes app URL as
     * footer.
     * 
     * @param user
     * @param msg
     * @param url
     */
    protected void sendUserMessage(User user, String msg, String url)
    {
        if (this.log.isDebugEnabled())
        {
            this.log.debug("sending e-mail to user [" + user.getEmail() + "]..."); //$NON-NLS-1$ //$NON-NLS-2$
        }

        this.message.setTo(user.getFullName() + "<" + user.getEmail() + ">"); //$NON-NLS-1$ //$NON-NLS-2$

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("user", user); //$NON-NLS-1$

        // TODO: once you figure out how to get the global resource bundle in
        // WebWork, then figure it out here too. In the meantime, the Username
        // and Password labels are hard-coded into the template.
        // model.put("bundle", getTexts());
        model.put("message", msg); //$NON-NLS-1$
        model.put("applicationURL", url); //$NON-NLS-1$
        this.mailEngine.sendMessage(this.message, this.templateName, model);
    }

    public void setMailEngine(MailEngine engine)
    {
        this.mailEngine = engine;
    }

    public void setMessage(SimpleMailMessage msg)
    {
        this.message = msg;
    }

    public void setTemplateName(String template)
    {
        this.templateName = template;
    }

    /**
     * Indicates what view to use when the cancel button has been pressed.
     */
    public final void setCancelView(String view)
    {
        this.cancelView = view;
    }

    public final String getCancelView()
    {
        // Default to successView if cancelView is invalid
        if ((this.cancelView == null) || (this.cancelView.length() == 0))
        {
            return getSuccessView();
        }
        return this.cancelView;
    }

}
