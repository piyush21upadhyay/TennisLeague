/*
 * SeasonDaoTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao;

import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

import com.sageconsulting.model.City;
import com.sageconsulting.model.Match;
import com.sageconsulting.model.Season;
import com.sageconsulting.model.User;

public class SeasonDaoTest extends BaseDaoTestCase
{
    private UserDao userDao;
    private SeasonDao seasonDao;
    
    public void setUserDao(UserDao dao)
    {
        this.userDao = dao;
    }
    
    public void setSeasonDao(SeasonDao dao)
    {
        this.seasonDao = dao;
    }
    
    public void testSave()
    {
        Season s = new Season();
        s.setCity(getCity());
        s.setName("Season 1"); //$NON-NLS-1$
        s.setPostSeasonQualifyingCount(Integer.valueOf(16));
        Match match1 = createMatch(getUser(3), getUser(4), new Date());
        Match match2 = createMatch(getUser(5), getUser(6), new Date());
        SortedSet<Match> matches = new TreeSet<Match>();
        matches.add(match1);
        matches.add(match2);
        s.setMatches(matches);
        System.out.println(s);
        
        this.seasonDao.saveSeason(s);
        
        Season s2 = this.seasonDao.getSeason(s.getId());
        
        System.out.println(s2);
        
    }
    
    private Match createMatch(User user1, User user2, Date playBy)
    {
        Match match = new Match();
        match.setGolfer1(user1);
        match.setGolfer2(user2);
        match.setRound(Integer.valueOf(1));
        match.setPlayBy(playBy);
        return match;
    }
    
    private User getUser(long id)
    {
        return this.userDao.getUser(Long.valueOf(id));
    }
    
    private City getCity()
    {
        City city = new City();
        city.setId(Long.valueOf(1));
        city.setName("Portland"); //$NON-NLS-1$
        city.setVersion(Integer.valueOf(1));
        return city;
    }
}
