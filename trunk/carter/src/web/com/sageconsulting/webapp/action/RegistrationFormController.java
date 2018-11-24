/*
 * RegistrationFormController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import com.sageconsulting.model.City;
import com.sageconsulting.model.Registration;
import com.sageconsulting.model.RegistrationEntry;
import com.sageconsulting.service.CityManager;
import com.sageconsulting.service.RegistrationEntryManager;
import com.sageconsulting.service.RegistrationManager;
import com.sageconsulting.webapp.util.CustomCityEditor;

public class RegistrationFormController extends BaseFormController
{
    private RegistrationManager registrationManager;
    private RegistrationEntryManager registrationEntryManager;
    private CityManager cityManager;
    
    private static final String BLANK=" ";

    public RegistrationFormController()
    {
        setCommandName("registration"); //$NON-NLS-1$
        setCommandClass(Registration.class);
    }
    
    public void setRegistrationManager(RegistrationManager mgr)
    {
        this.registrationManager = mgr;
    }
    
    public void setRegistrationEntryManager(RegistrationEntryManager mgr)
    {
        this.registrationEntryManager = mgr;
    }
    
    public void setCityManager(CityManager mgr)
    {
        this.cityManager = mgr;
    }

    private List<City> getCities()
    {
        return this.cityManager.getCities();
    }
    
    /**
     * Overridden to process the canceling of the editing.
     */
    @Override
    public ModelAndView processFormSubmission(HttpServletRequest request, HttpServletResponse response, Object command,
        BindException errors) throws Exception
    {
        if (isCancel(request))
        {
            return new ModelAndView(getCancelView());
        }

        return super.processFormSubmission(request, response, command, errors);
    }
    
    /**
     * Return true if this request was created by the user pressing the "Cancel" button.
     * @param request The current request.
     * @return true if the user pressed the cancel button and false if not.
     */
    private boolean isCancel(HttpServletRequest request)
    {
    	String cancel = request.getParameter("bCancel");
    	return (null != cancel) && cancel.equals("true");
    }
    
    /**
     * Handle the showing of the account form.
     * @param request The current request object.
     * @param response The current response object.
     * @param errors A collection of errors on the form.
     * @return The ModelAndView object to display after processing.
     * @exception Exception For errors processing the form.
     */
    @Override
    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors)
        throws Exception
    {
        ModelAndView modelAndView = super.showForm(request, response, errors);
        addCities(modelAndView);
        addRegistrantList(modelAndView, request);
        
        String cityId = request.getParameter("cityId");
        String state = "";
    	if ( (request.getRequestURI().indexOf("jsonState") >= 0) && (cityId != null) )
    	{
    		if(!cityId.equals(""))
    		{
    			City currentCity = this.cityManager.getCity(Long.parseLong(cityId));
        		
        		if(currentCity != null)
        			state = currentCity.getState();
    		}
    		modelAndView.addObject("state", state);
    	}
        
        return modelAndView;
    }

    /**
     * Set up a custom property editor for converting form inputs to real
     * objects.
     * @param request The current request.
     * @param binder The object which binds an input to a custom editor.
     */
    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
    {
        binder.registerCustomEditor(City.class, null, new CustomCityEditor(this.cityManager.getCities()));
        super.initBinder(request, binder);
    }

    @Override
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
        BindException errors) throws Exception
    {
        if (this.log.isDebugEnabled())
        {
            this.log.debug("entering 'onSubmit' method..."); //$NON-NLS-1$
        }

        Registration registration = (Registration)command;
        //Locale locale = request.getLocale();

        if (!isCancel(request)) //$NON-NLS-1$
        {
        	String earlyRegFee = request.getParameter("earlyRegistrationFee");
            String regularRegFee = request.getParameter("regularRegistrationFee");
            
            if((earlyRegFee.equals("")) || (!isNumeric(earlyRegFee)))
            {
            	if(!regularRegFee.equals("") && isNumeric(regularRegFee))
            		earlyRegFee = regularRegFee;
            	else
            		earlyRegFee = "0";
            }
            registration.setEarlyRegistrationFee(Float.parseFloat(earlyRegFee));
            /***Code changes by Piyush/Akash starts***/
            List<Registration> allRegDivisions=fetchAllRegDivisions(registration);
            for(Registration regDiv:allRegDivisions){
            	this.registrationManager.saveRegistration(regDiv);
            }
            /***Code changes by Piyush/Akash ends***/
            //this.registrationManager.saveRegistration(registration);
            
            //update count down date of the city
            City regCity = registration.getCity();
            regCity.setCountDownDate(registration.getRegistrationEnd());
            this.cityManager.saveCity(regCity);
        }
        
        //ModelAndView view = new ModelAndView(getSuccessView());
        ModelAndView view = showForm(request, response, errors);
        return view;
    }
    
    /**
     * @param registration
     * @return
     * @throws CloneNotSupportedException
     */
    private List<Registration> fetchAllRegDivisions(Registration registration) throws CloneNotSupportedException {
    	List<Registration> allRegDivisions=new ArrayList<Registration>();
    	List<String> seasonNames=new ArrayList<String>(); //mixedDblsNames was getting duplicated
    	for(Double playerLevel:registration.getPlayerLevel()){
    		for(String gender:registration.getGender()){
    			for(String playingPref:registration.getPlayingPreference()){
    				Registration regObj=(Registration) registration.clone();
    				regObj.setPlayerLevel(new Double[]{playerLevel});
    				regObj.setGender(new String[]{gender});
    				regObj.setPlayingPreference(new String[]{playingPref});
    				String genderVar="Mixed Doubles".equalsIgnoreCase(playingPref)?BLANK:BLANK.concat(gender).concat(BLANK);
    				regObj.setDisplayName(regObj.getDisplayName().concat(genderVar).concat(playingPref).concat(BLANK).concat(""+playerLevel));
    				if(!seasonNames.contains(regObj.getDisplayName())){
    					seasonNames.add(regObj.getDisplayName());
    					allRegDivisions.add(regObj);
    				}
    			}
    		}
    	}
		return allRegDivisions;
	}

	private void addCities(ModelAndView view)
    {
        view.addObject("cityList", getCities()); //$NON-NLS-1$
    }
    
    private void addRegistrantList(ModelAndView view, HttpServletRequest request)
    {
        List<RegistrationEntry> registrants = getRegistrants(request);
        view.addObject("registrantList", registrants); //$NON-NLS-1$
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
                this.log.warn("Invalid id passed to controller: "+idParam); //$NON-NLS-1$
                // we can ignore this and just return null
            }
        }
        return id;
    }
    
    private Registration getRegistration(Long id)
    {
        if (null == id)
        {
            return null;
        }
        return this.registrationManager.getRegistration(id);
    }
    
    private List<RegistrationEntry> getRegistrants(HttpServletRequest request)
    {
        Long id = getIdParameter(request);
        if (null == id)
        {
            return new ArrayList<RegistrationEntry>();
        }
        return this.registrationEntryManager.getRegistrationEntriesForRegistration(id);
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception
    {
        if (!isFormSubmission(request))
        {
            Long id = getIdParameter(request);
            Registration reg = getRegistration(id);
            if (null != reg)
            {
                return reg;
            }
        }
        return super.formBackingObject(request);
    }
    
    private boolean isNumeric(String s)
    {
    	boolean isNumber = false;
    	try{
    		if(Float.parseFloat(s) >= 0)
    			isNumber = true;
    	}
    	catch(NumberFormatException exp)
    	{
    		return false;
    	}
    	
    	return isNumber;
    }
}
