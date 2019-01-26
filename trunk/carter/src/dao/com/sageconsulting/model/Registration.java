/*
 * Registration.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.sageconsulting.model.City;

/**
 * This class is used to set up registration for a season for a given city.  It sets
 * the dates during which users can register for a season.  Once the registration
 * period is over the people that registered are split into flights and matches
 * are scheduled.  The flights are created as Season objects.
 * @see Season
 * @hibernate.class table="registration"
 */
public class Registration extends BaseObject implements Serializable,Cloneable
{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -7276084655108954216L;
	public static final Integer STATE_UNSCHEDULED = Integer.valueOf(0);
    public static final Integer STATE_REGULAR_SEASON_SCHEDULED = Integer.valueOf(1);
    public static final Integer STATE_POST_SEASON_SCHEDULED = Integer.valueOf(2);
    public static final Integer STATE_SEASON_CLEAR = Integer.valueOf(4);
    
    private Long id;
    private Integer version;
    private String displayName;
    private City city;
    private Date earlyRegistrationStart;
    private Date regularRegistrationStart;
    private Date registrationEnd;
    private Integer scheduleState = STATE_UNSCHEDULED;
    private Float earlyRegistrationFee;
    private Float regularRegistrationFee;
    private Float secondEventFee;
    private Float thirdEventFee;
    private Double[] playerLevel;
    private String[] playingPreference;
    private String[] gender;

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
     * @hibernate.property column="name" not-null="true" unique="true"
     */
    public String getDisplayName()
    {
        return this.displayName;
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
     * 
     * @return
     * 
     * @hibernate.property column="early_start"
     */
    public Date getEarlyRegistrationStart()
    {
        return this.earlyRegistrationStart;
    }
    
    /**
     * 
     * @return
     * 
     * @hibernate.property column="start" not-null="true"
     */
    public Date getRegularRegistrationStart()
    {
        return this.regularRegistrationStart;
    }
    
    /**
     * 
     * @return
     * 
     * @hibernate.property column="end" not-null="true"
     */
    public Date getRegistrationEnd()
    {
        return this.registrationEnd;
    }
    
    /**
     * 
     * @return
     * @hibernate.property column="state" not-null="true"
     */
    public Integer getScheduleState()
    {
        return this.scheduleState;
    }
    
    /**
     * 
     * @return
     * 
     * @hibernate.property column="early_registration_fee"
     */
    public Float getEarlyRegistrationFee()
    {
        return this.earlyRegistrationFee;
    }
    
    /**
     * 
     * @return
     * 
     * @hibernate.property column="regular_registration_fee"
     */
    public Float getRegularRegistrationFee()
    {
        return this.regularRegistrationFee;
    }
    
    
    /**
     * 
     * @return
     * 
     * @hibernate.property column="second_event_fee"
     */
    public Float getSecondEventFee() {
		return secondEventFee;
	}

	/**
     * 
     * @return
     * 
     * @hibernate.property column="third_event_fee"
     */
	public Float getThirdEventFee() {
		return thirdEventFee;
	}


	public void setId(Long i)
    {
        this.id = i;
    }

    public void setVersion(Integer ver)
    {
        this.version = ver;
    }
    
    /**
     * 
     * @param name
     * @spring.validator type="required"
     */
    public void setDisplayName(String name)
    {
        this.displayName = name;
    }
    
    /**
     * 
     * @param name
     * @spring.validator type="required"
     */
    public void setCity(City c)
    {
        this.city = c;
    }
    
    /**
     * 
     * @param name
     */
    public void setEarlyRegistrationStart(Date d)
    {
        this.earlyRegistrationStart = d;
    }
    
    /**
     * 
     * @param name
     * @spring.validator type="required"
     */
    public void setRegularRegistrationStart(Date d)
    {
        this.regularRegistrationStart = d;
    }
    
    /**
     * 
     * @param name
     * @spring.validator type="required"
     */
    public void setRegistrationEnd(Date d)
    {
        this.registrationEnd = d;
    }
    
    public void setScheduleState(Integer s)
    {
        this.scheduleState = s;
    }
    
    public void setEarlyRegistrationFee(Float e)
    {
        this.earlyRegistrationFee = e;
    }
    
    /**
     * 
     * @param name
     * @spring.validator type="required"
     */
    public void setRegularRegistrationFee(Float r)
    {
        this.regularRegistrationFee = r;
    }
    
    /**
     * 
     * @param name
     * @spring.validator type="required"
     */
    public void setSecondEventFee(Float secondEventFee) {
		this.secondEventFee = secondEventFee;
	}
    
    /**
     * 
     * @param name
     * @spring.validator type="required"
     */
    public void setThirdEventFee(Float thirdEventFee) {
		this.thirdEventFee = thirdEventFee;
	}

    
    /**
     * 
     * @return
     * 
     * @hibernate.property column="playing_preference" not-null="false"
     */
    public String[] getPlayingPreference() {
		return playingPreference;
	}

	public void setPlayingPreference(String[] playingPreference) {
		this.playingPreference = playingPreference;
	}
	
	 /**
     * 
     * @return
     * 
     * @hibernate.property column="player_level" not-null="false"
     */
	public Double[] getPlayerLevel() {
		return playerLevel;
	}

	public void setPlayerLevel(Double[] playerLevel) {
		this.playerLevel = playerLevel;
	}

	 /**
     * 
     * @return
     * 
     * @hibernate.property column="gender" not-null="false"
     */
	public String[] getGender() {
		return gender;
	}

	public void setGender(String[] gender) {
		this.gender = gender;
	}

	@Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).
            append("displayName", this.displayName).toString(); //$NON-NLS-1$
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((displayName == null) ? 0 : displayName.hashCode());
		result = prime * result + Arrays.hashCode(gender);
		result = prime * result + Arrays.hashCode(playerLevel);
		result = prime * result + Arrays.hashCode(playingPreference);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Registration))
			return false;
		Registration other = (Registration) obj;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		if (!Arrays.equals(gender, other.gender))
			return false;
		if (!Arrays.equals(playerLevel, other.playerLevel))
			return false;
		if (!Arrays.equals(playingPreference, other.playingPreference))
			return false;
		return true;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
    
    
}
