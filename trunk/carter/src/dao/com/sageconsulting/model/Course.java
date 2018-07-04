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
 * @hibernate.class table="course"
 */
public class Course extends BaseObject implements Serializable
{
    private static final long serialVersionUID = -8304018749637419488L;

    private Long id;
    private Integer version;
    private String name;
    private List<City> cities;
    private String mensTeeName;
    private Byte[] mensPars = new Byte[18];
    private Byte[] mensHandicaps = new Byte[18];
    private Integer[] mensYardages = new Integer[18];
    private String womensTeeName;
    private Byte[] womensPars = new Byte[18];
    private Byte[] womensHandicaps = new Byte[18];
    private Integer[] womensYardages = new Integer[18];
    private String proShopPhone;
    private String teeTimePhone;
    private String webSite;
    private Integer mensSlope;
    private Float mensRating;
    private Integer womensSlope;
    private Float womensRating;

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
     * @hibernate.list table="course_city" cascade="save-update" lazy="true"
     * @hibernate.key column="course_id"
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
        List<LabelValue> courseCities = new ArrayList<LabelValue>();

        if (this.cities != null)
        {
            for (Iterator<City> it = this.cities.iterator(); it.hasNext();)
            {
                City city = it.next();

                // convert the user's roles to LabelValue Objects
                courseCities.add(new LabelValue(city.getName(), city.getName()));
            }
        }

        return courseCities;
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
     * @hibernate.property column="mens_tee_name"
     */
    public String getMensTeeName()
    {
        return this.mensTeeName;
    }

    /**
     * @hibernate.property column="mens_pars"
     */
    public Byte[] getMensPars()
    {
        return this.mensPars;
    }
    
    public int getMensParOut()
    {
        return getSum(this.mensPars, 0, 8);
    }
    
    public int getMensParIn()
    {
        return getSum(this.mensPars, 9, 17);
    }
    
    public int getMensParTotal()
    {
        return getSum(this.mensPars, 0, 17);
    }

    /**
     * @hibernate.property column="mens_handicaps"
     */
    public Byte[] getMensHandicaps()
    {
        return this.mensHandicaps;
    }
    
    /**
     * @hibernate.property column="mens_yardages" length="512"
     */
    public Integer[] getMensYardages()
    {
        return this.mensYardages;
    }
    
    public int getMensYardageOut()
    {
        return getSum(this.mensYardages, 0, 8);
    }
    
    public int getMensYardageIn()
    {
        return getSum(this.mensYardages, 9, 17);
    }
    
    public int getMensYardageTotal()
    {
        return getSum(this.mensYardages, 0, 17);
    }
    
    /**
     * 
     * @return
     * @hibernate.property column="womens_tee_name"
     */
    public String getWomensTeeName()
    {
        return this.womensTeeName;
    }

    /**
     * @hibernate.property column="womens_pars"
     */
    public Byte[] getWomensPars()
    {
        return this.womensPars;
    }
    
    public int getWomensParOut()
    {
        return getSum(this.womensPars, 0, 8);
    }
    
    public int getWomensParIn()
    {
        return getSum(this.womensPars, 9, 17);
    }
    
    public int getWomensParTotal()
    {
        return getSum(this.womensPars, 0, 17);
    }
    
    private int getSum(Byte[] bytes, int start, int end)
    {
        int sum = 0;
        for (int i=start; i<=end; i++)
        {
            sum += bytes[i].intValue();
        }
        return sum;
    }

    /**
     * @hibernate.property column="womens_handicaps"
     */
    public Byte[] getWomensHandicaps()
    {
        return this.womensHandicaps;
    }
    
    /**
     * @hibernate.property column="womens_yardages" length="512"
     */
    public Integer[] getWomensYardages()
    {
        return this.womensYardages;
    }
    
    public int getWomensYardageOut()
    {
        return getSum(this.womensYardages, 0, 8);
    }
    
    public int getWomensYardageIn()
    {
        return getSum(this.womensYardages, 9, 17);
    }
    
    public int getWomensYardageTotal()
    {
        return getSum(this.womensYardages, 0, 17);
    }
    
    private int getSum(Integer[] values, int start, int end)
    {
        int sum = 0;
        for (int i=start; i<=end; i++)
        {
            sum += values[i].intValue();
        }
        return sum;
    }
    
    /**
     * 
     * @return
     * @hibernate.property column="pro_shop_phone"
     */
    public String getProShopPhone()
    {
        return this.proShopPhone;
    }
    
    /**
     * 
     * @return
     * @hibernate.property column="tee_time_phone"
     */
    public String getTeeTimePhone()
    {
        return this.teeTimePhone;
    }
    
    /**
     * 
     * @return
     * @hibernate.property column="web_site"
     */
    public String getWebSite()
    {
        return this.webSite;
    }
    
    /**
     * 
     * @return
     * @hibernate.property column="mens_slope" not-null="true"
     */
    public Integer getMensSlope()
    {
        return this.mensSlope;
    }
    
    /**
     * 
     * @return
     * @hibernate.property column="mens_rating" not-null="true"
     */
    public Float getMensRating()
    {
        return this.mensRating;
    }
    
    /**
     * 
     * @return
     * @hibernate.property column="womens_slope" not-null="true"
     */
    public Integer getWomensSlope()
    {
        return this.womensSlope;
    }
    
    /**
     * 
     * @return
     * @hibernate.property column="womens_rating" not-null="true"
     */
    public Float getWomensRating()
    {
        return this.womensRating;
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
    
    public void setMensTeeName(String teeName)
    {
        this.mensTeeName = teeName;
    }

    public void setMensPars(Byte[] p)
    {
        this.mensPars = p;
    }

    public void setMensHandicaps(Byte[] h)
    {
        this.mensHandicaps = h;
    }
    
    public void setMensYardages(Integer[] y)
    {
        this.mensYardages = y;
    }
    
    public void setWomensTeeName(String teeName)
    {
        this.womensTeeName = teeName;
    }

    public void setWomensPars(Byte[] p)
    {
        this.womensPars = p;
    }

    public void setWomensHandicaps(Byte[] h)
    {
        this.womensHandicaps = h;
    }
    
    public void setWomensYardages(Integer[] y)
    {
        this.womensYardages = y;
    }

    public void setProShopPhone(String phone)
    {
        this.proShopPhone = phone;
    }

    public void setTeeTimePhone(String phone)
    {
        this.teeTimePhone = phone;
    }
    
    public void setWebSite(String site)
    {
        this.webSite = site;
    }
    
    public void setMensSlope(Integer s)
    {
        this.mensSlope = s;
    }
    
    public void setMensRating(Float r)
    {
        this.mensRating = r;
    }
    
    public void setWomensSlope(Integer s)
    {
        this.womensSlope = s;
    }
    
    public void setWomensRating(Float r)
    {
        this.womensRating = r;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Course))
        {
            return false;
        }

        final Course course = (Course) o;

        return this.name.equals(course.name);
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
    
    public Byte getMensHole1Handicap() { return this.mensHandicaps[0]; }
    public Byte getMensHole2Handicap() { return this.mensHandicaps[1]; }
    public Byte getMensHole3Handicap() { return this.mensHandicaps[2]; }
    public Byte getMensHole4Handicap() { return this.mensHandicaps[3]; }
    public Byte getMensHole5Handicap() { return this.mensHandicaps[4]; }
    public Byte getMensHole6Handicap() { return this.mensHandicaps[5]; }
    public Byte getMensHole7Handicap() { return this.mensHandicaps[6]; }
    public Byte getMensHole8Handicap() { return this.mensHandicaps[7]; }
    public Byte getMensHole9Handicap() { return this.mensHandicaps[8]; }
    public Byte getMensHole10Handicap() { return this.mensHandicaps[9]; }
    public Byte getMensHole11Handicap() { return this.mensHandicaps[10]; }
    public Byte getMensHole12Handicap() { return this.mensHandicaps[11]; }
    public Byte getMensHole13Handicap() { return this.mensHandicaps[12]; }
    public Byte getMensHole14Handicap() { return this.mensHandicaps[13]; }
    public Byte getMensHole15Handicap() { return this.mensHandicaps[14]; }
    public Byte getMensHole16Handicap() { return this.mensHandicaps[15]; }
    public Byte getMensHole17Handicap() { return this.mensHandicaps[16]; }
    public Byte getMensHole18Handicap() { return this.mensHandicaps[17]; }
    public void setMensHole1Handicap(Byte b) { this.mensHandicaps[0] = b; } 
    public void setMensHole2Handicap(Byte b) { this.mensHandicaps[1] = b; } 
    public void setMensHole3Handicap(Byte b) { this.mensHandicaps[2] = b; } 
    public void setMensHole4Handicap(Byte b) { this.mensHandicaps[3] = b; } 
    public void setMensHole5Handicap(Byte b) { this.mensHandicaps[4] = b; } 
    public void setMensHole6Handicap(Byte b) { this.mensHandicaps[5] = b; } 
    public void setMensHole7Handicap(Byte b) { this.mensHandicaps[6] = b; } 
    public void setMensHole8Handicap(Byte b) { this.mensHandicaps[7] = b; } 
    public void setMensHole9Handicap(Byte b) { this.mensHandicaps[8] = b; } 
    public void setMensHole10Handicap(Byte b) { this.mensHandicaps[9] = b; } 
    public void setMensHole11Handicap(Byte b) { this.mensHandicaps[10] = b; } 
    public void setMensHole12Handicap(Byte b) { this.mensHandicaps[11] = b; } 
    public void setMensHole13Handicap(Byte b) { this.mensHandicaps[12] = b; } 
    public void setMensHole14Handicap(Byte b) { this.mensHandicaps[13] = b; } 
    public void setMensHole15Handicap(Byte b) { this.mensHandicaps[14] = b; } 
    public void setMensHole16Handicap(Byte b) { this.mensHandicaps[15] = b; } 
    public void setMensHole17Handicap(Byte b) { this.mensHandicaps[16] = b; } 
    public void setMensHole18Handicap(Byte b) { this.mensHandicaps[17] = b; } 
    
    public Byte getMensHole1Par() { return this.mensPars[0]; }
    public Byte getMensHole2Par() { return this.mensPars[1]; }
    public Byte getMensHole3Par() { return this.mensPars[2]; }
    public Byte getMensHole4Par() { return this.mensPars[3]; }
    public Byte getMensHole5Par() { return this.mensPars[4]; }
    public Byte getMensHole6Par() { return this.mensPars[5]; }
    public Byte getMensHole7Par() { return this.mensPars[6]; }
    public Byte getMensHole8Par() { return this.mensPars[7]; }
    public Byte getMensHole9Par() { return this.mensPars[8]; }
    public Byte getMensHole10Par() { return this.mensPars[9]; }
    public Byte getMensHole11Par() { return this.mensPars[10]; }
    public Byte getMensHole12Par() { return this.mensPars[11]; }
    public Byte getMensHole13Par() { return this.mensPars[12]; }
    public Byte getMensHole14Par() { return this.mensPars[13]; }
    public Byte getMensHole15Par() { return this.mensPars[14]; }
    public Byte getMensHole16Par() { return this.mensPars[15]; }
    public Byte getMensHole17Par() { return this.mensPars[16]; }
    public Byte getMensHole18Par() { return this.mensPars[17]; }
    public void setMensHole1Par(Byte b) { this.mensPars[0] = b; } 
    public void setMensHole2Par(Byte b) { this.mensPars[1] = b; } 
    public void setMensHole3Par(Byte b) { this.mensPars[2] = b; } 
    public void setMensHole4Par(Byte b) { this.mensPars[3] = b; } 
    public void setMensHole5Par(Byte b) { this.mensPars[4] = b; } 
    public void setMensHole6Par(Byte b) { this.mensPars[5] = b; } 
    public void setMensHole7Par(Byte b) { this.mensPars[6] = b; } 
    public void setMensHole8Par(Byte b) { this.mensPars[7] = b; } 
    public void setMensHole9Par(Byte b) { this.mensPars[8] = b; } 
    public void setMensHole10Par(Byte b) { this.mensPars[9] = b; } 
    public void setMensHole11Par(Byte b) { this.mensPars[10] = b; } 
    public void setMensHole12Par(Byte b) { this.mensPars[11] = b; } 
    public void setMensHole13Par(Byte b) { this.mensPars[12] = b; } 
    public void setMensHole14Par(Byte b) { this.mensPars[13] = b; } 
    public void setMensHole15Par(Byte b) { this.mensPars[14] = b; } 
    public void setMensHole16Par(Byte b) { this.mensPars[15] = b; } 
    public void setMensHole17Par(Byte b) { this.mensPars[16] = b; } 
    public void setMensHole18Par(Byte b) { this.mensPars[17] = b; } 
    
    public Integer getMensHole1Yardage() { return this.mensYardages[0]; }
    public Integer getMensHole2Yardage() { return this.mensYardages[1]; }
    public Integer getMensHole3Yardage() { return this.mensYardages[2]; }
    public Integer getMensHole4Yardage() { return this.mensYardages[3]; }
    public Integer getMensHole5Yardage() { return this.mensYardages[4]; }
    public Integer getMensHole6Yardage() { return this.mensYardages[5]; }
    public Integer getMensHole7Yardage() { return this.mensYardages[6]; }
    public Integer getMensHole8Yardage() { return this.mensYardages[7]; }
    public Integer getMensHole9Yardage() { return this.mensYardages[8]; }
    public Integer getMensHole10Yardage() { return this.mensYardages[9]; }
    public Integer getMensHole11Yardage() { return this.mensYardages[10]; }
    public Integer getMensHole12Yardage() { return this.mensYardages[11]; }
    public Integer getMensHole13Yardage() { return this.mensYardages[12]; }
    public Integer getMensHole14Yardage() { return this.mensYardages[13]; }
    public Integer getMensHole15Yardage() { return this.mensYardages[14]; }
    public Integer getMensHole16Yardage() { return this.mensYardages[15]; }
    public Integer getMensHole17Yardage() { return this.mensYardages[16]; }
    public Integer getMensHole18Yardage() { return this.mensYardages[17]; }
    public void setMensHole1Yardage(Integer b) { this.mensYardages[0] = b; } 
    public void setMensHole2Yardage(Integer b) { this.mensYardages[1] = b; } 
    public void setMensHole3Yardage(Integer b) { this.mensYardages[2] = b; } 
    public void setMensHole4Yardage(Integer b) { this.mensYardages[3] = b; } 
    public void setMensHole5Yardage(Integer b) { this.mensYardages[4] = b; } 
    public void setMensHole6Yardage(Integer b) { this.mensYardages[5] = b; } 
    public void setMensHole7Yardage(Integer b) { this.mensYardages[6] = b; } 
    public void setMensHole8Yardage(Integer b) { this.mensYardages[7] = b; } 
    public void setMensHole9Yardage(Integer b) { this.mensYardages[8] = b; } 
    public void setMensHole10Yardage(Integer b) { this.mensYardages[9] = b; } 
    public void setMensHole11Yardage(Integer b) { this.mensYardages[10] = b; } 
    public void setMensHole12Yardage(Integer b) { this.mensYardages[11] = b; } 
    public void setMensHole13Yardage(Integer b) { this.mensYardages[12] = b; } 
    public void setMensHole14Yardage(Integer b) { this.mensYardages[13] = b; } 
    public void setMensHole15Yardage(Integer b) { this.mensYardages[14] = b; } 
    public void setMensHole16Yardage(Integer b) { this.mensYardages[15] = b; } 
    public void setMensHole17Yardage(Integer b) { this.mensYardages[16] = b; } 
    public void setMensHole18Yardage(Integer b) { this.mensYardages[17] = b; } 
    
    public Byte getWomensHole1Handicap() { return this.womensHandicaps[0]; }
    public Byte getWomensHole2Handicap() { return this.womensHandicaps[1]; }
    public Byte getWomensHole3Handicap() { return this.womensHandicaps[2]; }
    public Byte getWomensHole4Handicap() { return this.womensHandicaps[3]; }
    public Byte getWomensHole5Handicap() { return this.womensHandicaps[4]; }
    public Byte getWomensHole6Handicap() { return this.womensHandicaps[5]; }
    public Byte getWomensHole7Handicap() { return this.womensHandicaps[6]; }
    public Byte getWomensHole8Handicap() { return this.womensHandicaps[7]; }
    public Byte getWomensHole9Handicap() { return this.womensHandicaps[8]; }
    public Byte getWomensHole10Handicap() { return this.womensHandicaps[9]; }
    public Byte getWomensHole11Handicap() { return this.womensHandicaps[10]; }
    public Byte getWomensHole12Handicap() { return this.womensHandicaps[11]; }
    public Byte getWomensHole13Handicap() { return this.womensHandicaps[12]; }
    public Byte getWomensHole14Handicap() { return this.womensHandicaps[13]; }
    public Byte getWomensHole15Handicap() { return this.womensHandicaps[14]; }
    public Byte getWomensHole16Handicap() { return this.womensHandicaps[15]; }
    public Byte getWomensHole17Handicap() { return this.womensHandicaps[16]; }
    public Byte getWomensHole18Handicap() { return this.womensHandicaps[17]; }
    public void setWomensHole1Handicap(Byte b) { this.womensHandicaps[0] = b; } 
    public void setWomensHole2Handicap(Byte b) { this.womensHandicaps[1] = b; } 
    public void setWomensHole3Handicap(Byte b) { this.womensHandicaps[2] = b; } 
    public void setWomensHole4Handicap(Byte b) { this.womensHandicaps[3] = b; } 
    public void setWomensHole5Handicap(Byte b) { this.womensHandicaps[4] = b; } 
    public void setWomensHole6Handicap(Byte b) { this.womensHandicaps[5] = b; } 
    public void setWomensHole7Handicap(Byte b) { this.womensHandicaps[6] = b; } 
    public void setWomensHole8Handicap(Byte b) { this.womensHandicaps[7] = b; } 
    public void setWomensHole9Handicap(Byte b) { this.womensHandicaps[8] = b; } 
    public void setWomensHole10Handicap(Byte b) { this.womensHandicaps[9] = b; } 
    public void setWomensHole11Handicap(Byte b) { this.womensHandicaps[10] = b; } 
    public void setWomensHole12Handicap(Byte b) { this.womensHandicaps[11] = b; } 
    public void setWomensHole13Handicap(Byte b) { this.womensHandicaps[12] = b; } 
    public void setWomensHole14Handicap(Byte b) { this.womensHandicaps[13] = b; } 
    public void setWomensHole15Handicap(Byte b) { this.womensHandicaps[14] = b; } 
    public void setWomensHole16Handicap(Byte b) { this.womensHandicaps[15] = b; } 
    public void setWomensHole17Handicap(Byte b) { this.womensHandicaps[16] = b; } 
    public void setWomensHole18Handicap(Byte b) { this.womensHandicaps[17] = b; } 
    
    public Byte getWomensHole1Par() { return this.womensPars[0]; }
    public Byte getWomensHole2Par() { return this.womensPars[1]; }
    public Byte getWomensHole3Par() { return this.womensPars[2]; }
    public Byte getWomensHole4Par() { return this.womensPars[3]; }
    public Byte getWomensHole5Par() { return this.womensPars[4]; }
    public Byte getWomensHole6Par() { return this.womensPars[5]; }
    public Byte getWomensHole7Par() { return this.womensPars[6]; }
    public Byte getWomensHole8Par() { return this.womensPars[7]; }
    public Byte getWomensHole9Par() { return this.womensPars[8]; }
    public Byte getWomensHole10Par() { return this.womensPars[9]; }
    public Byte getWomensHole11Par() { return this.womensPars[10]; }
    public Byte getWomensHole12Par() { return this.womensPars[11]; }
    public Byte getWomensHole13Par() { return this.womensPars[12]; }
    public Byte getWomensHole14Par() { return this.womensPars[13]; }
    public Byte getWomensHole15Par() { return this.womensPars[14]; }
    public Byte getWomensHole16Par() { return this.womensPars[15]; }
    public Byte getWomensHole17Par() { return this.womensPars[16]; }
    public Byte getWomensHole18Par() { return this.womensPars[17]; }
    public void setWomensHole1Par(Byte b) { this.womensPars[0] = b; } 
    public void setWomensHole2Par(Byte b) { this.womensPars[1] = b; } 
    public void setWomensHole3Par(Byte b) { this.womensPars[2] = b; } 
    public void setWomensHole4Par(Byte b) { this.womensPars[3] = b; } 
    public void setWomensHole5Par(Byte b) { this.womensPars[4] = b; } 
    public void setWomensHole6Par(Byte b) { this.womensPars[5] = b; } 
    public void setWomensHole7Par(Byte b) { this.womensPars[6] = b; } 
    public void setWomensHole8Par(Byte b) { this.womensPars[7] = b; } 
    public void setWomensHole9Par(Byte b) { this.womensPars[8] = b; } 
    public void setWomensHole10Par(Byte b) { this.womensPars[9] = b; } 
    public void setWomensHole11Par(Byte b) { this.womensPars[10] = b; } 
    public void setWomensHole12Par(Byte b) { this.womensPars[11] = b; } 
    public void setWomensHole13Par(Byte b) { this.womensPars[12] = b; } 
    public void setWomensHole14Par(Byte b) { this.womensPars[13] = b; } 
    public void setWomensHole15Par(Byte b) { this.womensPars[14] = b; } 
    public void setWomensHole16Par(Byte b) { this.womensPars[15] = b; } 
    public void setWomensHole17Par(Byte b) { this.womensPars[16] = b; } 
    public void setWomensHole18Par(Byte b) { this.womensPars[17] = b; } 
    
    public Integer getWomensHole1Yardage() { return this.womensYardages[0]; }
    public Integer getWomensHole2Yardage() { return this.womensYardages[1]; }
    public Integer getWomensHole3Yardage() { return this.womensYardages[2]; }
    public Integer getWomensHole4Yardage() { return this.womensYardages[3]; }
    public Integer getWomensHole5Yardage() { return this.womensYardages[4]; }
    public Integer getWomensHole6Yardage() { return this.womensYardages[5]; }
    public Integer getWomensHole7Yardage() { return this.womensYardages[6]; }
    public Integer getWomensHole8Yardage() { return this.womensYardages[7]; }
    public Integer getWomensHole9Yardage() { return this.womensYardages[8]; }
    public Integer getWomensHole10Yardage() { return this.womensYardages[9]; }
    public Integer getWomensHole11Yardage() { return this.womensYardages[10]; }
    public Integer getWomensHole12Yardage() { return this.womensYardages[11]; }
    public Integer getWomensHole13Yardage() { return this.womensYardages[12]; }
    public Integer getWomensHole14Yardage() { return this.womensYardages[13]; }
    public Integer getWomensHole15Yardage() { return this.womensYardages[14]; }
    public Integer getWomensHole16Yardage() { return this.womensYardages[15]; }
    public Integer getWomensHole17Yardage() { return this.womensYardages[16]; }
    public Integer getWomensHole18Yardage() { return this.womensYardages[17]; }
    public void setWomensHole1Yardage(Integer b) { this.womensYardages[0] = b; } 
    public void setWomensHole2Yardage(Integer b) { this.womensYardages[1] = b; } 
    public void setWomensHole3Yardage(Integer b) { this.womensYardages[2] = b; } 
    public void setWomensHole4Yardage(Integer b) { this.womensYardages[3] = b; } 
    public void setWomensHole5Yardage(Integer b) { this.womensYardages[4] = b; } 
    public void setWomensHole6Yardage(Integer b) { this.womensYardages[5] = b; } 
    public void setWomensHole7Yardage(Integer b) { this.womensYardages[6] = b; } 
    public void setWomensHole8Yardage(Integer b) { this.womensYardages[7] = b; } 
    public void setWomensHole9Yardage(Integer b) { this.womensYardages[8] = b; } 
    public void setWomensHole10Yardage(Integer b) { this.womensYardages[9] = b; } 
    public void setWomensHole11Yardage(Integer b) { this.womensYardages[10] = b; } 
    public void setWomensHole12Yardage(Integer b) { this.womensYardages[11] = b; } 
    public void setWomensHole13Yardage(Integer b) { this.womensYardages[12] = b; } 
    public void setWomensHole14Yardage(Integer b) { this.womensYardages[13] = b; } 
    public void setWomensHole15Yardage(Integer b) { this.womensYardages[14] = b; } 
    public void setWomensHole16Yardage(Integer b) { this.womensYardages[15] = b; } 
    public void setWomensHole17Yardage(Integer b) { this.womensYardages[16] = b; } 
    public void setWomensHole18Yardage(Integer b) { this.womensYardages[17] = b; } 
}
