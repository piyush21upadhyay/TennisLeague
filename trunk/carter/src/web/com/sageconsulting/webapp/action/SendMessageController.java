/*
 * SendMessageController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.sageconsulting.model.PrivateMessage;
import com.sageconsulting.model.User;
import com.sageconsulting.service.MailEngine;
import com.sageconsulting.service.PrivatemessageManager;
import com.sageconsulting.util.MessageUtil;
import com.sageconsulting.webapp.util.CustomUserEditor;

public class SendMessageController extends BaseFormController
{
    private PrivatemessageManager mailManager;
    String msgtype=null;
    protected MailEngine mailEngine;
    protected SimpleMailMessage message;
    
    public void setMailEngine(MailEngine mailEngine) {
		this.mailEngine = mailEngine;
	}

	public void setMessage(SimpleMailMessage message) {
		this.message = message;
	}

    /**
     * @param mailManager The mailManager to set.
     */
    public void setMailManager(PrivatemessageManager mgr)
    {
        this.mailManager = mgr;
    }
    
    public SendMessageController()
    {
        this.setCommandClass(PrivateMessage.class);
        this.setCommandName("privateMessage"); //$NON-NLS-1$
    }
    
    @Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	if (null == request.getRemoteUser())
    	{
    		return getErrorView("sendMsg.noUser", request.getLocale()); //$NON-NLS-1$
    	}
    	else if ((null == request.getParameter("id") && (null == request.getParameter("replyTo")))) //$NON-NLS-1$ //$NON-NLS-2$
		{
    		return getErrorView("sendMsg.noRecipient", request.getLocale()); //$NON-NLS-1$
		}
    	return super.handleRequestInternal(request, response);
    }
    
    private ModelAndView getErrorView(String msgKey, Locale locale)
    {
		ModelAndView view = new ModelAndView();
		String msg = getText(msgKey, locale);
    	view.addObject("successMessages", new String[] { msg }); //$NON-NLS-1$
    	return view;
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
        	// Go to the profile page of the user the message was going to be for.
        	PrivateMessage msg = (PrivateMessage)command;
            //return new ModelAndView(new RedirectView("profile.html?id="+ //$NON-NLS-1$
            	//msg.getTo().getId() + "&msg=false")); //$NON-NLS-1$
			return new ModelAndView(new RedirectView("profile.html"));
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
    
    @Override
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
        BindException errors) throws Exception
    {
        PrivateMessage msg = (PrivateMessage)command;
        User from = this.getUserManager().getUserByUsername(request.getRemoteUser());
        
        if ((null == msg.getSubject()) || (msg.getSubject().length() < 1))
        {
            errors.rejectValue("subject", "sendMsg.noSubject"); //$NON-NLS-1$ //$NON-NLS-2$
        }

        if ((null == msg.getMessage()) || (msg.getMessage().length() < 1))
        {
            errors.rejectValue("message", "sendMsg.noMessage"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        
        if (msg.getMessage().length() > 1000)
        {
            errors.rejectValue("message", "sendMsg.messageToLong"); //$NON-NLS-1$ //$NON-NLS-2$
        }

        if (null == from)
        {
            errors.rejectValue("from", "sendMsg.noUser"); //$NON-NLS-1$ //$NON-NLS-2$
        }

        ModelAndView view =null;
        if (errors.getErrorCount() < 1)
        {
        	if(msgtype!=null)
        	{
        		/*reply of previous message */
        		msgtype=null;
        		view = new ModelAndView("inbox"); 
        		msg.setFrom(from);
                msg.setDateSent(new Timestamp(new Date().getTime()));
                this.mailManager.sendPrivateMessage(msg);
                String sentMsg = getText("sendMsg.messageSent", request.getLocale()) + //$NON-NLS-1$
                    " " + msg.getTo().getFirstName(); //$NON-NLS-1$
                this.message.setTo(msg.getTo().getEmail());
                String subject = '[' +"You have a message on City Golf League"+ " ] " ; 
                this.message.setSubject(subject);
                this.message.setText(msg.getMessage());
                this.mailEngine.send(this.message);
               User user = getUserManager().getUserByUsername(request.getRemoteUser());
               view.addObject("messages", this.mailManager.getAllPrivateMessages(user.getId())); //$NON-NLS-1$
               view.addObject("newMessageCount", Integer.valueOf(this.mailManager.getNumberNewMessages(user.getId()))); //$NON-NLS-1$ 
               view.addObject("sentMessage", sentMsg); //$NON-NLS-1$
               view.addObject("currentMessage", null); //$NON-NLS-1$
        	}
        	else
        	{  
        		/*for new message  */
        		view= super.showForm(request, response, errors);
        		msg.setFrom(from);
                msg.setDateSent(new Timestamp(new Date().getTime()));
                this.mailManager.sendPrivateMessage(msg);
                
                String sentMsg = getText("sendMsg.messageSent", request.getLocale()) + //$NON-NLS-1$
                    " " + msg.getTo().getFirstName(); //$NON-NLS-1$
                this.message.setTo(msg.getTo().getEmail());
                String subject = '[' +"You have a message on City Golf League"+ " ] " ; 
                this.message.setSubject(subject);
                this.message.setText(msg.getMessage());
                this.mailEngine.send(this.message);
			    view.addObject("sentMessage", sentMsg); //$NON-NLS-1$
                view.addObject("currentMessage", null); //$NON-NLS-1$
        	}
        	
        }
        
        else
        {
        	view= super.showForm(request, response, errors);
            view.addObject("currentMessage", null); //$NON-NLS-1$
        	
        }
        
        return view;
    }


    @SuppressWarnings("rawtypes")
	@Override
    protected Map referenceData(HttpServletRequest request, Object command, Errors errors) throws Exception
    {
        return createModel(command);
    }

    @SuppressWarnings("rawtypes")
	private Map createModel(Object command) throws Exception
    {
        Map<String, Object> model = new HashMap<String, Object>();
        
        PrivateMessage msg = (PrivateMessage)command;
        if (null != msg)
        {
            model.put("member", msg.getTo()); //$NON-NLS-1$
        }

        return model;
    }

    /**
     * Set up a custom property editor for converting form inputs to real
     * objects.
     * @param request The current request.
     * @param binder The object which binds an input to a custom editor.
     */
    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
    {
        binder.registerCustomEditor(User.class, new CustomUserEditor(this.getUserManager()));
        super.initBinder(request, binder);
    }
    
    @Override
    protected Object formBackingObject(HttpServletRequest request)
    {
    	PrivateMessage replyTo = getReplyToMessage(request);
        User user = getUserMessageIsFor(request);
        PrivateMessage msg = new PrivateMessage();
        if (null != replyTo)
        {
        	// TODO: make sure the to value is for the current user.
        	msg.setTo(replyTo.getFrom());
        	String prefix = getText("sendMsg.replyPrefix", request.getLocale()) + " "; //$NON-NLS-1$ //$NON-NLS-2$
        	msg.setSubject(MessageUtil.getSubject(replyTo.getSubject(), prefix));
        	msg.setMessage(MessageUtil.quotePreviousMessage(replyTo.getMessage()));
        }
        else if (null != user)
        {
            msg.setTo(user);
        }
        return msg;
    }
    
    private User getUserMessageIsFor(HttpServletRequest request)
    {
        String strId = request.getParameter("id"); //$NON-NLS-1$
        if (null != strId)
        {
            return this.getUserManager().getUser(strId);
        }
        return null;
    }
    
    private PrivateMessage getReplyToMessage(HttpServletRequest request)
    {
    	PrivateMessage msg = null;
    	String replyId = request.getParameter("replyTo"); //$NON-NLS-1$
    	if (null != replyId)
    	{
    		try
    		{
    			Long id = Long.valueOf(replyId);
    			msg = this.mailManager.getPrivateMessagesByID(id);
    			msgtype="reply";
    		}
    		catch (NumberFormatException e)
    		{
    			this.log.error("Failed to parse the reply to id "+replyId); //$NON-NLS-1$
    		}
    	}
    	return msg;
    }
}
