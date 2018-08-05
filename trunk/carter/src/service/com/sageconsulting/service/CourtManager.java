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

import com.sageconsulting.dao.CourtDao;
import com.sageconsulting.model.Court;

public interface CourtManager
{
    public void setCourtDao(CourtDao courtDao);
    
    public Court getCourt(Long id);

    public List<Court> getCourts();

    public List<Court> getCourts(Long cityId);
    
    public List<Court> getCourts(String name);
    
    public List<Court> getCourts(Long cityId, String name);

    public void saveCourt(Court Court);

    public void removeCourt(Long id);

}
