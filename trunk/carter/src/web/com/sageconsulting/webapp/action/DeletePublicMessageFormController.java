/*
 * DeletePublicMessageFormController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.sageconsulting.model.PublicMessage;
import com.sageconsulting.service.PublicMessageManager;

public class DeletePublicMessageFormController extends BaseFormController
{
    private PublicMessageManager publicMessageManager;

    public DeletePublicMessageFormController()
    {
        super.setCommandName("publicMessage"); //$NON-NLS-1$
        super.setCommandClass(PublicMessage.class);
    }

    public void setPublicMessageManager(PublicMessageManager manager)
    {
        this.publicMessageManager = manager;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse, java.lang.Object,
     *      org.springframework.validation.BindException)
     */
    @Override
    public ModelAndView processFormSubmission(HttpServletRequest request, HttpServletResponse response, Object command,
        BindException errors) throws Exception
    {

        List<PublicMessage> messages = this.publicMessageManager.getAllPublicMessages();
        PublicMessage publicMessage;
        for (int i = 0; messages != null && i < messages.size(); i++)
        {
            publicMessage = messages.get(i);
            if (publicMessage != null)
            {
                if (request.getParameter(publicMessage.getId().toString()) != null)
                {
                    this.publicMessageManager.removePublicMessage(publicMessage.getId());
                }
            }
        }

        return new ModelAndView(new RedirectView(getSuccessView()));
    }

}
