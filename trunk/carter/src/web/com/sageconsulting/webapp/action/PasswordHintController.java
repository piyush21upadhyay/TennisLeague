/*
 * PasswordHintController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sageconsulting.model.User;
import com.sageconsulting.service.MailEngine;
import com.sageconsulting.service.UserManager;
import com.sageconsulting.webapp.util.RequestUtil;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * Simple class to retrieve and send a password hint to users.
 */
public class PasswordHintController implements Controller
{
    private transient final Log log = LogFactory.getLog(PasswordHintController.class);

    private UserManager mgr = null;
    private MessageSource messageSource = null;
    protected MailEngine mailEngine = null;
    protected SimpleMailMessage message = null;
    String forgotPWDmsg="";

    public void setUserManager(UserManager userManager)
    {
        this.mgr = userManager;
    }

    public void setMessageSource(MessageSource source)
    {
        this.messageSource = source;
    }

    public void setMailEngine(MailEngine engine)
    {
        this.mailEngine = engine;
    }

    public void setMessage(SimpleMailMessage msg)
    {
        this.message = msg;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        if (this.log.isDebugEnabled())
        {
            this.log.debug("entering 'handleRequest' method..."); //$NON-NLS-1$
        }

        String username = request.getParameter("username"); //$NON-NLS-1$
        MessageSourceAccessor text = new MessageSourceAccessor(this.messageSource, request.getLocale());

        // ensure that the username has been sent
        if (username == null)
        {
            this.log.warn("Username not specified, notifying user that it's a required field."); //$NON-NLS-1$

            request.setAttribute("error", text.getMessage("errors.required", //$NON-NLS-1$ //$NON-NLS-2$
                new Object[] { text.getMessage("user.username") })); //$NON-NLS-1$

            return new ModelAndView("login"); //$NON-NLS-1$
        }

        if (this.log.isDebugEnabled())
        {
            this.log.debug("Processing Password Hint..."); //$NON-NLS-1$
        }

        // look up the user's information
        try
        {
            List <User> user =this.mgr.getUserByUsername1(username);
            
            if(user.size()!=0)
            {
				StringBuffer msg = new StringBuffer();
				msg.append("Your password hint is: " +user.get(0).getPasswordHint()); //$NON-NLS-1$
				String url="<a href=\""+RequestUtil.getAppURL(request)+"\">"+"CITY TENNIS LEAGUE"+"</a>";
				//msg.append("\n\nLogin at: " + RequestUtil.getAppURL(request)); //$NON-NLS-1$
				msg.append("\n\nLogin at: " + url); //$NON-NLS-1$

				this.message.setTo(user.get(0).getEmail());
				String subject = '[' + text.getMessage("webapp.name") + "] " + //$NON-NLS-1$ //$NON-NLS-2$
                text.getMessage("user.passwordHint"); //$NON-NLS-1$
				this.message.setSubject(subject);
				this.message.setText(msg.toString());
				this.mailEngine.send(this.message);

				saveMessage(request, text.getMessage("login.passwordHint.sent", //$NON-NLS-1$
                new Object[] { username, user.get(0).getEmail() }));
				forgotPWDmsg="please check your mail.";
			}
			else
            {
				forgotPWDmsg="No account found with that username.";
            }
        }
        catch (Exception e)
        {
            saveError(request, text.getMessage("login.passwordHint.error", //$NON-NLS-1$
                new Object[] { username }));
        }
        
        ModelAndView mv =new ModelAndView("forgotSuccess");
        mv.addObject("username1", forgotPWDmsg);
        return mv; 
    }

    @SuppressWarnings("unchecked")
    public void saveError(HttpServletRequest request, String error)
    {
        List<String> errors = (List<String>)request.getSession().getAttribute("errors"); //$NON-NLS-1$
        if (errors == null)
        {
            errors = new ArrayList<String>();
        }
        errors.add(error);
        request.getSession().setAttribute("errors", errors); //$NON-NLS-1$
    }

    // this method is also in BaseForm Controller
    @SuppressWarnings("unchecked")
    public void saveMessage(HttpServletRequest request, String msg)
    {
        List<String> messages = (List<String>)request.getSession().getAttribute("messages"); //$NON-NLS-1$
        if (messages == null)
        {
            messages = new ArrayList<String>();
        }
        messages.add(msg);
        request.getSession().setAttribute("messages", messages); //$NON-NLS-1$
    }
}
