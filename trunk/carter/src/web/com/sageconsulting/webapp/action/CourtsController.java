/*
 * CourtsController.java
 * 
 * Copyright © 2008-2009 City Tennis League, LLC.  All Rights Reserved
 * http://www.citytennisleague.com
 * 
 * @author Piyush Upadhyay - 
 */
package com.sageconsulting.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.GrantedAuthority;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sageconsulting.Constants;
import com.sageconsulting.model.City;
import com.sageconsulting.model.User;
import com.sageconsulting.service.CourtManager;
import com.sageconsulting.service.UserManager;

public class CourtsController extends ApplicationObjectSupport implements Controller
{
    private CourtManager courtManager;
    private UserManager userManager;
    
    public void setCourtManager(CourtManager mgr)
    {
        this.courtManager = mgr;
    }
    
    public void setUserManager(UserManager mgr)
    {
        this.userManager = mgr;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ModelAndView view = new ModelAndView(); //super.onSubmit(request, response, command, errors);
        City city = (City)request.getSession().getAttribute(Constants.CITY_TOKEN);
        User user = getUser(request);
        boolean isAdmin = this.isCurrentUserAdmin(request, user);
        view.addObject("isAdmin", Boolean.valueOf(isAdmin));
        if (null == city)
        {
        	String msg = getMessageSourceAccessor().getMessage("errors.noCity", request.getLocale()); //$NON-NLS-1$
        	view.addObject("successMessages", new String[] { msg });//$NON-NLS-1$
            return view;
        }
        
        view.addObject("courtList", this.courtManager.getCourts(city.getId())); //$NON-NLS-1$
        
        return view;
    }
    
    private User getUser(HttpServletRequest request)
    {
        User user = null;
        
        String userId = request.getParameter("id"); //$NON-NLS-1$
        if (null == userId)
        {
            String currentUsername = request.getRemoteUser();
            if (null != currentUsername)
            {
                user = this.userManager.getUserByUsername(currentUsername);
            }
        }
        else
        {
            user = this.userManager.getUser(userId);
        }
        
        return user;
    }
    
    private boolean isCurrentUserAdmin(HttpServletRequest request, User user)
    {
    	boolean isAdmin = false;
        if ((null == user) || (null == request.getRemoteUser()))
            return false;
        
        if(isCurrentUser(request, user))
        {
        	GrantedAuthority[] roles = user.getAuthorities();
        	for(GrantedAuthority role : roles)
        	{
        		if(role.getAuthority().equalsIgnoreCase("admin"))
        		{
        			isAdmin = true;
        			break;
        		}
        	}
        }
        return isAdmin;
    }
    
    private boolean isCurrentUser(HttpServletRequest request, User user)
    {
        String currentUserName = request.getRemoteUser();
        if ((null == user) || (null == currentUserName))
        {
            return false;
        }
        
        return user.getUsername().equals(currentUserName);
    }
}
