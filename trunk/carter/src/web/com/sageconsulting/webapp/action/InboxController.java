/*
 * InboxController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.sageconsulting.model.PrivateMessage;
import com.sageconsulting.model.User;
import com.sageconsulting.service.PrivatemessageManager;

/**
 * 
 */
public class InboxController extends BaseFormController
{
    private PrivatemessageManager mailManager;

    public InboxController()
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
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	if (null == request.getRemoteUser())
    	{
    		ModelAndView view = new ModelAndView();
    		String msg = getText("inbox.notLoggedIn", request.getLocale()); //$NON-NLS-1$
        	view.addObject("successMessages", new String[] { msg }); //$NON-NLS-1$
        	return view;
    	}
    	return super.handleRequestInternal(request, response);
    }

    @Override
    public ModelAndView processFormSubmission(HttpServletRequest request, HttpServletResponse response,
        Object command, BindException errors) throws Exception
    {
        if (isDelete(request))
        {
            return deleteMessages(request, response, errors);
        }
        
        return super.showForm(request, response, errors);
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
    
    private ModelAndView deleteMessages(HttpServletRequest request, HttpServletResponse response, BindException errors) throws Exception
    {
        User user = getUserManager().getUserByUsername(request.getRemoteUser());
        String []msgIds = request.getParameterValues("msgDelete"); //$NON-NLS-1$
        
        if (null != msgIds)
        {
            for (String msgId : msgIds)
            {
                deleteMessage(user, msgId);
            }
        }
        //TODO: could put up a message to display that x messages were deleted
        return super.showForm(request, response, errors);
    }
    
    private void deleteMessage(User user, String msgId)
    {
        PrivateMessage msg = getMessage(msgId);
        if (null != msg)
        {
            if (msg.getTo().equals(user))
            {
                this.mailManager.deletePrivateMessage(msg.getId());
            }
            else
            {
                this.log.error("Attempt to delete a message that does not belong to the user."); //$NON-NLS-1$
            }
        }
    }
    
    private PrivateMessage getMessage(String strId)
    {
        try
        {
            Long id =  Long.valueOf(strId);
            return this.mailManager.getPrivateMessagesByID(id);
        }
        catch (Exception e)
        {
            this.log.error("Couldn't retrieve message "+strId+" to delete. ", e); //$NON-NLS-1$ //$NON-NLS-2$
        }
        return null;
    }
    
    /*
    private ModelAndView replyToMessage(HttpServletRequest request, HttpServletResponse response, BindException errors) throws Exception
    {
        PrivateMessage msg = getReplyMessage(request, errors);
        ModelAndView view = super.showForm(request, response, errors);
        if (errors.getErrorCount() < 1)
        {
            this.mailManager.sendPrivateMessage(msg);
            
            String strMessage = getText("inbox.messageSent", request.getLocale()) + //$NON-NLS-1$
                " " + msg.getTo().getFirstName(); //$NON-NLS-1$
            view.addObject("sentMessage", strMessage); //$NON-NLS-1$
        }
        else
        {
            view.addObject("replyMessage", request.getParameter("message")); //$NON-NLS-1$ //$NON-NLS-2$
        }
        
        return view;
    }
    
    private PrivateMessage getReplyMessage(HttpServletRequest request, BindException errors)
    {
        String strMessage = request.getParameter("message"); //$NON-NLS-1$
        if (strMessage.length() > 1000)
        {
            errors.rejectValue("message", "inbox.messageToLong"); //$NON-NLS-1$ //$NON-NLS-2$
            return null;
        }
        
        PrivateMessage msg = new PrivateMessage();
        PrivateMessage currentMessage = getCurrentMessage(request);
        User from = getUserManager().getUserByUsername(request.getRemoteUser());
        msg.setFrom(from);
        msg.setTo(currentMessage.getFrom());
        msg.setSubject(createSubject(currentMessage.getSubject(), request.getLocale()));
        msg.setMessage(strMessage);
        msg.setDateSent(new Timestamp(new Date().getTime()));
        return msg;
    }
    
    private String createSubject(String currentSubject, Locale locale)
    {
        String re = super.getText("inbox.re", locale); //$NON-NLS-1$
        if (currentSubject.startsWith(re))
        {
            return currentSubject;
        }
        StringBuilder sb = new StringBuilder(re).append(" ").append(currentSubject); //$NON-NLS-1$
        if (sb.length() > 60)
        {
            sb.setLength(60);
        }
        return sb.toString();
    }
    */

    @SuppressWarnings("unchecked")
    @Override
    protected Map referenceData(HttpServletRequest request, Object command, Errors errors) throws Exception
    {
        Map<String, Object> model = new HashMap<String, Object>();
        User user = getUserManager().getUserByUsername(request.getRemoteUser());

        model.put("messages", this.mailManager.getAllPrivateMessages(user.getId())); //$NON-NLS-1$
        model.put("newMessageCount", Integer.valueOf(this.mailManager.getNumberNewMessages(user.getId()))); //$NON-NLS-1$
        
        PrivateMessage readMessage = getCurrentMessage(request);
        if (null != readMessage)
        {
            this.mailManager.markPrivateMessageAsRead(readMessage.getId());
            PrivateMessage currentMessage = getCurrentMessage(request);
            updateMessageBreaks(currentMessage);
            model.put("currentMessage", currentMessage); //$NON-NLS-1$
        }

        return model;
    }
    
    private void updateMessageBreaks(PrivateMessage msg)
    {
        if (null == msg)
        {
            return;
        }
        
        msg.setMessage(msg.getMessage().replace("\n", "<br/>")); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private PrivateMessage getCurrentMessage(HttpServletRequest request)
    {
        String msgParam = request.getParameter("msg"); //$NON-NLS-1$
        if (null == msgParam)
        {
            return null;
        }
        
        try
        {
            return this.mailManager.getPrivateMessagesByID(Long.valueOf(msgParam));
        }
        catch (NumberFormatException e)
        {
            // Nothing to do - just return null
        }
        return null;
    }
    
    /*
    private boolean isReply(HttpServletRequest request)
    {
        String param = request.getParameter("reply"); //$NON-NLS-1$
        return (null != param) ? true : false;
    }
    
    private String getReplyMessage(PrivateMessage currentMessage)
    {
        if (null == currentMessage) return ""; //$NON-NLS-1$
        
        return quotePreviousMessage(currentMessage.getMessage());
    }

    private String quotePreviousMessage(String msg)
    {
//        String token = "\n>> "; //$NON-NLS-1$
//        StringBuilder sb = new StringBuilder(msg);
//        int lastOffset = 0;
//        int offset = 0;
//        while (offset < sb.length())
//        {
//            sb.insert(offset, token);
//            offset += 80;
//            if (offset < sb.length())
//            {
//                while (!(" \r\n\t".indexOf(sb.charAt(offset)) < 0));
//                {
//                    offset--;
//                    if (offset <= lastOffset)
//                    {
//                        offset = lastOffset + 80;
//                        break;
//                    }
//                }
//            }
//            lastOffset = offset;
//        }
//        return sb.toString();
        String token = "> "; //$NON-NLS-1$
        StringBuilder sb = new StringBuilder(msg);
        sb.insert(0, "\r\n\r\n\r\n"); //$NON-NLS-1$
        int curIndex = 5;
        while (curIndex >= 0)
        {
            sb.insert(curIndex+1, token);
            curIndex = sb.indexOf("\n", curIndex+1); //$NON-NLS-1$
        }
        return sb.toString();
    }
    */
}
