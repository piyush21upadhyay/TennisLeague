/*
 * UserStatsUtil.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sageconsulting.model.Match;
import com.sageconsulting.model.User;
import com.sageconsulting.service.UserExistsException;
import com.sageconsulting.service.UserManager;

public class UserStatsUtil
{
    private static final Log log = LogFactory.getLog(UserStatsUtil.class);
    
    private UserStatsUtil()
    {
        // Nothing to do.
    }
    
    /**
     * Update the users won/loss/tie info for the passed in match.
     * @param match The match that was just played.
     */
    public static void updateUserStats(UserManager userManager, Match match)
    {
        User user1;
        User user2;
        if (match.isDefaultWin())
        {
            user1 = match.getDefaultWinner();
            user2 = getDefaultLoser(match);
            updateWins(user1);
            updateLosses(user2);
        }
        else
        {
            user1 = match.getResult().getWinner();
            user2 = match.getResult().getLoser();
            if (match.getResult().isTie())
            {
                user1 = match.getGolfer1();
                user2 = match.getGolfer2();
                updateTies(user1);
                updateTies(user2);
            }
            else
            {
                updateWins(user1);
                updateLosses(user2);
            }
            updateLowScore(user1, match);
            updateLowScore(user2, match);
        }
        
        saveUser(userManager, user1);
        saveUser(userManager, user2);
    }
    
    private static User getDefaultLoser(Match match)
    {
        if (match.getDefaultWinner().equals(match.getGolfer1()))
        {
            return match.getGolfer2();
        }
        return match.getGolfer1();
    }
    
    private static void updateTies(User user)
    {
        int ties = user.getCurrentTies().intValue() + 1;
        user.setCurrentTies(Integer.valueOf(ties));
        ties = user.getTotalTies().intValue() + 1;
        user.setTotalTies(Integer.valueOf(ties));
    }
    
    private static void updateWins(User user)
    {
        int wins = user.getCurrentWins().intValue() + 1;
        user.setCurrentWins(Integer.valueOf(wins));
        wins = user.getTotalWins().intValue() + 1;
        user.setTotalWins(Integer.valueOf(wins));
    }
    
    private static void updateLosses(User user)
    {
        int losses = user.getCurrentLosses().intValue() + 1;
        user.setCurrentLosses(Integer.valueOf(losses));
        losses = user.getTotalLosses().intValue() + 1;
        user.setTotalLosses(Integer.valueOf(losses));
    }
    
    private static void updateLowScore(User user, Match match)
    {
        if (null == user)
        {
            return;
        }
        
        if (match.getGolfer1().equals(user))
        {
            updateLowScore(user, match.getScore().getPlayer1Scores());
        }
        else if (match.getGolfer2().equals(user))
        {
            updateLowScore(user, match.getScore().getPlayer2Scores());
        }
    }
    
    private static void updateLowScore(User user, Byte[] scores)
    {
        int score = 0;
        for (int i=0; i<scores.length; i++)
        {
            // If user didn't finish the round, then don't update their low score.
            if (scores[i].intValue() < 1)
            {
                return;
            }
            score += scores[i].intValue();
        }
        if ((null == user.getLowScore()) || (user.getLowScore().intValue() > score))
        {
            user.setLowScore(Integer.valueOf(score));
        }
    }
    
    private static void saveUser(UserManager userManager, User user)
    {
        if (null == user)
        {
            return;
        }
        
        try
        {
            userManager.saveUser(user);
        }
        catch (UserExistsException e)
        {
            // This should never happen since we are just updating.
            log.error("Error during stats updating.", e); //$NON-NLS-1$
        }
    }
}
