/*
 * PublicMessage.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.model;

import java.sql.Timestamp;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @hibernate.class table="public_message"
 */
public class PublicMessage extends BaseObject
{
    private static final long serialVersionUID = 7116840507487584911L;

    private Long id;
    private Integer version;
    private User poster;
    private String subject;
    private String message;
    private Timestamp date;
    private City city;


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
     * @hibernate.many-to-one column="poster" cascade="none" not-null="true"
     */
    public User getPoster()
    {
        return this.poster;
    }

    /**
     * @hibernate.property column="subject" not-null="true" length="60"
     */
    public String getSubject()
    {
        return this.subject;
    }

    /**
     * @hibernate.property column="message" not-null="true" length="1000"
     */
    public String getMessage()
    {
        return this.message;
    }

    /**
     * @hibernate.property column="date" not-null="true"
     */
    public Timestamp getDate()
    {
        return this.date;
    }

    /**
     * @hibernate.many-to-one column="city" cascade="none" not-null="false"
     */
    public City getCity()
    {
        return this.city;
    }

    public void setId(Long i)
    {
        this.id = i;
    }
    
    public void setVersion(Integer v)
    {
        this.version = v;
    }
    
    public void setPoster(User p)
    {
        this.poster = p;
    }
    
    /**
     * @spring.validator type="required"
     */
    public void setSubject(String s)
    {
        this.subject = s;
    }
    
    /**
     * @spring.validator type="required"
     */
    public void setMessage(String m)
    {
        this.message = m;
    }

    public void setDate(Timestamp ts)
    {
        this.date = ts;
    }
    
    public void setCity(City c)
    {
        this.city = c;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof PublicMessage))
        {
            return false;
        }

        final PublicMessage publicMessage = (PublicMessage)o;

        return this.poster.equals(publicMessage.getPoster()) && this.date.equals(publicMessage.getDate());
    }

    @Override
    public int hashCode()
    {
        return this.date.hashCode();
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("poster", this.poster). //$NON-NLS-1$
            append("date", this.date). //$NON-NLS-1$
            append("subject", this.subject). //$NON-NLS-1$
            append("message", this.message).toString(); //$NON-NLS-1$
    }
}
