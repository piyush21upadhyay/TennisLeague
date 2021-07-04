/*
 * MatchDaoHibernate.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao.hibernate;

import java.util.Date;
import java.util.List;

import com.sageconsulting.dao.MatchDao;
import com.sageconsulting.model.Match;

public class MatchDaoHibernate extends BaseDaoHibernate implements MatchDao
{

    public Match getMatch(Long id)
    {
        return (Match) getHibernateTemplate().get(Match.class, id);
    }

    public void saveMatch(Match match)
    {
    	getHibernateTemplate().clear();
        getHibernateTemplate().saveOrUpdate(match);
        // necessary to throw a DataIntegrityViolation
        getHibernateTemplate().flush();
    }

    @SuppressWarnings("unchecked")
    public List<Match> getMatchesForGolfer(Long golferid)
    {
        return getHibernateTemplate().find("from Match m where m.golfer1.id=? or m.golfer2.id=? order by m.playBy", //$NON-NLS-1$
            new Object[] { golferid, golferid });
    }
    
    @SuppressWarnings("unchecked")
    public List<Match> getMatchesForGolferAndSeason(Long golferid, Long seasonid)
    {
        return getHibernateTemplate().find("select m from Season s left join s.matches m where (s.id=?) and (m.golfer1.id=? or m.golfer2.id=?) order by m.playBy", //$NON-NLS-1$
        		new Object[] { seasonid, golferid, golferid });
    }
    
    @SuppressWarnings("unchecked")
    public List<Match> getUnderParLeaders(boolean player1, boolean gross, int count, Date start, Date end)
    {
        getHibernateTemplate().setMaxResults(count);
        String playerScore = getPlayerScore(player1, gross);
        StringBuilder sb = new StringBuilder("from Match m where m.score is not empty and "); //$NON-NLS-1$
        sb.append(playerScore);
        sb.append(" > 0 and "); //$NON-NLS-1$
        sb.append("m.playBy > ? and m.playBy <= ?"); //$NON-NLS-1$
        sb.append(" order by "); //$NON-NLS-1$
        sb.append(playerScore);
        sb.append(" desc"); //$NON-NLS-1$
        List<Match> matches = getHibernateTemplate().find(sb.toString(), new Object[] { start, end });
        getHibernateTemplate().setMaxResults(0);
        return matches;
    }
    
    private String getPlayerScore(boolean player1, boolean gross)
    {
        StringBuilder sb = new StringBuilder("m.score."); //$NON-NLS-1$
        if (player1)
        {
            sb.append("player1UnderPar"); //$NON-NLS-1$
        }
        else
        {
            sb.append("player2UnderPar"); //$NON-NLS-1$
        }
        if (gross)
        {
            sb.append("Gross"); //$NON-NLS-1$
        }
        else
        {
            sb.append("Net"); //$NON-NLS-1$
        }
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
	public List<Match> getByeMatch(Date mon,Date sun)
    {
       	StringBuilder sb = new StringBuilder("from Match m where ((m.golfer1 is not empty and m.golfer2 is empty) or (m.golfer1 is  empty and m.golfer2 is not empty)) and playBy>=? and playBy<?"); //$NON-NLS-1$
        List<Match> matches = getHibernateTemplate().find(sb.toString(), new Object[] { mon, sun });
        return matches;
    }

	@Override
	public Match getMatchById(Long id) {
		Match match = (Match) getHibernateTemplate().get(Match.class, id);
        getHibernateTemplate().refresh(match);
        return match;
	}
}
