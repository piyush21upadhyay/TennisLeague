/*
 * BracketManagerImpl.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service.impl;

import java.util.List;

import com.sageconsulting.dao.BracketEntryDao;
import com.sageconsulting.model.BracketEntry;
import com.sageconsulting.model.Match;
import com.sageconsulting.service.BracketManager;

public class BracketManagerImpl extends BaseManager implements BracketManager
{
    public void setBracketEntryDao(BracketEntryDao bdao)
    {
        super.setDao(bdao);
    }
    
    private BracketEntryDao getBracketEntryDao()
    {
        return (BracketEntryDao)super.dao;
    }

    public BracketEntry getBracketEntry(Long id)
    {
        return getBracketEntryDao().getBracketEntry(id);
    }

    public List<BracketEntry> getRoundOneBracketForSeason(Long seasonId)
    {
        return getBracketEntryDao().getRoundOneBracketForSeason(seasonId);
    }

    public void saveBracket(List<BracketEntry> bracket)
    {
        getBracketEntryDao().saveBracket(bracket);
    }

    public void saveBracketEntry(BracketEntry entry)
    {
        getBracketEntryDao().saveBracketEntry(entry);
    }
    
    public  List<BracketEntry> getRound(Match match)
    {
    	 return getBracketEntryDao().getRound(match);
    }

    public List<BracketEntry> getRound(Long seasonId)
    {
    	return getBracketEntryDao().getRound(seasonId);
    }
}
