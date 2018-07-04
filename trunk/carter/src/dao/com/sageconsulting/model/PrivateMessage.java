/*
 * PrivateMessage.java
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
 * @hibernate.class table="private_message"
 */
public class PrivateMessage extends BaseObject
{
    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer version;
    private User to;
    private User from;
    private String subject;
    private String message;
    private Timestamp dateSent;
    private Timestamp dateRead;


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
     * @hibernate.many-to-one column="receiver" cascade="none" not-null="true"
     */
    public User getTo()
    {
        return this.to;
    }

    /**
     * @hibernate.many-to-one column="sender" cascade="none" not-null="true"
     */
    public User getFrom()
    {
        return this.from;
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
     * @hibernate.property column="sent" not-null="true"
     */
    public Timestamp getDateSent()
    {
        return this.dateSent;
    }

    /**
     * @hibernate.property column="read_date" not-null="false"
     */
    public Timestamp getDateRead()
    {
        return this.dateRead;
    }
    
    public boolean isRead()
    {
        return (null != this.dateRead);
    }
    
    public void setId(Long i)
    {
        this.id = i;
    }
    
    public void setVersion(Integer v)
    {
        this.version = v;
    }
    
    public void setTo(User u)
    {
        this.to = u;
    }
    
    public void setFrom(User u)
    {
        this.from = u;
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
    
    public void setDateSent(Timestamp ts)
    {
        this.dateSent = ts;
    }
    
    public void setDateRead(Timestamp ts)
    {
        this.dateRead = ts;
    }

    public String getReplyBodyTxt()
    {
        if (this.message != null)
        {
            String txt = this.message.replaceAll("\n", "\n>"); //$NON-NLS-1$ //$NON-NLS-2$
            return "\n\n\n\n>" + txt; //$NON-NLS-1$
        }
        return ""; //$NON-NLS-1$
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

        return this.from.equals(publicMessage.getPoster()) && this.dateSent.equals(publicMessage.getDate());
    }

    @Override
    public int hashCode()
    {
        return this.dateSent.hashCode();
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("to", this.to). //$NON-NLS-1$
            append("from", this.from). //$NON-NLS-1$
            append("sent", this.dateSent). //$NON-NLS-1$
            append("subject", this.subject). //$NON-NLS-1$
            append("message", this.message).toString(); //$NON-NLS-1$
    }
}
