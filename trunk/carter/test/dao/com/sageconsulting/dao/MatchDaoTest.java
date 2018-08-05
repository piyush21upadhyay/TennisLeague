/*
 * MatchDaoTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.sageconsulting.model.Match;
import com.sageconsulting.model.MatchScore;
import com.sageconsulting.model.User;

public class MatchDaoTest extends BaseDaoTestCase
{

    private UserDao userDao;
    //private SeasonDao seasonDao;
    private MatchDao matchDao;

//    public void setSeasonDao(SeasonDao dao)
//    {
//        this.seasonDao = dao;
//    }

    public void setMatchDao(MatchDao dao)
    {
        this.matchDao = dao;
    }

    public void setUserDao(UserDao dao)
    {
        this.userDao = dao;
    }

//    public void testGetMatch()
//    {
//        Match match = this.matchDao.getMatch(Long.valueOf(1));
//        assertNotNull(match);
//    }

    @SuppressWarnings("boxing")
    public void testSaveMatch()
    {
        Match match = new Match();
        User user1 = this.userDao.getUser(Long.valueOf(2));
        User user2 = this.userDao.getUser(Long.valueOf(3));
        match.setGolfer1(user1);
        match.setGolfer2(user2);
        match.setRound(Integer.valueOf(1));
        match.setPlayBy(new GregorianCalendar(2007, 7, 10).getTime());
        MatchScore score = new MatchScore();
        // TODO: Akash
        //score.setScores1(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 });
        //score.setScores2(new Byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 });
        match.setScore(score);
        this.matchDao.saveMatch(match);

        Match m = this.matchDao.getMatch(match.getId());
        assertNotNull(m);
        // TODO: Akash
       /* assertTrue(match.getScore().getPlayer1Hole5Score() == 5);
        assertTrue(match.getScore().getPlayer1Hole10Score() == 10);
        assertTrue(match.getScore().getPlayer1Hole18Score() == 18);
        assertTrue(match.getScore().getPlayer2Hole1Score() == 1);
        assertTrue(match.getScore().getPlayer1Hole12Score() == 12);
        assertTrue(match.getScore().getPlayer1Hole18Score() == 18);*/
    }

//    public void testGetMatchesForGolfer()
//    {
//        List<Match> list = this.matchDao.getMatchesForGolfer(Long.valueOf(2));
//        assertTrue(list.size() == 6);
//    }

//    public void testGetMatchesForSeason()
//    {
//        List<Match> list = this.matchDao.getMatchesForSeason(Long.valueOf(1));
//        assertTrue(list.size() == 66);
//    }
    
    public void testGetUnderParLeaders()
    {
        Calendar start = new GregorianCalendar();
        Calendar end = new GregorianCalendar();
        int day = start.get(Calendar.DAY_OF_YEAR);
        start.set(Calendar.DAY_OF_YEAR, day+7);
        end.set(Calendar.DAY_OF_YEAR, day+14);
        List<Match> matches = this.matchDao.getUnderParLeaders(true, true, 1, start.getTime(), end.getTime());
        // TODO: Akash
        for (Match m : matches)
        {
           /* System.out.println(((null == m.getGolfer1()) ? "null" : m.getGolfer1().getFullName())+ //$NON-NLS-1$
                "  "+ m.getScore().getPlayer1UnderParGrossScore()+ //$NON-NLS-1$
                "  "+ m.getScore().getPlayer1UnderParNetScore()+"  "+ //$NON-NLS-1$ //$NON-NLS-2$
                ((null == m.getGolfer2()) ? "null" : m.getGolfer2().getFullName())+"  "+ //$NON-NLS-1$ //$NON-NLS-2$
                m.getScore().getPlayer2UnderParGrossScore()+"  "+ m.getScore().getPlayer2UnderParGrossScore()); *///$NON-NLS-1$
        }
    }

}
