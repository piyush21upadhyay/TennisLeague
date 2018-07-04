/*
 * TickerMessage.java
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
 * @hibernate.class table="ticker"
 */
public class TickerMessage extends BaseObject implements Serializable
{
    private static final long serialVersionUID = 6270539232543637088L;

    private Long id;
    private Integer version;
    private City city;
    private String message;

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
     * @hibernate.property column="message"
     */
    public String getMessage()
    {
        return this.message;
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

    public void setMessage(String msg)
    {
        this.message = msg;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof TickerMessage))
        {
            return false;
        }

        final TickerMessage msg = (TickerMessage)o;

        return this.message.equals(msg.message);
    }

    @Override
    public int hashCode()
    {
        return this.message.hashCode();
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("message", this.message).toString(); //$NON-NLS-1$
    }
}
