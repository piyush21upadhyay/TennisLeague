/*
 * ResultsController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.GrantedAuthority;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.sageconsulting.model.BracketEntry;
import com.sageconsulting.model.Champion;
import com.sageconsulting.model.City;
import com.sageconsulting.model.Court;
import com.sageconsulting.model.Match;
import com.sageconsulting.model.MatchResult;
import com.sageconsulting.model.MatchScore;
import com.sageconsulting.model.Season;
import com.sageconsulting.model.User;
import com.sageconsulting.service.BracketManager;
import com.sageconsulting.service.ChampionManager;
import com.sageconsulting.service.CourtManager;
import com.sageconsulting.service.MatchManager;
import com.sageconsulting.service.SeasonManager;
import com.sageconsulting.util.UserStatsUtil;
import com.sageconsulting.webapp.util.CustomCourtEditor;
import com.sageconsulting.webapp.util.CustomHoleScoreEditor;
import com.sageconsulting.webapp.util.CustomUserEditor;

public class ResultsController extends BaseFormController
{
    private static final String CMD_NAME = "match"; //$NON-NLS-1$
    private static final String ENTER_SCORES = "enterScores"; //$NON-NLS-1$
    
    //private CourseManager courseManager;
    private CourtManager courtManager;
    private MatchManager matchManager;
    private BracketManager bracketManager;
    private ChampionManager championManager;
    private SeasonManager seasonManager;
  
    private transient MatchResult result = null;
    
    public void setCourtManager(CourtManager mgr)
    {
        this.courtManager = mgr;
    }
    
    public void setBracketManager(BracketManager bracketManager) {
		this.bracketManager = bracketManager;
	}

	public void setChampionManager(ChampionManager championManager) {
		this.championManager = championManager;
	}

	public void setSeasonManager(SeasonManager seasonManager) {
		this.seasonManager = seasonManager;
	}

	public void setMatchManager(MatchManager mgr)
    {
        this.matchManager = mgr;
    }
    
    public ResultsController()
    {
        setCommandName(CMD_NAME);
        setCommandClass(Match.class);
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
        binder.registerCustomEditor(User.class, new CustomUserEditor(this.getUserManager()));
        binder.registerCustomEditor(Court.class, null, new CustomCourtEditor(this.courtManager.getCourts()));
        binder.registerCustomEditor(Byte.class, new CustomHoleScoreEditor());
        super.initBinder(request, binder);
    }

    /**
     * Overridden to process the cancelling of the editing.
     */
    @Override
    public ModelAndView processFormSubmission(HttpServletRequest request, HttpServletResponse response, Object command,
        BindException errors) throws Exception
    {
        if (isCancel(request))
        {
            return new ModelAndView(getCancelView());
        }

        return super.processFormSubmission(request, response, command, errors);
    }
    
    /**
     * Return true if this request was created by the user pressing the "Cancel" button.
     * @param request The current request.
     * @return true if the user pressed the cancel button and false if not.
     */
    private boolean isCancel(HttpServletRequest request)
    {
    	String cancel = request.getParameter("bCancel"); //$NON-NLS-1$
    	return (null != cancel) && cancel.equals("true"); //$NON-NLS-1$
    }
    
    /**
     * Return true if this request was created by the user pressing the "Default Victory" button.
     * @param request The current request.
     * @return true if the user pressed the default victory button and false if not.
     */
    private boolean isDefaultVictory(HttpServletRequest request)
    {
    	String cancel = request.getParameter("bDefault"); //$NON-NLS-1$
    	return (null != cancel) && cancel.equals("true"); //$NON-NLS-1$
    }
    
    /**
     * Return true if this request was created by the user pressing "Post" button on
     * the first entry screen.
     * @param request The current request.
     * @return true if the user pressed the "Post" button and false if not.
     */
    private boolean isVerify(HttpServletRequest request)
    {
    	String cancel = request.getParameter("bVerify"); //$NON-NLS-1$
    	return (null != cancel) && cancel.equals("true"); //$NON-NLS-1$
    }
    
    /**
     * Return true if this request was created by the user pressing "Save" button on
     * the second entry screen.
     * @param request The current request.
     * @return true if the user pressed the "Save" button and false if not.
     */
    private boolean isSave(HttpServletRequest request)
    {
    	String cancel = request.getParameter("bSave"); //$NON-NLS-1$
    	return (null != cancel) && cancel.equals("true"); //$NON-NLS-1$
    }
    
    /**
     * Return true if this request was created by the user pressing "Back" button on
     * the second entry screen.
     * @param request The current request.
     * @return true if the user pressed the "Back" button and false if not.
     */
    private boolean isBack(HttpServletRequest request)
    {
    	String cancel = request.getParameter("bBack"); //$NON-NLS-1$
    	return (null != cancel) && cancel.equals("true"); //$NON-NLS-1$
    }
    
    @Override
    public ModelAndView showForm(HttpServletRequest request, HttpServletResponse response,
        BindException errors) throws Exception
    {
    	// If no match is specified, just go to the schedule page
    	if (null == getMatchId(request))
    	{
    		return new ModelAndView(new RedirectView("schedule.html")); //$NON-NLS-1$
    	}
    	
        User currentUser = getCurrentUser(request);
        Match match = (Match)getCommand(request);
        
        // Don't allow user not involved with the match to post scores.
        if ((currentUser == null) ||
        	(!currentUser.equals(match.getGolfer1()) && !currentUser.equals(match.getGolfer2())))
        {
        	super.saveMessage(request, getText("results.nonplayer", request.getLocale())); //$NON-NLS-1$
        	return new ModelAndView();
        }
        
        ModelAndView view = super.showForm(request, response, errors);
        if (null == match.getCourse())
        {
            updateCourseInfo(view, currentUser);
        }
        else if(isAdministratorEdit(request))
        {
            view.addObject("Allcourse", this.courtManager.getCourts());
        	view.addObject("courseList", match.getCourse());
        	view.addObject("isAdministrator", true);
        }
        
        view.addObject(ENTER_SCORES, Boolean.TRUE);
        view.addObject("user", currentUser); //$NON-NLS-1$
        return view;
    }
    
    @Override
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
        BindException errors) throws Exception
    {
        if (isDefaultVictory(request))
        {
            Match match = (Match)command;
            User user = this.getCurrentUser(request);
            match.setDefaultWinner(user);

            ModelAndView view = new ModelAndView();
            view.addObject(CMD_NAME, command);
            view.addObject(ENTER_SCORES, Boolean.FALSE);
            if(isAdministratorEdit(request))
            {
            	view.addObject("user", user);
            	view.addObject("isAdministrator", true);
            }
            
            return view;
        }
        else if (isVerify(request))
        {
            Match match = (Match)command;
            // TODO: Akash
            //match.getScore().computeStrokes(match.getCourse(), match.getGolfer1(), match.getGolfer2());
            //match.getScore().computeMatchScore();

            ModelAndView view = new ModelAndView();
            view.addObject(CMD_NAME, command);
            view.addObject(ENTER_SCORES, Boolean.FALSE);
            if(isAdministratorEdit(request))
            {
            	view.addObject("user", this.getCurrentUser(request));
            	view.addObject("isAdministrator", true);
            }
            
            return view;
        }
        else if (isSave(request))
        {
            // First save the match
            Match match = (Match)command;
            
            if (isDefaultWin(request))
            {
                User user = this.getCurrentUser(request);
                match.setDefaultWinner(user);
            }
            else
            {
                // Need to recompute the score or the scores after the match are over will be 0 instead of null.
            	// TODO: Akash
                //match.getScore().computeMatchScore();
                
                // If this is a post season match that was a tie, we need to update
                // things based on the winner of the putt-off.
                if (match.getResult().isTie() && (null != match.getBracketEntry()))
                {
                    // Make sure a winner was selected in the putt off.
                    User puttoffWinner = getPuttoffWinner(request, match);
                    if (null == puttoffWinner)
                    {
                        errors.rejectValue("result.winner", "results.noPuttoffWinner"); //$NON-NLS-1$ //$NON-NLS-2$
                        ModelAndView view = new ModelAndView("results", errors.getModel()); //$NON-NLS-1$
                        view.addObject(CMD_NAME, command);
                        view.addObject(ENTER_SCORES, Boolean.FALSE);
                        return view;
                    }
                    
                    // Update the winner and loser based on putt off result.
                    match.setPuttoffWinner(puttoffWinner);
                }
            }
            
			//System.out.println("Match: "+match.getId());
            List<BracketEntry> bracketEntry=this.bracketManager.getRound(match);
            
            if (bracketEntry.size()>0)
            {
            	//System.out.println("Bracket Id: "+bracketEntry.get(0).getId());
            	if(bracketEntry.get(0).getRound()==4)
            	{
            		//System.out.println("In If");
            		User winner=null;
            		Season season =this.seasonManager.getSeason(bracketEntry.get(0).getSeasonId());
            		City city =season.getCity();
            		Champion champion= new Champion();
            		result=match.getResult();
            		if(match.getDefaultWinner()!=null)
            		{
            			System.out.println("In default Winner");
            			winner=match.getDefaultWinner();
            		}
            		else if(result.getWinner()!=null)
            		{
            			System.out.println("In Normal Winner");
            			winner=result.getWinner();
            		}
            		else if(match.getPuttoffWinner()!=null)
            		{
            			System.out.println("In puttoff Winner");
            			winner=match.getPuttoffWinner();
            		}
            		champion.setPlayer(winner);
            		champion.setVersion(1);
            		if(city!= null)
            		{
            		champion.setCity(city);
            		}
            		if(season!=null)
            		{
            		champion.setDivision(season.getDivision());
            		}
            		Calendar now = Calendar.getInstance();  
            		champion.setYear(now.get(Calendar.YEAR));
            		//System.out.println("Current Season: "+result.getWinner().getCurrentSeason());
            		//System.out.println("Season State: "+result.getWinner().getCurrentSeason().getState().intValue());
            		String record=getCurrentRecord(winner);
            		//System.out.println("Rcord: "+record);
            		champion.setRecord(record.toString());
            		champion.setSeason(season.getName());
            		Court court=new Court();
            		court.setName(winner.getHomeCourtText());
            		court.setCourtAddress(winner.getCourtAddress());
            		champion.setHomeCourt(court);
            		//champion.setHandicap(winner.getHandicap());
            		this.championManager.saveChampion(champion);
            		winner.setIcon("images/champion.png");
            		this.getUserManager().updateChampionIcon(winner);
            	}
            }
           /***Changes for opponent retired starts*****/
            if(1==match.getScore().getOpponentRetired()){
            	User currUser=this.getCurrentUser(request);
            	Long p1UserId=match.getGolfer1().getId();
            	Long p2UserId=match.getGolfer2().getId();
            	
            	match.getScore().setOpponentRetired(currUser.getId().compareTo(p1UserId)==0?p2UserId:p1UserId);
            }
            /***Changes for opponent retired ends*****/
            
            this.matchManager.saveMatch(match);
            
            // If the match is part of a post season bracket, move the winner
            // to the next position in the bracket.
            updateBracket(match);
            
            UserStatsUtil.updateUserStats(this.getUserManager(), match);
            if(isAdministratorEdit(request))
            {
            	String adminRedirectView = "redirect:record.html?id=" + this.getCurrentUser(request).getId().toString();
            	super.setSuccessView(adminRedirectView);
            }
            else
            	super.setSuccessView("redirect:schedule.html");
            
            ModelAndView view = new ModelAndView(getSuccessView());
            return view;
        }
        else if (isBack(request))
        {
            ModelAndView view = new ModelAndView();
            view.addObject(CMD_NAME, command);
            view.addObject(ENTER_SCORES, Boolean.TRUE);
            User user = this.getCurrentUser(request);
            updateCourseInfo(view, user);
            view.addObject("user", user); //$NON-NLS-1$
            
            if(isAdministratorEdit(request))
            {
            	Match match = (Match)command;
            	view.addObject("courseList", match.getCourse());
            	view.addObject("isAdministrator", true);
            }
            return view;
        }

        return super.onSubmit(request, response, command, errors);
    }
    
    private boolean isDefaultWin(HttpServletRequest request)
    {
        String defaultWinParam = request.getParameter("defaultWin"); //$NON-NLS-1$
        return ((null != defaultWinParam) && defaultWinParam.equals("true")); //$NON-NLS-1$
    }
    
    private User getPuttoffWinner(HttpServletRequest request, Match match)
    {
        User winner = null;
        String winnerId = request.getParameter("puttoffWinner"); //$NON-NLS-1$
        if (null != winnerId)
        {
            try
            {
                Long id = Long.valueOf(winnerId);
                if (match.getGolfer1().getId().equals(id))
                {
                    winner = match.getGolfer1();
                }
                else if (match.getGolfer2().getId().equals(id))
                {
                    winner = match.getGolfer2();
                }
            }
            catch (NumberFormatException e)
            {
                this.log.error("Invalid winner selected", e); //$NON-NLS-1$
            }
        }
        return winner;
    }
    
    private void updateCourseInfo(ModelAndView view, User currentUser)
    {
        view.addObject("courseList", this.courtManager.getCourts(currentUser.getRegisteredCity().getId())); //$NON-NLS-1$
    }
    
    @Override
    public Object formBackingObject(HttpServletRequest request)
    {
        Match match = getMatch(request);
        if (null == match)
        {
            match = new Match();
        }
        if (null == match.getScore())
        {
            match.setScore(new MatchScore());
        }
        if (null == match.getPlayed())
        {
            match.setPlayed(new Date());
        }
        return match;
    }
    
    private Long getMatchId(HttpServletRequest request)
    {
        Long id = null;
        String strMatchId = request.getParameter("id"); //$NON-NLS-1$
        if (null != strMatchId)
        {
            try
            {
                id = Long.valueOf(strMatchId);
            }
            catch (NumberFormatException e)
            {
                this.log.warn("Invalid match id specified: "+strMatchId); //$NON-NLS-1$
            }
        }
        return id;
    }
    
    private Match getMatch(HttpServletRequest request)
    {
        Match match = null;
        Long matchId = getMatchId(request);
        if (null != matchId)
        {
            match =  this.matchManager.getMatch(matchId);
        }
        return match;
    }
    
    private User getCurrentUser(HttpServletRequest request)
    {
        if ( (request.getParameter("user_id") != null) && isAdministratorEdit(request) )
        	return this.getUserManager().getUser(request.getParameter("user_id"));

        String username = request.getRemoteUser();
        return this.getUserManager().getUserByUsername(username);
    }
    
    private boolean isAdministratorEdit(HttpServletRequest request)
    {
    	boolean isAdministrator = false;
    	User currentUser = this.getUserManager().getUserByUsername(request.getRemoteUser());
    	GrantedAuthority[] userAuthorities = currentUser.getAuthorities();
        
        for(int counter=0; counter<userAuthorities.length; counter++)
        {
        	String userRole = userAuthorities[counter].toString();
        	if(userRole.equalsIgnoreCase("admin"))
        	{
        		isAdministrator = true;
        		break;
        	}
        }
        
    	return isAdministrator;
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
                User winner = match.getDefaultWinner();
                if (!match.isDefaultWin())
                {
                    winner = match.getResult().getWinner();
                }
                if ((entry.getMatchNumber().intValue() % 2) == 0)
                {
                    next.getMatch().setGolfer1(winner);
                }
                else
                {
                    next.getMatch().setGolfer2(winner);
                }
                this.matchManager.saveMatch(next.getMatch());
            }
        }
    }
     
    private String getCurrentRecord(User user)
	{
    	if((user.getCurrentSeason() == null) || (user.getCurrentSeason().getState().intValue() == Season.STATE_CLEAR))
		{
			StringBuilder sb = new StringBuilder("0").append('-').append("0").append('-').append("0");
			return sb.toString();
		}
		
		//System.out.println("Current Record: "+user.getCurrentRecord());
		return user.getCurrentRecord();
	}
}
