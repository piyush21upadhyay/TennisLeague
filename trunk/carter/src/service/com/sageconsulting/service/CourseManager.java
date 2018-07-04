/*
 * CourseManager.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service;

import java.util.List;

import com.sageconsulting.dao.CourseDao;
import com.sageconsulting.model.Course;

public interface CourseManager
{
    public void setCourseDao(CourseDao courseDao);
    
    public Course getCourse(Long id);
    
    public List<Course> getCourses();
    
    public List<Course> getCourses(Long cityId);
    
    public List<Course> getCourses(String name);
    
    public List<Course> getCourses(Long cityId, String name);
    
    public void saveCourse(Course course);
    
    public void removeCourse(Long id);
}
