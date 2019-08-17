/*
 * SeasonInfo.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;

import com.sageconsulting.model.Match;
import com.sageconsulting.model.Season;
import com.sageconsulting.model.User;
import com.sageconsulting.service.SeasonManager;

public class SeasonInfo
{
    private SeasonManager seasonManager;

    private Long seasonId;

    private Season season;

    private Map<User, SeasonResult> results;

    public void setSeasonManager(SeasonManager mgr)
    {
        this.seasonManager = mgr;
        this.results = new HashMap<User, SeasonResult>(20);
    }

    public Long getSeasonId()
    {
        return this.seasonId;
    }

    public void setSeasonId(Long id)
    {
        this.seasonId = id;
    }

    public Season getSeason()
    {
        return this.season;
    }

    public void setSeason(Season s)
    {
        this.season = s;
    }

    public SeasonResult[] getResults()
    {
        Collection<SeasonResult> coll = this.results.values();
        return coll.toArray(new SeasonResult[coll.size()]);
    }

    public boolean isValidSeason()
    {
        return (null != this.seasonId);
    }

    public void updateResults()
    {
        if (null == this.seasonId)
        {
            return;
        }

        this.season = this.seasonManager.getSeason(this.seasonId);
        updateResults(this.season);
    }

    private void updateResults(Season s)
    {
        if (null == s)
        {
            return;
        }

        SortedSet<Match> matches = s.getMatches();
        for (Match match : matches)
        {
            updateResults(match);
        }
    }

    private void updateResults(Match match)
    {
        if (match.isBye())
        {
            if (null != match.getGolfer1())
            {
                updateWin(match.getGolfer1());
            }
            else if (null != match.getGolfer2())
            {
                updateWin(match.getGolfer2());
            }
        }
        else if (null == match.getPlayed())
        {
            updateUser(match.getGolfer1());
            updateUser(match.getGolfer2());
        }
        else if (match.getResult().isTie())
        {
            updateTie(match.getGolfer1());
            updateTie(match.getGolfer2());
        }
        else if (match.isDefaultWin())
        {
            updateWin(match.getDefaultWinner());
            if (match.getDefaultWinner().equals(match.getGolfer1()))
            {
                updateLoss(match.getGolfer2());
            }
            else
            {
                updateLoss(match.getGolfer1());
            }
        }
        else
        {
            updateWin(match.getResult().getWinner());
            updateLoss(match.getResult().getLoser());
        }
    }

    private void updateUser(User user)
    {
        // Ignore the "bye" user
        if (user == null)
        {
            return;
        }

        SeasonResult result = this.results.get(user);
        if (null == result)
        {
            result = new SeasonResult(user);
            this.results.put(user, result);
        }
    }

    private void updateTie(User user)
    {
        SeasonResult result = getResult(user);
        result.incrementTies();
        this.results.put(user, result);
    }

    private void updateWin(User user)
    {
        // Ignore the "bye" user
        if (user == null)
        {
            return;
        }

        SeasonResult result = getResult(user);
        result.incrementWins();
        this.results.put(user, result);
    }

    private void updateLoss(User user)
    {
        // Ignore the "bye" user
        if (user == null)
        {
            return;
        }

        SeasonResult result = getResult(user);
        result.incrementLosses();
        this.results.put(user, result);
    }

    private SeasonResult getResult(User user)
    {
        SeasonResult result = this.results.get(user);
        if (null == result)
        {
            result = new SeasonResult(user);
        }
        return result;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Collection<SeasonResult> allResults = this.results.values();
        for (SeasonResult result : allResults)
        {
            sb.append(result.getUser().getFullName());
            sb.append(": "); //$NON-NLS-1$
            sb.append(result.getPoints()).append(" "); //$NON-NLS-1$
            sb.append(result.getWins()).append(" "); //$NON-NLS-1$
            sb.append(result.getLosses()).append(" "); //$NON-NLS-1$
            sb.append(result.getTies()).append(" "); //$NON-NLS-1$
            //sb.append(result.getUser().getHandicap());
            sb.append("\r\n"); //$NON-NLS-1$
        }
        return sb.toString();
    }
    
    /**
     * Get the current results of the passed in season sorted in order of users
     * with most points to least.
     * @param mgr The season manager to use to get season information
     * @param seasonId The id of the season to get the results for.
     * @return The sorted list of results for the passed in season.
     */
    public static SeasonResult[] getSortedSeasonResults(SeasonManager mgr, Long seasonId)
    {
        SeasonInfo seasonInfo = new SeasonInfo();
        seasonInfo.setSeasonId(seasonId);
        seasonInfo.setSeasonManager(mgr);
        seasonInfo.updateResults();
        SeasonResult[] results = seasonInfo.getResults();
        
        Arrays.sort(results, new Comparator<SeasonResult>()
        {
            public int compare(SeasonResult result1, SeasonResult result2)
            {
                if (result1.getPoints() == result2.getPoints())
                {
                	if(result1.getWins() == result2.getWins()) // if both have 0 wins
                	{
                		if (result1.getWins() > 0 && result2.getWins() > 0) {
                			Double percentageOfGamesWonByPlayer1 = Double.valueOf(result1.getUser().getGamesWonPercentage());
                			Double percentageOfGamesWonByPlayer2 = Double.valueOf(result2.getUser().getGamesWonPercentage());
                			return (percentageOfGamesWonByPlayer1.compareTo(percentageOfGamesWonByPlayer2));
                		}
                		
                		// logic to handle 0 wins/points, atleast played a match
                		if(result1.getPoints() == 0 && result2.getPoints() == 0
                				&& result1.getWins() == 0 && result2.getWins() == 0)
                		{
                			if(result1.getLosses() == 0 && result2.getLosses() > 0)
                				return 1;
                			if(result2.getLosses() == 0 && result1.getLosses() > 0)
                				return -1;
                		}
                		
            			if(result1.getLosses() == result2.getLosses()) //wins are equal but not 0
            			{
                           	return -1;
            			}
            			else if(result1.getLosses() > result2.getLosses())
                			return 1;
                		return -1;
                	}
                	else if(result1.getWins() < result2.getWins())
                		return 1;
                	return -1;
                }
                else if (result1.getPoints() < result2.getPoints())
                {
                    return 1;
                }
                return -1;
            }
        });
        
        return results;
    }
}
