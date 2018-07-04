/*
 * CityManagerImpl.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service.impl;

import java.util.List;

import com.sageconsulting.dao.CityDao;
import com.sageconsulting.model.City;
import com.sageconsulting.service.CityManager;

public class CityManagerImpl extends BaseManager implements CityManager
{
    public void setCityDao(CityDao cdao)
    {
        super.setDao(cdao);
    }
    
    private CityDao getCityDao()
    {
        return (CityDao)super.dao;
    }
    
    public City getCity(Long id)
    {
        return getCityDao().getCity(id);
    }
    
    public City getCityByName(String name)
    {
        return getCityDao().getCityByName(name);
    }

    public List<City> getCities()
    {
        return getCityDao().getCities();
    }

    public void saveCity(City city)
    {
        getCityDao().saveCity(city);
    }

    public void removeCity(Long id)
    {
        getCityDao().removeCity(id);
    }
}
