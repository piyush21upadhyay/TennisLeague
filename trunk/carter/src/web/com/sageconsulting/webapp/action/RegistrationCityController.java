package com.sageconsulting.webapp.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.sageconsulting.Constants;
import com.sageconsulting.model.City;
import com.sageconsulting.model.TickerMessage;
import com.sageconsulting.model.User;
import com.sageconsulting.service.CityManager;
import com.sageconsulting.service.TickerMessageManager;
import com.sageconsulting.service.UserExistsException;

public class RegistrationCityController extends BaseFormController
{
	private CityManager cityManager;
	private TickerMessageManager tickerMessageManager;
	
	public RegistrationCityController()
    {
        setCommandName("city");
        setCommandClass(City.class);
    }
	
	public void setCityManager(CityManager mgr)
    {
        this.cityManager = mgr;
    }
	
	public void setTickerMessageManager(TickerMessageManager mgr)
    {
        this.tickerMessageManager = mgr;
    }
	
	/**
     * Handle the showing of city registration form.
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
    	ModelAndView view = super.showForm(request, response, errors);
    	view.addObject("cityName", request.getSession().getAttribute(Constants.CITY_TOKEN));
    	
    	String cityId = request.getParameter("id");
    	String error = request.getParameter("errors");
    	
    	if(cityId != null)
    	{
    		Locale locale = request.getLocale();
    		if( Long.valueOf(cityId) > 0L )
    		{
    			City city = getCity(Long.valueOf(cityId));
    			view.addObject("currentCity", city.getFullCityName());
    			
        		if(error != null)
            	{
            		if( error.equals("1") )
            			view.addObject("errorMessage", getText("city.error.delete", city.getFullCityName(), locale));
            	}
    		}
    		if( (error != null) && error.equals("2") )
    			view.addObject("errorMessage", getText("city.error.save", "City could not be saved", locale));
    	}
    	return view;
    }
    
    @Override
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
        BindException errors) throws Exception
    {
        if (super.log.isDebugEnabled())
        {
            super.log.debug("entering 'onSubmit' method..."); //$NON-NLS-1$
        }
        
        City city = (City)command;
        boolean isCityActive = false;
        Date cityCountDownDate = new Date();
        String cityId = request.getParameter("id");
        
        // Handle delete request here first
        if (isDelete(request))
        {
        	try
	        {
            	if(cityId != null)
            	{
            		if( Long.valueOf(cityId) > 0L )
            			this.cityManager.removeCity(Long.valueOf(cityId));
            	}
	            return new ModelAndView(getSuccessView());
	        }
	        catch (Exception e)
	        {
	        	String successView = "redirect:registrationCity.html";
	        	
	        	if(cityId != null)
            	{
            		if( Long.valueOf(cityId) > 0L )
            		{
            			successView = "redirect:registrationCity.html?id=" + cityId;
            		}
            	}
	        	
	        	ModelAndView view = new ModelAndView(successView);
	        	view.addObject("errors", "1");	//delete error
	        	return view;
	        }
        }
        
        if(request.getParameter("active") != null)
        	isCityActive = Boolean.valueOf(request.getParameter("active"));
    	else
    		isCityActive = false;
        city.setActive(isCityActive);
        if(request.getParameter("countDownDate") == null)
        	city.setCountDownDate(cityCountDownDate);
        
        if (errors.getErrorCount() <= 0)
        {
	        try
	        {
	        	// save city
	        	saveCity(city);
	        	return new ModelAndView(getSuccessView());
	        }
	        catch (Exception e)
	        {
	            ModelAndView view = new ModelAndView("redirect:registrationCity.html");
	        	view.addObject("errors", "2");	//save error
	        	return view;
	        }
        }
        
        return showForm(request, response, errors);
    }
    
    private void saveCity(City city)
    {
    	this.cityManager.saveCity(city);
    	// further code for saving ticker message !
    }
    
    /**
     * Overridden to process the canceling of the editing/creating.
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
    	String cancel = request.getParameter("bCancel"); //$NON-NLS-1$
    	return (null != cancel) && cancel.equals("true"); //$NON-NLS-1$
    }
    
    /**
     * Return true if this request was created by the user pressing the "Delete" button.
     * @param request The current request.
     * @return true if the user pressed the delete button and false if not.
     */
    private boolean isDelete(HttpServletRequest request)
    {
    	String delete = request.getParameter("bDelete"); //$NON-NLS-1$
    	return (null != delete) && delete.equals("true"); //$NON-NLS-1$
    }
    
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception
    {
        if (!isFormSubmission(request))
        {
        	Long cityId = getIdParameter(request);
        	if(cityId != null)
        	{
        		City city = getCity(cityId);
        		return city;
        	}
        	else
        	{
        		// Initialize new city variables...
        		City city = new City();
        		
        		city.setName("");
        		city.setState("");
        		city.setActive(false);
        		city.setCountDownDate(new Date());
        		city.setCountDownMessage("");
        		city.setInactiveMessage("");
        		city.setVersion(Integer.valueOf("1"));
        		return city;
        	}
        }
        return super.formBackingObject(request);
    }
    
    /**
     * Get the id of the parameter
     * @param request
     * @return
     */
    private Long getIdParameter(HttpServletRequest request)
    {
        Long id = null;
        String idParam = request.getParameter("id");
        
        if (null != idParam)
        {
            try
            {
                id = Long.valueOf(idParam);
            }
            catch (NumberFormatException e)
            {
            	super.log.warn("Invalid id passed to controller: " + idParam);
                // we can ignore this and just return null
            }
        }
        return id;
    }
    
    private City getCity(Long id)
    {
        if (null == id)
        {
            return null;
        }
        return this.cityManager.getCity(id);
    }
    
}
