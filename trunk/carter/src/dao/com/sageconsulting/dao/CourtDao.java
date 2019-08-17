package com.sageconsulting.dao;

import java.util.List;

import com.sageconsulting.model.Court;

public interface CourtDao extends Dao
{
    public Court getCourt(Long id);

    public List<Court> getCourts();

    public List<Court> getCourtsForCity(Long cityId);
    
    public List<Court> getCourtsForName(String name);
    
    public List<Court> getCourtsForCityAndName(Long cityId, String name);

    public void saveCourt(Court Court);

    public void removeCourt(Long id);

	public Long saveAndReturnCourt(Court court);
}
