/*
 * BracketEntryDaoHibernate.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao.hibernate;

import java.util.List;

import org.hibernate.exception.SQLGrammarException;
import org.springframework.orm.hibernate3.HibernateJdbcException;

import com.sageconsulting.dao.BracketEntryDao;
import com.sageconsulting.model.BracketEntry;
import com.sageconsulting.model.Match;
import com.sageconsulting.util.BracketUtility;

public class BracketEntryDaoHibernate extends BaseDaoHibernate implements BracketEntryDao
{

    public BracketEntry getBracketEntry(Long id)
    {
        return (BracketEntry)getHibernateTemplate().get(BracketEntry.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<BracketEntry> getRoundOneBracketForSeason(Long seasonId)
    {
        return getHibernateTemplate().find("from BracketEntry b where b.seasonId=? and b.round=? order by b.matchNumber", //$NON-NLS-1$
            new Object[] { seasonId, Integer.valueOf(1) });
    }
    
    public void saveBracket(List<BracketEntry> bracket)
    {
        // This traverses the tree of the bracket and saves each entry starting
        // at the last element of the bracket.
        int nRounds = BracketUtility.getRoundCount(bracket.size());
        for (int i=nRounds-1; i>=0; i--)
        {
            int traverse = 1 << i;
            for (BracketEntry currentEntry : bracket)
            {
                if ((currentEntry.getMatchNumber().intValue() % traverse) == 0)
                {
                    BracketEntry entryToSave = currentEntry;
                    for (int j=0; j<i; j++)
                    {
                        entryToSave = entryToSave.getNext();
                    }
                    saveBracketEntry(entryToSave);
                }
            }
        }
    }

    public void saveBracketEntry(BracketEntry entry)
    {
        try
        {
            getHibernateTemplate().saveOrUpdate(entry);
        }
        catch (HibernateJdbcException e)
        {
            System.out.println(((SQLGrammarException)e.getCause()).getSQL());
        }
    }
    
    @SuppressWarnings("unchecked")
	public  List<BracketEntry> getRound(Match match)
    {
    	return getHibernateTemplate().find("from BracketEntry b where b.match = ?",match);
    }
	
    @SuppressWarnings("unchecked")
	public List<BracketEntry> getRound(Long seasonId)
    {
    	return getHibernateTemplate().find("from BracketEntry b where b.seasonId=? and b.round=? order by b.matchNumber", //$NON-NLS-1$
                new Object[] { seasonId, Integer.valueOf(4) });
    }
}
