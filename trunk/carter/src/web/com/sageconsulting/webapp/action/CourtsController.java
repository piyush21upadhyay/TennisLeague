/*
 * CourtsController.java
 * 
 * Copyright © 2008-2009 City Tennis League, LLC.  All Rights Reserved
 * http://www.citytennisleague.com
 * 
 * @author Piyush Upadhyay - 
 */
package com.sageconsulting.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sageconsulting.Constants;
import com.sageconsulting.model.City;
import com.sageconsulting.service.CourtManager;

public class CourtsController extends ApplicationObjectSupport implements Controller
{
    private CourtManager courtManager;
    
    public void setCourtManager(CourtManager mgr)
    {
        this.courtManager = mgr;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ModelAndView view = new ModelAndView(); //super.onSubmit(request, response, command, errors);
        City city = (City)request.getSession().getAttribute(Constants.CITY_TOKEN);
        if (null == city)
        {
        	String msg = getMessageSourceAccessor().getMessage("errors.noCity", request.getLocale()); //$NON-NLS-1$
        	view.addObject("successMessages", new String[] { msg });//$NON-NLS-1$
            return view;
        }
        
        view.addObject("courtList", this.courtManager.getCourts(city.getId())); //$NON-NLS-1$
        
        return view;
    }
}
