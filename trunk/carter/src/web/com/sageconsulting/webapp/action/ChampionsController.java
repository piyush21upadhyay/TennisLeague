/*
 * ChampionsController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sageconsulting.Constants;
import com.sageconsulting.model.Champion;
import com.sageconsulting.model.City;
import com.sageconsulting.service.ChampionManager;

public class ChampionsController extends ApplicationObjectSupport implements Controller
{
    private ChampionManager championManager;
    
    public void setChampionManager(ChampionManager mgr)
    {
        this.championManager = mgr;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ModelAndView view = new ModelAndView();

        City city = (City) request.getSession().getAttribute(Constants.CITY_TOKEN);
        if (null == city)
        {
        	String msg = getText("errors.noCity", request.getLocale()); //$NON-NLS-1$
        	view.addObject("successMessages", new String[] { msg });//$NON-NLS-1$
            return view;
        }
        
        List<Integer> years = this.championManager.getChampionYears(city.getId());
        view.addObject("years", years); //$NON-NLS-1$

        Integer year = getYear(request, years);
        view.addObject("year", year); //$NON-NLS-1$
        List<Champion> champions = getChampions(city, year);
        view.addObject("champions", champions); //$NON-NLS-1$

        return view;
    }
    
    private Integer getYear(HttpServletRequest request, List<Integer> years)
    {
    	if ((null == years) || (years.size() < 1))
    	{
    		return null;
    	}
    	
        String param = request.getParameter("changeYear"); //$NON-NLS-1$
        if ((null != param) && (param.length() > 0))
        {
            try
            {
                return Integer.valueOf(param);
            }
            catch (NumberFormatException e)
            {
                // Ignore this and return the first year in the list
            }
        }
        return years.get(0);
    }

    private List<Champion> getChampions(City city, Integer year)
    {
        List<Champion> champions = this.championManager.getChampions(city.getId(), year);
        return champions;
    }

    private String getText(String msgKey, Locale locale)
    {
        return getMessageSourceAccessor().getMessage(msgKey, locale);
    }
}
