/*
 * SeasonManager.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service;

import java.util.List;

import com.sageconsulting.model.Season;

public interface SeasonManager
{
    public Season getSeason(Long id);
    
    public List<Season> getSeasons();
    
    public List<Season> getSeasonsForRegistration(Long registrationId);
    
    public List<Season> getOpenSeasons();
    
    public List<Season> getOpenSeasonsForCity(Long cityId);
    
    public List<Season> getClosedSeasons();
    
    public void saveSeason(Season season);
}
