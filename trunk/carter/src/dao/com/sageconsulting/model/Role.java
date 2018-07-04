/*
 * Role.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.model;

import java.io.Serializable;

import org.acegisecurity.GrantedAuthority;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * This class is used to represent available roles in the database.
 * </p>
 * 
 * @struts.form extends="BaseForm"
 * @hibernate.class table="role"
 */
public class Role extends BaseObject implements Serializable, GrantedAuthority
{
    private static final long serialVersionUID = 3690197650654049848L;

    private Long id;
    private String name;
    private String description;

    public Role()
    {
        // nothing to do.
    }

    public Role(String n)
    {
        this.name = n;
    }

    /**
     * @hibernate.id column="id" generator-class="native" unsaved-value="null"
     */
    public Long getId()
    {
        return this.id;
    }

    /**
     * @see org.acegisecurity.GrantedAuthority#getAuthority()
     */
    public String getAuthority()
    {
        return getName();
    }

    /**
     * @hibernate.property column="name" length="20"
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @hibernate.property column="description" length="64"
     */
    public String getDescription()
    {
        return this.description;
    }

    public void setId(Long i)
    {
        this.id = i;
    }

    public void setName(String n)
    {
        this.name = n;
    }

    public void setDescription(String desc)
    {
        this.description = desc;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Role))
        {
            return false;
        }

        final Role role = (Role) o;

        return !(this.name != null ? !this.name.equals(role.name) : role.name != null);

    }

    @Override
    public int hashCode()
    {
        return (this.name != null ? this.name.hashCode() : 0);
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append(this.name).toString();
    }

}
