/*
 * BracketUtilityTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import junit.framework.TestCase;

import com.sageconsulting.model.BracketEntry;
import com.sageconsulting.model.City;
import com.sageconsulting.model.Course;
import com.sageconsulting.model.Match;
import com.sageconsulting.model.MatchScore;
import com.sageconsulting.model.Season;
import com.sageconsulting.model.User;

/**
 * This class has unit tests for the {@link BracketUtility} class.
 */
public class BracketUtilityTest extends TestCase
{
    //private Map<User, SeasonResult> results = new HashMap<User, SeasonResult>(20);

    public void test()
    {
        int postSeasonCount = 64;
        Course course = createCourse();
        Season season = createSeason(course, postSeasonCount);
        Calendar start = new GregorianCalendar();
        List<BracketEntry> bracket = BracketUtility.generateBracket(season, start, 4);
        System.out.println(BracketUtility.toString(bracket));
        
        simulateSeason(season, course);
        //updateResults(season);
        //season.get
        //SeasonResult[] resultArray = this.results.values().toArray(new SeasonResult[this.results.size()]);
        SeasonResult[] results = createResults(postSeasonCount);
        
        BracketUtility.fillBracket(bracket, results);
        System.out.println(BracketUtility.toString(bracket));
        
        // TODO: the bracket should be set up so the users are seeded in the order
        //       of thier userid.  We should check to see if it is set up so that
        //       the users meet in the correct round.
    }
    
    private Season createSeason(Course course, int postSeasonCount)
    {
        Season season = new Season();
        season.setCity(getCity());
        season.setMatches(createMatches(postSeasonCount, course));
        season.setName("Test Season"); //$NON-NLS-1$
        season.setPostSeasonQualifyingCount(Integer.valueOf(postSeasonCount));
        return season;
    }
    
    private SortedSet<Match> createMatches(int count, Course course)
    {
        TreeSet<Match> matches = new TreeSet<Match>(new Comparator<Match>()
        {
            public int compare(Match match1, Match match2)
            {
                int sort = match1.getPlayBy().compareTo(match2.getPlayBy());
                if (sort == 0)
                {
                    sort = match1.getGolfer1().getUsername().compareTo(match2.getGolfer1().getUsername());
                }
                return sort;
            }
        });
        
        for (int i=0; i<count; i++)
        {
            Match match = new Match();
            match.setGolfer1(createUser("Match"+i, "Golfer1")); //$NON-NLS-1$ //$NON-NLS-2$
            match.setGolfer2(createUser("Match"+i, "Golfer2")); //$NON-NLS-1$ //$NON-NLS-2$
            match.setCourse(course);
            match.setPlayBy(new Date());
            matches.add(match);
        }
        
        return matches;
    }
    
    private User createUser(String first, String last)
    {
        User user = new User();
        user.setFirstName(first);
        user.setLastName(last);
        user.setUsername(first+last);
        //user.setHandicap(Double.valueOf(Math.random()*20));
        return user;
    }
    
    @SuppressWarnings("boxing")
    private Course createCourse()
    {
        City portland = new City();
        portland.setName("Portland"); //$NON-NLS-1$
        List<City> cities = new ArrayList<City>();
        cities.add(portland);

        Course course = new Course();
        course.setCities(cities);
        course.setCities(cities);
        course.setName("Eastmoreland"); //$NON-NLS-1$
        course.setMensPars(new Byte[] { 4, 4, 4, 4, 3, 5, 4, 3, 5, 4, 5, 3, 5, 4, 4, 4, 3, 4 });
        course.setMensHandicaps(new Byte[] { 13, 3, 11, 9, 17, 1, 5, 15, 7, 14, 8, 18, 2, 12, 10, 4, 16, 6 });
        course.setMensRating(Float.valueOf(74.4f));
        course.setMensSlope(Integer.valueOf(115));
        course.setWomensPars(new Byte[] { 4, 4, 4, 4, 3, 5, 4, 3, 5, 4, 5, 3, 5, 4, 4, 4, 3, 4 });
        course.setWomensHandicaps(new Byte[] { 13, 3, 11, 9, 17, 1, 5, 15, 7, 14, 8, 18, 2, 12, 10, 4, 16, 6 });
        course.setWomensRating(Float.valueOf(74.4f));
        course.setWomensSlope(Integer.valueOf(115));
        return course;
    }
    
    private void simulateSeason(Season season, Course course)
    {
        Calendar calendar = new GregorianCalendar();
        Iterator<Match> matches = season.getMatches().iterator();
        while(matches.hasNext())
        {
            Match match = matches.next();
            MatchScore score = new MatchScore();
            // TODO: Akash
            /*score.computeStrokes(course, match.getGolfer1(), match.getGolfer2());
            score.setPlayer1Hole1Score(Byte.valueOf((byte)5));
            score.setPlayer1Hole2Score(Byte.valueOf((byte)5));
            score.setPlayer1Hole3Score(Byte.valueOf((byte)5));
            score.setPlayer1Hole4Score(Byte.valueOf((byte)5));
            score.setPlayer1Hole5Score(Byte.valueOf((byte)5));
            score.setPlayer1Hole6Score(Byte.valueOf((byte)5));
            score.setPlayer1Hole7Score(Byte.valueOf((byte)5));
            score.setPlayer1Hole8Score(Byte.valueOf((byte)5));
            score.setPlayer1Hole9Score(Byte.valueOf((byte)5));
            score.setPlayer1Hole10Score(Byte.valueOf((byte)5));
            score.setPlayer1Hole11Score(Byte.valueOf((byte)5));
            score.setPlayer1Hole12Score(Byte.valueOf((byte)5));
            score.setPlayer1Hole13Score(Byte.valueOf((byte)5));
            score.setPlayer1Hole14Score(Byte.valueOf((byte)5));
            score.setPlayer1Hole15Score(Byte.valueOf((byte)5));
            score.setPlayer1Hole16Score(Byte.valueOf((byte)5));
            score.setPlayer1Hole17Score(Byte.valueOf((byte)5));
            score.setPlayer1Hole18Score(Byte.valueOf((byte)5));
            score.setPlayer2Hole1Score(Byte.valueOf((byte)5));
            score.setPlayer2Hole2Score(Byte.valueOf((byte)5));
            score.setPlayer2Hole3Score(Byte.valueOf((byte)5));
            score.setPlayer2Hole4Score(Byte.valueOf((byte)5));
            score.setPlayer2Hole5Score(Byte.valueOf((byte)5));
            score.setPlayer2Hole6Score(Byte.valueOf((byte)5));
            score.setPlayer2Hole7Score(Byte.valueOf((byte)5));
            score.setPlayer2Hole8Score(Byte.valueOf((byte)5));
            score.setPlayer2Hole9Score(Byte.valueOf((byte)5));
            score.setPlayer2Hole10Score(Byte.valueOf((byte)5));
            score.setPlayer2Hole11Score(Byte.valueOf((byte)5));
            score.setPlayer2Hole12Score(Byte.valueOf((byte)5));
            score.setPlayer2Hole13Score(Byte.valueOf((byte)5));
            score.setPlayer2Hole14Score(Byte.valueOf((byte)5));
            score.setPlayer2Hole15Score(Byte.valueOf((byte)5));
            score.setPlayer2Hole16Score(Byte.valueOf((byte)5));
            score.setPlayer2Hole17Score(Byte.valueOf((byte)5));
            score.setPlayer2Hole18Score(Byte.valueOf((byte)5));
            score.computeMatchScore();*/
            match.setScore(score);
            match.setPlayed(calendar.getTime());
            match.setCourse(course);
        }
    }
    
    private SeasonResult[] createResults(int count)
    {
        List<SeasonResult> results = new ArrayList<SeasonResult>(count);
        for (int i=0; i<count; i++)
        {
            User user = createUser("User", "Number"+(i+1)); //$NON-NLS-1$ //$NON-NLS-2$
            user.setId(Long.valueOf(i));
            SeasonResult result = new SeasonResult(user);
            for (int j=count; j>i; j--)
            {
                result.incrementWins();
            }
            results.add(result);
        }
        return results.toArray(new SeasonResult[results.size()]);
    }
    
    private City getCity()
    {
        City city = new City();
        city.setId(Long.valueOf(1));
        city.setName("Portland"); //$NON-NLS-1$
        city.setVersion(Integer.valueOf(1));
        return city;
    }
    
//    private void updateResults(Season season)
//    {
//        SortedSet<Match> matches = season.getMatches();
//        for (Match match : matches)
//        {
//            updateResults(match);
//        }
//    }
//    
//    private void updateResults(Match match)
//    {
//        if (null == match.getPlayed())
//        {
//            updateUser(match.getGolfer1());
//            updateUser(match.getGolfer2());
//        }
//        else if (match.getResult().isTie())
//        {
//            updateTie(match.getGolfer1());
//            updateTie(match.getGolfer2());
//        }
//        else
//        {
//            updateWin(match.getResult().getWinner());
//            updateLoss(match.getResult().getLoser());
//        }
//    }
//    
//    private void updateUser(User user)
//    {
//        // Ignore the "bye" user
//        if (user == null)
//        {
//            return;
//        }
//        
//        SeasonResult result = this.results.get(user);
//        if (null == result)
//        {
//            result = new SeasonResult(user);
//            this.results.put(user, result);
//        }
//    }
//    
//    private void updateTie(User user)
//    {
//        SeasonResult result = getResult(user);
//        result.incrementTies();
//        this.results.put(user, result);
//    }
//    
//    private void updateWin(User user)
//    {
//        // Ignore the "bye" user
//        if (user == null)
//        {
//            return;
//        }
//        
//        SeasonResult result = getResult(user);
//        result.incrementWins();
//        this.results.put(user, result);
//    }
//    
//    private void updateLoss(User user)
//    {
//        // Ignore the "bye" user
//        if (user == null)
//        {
//            return;
//        }
//        
//        SeasonResult result = getResult(user);
//        result.incrementLosses();
//        this.results.put(user, result);
//    }
//    
//    private SeasonResult getResult(User user)
//    {
//        SeasonResult result = this.results.get(user);
//        if (null == result)
//        {
//            result = new SeasonResult(user);
//        }
//        return result;
//    }
}
