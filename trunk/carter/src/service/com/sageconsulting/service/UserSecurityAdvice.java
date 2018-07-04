/*
 * UserSecurityAdvice.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.acegisecurity.AccessDeniedException;
import org.acegisecurity.Authentication;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.context.SecurityContext;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.acegisecurity.providers.dao.UserCache;
import org.acegisecurity.userdetails.UserDetails;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import com.sageconsulting.Constants;
import com.sageconsulting.model.Role;
import com.sageconsulting.model.User;

public class UserSecurityAdvice implements MethodBeforeAdvice, AfterReturningAdvice
{
    public final static String ACCESS_DENIED = "Access Denied: Only administrators are allowed to modify other users."; //$NON-NLS-1$

    protected final Log log = LogFactory.getLog(UserSecurityAdvice.class);

    private UserCache userCache;

    public void setUserCache(UserCache cache)
    {
        this.userCache = cache;
    }

    /**
     * Method to enforce security and only allow administrators to modify users.
     * Regular users are allowed to modify themselves.
     */
    public void before(Method method, Object[] args, Object target) throws Throwable
    {
        SecurityContext ctx = SecurityContextHolder.getContext();

        if (ctx.getAuthentication() != null)
        {
            Authentication auth = ctx.getAuthentication();
            boolean administrator = false;
            GrantedAuthority[] roles = auth.getAuthorities();
            for (GrantedAuthority element : roles)
            {
                if (element.getAuthority().equals(Constants.ADMIN_ROLE))
                {
                    administrator = true;
                    break;
                }
            }

            User user = (User) args[0];
            String username = user.getUsername();

            String currentUser;
            if (auth.getPrincipal() instanceof UserDetails)
            {
                currentUser = ((UserDetails) auth.getPrincipal()).getUsername();
            }
            else
            {
                currentUser = String.valueOf(auth.getPrincipal());
            }

            if ((username != null) && !username.equals(currentUser))
            {
                /* I had to take this out for now because when a match is played we update the user statistics
                 * for both golfers in the match.
                AuthenticationTrustResolver resolver = new AuthenticationTrustResolverImpl();
                // allow new users to signup - this is OK b/c Signup doesn't
                // allow setting of roles
                boolean signupUser = resolver.isAnonymous(auth);
                if (!signupUser)
                {
                    if (this.log.isDebugEnabled())
                    {
                        this.log.debug("Verifying that '" + currentUser + "' can modify '" + username + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    }
                    if (!administrator)
                    {
                        this.log.warn("Access Denied: '" + currentUser + "' tried to modify '" + username + "'!"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        throw new AccessDeniedException(ACCESS_DENIED);
                    }
                }
                else
                {
                    if (this.log.isDebugEnabled())
                    {
                        this.log.debug("Registering new user '" + username + "'"); //$NON-NLS-1$ //$NON-NLS-2$
                    }
                }
                 */
            }

            // don't allow users with "user" role to upgrade to "admin" role
            else if ((username != null) && username.equalsIgnoreCase(currentUser) && !administrator)
            {

                // get the list of roles the user is trying add
                Set<String> userRoles = new HashSet<String>();
                if (user.getRoles() != null)
                {
                    for (Iterator<Role> it = user.getRoles().iterator(); it.hasNext();)
                    {
                        Role role = it.next();
                        userRoles.add(role.getName());
                    }
                }

                // get the list of roles the user currently has
                Set<String> authorizedRoles = new HashSet<String>();
                for (GrantedAuthority element : roles)
                {
                    authorizedRoles.add(element.getAuthority());
                }

                // if they don't match - access denied
                // users aren't allowed to change their roles
                if (!CollectionUtils.isEqualCollection(userRoles, authorizedRoles))
                {
                    this.log.warn("Access Denied: '" + currentUser + "' tried to change their role(s)!"); //$NON-NLS-1$ //$NON-NLS-2$
                    throw new AccessDeniedException(ACCESS_DENIED);
                }
            }
        }
    }

    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable
    {
        User user = (User) args[0];

        if ((this.userCache != null) && (user.getVersion() != null))
        {
            if (this.log.isDebugEnabled())
            {
                this.log.debug("Removing '" + user.getUsername() + "' from userCache"); //$NON-NLS-1$ //$NON-NLS-2$
            }

            this.userCache.removeUserFromCache(user.getUsername());

            // reset the authentication object if current user
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if ((auth != null) && (auth.getPrincipal() instanceof UserDetails))
            {
                User currentUser = (User) auth.getPrincipal();
                if (currentUser.getId().equals(user.getId()))
                {
                    if (!currentUser.getUsername().equalsIgnoreCase(user.getUsername()))
                    {
                        // The name of the current user changed, so the previous
                        // flush won't have done anything.
                        // Flush the old name, too.
                        if (this.log.isDebugEnabled())
                        {
                            this.log.debug("Removing '" + currentUser.getUsername() + "' from userCache"); //$NON-NLS-1$ //$NON-NLS-2$
                        }
                        this.userCache.removeUserFromCache(currentUser.getUsername());
                    }
                    auth = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
        }
    }
}
