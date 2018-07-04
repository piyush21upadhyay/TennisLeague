/*
 * LoginListener.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.listener;

import java.util.Date;

import org.acegisecurity.event.authentication.AuthenticationSuccessEvent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import com.sageconsulting.model.User;
import com.sageconsulting.service.UserExistsException;
import com.sageconsulting.service.UserManager;


public class LoginListener implements ApplicationListener
{
    private static final Log log = LogFactory.getLog(LoginListener.class);
    
    private UserManager userManager;
    
    public void setUserManager(UserManager mgr)
    {
        this.userManager = mgr;
    }

    public void onApplicationEvent(ApplicationEvent event)
    {
        if (event instanceof AuthenticationSuccessEvent)
        {
            AuthenticationSuccessEvent authEvent = (AuthenticationSuccessEvent)event;
            
            /*
             * The code for last login date has been moved to SessionAwareAuthenticationProcessingFilter.java
             * */
            
            /*User user = (User)authEvent.getAuthentication().getPrincipal();
            user.setLastLogin(new Date());
            try
            {
                this.userManager.saveUser(user);
            }
            catch (UserExistsException e)
            {
                // This should never happen since we are just doing an update.
                log.error("Failed to update last login.", e); //$NON-NLS-1$
            }*/
        }
    }
}
