/*
 * ChampionDaoHibernate.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao.hibernate;

import java.util.List;

import com.sageconsulting.dao.ChampionDao;
import com.sageconsulting.model.Champion;

public class ChampionDaoHibernate extends BaseDaoHibernate implements ChampionDao
{

    public Champion getChampion(Long id)
    {
        return (Champion)getHibernateTemplate().get(Champion.class, id);
    }

    public void saveChampion(Champion champion)
    {
        getHibernateTemplate().save(champion);
    }

    @SuppressWarnings("unchecked")
    public List<Champion> getChampions(Long cityId, Integer year)
    {
        return getHibernateTemplate().find("from Champion c where c.city.id = ? and c.year = ? order by c.season, c.division", new Object[] { cityId, year }); //$NON-NLS-1$
    }
    
    @SuppressWarnings("unchecked")
    public List<Integer> getChampionYears(Long cityId)
    {
        return getHibernateTemplate().find("select distinct c.year from Champion c where c.city.id = ? order by c.year", new Object[] { cityId }); //$NON-NLS-1$
    }
}
