/*
 * MatchManagerImpl.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service.impl;

import java.util.Date;
import java.util.List;

import com.sageconsulting.dao.MatchDao;
import com.sageconsulting.model.Match;
import com.sageconsulting.service.MatchManager;

public class MatchManagerImpl extends BaseManager implements MatchManager
{
    public void setMatchDao(MatchDao mdao)
    {
        super.setDao(mdao);
    }
    
    private MatchDao getMatchDao()
    {
        return (MatchDao)this.dao;
    }
    
    public Match getMatch(Long id)
    {
        return getMatchDao().getMatch(id);
    }
    
    public Match getMatchById(Long id)
    {
        return getMatchDao().getMatchById(id);
    }

    public List<Match> getMatchesForGolfer(Long golferid)
    {
        return getMatchDao().getMatchesForGolfer(golferid);
    }
    
    public List<Match> getMatchesForGolferAndSeason(Long golferid, Long seasonid)
    {
        return getMatchDao().getMatchesForGolferAndSeason(golferid, seasonid);
    }

    public void saveMatch(Match match)
    {
        getMatchDao().saveMatch(match);
    }
    
    public List<Match> getUnderParLeaders(boolean player1, boolean gross, int count, Date start, Date end)
    {
        return getMatchDao().getUnderParLeaders(player1, gross, count, start, end);
    }
    
    public List<Match> getByeMatch(Date mon,Date sun)
    {
    	return getMatchDao().getByeMatch(mon,sun);
    }
}
