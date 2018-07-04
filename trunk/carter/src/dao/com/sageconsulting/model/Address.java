/*
 * Address.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.model;

import java.io.Serializable;
import java.util.Locale;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * This class is used to represent an address.
 * </p>
 */
public class Address extends BaseObject implements Serializable
{
    private static final long serialVersionUID = 3617859655330969141L;

    protected String address;
    protected String city;
    protected String province;
    protected String country = Locale.US.getCountry();
    protected String postalCode;

    /**
     * @hibernate.property column="address" not-null="true" length="150"
     */
    public String getAddress()
    {
        return this.address;
    }

    /**
     * @hibernate.property column="city" not-null="true" length="50"
     */
    public String getCity()
    {
        return this.city;
    }

    /**
     * @hibernate.property column="province" length="100"
     */
    public String getProvince()
    {
        return this.province;
    }

    /**
     * @hibernate.property column="country" length="100"
     */
    public String getCountry()
    {
        return this.country;
    }

    /**
     * @hibernate.property column="postal_code" not-null="true" length="15"
     */
    public String getPostalCode()
    {
        return this.postalCode;
    }

    /**
     * @spring.validator type="required"
     */
    public void setAddress(String addr)
    {
        this.address = addr;
    }

    /**
     * @spring.validator type="required"
     */
    public void setCity(String c)
    {
        this.city = c;
    }

    /**
     * @spring.validator type="required"
     */
    public void setCountry(String c)
    {
        this.country = c;
    }

    /**
     * @spring.validator type="required"
     * @spring.validator type="mask" msgkey="errors.zip"
     * @spring.validator-var name="mask" value="${zip}"
     */
    public void setPostalCode(String code)
    {
        this.postalCode = code;
    }

    /**
     * @spring.validator type="required"
     */
    public void setProvince(String prov)
    {
        this.province = prov;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Address))
        {
            return false;
        }

        final Address address1 = (Address) o;

        if (this.address != null ? !this.address.equals(address1.address) : address1.address != null)
        {
            return false;
        }
        if (this.city != null ? !this.city.equals(address1.city) : address1.city != null)
        {
            return false;
        }
        if (this.country != null ? !this.country.equals(address1.country) : address1.country != null)
        {
            return false;
        }
        if (this.postalCode != null ? !this.postalCode.equals(address1.postalCode) : address1.postalCode != null)
        {
            return false;
        }
        if (this.province != null ? !this.province.equals(address1.province) : address1.province != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result;
        result = (this.address != null ? this.address.hashCode() : 0);
        result = 29 * result + (this.city != null ? this.city.hashCode() : 0);
        result = 29 * result + (this.province != null ? this.province.hashCode() : 0);
        result = 29 * result + (this.country != null ? this.country.hashCode() : 0);
        result = 29 * result + (this.postalCode != null ? this.postalCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).
            append("country", this.country). //$NON-NLS-1$
            append("address", this.address). //$NON-NLS-1$
            append("province", this.province). //$NON-NLS-1$
            append("postalCode", this.postalCode). //$NON-NLS-1$
            append("city", this.city).toString(); //$NON-NLS-1$
    }
}
