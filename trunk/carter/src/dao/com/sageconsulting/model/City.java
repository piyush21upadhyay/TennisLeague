/*
 * City.java
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

/**
 * 
 * @hibernate.class table="city"
 */
public class City extends BaseObject implements Serializable
{
    private static final long serialVersionUID = -8612499642293008726L;

    private Long id;
    private Integer version;
    private String name;
    private String state;
    private Boolean active;
    private String inactiveMessage;
    private Date countDownDate;
    private String countDownMessage;
    private String fullCityName;

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
     * @hibernate.property column="name"
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * @hibernate.property column="state"
     */
    public String getState()
    {
        return this.state;
    }
    
    /**
     * Returns the full city name.
     */
    public String getFullCityName()
    {
        return this.name + ", " + this.state;
    }
    
    /**
     * @hibernate.property column="active"
     */
    public Boolean isActive()
    {
        return this.active;
    }
    
    public boolean getActive()
    {
    	return this.isActive().booleanValue();
    }
    
    /**
     * @hibernate.property column="inactive_msg"
     */
    public String getInactiveMessage()
    {
        return this.inactiveMessage;
    }
    
    /**
     * @hibernate.property column="countdown_date"
     */
    public Date getCountDownDate()
    {
        return this.countDownDate;
    }
    
    /**
     * @hibernate.property column="countdown_msg"
     */
    public String getCountDownMessage()
    {
        return this.countDownMessage;
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
    public void setName(String n)
    {
        this.name = n;
    }
    
    /**
     * 
     * @param name
     * @spring.validator type="required"
     */
    public void setState(String s)
    {
        this.state = s;
    }
    
    public void setActive(Boolean b)
    {
        this.active = b;
    }
    
    public void setInactiveMessage(String s)
    {
        this.inactiveMessage = s;
    }
    
    public void setCountDownDate(Date d)
    {
        this.countDownDate = d;
    }
    
    public void setCountDownMessage(String s)
    {
        this.countDownMessage = s;
    }
    
    /* not to be used */
    public void setFullCityName(String name, String state)
    {
    	this.fullCityName = name + ", " + state;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof City))
        {
            return false;
        }

        final City city = (City) o;

        return this.name.equals(city.name);
    }

    @Override
    public int hashCode()
    {
        return this.name.hashCode();
    }

    @Override
    public String toString()
    {
        //return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("name", this.name).toString(); //$NON-NLS-1$
        //return new StringBuilder(this.name).append(", ").append(this.state).toString(); //$NON-NLS-1$
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
        
        sb.append("id", this.id);
        sb.append("version", this.version);
        sb.append("name", this.name);
        sb.append("state", this.state);
        sb.append("active", this.active);
        sb.append("inactiveMessage", this.inactiveMessage);
        sb.append("countDownDate", this.countDownDate);
        sb.append("countDownMessage", this.countDownMessage);
        sb.append("fullCityName", this.fullCityName);
        
        return sb.toString();
    }

}
