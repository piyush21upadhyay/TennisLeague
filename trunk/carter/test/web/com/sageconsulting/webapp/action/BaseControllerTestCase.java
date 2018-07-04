/*
 * BaseControllerTestCase.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.*;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sageconsulting.Constants;
import com.sageconsulting.util.DateUtil;
import com.sageconsulting.model.BaseObject;
import com.sageconsulting.model.User;
import com.sageconsulting.service.UserManager;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

public abstract class BaseControllerTestCase extends TestCase
{
    protected transient final Log log = LogFactory.getLog(getClass());

    protected static XmlWebApplicationContext ctx;

    protected User user;

    // This static block ensures that Spring's BeanFactory is only loaded
    // once for all tests
    static
    {
        String pkg = ClassUtils.classPackageAsResourcePath(Constants.class);
        String[] paths = { "classpath*:/" + pkg + "/dao/applicationContext-*.xml", //$NON-NLS-1$ //$NON-NLS-2$
            "classpath*:META-INF/applicationContext-*.xml", //$NON-NLS-1$
            "/WEB-INF/applicationContext-validation.xml", "/WEB-INF/action-servlet.xml" }; //$NON-NLS-1$ //$NON-NLS-2$

        ctx = new XmlWebApplicationContext();
        ctx.setConfigLocations(paths);
        ctx.setServletContext(new MockServletContext("")); //$NON-NLS-1$
        ctx.refresh();
    }

    @Override
    protected void setUp() throws Exception
    {
        // populate the userForm and place into session
        UserManager userMgr = (UserManager) ctx.getBean("userManager"); //$NON-NLS-1$
        this.user = userMgr.getUserByUsername("tcarter"); //$NON-NLS-1$

        // change the port on the mailSender so it doesn't conflict with an
        // existing SMTP server on localhost
        JavaMailSenderImpl mailSender = (JavaMailSenderImpl) ctx.getBean("mailSender"); //$NON-NLS-1$
        mailSender.setPort(2525);
        mailSender.setHost("localhost"); //$NON-NLS-1$
    }

    /**
     * Convenience methods to make tests simpler
     */
    public MockHttpServletRequest newPost(String url)
    {
        return new MockHttpServletRequest("POST", url); //$NON-NLS-1$
    }

    public MockHttpServletRequest newGet(String url)
    {
        return new MockHttpServletRequest("GET", url); //$NON-NLS-1$
    }

    public void objectToRequestParameters(Object o, MockHttpServletRequest request) throws Exception
    {
        objectToRequestParameters(o, request, null);
    }

    public void objectToRequestParameters(Object o, MockHttpServletRequest request, String prefix) throws Exception
    {
        Class<?> clazz = o.getClass();
        Field[] fields = getDeclaredFields(clazz);
        AccessibleObject.setAccessible(fields, true);

        for (Field element : fields)
        {
            Object field = (element.get(o));
            if (field != null)
            {
                if (field instanceof BaseObject)
                {
                    if (prefix != null)
                    {
                        objectToRequestParameters(field, request, prefix + "." + element.getName()); //$NON-NLS-1$
                    }
                    else
                    {
                        objectToRequestParameters(field, request, element.getName());
                    }
                }
                else if (!(field instanceof List) && !(field instanceof Set))
                {
                    String paramName = element.getName();

                    if (prefix != null)
                    {
                        paramName = prefix + "." + paramName; //$NON-NLS-1$
                    }

                    String paramValue = String.valueOf(element.get(o));

                    // handle Dates
                    if (field instanceof java.util.Date)
                    {
                        paramValue = DateUtil.convertDateToString((Date) element.get(o));
                        if ("null".equals(paramValue)) //$NON-NLS-1$
                        {
                            paramValue = ""; //$NON-NLS-1$
                        }
                    }

                    request.addParameter(paramName, paramValue);
                }
            }
        }
    }

    private Field[] getDeclaredFields(Class<?> clazz)
    {
        Field[] f = new Field[0];
        Class<?> superClazz = clazz.getSuperclass();
        Collection<Field> rval = new ArrayList<Field>();

        if (superClazz != null)
        {
            rval.addAll(Arrays.asList(getDeclaredFields(superClazz)));
        }

        rval.addAll(Arrays.asList(clazz.getDeclaredFields()));
        return rval.toArray(f);
    }
}
