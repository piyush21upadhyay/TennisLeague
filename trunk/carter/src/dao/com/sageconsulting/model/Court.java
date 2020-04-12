/*
 * Course.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * @hibernate.class table="court"
 */
public class Court extends BaseObject implements Serializable
{
    private static final long serialVersionUID = -8304018749637419488L;

    private Long id;
    private Integer version;
    private String name;
    private List<City> cities;
    private String courtAddress;
    private String courtState;
    private String isCourtLighted;
    private String numberOfCourts;
    private String openCourtMeridiem;
    private String openCourtHour;
    private String closeCourtMeridiem;
    private String closeCourtHour;
    private boolean isCourtVerifiedByAdmin=false;

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
     * @hibernate.list table="court_city" cascade="save-update" lazy="true"
     * @hibernate.key column="court_id"
     * @hibernate.list-index column="idx"
     * @hibernate.many-to-many class="com.sageconsulting.model.City"
     *                         column="city_id" unique="false"
     */
    public List<City> getCities()
    {
        return this.cities;
    }

    /**
     * Convert user roles to LabelValue objects for convenience.
     */
    public List<LabelValue> getCityList()
    {
        List<LabelValue> courtCities = new ArrayList<LabelValue>();

        if (this.cities != null)
        {
            for (Iterator<City> it = this.cities.iterator(); it.hasNext();)
            {
                City city = it.next();

                // convert the user's roles to LabelValue Objects
                courtCities.add(new LabelValue(city.getName(), city.getName()));
            }
        }

        return courtCities;
    }

    /**
     * @hibernate.property column="name"
     */
    public String getName()
    {
        return this.name;
    }
    
    
    
    
    /**
     * 
     * @return
     * @hibernate.property column="court_address"
     */
    public String getCourtAddress()
    {
    	return this.courtAddress;
    }
    
    /**
     * @spring.validator type="required"
     */
    public void setId(Long i)
    {
        this.id = i;
    }

    public void setVersion(Integer ver)
    {
        this.version = ver;
    }

    public void setCities(List<City> c)
    {
        this.cities = c;
    }
    
    public void addCity(City c)
    {
        if (null == this.cities)
        {
            this.cities = new ArrayList<City>();
        }
        this.cities.add(c);
    }

    public void setName(String n)
    {
        this.name = n;
    }

    public void setCourtAddress(String courtAddress) 
    {
		this.courtAddress = courtAddress;
	}
    
    /**
     * 
     * @return
     * @hibernate.property column="court_state"
     */
    public String getCourtState() {
		return courtState;
	}

	public void setCourtState(String courtState) {
		this.courtState = courtState;
	}
    
    /**
     * 
     * @return
     * @hibernate.property column="court_lighted" not-null="false"
     */
	public String getIsCourtLighted() {
		return isCourtLighted;
	}

	public void setIsCourtLighted(String isCourtLighted) {
		this.isCourtLighted = isCourtLighted;
	}

    /**
     * 
     * @return
     * @hibernate.property column="numberOfCourts" not-null="false"
     */
	public String getNumberOfCourts() {
		return numberOfCourts;
	}

	public void setNumberOfCourts(String numberOfCourts) {
		this.numberOfCourts = numberOfCourts;
	}

	/**
     * @hibernate.property column="openCourtMeridiem" not-null="false"
     */
	public String getOpenCourtMeridiem() {
		return openCourtMeridiem;
	}
	public void setOpenCourtMeridiem(String openCourtMeridiem) {
		this.openCourtMeridiem = openCourtMeridiem;
	}

	/**
     * @hibernate.property column="openCourtHour" not-null="false"
     */
	public String getOpenCourtHour() {
		return openCourtHour;
	}

	public void setOpenCourtHour(String openCourtHour) {
		this.openCourtHour = openCourtHour;
	}

	/**
     * @hibernate.property column="closeCourtMeridiem" not-null="false"
     */
	public String getCloseCourtMeridiem() {
		return closeCourtMeridiem;
	}

	public void setCloseCourtMeridiem(String closeCourtMeridiem) {
		this.closeCourtMeridiem = closeCourtMeridiem;
	}
	/**
     * @hibernate.property column="closeCourtHour" not-null="false"
     */
	public String getCloseCourtHour() {
		return closeCourtHour;
	}

	public void setCloseCourtHour(String closeCourtHour) {
		this.closeCourtHour = closeCourtHour;
	}
	
	/**
     * @hibernate.property column="is_court_verified" not-null="false"
     */
	public boolean isCourtVerifiedByAdmin() {
		return isCourtVerifiedByAdmin;
	}

	public void setCourtVerifiedByAdmin(boolean isCourtVerifiedByAdmin) {
		this.isCourtVerifiedByAdmin = isCourtVerifiedByAdmin;
	}

	@Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Court))
        {
            return false;
        }

        final Court court = (Court) o;

        return this.name.equals(court.name);
    }

    @Override
    public int hashCode()
    {
        return this.name.hashCode();
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).
            append("id", this.id). //$NON-NLS-1$
            append("name", this.name).toString(); //$NON-NLS-1$
    }
}
