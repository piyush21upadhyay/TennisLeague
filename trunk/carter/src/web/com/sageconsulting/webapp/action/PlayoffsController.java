/*
 * PlayoffsController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.sageconsulting.model.BracketEntry;
import com.sageconsulting.model.Match;
import com.sageconsulting.model.Season;
import com.sageconsulting.service.BracketManager;
import com.sageconsulting.util.BracketUtility;

public class PlayoffsController extends BaseSeasonResultController
{
	private static final String CMD_NAME = "season"; //$NON-NLS-1$
    
    private BracketManager bracketManager;
    
    public void setBracketManager(BracketManager mgr)
    {
        this.bracketManager = mgr;
    }
    
    public PlayoffsController()
    {
        setCommandName(CMD_NAME);
        setCommandClass(Object.class);
    }
        
    @Override
	protected void updateModelAndView(Season currentSeason, ModelAndView view)
    {
        if (null != currentSeason)
        {
        	List<BracketEntry> bracket = this.bracketManager.getRoundOneBracketForSeason(currentSeason.getId());
        	generateBracketValues(bracket, view);
        }
    }
    
    private void generateBracketValues(List<BracketEntry> bracket, ModelAndView view)
    {
    	this.log.debug(BracketUtility.toString(bracket));
    	
        int roundCount = BracketUtility.getRoundCount(bracket.size());
        for (int round=0; round<roundCount; round++)
        {
            int traverse = 1 << round;
            for (BracketEntry b : bracket)
            {
                if ((b.getMatchNumber().intValue() % traverse) == 0)
                {
                    BracketEntry resultEntry = b;
                    for (int j=0; j<round; j++)
                    {
                        resultEntry = resultEntry.getNext();
                    }
                    Match match = resultEntry.getMatch();
                    generateMatchValues(round+1, resultEntry.getMatchNumber().intValue()+1, match, view);
                }
            }
        }
        
        view.addObject("champion", getChampionName(bracket, roundCount)); //$NON-NLS-1$
    }
    
    private void generateMatchValues(int round, int matchNum, Match match, ModelAndView view)
    {
    	StringBuilder sb = new StringBuilder();
        sb.append("r").append((round)); //$NON-NLS-1$
        sb.append("m").append(matchNum); //$NON-NLS-1$
        sb.append("p"); //$NON-NLS-1$
        view.addObject(sb.toString()+"1", ((null == match.getGolfer1()) ? "" : match.getGolfer1().getDisplayName())); //$NON-NLS-1$ //$NON-NLS-2$
        view.addObject(sb.toString()+"2", ((null == match.getGolfer2()) ? "" : match.getGolfer2().getDisplayName())); //$NON-NLS-1$ //$NON-NLS-2$
        view.addObject(sb.toString()+"1id", ((null == match.getGolfer1()) ? "" : match.getGolfer1().getId())); //$NON-NLS-1$ //$NON-NLS-2$
        view.addObject(sb.toString()+"2id", ((null == match.getGolfer2()) ? "" : match.getGolfer2().getId())); //$NON-NLS-1$ //$NON-NLS-2$
    }
    
    private String getChampionName(List<BracketEntry> bracket, int rounds)
    {
    	BracketEntry entry = null;
    	
    	if(bracket.size() > 0)
    	{
    		entry = bracket.get(0);
        	for (int i=0; i<rounds; i++)
        	{
        		entry = entry.getNext();
        	}
     
        	if (null != entry.getMatch().getGolfer1())
        	{
        		return entry.getMatch().getGolfer1().getFullName();
        	}
    	}
    	
    	return ""; //$NON-NLS-1$
    }
}
