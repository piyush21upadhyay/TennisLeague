/*
 * ViewSeasonController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sageconsulting.model.Season;
import com.sageconsulting.service.SeasonManager;
import com.sageconsulting.webapp.decorators.MatchGolferColumnDecorator;

public class ViewSeasonController extends ApplicationObjectSupport implements Controller
{
    private static final Log log = LogFactory.getLog(ViewSeasonController.class);
    
    private SeasonManager seasonManager;
    
    public void setSeasonManager(SeasonManager mgr)
    {
        this.seasonManager = mgr;
    }
    
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ModelAndView view = new ModelAndView();
        view.addObject("seasonList", getSeasonList(request)); //$NON-NLS-1$
        
        // Put the "BYE" string in the request for the MatchGolferColumnDecorator.
        request.setAttribute(MatchGolferColumnDecorator.BYE, getText("viewSeason.bye", request.getLocale())); //$NON-NLS-1$
        return view;
    }

    /**
     * Convenience method for getting a i18n key's value. Calling
     * getMessageSourceAccessor() is used because the RequestContext variable is
     * not set in unit tests b/c there's no DispatchServlet Request.
     * 
     * @param msgKey The key of the resource string to get.
     * @param locale The current locale.
     * @return The specified string.
     */
    public String getText(String msgKey, Locale locale)
    {
        return getMessageSourceAccessor().getMessage(msgKey, locale);
    }
    
    private List<Season> getSeasonList(HttpServletRequest request)
    {
        Long id = getRegistrationId(request);
        if (null == id)
        {
            return new ArrayList<Season>(0);
        }
        return this.seasonManager.getSeasonsForRegistration(id);
    }
    
    private Long getRegistrationId(HttpServletRequest request)
    {
        String str = request.getParameter("id"); //$NON-NLS-1$
        try
        {
            Long id = Long.valueOf(str);
            return id;
        }
        catch (NumberFormatException e)
        {
            log.warn("Failed to parse registration id from parameter "+str); //$NON-NLS-1$
        }
        return null;
    }
}
