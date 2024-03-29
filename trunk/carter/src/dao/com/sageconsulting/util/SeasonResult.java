/*
 * SeasonResult.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.util;

import java.util.SortedSet;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.sageconsulting.model.Match;
import com.sageconsulting.model.User;

public class SeasonResult
{
    private User user;
    private int wins;
    private int losses;
    private int ties;
        
    public SeasonResult(User u)
    {
        this.user = u;
    }
    
    public User getUser() { return this.user; }
    
    public int getWins() { return this.wins; }
    public void incrementWins() { this.wins++; }
    
    public int getLosses() { return this.losses; }
    public void incrementLosses() { this.losses++; }
    
    public int getTies() { return this.ties; }
    public void incrementTies() { this.ties++; }
    
    public int getPoints()
    {
    	int seasonPoints = 0;
    	if(this.user != null && this.user.getCurrentSeason() != null)
    	{	
    	SortedSet<Match> matches = this.user.getCurrentSeason().getMatches();
    	if(null != matches)
    	{
    		for(Match match : matches)
	    	{
	    		if(match.getPlayed() != null)
	    		{
		    		boolean isStraightWin = false;
		    		boolean isStraightLose = false;
		    		int numberOfSetsWon = 0;
		    		int pointsForMatch = 0;
		    		
		    		if(null != match.getDefaultWinner() && this.user.getId() == match.getDefaultWinner().getId())
		    		{
		    			pointsForMatch += 2;
		    		}
		    		
		    		else if(null != match.getScore().getOpponentRetired() 
		    				&& (this.user.getId() == match.getGolfer1().getId() || this.user.getId() == match.getGolfer2().getId()))
		    		{
		    			if(!this.user.getId().equals(match.getScore().getOpponentRetired()))
		    				pointsForMatch += 3;
		    		}
		    		else if(match.getGolfer1().getId() == this.user.getId())
		    		{
			    		if(match.getScore().getPlayer1set1() > match.getScore().getPlayer2set1()){
			    			pointsForMatch += 1;
			    			if(match.getScore().getPlayer1set2() > match.getScore().getPlayer2set2())
			    			{
			    				pointsForMatch +=3;
			    				isStraightWin = true;
			    			}
			    			numberOfSetsWon++;
			    		}
			    		if(match.getScore().getPlayer1set2() > match.getScore().getPlayer2set2() && !isStraightWin)
		    			{
		    				pointsForMatch +=1;
		    				numberOfSetsWon++;
		    			}
			    		if(numberOfSetsWon == 0)
			    		{
			    			isStraightLose = true;
			    		}
			    		if(match.getScore().getPlayer1set3() > match.getScore().getPlayer2set3() && !isStraightWin && !isStraightLose)
			    		{
			    			pointsForMatch += 1;
			    			numberOfSetsWon++;
			    		}
			    		if(numberOfSetsWon > 1)
			    			pointsForMatch += 1;
		    		}
		    		else if(match.getGolfer2().getId() == this.user.getId() )
		    		{
		    			if(match.getScore().getPlayer2set1() > match.getScore().getPlayer1set1()){
			    			pointsForMatch += 1;
			    			if(match.getScore().getPlayer2set2() > match.getScore().getPlayer1set2())
			    			{
			    				pointsForMatch +=3;
			    				isStraightWin = true;
			    			}
			    			numberOfSetsWon++;
			    		}
		    			if(match.getScore().getPlayer2set2() > match.getScore().getPlayer1set2() && !isStraightWin)
		    			{
		    				pointsForMatch +=1;
		    				numberOfSetsWon++;
		    			}
		    			if(numberOfSetsWon == 0)
			    		{
			    			isStraightLose = true;
			    		}
			    		if(match.getScore().getPlayer2set3() > match.getScore().getPlayer1set3() && !isStraightWin && !isStraightLose)
			    		{
			    			pointsForMatch += 1;
			    			numberOfSetsWon++;
			    		}
			    		if(numberOfSetsWon > 1)
			    			pointsForMatch += 1;
		    		}
		    			seasonPoints += pointsForMatch; 
	    		}
	    		else if(match.isBye())
	    		{
	    			if((null != match.getGolfer1() && this.user.getId() == match.getGolfer1().getId()) 
	    					|| (null != match.getGolfer2() && this.user.getId() == match.getGolfer2().getId()))
	    				seasonPoints += 2;
	    		}
	    		
	    	}
    	}
    }
    	
    	return seasonPoints;
    }
    
    @Override
    public int hashCode()
    {
        return this.user.hashCode();
    }
    
    @Override
    public boolean equals(Object o)
    {
        SeasonResult other = (SeasonResult)o;
        return this.user.equals(other.user);
    }
    
    @Override
    public String toString()
    {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
        sb.append("user", this.user.getFullName()); //$NON-NLS-1$
        sb.append("wins", this.wins); //$NON-NLS-1$
        sb.append("losses", this.losses); //$NON-NLS-1$
        sb.append("ties", this.ties); //$NON-NLS-1$
        return sb.toString();
    }
}
