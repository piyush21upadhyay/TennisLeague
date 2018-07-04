/*
 * UnderParLeaderController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sageconsulting.model.UnderParLeader;
import com.sageconsulting.service.UnderParLeaderManager;

import com.sageconsulting.model.Match;
import com.sageconsulting.model.User;
import com.sageconsulting.service.MatchManager;

public class UnderParLeaderController implements Controller
{
    private static final Log log = LogFactory.getLog(UnderParLeaderController.class);
    
    private UnderParLeaderManager underParLeaderManager;
 
	private MatchManager matchManager;
 
    public void setUnderParLeaderManager(UnderParLeaderManager mgr)
    {
        this.underParLeaderManager = mgr;
    }

	public void setMatchManager(MatchManager mgr)
    {
        this.matchManager = mgr;
    }
	
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ModelAndView view = new ModelAndView();
        Set<Long> userIdSet = new HashSet<Long>();
        Long registrationId = getRegistrationId(request);
        if (null != registrationId)
        {
            List<UnderParLeader> leaders = this.underParLeaderManager.getUnderParLeaders(registrationId);
            List<UnderParLeader> allLeaders = new ArrayList<UnderParLeader>();

			for( UnderParLeader leader : leaders )
			{
				if( ! userIdSet.contains(leader.getUser().getId()) )
				{
					allLeaders.add(leader);
					userIdSet.add(leader.getUser().getId());
					updateBirdiePointWeek(leader); // Birdie ponts	
				}
			}

			view.addObject("leaders", allLeaders); //$NON-NLS-1$
		}
        
        return view;
    }
	
	private Long getRegistrationId(HttpServletRequest request)
    {
        Long id = null;
        String strId = request.getParameter("id"); //$NON-NLS-1$
        if (null != strId)
        {
            try
            {
                id = Long.valueOf(strId);
            }
            catch (NumberFormatException e)
            {
                log.error("Invalid registration id passed as paramter: "+strId); //$NON-NLS-1$
            }
        }
        return id;
    }
	
	private void updateBirdiePointWeek( UnderParLeader objLeader )
    {
    	if( null != objLeader.getUser().getCurrentSeason() )
    	{
			List<Match> matches = this.matchManager.getMatchesForGolferAndSeason(
									objLeader.getUser().getId(),
									objLeader.getUser().getCurrentSeason().getId()
								);

			HashMap<String, Integer> birdiePoints = new HashMap<String, Integer>();
			int curBirdieCount		= 0;
			int curEagleCount		= 0;
			int curDoubleEagleCount	= 0;
			int cntAfterScheduled	= 0;
			int cntOtherWeekCounts	= 0;

			for( int i = 0; i <matches.size(); i++ )
    		{
    			Match match	= matches.get(i);

    			if( null != match.getPlayed() && (!match.isDefaultWin()) )
    			{
    				birdiePoints = getAllBirdiePoints(match, objLeader.getUser());

    				for (String key : birdiePoints.keySet())
    				{
    					if(key.equals("birdieCount"))
    						curBirdieCount	= birdiePoints.get(key);
    					else if(key.equals("eagleCount"))
    						curEagleCount	= birdiePoints.get(key);
    					else if(key.equals("doubleEagleCount"))
    						curDoubleEagleCount	= birdiePoints.get(key);
    				}

					int cntAllBirdiePonts	= 1*curBirdieCount +  2*curEagleCount + 3*curDoubleEagleCount;
					Date startDate			= new Date(getWeekStart(match.getPlayBy()));
					
					if( (match.getPlayBy().compareTo(match.getPlayed()) >= 0) && (new Date().compareTo(startDate) >= 0) )
					{
						if( match.getRound() == 1 )
							objLeader.cntBirdieWeek1	= cntAllBirdiePonts;
						else if( match.getRound() == 2 )
							objLeader.cntBirdieWeek2	= cntAllBirdiePonts;
						else if( match.getRound() == 3 )
							objLeader.cntBirdieWeek3	= cntAllBirdiePonts;
						else if( match.getRound() == 4 )
							objLeader.cntBirdieWeek4	= cntAllBirdiePonts;
						else if( match.getRound() == 5 )
							objLeader.cntBirdieWeek5	= cntAllBirdiePonts;
						else if( match.getRound() == 6 )
							objLeader.cntBirdieWeek6	= cntAllBirdiePonts;
					}
					else if( match.getPlayBy().compareTo(match.getPlayed()) < 0 )
					{
						cntAfterScheduled				+= cntAllBirdiePonts;
					}
					else if(new Date().compareTo(startDate) < 0)
					{
						cntOtherWeekCounts				+= cntAllBirdiePonts;
					}
				}
    		}
			objLeader.totBirdiePoints	= objLeader.cntBirdieWeek1 + objLeader.cntBirdieWeek2
										+ objLeader.cntBirdieWeek3 + objLeader.cntBirdieWeek4
										+ objLeader.cntBirdieWeek5 + objLeader.cntBirdieWeek6
										+ cntAfterScheduled
										+ cntOtherWeekCounts;
    	}
    }
  
	private long getWeekStart(Date playBy)
	{
		long weekStart = playBy.getTime() - (86400000 * 6);
		return weekStart;
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
    	
    	if (match.getGolfer1().equals(user))
    	{
    		Byte[] player1Scores = match.getScore().getPlayer1Scores();
    		Byte[] player1Pars = match.getScore().getPlayer1Pars();
    		Byte[] player1Strokes = match.getScore().getPlayer1Strokes();
    		
    		for(int i=0; i<18; i++)
    		{
    			if( player1Scores[i].intValue() > 0 )
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
				if( player2Scores[i].intValue() > 0 )
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
    	}
    	
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
}
