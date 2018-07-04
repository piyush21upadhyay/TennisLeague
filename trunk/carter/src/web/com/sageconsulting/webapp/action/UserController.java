/*
 * UserController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sageconsulting.Constants;
import com.sageconsulting.model.User;
import com.sageconsulting.service.UserManager;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * Simple class to retrieve a list of users from the database.
 */
public class UserController implements Controller
{
    private transient final Log log = LogFactory.getLog(UserController.class);

    private UserManager mgr = null;

    public void setUserManager(UserManager userManager)
    {
        this.mgr = userManager;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        if (this.log.isDebugEnabled())
        {
            this.log.debug("entering 'handleRequest' method..."); //$NON-NLS-1$
        }
        
        String action = request.getParameter("action");
        if((action != null) && action.equals("delete"))
        {
        	if(request.getParameter("id") != null)
        	{
        		User user = this.mgr.getUser(request.getParameter("id"));
        		user.setEnabled(false);
        		this.mgr.saveUser(user);
        	}
        }

        return new ModelAndView("userList", Constants.USER_LIST, this.mgr.getUsers(new User())); //$NON-NLS-1$
    }
}
