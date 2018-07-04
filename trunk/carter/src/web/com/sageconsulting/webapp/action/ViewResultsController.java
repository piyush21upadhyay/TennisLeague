/*
 * ViewResultsController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

import com.sageconsulting.model.Match;
import com.sageconsulting.model.MatchScore;
import com.sageconsulting.service.MatchManager;

public class ViewResultsController implements Controller
{
    private static final Log log = LogFactory.getLog(ViewResultsController.class);
    
    private static final String CMD_NAME = "match"; //$NON-NLS-1$
    
    private MatchManager matchManager;
    
    public void setMatchManager(MatchManager mgr)
    {
        this.matchManager = mgr;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView view = new ModelAndView();
        Match match = getMatch(request);
        if (null == match)
        {
        	return new ModelAndView(new RedirectView("schedule.html")); //$NON-NLS-1$
        }
        view.addObject(CMD_NAME, match);
        
        return view;
    }
    
    private Long getMatchId(HttpServletRequest request)
    {
        Long id = null;
        String strMatchId = request.getParameter("id"); //$NON-NLS-1$
        if (null != strMatchId)
        {
            try
            {
                id = Long.valueOf(strMatchId);
            }
            catch (NumberFormatException e)
            {
                log.warn("Invalid match id specified: "+strMatchId); //$NON-NLS-1$
            }
        }
        return id;
    }
    
    private Match getMatch(HttpServletRequest request)
    {
        Match match = null;
        Long matchId = getMatchId(request);
        if (null != matchId)
        {
            match =  this.matchManager.getMatch(matchId);
            if (null == match.getPlayed())
            {
                return null;
            }
            
            // If golfer1 wasn't the winner, create a temporary match that
            // reverses the golfers and the scores so we always show the
            // winner on top and the match with a positive final score.
            if (needsReverse(match))
            {
                match = reverse(match);
            }
        }
        return match;
    }
    
    private boolean needsReverse(Match match)
    {
        if (match.isDefaultWin())
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
