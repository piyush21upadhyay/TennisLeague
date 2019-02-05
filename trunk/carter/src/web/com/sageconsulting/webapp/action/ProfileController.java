/*
 * ProfileController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.HashMap;
import java.util.SortedSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.GrantedAuthority;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import sun.misc.Perf.GetPerfAction;

import com.sageconsulting.model.Match;
import com.sageconsulting.model.PrivateMessage;
import com.sageconsulting.model.Registration;
import com.sageconsulting.model.Season;
import com.sageconsulting.model.User;
import com.sageconsulting.service.PrivatemessageManager;
import com.sageconsulting.service.MatchManager;
import com.sageconsulting.service.PublicMessageManager;
import com.sageconsulting.service.RegistrationManager;
import com.sageconsulting.service.SeasonManager;
import com.sageconsulting.service.UserManager;
import com.sageconsulting.util.SeasonInfo;
import com.sageconsulting.util.SeasonResult;
import com.sageconsulting.Constants;
import com.sageconsulting.model.City;
import com.sageconsulting.model.PublicMessage;
import com.sageconsulting.service.RegistrationEntryManager;
import com.sageconsulting.model.RegistrationEntry;

/**
 * Controller class for the main user home page.
 */
public class ProfileController extends ApplicationObjectSupport implements Controller
{
    private UserManager userManager;
    private SeasonManager seasonManager;
    private RegistrationManager registrationManager;
    private MatchManager matchManager;
    private PrivatemessageManager mailManager;
    private PublicMessageManager msgBoardManager;
    private RegistrationEntryManager registrationEntryManager;
    
    public void setUserManager(UserManager mgr)
    {
        this.userManager = mgr;
    }
    
    public void setSeasonManager(SeasonManager mgr)
    {
    	this.seasonManager = mgr;
    }
    
    public void setRegistrationManager(RegistrationManager mgr)
    {
    	this.registrationManager = mgr;
    }
    
    public void setMatchManager(MatchManager mgr)
    {
        this.matchManager = mgr;
    }
    
    /**
     * @param mailManager The mailManager to set.
     */
    public void setMailManager(PrivatemessageManager mgr)
    {
        this.mailManager = mgr;
    }
    
    public void setPublicMessageManager(PublicMessageManager mgr)
    {
        this.msgBoardManager = mgr;
    }
    
    public void setRegistrationEntryManager(RegistrationEntryManager mgr)
    {
    	this.registrationEntryManager = mgr;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ModelAndView view = new ModelAndView();
        
        User user = getUser(request);
        boolean isCurrentUser = this.isCurrentUser(request, user);
        boolean isAdmin = this.isCurrentUserAdmin(request, user);
        City city = (City)request.getSession().getAttribute(Constants.CITY_TOKEN);
        
        view.addObject("isCurrentUser", Boolean.valueOf(isCurrentUser)); //$NON-NLS-1$
        view.addObject("isAdmin", Boolean.valueOf(isAdmin));
        if (null != user)
        {
            view.addObject("user", user); //$NON-NLS-1$
            view.addObject("matches", getNextMatches(user)); //$NON-NLS-1$
            view.addObject("currentRecord", getCurrentRecord(user)); //$NON-NLS-1$
            view.addObject("overallRecord", user.getOverallRecord()); //$NON-NLS-1$
            view.addObject("currentDivision", getCurrentDivision(user)); //$NON-NLS-1$
            view.addObject("seasonPosition", getSeasonPosition(user, request.getLocale())); //$NON-NLS-1$
            view.addObject("seasonPoints", getSeasonPoints(user, request.getLocale())); //$NON-NLS-1$
            view.addObject("privateMessages", this.mailManager.getAllPrivateMessages(user.getId())); //$NON-NLS-1$
            
            List<PublicMessage> allMessages = this.msgBoardManager.getAllPublicMessages(city.getId(), null, "");
            view.addObject("publicMessages", allMessages);
            view.addObject("openRegistrations", this.getOpenRegistrations(user)); //$NON-NLS-1$
            view.addObject("registeredSeason", this.getOpenEntryRegistrations(user));
            view.addObject("seasonStarted", this.getCurrentSeasonStarted(user));
            view.addObject("percentageGamesWon", getGamesWonPercentage(user, request.getLocale()));
            view.addObject("percentageGamesLoss", getGamesLossPercentage(user, request.getLocale()));
            updateBirdieCount(view, user);
            updatePlayingPrefForMixedDoubles(user.getPlayingPreference());
            //view.addObject("new_messages", Integer.valueOf(this.mailManager.getNumberNewMessages(user.getId()))); //$NON-NLS-1$
        }
        else if(user == null)
        {
        	List<Registration> openForRegistration = this.registrationManager.getOpenRegistrationsForCity(city.getId());
        	view.addObject("openRegistrationForVisitor", openForRegistration);
        }
        
        if (request.getRemoteUser() != null)
        {
        	User currentUser = this.userManager.getUserByUsername(request.getRemoteUser());
        	//updatePlayingPrefForMixedDoubles(currentUser.getPlayingPreference());
        	view.addObject("currentUser",currentUser);
        }
        if (isCurrentUser && (request.getSession().getAttribute("prevLastLogin") != null))
        	view.addObject("lastLogin", request.getSession().getAttribute("prevLastLogin"));
        return view;
    }
    
    /**
     * @param playingPreferenceArr
     */
    private void updatePlayingPrefForMixedDoubles(String[] playingPreferenceArr) {
    	if(null != playingPreferenceArr)
    	{
	    	for(int i=0;i<playingPreferenceArr.length;i++){
	    		if("Mixeddoubles".equals(playingPreferenceArr[i])){
	    			playingPreferenceArr[i]="Mixed Doubles";
	    		}
	    	}
    	}
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
    
    private boolean isCurrentUser(HttpServletRequest request, User user)
    {
        String currentUserName = request.getRemoteUser();
        if ((null == user) || (null == currentUserName))
        {
            return false;
        }
        
        return user.getUsername().equals(currentUserName);
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
    
    private List<Match> getNextMatches(User user)
    {
        List<Match> matches = new ArrayList<Match>(2);
        
        if((user.getCurrentSeason() == null) || ((user.getCurrentSeason() != null) && (user.getCurrentSeason().getState().intValue() == Season.STATE_CLEAR)) )
        	return matches;
        
        List<Match> allMatches = getMatchesForUser(this.matchManager.getMatchesForGolfer(user.getId()), user);
        for (Match match : allMatches)
        {
            if (null == match.getPlayed())
            {
                matches.add(match);
                if (matches.size() >= 2)
                {
                    break;
                }
            }
        }
        
        return matches;
    }
    
    private List<Match> getMatchesForUser(List<Match> matches, User currentUser)
    {
    	List<Match> list = new ArrayList<Match>(matches.size());
    	
    	if(currentUser.getCurrentSeason().getState().intValue() == Season.STATE_POST_SEASON)
        {
        	// get only post season matches.
        	for (Match match : matches)
            {
            	if(match.getBracketEntry() != null)
        		{
        			if (match.getBracketEntry().getSeasonId().longValue() == currentUser.getCurrentSeason().getId().longValue())
        				list.add(match);
        		}
            }
        }
        else if(currentUser.getCurrentSeason().getState().intValue() == Season.STATE_REGULAR_SEASON)
        {
        	// get only regular season matches.
	        for (Match match : matches)
	        {
	        	boolean response = isCurrentSeasonMatch(match, currentUser.getCurrentSeason());
    			if(response)
    				list.add(match);
	        }
        }
        return list;
    }
    
    private String getCurrentDivision(User user)
    {
        if (null == user.getCurrentSeason()){
            return ""; //$NON-NLS-1$
        }
        return user.getCurrentSeason().getDivision();
    }
    
    private String getSeasonPosition(User user, Locale locale)
    {
    	if ((null == user.getCurrentSeason()) || (user.getCurrentSeason().getState().intValue() == Season.STATE_CLEAR))
    	{
        	return getMessageSourceAccessor().getMessage("profile.notApplicable", locale); //$NON-NLS-1$
    	}
    	
    	// First find this user in the sorted list of results to get their current position
    	Long seasonId = user.getCurrentSeason().getId();
    	SeasonResult[] results = SeasonInfo.getSortedSeasonResults(this.seasonManager, seasonId);
    	int pos = 0;
    	for (SeasonResult result: results)
    	{
    		if (result.getUser().equals(user))
    		{
    			break;
    		}
    		pos++;
    	}
    	
    	// Now work backward in the result set to account for ties.  This will make all people that
    	// have the same score be tied for the same position.
    	/*int i = pos-1;
    	while ((i >= 0) && (results[pos].getPoints() == results[i].getPoints()))
    	{
    		pos--;
    		i--;
    	}*/
    	
    	return Integer.toString(pos+1); // Make the result 1 based instead of 0
    }
    
    private String getSeasonPoints(User user, Locale locale)
    {
    	if ((null == user.getCurrentSeason()) || (user.getCurrentSeason().getState().intValue() == Season.STATE_CLEAR))
    	{
        	return getMessageSourceAccessor().getMessage("profile.notApplicable", locale); //$NON-NLS-1$
    	}

    	return "" + user.getCurrentPoints(); //$NON-NLS-1$
    }
    
    private String getGamesWonPercentage(User user, Locale locale)
    {
    	if ((null == user.getCurrentSeason()) || (user.getCurrentSeason().getState().intValue() == Season.STATE_CLEAR))
    	{
        	return getMessageSourceAccessor().getMessage("profile.notApplicable", locale); //$NON-NLS-1$
    	}

    	return user.getGamesWonPercentage(); //$NON-NLS-1$
    }
    
    private String getGamesLossPercentage(User user, Locale locale)
    {
    	if ((null == user.getCurrentSeason()) || (user.getCurrentSeason().getState().intValue() == Season.STATE_CLEAR))
    	{
        	return getMessageSourceAccessor().getMessage("profile.notApplicable", locale); //$NON-NLS-1$
    	}

    	return user.getGamesLossPercentage(); //$NON-NLS-1$
    }
    
    private List<Registration> getOpenRegistrations(User user)
    {
    	if (null != user)
    	{
    		return this.registrationManager.getOpenRegistrationsForCity(user.getRegisteredCity().getId());
    	}
    	return null;
    }
    
    private List<Registration> getOpenEntryRegistrations(User user)
    {
    	List<Registration> userRegisteredSeason = new ArrayList<Registration>();
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
    					if(registedSeason.getId() == cityOpenSeasonList.get(innerCounter).getId())
        				{
        					userRegisteredSeason.add(registedSeason);
        				}
    				}
    			}
    		}
    	}
    	return userRegisteredSeason;
    }
    
    private boolean getCurrentSeasonStarted(User user)
    {
    	//get list of registration entries for which member has paid
    	List<RegistrationEntry> userRegistrationEntryList = this.registrationEntryManager.getRegistrationEntriesForUser(user.getId());
    	
    	if(userRegistrationEntryList.size() > 0)
    	{
    		for(int listCounter=0; listCounter<userRegistrationEntryList.size(); listCounter++)
    		{
    			Registration userEntry = userRegistrationEntryList.get(listCounter).getRegistration();
    			
    			if(userEntry != null)
    			{
    				List<Season> seasonList = this.seasonManager.getSeasonsForRegistration(userEntry.getId());
    				
    				if((seasonList != null) && (seasonList.size() == 0))
    					return false;
    			}
    		}
    	}
    	else
    		return true;

    	return true;
    }
    
    private void updateBirdieCount(ModelAndView view, User user)
    {
    	HashMap<String, Integer> birdiePoints = new HashMap<String, Integer>();
    	int curBirdieCount = 0;
    	int curEagleCount = 0;
    	int curDoubleEagleCount = 0;
    	int birdieCount = 0;
    	int eagleCount = 0;
    	int doubleEagleCount = 0;
    	if ((null != user.getCurrentSeason()) && (user.getCurrentSeason().getState().intValue() != Season.STATE_CLEAR))
    	{
    		List<Match> matches = this.matchManager.getMatchesForGolferAndSeason(
    			user.getId(), user.getCurrentSeason().getId());
    		for (int i=0; i<matches.size(); i++)
    		{
    			Match match = matches.get(i);
    			if ((null != match.getPlayed()) && (!match.isDefaultWin()))
    			{
    				Date startDate = new Date(getWeekStart(match.getPlayBy()));
    				int dateDiff = new Date().compareTo(startDate);
        			birdiePoints = getAllBirdiePoints(match, user);
        			
        			for (String key : birdiePoints.keySet())
        			{
        				if(dateDiff >= 0 && (match.getPlayBy().compareTo(match.getPlayed()) >= 0))
        				{
        					if(key.equals("birdieCount"))
        						curBirdieCount = birdiePoints.get(key);
        					else if(key.equals("eagleCount"))
        						curEagleCount = birdiePoints.get(key);
        					else if(key.equals("doubleEagleCount"))
        						curDoubleEagleCount = birdiePoints.get(key);
        				}
        				
        				if(key.equals("birdieCount"))
        					birdieCount += birdiePoints.get(key);
    					else if(key.equals("eagleCount"))
    						eagleCount += birdiePoints.get(key);
    					else if(key.equals("doubleEagleCount"))
    						doubleEagleCount += birdiePoints.get(key);
        			}
    			}
    		}
    	}
    	
    	view.addObject("curBirdieCount", Integer.valueOf(curBirdieCount)); //$NON-NLS-1$
    	view.addObject("curEagleCount", Integer.valueOf(curEagleCount)); //$NON-NLS-1$
    	view.addObject("curDoubleEagleCount", Integer.valueOf(curDoubleEagleCount)); //$NON-NLS-1$
    	view.addObject("birdieCount", Integer.valueOf(birdieCount)); //$NON-NLS-1$
    	view.addObject("eagleCount", Integer.valueOf(eagleCount)); //$NON-NLS-1$
    	view.addObject("doubleEagleCount", Integer.valueOf(doubleEagleCount)); //$NON-NLS-1$
    }
    
    private String getBirdieType(Byte playerScore, Byte playerPar, Byte playerStroke)
    {
    	String type = "";
    	
    	if (isBirdie(playerScore, playerPar))
        {
    		type = "birdie";
        }
        if (isEagle(playerScore, playerPar))
        {
        	type = "eagle";
        }
        if (isDoubleEagle(playerScore, playerPar))
        {
        	type = "double_eagle";
        }
        if (isNetBirdie(playerScore, playerPar, playerStroke))
        {
        	type = "net_birdie";
        }
        if (isNetEagle(playerScore, playerPar, playerStroke))
        {
        	type = "net_eagle";
        }
        if (isNetDoubleEagle(playerScore, playerPar, playerStroke))
        {
        	type = "net_double_eagle";
        }
    	
    	return type;
    }
    
    private HashMap<String, Integer> getAllBirdiePoints(Match match, User user)
    {
    	HashMap<String, Integer> birdieCounts = new HashMap<String, Integer>();
    	String birdieType = "";
    	int birdiePoints = 0;
    	int eaglePoints = 0;
    	int dblEaglePoints = 0;
    	
    	// TODO: Akash
    	/*if (match.getGolfer1().equals(user))
    	{
    		Byte[] player1Scores = match.getScore().getPlayer1Scores();
    		Byte[] player1Pars = match.getScore().getPlayer1Pars();
    		Byte[] player1Strokes = match.getScore().getPlayer1Strokes();
    		
    		for(int i=0; i<18; i++)
    		{
    			if(player1Scores[i] > 0)
    			{
    				birdieType = getBirdieType(player1Scores[i], player1Pars[i], player1Strokes[i]);
        			
        			if(birdieType.equals("birdie") || birdieType.equals("net_birdie"))
        				birdiePoints++;
        			else if(birdieType.equals("eagle") || birdieType.equals("net_eagle"))
        				eaglePoints++;
        			else if(birdieType.equals("double_eagle") || birdieType.equals("net_double_eagle"))
        				dblEaglePoints++;
    			}
    		}
    	}
    	else if (match.getGolfer2().equals(user))
    	{
    		Byte[] player2Scores = match.getScore().getPlayer2Scores();
    		Byte[] player2Pars = match.getScore().getPlayer2Pars();
    		Byte[] player2Strokes = match.getScore().getPlayer2Strokes();
    		
    		for(int i=0; i<18; i++)
    		{
    			if(player2Scores[i] > 0)
    			{
    				birdieType = getBirdieType(player2Scores[i], player2Pars[i], player2Strokes[i]);
        			
        			if(birdieType.equals("birdie") || birdieType.equals("net_birdie"))
        				birdiePoints++;
        			else if(birdieType.equals("eagle") || birdieType.equals("net_eagle"))
        				eaglePoints++;
        			else if(birdieType.equals("double_eagle") || birdieType.equals("net_double_eagle"))
        				dblEaglePoints++;
    			}
    		}
    	}*/
    	
    	birdieCounts.put("birdieCount", birdiePoints);
    	birdieCounts.put("eagleCount", eaglePoints);
    	birdieCounts.put("doubleEagleCount", dblEaglePoints);
    	
    	return birdieCounts;
    }
    
    private boolean isBirdie(Byte playerScore, Byte playerPar)
    {
        return (playerPar.byteValue() - playerScore.byteValue()) == 1;
    }
    
    private boolean isEagle(Byte playerScore, Byte playerPar)
    {
        return (playerPar.byteValue() - playerScore.byteValue()) == 2;
    }
    
    private boolean isDoubleEagle(Byte playerScore, Byte playerPar)
    {
        return (playerPar.byteValue() - playerScore.byteValue()) == 3;
    }
    
    private boolean isNetBirdie(Byte playerScore, Byte playerPar, Byte playerStrokes)
    {
        //if (playerStrokes.byteValue() <= 0) return false;
        return ((playerPar.byteValue() == (playerScore.byteValue() - playerStrokes.byteValue() + 1)) &&
        	(playerStrokes > 0));
    }
    
    private boolean isNetEagle(Byte playerScore, Byte playerPar, Byte playerStrokes)
    {
        //if (playerStrokes.byteValue() <= 0) return false;
        return ((playerPar.byteValue() == (playerScore.byteValue() - playerStrokes.byteValue() + 2)) &&
        	(playerStrokes > 0));
    }
    
    private boolean isNetDoubleEagle(Byte playerScore, Byte playerPar, Byte playerStrokes)
    {
        //if (playerStrokes.byteValue() <= 0) return false;
        return ((playerPar.byteValue() == (playerScore.byteValue() - playerStrokes.byteValue() + 3)) &&
       		(playerStrokes > 0));
    }
    
	private long getWeekStart(Date playBy)
	{
		long weekStart = playBy.getTime() - (86400000 * 6);
		return weekStart;
	}
	
	private String getCurrentRecord(User user)
	{
		if((user.getCurrentSeason() == null) || (user.getCurrentSeason().getState().intValue() == Season.STATE_CLEAR))
		{
			StringBuilder sb = new StringBuilder("0").append('-').append("0").append('-').append("0");
			return sb.toString();
		}
		
		return user.getCurrentRecord();
	}
	
	private boolean isCurrentSeasonMatch(Match match, Season currentSeason)
    {
    	boolean response = false;
    	SortedSet<Match> matches = currentSeason.getMatches();
    	
    	for (Match seasonMatch : matches)
    	{
    		if(seasonMatch.equals(match))
    		{
    			response = true;
    			break;
    		}
    	}
    	return response;
    }
}
