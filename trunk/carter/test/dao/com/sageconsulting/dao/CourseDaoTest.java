/*
 * CourseDaoTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao;

import java.util.ArrayList;
import java.util.List;

import com.sageconsulting.model.City;
import com.sageconsulting.model.Course;

public class CourseDaoTest extends BaseDaoTestCase
{
    private CityDao cityDao;

    private CourseDao courseDao;

    public CourseDaoTest()
    {
        //super.setDefaultRollback(false);
    }

    public void setCityDao(CityDao dao)
    {
        this.cityDao = dao;
    }

    public void setCourseDao(CourseDao dao)
    {
        this.courseDao = dao;
    }

    @SuppressWarnings("boxing")
    public void testSaveCourse()
    {
        City portland = this.cityDao.getCity(Long.valueOf(1));
        List<City> cities = new ArrayList<City>();
        cities.add(portland);

        Course course = newCourse(cities); 
        course.setCities(cities);
        course.setName("Eastmoreland"); //$NON-NLS-1$
        course.setMensPars(new Byte[] { 4, 4, 4, 4, 3, 5, 4, 3, 5, 4, 5, 3, 5, 4, 4, 4, 3, 4 });
        course.setMensHandicaps(new Byte[] { 13, 3, 11, 9, 17, 1, 5, 15, 7, 14, 8, 18, 2, 12, 10, 4, 16, 6 });
        course.setMensYardages(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
        course.setMensRating(Float.valueOf(74.4f));
        course.setMensSlope(Integer.valueOf(115));
        course.setWomensPars(new Byte[] { 4, 4, 4, 4, 3, 5, 4, 3, 5, 4, 5, 3, 5, 4, 4, 4, 3, 4 });
        course.setWomensHandicaps(new Byte[] { 13, 3, 11, 9, 17, 1, 5, 15, 7, 14, 8, 18, 2, 12, 10, 4, 16, 6 });
        course.setWomensYardages(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
        course.setWomensRating(Float.valueOf(74.4f));
        course.setWomensSlope(Integer.valueOf(115));
        this.courseDao.saveCourse(course);
        //Course c = this.courseDao.getCourse(course.getId());
        //assertNotNull(c);
        
        course = newCourse(cities); 
        course.setName("Heron Lakes Great Blue"); //$NON-NLS-1$
        course.setMensPars(new Byte[] { 4, 5, 4, 3, 5, 3, 4, 4, 4, 4, 3, 5, 4, 4, 3, 4, 5, 4 });
        course.setMensHandicaps(new Byte[] { 9, 5, 17, 15, 1, 13, 11, 3, 7, 12, 18, 2, 10, 14, 16, 8, 4, 6 });
        course.setMensYardages(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
        course.setMensRating(Float.valueOf(74.4f));
        course.setMensSlope(Integer.valueOf(115));
        course.setWomensPars(new Byte[] { 4, 4, 4, 4, 3, 5, 4, 3, 5, 4, 5, 3, 5, 4, 4, 4, 3, 4 });
        course.setWomensHandicaps(new Byte[] { 13, 3, 11, 9, 17, 1, 5, 15, 7, 14, 8, 18, 2, 12, 10, 4, 16, 6 });
        course.setWomensYardages(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
        course.setWomensRating(Float.valueOf(74.4f));
        course.setWomensSlope(Integer.valueOf(115));
        this.courseDao.saveCourse(course);
        
        course = newCourse(cities); 
        course.setName("Heron Lakes Greenback"); //$NON-NLS-1$
        course.setMensPars(new Byte[] { 5, 4, 3, 4, 5, 4, 3, 4, 4, 5, 4, 4, 5, 3, 4, 3, 4, 4 });
        course.setMensHandicaps(new Byte[] { 2, 10, 18, 6, 4, 8, 16, 14, 12, 5, 9, 3, 1, 11, 17, 13, 15, 7 });
        course.setMensYardages(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
        course.setMensRating(Float.valueOf(74.4f));
        course.setMensSlope(Integer.valueOf(115));
        course.setWomensPars(new Byte[] { 4, 4, 4, 4, 3, 5, 4, 3, 5, 4, 5, 3, 5, 4, 4, 4, 3, 4 });
        course.setWomensHandicaps(new Byte[] { 13, 3, 11, 9, 17, 1, 5, 15, 7, 14, 8, 18, 2, 12, 10, 4, 16, 6 });
        course.setWomensYardages(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
        course.setWomensRating(Float.valueOf(74.4f));
        course.setWomensSlope(Integer.valueOf(115));
        this.courseDao.saveCourse(course);
        
        course = newCourse(cities); 
        course.setName("Rose City"); //$NON-NLS-1$
        course.setMensPars(new Byte[] { 4, 5, 4, 4, 3, 4, 4, 3, 4, 5, 5, 3, 4, 4, 3, 5, 4, 4 });
        course.setMensHandicaps(new Byte[] { 9, 5, 15, 17, 13, 3, 11, 7, 1, 6, 12, 10, 8, 14, 18, 16, 4, 2 });
        course.setMensYardages(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
        course.setMensRating(Float.valueOf(74.4f));
        course.setMensSlope(Integer.valueOf(115));
        course.setWomensPars(new Byte[] { 4, 4, 4, 4, 3, 5, 4, 3, 5, 4, 5, 3, 5, 4, 4, 4, 3, 4 });
        course.setWomensHandicaps(new Byte[] { 13, 3, 11, 9, 17, 1, 5, 15, 7, 14, 8, 18, 2, 12, 10, 4, 16, 6 });
        course.setWomensYardages(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
        course.setWomensRating(Float.valueOf(74.4f));
        course.setWomensSlope(Integer.valueOf(115));
        this.courseDao.saveCourse(course);
        
        course = newCourse(cities); 
        course.setName("RedTail"); //$NON-NLS-1$
        course.setMensPars(new Byte[] { 4, 3, 4, 4, 4, 3, 5, 4, 5, 4, 4, 3, 4, 5, 4, 3, 4, 5 });
        course.setMensHandicaps(new Byte[] { 13, 17, 15, 3, 5, 11, 1, 9, 7, 12, 4, 18, 8, 16, 2, 14, 16, 10 });
        course.setMensYardages(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
        course.setMensRating(Float.valueOf(74.4f));
        course.setMensSlope(Integer.valueOf(115));
        course.setWomensPars(new Byte[] { 4, 4, 4, 4, 3, 5, 4, 3, 5, 4, 5, 3, 5, 4, 4, 4, 3, 4 });
        course.setWomensHandicaps(new Byte[] { 13, 3, 11, 9, 17, 1, 5, 15, 7, 14, 8, 18, 2, 12, 10, 4, 16, 6 });
        course.setWomensYardages(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
        course.setWomensRating(Float.valueOf(74.4f));
        course.setWomensSlope(Integer.valueOf(115));
        this.courseDao.saveCourse(course);
        
        course = newCourse(cities); 
        course.setName("Broadmoor"); //$NON-NLS-1$
        course.setMensPars(new Byte[] { 4, 3, 4, 4, 5, 4, 4, 4, 4, 4, 3, 4, 5, 5, 3, 5, 3, 4 });
        course.setMensHandicaps(new Byte[] { 1, 17, 15, 7, 3, 9, 11, 13, 15, 18, 16, 2, 4, 6, 10, 12, 14, 8 });
        course.setMensYardages(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
        course.setMensRating(Float.valueOf(74.4f));
        course.setMensSlope(Integer.valueOf(115));
        course.setWomensPars(new Byte[] { 4, 4, 4, 4, 3, 5, 4, 3, 5, 4, 5, 3, 5, 4, 4, 4, 3, 4 });
        course.setWomensHandicaps(new Byte[] { 13, 3, 11, 9, 17, 1, 5, 15, 7, 14, 8, 18, 2, 12, 10, 4, 16, 6 });
        course.setWomensYardages(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
        course.setWomensRating(Float.valueOf(74.4f));
        course.setWomensSlope(Integer.valueOf(115));
        this.courseDao.saveCourse(course);
        
        course = newCourse(cities); 
        course.setName("Colwood"); //$NON-NLS-1$
        course.setMensPars(new Byte[] { 4, 4, 3, 3, 5, 4, 4, 3, 5, 4, 4, 4, 3, 4, 5, 4, 3, 5 });
        course.setMensHandicaps(new Byte[] { 9, 1, 13, 7, 3, 17, 15, 11, 5, 2, 12, 18, 10, 4, 14, 16, 8, 6 });
        course.setMensYardages(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
        course.setMensRating(Float.valueOf(74.4f));
        course.setMensSlope(Integer.valueOf(115));
        course.setWomensPars(new Byte[] { 4, 4, 4, 4, 3, 5, 4, 3, 5, 4, 5, 3, 5, 4, 4, 4, 3, 4 });
        course.setWomensHandicaps(new Byte[] { 13, 3, 11, 9, 17, 1, 5, 15, 7, 14, 8, 18, 2, 12, 10, 4, 16, 6 });
        course.setWomensYardages(new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
        course.setWomensRating(Float.valueOf(74.4f));
        course.setWomensSlope(Integer.valueOf(115));
        this.courseDao.saveCourse(course);
    }

    @Override
    public void onTearDownAfterTransaction()
    {
        // super.onTearDownAfterTransaction()
    }
    
    private Course newCourse(List<City> cities)
    {
        Course course = new Course();
        course.setCities(cities);
        return course;
    }
}
