/*
 * CourseDaoHibernate.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao.hibernate;

import java.util.List;

import com.sageconsulting.dao.CourseDao;
import com.sageconsulting.model.Course;

public class CourseDaoHibernate extends BaseDaoHibernate implements CourseDao
{
    public Course getCourse(Long id)
    {
        return (Course) getHibernateTemplate().get(Course.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Course> getCourses()
    {
        return getHibernateTemplate().find("from Course c order by c.name"); //$NON-NLS-1$
    }

    @SuppressWarnings("unchecked")
    public List<Course> getCoursesForCity(Long cityId)
    {
        return getHibernateTemplate().find("from Course c where ? in elements(c.cities) order by c.name", cityId); //$NON-NLS-1$
    }
    
    @SuppressWarnings("unchecked")
    public List<Course> getCoursesForName(String name)
    {
        StringBuilder sb = new StringBuilder("from Course c where c.name like '%"). //$NON-NLS-1$
            append(name).append("%' order by c.name"); //$NON-NLS-1$
        return getHibernateTemplate().find(sb.toString());
    }
    
    @SuppressWarnings("unchecked")
    public List<Course> getCoursesForCityAndName(Long cityId, String name)
    {
        if ((cityId.longValue() <= 0) && (null == name))
        {
            return getCourses();
        }
        else if (null == name)
        {
            return getCoursesForCity(cityId);
        }
        else if (cityId.longValue() <= 0)
        {
            return getCoursesForName(name);
        }
        
        StringBuilder sb = new StringBuilder("from Course c where "). //$NON-NLS-1$
            append(cityId).append(" in elements(cities) and c.name like '%"). //$NON-NLS-1$
            append(name).append("%' order by c.name"); //$NON-NLS-1$
         return getHibernateTemplate().find(sb.toString());
    }

    public void saveCourse(Course course)
    {
        getHibernateTemplate().saveOrUpdate(course);
        // necessary to throw a DataIntegrityViolation
        // getHibernateTemplate().flush();
    }

    public void removeCourse(Long id)
    {
        getHibernateTemplate().delete(getCourse(id));
    }
}
