/*
 * RecordController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.GrantedAuthority;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

import com.sageconsulting.model.Match;
import com.sageconsulting.model.MatchScore;
import com.sageconsulting.model.Season;
import com.sageconsulting.model.User;
import com.sageconsulting.service.MatchManager;
import com.sageconsulting.service.UserManager;

public class RecordController implements Controller
{
    //private static final Log log = LogFactory.getLog(RecordController.class);
    
    private UserManager userManager;
    private MatchManager matchManager;
    
    public void setUserManager(UserManager mgr)
    {
        this.userManager = mgr;
    }
    
    public void setMatchManager(MatchManager mgr)
    {
        this.matchManager = mgr;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView view = new ModelAndView();
        
        // If there is no user specified then just go to the profile page
        User user = getUser(request);
        if (null == user)
        {
        	return new ModelAndView(new RedirectView("profile.html")); //$NON-NLS-1$
        }
        view.addObject("user", user); //$NON-NLS-1$
        
        String showOverall = request.getParameter("func");
        
        if( (showOverall != null) && (showOverall.equals("all")) )
        {
        	// show overall matches for user.
        	List<Match> matches = new ArrayList<Match>();
        	List<Match> allMatches = this.matchManager.getMatchesForGolfer(user.getId());
            for (Match match : allMatches)
            {
            	if (user.equals(match.getGolfer1()) || user.equals(match.getGolfer2()))
	            {
	            	if ((null != match.getPlayed()) || match.isBye())
	                {
                		if (needsReverse(match))
                			matches.add(reverse(match));
                        else
                        	matches.add(match);
                	}
                }
            }
            view.addObject("matches", matches);
        }
        else
        	view.addObject("matches", getMatches(user));

        if((request.getRemoteUser() != null) && checkAdminAuth(request.getRemoteUser()))
        	view.addObject("isAdministrator", true);
        return view;
    }
    
    /**
     * Return true if the an administrator is editing a user's score
     * @param userName The current user name.
     * @return true if an administrator is editing a user and false if a user is
     * editing his/her own score.
     */
    private boolean checkAdminAuth(String userName)
    {
    	boolean isAdministrator = false;
    	User currentUser = this.userManager.getUserByUsername(userName);
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
    
    private List<Match> getMatches(User user)
    {
        if ((null == user) || (null == user.getCurrentSeason())
        		|| ((user.getCurrentSeason() != null) && (user.getCurrentSeason().getState().intValue() == Season.STATE_CLEAR) ))
        {
            return null;
        }
        
        Season season = user.getCurrentSeason();
        List<Match> matches = new ArrayList<Match>();
        ArrayList<Long> seasonMatch = new ArrayList<Long>();
        
        // get list of all regular season matches this season.
        for (Match match : season.getMatches())
        {
            if (user.equals(match.getGolfer1()) || user.equals(match.getGolfer2()))
            {
                if ((null != match.getPlayed()) || match.isBye())
                {
                	seasonMatch.add(match.getId());
                    if (needsReverse(match))
                    {
                        matches.add(reverse(match));
                    }
                    else
                    {
                        matches.add(match);
                    }
                }
            }
        }
        
        // get list of all playoff matches this season.
        List<Match> allMatches = this.matchManager.getMatchesForGolfer(user.getId());
        for (Match match : allMatches)
        {
        	if(match.getBracketEntry() != null)
    		{
        		if(!seasonMatch.contains(match.getId()))	// this condition may need to be removed...
        		{
        			if (match.getBracketEntry().getSeasonId().longValue() == user.getCurrentSeason().getId().longValue())
        			{
        				if ((null != match.getPlayed()) || match.isBye())
    	                {
                    		if (needsReverse(match))
                    			matches.add(reverse(match));
                            else
                            	matches.add(match);
                    	}
                        
        			}
        		}
    		}
        }
        
        return matches;
    }
    
    private User getUser(HttpServletRequest request)
    {
        User user = null;
        String idParam = request.getParameter("id"); //$NON-NLS-1$
        if (null != idParam)
        {
            try
            {
                user = this.userManager.getUser(idParam);
            }
            catch (NumberFormatException e)
            {
                // Ignore this and continue below to get current user.
            }
        }
        
        if (null == user && (request.getRemoteUser() != null))
        {
            user = this.userManager.getUserByUsername(request.getRemoteUser());
        }
        
        return user;
    }
    
    private boolean needsReverse(Match match)
    {
        if (match.isDefaultWin())
        {
            return false;
        }
        if (match.isBye() && (null == match.getGolfer1()))
        {
            return true;
        }
        if (match.isBye() && (null == match.getGolfer2()))
        {
            return false;
        }
        if ((null != match.getResult()) && !(match.getGolfer1().equals(match.getResult().getWinner())))
        {
            return true;
        }
        return false;
    }
    
    private Match reverse(Match match)
    {
        Match newMatch = new Match();
        newMatch.setGolfer1(match.getGolfer2());
        newMatch.setGolfer2(match.getGolfer1());
        newMatch.setCourse(match.getCourse());
        newMatch.setRound(match.getRound());
        newMatch.setPlayed(match.getPlayed());
        MatchScore score = new MatchScore();
        score.setGolfer1Handicap(match.getScore().getGolfer2Handicap());
        score.setGolfer2Handicap(match.getScore().getGolfer1Handicap());
        score.setPlayer1Pars(match.getScore().getPlayer2Pars());
        score.setPlayer1Strokes(match.getScore().getPlayer2Strokes());
        score.setPlayer1Scores(match.getScore().getPlayer2Scores());
        score.setPlayer2Pars(match.getScore().getPlayer1Pars());
        score.setPlayer2Strokes(match.getScore().getPlayer1Strokes());
        score.setPlayer2Scores(match.getScore().getPlayer1Scores());
        score.setScores1(match.getScore().getScores2());
        score.setScores2(match.getScore().getScores1());
        score.setStrokes(match.getScore().getStrokes());
        Byte[] oldScore = match.getScore().getNet();
        for (int i=0; i<18; i++)
        {
            if (null != oldScore[i])
            {
                Byte newVal = Byte.valueOf((byte)(oldScore[i].byteValue()*-1));
                score.setScore(i, newVal);
            }
            else
            {
                score.setScore(i, null);
            }
        }
        newMatch.setScore(score);
        newMatch.getResult();
        
        //Set match Id
        newMatch.setId(match.getId());
        
        //Set puttoff winner
        newMatch.setPuttoffWinner(match.getPuttoffWinner());
        
        return newMatch;
    }
}
