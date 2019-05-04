/*
 * MessageBoardController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.Authentication;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.context.SecurityContext;
import org.acegisecurity.context.SecurityContextHolder;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.sageconsulting.Constants;
import com.sageconsulting.model.City;
import com.sageconsulting.model.PublicMessage;
import com.sageconsulting.model.User;
import com.sageconsulting.service.PublicMessageManager;
import com.sageconsulting.util.MessageUtil;

public class MessageBoardController extends BaseFormController
{

    private PublicMessageManager publicMessageManager;

    public MessageBoardController()
    {
        super.setCommandName("publicMessage"); //$NON-NLS-1$
        super.setCommandClass(PublicMessage.class);
    }

    /**
     * @param manager
     */
    public void setPublicMessageManager(PublicMessageManager manager)
    {
        this.publicMessageManager = manager;
    }
    
    @Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        City city = (City) request.getSession().getAttribute(Constants.CITY_TOKEN);
        if (city == null)
        {
        	String msg = getMessageSourceAccessor().getMessage("errors.noCity", request.getLocale()); //$NON-NLS-1$
        	ModelAndView view = new ModelAndView();
        	view.addObject("successMessages", new String[] { msg });//$NON-NLS-1$
        	return view;
        }

        return super.handleRequestInternal(request, response);
    }

    /*
     * (non-Javadoc) This method sets the messages display
     * 
     * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest,
     *      java.lang.Object, org.springframework.validation.Errors)
     */
    @SuppressWarnings("unchecked")
    @Override
    protected Map referenceData(HttpServletRequest request, Object command, Errors arg2) throws Exception
    {
        Map<String, Object> dataModel = new HashMap<String, Object>();
        List<Map> msgList = new ArrayList<Map>();

        // Get the user if one is logged in.
        User user = null;
        if (request.getRemoteUser() != null)
        {
        	user = super.getUserManager().getUserByUsername(request.getRemoteUser());
        }

        // grab the city from session
        City city = (City) request.getSession().getAttribute(Constants.CITY_TOKEN);
        List<PublicMessage> messages = null;

        // set the city if its not null
        if (city != null)
        {
            messages = this.publicMessageManager.getAllPublicMessages(city.getId(), null, ""); //$NON-NLS-1$
        }
        
        // set the admin flag
        SecurityContext ctx = SecurityContextHolder.getContext();
        boolean administrator = false;
        if (ctx.getAuthentication() != null)
        {
            Authentication auth = ctx.getAuthentication();
            GrantedAuthority[] roles = auth.getAuthorities();
            for (GrantedAuthority element : roles)
            {
                if (element.getAuthority().equals(Constants.ADMIN_ROLE))
                {
                    administrator = true;
                    break;
                }
            }
        }
        
        if(messages != null)
        {
        	for(int i=0; i<messages.size(); i++)
        	{
        		Map<String, Object> msgModel = new HashMap<String, Object>();
        		
        		if(messages.get(i).getPoster().getUsername().equals(request.getRemoteUser()) && (!administrator))
        		{
        			Long htmlValue = messages.get(i).getId();
        			msgModel.put("htmlValue", htmlValue);
        			dataModel.put("showDeleteBtn", true);
        		}
        		
        		msgModel.put("messageMap", messages.get(i));
        		msgList.add(msgModel);
        	}
        }
        
        // load objects into the model
        PublicMessage replyTo = getReplyToMessage(request);
        if (null != replyTo)
        {
        	dataModel.put("post", "true"); //$NON-NLS-1$ //$NON-NLS-2$
        	PublicMessage msg = (PublicMessage)command;
        	String prefix = getText("sendMsg.replyPrefix", request.getLocale()) + " "; //$NON-NLS-1$ //$NON-NLS-2$
        	msg.setSubject(MessageUtil.getSubject(replyTo.getSubject(), prefix));
        	msg.setMessage(MessageUtil.quotePreviousMessage(replyTo.getMessage()));
        }
        else if (isPost(request))
        {
        	dataModel.put("post", "true"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        else
        {
            dataModel.put("currentMessage", getCurrentMessage(request)); //$NON-NLS-1$
        }
        dataModel.put("messages", msgList); //$NON-NLS-1$
        dataModel.put("city", city); //$NON-NLS-1$
        dataModel.put("user", user); //$NON-NLS-1$
        if (administrator)
        {
            dataModel.put("admin", "admin"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        if(request.getSession().getAttribute("sentMessage") != null)
        {
        	dataModel.put("sentMessage", request.getSession().getAttribute("sentMessage"));
        	request.getSession().removeAttribute("sentMessage");
        }
        
        return dataModel;
    }
    
    private PublicMessage getCurrentMessage(HttpServletRequest request)
    {
    	PublicMessage msg = null;
    	String msgId = request.getParameter("msg"); //$NON-NLS-1$
    	if (null != msgId)
    	{
    		try
    		{
    			Long id = Long.valueOf(msgId);
    			msg = this.publicMessageManager.getPublicMessage(id);
    		}
    		catch (NumberFormatException e)
    		{
    			this.log.error("Couldn't parse message id " + msgId, e); //$NON-NLS-1$
    		}
    	}
    	
    	return msg;
    }
    
    private PublicMessage getReplyToMessage(HttpServletRequest request)
    {
    	PublicMessage msg = null;
    	String msgId = request.getParameter("replyTo"); //$NON-NLS-1$
    	if (null != msgId)
    	{
    		try
    		{
    			Long id = Long.valueOf(msgId);
    			msg = this.publicMessageManager.getPublicMessage(id);
    		}
    		catch (NumberFormatException e)
    		{
    			this.log.error("Couldn't parse reply message id " + msgId, e); //$NON-NLS-1$
    		}
    	}
    	
    	return msg;
    }
    
    private boolean isPost(HttpServletRequest request)
    {
    	String post = request.getParameter("post"); //$NON-NLS-1$
    	return ((null != post) && post.equals("true")); //$NON-NLS-1$
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
     *      Load the city option list. Will implement the course list if needed.
     */
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception
    {
    	PublicMessage publicMessage = new PublicMessage();
        City city = (City) request.getSession().getAttribute(Constants.CITY_TOKEN);
        if (city != null)
        {
            publicMessage.setCity(city);
        }
        return publicMessage;
    }

    /**
     * Overridden to process the cancelling of the editing.
     */
    @Override
    public ModelAndView processFormSubmission(HttpServletRequest request, HttpServletResponse response, Object command,
        BindException errors) throws Exception
    {
        if (isCancel(request))
        {
            return new ModelAndView(new RedirectView("msgboard.html")); //$NON-NLS-1$
        }

        return super.processFormSubmission(request, response, command, errors);
    }
    
    /**
     * Return true if this request was created by the user pressing the "Cancel" button.
     * @param request The current request.
     * @return true if the user pressed the cancel button and false if not.
     */
    private boolean isCancel(HttpServletRequest request)
    {
    	String cancel = request.getParameter("bCancel"); //$NON-NLS-1$
    	return (null != cancel) && cancel.equals("true"); //$NON-NLS-1$
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse, java.lang.Object,
     *      org.springframework.validation.BindException)
     */
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
        BindException errors) throws Exception
    {
    	if (isNewMessage(request))
    	{
	    	PublicMessage msg = (PublicMessage)command;
	        User user = super.getUserManager().getUserByUsername(request.getRemoteUser());
        	Date date = new Date();
        	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	        //msg.setDate(new Timestamp(System.currentTimeMillis()));
        	//msg.setDate(new Timestamp(date.getTime()));
        	msg.setDate(new Timestamp(dateFormat.parse(dateFormat.format(date)).getTime()));
	        msg.setPoster(user);
	
	        try {
				this.publicMessageManager.postPublicMessage(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
	        request.getSession().setAttribute("sentMessage", super.getText("msgboard.posted", request.getLocale()));
    	}
    	else if (isDelete(request))
    	{
    		deleteMessages(request);
    	}
        return new ModelAndView(new RedirectView(getSuccessView()));
    }
    
    private boolean isNewMessage(HttpServletRequest request)
    {
    	return null != request.getParameter("bCancel"); //$NON-NLS-1$
    }
    
    /**
     * Return true if this request was created by the user pressing the "Delete" button.
     * @param request The current request.
     * @return true if the user pressed the delete button and false if not.
     */
    private boolean isDelete(HttpServletRequest request)
    {
    	String delete = request.getParameter("bDelete"); //$NON-NLS-1$
    	return (null != delete) && delete.equals("true"); //$NON-NLS-1$
    }
    
    private void deleteMessages(HttpServletRequest request)
    {
        String []msgIds = request.getParameterValues("msgDelete"); //$NON-NLS-1$
        
        if (null != msgIds)
        {
            for (String msgId : msgIds)
            {
                deleteMessage(msgId);
            }
        }
    }
    
    private void deleteMessage(String msgId)
    {
        PublicMessage msg = getPublicMessage(msgId);
        if (null != msg)
        {
            this.publicMessageManager.removePublicMessage(msg.getId());
        }
    }
    
    private PublicMessage getPublicMessage(String msgId)
    {
    	try
    	{
    		Long id = Long.valueOf(msgId);
    		return this.publicMessageManager.getPublicMessage(id);
    	}
    	catch (NumberFormatException e)
    	{
    		this.log.error("Error getting message id for delete: "+msgId, e); //$NON-NLS-1$
    	}
    	return null;
    }
}
