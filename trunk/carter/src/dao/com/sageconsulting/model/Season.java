/*
 * Season.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.model;

import java.io.Serializable;
import java.util.SortedSet;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * This is contains the information for a specific season.  There can be
 * multiple Seasons for a given Registration.  Users in a city sign up
 * in a Registration and at the end of the registration period they are
 * flighed and scheduled into a Season.
 * @see Registration
 * @hibernate.class table="season"
 */
public class Season extends BaseObject implements Serializable
{

    private static final long serialVersionUID = 1279444680792375295L;
    
    public static final Integer STATE_REGULAR_SEASON = Integer.valueOf(1);
    public static final Integer STATE_POST_SEASON = Integer.valueOf(2);
    public static final Integer STATE_COMPLETE = Integer.valueOf(3);
	public static final Integer STATE_CLEAR = Integer.valueOf(4);

    private Long id;
    private Integer version;
    private City city;
    private String name;
    private String division;
    private Integer postSeasonQualifyingCount;
    private SortedSet<Match> matches;
    private Long registrationId;
    private Integer state = STATE_REGULAR_SEASON;

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
     * 
     * @return
     * 
     * @hibernate.many-to-one column="city_id" not-null="true"
     */
    public City getCity()
    {
        return this.city;
    }

    /**
     * @hibernate.property column="name" unique="false"
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * @hibernate.property column="division"
     */
    public String getDivision()
    {
        return this.division;
    }
    
    public String getDisplayName()
    {
        return this.name + " - " + this.division; //$NON-NLS-1$
    }
    
    /**
     * 
     * @return
     * @hibernate.property column="qualifiers" not-null="true"
     */
    public Integer getPostSeasonQualifyingCount()
    {
        return this.postSeasonQualifyingCount;
    }
    
    /**
     * 
     * @return
     * @hibernate.set table="season_match" cascade="all" lazy="true" sort="com.sageconsulting.model.MatchSorter"
     * @hibernate.collection-key column="season_id"
     * @hibernate.collection-many-to-many class="com.sageconsulting.model.Match" column="match_id"
     */
    public SortedSet<Match> getMatches()
    {
        return this.matches;
    }
    
    /**
     * Return the id of the {@link Registration} object this season is associated with.
     * @return The id of the {@link Registration} object this season is associated with.
     * @hibernate.property column="registration_id" not-null="true"
     */
    public Long getRegistrationId()
    {
        return this.registrationId;
    }
    
    /**
     * Get the current state of the season.  This is either {@link STATE_REGULAR_SEASON},
     * {@link STATE_POST_SEASON} or {@link STATE_COMPLETE}.
     * @return The current season state.
     * @hibernate.property column="state" not-null="true"
     */
    public Integer getState()
    {
        return this.state;
    }

    public void setId(Long i)
    {
        this.id = i;
    }

    public void setVersion(Integer ver)
    {
        this.version = ver;
    }
    
    public void setCity(City c)
    {
        this.city = c;
    }

    public void setName(String n)
    {
        this.name = n;
    }
    
    public void setDivision(String d)
    {
        this.division = d;
    }
    
    public void setPostSeasonQualifyingCount(Integer count)
    {
        this.postSeasonQualifyingCount = count;
    }
    
    public void setMatches(SortedSet<Match> set)
    {
        this.matches = set;
    }
    
    public void setRegistrationId(Long rid)
    {
        this.registrationId = rid;
    }
    
    public void setState(Integer s)
    {
        this.state = s;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Season))
        {
            return false;
        }

        final Season season = (Season)o;

        return season.id.equals(this.id);
    }

    @Override
    public int hashCode()
    {
        return this.name.hashCode();
    }

    @Override
    public String toString()
    {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
        sb.append("name", this.name); //$NON-NLS-1$
        sb.append("division", this.division);
        for (Match match : this.matches)
        {
            sb.append(match);
        }
        return sb.toString();
    }
}
