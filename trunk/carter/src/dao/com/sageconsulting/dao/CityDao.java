/*
 * CityDao.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao;

import java.util.List;

import com.sageconsulting.model.City;

public interface CityDao extends Dao
{
    public City getCity(Long id);
    
    public City getCityByName(String name);
    
    public List<City> getCities();

    public void saveCity(City city);
    
    public void removeCity(Long id);
}
