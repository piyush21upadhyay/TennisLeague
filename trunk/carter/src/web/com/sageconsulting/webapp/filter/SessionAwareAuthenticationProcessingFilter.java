/*
 * SessionAwareAuthenticationProcessingFilter.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.filter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.Authentication;
import org.acegisecurity.ui.webapp.AuthenticationProcessingFilter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sageconsulting.Constants;
import com.sageconsulting.model.User;
import com.sageconsulting.service.UserExistsException;
import com.sageconsulting.service.UserManager;

public class SessionAwareAuthenticationProcessingFilter extends AuthenticationProcessingFilter
{
    private static final Log log = LogFactory.getLog(SessionAwareAuthenticationProcessingFilter.class);
    
    private UserManager userManager;
    
    public void setUserManager(UserManager mgr)
    {
        this.userManager = mgr;
    }

    @Override
    public void onSuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authResult)
        throws IOException
    {
    	User user = this.userManager.getUserByUsername(authResult.getName());
    	request.getSession().setAttribute("prevLastLogin", user.getLastLogin());
    	/***Code added by Piyush/Akash starts**/
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = new Date();
		/**Code added by Piyush/Akash ends**/
        try
        {
        	user.setLastLogin(dateFormat.parse(dateFormat.format(date)));
        	//user.setLastLogin(new Date());
            this.userManager.saveUser(user);
        }
        catch (UserExistsException e)
        {
            // This should never happen since we are just doing an update.
            log.error("Failed to update last login.", e); //$NON-NLS-1$
        }
        catch(ParseException pe)
        {
        	log.error("Failed to update last login.", pe); //$NON-NLS-1$
        }
        
        response.addCookie(new Cookie(Constants.CITY_TOKEN, user.getRegisteredCity().getId().toString()));
        request.getSession().setAttribute(Constants.CITY_TOKEN, user.getRegisteredCity());
        log.debug("SESSION TIMEOUT: "+request.getSession().getMaxInactiveInterval()); //$NON-NLS-1$
        request.getSession().setMaxInactiveInterval(-1);
        log.debug("SESSION TIMEOUT: "+request.getSession().getMaxInactiveInterval()); //$NON-NLS-1$
        super.onSuccessfulAuthentication(request, response, authResult);
    }
}
