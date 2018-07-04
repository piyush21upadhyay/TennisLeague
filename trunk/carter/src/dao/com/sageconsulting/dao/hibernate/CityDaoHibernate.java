/*
 * CityDaoHibernate.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao.hibernate;

import java.util.List;

import com.sageconsulting.dao.CityDao;
import com.sageconsulting.model.City;

public class CityDaoHibernate extends BaseDaoHibernate implements CityDao
{

    public City getCity(Long id)
    {
        return (City)getHibernateTemplate().get(City.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public City getCityByName(String name)
    {
        List<City> cities = getHibernateTemplate().find("from City c where c.name=?", name); //$NON-NLS-1$
        if (cities.size() > 0)
        {
            return cities.get(0);
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
    public List<City> getCities()
    {
        return getHibernateTemplate().find("from City c order by c.name"); //$NON-NLS-1$
    }

    public void saveCity(City city)
    {
        getHibernateTemplate().saveOrUpdate(city);
    }

    public void removeCity(Long id)
    {
        getHibernateTemplate().delete(getCity(id));
    }
}
