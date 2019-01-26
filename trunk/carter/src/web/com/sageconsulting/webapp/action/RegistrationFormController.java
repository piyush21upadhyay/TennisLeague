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
import java.util.Iterator;
import java.util.List;

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
    private static final String MIXED_DOUBLES="Mixed Doubles";

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
    	
    	/***Code changes by Piyush/Akash starts to disable the Gender,Playing Pref and Player Level***/
    	modelAndView.addObject("isEditSeasonRequest", "edit".equals(request.getParameter("func"))?"true":null);
    	/***Code changes by Piyush/Akash starts***/
        
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
        boolean isEditFlow=false;

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
            isEditFlow="null".equals(request.getParameter("editFlowHidden"))?Boolean.FALSE:Boolean.TRUE;
            	
            List<Registration> allSeasonRegToBeDone=fetchAllRegDivisions(registration,isEditFlow);
            for(Registration regDiv:allSeasonRegToBeDone){
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
		view.addObject("isEditSeasonRequest", isEditFlow?"true":null);
        return view;
    }
    
    /**
     * @param registration
     * @param isEditFlow 
     * @return
     * @throws CloneNotSupportedException
     */
    private List<Registration> fetchAllRegDivisions(Registration registration, boolean isEditFlow) throws CloneNotSupportedException {
    	System.out.println("isEditFlow::"+isEditFlow);
    	List<Registration> allSeasonRegToBeDone=new ArrayList<Registration>();
    	List<String> seasonNames=new ArrayList<String>(); //mixedDblsNames were getting duplicated
    	
    	if(registration.getPlayerLevel()!=null && !isEditFlow){
    		for(Double playerLevel:registration.getPlayerLevel()){
    			for(String gender:registration.getGender()){
    				for(String playingPref:registration.getPlayingPreference()){
    					
    					Registration regObj=(Registration) registration.clone();
    					regObj.setPlayerLevel(new Double[]{playerLevel});
    					regObj.setGender(new String[]{gender});
    					regObj.setPlayingPreference(new String[]{playingPref});
    					String genderVar=MIXED_DOUBLES.equalsIgnoreCase(playingPref)?BLANK:BLANK.concat(gender).concat(BLANK);
    					
    					String origSeasonName=splitOriginalSeasonName(regObj.getDisplayName());
    					regObj.setDisplayName(origSeasonName.concat(genderVar).concat(playingPref).concat(BLANK).concat(""+playerLevel));
    					
    					if(!seasonNames.contains(regObj.getDisplayName())){
    						seasonNames.add(regObj.getDisplayName());
    						allSeasonRegToBeDone.add(regObj);
    					}
    				}
    			}
    		}
    		List<Registration> openRegistrations = this.registrationManager.getOpenRegistrations();
    		List<Registration> finalREgToeDone=fetchFinalRegObjects(allSeasonRegToBeDone,openRegistrations);
    		return finalREgToeDone;
    	}
    	allSeasonRegToBeDone.add(registration);
    	return allSeasonRegToBeDone;
	}
    

	private List<Registration> fetchFinalRegObjects(List<Registration> allSeasonRegToBeDone,List<Registration> openRegistrations) {
    	List<Registration> fetchFinalRegObjects=new ArrayList<Registration>();
    	
		if(openRegistrations==null || openRegistrations.size()==0)
			return allSeasonRegToBeDone;
		
		Iterator<Registration> itr=allSeasonRegToBeDone.iterator();
		while (itr.hasNext()) {
			Registration registration=itr.next();
			if(!openRegistrations.contains(registration))
				fetchFinalRegObjects.add(registration);
		}
		return fetchFinalRegObjects;
	}
	
	private String splitOriginalSeasonName(String seasonDisplayName) {
		
		if(seasonDisplayName.contains("Men's")){
			return seasonDisplayName.split("Men's")[0].trim();
		}else if(seasonDisplayName.contains("Women's")){
			return seasonDisplayName.split("Women's")[0].trim();
		}
		return seasonDisplayName;
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
