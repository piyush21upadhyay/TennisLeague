/*
 * UserFormController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationTrustResolver;
import org.acegisecurity.AuthenticationTrustResolverImpl;
import org.acegisecurity.context.SecurityContext;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.providers.ProviderManager;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.sageconsulting.Constants;
import com.sageconsulting.model.City;
import com.sageconsulting.model.Court;
import com.sageconsulting.model.Role;
import com.sageconsulting.model.Season;
import com.sageconsulting.model.User;
import com.sageconsulting.service.CityManager;
import com.sageconsulting.service.CourtManager;
import com.sageconsulting.service.RoleManager;
import com.sageconsulting.service.SeasonManager;
import com.sageconsulting.service.UserExistsException;
import com.sageconsulting.service.UserManager;
import com.sageconsulting.util.StringUtil;
import com.sageconsulting.webapp.util.CustomCityEditor;
import com.sageconsulting.webapp.util.CustomHandicapEditor;
import com.sageconsulting.webapp.util.CustomSeasonEditor;
import com.sageconsulting.webapp.util.RequestUtil;

/**
 * Implementation of <strong>SimpleFormController</strong> that interacts with
 * the {@link UserManager} to retrieve/persist values to the database.
 */
public class UserFormController extends BaseFormController
{
    private RoleManager roleManager;
    private CityManager cityManager;
    private SeasonManager seasonManager;
    private CourtManager courtManager;
    User user = null;

    /**
     * @param mgr
     *            The roleManager to set.
     */
    public void setRoleManager(RoleManager mgr)
    {
        this.roleManager = mgr;
    }
    
    public void setCityManager(CityManager mgr)
    {
        this.cityManager = mgr;
    }
    
    public void setSeasonManager(SeasonManager mgr)
    {
        this.seasonManager = mgr;
    }
    
    public void setCourtManager(CourtManager mgr) {
		this.courtManager = mgr;
	}

	public UserFormController()
    {
        setCommandName("user"); //$NON-NLS-1$
        setCommandClass(User.class);
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
        binder.registerCustomEditor(City.class, null, new CustomCityEditor(this.cityManager.getCities()));
        binder.registerCustomEditor(Season.class, null, new CustomSeasonEditor(this.seasonManager.getSeasons()));
        binder.registerCustomEditor(Double.class, "handicap", new CustomHandicapEditor()); //$NON-NLS-1$
        super.initBinder(request, binder);
    }
    
    @Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	ModelAndView view = null;
    	if (isProfileEdit(request))
        {
    		if(isDelete(request))
    		{
    			super.setSuccessView("redirect:default.jsp");
            	super.setCancelView("redirect:default.jsp");
    		}
    		else
    		{
    			super.setSuccessView("redirect:profile.html"); //$NON-NLS-1$
            	super.setCancelView("redirect:profile.html"); //$NON-NLS-1$
    		}
        }
        else if (isSignupEdit(request))
        {
        	super.setSuccessView("redirect:congratsPage.html"); //$NON-NLS-1$
        	super.setCancelView("redirect:default.jsp"); //$NON-NLS-1$
        }
        else if (isAdministratorEdit(request))
        {
        	super.setSuccessView("redirect:users.html"); //$NON-NLS-1$
        	super.setCancelView("redirect:users.html"); //$NON-NLS-1$
        }
        else if(request.getRequestURI().indexOf("emailValidate") >= 0)
        {
        	super.setSuccessView("redirect:emailValidate.html");
        	super.setCancelView("redirect:emailValidate.html");
        }
        else
        {
        	throw new Exception("Invalid page using UserFormController"); //$NON-NLS-1$
        }
        
    	view = super.handleRequestInternal(request, response);
    	
    	String emailStr = request.getParameter("email");
    	if ( (request.getRequestURI().indexOf("emailValidate") >= 0) && (emailStr != null) )
    	{
    		boolean isEmailInUse = this.getUserManager().isEmailInUse(emailStr);
    		boolean isSameUser = false;
    		String userId = request.getParameter("id");
    		boolean finalResponse = false;
    		
    		if(!userId.equals(""))
    		{
    			User currentUser = this.getUserManager().getUser(userId);
        		
        		if(currentUser != null)
        			isSameUser = emailStr.equals(currentUser.getEmail());
        		
        		if(!(isSameUser) && isEmailInUse)
        			finalResponse = true;
    		}
    		else
    			finalResponse = isEmailInUse;
    		view.addObject("isExistingEmail", finalResponse);
    	}
    	
    	String userNameStr = request.getParameter("username");
    	if ( (request.getRequestURI().indexOf("emailValidate") >= 0) && (userNameStr != null) )
    	{
    		boolean isDuplicateUserName = this.getUserManager().isUsernameInUse(userNameStr);
    		boolean isSameUser = false;
    		String userId = request.getParameter("id");
    		boolean finalResponse = false;
    		
    		if(!userId.equals(""))
    		{
    			User currentUser = this.getUserManager().getUser(userId);
        		
        		if(currentUser != null)
        			isSameUser = userNameStr.equals(currentUser.getUsername());
        		
        		if(!(isSameUser) && isDuplicateUserName)
        			finalResponse = true;
    		}
    		else
    			finalResponse = isDuplicateUserName;
    		view.addObject("isExistingUserName", finalResponse);
    	}
    	
    	return view;
    }
    
    /**
     * Return true if the user is editing his/her own profile.
     * @param request The current request object.
     * @return true if the user is editing their own profile and false if the user
     *    is signing up or an administrator is editing a user profile.
     */
    protected boolean isProfileEdit(HttpServletRequest request)
    {
    	return request.getRequestURI().indexOf("editprofile") >= 0; //$NON-NLS-1$
    }
    
    /**
     * Return true if the user is signing up as a new user.
     * @param request The current request object.
     * @return true if the user is signing up as a new user and false if the user
     *     is editing his/her own profile or an administrator is editing the user.
     */
    protected boolean isSignupEdit(HttpServletRequest request)
    {
    	return request.getRequestURI().indexOf("signup") >= 0; //$NON-NLS-1$
    }
    
    /**
     * Return true if the an administrator is editing a user
     * @param request The current request object.
     * @return true if an administrator is editing a user and false if a user is
     *     editing his/her own profile or user is signing up.
     */
    protected boolean isAdministratorEdit(HttpServletRequest request)
    {
    	return request.getRequestURI().indexOf("edituser") >= 0; //$NON-NLS-1$
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
    	String cancel = request.getParameter("bCancel"); //$NON-NLS-1$
    	return (null != cancel) && cancel.equals("true"); //$NON-NLS-1$
    }
    
    private boolean isDelete(HttpServletRequest request)
    {
    	String delete = request.getParameter("bDelete"); //$NON-NLS-1$
    	return (null != delete) && delete.equals("true"); //$NON-NLS-1$
    }

    /**
     * Handle the form submission.
     */
    @Override
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
        BindException errors) throws Exception
    {
        if (this.log.isDebugEnabled())
        {
            this.log.debug("entering 'onSubmit' method..."); //$NON-NLS-1$
        }

        User user = (User)command;
        Locale locale = request.getLocale();
        
        // Handle delete request here first
        if (isDelete(request))
        {
        	// disable user account, history will be available
        	// but user will not be able to login... may need various test scenarios.
        	user.setEnabled(false);
        	saveUser(user);
        	//getUserManager().removeUser(user.getId().toString());
        	//saveMessage(request, getText("user.deleted", user.getFullName(), locale)); //$NON-NLS-1$
            return new ModelAndView(getSuccessView());
        }
        
        Integer originalVersion = user.getVersion();

        // If there are binding errors, just redisplay the form with the errors.
        if (errors.getErrorCount() <= 0)
        {

	        if (passwordChanged(user))
	        {
	            user.setPassword(StringUtil.encodePassword(user.getPassword(), getPasswordAlgorithm()));
	        }
	
	        try
	        {
	        	saveUser(user);
	        	// The message to the user was taken out by request.
	            //saveMessage(request, getSavedMessage(request, user, locale));
	            String successView = getSuccessView();
	            if (isSignupEdit(request))
	            {
	            	autoLogin(request, user);
	            	sendEmail(request, user, locale);
	            	successView = "redirect:congratsPage.html";
	            }
	            return new ModelAndView(successView);
	        }
	        catch (UserExistsException e)
	        {
	            this.log.warn(e.getMessage());
	            rejectValue(user, errors);
	        }
        }

        // Reset to the unencrypted password and back to the original version
        user.setPassword(user.getConfirmPassword());
        user.setVersion(originalVersion);

        return showForm(request, response, errors);
    }
    
    private void rejectValue(User user, BindException errors)
    {
    	// Figure out what caused the save to fail and return the key that will
    	// tell the user why.  It is because the username, email or ghin number
    	// is already in use.
    	
    	if (this.getUserManager().isUsernameInUse(user.getUsername()))
    	{
    		errors.rejectValue("username", "errors.existing.username", //$NON-NLS-1$ //$NON-NLS-2$
    			new Object[] { user.getUsername() }, "duplicate username"); //$NON-NLS-1$
    		return;
    	}
    	    	
    	if (this.getUserManager().isEmailInUse(user.getEmail()))
    	{
    		errors.rejectValue("email", "errors.existing.email", //$NON-NLS-1$ //$NON-NLS-2$
        		new Object[] { user.getEmail() }, "duplicate email"); //$NON-NLS-1$
        	return;
    	}
    	
		errors.rejectValue("username", "errors.user.save", "user save failed"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }
    
    private String getPasswordAlgorithm()
    {
        String algorithm = (String) getConfiguration().get(Constants.ENC_ALGORITHM);
        if (algorithm == null)
        { // should only happen for test case
            if (this.log.isDebugEnabled())
            {
                this.log.debug("assuming testcase, setting algorithm to 'SHA'"); //$NON-NLS-1$
            }
            algorithm = "SHA"; //$NON-NLS-1$
        }
        return algorithm;
    }
    
    private boolean passwordChanged(User user)
    {
    	if (null == user.getVersion())
    	{
    		return true;
    	}
    	
    	User orig = this.getUserManager().getUser(user.getId().toString());
    	this.getUserManager().evictUser(orig);
    	if (null == orig)
    	{
    		return true;
    	}
    	return (!orig.getPassword().equals(user.getPassword()));
    }
    
    private void saveUser(User user) throws UserExistsException, ParseException
    {
    	if (null == user.getVersion())
    	{
    		user.setEnabled(true);
    		/***Code added by Piyush/Akash starts**/
    		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        	Date date = new Date();
    		/**Code added by Piyush/Akash ends**/
    		user.setDateJoined(dateFormat.parse(dateFormat.format(date)));
            user.addRole(this.roleManager.getRole(Constants.USER_ROLE));
    	}
    	if(null == user.getCourtId()){ //For new Court this condition will be met
    		user.setCourtId(saveCourt(user));
    	}
        getUserManager().saveUser(user);
    }
    
    private Long saveCourt(User user) {
    	Court court=new Court();
    	court.setName(user.getHomeCourtText());
    	court.setCourtAddress(user.getCourtAddress());
    	court.setCourtState(user.getCourtState());
    	court.setIsCourtLighted(user.getIsCourtLighted());
    	court.setNumberOfCourts(user.getNumberOfCourts());
    	court.setOpenCourtMeridiem(user.getOpenCourtMeridiem());
    	court.setCloseCourtMeridiem(user.getCloseCourtMeridiem());
    	court.setCloseCourtHour(user.getCloseCourtHour());
    	//court.setId(user.getCourtId());
    	
    	City city=user.getRegisteredCity();
    	List<City> cityList=new ArrayList<City>();
    	cityList.add(city);
    	
    	court.setCities(cityList);
    	return this.courtManager.saveAndReturnCourt(court);
	}

	/**
     * Get the message to display on a successful save.
     * @param request The current request.
     * @param user The user that was saved.
     * @param locale The locale to get the message for.
     * @return The string message to display to the user on a successful save.
     */
    private String getSavedMessage(HttpServletRequest request, User user, Locale locale)
    {
    	if (isProfileEdit(request))
    	{
    		return getText("user.saved", user.getFullName(), locale); //$NON-NLS-1$
    	}
    	else if (isSignupEdit(request))
    	{
    		return getText("user.added", user.getFullName(), locale); //$NON-NLS-1$
    	}
    	else if (isAdministratorEdit(request))
    	{
    		return getText("user.updated.byAdmin", user.getFullName(), locale); //$NON-NLS-1$
    	}
    	return ""; //$NON-NLS-1$
    }
    
    private void autoLogin(HttpServletRequest request, User user)
    {

        // log user in automatically
        Authentication auth = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getConfirmPassword());
        try
        {
            ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(
                request.getSession().getServletContext());
            if (ctx != null)
            {
                ProviderManager authenticationManager = (ProviderManager) ctx.getBean("authenticationManager"); //$NON-NLS-1$
                SecurityContextHolder.getContext().setAuthentication(authenticationManager.doAuthentication(auth));
            }
        }
        catch (NoSuchBeanDefinitionException n)
        {
            // ignore, should only happen when testing
        }
    }
    
    /**
     * Send email to a newly registered user.
     * @param request The current request.
     * @param user The user that just signed up.
     * @param locale The current locale.
     */
    private void sendEmail(HttpServletRequest request, User user, Locale locale)
    {
        // Send an account information e-mail
        this.message.setSubject(getText("userForm.email.subject", locale)); //$NON-NLS-1$
        //String url="<a href=\""+RequestUtil.getAppURL(request)+"\">"+"CITY GOLF LEAGUE"+"</a>";
        String url=RequestUtil.getAppURL(request);
        sendUserMessage(user, getText("newuser.email.message", user.getFullName(), locale), //$NON-NLS-1$
        		url);
        sendCourtAddressDetailsToAdmin(request,user,locale);
    }
    
    private void sendCourtAddressDetailsToAdmin(HttpServletRequest request, User user, Locale locale)
    {
        if (this.log.isDebugEnabled())
        {
            this.log.debug("sending e-mail to admin for court address...");
        }

        this.message.setTo("admin@openplaytennis.com");
        String subject = "NEW COURT | "+user.getCourtCity().toUpperCase();
        
        StringBuffer msg = new StringBuffer("Please verify the new court.");
        this.message.setSubject(subject);
		this.message.setText(msg.toString());
		this.mailEngine.send(this.message);
       
    }

    @Override
    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors)
        throws Exception
    {
    	// If a user is editing a profile make sure they are editing their own profile.
        if (isProfileEdit(request) && !isCurrentUser(request))
        {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            this.log.warn("User '" + request.getRemoteUser() +  //$NON-NLS-1$
                "' is trying to edit user '" + request.getParameter("username") + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            return null;
        }

        // Don't allow normal users to go to editUser.html
        if ((isAdministratorEdit(request)) &&
            (!request.isUserInRole(Constants.ADMIN_ROLE) && (errors.getErrorCount() == 0) && 
            (request.getRemoteUser() != null)))
        { // be nice to unit tests
        	this.log.warn("Normal user trying to call editUser.html - " + request.getRemoteUser()); //$NON-NLS-1$
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return null;
        }

        ModelAndView view = super.showForm(request, response, errors);
        updateCourtInfo(view, getCurrentCity(request, view));
        updateReferralInfo(view, request);
        view.addObject("isAdministrator", Boolean.valueOf(isAdministratorEdit(request))); //$NON-NLS-1$
        view.addObject("isUser", Boolean.valueOf(isProfileEdit(request)));
        if(Boolean.valueOf(isAdministratorEdit(request)))
        {
        	view.addObject("userId",user.getId());
        	Long adminId=((User)request.getSession().getAttribute("sessionLoginUser")).getId();
        	view.addObject("adminId",adminId);
        }
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

	private boolean isCurrentUser(HttpServletRequest request)
    {
    	String user = request.getParameter("username"); //$NON-NLS-1$
    	if (null == user)
    	{
    		return true;
    	}
    	return user.equals(request.getRemoteUser());
    }
    
    private City getCurrentCity(HttpServletRequest request, ModelAndView view)
    {
        City city = (City)request.getSession().getAttribute(Constants.CITY_TOKEN);
    	if ((null == city) && (null != view))
    	{
        	String msg = getMessageSourceAccessor().getMessage("errors.chooseCity", request.getLocale()); //$NON-NLS-1$
        	view.addObject("successMessages", new String[] { msg });//$NON-NLS-1$
    	}
    	return city;
    }
    
    /**
     * It can be used later to show the COurts corresponding to city selected on userForm.jsp
     * @param view
     * @param city
     */
    private void updateCourtInfo(ModelAndView view, City city)
    {
        if (null != city)
        {
            view.addObject("verifiedCourtList",  //$NON-NLS-1$
                this.courtManager.getCourts(city.getId()));
        }
    }
    
    private void updateReferralInfo(ModelAndView view, HttpServletRequest request)
    {
        List<String> referrals = new ArrayList<String>(5);
        
        referrals.add(getText("userForm.webSearch", request.getLocale())); //$NON-NLS-1$
        referrals.add(getText("userForm.onlineAdvertising", request.getLocale())); //$NON-NLS-1$
        referrals.add(getText("userForm.posterAtTennisCourt", request.getLocale())); //$NON-NLS-1$
        referrals.add(getText("userForm.posterAtTennisClub", request.getLocale())); //$NON-NLS-1$
        referrals.add(getText("userForm.posterElsewhere", request.getLocale())); //$NON-NLS-1$
        referrals.add(getText("userForm.emailNewsletter", request.getLocale()));
        referrals.add(getText("userForm.friend", request.getLocale())); //$NON-NLS-1$
        referrals.add(getText("userForm.other", request.getLocale())); //$NON-NLS-1$
        view.addObject("referrals", referrals); //$NON-NLS-1$
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception
    {
        if (!isFormSubmission(request))
        {
            String username = request.getParameter("usr"); //$NON-NLS-1$

            // if user logged in with remember me, display a warning that they
            // can't change passwords
            this.log.debug("checking for remember me login..."); //$NON-NLS-1$

            AuthenticationTrustResolver resolver = new AuthenticationTrustResolverImpl();
            SecurityContext ctx = SecurityContextHolder.getContext();

            if (ctx.getAuthentication() != null)
            {
                Authentication auth = ctx.getAuthentication();

                if (resolver.isRememberMe(auth))
                {
                    request.getSession().setAttribute("cookieLogin", "true"); //$NON-NLS-1$ //$NON-NLS-2$

                    // add warning message
                    saveMessage(request, getText("userForm.cookieLogin", request.getLocale())); //$NON-NLS-1$
                }
            }

          

            if (isProfileEdit(request))
            {
                user = getUserManager().getUserByUsername(request.getRemoteUser());
            }
            else if (!StringUtils.isBlank(username) && !"".equals(request.getParameter("version"))) //$NON-NLS-1$ //$NON-NLS-2$
            {
                user = getUserManager().getUserByUsername(username);
            }
            else
            {
                user = new User();
                user.addRole(new Role(Constants.USER_ROLE));
                user.setRegisteredCity(getCurrentCity(request, null));
            }

            user.setConfirmPassword(user.getPassword());

            return user;
        }

        User user = (User)super.formBackingObject(request);
        String[] userRoles = request.getParameterValues("userRoles"); //$NON-NLS-1$
        if (userRoles != null)
        {
            // for some reason, Spring seems to hang on to the roles in
            // the User object, even though isSessionForm() == false
            user.getRoles().clear();
            for (String roleName : userRoles)
            {
                user.addRole(this.roleManager.getRole(roleName));
            }
        }

        return user;
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
}
