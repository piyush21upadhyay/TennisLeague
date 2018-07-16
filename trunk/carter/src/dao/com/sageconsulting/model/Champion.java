/*
 * Champion.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * @hibernate.class table="champion"
 */
public class Champion extends BaseObject implements Serializable
{
    private static final long serialVersionUID = 5235086581953786364L;
    
    private Long id;
    private Integer version;
    private User player;
    private City city;
    private Integer year;
    private String season;
    private String division;
    private String record;
    //private Double handicap;
    private Course homeCourse;
    //private String homeCourt;

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
     * @hibernate.many-to-one column="player" cascade="none"
     */
    public User getPlayer()
    {
        return this.player;
    }

    /**
     * @hibernate.many-to-one column="city" cascade="none"
     */
    public City getCity()
    {
        return this.city;
    }

    /**
     * @hibernate.property column="year" not-null="true" unique="false"
     */
    public Integer getYear()
    {
        return this.year;
    }

    /**
     * @hibernate.property column="season" unique="false"
     */
    public String getSeason()
    {
        return this.season;
    }

    /**
     * @hibernate.property column="division"
     */
    public String getDivision()
    {
        return this.division;
    }
    
    /**
     * @hibernate.property column="record" not-null="true"
     */
    public String getRecord()
    {
        return this.record;
    }
    
    
    /**
     * Get the users chosen home course.
     * @return The user's home course.
     * @hibernate.many-to-one column="home_course" cascade="none" not-null="true"
     */
    public Course getHomeCourse()
    {
        return this.homeCourse;
    }
    
    /**
     * Get the users chosen home course.
     * @return The user's home course.
     * @hibernate.many-to-one column="home_course" cascade="none" not-null="true"
     */
    /*public String getHomeCourt()
    {
        return this.homeCourse;
    }*/

    public void setId(Long userId)
    {
        this.id = userId;
    }

    public void setVersion(Integer ver)
    {
        this.version = ver;
    }
    
    public void setPlayer(User p)
    {
        this.player = p;
    }
    
    public void setCity(City c)
    {
        this.city = c;
    }
    
    public void setYear(Integer y)
    {
        this.year = y;
    }
    
    public void setSeason(String s)
    {
        this.season = s;
    }
    
    public void setDivision(String d)
    {
        this.division = d;
    }
    
    public void setRecord(String r)
    {
        this.record = r;
    }
    
    /*public void setHandicap(Double h)
    {
        this.handicap = h;
    }*/
    
    public void setHomeCourse(Course c)
    {
        this.homeCourse = c;
    }
    
    /*public void setHomeCourt(String c)
    {
        this.homeCourse = c;
    }*/

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Champion))
        {
            return false;
        }

        final Champion champion = (Champion)o;

        if (!this.player.equals(champion.player) || !this.year.equals(champion.year) ||
            !this.season.equals(champion.season) || !this.division.equals(champion.division))
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(this.player);
        hcb.append(this.year);
        hcb.append(this.season);
        hcb.append(this.division);
        return hcb.toHashCode();
    }

    @Override
    public String toString()
    {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).
            append("user", this.player). //$NON-NLS-1$
            append("year", this.year). //$NON-NLS-1$
            append("season", this.season). //$NON-NLS-1$
            append("division", this.division); //$NON-NLS-1$
        return sb.toString();
    }

}
