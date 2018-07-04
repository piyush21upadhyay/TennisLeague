/*
 * StartupListener.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.listener;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.acegisecurity.providers.AuthenticationProvider;
import org.acegisecurity.providers.ProviderManager;
import org.acegisecurity.providers.encoding.Md5PasswordEncoder;
import org.acegisecurity.providers.rememberme.RememberMeAuthenticationProvider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sageconsulting.Constants;
import com.sageconsulting.service.CityManager;
import com.sageconsulting.service.LookupManager;

/**
 * <p>
 * StartupListener class used to initialize and database settings and populate
 * any application-wide drop-downs.
 * 
 * <p>
 * Keep in mind that this listener is executed outside of
 * OpenSessionInViewFilter, so if you're using Hibernate you'll have to
 * explicitly initialize all loaded data at the Dao or service level to avoid
 * LazyInitializationException. Hibernate.initialize() works well for doing
 * this.
 */
public class StartupListener extends ContextLoaderListener
{

    private static final Log log = LogFactory.getLog(StartupListener.class);

    @SuppressWarnings("unchecked")
    @Override
    public void contextInitialized(ServletContextEvent event)
    {
        if (log.isDebugEnabled())
        {
            log.debug("initializing context..."); //$NON-NLS-1$
        }

        // call Spring's context ContextLoaderListener to initialize
        // all the context files specified in web.xml
        super.contextInitialized(event);

        ServletContext context = event.getServletContext();

        // Orion starts Servlets before Listeners, so check if the config
        // object already exists
        Map<String, Object> config = (Map<String, Object>)context.getAttribute(Constants.CONFIG);

        if (config == null)
        {
            config = new HashMap<String, Object>();
        }

        if (context.getInitParameter(Constants.CSS_THEME) != null)
        {
            config.put(Constants.CSS_THEME, context.getInitParameter(Constants.CSS_THEME));
        }

        ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);

        boolean encryptPassword = false;
        try
        {
            ProviderManager provider = (ProviderManager) ctx.getBean("authenticationManager"); //$NON-NLS-1$
            for (Iterator it = provider.getProviders().iterator(); it.hasNext();)
            {
                AuthenticationProvider p = (AuthenticationProvider) it.next();
                if (p instanceof RememberMeAuthenticationProvider)
                {
                    config.put("rememberMeEnabled", Boolean.TRUE); //$NON-NLS-1$
                }
            }

            if (ctx.containsBean("passwordEncoder")) //$NON-NLS-1$
            {
                encryptPassword = true;
                config.put(Constants.ENCRYPT_PASSWORD, Boolean.TRUE);
                String algorithm = "SHA"; //$NON-NLS-1$
                if (ctx.getBean("passwordEncoder") instanceof Md5PasswordEncoder) //$NON-NLS-1$
                {
                    algorithm = "MD5"; //$NON-NLS-1$
                }
                config.put(Constants.ENC_ALGORITHM, algorithm);
            }
        }
        catch (NoSuchBeanDefinitionException n)
        {
            // ignore, should only happen when testing
        }

        context.setAttribute(Constants.CONFIG, config);

        // output the retrieved values for the Init and Context Parameters
        if (log.isDebugEnabled())
        {
            log.debug("Remember Me Enabled? " + config.get("rememberMeEnabled")); //$NON-NLS-1$ //$NON-NLS-2$
            log.debug("Encrypt Passwords? " + encryptPassword); //$NON-NLS-1$
            if (encryptPassword)
            {
                log.debug("Encryption Algorithm: " + config.get(Constants.ENC_ALGORITHM)); //$NON-NLS-1$
            }
            log.debug("Populating drop-downs..."); //$NON-NLS-1$
        }

        setupContext(context);
    }

    public static void setupContext(ServletContext context)
    {
        ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);

        LookupManager mgr = (LookupManager) ctx.getBean("lookupManager"); //$NON-NLS-1$

        // get list of possible roles
        context.setAttribute(Constants.AVAILABLE_ROLES, mgr.getAllRoles());
        
        
        CityManager cityMgr = (CityManager)ctx.getBean("cityManager"); //$NON-NLS-1$
        context.setAttribute(Constants.AVAILABLE_CITIES, cityMgr.getCities());

        if (log.isDebugEnabled())
        {
            log.debug("Drop-down initialization complete [OK]"); //$NON-NLS-1$
        }
    }
}
