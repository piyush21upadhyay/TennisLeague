/*
 * SeasonResult.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.util;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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
        return (2*this.wins) + this.ties;
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
