/*
 * UserCounterListener.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.listener;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.acegisecurity.context.HttpSessionContextIntegrationFilter;
import org.acegisecurity.context.SecurityContext;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationTrustResolver;
import org.acegisecurity.AuthenticationTrustResolverImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sageconsulting.model.User;

/**
 * UserCounterListener class used to count the current number of active users
 * for the applications. Does this by counting how many user objects are stuffed
 * into the session. It Also grabs these users and exposes them in the servlet
 * context.
 */
public class UserCounterListener implements ServletContextListener, HttpSessionAttributeListener
{
    public static final String COUNT_KEY = "userCounter"; //$NON-NLS-1$
    public static final String USERS_KEY = "userNames"; //$NON-NLS-1$
    public static final String EVENT_KEY = HttpSessionContextIntegrationFilter.ACEGI_SECURITY_CONTEXT_KEY;

    private final transient Log log = LogFactory.getLog(UserCounterListener.class);

    private transient ServletContext servletContext;
    private int counter;
    private Set<User> users;

    public synchronized void contextInitialized(ServletContextEvent sce)
    {
        this.servletContext = sce.getServletContext();
        this.servletContext.setAttribute((COUNT_KEY), Integer.toString(this.counter));
    }

    public synchronized void contextDestroyed(ServletContextEvent event)
    {
        this.servletContext = null;
        this.users = null;
        this.counter = 0;
    }

    synchronized void incrementUserCounter()
    {
        this.counter = Integer.parseInt((String) this.servletContext.getAttribute(COUNT_KEY));
        this.counter++;
        this.servletContext.setAttribute(COUNT_KEY, Integer.toString(this.counter));

        if (this.log.isDebugEnabled())
        {
            this.log.debug("User Count: " + this.counter); //$NON-NLS-1$
        }
    }

    synchronized void decrementUserCounter()
    {
        int cntr = Integer.parseInt((String) this.servletContext.getAttribute(COUNT_KEY));
        cntr--;

        if (cntr < 0)
        {
            cntr = 0;
        }

        this.servletContext.setAttribute(COUNT_KEY, Integer.toString(cntr));

        if (this.log.isDebugEnabled())
        {
            this.log.debug("User Count: " + cntr); //$NON-NLS-1$
        }
    }

    @SuppressWarnings("unchecked")
    synchronized void addUsername(User user)
    {
        this.users = (Set<User>)this.servletContext.getAttribute(USERS_KEY);

        if (this.users == null)
        {
            this.users = new HashSet();
        }

        if (this.log.isDebugEnabled())
        {
            if (this.users.contains(user))
            {
                this.log.debug("User already logged in, adding anyway..."); //$NON-NLS-1$
            }
        }

        this.users.add(user);
        this.servletContext.setAttribute(USERS_KEY, this.users);
        incrementUserCounter();
    }

    @SuppressWarnings("unchecked")
    synchronized void removeUsername(Object user)
    {
        this.users = (Set<User>)this.servletContext.getAttribute(USERS_KEY);

        if (this.users != null)
        {
            this.users.remove(user);
        }

        this.servletContext.setAttribute(USERS_KEY, this.users);
        decrementUserCounter();
    }

    /**
     * This method is designed to catch when user's login and record their name
     * 
     * @see javax.servlet.http.HttpSessionAttributeListener#attributeAdded(javax.servlet.http.HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)
    {
        this.log.debug("event.name: " + event.getName()); //$NON-NLS-1$
        if (event.getName().equals(EVENT_KEY) && !isAnonymous())
        {
            SecurityContext securityContext = (SecurityContext) event.getValue();
            User user = (User) securityContext.getAuthentication().getPrincipal();
            addUsername(user);
        }
    }

    private boolean isAnonymous()
    {
        AuthenticationTrustResolver resolver = new AuthenticationTrustResolverImpl();
        SecurityContext ctx = SecurityContextHolder.getContext();
        if (ctx != null)
        {
            Authentication auth = ctx.getAuthentication();
            return resolver.isAnonymous(auth);
        }
        return true;
    }

    /**
     * When user's logout, remove their name from the hashMap
     * 
     * @see javax.servlet.http.HttpSessionAttributeListener#attributeRemoved(javax.servlet.http.HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)
    {
        if (event.getName().equals(EVENT_KEY) && !isAnonymous())
        {
            SecurityContext securityContext = (SecurityContext) event.getValue();
            Authentication auth = securityContext.getAuthentication();
            if ((auth != null) && (auth.getPrincipal() instanceof User))
            {
                User user = (User) auth.getPrincipal();
                removeUsername(user);
            }
        }
    }

    /**
     * Needed for Acegi Security 1.0, as it adds an anonymous user to the
     * session and then replaces it after authentication.
     * http://forum.springframework.org/showthread.php?p=63593
     * 
     * @see javax.servlet.http.HttpSessionAttributeListener#attributeReplaced(javax.servlet.http.HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)
    {
        if (event.getName().equals(EVENT_KEY) && !isAnonymous())
        {
            SecurityContext securityContext = (SecurityContext) event.getValue();
            if (securityContext.getAuthentication() != null)
            {
                User user = (User) securityContext.getAuthentication().getPrincipal();
                addUsername(user);
            }
        }
    }
}
