/*
 * BaseSeasonResultController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.sageconsulting.Constants;
import com.sageconsulting.model.City;
import com.sageconsulting.model.Season;
import com.sageconsulting.model.User;
import com.sageconsulting.service.SeasonManager;
import com.sageconsulting.util.GenderComparator;
import com.sageconsulting.util.PlayingRatingsComparator;
import com.sageconsulting.util.SeasonChainedComparator;
import com.sageconsulting.util.SortSeason;

/**
 * This base class for the PlayoffsController and the StandingsController
 * which have a lot in common.
 */
public abstract class BaseSeasonResultController extends BaseFormController
{
    private static final String WOMEN_S = "Women's";
	private static final String MEN_S = "Men's";
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
        //sortList(seasons);
        //view.addObject("seasons", seasons); //$NON-NLS-1$
        if(null != request.getRemoteUser()){
        	setCurrentDivisionAsFirstSeason(seasons, this.getUserManager().getUserByUsername(request.getRemoteUser()));
        }
        view.addObject("seasons", seasons); 
        Season currentSeason = getCurrentSeason(request, seasons);
        view.addObject("season", currentSeason); //$NON-NLS-1$
        view.addObject("submittedSeason", currentSeason);
        
        updateModelAndView(currentSeason, view);
        
        

        return view;
    }
    
      
    /**
     * When logged in, your division should always comes first on Leaderboard and Playoffs screen
     * 
     * @param seasons
     * @param currentSeason
     * @param user 
     */
	private void setCurrentDivisionAsFirstSeason(List<Season> seasons, User user) {
		sortSeasonsBasedOnGenderAndRating(seasons, user.getMale());
		if (user != null && user.getCurrentSeason() != null && seasons != null
				&& seasons.size() > 1) {
			int searchIndex = 0;
			for (int index = 0; index < seasons.size(); index++) {
				if (user.getCurrentSeason().getId() == seasons.get(index)
						.getId()) {
					searchIndex = index;
					break;
				}
			}
			seasons.remove(searchIndex);
			seasons.add(0, user.getCurrentSeason());
		}

	}

	@SuppressWarnings("unchecked")
	private void sortSeasonsBasedOnGenderAndRating(List<Season> seasons,
			boolean isMale) {
		List<SortSeason> sortSeasons = new ArrayList<SortSeason>();
		Map<Long, Season> seasonWRTSeasonId=new HashMap<Long, Season>();
		if (seasons != null && seasons.size() > 1) {
			for (Season season : seasons) {
				String seasonName = season.getName();
				String[] parts = seasonName.split(" ");

				double rating = Double.parseDouble(parts[parts.length - 1]);
				String playingPref = parts[parts.length - 2];
				String gender = parts[parts.length - 3];
				int seasonNameIndex = (seasonName.indexOf(MEN_S) != -1) ? seasonName
						.indexOf(MEN_S) : seasonName.indexOf(WOMEN_S);
				String actualName = season.getName().substring(0,
						seasonNameIndex);

				sortSeasons.add(new SortSeason(actualName, gender, playingPref,
						rating, season.getId()));
				
				seasonWRTSeasonId.put(season.getId(), season);
			}
			System.out.println("before Sorting of Seasons::"
					+ sortSeasons.toString());
			Collections.sort(sortSeasons, new SeasonChainedComparator(
					new GenderComparator(isMale),
					new PlayingRatingsComparator()));
			
			Collections.copy(seasons, orderSeasons(sortSeasons, seasonWRTSeasonId));
			System.out.println("After Sorted Seasons::"
					+ sortSeasons.toString());
		}
	}

	private List<Season> orderSeasons(List<SortSeason> sortSeasons,
			Map<Long, Season> seasonWRTSeasonId) {
		List<Season> orderedSeasons = new ArrayList<Season>();
		for(int i=0; i<sortSeasons.size();i++){
			orderedSeasons.add(seasonWRTSeasonId.get(sortSeasons.get(i).getSeasonId()));
		}
		return orderedSeasons;
		
		/*int index = 0;
		for (SortSeason sortSeason : sortSeasons) {
			originalSeasonObj.clear();
			originalSeasonObj.add(index,
					seasonWRTSeasonId.get(sortSeason.getSeasonId()));
			index++;
		}
		return originalSeasonObj;*/
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
