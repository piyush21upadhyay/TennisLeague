/*
 * ChooseCityController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sageconsulting.Constants;
import com.sageconsulting.model.City;
import com.sageconsulting.service.CityManager;

public class ChooseCityController implements Controller
{
    //private static final Log log = LogFactory.getLog(ChooseCityController.class);
    
    // This is a list of places that this class can redirect to by using the target=
    // query string parameter.
    private static final String[] VALID_TARGETS = 
    {
        "home.html", //$NON-NLS-1$
        "signup.html", //$NON-NLS-1$
        "members.html", //$NON-NLS-1$
        "courses.html", //$NON-NLS-1$
        "profile.html", //$NON-NLS-1$
    };
    
    private static final String REDIRECT = "redirect:"; //$NON-NLS-1$
    
    private CityManager cityManager;
    private String successView;
    
    public void setCityManager(CityManager mgr)
    {
        this.cityManager = mgr;
    }
    
    public void setSuccessView(String view)
    {
        this.successView = view;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String format = request.getParameter("format"); //$NON-NLS-1$
        boolean asXml = ((null != format) && (format.equals("xml"))); //$NON-NLS-1$
        if (asXml)
        {
            response.getOutputStream().write(getCitiesAsXml().getBytes());
            return null;
        }

        City city = getCity(request);
        if (null != city)
        {
            response.addCookie(new Cookie(Constants.CITY_TOKEN, city.getId().toString()));
            request.getSession().setAttribute(Constants.CITY_TOKEN, city);
            return new ModelAndView(getSuccesView(request));
        }
        
        return new ModelAndView();
    }
    
    private String getSuccesView(HttpServletRequest request)
    {
        String view = this.successView;
        String targetParam = request.getParameter("target"); //$NON-NLS-1$
        if (null != targetParam)
        {
            for (String target : VALID_TARGETS)
            {
                if (targetParam.startsWith(target))
                {
                    view = REDIRECT+target;
                    break;
                }
            }
        }
        return view;
    }
    
    private String getCitiesAsXml()
    {
        List<City> cities = this.cityManager.getCities();
        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>"); //$NON-NLS-1$
        sb.append("<cities>"); //$NON-NLS-1$
        for (City city : cities)
        {
            sb.append("<city>"); //$NON-NLS-1$
            sb.append("<id>").append(city.getId()).append("</id>"); //$NON-NLS-1$ //$NON-NLS-2$
            sb.append("<name>").append(city.getName()).append("</name>"); //$NON-NLS-1$ //$NON-NLS-2$
            sb.append("<state>").append(city.getState()).append("</state>"); //$NON-NLS-1$ //$NON-NLS-2$
            sb.append("<active>").append(city.isActive()).append("</active>"); //$NON-NLS-1$ //$NON-NLS-2$
            sb.append("<inactiveMessage>").append(city.getInactiveMessage()).append("</inactiveMessage>"); //$NON-NLS-1$ //$NON-NLS-2$
            sb.append("</city>"); //$NON-NLS-1$
        }
        sb.append("</cities>"); //$NON-NLS-1$
        return sb.toString();
    }
    
    private City getCity(HttpServletRequest request)
    {
        City city = null;
        Long id = getId(request);
        if (null != id)
        {
            city = this.cityManager.getCity(id);
        }
        return city;
    }
    
    private Long getId(HttpServletRequest request)
    {
        String id = request.getParameter("id"); //$NON-NLS-1$
        if (null == id)
        {
            return null;
        }
        
        Long lid = null;
        try
        {
            lid = Long.valueOf(id);
        }
        catch (NumberFormatException e)
        {
            // Nothing to do return null;
        }
        return lid;
    }

}
