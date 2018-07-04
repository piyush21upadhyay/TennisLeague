/*
 * CourseDetailsController.java
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
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sageconsulting.Constants;
import com.sageconsulting.model.City;
import com.sageconsulting.model.Course;
import com.sageconsulting.service.CourseManager;

public class CourseDetailsController extends ApplicationObjectSupport implements Controller
{
    private static final Log log = LogFactory.getLog(CourseDetailsController.class);
    
    private CourseManager courseManager;
    
    public void setCourseManager(CourseManager mgr)
    {
        this.courseManager = mgr;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ModelAndView view = new ModelAndView();
        
        City city = (City)request.getSession().getAttribute(Constants.CITY_TOKEN);
        if (null == city)
        {
        	String msg = getMessageSourceAccessor().getMessage("errors.noCity", request.getLocale()); //$NON-NLS-1$
        	view.addObject("successMessages", new String[] { msg });//$NON-NLS-1$
        	return view;
        }
        
        Course course = getCourse(request);
        if (null == course)
        {
        	String msg = getMessageSourceAccessor().getMessage("coursedetails.noCourse", request.getLocale()); //$NON-NLS-1$
        	view.addObject("successMessages", new String[] { msg });//$NON-NLS-1$
        	return view;
        }

        view.addObject("course", course); //$NON-NLS-1$
        return view;
    }
    
    private Course getCourse(HttpServletRequest request)
    {
    	Long id = getCourseId(request);
    	if (null != id)
    	{
    		return this.courseManager.getCourse(id);
    	}
    	
    	return null;
    }

    private Long getCourseId(HttpServletRequest request)
    {
        Long id = null;
        String strCourse = request.getParameter("id"); //$NON-NLS-1$
        if (null != strCourse)
        {
            try
            {
                id = Long.valueOf(strCourse);
            }
            catch (NumberFormatException e)
            {
                log.error("Invalid course id: "+strCourse); //$NON-NLS-1$
            }
        }
        
        return id;
    }
}
