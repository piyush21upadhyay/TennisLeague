/*
 * ChampionManagerImpl.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service.impl;

import java.util.List;

import com.sageconsulting.dao.ChampionDao;
import com.sageconsulting.model.Champion;
import com.sageconsulting.service.ChampionManager;

public class ChampionManagerImpl extends BaseManager implements ChampionManager
{
    public void setChampionDao(ChampionDao cdao)
    {
        super.setDao(cdao);
    }
    
    private ChampionDao getChampionDao()
    {
        return (ChampionDao)super.dao;
    }

    public Champion getChampion(Long id)
    {
        return getChampionDao().getChampion(id);
    }

    public void saveChampion(Champion champion)
    {
        getChampionDao().saveChampion(champion);
    }

    public List<Champion> getChampions(Long cityId, Integer year)
    {
        return getChampionDao().getChampions(cityId, year);
    }
    
    public List<Integer> getChampionYears(Long cityId)
    {
        return getChampionDao().getChampionYears(cityId);
    }
}
