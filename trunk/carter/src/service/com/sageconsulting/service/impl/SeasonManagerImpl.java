/*
 * SeasonManagerImpl.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service.impl;

import java.util.List;

import com.sageconsulting.dao.SeasonDao;
import com.sageconsulting.model.Season;
import com.sageconsulting.service.SeasonManager;

public class SeasonManagerImpl extends BaseManager implements SeasonManager
{
    public void setSeasonDao(SeasonDao sdao)
    {
        super.setDao(sdao);
    }
    
    private SeasonDao getSeasonDao()
    {
        return (SeasonDao)this.dao;
    }
    
    public Season getSeason(Long id)
    {
        return getSeasonDao().getSeason(id);
    }
    
    public List<Season> getSeasonsForRegistration(Long registrationId)
    {
        return getSeasonDao().getSeasonsForRegistration(registrationId);
    }
    
    public List<Season> getOpenSeasons()
    {
        return getSeasonDao().getOpenSeasons();
    }
    
    public List<Season> getOpenSeasonsForCity(Long cityId)
    {
        return getSeasonDao().getOpenSeasonsForCity(cityId);
    }
    
    public List<Season> getClosedSeasons()
    {
        return getSeasonDao().getClosedSeasons();
    }

    public List<Season> getSeasons()
    {
        return getSeasonDao().getSeasons();
    }

    public void saveSeason(Season season)
    {
        getSeasonDao().saveSeason(season);
    }
}
