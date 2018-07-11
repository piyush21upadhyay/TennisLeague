/*
 * PrintCardController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.sageconsulting.Constants;
import com.sageconsulting.model.City;
import com.sageconsulting.model.Course;
import com.sageconsulting.model.Match;
import com.sageconsulting.service.CourseManager;
import com.sageconsulting.service.MatchManager;

public class PrintCardController  extends BaseFormController
{
    private CourseManager courseManager;
    private MatchManager matchManager;
    
    public void setCourseManager(CourseManager mgr)
    {
        this.courseManager = mgr;
    }
    
    public void setMatchManager(MatchManager mgr)
    {
        this.matchManager = mgr;
    }
    
    public PrintCardController()
    {
        super.setCommandName("course"); //$NON-NLS-1$
        super.setCommandClass(Course.class);
    }
    
    @Override
    public ModelAndView showForm(HttpServletRequest request, HttpServletResponse response,
        BindException errors) throws Exception
    {
    	return getModelAndView(request);
    }
    
    @Override
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
        Object command, BindException errors) throws Exception
    {
    	return getModelAndView(request);
    }
    
    private ModelAndView getModelAndView(HttpServletRequest request)
    {
    	ModelAndView view = new ModelAndView();
    	
        City city = (City)request.getSession().getAttribute(Constants.CITY_TOKEN);
        if (null == city)
        {
        	String msg = getMessageSourceAccessor().getMessage("errors.noCity", request.getLocale()); //$NON-NLS-1$
        	view.addObject("successMessages", new String[] { msg });//$NON-NLS-1$
        	return view;
        }
        
        Match match = getMatch(request);
        if (null == match)
        {
        	String msg = getMessageSourceAccessor().getMessage("printcard.noMatch", request.getLocale()); //$NON-NLS-1$
        	view.addObject("errors", new String[] { msg }); //$NON-NLS-1$
        	return view;
        }
        
        Course course = getCourse(request);
        if (null == course)
        {
            course = match.getGolfer1().getHomeCourt();
        }
        match.setCourse(course);
        match.getScore().computeStrokes(course, match.getGolfer1(), match.getGolfer2());

        view.addObject("courseList", getCourseList(city)); //$NON-NLS-1$
        view.addObject("match", match); //$NON-NLS-1$
        return view;
    }
    
    private List<Course> getCourseList(City city)
    {
        return this.courseManager.getCourses(city.getId());
    }
    
    private Long getMatchId(HttpServletRequest request)
    {
        return getIdParam(request, "match"); //$NON-NLS-1$
    }
    
    private Match getMatch(HttpServletRequest request)
    {
        Match match = null;
        Long matchId = getMatchId(request);
        if (null != matchId)
        {
            match =  this.matchManager.getMatch(matchId);
        }
        return match;
    }
    
    private Long getCourseId(HttpServletRequest request)
    {
        return getIdParam(request, "course"); //$NON-NLS-1$
    }
    
    private Course getCourse(HttpServletRequest request)
    {
        Course course = null;
        Long courseId = getCourseId(request);
        if (null != courseId)
        {
            course = this.courseManager.getCourse(courseId);
        }
        return course;
    }
    
    private Long getIdParam(HttpServletRequest request, String name)
    {
        Long id = null;
        String paramId = request.getParameter(name);
        if (null != paramId)
        {
            try
            {
                id = Long.valueOf(paramId);
            }
            catch (NumberFormatException e)
            {
                super.log.warn("Invalid id specified for "+name+": "+paramId); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
        return id;
    }
}
