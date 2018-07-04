/*
 * UnderParLeaderManagerImpl.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;

import com.sageconsulting.model.Match;
import com.sageconsulting.model.MatchScore;
import com.sageconsulting.model.Registration;
import com.sageconsulting.model.Season;
import com.sageconsulting.model.UnderParLeader;
import com.sageconsulting.model.User;
import com.sageconsulting.service.RegistrationManager;
import com.sageconsulting.service.SeasonManager;
import com.sageconsulting.service.UnderParLeaderManager;

public class UnderParLeaderManagerImpl implements UnderParLeaderManager
{
    private RegistrationManager registrationManager;
    private SeasonManager seasonManager;
    
    public void setRegistrationManager(RegistrationManager mgr)
    {
        this.registrationManager = mgr;
    }
    
    public void setSeasonManager(SeasonManager mgr)
    {
        this.seasonManager = mgr;
    }

    public List<UnderParLeader> getUnderParLeaders(Long registrationId)
    {
        List<UnderParLeader> leaders = new ArrayList<UnderParLeader>();
        Registration r = this.registrationManager.getRegistration(registrationId);
        if (null == r)
        {
            return leaders;
        }
        
        List<Season> seasons = this.seasonManager.getSeasonsForRegistration(registrationId);
        for (Season season : seasons)
        {
        	SortedSet<Match> matches = season.getMatches();
        	for (Match match : matches)
        	{
        		if ((match.getPlayed() != null) && (!match.isBye()) && (!match.isDefaultWin()))
        		{
        			UnderParLeader leader = getUnderParLeader(season, match, 1);
        			if (null != leader)
        			{
        				leaders.add(leader);
        			}
        			leader = getUnderParLeader(season, match, 2);
        			if (null != leader)
        			{
        				leaders.add(leader);
        			}
        		}
        	}
        }

        sort(leaders);
        return leaders;
    }
    
    private UnderParLeader getUnderParLeader(Season season, Match match, int whichScore)
    {
    	UnderParLeader upl = null;
		MatchScore score = match.getScore();
    	if (whichScore == 1)
    	{
    		User user = match.getGolfer1();
    		upl = new UnderParLeader(user, season, match.getRound().intValue(),
    			score.getPlayer1NetBirdies(), score.getPlayer1NetEagles(), score.getPlayer1NetDoubleEagles(),
    			score.getPlayer1Birdies(), score.getPlayer1Eagles(), score.getPlayer1DoubleEagles());
    	}
    	else if (whichScore == 2)
    	{
    		User user = match.getGolfer2();
    		upl = new UnderParLeader(user, season, match.getRound().intValue(),
    			score.getPlayer2NetBirdies(), score.getPlayer2NetEagles(), score.getPlayer2NetDoubleEagles(),
    			score.getPlayer2Birdies(), score.getPlayer2Eagles(), score.getPlayer2DoubleEagles());
    	}
    	return upl;
    }
    
    private void sort(List<UnderParLeader> leaders)
    {
    	Collections.sort(leaders, new Comparator<UnderParLeader>()
    	{

			public int compare(UnderParLeader leader1, UnderParLeader leader2)
			{
				if (!leader1.getSeason().getDivision().equals(leader2.getSeason().getDivision()))
				{
					return leader1.getSeason().getDivision().compareTo(leader2.getSeason().getDivision());
				}
				if (leader1.getRound() < leader2.getRound())
				{
					return -1;
				}
				else if (leader1.getRound() > leader2.getRound())
				{
					return 1;
				}
				
				if (leader1.getNetPoints() < leader2.getNetPoints())
				{
					return 1;
				}
				else if (leader1.getNetPoints() > leader2.getNetPoints())
				{
					return -1;
				}
				
				return 0;
			}
    	});
    }
}
