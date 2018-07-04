/*
 * BracketUtility.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.util;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

import com.sageconsulting.model.BracketEntry;
import com.sageconsulting.model.Match;
import com.sageconsulting.model.Season;
import com.sageconsulting.model.User;

/**
 * This class has some useful functions for creating tournament brackets.
 */
public class BracketUtility
{
    private static final int[] FOUR_PLAYER = { 0, 3, 2, 1 };
    private static final int[] EIGHT_PLAYER = { 0, 7, 3, 4, 2, 5, 1, 6 };
    private static final int[] SIXTEEN_PLAYER = { 0, 15, 7, 8, 4, 11, 3, 12, 5, 10, 2, 13, 6, 9, 1, 14 };
    
    /**
     * This method generates the bracket and returns the first round.
     * @param competitors The total number of competitors in the first round.
     * @param firstRoundStart The date that the first round will start.  The first
     * round will end 1 week beyond that and each subsequent round will end a week
     * later than the round before it.
     * @param regularSeasonMatchCount The number of matches that were played in the regular season.
     * @return The first round of {@param BracketEntry} objects that were
     * generated.  The rest of the rounds must be traversed to using
     * {@link BracketEntry#getNext()}.
     */
    public static List<BracketEntry> generateBracket(Season season, Calendar firstRoundStart, int regularSeasonMatchCount)
    {
        // First make sure nCompetitors is a power of two and is at least 4
        int competitors = season.getPostSeasonQualifyingCount().intValue();
        if (((competitors & (competitors-1)) != 0) || (competitors < 4))
        {
            throw new IllegalArgumentException("Invalid number of competitors: "+competitors); //$NON-NLS-1$
        }
        
        // Create the first entry which will be for the winner of the bracket.  Then
        // we work backwards to build out the tree that represents the bracket.
        int nRound = getRoundCount(competitors/2);
        Calendar championshipDate = computePlayDate(firstRoundStart, nRound);
        BracketEntry winner = new BracketEntry();
        winner.setMatchNumber(Integer.valueOf(0));
        winner.setRound(Integer.valueOf(0));
        winner.setSeasonId(season.getId());
        winner.setNext(winner);
        winner.getMatch().setRound(Integer.valueOf(regularSeasonMatchCount+nRound+1));
        winner.getMatch().setPlayBy(championshipDate.getTime());
        winner.getMatch().setBracketEntry(winner);

        BracketEntry lastMatch = new BracketEntry();
        lastMatch.setMatchNumber(Integer.valueOf(0));
        lastMatch.setRound(Integer.valueOf(nRound));
        lastMatch.setSeasonId(season.getId());
        lastMatch.setNext(winner);
        lastMatch.getMatch().setRound(Integer.valueOf(regularSeasonMatchCount+nRound));
        lastMatch.getMatch().setPlayBy(championshipDate.getTime());
        lastMatch.getMatch().setBracketEntry(lastMatch);
        
        //Calendar currentRoundEnd = (Calendar)firstRoundStart.clone();
        //currentRoundEnd.add(Calendar.DAY_OF_YEAR, 7);
        BracketEntry[] previousRound = new BracketEntry[] { lastMatch };
        int nMatches = 2;
        while (nMatches*2 <= competitors)
        {
            nRound--;
            Calendar playDate = computePlayDate(firstRoundStart, nRound);
            BracketEntry[] thisRound = new BracketEntry[nMatches];
            for (int i=0; i<nMatches; i++)
            {
                thisRound[i] = new BracketEntry();
                thisRound[i].setNext(previousRound[i/2]);
                thisRound[i].setMatchNumber(Integer.valueOf(i));
                thisRound[i].setSeasonId(season.getId());
                thisRound[i].setRound(Integer.valueOf(nRound));
                thisRound[i].getMatch().setRound(Integer.valueOf(regularSeasonMatchCount+nRound));
                thisRound[i].getMatch().setPlayBy(playDate.getTime());
                thisRound[i].getMatch().setBracketEntry(thisRound[i]);
            }
            nMatches <<= 1;
            previousRound = thisRound;
        }
        
        return Arrays.asList(previousRound);
    }
    
    private static Calendar computePlayDate(Calendar startDate, int round)
    {
        Calendar playDate = (Calendar)startDate.clone();
        playDate.add(Calendar.DAY_OF_YEAR, (round-1)*7);
        return playDate;
    }
    
    public static void saveBracket(List<BracketEntry> bracket)
    {
        StringBuilder sb = new StringBuilder();
        
        int nRounds = getRoundCount(bracket.size());
        for (int i=nRounds-1; i>=0; i--)
        {
            int traverse = 1 << i;
            for (BracketEntry b : bracket)
            {
                if ((b.getMatchNumber().intValue() % traverse) == 0)
                {
                    BracketEntry bPrint = b;
                    for (int j=0; j<i; j++)
                    {
                        bPrint = bPrint.getNext();
                        sb.append("    "); //$NON-NLS-1$
                    }
                    sb.append(bPrint.getRound()).append("\r\n"); //$NON-NLS-1$
                }
            }
        }

        System.out.println(sb.toString());
    }
    
    public static String toString(List<BracketEntry> bracket)
    {
        StringBuilder sb = new StringBuilder();
        
        int nRounds = getRoundCount(bracket.size());
        for (int i=0; i<nRounds; i++)
        {
            int traverse = 1 << i;
            for (BracketEntry b : bracket)
            {
                if ((b.getMatchNumber().intValue() % traverse) == 0)
                {
                    BracketEntry bPrint = b;
                    for (int j=0; j<i; j++)
                    {
                        bPrint = bPrint.getNext();
                        sb.append("    "); //$NON-NLS-1$
                    }
                    sb.append(toString(bPrint)).append("\r\n"); //$NON-NLS-1$
                }
            }
        }

        return sb.toString();
    }
    
    private static String toString(BracketEntry entry)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("bracket entry: "); //$NON-NLS-1$
        Match match = entry.getMatch();
        if (null == match)
        {
            sb.append("no match"); //$NON-NLS-1$
        }
        else
        {
            sb.append((null != match.getGolfer1()) ? match.getGolfer1().getFullName() : "no golfer1"); //$NON-NLS-1$
            sb.append(" vs "); //$NON-NLS-1$
            sb.append((null != match.getGolfer2()) ? match.getGolfer2().getFullName() : "no golfer2"); //$NON-NLS-1$
            DateFormat fmt = DateFormat.getDateInstance();
            sb.append("  play by: ").append(fmt.format(match.getPlayBy())); //$NON-NLS-1$
            sb.append("  (").append(match.getId()).append(")"); //$NON-NLS-1$ //$NON-NLS-2$
            sb.append("  [").append(entry.getMatchNumber()).append("]"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        return sb.toString();
    }
    
    public static int getRoundCount(int firstRoundMatches)
    {
        int count = 0, matches = firstRoundMatches;
        while (matches > 0)
        {
            count++;
            matches >>=1;
        }
        return count;
    }
    
    public static void fillBracket(List<BracketEntry> bracket, SeasonResult[] results)
    {
        if (bracket.size() == 2)
        {
            fillBracket(bracket, results, FOUR_PLAYER);
        }
        else if (bracket.size() == 4)
        {
            fillBracket(bracket, results, EIGHT_PLAYER);
        }
        else if (bracket.size() == 8)
        {
            fillBracket(bracket, results, SIXTEEN_PLAYER);
        }
        else if (bracket.size() >= 16)
        {
            int splits = bracket.size()/8;
            SeasonResult[][]splitResults = splitResults(results, splits);
            for (int i=0; i<splits; i++)
            {
                List<BracketEntry> subBracket = bracket.subList(i*8, i*8+8);
                fillBracket(subBracket, splitResults[i], SIXTEEN_PLAYER);
            }
        }
    }
    
    private static void fillBracket(List<BracketEntry> bracket, SeasonResult[] results, int[] order)
    {
        sortResults(results);
        for (int i=0; i<order.length; i++)
        {
            int bracketIndex = i/2;
            int golferIndex = i%2;
            BracketEntry entry = bracket.get(bracketIndex);
            int idx = order[i];
            if (idx < results.length)
            {
	            User golfer = results[order[i]].getUser();
	            if (golferIndex == 0)
	            {
	                entry.getMatch().setGolfer1(golfer);
	            }
	            else
	            {
	                entry.getMatch().setGolfer2(golfer);
	            }
            }
        }
    }
    
    private static void sortResults(SeasonResult[] results)
    {
        Arrays.sort(results, new Comparator<SeasonResult>()
        {
        	public int compare(SeasonResult result1, SeasonResult result2)
            {
                if (result1.getPoints() == result2.getPoints())
                {
                	if(result1.getWins() == result2.getWins())
                	{
                		if(result1.getLosses() == result2.getLosses())
                		{
                			if(result1.getTies() == result2.getTies())
                			{
                				/*if(result1.getUser().getHandicap() == result2.getUser().getHandicap())
                            		return 0;
                            	else if(result1.getUser().getHandicap() > result2.getUser().getHandicap())
                        			return 1;*/
                            	
                            	return -1;
                			}
                			else if(result1.getTies() > result2.getTies())
                    			return 1;
                    		return -1;
                		}
                		else if(result1.getLosses() > result2.getLosses())
                			return 1;
                		return -1;
                	}
                	else if(result1.getWins() < result2.getWins())
                		return 1;
                	return -1;
                }
                else if (result1.getPoints() < result2.getPoints())
                {
                    return 1;
                }
                return -1;
            }
        });
    }
    
//    private static Object[] splitBracket(List<BracketEntry> bracket, int count)
//    {
//        List<List<BracketEntry>> brackets = new ArrayList<List<BracketEntry>>(count);
//        int index = 0;
//        int dir = 1;
//        for (int i=0; i<bracket.size(); i++)
//        {
//            if (null == brackets.get(index))
//            {
//                brackets.add(new ArrayList<BracketEntry>(8));
//            }
//            brackets.get(index).add(bracket.get(i));
//            index += dir;
//            if (index >= count)
//            {
//                dir *= -1;
//                index += 2*dir;
//            }
//        }
//        return brackets.toArray();
//    }
    
    private static SeasonResult[][] splitResults(SeasonResult results[], int count)
    {
        SeasonResult splitResults[][] = new SeasonResult[count][16];
        boolean forward = true;
        int index = 0;
        for (int i=0; i<results.length; i+=count)
        {
            if (forward)
            {
                for (int j=0; j<count; j++)
                {
                    int k = i+j;
                    splitResults[j][index] = results[k];
                }
            }
            else
            {
                for (int j=0; j<count; j++)
                {
                    int k = i+count-j-1;
                    splitResults[j][index] = results[k];
                }
            }
            forward = !forward;
            index++;
        }
        
        return splitResults;
    }
    
    /**
     * Return the champion from the bracket if there is one.  If the bracket is not
     * played out yet then return null.
     * @param bracket The bracket to get the champion for.
     * @return The champion from the bracket or null if there is no champion.
     */
    public static User getChampion(List<BracketEntry> bracket)
    {
        if ((null == bracket) || (bracket.size() < 1))
        {
            return null;
        }
        
        BracketEntry bracketEntry = bracket.get(0);
        while (null != bracketEntry)
        {
            // If the current bracket entry doesn't have a result then there is no champion
            if (!bracketEntry.getMatch().getResult().isPlayed())
            {
                return null;
            }
            
            // If the next bracket entry is null then we are at the end of the bracket so
            // if there is a winner then return it.
            BracketEntry nextEntry = bracketEntry.getNext();
            if (null == nextEntry)
            {
                return bracketEntry.getMatch().getResult().getWinner();
            }
            
            // We aren't at the end of the bracket so go to the next match.
            bracketEntry = nextEntry;
        }
        
        return null;
    }
}
