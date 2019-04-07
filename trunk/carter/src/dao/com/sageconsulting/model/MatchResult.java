/*
 * MatchResult.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.model;

/**
 * This is a simple class that can be used to retrieve a match result.
 * It specifies the winner and the score of the match.
 *
 */
public class MatchResult
{
    private Match match;
    private boolean isPlayed = true;
    private boolean isTie = false;
    private User winner;
    private User loser;
    private int holesWon;
    private int holesRemaining;
       
    public MatchResult(Match m)
    {
        this.match = m;
        if (m.getGolfer1() == null || m.getGolfer2() == null)
        {
        	this.isPlayed = false;
        	this.winner = m.getGolfer1() != null ? m.getGolfer1() : m.getGolfer2();
        } else {
        	computeResults();
        }
    }
       
    private void computeResults()
    {
    	
    	if(match.isOpponentRetiredWin())
    	{
    		if(this.match.getGolfer1().getId().equals(match.getScore().getOpponentRetired()))
    		{
    			this.winner = this.match.getGolfer2();
                this.loser = this.match.getGolfer1();
                return;
    		}
    		else if(this.match.getGolfer2().getId().equals(match.getScore().getOpponentRetired()))
    		{
    			this.winner = this.match.getGolfer1();
                this.loser = this.match.getGolfer2();
                return;
    		}
    	}
    	else if(match.isDefaultWin())
    	{
    		if(match.getGolfer1().getId().equals(match.getDefaultWinner().getId()))
    		{
    			this.winner = this.match.getGolfer1();
                this.loser = this.match.getGolfer2();
                return;
    		}
    		else if(match.getGolfer2().getId().equals(match.getDefaultWinner().getId()))
    		{
    			this.winner = this.match.getGolfer2();
                this.loser = this.match.getGolfer1();
                return;
    		}
    	}
     
    	int player1SetWinCount = 0;
    	int player2SetWinCount = 0;
    	
    	
    	int player1set1 = this.match.getScore().getPlayer1set1();
    	int player2set1 = this.match.getScore().getPlayer2set1();
    	
    	if(player1set1 > player2set1)
    	{
    		player1SetWinCount++;
    	}
    	else
    	{
    		player2SetWinCount++;
    	}
    	
    	int player1set2 = this.match.getScore().getPlayer1set2();
    	int player2set2 = this.match.getScore().getPlayer2set2();
    	
    	if(player1set2 > player2set2)
    	{
    		player1SetWinCount++;
    	}
    	else
    	{
    		player2SetWinCount++;
    	}
    	
    	int player1set3 = this.match.getScore().getPlayer1set3();
    	int player2set3 = this.match.getScore().getPlayer2set3();
    	
    	if(player1set3 > player2set3)
    	{
    		player1SetWinCount++;
    	}
    	else
    	{
    		player2SetWinCount++;
    	}
    	
    	if(player1SetWinCount > player2SetWinCount)
    	{
    		this.winner = this.match.getGolfer1();
            this.loser = this.match.getGolfer2();
    	}
    	else
    	{
    		this.winner = this.match.getGolfer2();
            this.loser = this.match.getGolfer1();
    	}
    	
    }
    
    public boolean isPlayed() { return this.isPlayed; }
    
    public boolean isTie() { return this.isTie; }
    
    public User getWinner() { return this.winner; }
    
    public User getLoser() { return this.loser; }
    
    public int getHolesWon() { return this.holesWon; }
    
    public int getHolesRemaining() { return this.holesRemaining; }
    
    private boolean anyHoleScores(Byte[] scores)
    {
        for (Byte b : scores)
        {
            if (null != b)
            {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        
        if (!isPlayed())
        {
            sb.append("Match has not been played"); //$NON-NLS-1$
        }
        else if (isTie())
        {
            if (null == this.winner)
            {
                sb.append("Match was a draw"); //$NON-NLS-1$
            }
            else
            {
                sb.append(this.winner.getFullName());
                sb.append(' ');
                sb.append("wins in a putt off"); //$NON-NLS-1$
            }
        }
        else
        {
            sb.append(getWinner().getFullName()).append(" wins "); //$NON-NLS-1$
            sb.append(getHolesWon()).append(" & ").append(getHolesRemaining()); //$NON-NLS-1$
        }
        return sb.toString();
    }
}
