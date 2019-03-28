/*
 * Match.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.sageconsulting.model.BaseObject;

/**
 * @hibernate.class table="golf_match"
 */
public class Match extends BaseObject implements Serializable
{
    private static final long serialVersionUID = 186763659815448139L;

    private Long id;
    private Integer version;
    private User golfer1;
    private User golfer2;
    private User puttoffWinner;
    private User defaultWinner;
    private Integer round;
    private Date playBy;
    private Date played;
    private Course course;
    private MatchScore score = new MatchScore();
    private BracketEntry bracketEntry;
    
    private transient MatchResult result = null;

    /**
     * @hibernate.id column="id" generator-class="native" unsaved-value="null"
     */
    public Long getId()
    {
        return this.id;
    }

    /**
     * @hibernate.version
     */
    public Integer getVersion()
    {
        return this.version;
    }

    /**
     * @hibernate.many-to-one column="golfer1" cascade="none"
     */
    public User getGolfer1()
    {
        return this.golfer1;
    }

    /**
     * @hibernate.many-to-one column="golfer2" cascade="none"
     */
    public User getGolfer2()
    {
        return this.golfer2;
    }
    
    /**
     * @hibernate.many-to-one column="puttoff_winner" cascade="none"
     */
    public User getPuttoffWinner()
    {
        return this.puttoffWinner;
    }
    
    /**
     * @hibernate.many-to-one column="default_winner" cascade="none" 
     */
    public User getDefaultWinner()
    {
        return this.defaultWinner;
    }
    
    /**
     * What round of the season is it.  The first round is 1.  The first round of the 
     * playoffs is however long the season is plus 1.
     * @return Which round of the season this match is scheduled for.
     * @hibernate.property column="round" not-null="true"
     */
    public Integer getRound()
    {
    	return this.round;
    }

    /**
     * 
     * @return
     * @hibernate.property column="play_by" not-null="true"
     */
    public Date getPlayBy()
    {
        return this.playBy;
    }

    /**
     * 
     * @return
     * @hibernate.property column="played"
     */
    public Date getPlayed()
    {
        return this.played;
    }
    
    /**
     * 
     * @return
     * @hibernate.many-to-one column="course" cascade="none" 
     */
    public Course getCourse()
    {
        return this.course;
    }

    /**
     * 
     * @return
     * @hibernate.component
     */
    public MatchScore getScore()
    {
        return this.score;
    }
    
    public MatchResult getResult()
    {
    	if (null == this.result)
    	{
    		this.result = new MatchResult(this);
    	}
        return this.result;
    }
    
    public boolean isDefaultWin()
    {
        return (null != this.defaultWinner);
    }
    
    public boolean isOpponentRetiredWin()
    {
    	if(null != this.score.getOpponentRetired())
    		return true;
    	return false;
    }
    
    public boolean isBye()
    {
        return ((null == this.golfer1) || (null == this.golfer2));
    }
    
    /**
     * It this match is part of a bracket, this will be set to the entry in the bracket.
     * @return
     * @hibernate.many-to-one column="bracket_entry" not-null="false" unique="true" cascade="none"
     */
    public BracketEntry getBracketEntry()
    {
        return this.bracketEntry;
    }

    public void setId(Long i)
    {
        this.id = i;
    }

    public void setVersion(Integer ver)
    {
        this.version = ver;
    }

    public void setGolfer1(User golfer)
    {
        this.golfer1 = golfer;
    }

    public void setGolfer2(User golfer)
    {
        this.golfer2 = golfer;
    }
    
    public void setPuttoffWinner(User golfer)
    {
        this.puttoffWinner = golfer;
    }
    
    public void setDefaultWinner(User golfer)
    {
        this.defaultWinner = golfer;
    }
    
    public void setRound(Integer r)
    {
    	this.round = r;
    }

    public void setPlayBy(Date date)
    {
        this.playBy = date;
    }

    public void setPlayed(Date date)
    {
        this.played = date;
    }
    
    public void setCourse(Course c)
    {
        this.course = c;
    }

    public void setScore(MatchScore s)
    {
        this.score = s;
    }
    
    public void setBracketEntry(BracketEntry entry)
    {
        this.bracketEntry = entry;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Match))
        {
            return false;
        }

        final Match match = (Match) o;

        if (( (this.golfer1 != null) && !this.golfer1.equals(match.golfer1)) || ( (this.golfer2 != null) && !this.golfer2.equals(match.golfer2))
            || !this.playBy.equals(match.playBy))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int result;
        result = (null != this.golfer1) ? this.golfer1.hashCode() : 1;
        result = 29 * ((null == this.golfer2) ? 1 : this.golfer2.hashCode());
        result = 29 * this.playBy.hashCode();
        return result;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).
            append("golfer1", this.golfer1.getFullName()). //$NON-NLS-1$
            append("golfer2", (null == this.golfer2) ? "bye" : this.golfer2.getFullName()). //$NON-NLS-1$ //$NON-NLS-2$
            append("round", this.round). //$NON-NLS-1$
            append("completeBy", this.playBy).
            append("id", this.id).toString(); //$NON-NLS-1$
    }

}
