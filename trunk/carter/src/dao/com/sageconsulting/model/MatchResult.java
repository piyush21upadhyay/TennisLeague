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
        Byte[] netScores = this.match.getScore().getNet();
        if (!anyHoleScores(netScores))
        {
            this.isPlayed = false;
            return;
        }
        
        int i = 17;
        while (null == netScores[i])
        {
            i--;
        }
        
        if (netScores[i].intValue() == 0)
        {
            this.isTie = true;
            if (null != this.match.getPuttoffWinner())
            {
                this.winner = this.match.getPuttoffWinner();
                this.loser = (this.match.getPuttoffWinner().equals(this.match.getGolfer1())) ?
                    this.match.getGolfer2() : this.match.getGolfer1();
                
            }
            return;
        }
        else if (netScores[i].intValue() > 0)
        {
            this.winner = this.match.getGolfer1();
            this.loser = this.match.getGolfer2();
            this.holesWon = netScores[i].intValue();
            this.holesRemaining = 17 - i;
        }
        else if (netScores[i].intValue() < 0)
        {
            this.winner = this.match.getGolfer2();
            this.loser = this.match.getGolfer1();
            this.holesWon = netScores[i].intValue() * -1;
            this.holesRemaining = 17 - i;
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
