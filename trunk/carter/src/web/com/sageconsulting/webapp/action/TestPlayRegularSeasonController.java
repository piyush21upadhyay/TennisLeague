/*
 * TestPlayRegularSeasonController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import com.sageconsulting.model.Course;
import com.sageconsulting.model.Match;
import com.sageconsulting.model.MatchScore;
import com.sageconsulting.model.Season;
import com.sageconsulting.service.CourseManager;
import com.sageconsulting.service.MatchManager;
import com.sageconsulting.service.SeasonManager;
import com.sageconsulting.util.UserStatsUtil;
import com.sageconsulting.webapp.util.CustomSeasonEditor;

public class TestPlayRegularSeasonController extends BaseFormController
{
    private SeasonManager seasonManager;
    private MatchManager matchManager;
    private CourseManager courseManager;
    
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
    
    public TestPlayRegularSeasonController()
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
            if (season.getState().equals(Season.STATE_REGULAR_SEASON))
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
        simulateSeason(playSeasonInfo.getSeason(), getCourse());
        saveMessage(request, "Simulation of playing season "+playSeasonInfo.getSeason().getName()+" successful."); //$NON-NLS-1$ //$NON-NLS-2$

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
    
    private void simulateSeason(Season season, Course course)
    {
        Iterator<Match> matches = season.getMatches().iterator();
        while(matches.hasNext())
        {
            Match match = matches.next();
            MatchScore score = new MatchScore();
            if (null != match.getGolfer2())
            {
            	// TODO: Akash
                /*score.computeStrokes(course, match.getGolfer1(), match.getGolfer2());
                score.setPlayer1Hole1Score(Byte.valueOf((byte)4));
                score.setPlayer1Hole2Score(Byte.valueOf((byte)4));
                score.setPlayer1Hole3Score(Byte.valueOf((byte)4));
                score.setPlayer1Hole4Score(Byte.valueOf((byte)4));
                score.setPlayer1Hole5Score(Byte.valueOf((byte)4));
                score.setPlayer1Hole6Score(Byte.valueOf((byte)4));
                score.setPlayer1Hole7Score(Byte.valueOf((byte)4));
                score.setPlayer1Hole8Score(Byte.valueOf((byte)4));
                score.setPlayer1Hole9Score(Byte.valueOf((byte)4));
                score.setPlayer1Hole10Score(Byte.valueOf((byte)4));
                score.setPlayer1Hole11Score(Byte.valueOf((byte)4));
                score.setPlayer1Hole12Score(Byte.valueOf((byte)4));
                score.setPlayer1Hole13Score(Byte.valueOf((byte)4));
                score.setPlayer1Hole14Score(Byte.valueOf((byte)4));
                score.setPlayer1Hole15Score(Byte.valueOf((byte)4));
                score.setPlayer1Hole16Score(Byte.valueOf((byte)4));
                score.setPlayer1Hole17Score(Byte.valueOf((byte)4));
                score.setPlayer1Hole18Score(Byte.valueOf((byte)4));
                score.setPlayer2Hole1Score(Byte.valueOf((byte)4));
                score.setPlayer2Hole2Score(Byte.valueOf((byte)4));
                score.setPlayer2Hole3Score(Byte.valueOf((byte)4));
                score.setPlayer2Hole4Score(Byte.valueOf((byte)4));
                score.setPlayer2Hole5Score(Byte.valueOf((byte)4));
                score.setPlayer2Hole6Score(Byte.valueOf((byte)4));
                score.setPlayer2Hole7Score(Byte.valueOf((byte)4));
                score.setPlayer2Hole8Score(Byte.valueOf((byte)4));
                score.setPlayer2Hole9Score(Byte.valueOf((byte)4));
                score.setPlayer2Hole10Score(Byte.valueOf((byte)4));
                score.setPlayer2Hole11Score(Byte.valueOf((byte)4));
                score.setPlayer2Hole12Score(Byte.valueOf((byte)4));
                score.setPlayer2Hole13Score(Byte.valueOf((byte)4));
                score.setPlayer2Hole14Score(Byte.valueOf((byte)4));
                score.setPlayer2Hole15Score(Byte.valueOf((byte)4));
                score.setPlayer2Hole16Score(Byte.valueOf((byte)4));
                score.setPlayer2Hole17Score(Byte.valueOf((byte)4));
                score.setPlayer2Hole18Score(Byte.valueOf((byte)4));
                score.computeMatchScore();*/
                match.setScore(score);
                match.setPlayed(match.getPlayBy());
                //match.setCourse(course);
                this.matchManager.saveMatch(match);
                
                UserStatsUtil.updateUserStats(this.getUserManager(), match);
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
