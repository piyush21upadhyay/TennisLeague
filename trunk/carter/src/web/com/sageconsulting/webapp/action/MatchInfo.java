/*
 * MatchInfo.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.Date;

import com.sageconsulting.model.Match;
import com.sageconsulting.model.User;

/**
 * Simple class to make it easier to display matches in a format that
 * shows the current user first and whether they are the home or away
 * golfer.
 */
public final class MatchInfo
{
    private User currentUser;
    private Match match;
    
    public MatchInfo(User user, Match m)
    {
        this.currentUser = user;
        this.match = m;
    }
    
    public Long getId()
    {
        return this.match.getId();
    }
    
    public User getGolfer1()
    {
        return this.currentUser;
    }
    
    public User getGolfer2()
    {
        if (this.currentUser.equals(this.match.getGolfer1()))
        {
            return this.match.getGolfer2();
        }
        return this.match.getGolfer1();
    }
    
    public Boolean getHome()
    {
        if (this.currentUser.equals(this.match.getGolfer1()))
        {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
    
    public String getCssClass()
    {
        if (getHome().booleanValue())
        {
            return "home"; //$NON-NLS-1$
        }
        return "away"; //$NON-NLS-1$
    }
    
    public Date getPlayBy()
    {
        return this.match.getPlayBy();
    }
    
    public Date getPlayed()
    {
        return this.match.getPlayed();
    }
    
    public boolean isPostSeason()
    {
    	return (null != this.match.getBracketEntry());
    }
}