/*
 * BaseSeasonResultController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.sageconsulting.Constants;
import com.sageconsulting.model.City;
import com.sageconsulting.model.MatchCategory;
import com.sageconsulting.model.Season;
import com.sageconsulting.service.MatchCategoryManager;
import com.sageconsulting.service.SeasonManager;

/**
 * This base class for the PlayoffsController and the StandingsController
 * which have a lot in common.
 */
public abstract class BaseSeasonResultController extends BaseFormController
{
    private SeasonManager seasonManager;
        
    public void setSeasonManager(SeasonManager mgr)
    {
        this.seasonManager = mgr;
    }
    
    protected SeasonManager getSeasonManager()
    {
    	return this.seasonManager;
    }
    
    @Override
    public ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors) throws Exception
    {
        City city = (City)request.getSession().getAttribute(Constants.CITY_TOKEN);
        if (null == city)
        {
        	String msg = getMessageSourceAccessor().getMessage("errors.noCity", request.getLocale()); //$NON-NLS-1$
        	ModelAndView view = new ModelAndView();
        	view.addObject("successMessages", new String[] { msg });//$NON-NLS-1$
        	return view;
        }

        return getModelAndView(request);
    }
    
    @Override
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
        BindException errors) throws Exception
    {
        return getModelAndView(request);
    }
    
    private ModelAndView getModelAndView(HttpServletRequest request)
    {
        ModelAndView view = new ModelAndView();

        City city = (City)request.getSession().getAttribute(Constants.CITY_TOKEN);
        if (null == city)
        {
        	String msg = getMessageSourceAccessor().getMessage("errors.noCity", request.getLocale()); //$NON-NLS-1$
        	view.addObject("successMessages", new String[] { msg });//$NON-NLS-1$
        	return view;
        }
        
        view.addObject("city", city); //$NON-NLS-1$

        List<Season> seasons = getSeasonList(city);
        sortList(seasons);
        view.addObject("seasons", seasons); //$NON-NLS-1$
        Season currentSeason = getCurrentSeason(request, seasons);
        view.addObject("season", currentSeason); //$NON-NLS-1$
        view.addObject("submittedSeason", currentSeason);
        
        updateModelAndView(currentSeason, view);
        
        

        return view;
    }
    
      
    private void sortList(List<Season> seasons)
    {
    	Collections.sort(seasons, new Comparator<Season>()
        {
            public int compare(Season season1, Season season2)
            {
                if (season1.getId().longValue() > season2.getId().longValue())
                {
                    return -1;
                }
                return 1;
            }
        });
    }
    
    protected abstract void updateModelAndView(Season currentSeason, ModelAndView view);
    
    private List<Season> getSeasonList(City city)
    {
        if (null != city)
        {
            return this.seasonManager.getOpenSeasonsForCity(city.getId());
        }
        return this.seasonManager.getOpenSeasons();
    }
    
    private Season getCurrentSeason(HttpServletRequest request, List<Season> seasons)
    {
    	Season season = null;
    	String id = request.getParameter("seasonid"); //$NON-NLS-1$
    	if ((null != id) && (id.length() > 0))
    	{
    		try
    		{
    			Long seasonId = Long.valueOf(id);
    			for (Season s : seasons)
    			{
    				if (s.getId().equals(seasonId))
    				{
    					season = s;
    					break;
    				}
    			}
    		}
    		catch (NumberFormatException e)
    		{
    			// Ignore this and return the default season
    		}
    	}
    	
    	if ((null == season) && (seasons.size() > 0))
    	{
    		if(seasons.get(0).getState().intValue() != Season.STATE_CLEAR)
    			season = seasons.get(0);	
    	}
    	
    	return season;
    }
}
