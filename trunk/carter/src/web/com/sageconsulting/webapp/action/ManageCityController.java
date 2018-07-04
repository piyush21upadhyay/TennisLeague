/*
 * ManageCityController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */

package com.sageconsulting.webapp.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sageconsulting.model.City;
import com.sageconsulting.service.CityManager;

public class ManageCityController implements Controller
{
	private static final Log log = LogFactory.getLog(ManageCityController.class);
    private CityManager cityManager;
    
    public void setCityManager(CityManager mgr)
    {
        this.cityManager = mgr;
    }
 
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
		if (log.isDebugEnabled())
        {
            log.debug("entering 'handleRequest' method...");
        }
		
		ModelAndView modelView = new ModelAndView();
		List<City> cities = this.cityManager.getCities();
		modelView.addObject("cities", cities);
		return modelView;
    }
}