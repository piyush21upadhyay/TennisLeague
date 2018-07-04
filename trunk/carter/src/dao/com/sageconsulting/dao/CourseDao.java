/*
 * CourseDao.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao;

import java.util.List;

import com.sageconsulting.model.Course;

public interface CourseDao extends Dao
{
    public Course getCourse(Long id);

    public List<Course> getCourses();

    public List<Course> getCoursesForCity(Long cityId);
    
    public List<Course> getCoursesForName(String name);
    
    public List<Course> getCoursesForCityAndName(Long cityId, String name);

    public void saveCourse(Course course);

    public void removeCourse(Long id);
}
