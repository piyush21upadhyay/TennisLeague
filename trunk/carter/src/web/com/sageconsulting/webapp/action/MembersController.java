/*
 * MembersController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.GrantedAuthority;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.sageconsulting.Constants;
import com.sageconsulting.model.City;
import com.sageconsulting.model.Registration;
import com.sageconsulting.model.RegistrationEntry;
import com.sageconsulting.model.User;
import com.sageconsulting.service.RegistrationEntryManager;
import com.sageconsulting.service.RegistrationManager;

public class MembersController extends BaseFormController
{
    private static final String CMD_NAME = "search"; //$NON-NLS-1$
    private RegistrationManager registrationManager;
    private RegistrationEntryManager registrationEntryManager;
    
    public MembersController()
    {
        setCommandName(CMD_NAME);
        setCommandClass(MemberName.class);
    }
    
    public void setRegistrationManager(RegistrationManager mgr)
    {
    	this.registrationManager = mgr;
    }
    
    public void setRegistrationEntryManager(RegistrationEntryManager mgr)
    {
    	this.registrationEntryManager = mgr;
    }
    
    @Override
    public ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors) throws Exception
    {
        City city = (City)request.getSession().getAttribute(Constants.CITY_TOKEN);
        ModelAndView view = new ModelAndView();
        
        if (null == city)
        {
        	String msg = getMessageSourceAccessor().getMessage("errors.noCity", request.getLocale()); //$NON-NLS-1$
        	view.addObject("successMessages", new String[] { msg });//$NON-NLS-1$
        	return view;
        }
        
        return getModelAndView(city, (MemberName)getCommand(request), request);
    }
    
    @Override
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
        BindException errors) throws Exception
    {
        City city = (City)request.getSession().getAttribute(Constants.CITY_TOKEN);
        return getModelAndView(city, (MemberName)command, request);
    }
    
    private ModelAndView getModelAndView(City city, MemberName command, HttpServletRequest request)
    {
        ModelAndView view = new ModelAndView();
        view.addObject(CMD_NAME, command);
        
        if (command.isValidSearch())
        {
        	List<User> users = getUsers(city, command, request);
            view.addObject("memberList", users); //$NON-NLS-1$
            view.addObject("registeredUsers", getRegisteredUsers(users));
            /**Added by Piyush/Akash starts***/
            List<Double> playerRatings=Arrays.asList(new Double[]{2.5,3.0,3.5,4.0,4.5,5.0});
            List<String> gender=Arrays.asList(new String[]{"Male","Female"});
            List<String> dexterities=Arrays.asList(new String[]{"Left Handed","Right Handed"});
            List<String> matchPreferences=Arrays.asList(new String[]{"Singles","Doubles","Mixed Doubles"});
            view.addObject("playerRatings", playerRatings);
            view.addObject("gender", gender);
            view.addObject("dexterities", dexterities);
            view.addObject("matchPreferences", matchPreferences);
            /**Added by Piyush/Akash starts***/
        }
        if (request.getRemoteUser() != null)
        {
        	User user = super.getUserManager().getUserByUsername(request.getRemoteUser());
        	view.addObject("user",user);
        	view.addObject("isAdministrator", checkAdminAuth(request.getRemoteUser()));
        }
        
        if(request.getParameter("showDeleted") != null)
        	view.addObject("showDeleted", true);
        
        return view;
    }
    
    private List<User> getUsers(City city, MemberName command, HttpServletRequest request)
    {
    	Long cityId = (null == city) ? null : city.getId();
        /*List<User> users = getUserManager().findUsers(cityId, command.getFirstname(),
            command.getLastname(), getDouble(command.getMinHandicap()),
            getDouble(command.getMaxHandicap()));*/
        
        List<User> users = getUserManager().findTotalUsers(cityId, command.getFirstname(),
                command.getLastname(), command.getGender(),command.getRating(),command.getMinRating(),command.getMaxRating(),
                command.getDexterity(), command.getMatchPreference(),command.getTournamentEntry());
        
        // check if user has admin role and show deleted is true, skip delete check
        boolean checkDeleted = getDeletedMembers(request);
        List<User> userList = new ArrayList<User>();
        
        if(!checkDeleted)
        {
        	// check if user's profile is 'deleted'
        	for (User user : users)
            {
                if (!user.isAccountDeleted())
                	userList.add(user);
            }
        }
        else
        	userList = users;
        
        return userList;
    }
    
    private Double getDouble(Integer val)
    {
        Double dval = null;
        
        if (null != val)
        {
            dval = Double.valueOf(val.doubleValue());
        }
        
        return dval;
    }
    
    @Override
    public Object formBackingObject(HttpServletRequest request) throws Exception
    {
        return getMemberName(request);
    }
    
    private MemberName getMemberName(HttpServletRequest request)
    {
        MemberName memberName = new MemberName();
        String firstname = request.getParameter("firstname"); //$NON-NLS-1$
        if (null != firstname)
        {
            memberName.setFirstname(firstname);
        }
        String lastname = request.getParameter("lastname"); //$NON-NLS-1$
        if (null != lastname)
        {
            memberName.setLastname(lastname);
        }
        /*String strVal = request.getParameter("maxHandicap"); //$NON-NLS-1$
        if (null != strVal)
        {
            memberName.setMaxHandcap(getInteger(strVal));
        }
        strVal = request.getParameter("minHandicap"); //$NON-NLS-1$
        if (null != strVal)
        {
            memberName.setMinHandcap(getInteger(strVal));
        }*/
        String gender = request.getParameter("gender"); //$NON-NLS-1$
        if (null != gender)
        {
            memberName.setGender(gender);;
        }
        String dexterity = request.getParameter("dexterity"); //$NON-NLS-1$
        if (null != dexterity)
        {
            memberName.setDexterity(dexterity);;
        }
        String matchPreference=request.getParameter("matchPreference");
        if(null !=matchPreference)
        {
        	memberName.setMatchPreference(matchPreference);
        }
        String tournamentEntry = request.getParameter("tournamentEntry"); //$NON-NLS-1$
        if (null != tournamentEntry)
        {
            memberName.setTournamentEntry(tournamentEntry);
        }
        String rating = request.getParameter("rating"); //$NON-NLS-1$
        if (isNotEmpty(rating))
        {
            memberName.setRating(Double.valueOf(rating));
        }
        String minRating=request.getParameter("minRating");
        if(isNotEmpty(minRating))
        {
        	memberName.setMinRating(Double.valueOf(minRating));
        }
        String maxRating=request.getParameter("maxRating");
        if(isNotEmpty(maxRating))
        {
        	memberName.setMaxRating(Double.valueOf(maxRating));
        }
        return memberName;
    }
    
    private boolean isNotEmpty(String input) {
		return (null != input) && (input.length()) > 0;
	}
    
    private Integer getInteger(String val)
    {
        Integer d = null;
        try
        {
            d = Integer.valueOf(val);
        }
        catch (NumberFormatException e)
        {
            // ignore this and return null
        }
        return d;
    }
    
    private Long getOpenEntryRegistrations(User user)
    {
    	Long registeredSeason = 0L;
    	if (null != user)
    	{
    		//get list of all open seasons in user's registered city
    		List<Registration> cityOpenSeasonList = this.registrationManager.getOpenRegistrationsForCity(user.getRegisteredCity().getId());
    		
    		if(cityOpenSeasonList.size() > 0)
    		{
    			List<RegistrationEntry> userRegistrationEntryList = this.registrationEntryManager.getRegistrationEntriesForUser(user.getId());
    			
    			for(int listCounter=0; listCounter<userRegistrationEntryList.size(); listCounter++)
    			{
    				RegistrationEntry userEntry = userRegistrationEntryList.get(listCounter);
    				Registration registedSeason = userEntry.getRegistration();

    				for(int innerCounter=0; innerCounter<cityOpenSeasonList.size(); innerCounter++)
    				{
    					if((registedSeason.getId() == cityOpenSeasonList.get(innerCounter).getId()) && (cityOpenSeasonList.get(innerCounter).getScheduleState().intValue() == 0))
        				{
    						registeredSeason = cityOpenSeasonList.get(innerCounter).getId();
    						break;
        				}
    				}
    				
    				if(registeredSeason > 0L)
    					break;
    			}
    		}
    	}
    	return registeredSeason;
    }
    
    private Map<Long,Long> getRegisteredUsers(List<User> users)
    {
    	if(users.size() <= 0)
    		return null;
    	
    	Map<Long,Long> userRegistrations = new HashMap<Long,Long>();
    	
    	for(int counter = 0; counter<users.size(); counter++)
    	{
    		Long registeredSeasonId = getOpenEntryRegistrations(users.get(counter));
    		if(registeredSeasonId > 0L)
    			userRegistrations.put(users.get(counter).getId(), registeredSeasonId);
    	}
    	
    	return userRegistrations;
    }
    
    private boolean checkAdminAuth(String userName)
    {
    	boolean isAdministrator = false;
    	User currentUser = super.getUserManager().getUserByUsername(userName);
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
    
    private boolean getDeletedMembers(HttpServletRequest request)
    {
    	boolean response = false;
    	if(request.getRemoteUser() != null)
    	{
    		response = checkAdminAuth(request.getRemoteUser());
    		
    		if(request.getParameter("showDeleted") != null)
    			response = response && true;
    		else
    			response = response && false;
    	}
    	return response;
    }
    
    public static final class MemberName implements java.io.Serializable
    {
        /**
		 * 
		 */
		private static final long serialVersionUID = 3832626162173359411L;
		private String firstname;
        private String lastname;
        private String gender;
        private String dexterity;
        private String matchPreference;
        private String tournamentEntry;
        /*private Double rating;
        private Double minRating=Double.valueOf(2.5);
        private Double maxRating=Double.valueOf(5.0);*/
        private Double rating=null;
        private Double minRating=null;
        private Double maxRating=Double.valueOf(5.0);
        private Integer maxHandicap = Integer.valueOf(100);//Integer.valueOf(6);
        private Integer minHandicap = null;
        
        public MemberName() {
		}
        
        public String getFirstname() { return this.firstname; }
        public void setFirstname(String name) { this.firstname = name; }
        
        public String getLastname() { return this.lastname; }
        public void setLastname(String name) { this.lastname = name; }
        
        public Integer getMaxHandicap() { return this.maxHandicap; }
        public void setMaxHandcap(Integer d) { this.maxHandicap = d; }
        
        public Integer getMinHandicap() { return this.minHandicap; }
        public void setMinHandcap(Integer d) { this.minHandicap = d; }
        
        public String getGender() {	return this.gender;}
		public void setGender(String gender) {this.gender = gender;}
		
		public String getDexterity() {return this.dexterity;}
		public void setDexterity(String dexterity) {this.dexterity = dexterity;}
		
		public String getMatchPreference() {return this.matchPreference;}
		public void setMatchPreference(String matchPreference) {this.matchPreference = matchPreference;}
		
		public String getTournamentEntry() {return this.tournamentEntry;}
		public void setTournamentEntry(String tournamentEntry) {this.tournamentEntry = tournamentEntry;}
		
		public Double getRating() {return this.rating;}
		public void setRating(Double r) {this.rating = r;}
		
		public Double getMinRating() {return this.minRating;}
		public void setMinRating(Double minR) {this.minRating = minR;}
		
		public Double getMaxRating() {return this.maxRating;}
		public void setMaxRating(Double maxR) {this.maxRating = maxR;}
        
        public boolean isValidSearch()
        {
        	return (null != this.firstname) ||
                    (null != this.lastname) ||
                    (null != this.maxRating) ||
                    (null != this.minRating)||
                    (null != this.rating)||
                    (null != this.gender) ||
                    (null != this.dexterity) ||
                    (null != this.matchPreference)||
                    (null != this.tournamentEntry);
        }
        
        @Override
		public String toString() {
			return "MemberName [firstname=" + firstname + ", lastname="
					+ lastname + ", gender=" + gender + ", dexterity="
					+ dexterity + ", matchPreference=" + matchPreference
					+ ", tournamentEntry=" + tournamentEntry + ", rating="
					+ rating + ", minRating=" + minRating + ", maxRating="
					+ maxRating + "]";
		}
    }
}
