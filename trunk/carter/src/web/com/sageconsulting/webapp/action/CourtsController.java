/*
 * CourtsController.java
 * 
 * Copyright © 2008-2009 City Tennis League, LLC.  All Rights Reserved
 * http://www.citytennisleague.com
 * 
 * @author Piyush Upadhyay - 
 */
package com.sageconsulting.webapp.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.GrantedAuthority;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import com.sageconsulting.Constants;
import com.sageconsulting.model.City;
import com.sageconsulting.model.Court;
import com.sageconsulting.model.User;
import com.sageconsulting.service.CourtManager;
import com.sageconsulting.service.UserExistsException;
import com.sageconsulting.service.UserManager;
import com.sageconsulting.webapp.filter.CourtListWrapper;

public class CourtsController  extends BaseFormController
{
	private static final String CMD_NAME = "courtListWrapper"; 

	public CourtsController() {
		setCommandName(CMD_NAME);
		setCommandClass(CourtListWrapper.class);
	}
	
    private CourtManager courtManager;
    private UserManager userManager;
    
    public void setCourtManager(CourtManager mgr)
    {
        this.courtManager = mgr;
    }
    
    public void setUserManager(UserManager mgr)
    {
        this.userManager = mgr;
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
        //binder.registerCustomEditor(Course.class, null, new CustomCourseEditor(this.courseManager.getCourses()));
       // binder.registerCustomEditor(Court.class, null, new CustomCourtEditor(this.courtManager.getCourts()));
       // binder.registerCustomEditor(Season.class, null, new CustomSeasonEditor(this.userManager.get));
        //binder.registerCustomEditor(Double.class, "handicap", new CustomHandicapEditor()); //$NON-NLS-1$
        super.initBinder(request, binder);
    }
    
    @Override
    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	ModelAndView view = null;
    	if (isCourtEdit(request))
        {
			super.setSuccessView("redirect:courts.html"); //$NON-NLS-1$
        	super.setCancelView("redirect:courts.html"); //$NON-NLS-1$
        }
    	
    	view = super.handleRequestInternal(request, response);
        City city = (City)request.getSession().getAttribute(Constants.CITY_TOKEN);
        view.addObject("isAdmin", Boolean.valueOf(this.isCurrentUserAdmin(request, getUser(request))));
        if (null == city)
        {
        	String msg = getMessageSourceAccessor().getMessage("errors.noCity", request.getLocale()); //$NON-NLS-1$
        	view.addObject("successMessages", new String[] { msg });//$NON-NLS-1$
            return view;
        }
        
        view.addObject("courtList", this.courtManager.getCourts(city.getId())); //$NON-NLS-1$
        return view;
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
    
    @Override
	public ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
    	CourtListWrapper wrapper = (CourtListWrapper)command;
    	saveCourtDetails(wrapper);
		City city = (City) request.getSession().getAttribute(
				Constants.CITY_TOKEN);
		String successView = getSuccessView();
		return new ModelAndView(successView);
		//return getModelAndView(city, (CourtListWrapper) command, request);
	}
    
    
    private void saveCourtDetails(CourtListWrapper courtListWrapper) {
		for (Court court : courtListWrapper.getCourtList()) {
			courtManager.saveCourt(court);
			updateUsersBelongingToThisCourt(court);
		}
	}

	private void updateUsersBelongingToThisCourt(Court court) {
		List<User> users = this.userManager.findUsers(court.getCities().get(0).getId(), court.getId());
		for(User user: users){
			user.setHomeCourtText(court.getName());
			user.setCourtCity(court.getCities().get(0).getName());
			user.setCourtState(court.getCourtState());
			user.setIsCourtLighted(court.getIsCourtLighted());
			user.setNumberOfCourts(court.getNumberOfCourts());
			user.setOpenCourtMeridiem(court.getOpenCourtMeridiem());
			user.setOpenCourtHour(court.getOpenCourtHour());
			user.setCloseCourtMeridiem(court.getCloseCourtMeridiem());
			user.setCloseCourtHour(court.getCloseCourtHour());
			user.setCourtVerified(court.isCourtVerified());
			try {
				this.userManager.saveUser(user);
			} catch (UserExistsException e) {
				log.error("Error occured while updating court information for User::"+user.getFullName());
				e.printStackTrace();
			}
		}
	}

	private ModelAndView getModelAndView(City city, CourtListWrapper command,
			HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		view.addObject(CMD_NAME, command);

		return view;
	}
    
    @Override
	public Object formBackingObject(HttpServletRequest request)
			throws Exception {
    	City city = (City)request.getSession().getAttribute(Constants.CITY_TOKEN);
        
        CourtListWrapper courtListWrapper = new CourtListWrapper();
        List<Court> courts = this.courtManager.getCourts(city.getId());
        courtListWrapper.setCourtList(courts);
        //Court court = courts.get(0);
        return courtListWrapper;
	}
    
    @Override
    protected void onBind(HttpServletRequest request, Object command) throws Exception
    {
        // if the user is being deleted, turn off validation
        if (isDelete(request))
        {
            super.setValidateOnBinding(false);
        }
        else
        {
            super.setValidateOnBinding(true);
        }
    }
    
    @Override
    public ModelAndView showForm(HttpServletRequest request, HttpServletResponse response,
        BindException errors) throws Exception
    {
    	
        ModelAndView view = super.showForm(request, response, errors);
        User user = getUser(request);
        boolean isAdmin = this.isCurrentUserAdmin(request, user);
        view.addObject("isAdmin", Boolean.valueOf(isAdmin));
        view.addObject("numberOfCourts",generateListOfSequentialNumber(12));
		view.addObject("hoursList", generateListOfSequentialNumber(24));
        return view;
    }
   
    private List<Integer> generateListOfSequentialNumber(int upperBound) {
		List<Integer> intList = new ArrayList<Integer>();
		for (int i = 1; i <= upperBound; i++) {
			intList.add(i);
		}
		return intList;
	}
    
    private boolean isCancel(HttpServletRequest request)
    {
    	String cancel = request.getParameter("bCancel"); //$NON-NLS-1$
    	return (null != cancel) && cancel.equals("true"); //$NON-NLS-1$
    }
    
    private boolean isDelete(HttpServletRequest request)
    {
    	String delete = request.getParameter("bDelete"); //$NON-NLS-1$
    	return (null != delete) && delete.equals("true"); //$NON-NLS-1$
    }
    
    protected boolean isCourtEdit(HttpServletRequest request)
    {
    	return request.getRequestURI().indexOf("editCourts") >= 0; //$NON-NLS-1$
    }
    
    private boolean isAdministratorEdit(HttpServletRequest request)
    {
    	boolean isAdministrator = false;
    	User currentUser = this.getUserManager().getUserByUsername(request.getRemoteUser());
    	GrantedAuthority[] userAuthorities = currentUser.getAuthorities();
        
        for(int counter=0; counter<userAuthorities.length; counter++)
        {
        	String userRole = userAuthorities[counter].toString();
        	if(userRole.equalsIgnoreCase("admin"))
        	{
        		isAdministrator = true;
        		break;
        	}
        }
        
    	return isAdministrator;
    }
    
    private User getUser(HttpServletRequest request)
    {
        User user = null;
        
        String userId = request.getParameter("id"); //$NON-NLS-1$
        if (null == userId)
        {
            String currentUsername = request.getRemoteUser();
            if (null != currentUsername)
            {
                user = this.userManager.getUserByUsername(currentUsername);
            }
        }
        else
        {
            user = this.userManager.getUser(userId);
        }
        
        return user;
    }
    
    private boolean isCurrentUserAdmin(HttpServletRequest request, User user)
    {
    	boolean isAdmin = false;
        if ((null == user) || (null == request.getRemoteUser()))
            return false;
        
        if(isCurrentUser(request, user))
        {
        	GrantedAuthority[] roles = user.getAuthorities();
        	for(GrantedAuthority role : roles)
        	{
        		if(role.getAuthority().equalsIgnoreCase("admin"))
        		{
        			isAdmin = true;
        			break;
        		}
        	}
        }
        return isAdmin;
    }
    
    private boolean isCurrentUser(HttpServletRequest request, User user)
    {
        String currentUserName = request.getRemoteUser();
        if ((null == user) || (null == currentUserName))
        {
            return false;
        }
        
        return user.getUsername().equals(currentUserName);
    }
}
