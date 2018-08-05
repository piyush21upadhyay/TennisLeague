/*
 * TestPlayPostSeasonController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import com.sageconsulting.model.BracketEntry;
import com.sageconsulting.model.Champion;
import com.sageconsulting.model.City;
import com.sageconsulting.model.Course;
import com.sageconsulting.model.Match;
import com.sageconsulting.model.MatchResult;
import com.sageconsulting.model.MatchScore;
import com.sageconsulting.model.Season;
import com.sageconsulting.model.User;
import com.sageconsulting.service.BracketManager;
import com.sageconsulting.service.ChampionManager;
import com.sageconsulting.service.CourseManager;
import com.sageconsulting.service.MatchManager;
import com.sageconsulting.service.SeasonManager;
import com.sageconsulting.util.BracketUtility;
import com.sageconsulting.util.UserStatsUtil;
import com.sageconsulting.webapp.util.CustomSeasonEditor;

public class TestPlayPostSeasonController extends BaseFormController
{
    private SeasonManager seasonManager;
    private MatchManager matchManager;
    private CourseManager courseManager;
    private BracketManager bracketManager;
    private ChampionManager championManager;
	private transient MatchResult result = null;
    
    public void setChampionManager(ChampionManager championManager) 
	{
		this.championManager = championManager;
	}

    public void setSeasonManager(SeasonManager mgr)
    {
        this.seasonManager = mgr;
    }
    
    public void setMatchManager(MatchManager mgr)
    {
        this.matchManager = mgr;
    }
    
    public void setCourseManager(CourseManager mgr)
    {
        this.courseManager = mgr;
    }
    
    public void setBracketManager(BracketManager mgr)
    {
        this.bracketManager = mgr;
    }
    
    public TestPlayPostSeasonController()
    {
        super();
        setCommandName("playSeasonInfo"); //$NON-NLS-1$
        setCommandClass(PlaySeasonInfo.class);
    }
    
    @Override
    public ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors) throws Exception
    {
        ModelAndView view = super.showForm(request, response, errors);
        view.addObject("seasonList", getSeasons()); //$NON-NLS-1$
        return view;
    }

    private List<Season> getSeasons()
    {
        List<Season> list = this.seasonManager.getSeasons();
        List<Season> playableList = new ArrayList<Season>(list.size());
        for (Season season : list)
        {
            if (season.getState().equals(Season.STATE_POST_SEASON))
            {
                playableList.add(season);
            }
        }
        return playableList;
    }

    @Override
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
        BindException errors) throws Exception
    {
        if (this.log.isDebugEnabled())
        {
            this.log.debug("entering 'onSubmit' method..."); //$NON-NLS-1$
        }

        PlaySeasonInfo playSeasonInfo = (PlaySeasonInfo)command;
        simulatePostSeason(playSeasonInfo.getSeason(), getCourse());
        saveMessage(request, "Simulation of playing post season for "+playSeasonInfo.getSeason().getName()+" successful."); //$NON-NLS-1$ //$NON-NLS-2$

        return super.onSubmit(request, response, command, errors);
    }

    /**
     * Set up a custom property editor for converting form inputs to real
     * objects.
     * @param request The current request.
     * @param binder The object which binds an input to a custom editor.
     */
    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
    {
        binder.registerCustomEditor(Season.class, null, new CustomSeasonEditor(this.seasonManager.getSeasons()));
        super.initBinder(request, binder);
    }
    
    @Override
    public Object formBackingObject(HttpServletRequest request) throws Exception
    {
        PlaySeasonInfo info = (PlaySeasonInfo)super.formBackingObject(request);
        return info;
    }
    
    private Course getCourse()
    {
        List<Course> courses = this.courseManager.getCourses();
        return courses.get(0);
    }
    
    private void simulatePostSeason(Season season, Course course)
    {
        List<BracketEntry> bracket = this.bracketManager.getRoundOneBracketForSeason(season.getId());
        int nRounds = BracketUtility.getRoundCount(bracket.size());
        for (int i=0; i<nRounds; i++)
        {
            for (BracketEntry b : bracket)
            {
                BracketEntry entryToPlay = b;
                for (int j=0; j<i; j++)
                {
                    entryToPlay = entryToPlay.getNext();
                }
                
                if (entryToPlay.getMatch().getPlayed() == null)
                {
                    playMatch(entryToPlay.getMatch(), course);
                    this.matchManager.saveMatch(entryToPlay.getMatch());
                    updateBracket(entryToPlay.getMatch());
                    UserStatsUtil.updateUserStats(this.getUserManager(), entryToPlay.getMatch());
                }
            }
        }
        
        if (this.log.isDebugEnabled())
        {
            this.log.debug("Bracket after auto playing post season"); //$NON-NLS-1$
            this.log.debug(BracketUtility.toString(bracket));
        }
    }
    
    private void playMatch(Match match, Course course)
    {
        Calendar calendar = new GregorianCalendar();
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
        if (match.getResult().isTie())
        {
            match.setPuttoffWinner(match.getGolfer1());
        }
    }
    
    /**
     * Take the winner from the passed in match and move him/her to the next
     * round of the bracket.
     * @param match The match to update.
     */
    private void updateBracket(Match match)
    {
        BracketEntry entry = match.getBracketEntry();
        if (null != entry)
        {
            BracketEntry next = entry.getNext();
            if (null != next)
            {
                // If the match was an odd numbered match for that round, then the
                // golfer becomes the 1st golfer in the next round match.  If it is
                // an even numbered match the the golfer becomes golfer 2 of the next
                // round match.
                User user = match.getResult().getWinner();
                if ((entry.getMatchNumber().intValue() % 2) == 0)
                {
                    next.getMatch().setGolfer1(user);
                }
                else
                {
                    next.getMatch().setGolfer2(user);
                }
                this.matchManager.saveMatch(next.getMatch());
            }
        }
    }

    public static final class PlaySeasonInfo
    {
        private Season season;
        
        public Season getSeason() { return this.season; }
        public void setSeason(Season s) { this.season = s; }
    }
}
