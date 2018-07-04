/*
 * ChampionManager.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service;

import java.util.List;

import com.sageconsulting.model.Champion;

public interface ChampionManager extends Manager
{
    public Champion getChampion(Long id);
    public void saveChampion(Champion champion);
    public List<Champion> getChampions(Long cityId, Integer year);
    public List<Integer> getChampionYears(Long cityId);
}
