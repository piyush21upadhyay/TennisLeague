/*
 * MatchDao.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao;

import java.util.Date;
import java.util.List;

import com.sageconsulting.model.Match;

public interface MatchDao extends Dao
{

    public Match getMatch(Long id);
    
    public Match getMatchById(Long id);

    public List<Match> getMatchesForGolfer(Long golferid);
    
    public List<Match> getMatchesForGolferAndSeason(Long golferid, Long seasonid);

    public void saveMatch(Match match);
    
    public List<Match> getUnderParLeaders(boolean player1, boolean gross, int count, Date start, Date end);
    
    public List<Match> getByeMatch(Date mon,Date sun);
}
