/*
 * AdminInboxController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.sageconsulting.model.PrivateMessage;
import com.sageconsulting.service.PrivatemessageManager;

/**
 * @author PRC9041
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class AdminInboxController extends BaseFormController
{
    private PrivatemessageManager mailManager;

    public AdminInboxController()
    {
        this.setCommandClass(PrivateMessage.class);
        this.setCommandName("privateMessage"); //$NON-NLS-1$
    }

    /**
     * @return Returns the mailManager.
     */
    public PrivatemessageManager getMailManager()
    {
        return this.mailManager;
    }

    /**
     * @param mailManager The mailManager to set.
     */
    public void setMailManager(PrivatemessageManager mgr)
    {
        this.mailManager = mgr;
    }

    @Override
    public ModelAndView processFormSubmission(HttpServletRequest request, HttpServletResponse response, Object command,
        BindException errors) throws Exception
    {
        List<PrivateMessage> messages = this.mailManager.getAllMessageFromAllUsers();
        for (PrivateMessage mail : messages)
        {
            if (mail != null)
            {
                if (request.getParameter(mail.getId().toString()) != null)
                {
                    this.mailManager.deletePrivateMessage(mail.getId());
                }
            }
        }

        return new ModelAndView(getSuccessView(), referenceData(request, command, errors));
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Map referenceData(HttpServletRequest request, Object command, Errors errors) throws Exception
    {

        Map<String, Object> model = new HashMap<String, Object>();

        model.put("messages", this.mailManager.getAllMessageFromAllUsers()); //$NON-NLS-1$

        return model;
    }

}
