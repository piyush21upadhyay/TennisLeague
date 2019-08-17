package com.sageconsulting.dao.hibernate;

import java.util.List;

import com.sageconsulting.dao.CourtDao;
import com.sageconsulting.model.Court;

public class CourtDaoHibernate extends BaseDaoHibernate implements CourtDao
{
    public Court getCourt(Long id)
    {
        return (Court) getHibernateTemplate().get(Court.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Court> getCourts()
    {
        return getHibernateTemplate().find("from Court c order by c.name"); //$NON-NLS-1$
    }

    @SuppressWarnings("unchecked")
    public List<Court> getCourtsForCity(Long cityId)
    {
        return getHibernateTemplate().find("from Court c where ? in elements(c.cities) order by c.name", cityId); //$NON-NLS-1$
    }
    
    @SuppressWarnings("unchecked")
    public List<Court> getCourtsForName(String name)
    {
        StringBuilder sb = new StringBuilder("from Court c where c.name like '%"). //$NON-NLS-1$
            append(name).append("%' order by c.name"); //$NON-NLS-1$
        return getHibernateTemplate().find(sb.toString());
    }
    
    @SuppressWarnings("unchecked")
    public List<Court> getCourtsForCityAndName(Long cityId, String name)
    {
        if ((cityId.longValue() <= 0) && (null == name))
        {
            return getCourts();
        }
        else if (null == name)
        {
            return getCourtsForCity(cityId);
        }
        else if (cityId.longValue() <= 0)
        {
            return getCourtsForName(name);
        }
        
        StringBuilder sb = new StringBuilder("from Court c where "). //$NON-NLS-1$
            append(cityId).append(" in elements(cities) and c.name like '%"). //$NON-NLS-1$
            append(name).append("%' order by c.name"); //$NON-NLS-1$
         return getHibernateTemplate().find(sb.toString());
    }

    public void saveCourt(Court court)
    {
        getHibernateTemplate().saveOrUpdate(court);
    }

    public void removeCourt(Long id)
    {
        getHibernateTemplate().delete(getCourt(id));
    }

	@Override
	public Long saveAndReturnCourt(Court court) {
		getHibernateTemplate().saveOrUpdate(court);
		return court.getId();
	}
}
