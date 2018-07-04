/*
 * CourseFormController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.sageconsulting.model.City;
import com.sageconsulting.model.Course;
import com.sageconsulting.model.LabelValue;
import com.sageconsulting.service.CityManager;
import com.sageconsulting.service.CourseManager;

public class CourseFormController extends BaseFormController
{
    private CityManager cityManager;
    private CourseManager courseManager;
    
    public void setCityManager(CityManager mgr)
    {
        this.cityManager = mgr;
    }
    
    public void setCourseManager(CourseManager mgr)
    {
        this.courseManager = mgr;
    }
    
    public CourseFormController()
    {
        super.setCommandName("course"); //$NON-NLS-1$
        super.setCommandClass(Course.class);
    }
    
    @Override
    public ModelAndView showForm(HttpServletRequest request, HttpServletResponse response,
        BindException errors) throws Exception
    {
        ModelAndView view = super.showForm(request, response, errors);
        view.addObject("cityList", getCityList()); //$NON-NLS-1$
        return view;
    }
    
    private List<LabelValue> getCityList()
    {
        List<City> cities = this.cityManager.getCities();
        
        List<LabelValue> cityList = new ArrayList<LabelValue>();

        if (cities != null)
        {
            for (Iterator<City> it = cities.iterator(); it.hasNext();)
            {
                City city = it.next();

                // convert the user's roles to LabelValue Objects
                cityList.add(new LabelValue(city.getName(), city.getName()));
            }
        }

        return cityList;
    }
    
    @Override
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
        Object command, BindException errors) throws Exception
    {
        Course course = (Course)command;
        String[] cities = request.getParameterValues("courseCities"); //$NON-NLS-1$

        if (cities != null)
        {
            if (null != course.getCities())
            {
                course.getCities().clear();
            }
            for (String cityName : cities)
            {
                course.addCity(this.cityManager.getCityByName(cityName));
            }
        }
        this.courseManager.saveCourse(course);

        return super.onSubmit(request, response, command, errors);
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception
    {
        if (!isFormSubmission(request))
        {
            Long id = getCourseId(request);
            if (null != id)
            {
                Course course = this.courseManager.getCourse(id);
                if (null != course)
                {
                    return course;
                }
            }
        }
        return super.formBackingObject(request);
    }
    
    private Long getCourseId(HttpServletRequest request)
    {
        String strId = request.getParameter("id"); //$NON-NLS-1$
        if (null != strId)
        {
            try
            {
                return Long.valueOf(strId);
            }
            catch (NumberFormatException e)
            {
                this.log.warn("Invalid id: "+strId); //$NON-NLS-1$
            }
        }
        return null;
    }
}
