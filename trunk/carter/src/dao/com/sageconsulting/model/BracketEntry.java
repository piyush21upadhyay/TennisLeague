/*
 * BracketEntry.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * This class represents a single match in a tournament bracket.  It contains
 * a link to the next round as well as a {@link Match} object (after it is
 * initialized).
 *
 * @hibernate.class table="bracket"
 */
public class BracketEntry extends BaseObject implements Serializable
{
    private static final long serialVersionUID = 8245447148995611213L;

    private Long id;
    private Integer version;
    private Long seasonId;
    private Integer matchNumber;
    private Match match = new Match();
    private BracketEntry next;
    private Integer round;
    
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
     * This is the id of the season that this bracket entry is for.
     * @return The id of the season this is 
     * @hibernate.property column="season_id"
     */
    public Long getSeasonId()
    {
        return this.seasonId;
    }
    
    /**
     * 
     * @return
     * @hibernate.property column="match_number" not-null="true"
     */
    public Integer getMatchNumber()
    {
        return this.matchNumber;
    }
    
    /**
     * Get the match for this entry in the bracket.
     * @return
     * @hibernate.many-to-one column="golf_match" not-null="true" unique="true" cascade="all"
     */
    public Match getMatch()
    {
        return this.match;
    }
    
    /**
     * @return
     * @hibernate.many-to-one column="next" cascade="all" 
     */
    public BracketEntry getNext()
    {
        return this.next;
    }
    
    /**
     * 
     * @return
     * @hibernate.property column="round"
     */
    public Integer getRound()
    {
        return this.round;
    }

    public void setId(Long i)
    {
        this.id = i;
    }

    public void setVersion(Integer ver)
    {
        this.version = ver;
    }
    
    public void setSeasonId(Long sid)
    {
        this.seasonId = sid;
    }
    
    public void setMatchNumber(Integer num)
    {
        this.matchNumber = num;
    }
    
    public void setMatch(Match m)
    {
        this.match = m;
    }
    
    public void setNext(BracketEntry entry)
    {
        this.next = entry;
    }
    
    public void setRound(Integer r)
    {
        this.round = r;
    }
    

    @Override
    public boolean equals(Object o)
    {
        // TODO: figure out how do this right
        // For now just compare the actual object.
        return o == this;
    }

    @Override
    public int hashCode()
    {
        // TODO: this needs to be fixed.
        return this.round.hashCode() * 29;// * this.match.hashCode();
    }

    @Override
    public String toString()
    {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
        sb.append("match", this.match); //$NON-NLS-1$
        sb.append("next", (null != this.next) ? this.next.getId() : "null"); //$NON-NLS-1$ //$NON-NLS-2$
        sb.append("round", this.round); //$NON-NLS-1$
        return sb.toString();
    }

}
