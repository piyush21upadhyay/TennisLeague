/*
 * ManageRegistrationController.java
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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sageconsulting.model.Registration;
import com.sageconsulting.model.Season;
import com.sageconsulting.service.RegistrationManager;
import com.sageconsulting.service.SeasonManager;

public class ManageRegistrationController extends ApplicationObjectSupport implements Controller
{
    private static final Log log = LogFactory.getLog(ManageRegistrationController.class);
    
    private RegistrationManager registrationManager;
    private SeasonManager seasonManager;

    public ManageRegistrationController()
    {
        // nothing to do
    }
    
    public void setRegistrationManager(RegistrationManager mgr)
    {
        this.registrationManager = mgr;
    }

	public void setSeasonManager(SeasonManager mgr)
    {
        this.seasonManager = mgr;
    }
	
    private List<Registration> getClosedRegistrations()
    {
        return this.registrationManager.getClosedRegistrations();
    }

    private List<Registration> getOpenRegistrations()
    {
        return this.registrationManager.getOpenRegistrations();
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        if (log.isDebugEnabled())
        {
            log.debug("entering 'handleRequest' method..."); //$NON-NLS-1$
        }

        ModelAndView view = new ModelAndView();

        if (isDelete(request))
        {
            try
            {
                handleDelete(request);
            }
            catch (DataIntegrityViolationException e)
            {
                Locale locale = request.getLocale();
                view.addObject("errorMessage", getText("registration.error.cantdelete", locale)); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }        
        else if(isClear(request))
        {
            try
            {
                handleClearSeason(request);
            }
            catch (DataIntegrityViolationException e)
            {
                Locale locale = request.getLocale();
                view.addObject("errorMessage", getText("registration.error.cantclear", locale)); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
        

		// Filter cleared
		List<Registration> closedResistrations = getClosedRegistrations();
		List<Registration> filteredClosedResistrations = new ArrayList<Registration>();

		for( Registration closedResistration : closedResistrations )
		{
			if( closedResistration.getScheduleState().intValue() != Registration.STATE_SEASON_CLEAR )
				filteredClosedResistrations.add(closedResistration);
		}

		view.addObject("closedRegistrationList", filteredClosedResistrations);
		//view.addObject("closedRegistrationList", getClosedRegistrations()); //$NON-NLS-1$
		view.addObject("openRegistrationList", getOpenRegistrations()); //$NON-NLS-1$
        return view;
    }

    public String getText(String msgKey, Locale locale)
    {
        return getMessageSourceAccessor().getMessage(msgKey, locale);
    }
    
    private void handleDelete(HttpServletRequest request)
    {
        Long id = getIdParameter(request);
        if (null != id)
        {
            this.registrationManager.removeRegistration(id);
        }
    }
    
	private void handleClearSeason( HttpServletRequest request )
    {
		Long registrationId = getIdParameter(request);
        
		if(registrationId != null)
        {
			// Update resistration state
			Registration registration = this.registrationManager.getRegistration(registrationId);
			registration.setScheduleState(Registration.STATE_SEASON_CLEAR); 
			this.registrationManager.saveRegistration(registration);
			
			List<Season> seasons = this.seasonManager.getSeasonsForRegistration(registrationId);

			for( Season seas: seasons )
			{
				if( seas.getRegistrationId().longValue() == registrationId.longValue() )
				{
					// Update season state
					seas.setState(Season.STATE_CLEAR);
					this.seasonManager.saveSeason(seas);
				}
			}
		}
    }
	
    private boolean isDelete(HttpServletRequest request)
    {
        String func = request.getParameter("func"); //$NON-NLS-1$
        return (null != func) && (func.equals("delete")); //$NON-NLS-1$
    }
	
	private boolean isClear( HttpServletRequest request )
    {
        String func = request.getParameter("func");
        return (null != func) && (func.equals("clear"));
    }
	
    /**
     * Get the id of the parameter
     * @param request
     * @return
     */
    private Long getIdParameter(HttpServletRequest request)
    {
        Long id = null;
        String idParam = request.getParameter("id"); //$NON-NLS-1$
        if (null != idParam)
        {
            try
            {
                id = Long.valueOf(idParam);
            }
            catch (NumberFormatException e)
            {
                log.warn("Invalid id passed to controller: "+idParam); //$NON-NLS-1$
                // we can ignore this and just return null
            }
        }
        return id;
    }
}
