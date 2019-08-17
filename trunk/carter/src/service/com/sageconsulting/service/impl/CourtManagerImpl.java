
package com.sageconsulting.service.impl;

import java.util.List;

import com.sageconsulting.dao.CourtDao;
import com.sageconsulting.model.Court;
import com.sageconsulting.service.CourtManager;

public class CourtManagerImpl extends BaseManager implements CourtManager
{
    public void setCourtDao(CourtDao courtDao)
    {
        super.setDao(courtDao);
    }
    
    private CourtDao getCourtDao()
    {
        return (CourtDao)super.dao;
    }
    
    public Court getCourt(Long id)
    {
        return getCourtDao().getCourt(id);
    }
    
    public List<Court> getCourts()
    {
        return getCourtDao().getCourts();
    }
    
    public List<Court> getCourts(Long cityId)
    {
        return getCourtDao().getCourtsForCity(cityId);
    }
    
    public List<Court> getCourts(String name)
    {
        return getCourtDao().getCourtsForName(name);
    }
    
    public List<Court> getCourts(Long cityId, String name)
    {
        return getCourtDao().getCourtsForCityAndName(cityId, name);
    }
    
    public void saveCourt(Court court)
    {
        getCourtDao().saveCourt(court);
    }
    
    public void removeCourt(Long id)
    {
        getCourtDao().removeCourt(id);
    }

	@Override
	public Long saveAndReturnCourt(Court court) {
		return getCourtDao().saveAndReturnCourt(court);
	}
}
