/*
 * CoursesController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sageconsulting.Constants;
import com.sageconsulting.model.City;
import com.sageconsulting.service.CourseManager;

public class CoursesController extends ApplicationObjectSupport implements Controller
{
    private CourseManager courseManager;
    
    public void setCourseManager(CourseManager mgr)
    {
        this.courseManager = mgr;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ModelAndView view = new ModelAndView(); //super.onSubmit(request, response, command, errors);
        City city = (City)request.getSession().getAttribute(Constants.CITY_TOKEN);
        if (null == city)
        {
        	String msg = getMessageSourceAccessor().getMessage("errors.noCity", request.getLocale()); //$NON-NLS-1$
        	view.addObject("successMessages", new String[] { msg });//$NON-NLS-1$
            return view;
        }
        
        view.addObject("courseList", this.courseManager.getCourses(city.getId())); //$NON-NLS-1$
        
        return view;
    }
}
