/*
 * CourseManagerImpl.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service.impl;

import java.util.List;

import com.sageconsulting.dao.CourseDao;
import com.sageconsulting.model.Course;
import com.sageconsulting.service.CourseManager;

public class CourseManagerImpl extends BaseManager implements CourseManager
{
    public void setCourseDao(CourseDao courseDao)
    {
        super.setDao(courseDao);
    }
    
    private CourseDao getCourseDao()
    {
        return (CourseDao)super.dao;
    }
    
    public Course getCourse(Long id)
    {
        return getCourseDao().getCourse(id);
    }
    
    public List<Course> getCourses()
    {
        return getCourseDao().getCourses();
    }
    
    public List<Course> getCourses(Long cityId)
    {
        return getCourseDao().getCoursesForCity(cityId);
    }
    
    public List<Course> getCourses(String name)
    {
        return getCourseDao().getCoursesForName(name);
    }
    
    public List<Course> getCourses(Long cityId, String name)
    {
        return getCourseDao().getCoursesForCityAndName(cityId, name);
    }
    
    public void saveCourse(Course course)
    {
        getCourseDao().saveCourse(course);
    }
    
    public void removeCourse(Long id)
    {
        getCourseDao().removeCourse(id);
    }
}
