/*
 * SeasonDaoHibernate.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao.hibernate;

import java.util.List;

import com.sageconsulting.dao.SeasonDao;
import com.sageconsulting.model.Season;

public class SeasonDaoHibernate extends BaseDaoHibernate implements SeasonDao
{

    public Season getSeason(Long id)
    {
        // TODO Auto-generated method stub
        return (Season) getHibernateTemplate().get(Season.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Season> getSeasons()
    {
        return getHibernateTemplate().find("from Season s order by s.name"); //$NON-NLS-1$
    }
    
    @SuppressWarnings("unchecked")
    public List<Season> getSeasonsForRegistration(Long id)
    {
        return getHibernateTemplate().find("from Season s where s.registrationId=? order by s.name", id); //$NON-NLS-1$
    }
    
    @SuppressWarnings("unchecked")
    public List<Season> getOpenSeasons()
    {
        return getHibernateTemplate().find("from Season s where s.state!=? order by s.name", Season.STATE_COMPLETE); //$NON-NLS-1$
    }
    
    @SuppressWarnings("unchecked")
    public List<Season> getOpenSeasonsForCity(Long cityId)
    {
        return getHibernateTemplate().find("from Season s where s.state!=? and s.city.id=? order by s.name", //$NON-NLS-1$
            new Object[] { Season.STATE_COMPLETE, cityId });
    }
    
    @SuppressWarnings("unchecked")
    public List<Season> getClosedSeasons()
    {
        return getHibernateTemplate().find("from Season s where s.state=? order by s.name", Season.STATE_COMPLETE); //$NON-NLS-1$
    }

    public void saveSeason(Season season)
    {
        getHibernateTemplate().saveOrUpdate(season);
        // necessary to throw a DataIntegrityViolation and catch it in
        // UserManager
        getHibernateTemplate().flush();
    }

}
