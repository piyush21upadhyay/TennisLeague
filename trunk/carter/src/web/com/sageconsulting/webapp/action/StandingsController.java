/*
 * StandingsController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.Date;
import java.util.SortedSet;

import org.springframework.web.servlet.ModelAndView;

import com.sageconsulting.model.Match;
import com.sageconsulting.model.Season;
import com.sageconsulting.util.DateUtil;
import com.sageconsulting.util.SeasonInfo;
import com.sageconsulting.util.SeasonResult;

public class StandingsController extends BaseSeasonResultController
{
	private static final String CMD_NAME = "season"; //$NON-NLS-1$

	//private static final long MS_IN_DAY = 86400000;
    
    public StandingsController()
    {
        setCommandName(CMD_NAME);
        setCommandClass(Object.class);
    }
    
    @Override
	protected void updateModelAndView(Season currentSeason, ModelAndView view)
    {
        if (null != currentSeason)
        {
        	view.addObject("results", getSeasonResults(currentSeason)); //$NON-NLS-1$
        }
        else
        {
        	view.addObject("emptyResults", getEmptyResults()); //$NON-NLS-1$
        }
        String playoffCounter = getPlayoffCountdown(currentSeason);
        if((playoffCounter != null) && (!playoffCounter.equals("0")))
        	view.addObject("playoffCounter", playoffCounter); //$NON-NLS-1$
        view.addObject("playoffStarted", getPlayoffStarted(currentSeason));
    }
    
    private SeasonResult[] getSeasonResults(Season season)
    {
    	return SeasonInfo.getSortedSeasonResults(getSeasonManager(), season.getId());
    }
    
    private SeasonResult[] getEmptyResults()
    {
    	int count = 15;
    	SeasonResult empty = new SeasonResult(null);
    	SeasonResult[] results = new SeasonResult[count];
    	for (int i=0; i<count; i++)
    	{
    		results[i] = empty;
    	}
    	
    	return results;
    }
    
    private String getPlayoffCountdown(Season season)
    {
    	if ((null == season) || (season.getState().intValue() == Season.STATE_CLEAR))
    		return null;
    	
    	Date date = season.getCity().getCountDownDate();
    	int weeks = getWeeksInSeason(season.getMatches());
    	date = new Date(date.getTime() + (long)weeks * 7L * DateUtil.MS_IN_DAY);
    	return Integer.toString(DateUtil.computeDaysToDate(date));
    }
    
    private int getWeeksInSeason(SortedSet<Match> matches)
    {
    	// TODO: this should not be hard coded.  We probably need to have it in the season.
    	return 4;
    }
    
    private int getPlayoffStarted(Season currentSeason)
    {
    	int playoffStarted = 0;
    	if(currentSeason != null)
    	{
    		try{
    			if(currentSeason.getState().intValue() == 2)
    				playoffStarted = 1;
    		}
    		catch(Exception exp){
    			playoffStarted = Integer.valueOf(0);
    		}
    	}
    	return playoffStarted;
    }
}
