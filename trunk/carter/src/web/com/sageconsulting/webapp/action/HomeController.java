/*
 * HomeController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sageconsulting.Constants;
import com.sageconsulting.model.City;
import com.sageconsulting.model.Match;
import com.sageconsulting.model.MatchCategory;
import com.sageconsulting.model.PublicMessage;
import com.sageconsulting.model.Registration;
import com.sageconsulting.model.Season;
import com.sageconsulting.model.TickerMessage;
import com.sageconsulting.model.User;
import com.sageconsulting.service.MatchCategoryManager;
import com.sageconsulting.service.PublicMessageManager;
import com.sageconsulting.service.RegistrationManager;
import com.sageconsulting.service.SeasonManager;
import com.sageconsulting.service.TickerMessageManager;
import com.sageconsulting.service.UserManager;
import com.sageconsulting.util.DateUtil;
import com.sageconsulting.util.SeasonInfo;
import com.sageconsulting.util.SeasonResult;

/**
 * Controller class for the main user home page.
 */
public class HomeController extends ApplicationObjectSupport implements Controller
{
    private SeasonManager seasonManager;
    private PublicMessageManager msgBoardManager;
    private TickerMessageManager tickerMessageManager;
    private UserManager userManager;
    private RegistrationManager registrationManager;
    private MatchCategoryManager matchCategoryManager;
	private String weatherKey = "2bca57c999051124122908";
    
    public void setSeasonManager(SeasonManager mgr)
    {
        this.seasonManager = mgr;
    }
    
    public void setPublicMessageManager(PublicMessageManager mgr)
    {
        this.msgBoardManager = mgr;
    }
    
    public void setTickerMessageManager(TickerMessageManager mgr)
    {
        this.tickerMessageManager = mgr;
    }
    
    public void setUserManager(UserManager mgr)
    {
        this.userManager = mgr;
    }
    
    public void setRegistrationManager(RegistrationManager mgr)
    {
        this.registrationManager = mgr;
    }
    
    public void setMatchCategoryManager(MatchCategoryManager matchCategoryManager) {
		this.matchCategoryManager = matchCategoryManager;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ModelAndView view = new ModelAndView();
        Map<String, Object> objWeather = new HashMap<String, Object>();
        String msgId = "";
        
        City city = (City)request.getSession().getAttribute(Constants.CITY_TOKEN);
        
        if (null != city)
        {
        	Integer countdownDays = Integer.valueOf(DateUtil.computeDaysToDate(city.getCountDownDate()));
            view.addObject("countdownMessage", city.getCountDownMessage()); //$NON-NLS-1$
            view.addObject("countdownDays", countdownDays); //$NON-NLS-1$
    
            /**Added by Piyush&Akash for Tennis League Project starts**/
            List<MatchCategory> matchCategories= getVariousMatchCategories(city);
            view.addObject("matchCategories", matchCategories); //$NON-NLS-1$
            /**Added by Piyush&Akash for Tennis League Project ends**/
            List<Season> openSeasons = getOpenSeasons(city);
            sortList(openSeasons);
            view.addObject("seasons", openSeasons); //$NON-NLS-1$
            Season standingsSeason = getStandingsSeason(request, openSeasons);
            view.addObject("season", standingsSeason); //$NON-NLS-1$
            view.addObject("standings", getStandings(standingsSeason)); //$NON-NLS-1$

            String s = request.getParameter("division");
            if ((s == null) && ((openSeasons.size() > 0) && (openSeasons.get(0).getState().intValue() == Season.STATE_CLEAR)))
            	view.addObject("hideStandings", true);
            
            List<PublicMessage> allMessages = this.msgBoardManager.getAllPublicMessages(city.getId(), null, "");
            view.addObject("publicMessages", allMessages); //$NON-NLS-1$ //$NON-NLS-2$
            view.addObject("tickerMessages", getTickerMessages(city)); //$NON-NLS-1$
            
            String playoffCounter = getPlayoffCountdown(standingsSeason);
            if((playoffCounter != null) && (!playoffCounter.equals("0")))
            	view.addObject("playOffCountdownDays", playoffCounter);
            view.addObject("seasonStarted", getSeasonStarted(standingsSeason));
            
            msgId = request.getParameter("msg"); //$NON-NLS-1$
            
            // select top most message by default
            if((msgId == null) && (! allMessages.isEmpty()))
            	msgId = getMessageId(allMessages.get(0));
            
            if (null != msgId)
        	{
        		Long id = Long.valueOf(msgId);
        		view.addObject("currentMessage",this.msgBoardManager.getPublicMessage(id));
        	}
        	// Get the user if one is logged in.
            if (request.getRemoteUser() != null)
            {
            	User user = this.userManager.getUserByUsername(request.getRemoteUser());
            	view.addObject("user",user);
            	HttpSession session=request.getSession();
            	session.setAttribute("sessionLoginUser", user);
            }
            
            // get city name
            view.addObject("cityName",city.getName());
            
            // get banner date
            List<Registration> openRegistrations = this.registrationManager.getOpenRegistrationsForCity(city.getId());
            Registration currentRegistration = null;
            
            if(openRegistrations.size() > 0)
            {
            	for( Registration openRegistration : openRegistrations )
            	{
            		if(openRegistration.getScheduleState().intValue() == Registration.STATE_UNSCHEDULED)
            		{
            			currentRegistration = openRegistration;
            			break;
            		}
            	}
            	
            	if(currentRegistration != null)
            	{
            		view.addObject("countdownDate", currentRegistration.getEarlyRegistrationStart());
                	view.addObject("dateSuffix", DateUtil.getDateSuffix(currentRegistration.getEarlyRegistrationStart()));
            	}
            }
            //get city's weather conditions
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        	DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = null;
			boolean weatherSuccess = false;
			
			// Get weather data from worldweatheronline.com
			try
			{
				doc = docBuilder.parse("http://free.worldweatheronline.com/feed/weather.ashx?format=xml&num_of_days=1&key=" + this.weatherKey + "&q=" + city.getName());
				weatherSuccess = true;
			
	        	if( weatherSuccess == true )
				{
					NodeList nList = doc.getElementsByTagName("weather");
	
					for(int temp = 0; temp < nList.getLength(); temp++)
					{
					   Node nNode = nList.item(temp);
					   if(nNode.getNodeType() == Node.ELEMENT_NODE)
					   {
							Element eElement = (Element) nNode;
							objWeather.put("dayOfWeek", getTagValue("date", eElement).trim());
							objWeather.put("low", getTagValue("tempMinF", eElement).trim());
							objWeather.put("high", getTagValue("tempMaxF", eElement).trim());
							objWeather.put("icon", getTagValue("weatherIconUrl", eElement).trim());
							objWeather.put("condition", getTagValue("weatherDesc", eElement).trim());
							view.addObject("weather", objWeather);
					   }
					}
				}
			}
			catch(Exception e){
				view.addObject("weather", null);
			}
			
        }
        else
        {
        	String msg = getMessageSourceAccessor().getMessage("errors.noCity", request.getLocale()); //$NON-NLS-1$
        	view.addObject("successMessages", new String[] { msg });//$NON-NLS-1$
        }
        
        return view;
    }
  
	private List<MatchCategory> getVariousMatchCategories(City city) {
		return this.matchCategoryManager.getMatchCategoryForCity(city.getId());
	}

	private String getTagValue(String sTag, Element eElement)
	{
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	}
 
	private List<Season> getOpenSeasons(City city)
    {
        return this.seasonManager.getOpenSeasonsForCity(city.getId());
    }
    
    private Season getStandingsSeason(HttpServletRequest request, List<Season> openSeasons)
    {
        String s = request.getParameter("division"); //$NON-NLS-1$
        if ((null != s) && (s.length() > 0))
        {
            try
            {
                Long id = Long.valueOf(s);
                for (Season testSeason : openSeasons)
                {
                    if (testSeason.getId().equals(id))
                    {
                        return testSeason;
                    }
                }
            }
            catch (NumberFormatException e)
            {
                // Just ignore this and return the first season below
            }
        }

        if (openSeasons.size() > 0) return openSeasons.get(0);
        return null;
    }
    
    private SeasonResult[] getStandings(Season season)
    {
    	if (season != null) {
    		return SeasonInfo.getSortedSeasonResults(this.seasonManager, season.getId());
    	}
    	return null;
    }
    
    private String getTickerMessages(City city)
    {
    	if (null == city)
    	{
    		return ""; //$NON-NLS-1$
    	}

    	List<TickerMessage> msgs = this.tickerMessageManager.getTickerMessagesForCity(city.getId());
    	StringBuilder sb = new StringBuilder();
    	for (TickerMessage msg: msgs)
    	{
    		sb.append(msg.getMessage());
    		sb.append("&nbsp;&nbsp;&nbsp;"); //$NON-NLS-1$
    	}
    	return sb.toString();
    }
    
    private String getMessageId(PublicMessage msg)
    {
    	String messageId = "";
    	Long msgId = 0L;
    	msgId = msg.getId();
    	messageId = msgId.toString();
    	return messageId;
    }
    
    private String getPlayoffCountdown(Season season)
    {
    	if (null == season)
    		return null;
    	
    	Date date = season.getCity().getCountDownDate();
    	int weeks = getWeeksInSeason(season.getMatches());
    	date = new Date(date.getTime() + (long)weeks * 7L * DateUtil.MS_IN_DAY);
    	return Integer.toString(DateUtil.computeDaysToDate(date));
    }
    
    private int getWeeksInSeason(SortedSet<Match> matches)
    {
    	// TODO: this should not be hard coded.  We probably need to have it in the season.
    	return 4;
    }
    
    private int getSeasonStarted(Season currentSeason)
    {
    	int seasonStarted = 0;
    	if(currentSeason != null)
    	{
    		try{
    			seasonStarted = currentSeason.getState();
    		}
    		catch(Exception exp){
    			seasonStarted = Integer.valueOf(0);
    		}
    	}
    	return seasonStarted;
    }
    
    private void sortList(List<Season> seasons)
    {
    	Collections.sort(seasons, new Comparator<Season>()
        {
            public int compare(Season season1, Season season2)
            {
                if (season1.getId().longValue() > season2.getId().longValue())
                {
                    return -1;
                }
                return 1;
            }
        });
    }
}
