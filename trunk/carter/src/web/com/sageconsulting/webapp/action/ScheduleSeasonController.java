/*
 * ScheduleSeasonController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import com.sageconsulting.model.BracketEntry;
import com.sageconsulting.model.Match;
import com.sageconsulting.model.Registration;
import com.sageconsulting.model.RegistrationEntry;
import com.sageconsulting.model.Season;
import com.sageconsulting.model.User;
import com.sageconsulting.service.BracketManager;
import com.sageconsulting.service.RegistrationEntryManager;
import com.sageconsulting.service.RegistrationManager;
import com.sageconsulting.service.SeasonManager;
import com.sageconsulting.service.UserExistsException;
import com.sageconsulting.util.BracketUtility;
import com.sageconsulting.util.SeasonInfo;
import com.sageconsulting.util.SeasonResult;

public class ScheduleSeasonController extends BaseFormController
{
    private RegistrationManager registrationManager;
    private RegistrationEntryManager registrationEntryManager;
    private SeasonManager seasonManager;
    private BracketManager bracketManager;

    public ScheduleSeasonController()
    {
        setCommandName("schedule"); //$NON-NLS-1$
        setCommandClass(ScheduleInfo.class);
    }
    
    public void setRegistrationManager(RegistrationManager mgr)
    {
        this.registrationManager = mgr;
    }
    
    public void setRegistrationEntryManager(RegistrationEntryManager mgr)
    {
        this.registrationEntryManager = mgr;
    }
    
    public void setSeasonManager(SeasonManager mgr)
    {
        this.seasonManager = mgr;
    }
    
    public void setBracketManager(BracketManager mgr)
    {
        this.bracketManager = mgr;
    }
    
    /**
     * Handle the showing of the account form.
     * @param request The current request object.
     * @param response The current response object.
     * @param errors A collection of errors on the form.
     * @return The ModelAndView object to display after processing.
     * @exception Exception For errors processing the form.
     */
    @Override
    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors)
        throws Exception
    {
        ModelAndView modelAndView = super.showForm(request, response, errors);
        addRegistrantList(modelAndView, request);
        Registration registration = getRegistration(request);
        modelAndView.addObject("registration", registration); //$NON-NLS-1$
        modelAndView.addObject("seasonList", getSeasonList(registration)); //$NON-NLS-1$
        return modelAndView;
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
        super.initBinder(request, binder);
    }

    @Override
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
        BindException errors) throws Exception
    {
        if (this.log.isDebugEnabled())
        {
            this.log.debug("entering 'onSubmit' method..."); //$NON-NLS-1$
        }

        ScheduleInfo scheduleInfo = (ScheduleInfo)command;
        if (request.getParameter("save") != null) //$NON-NLS-1$
        {
            createSchedule(scheduleInfo, request.getLocale());
        }
        
        ModelAndView view = new ModelAndView(getSuccessView());
        view.addObject("id", scheduleInfo.getRegistrationId()); //$NON-NLS-1$
        return view;
    }
    
    private List<Season> getSeasonList(Registration registration)
    {
        if (null == registration)
        {
            return new ArrayList<Season>();
        }
        return this.seasonManager.getSeasonsForRegistration(registration.getId());
    }
    
    private void addRegistrantList(ModelAndView view, HttpServletRequest request)
    {
        List<RegistrationEntry> registrants = getRegistrants(request);
        view.addObject("registrantList", registrants); //$NON-NLS-1$
    }
    
    /**
     * Get the id of the parameter
     * @param request
     * @return
     */
    private Long getIdParameter(HttpServletRequest request)
    {
        Long id = null;
        String idParam = request.getParameter("id"); //$NON-NLS-1$
        if (null != idParam)
        {
            try
            {
                id = Long.valueOf(idParam);
            }
            catch (NumberFormatException e)
            {
                this.log.warn("Invalid id passed to controller: "+idParam); //$NON-NLS-1$
                // we can ignore this and just return null
            }
        }
        return id;
    }
    
    private Registration getRegistration(HttpServletRequest request)
    {
        Long id = getIdParameter(request);
        return getRegistration(id);
    }
    
    private Registration getRegistration(Long id)
    {
        if (null == id)
        {
            return null;
        }
        return this.registrationManager.getRegistration(id);
    }
    
    private List<RegistrationEntry> getRegistrants(HttpServletRequest request)
    {
        Long id = getIdParameter(request);
        return getRegistrants(id);
    }
    
    private List<RegistrationEntry> getRegistrants(Long id)
    {
        if (null == id)
        {
            return new ArrayList<RegistrationEntry>();
        }
        return this.registrationEntryManager.getRegistrationEntriesForRegistration(id);
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception
    {
        ScheduleInfo info = (ScheduleInfo)super.formBackingObject(request);
        info.setRegistrationId(getIdParameter(request));
        return info;
    }
    
    private void createSchedule(ScheduleInfo scheduleInfo, Locale locale)
    {
        Registration registration = getRegistration(scheduleInfo.getRegistrationId());
        if (registration.getScheduleState().equals(Registration.STATE_UNSCHEDULED))
        {
            createRegularSeasonSchedule(scheduleInfo, registration, locale);
        }
        else if (registration.getScheduleState().equals(Registration.STATE_REGULAR_SEASON_SCHEDULED))
        {
            createPostSeasonSchedule(registration);
        }
    }
    
    private void createRegularSeasonSchedule(ScheduleInfo scheduleInfo, Registration registration, Locale locale)
    {
        List<RegistrationEntry> registrants = getRegistrants(scheduleInfo.getRegistrationId());
        sortRegistrants(registrants);

        List<RegistrationEntry> groupA = getGroup(registrants, scheduleInfo.getGroupACutoff());
        List<RegistrationEntry> groupB = getGroup(registrants, scheduleInfo.getGroupBCutoff());
        List<RegistrationEntry> groupC = getGroup(registrants, scheduleInfo.getGroupCCutoff());
        List<RegistrationEntry> groupD = getGroup(registrants, scheduleInfo.getGroupDCutoff());
        List<RegistrationEntry> groupE = getGroup(registrants, scheduleInfo.getGroupECutoff());
        
        createSeason(registration, groupA, getText("scheduleSeason.aflight", locale), scheduleInfo); //$NON-NLS-1$
        createSeason(registration, groupB, getText("scheduleSeason.bflight", locale), scheduleInfo); //$NON-NLS-1$
        createSeason(registration, groupC, getText("scheduleSeason.cflight", locale), scheduleInfo); //$NON-NLS-1$
        createSeason(registration, groupD, getText("scheduleSeason.dflight", locale), scheduleInfo); //$NON-NLS-1$
        createSeason(registration, groupE, getText("scheduleSeason.eflight", locale), scheduleInfo); //$NON-NLS-1$
    }
    
    private void sortRegistrants(List<RegistrationEntry> registrants)
    {
        Collections.sort(registrants, new Comparator<RegistrationEntry>()
        {
            public int compare(RegistrationEntry entry1, RegistrationEntry entry2)
            {
                return 0;//entry1.getUser().getHandicap().compareTo(entry2.getUser().getHandicap());
            }
        });
    }
    
    private List<RegistrationEntry> getGroup(List<RegistrationEntry> registrants, Double cutoff)
    {
        if (registrants.isEmpty())
        {
            return null;
        }
        
        Double testCutoff = (null != cutoff) ? cutoff : Double.valueOf(Double.MAX_VALUE);
        List<RegistrationEntry> group = new ArrayList<RegistrationEntry>(20);
        while (!registrants.isEmpty() /*&& (registrants.get(0).getUser().getHandicap().compareTo(testCutoff) <= 0)*/)
        {
            RegistrationEntry entry = registrants.remove(0);
            group.add(entry);
        }
        
        // Add a fake one to make an even number if necessary
        if ((group.size() % 2) != 0)
        {
            group.add(createDummyRegistration());
        }
        return group;
    }
    
    private RegistrationEntry createDummyRegistration()
    {
        RegistrationEntry entry = new RegistrationEntry();
        return entry;
    }
    
    private void createSeason(Registration registration, List<RegistrationEntry> registrants, String name, ScheduleInfo info)
    {
        if ((null == registrants) || (registrants.isEmpty()))
        {
            return;
        }
        
        info.setStartDate(new GregorianCalendar());  // TODO: this needs to be specified in scheduleinfo
        Season season = new Season();
        season.setCity(registration.getCity());
        season.setName(registration.getDisplayName());
        season.setDivision(name);
        season.setPostSeasonQualifyingCount(Integer.valueOf(info.getPostSeasonPlayers()));
        season.setMatches(createMatches(registrants, info));
        season.setRegistrationId(info.getRegistrationId());
        
        this.seasonManager.saveSeason(season);
        registration.setScheduleState(Registration.STATE_REGULAR_SEASON_SCHEDULED);
        this.registrationManager.saveRegistration(registration);
        createBracket(season, info.getStartDate(), info.getRegularSeasonMatches());
        
        updateUsersSeasonInfo(registrants, season);
    }
    
    private SortedSet<Match> createMatches(List<RegistrationEntry> registrants, ScheduleInfo info)
    {
        randomizeRegistrants(registrants);
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
        
        int nDays = 7;
        info.getStartDate().add(Calendar.DAY_OF_YEAR, nDays);
        for (int i=0; i<info.getRegularSeasonMatches(); i++)
        {
            createRound(i, registrants, matches, info.getStartDate());
            info.getStartDate().add(Calendar.DAY_OF_YEAR, nDays);
        }
        
        return matches;
    }
    
    private void createRound(int roundNumber, List<RegistrationEntry> entries, SortedSet<Match> matches, Calendar playBy)
    {
        int half = entries.size() / 2;
        for (int i=0; i<half; i++)
        {
            User user1 = entries.get(i).getUser();
            int user2Index = half + ((half + roundNumber + i) % half);
            User user2 = entries.get(user2Index).getUser();
            
            
            Match match = new Match();
            match.setRound(Integer.valueOf(roundNumber+1));
            match.setPlayBy(playBy.getTime());
            if ((roundNumber % 2) == 0)
            {
                if (null == user1)
                {
                    match.setGolfer1(user2);
                }
                else
                {
                    match.setGolfer1(user1);
                    match.setGolfer2(user2);
                }
            }
            else
            {
                if (null == user2)
                {
                    match.setGolfer1(user1);
                }
                else
                {
                    match.setGolfer1(user2);
                    match.setGolfer2(user1);
                }
            }
            matches.add(match);
        }
    }
    
    private void randomizeRegistrants(List<RegistrationEntry> registrants)
    {
        Collections.sort(registrants, new Comparator<RegistrationEntry>()
        {
            public int compare(RegistrationEntry entry1, RegistrationEntry entry2)
            {
                if (entry1.hashCode() <= entry2.hashCode())
                {
                    return -1;
                }
                return 1;
            }
        });
    }
    
    private void createBracket(Season season, Calendar startDate, int regularSeasonMatchCount)
    {
        List<BracketEntry> bracket = BracketUtility.generateBracket(season, startDate, regularSeasonMatchCount);
        this.bracketManager.saveBracket(bracket);
    }
    
    private void createPostSeasonSchedule(Registration registration)
    {
        List<Season> seasons = getSeasonList(registration);
        for (Season season : seasons)
        {
            SeasonInfo seasonInfo = new SeasonInfo();
            seasonInfo.setSeasonId(season.getId());
            seasonInfo.setSeasonManager(this.seasonManager);
            seasonInfo.updateResults();
            SeasonResult[] results = seasonInfo.getResults();

            List<BracketEntry> bracket = this.bracketManager.getRoundOneBracketForSeason(seasonInfo.getSeasonId());
            BracketUtility.fillBracket(bracket, results);
            this.bracketManager.saveBracket(bracket);
            season.setState(Season.STATE_POST_SEASON);
            this.seasonManager.saveSeason(season);
//            Arrays.sort(results, new SeasonResultComparator());
//            
//            season.getPostSeasonQualifyingCount();
//            StringBuilder sb = new StringBuilder();
//            for (SeasonResult result : results)
//            {
//                sb.append(result.getUser().getFullName());
//                sb.append(": ");
//                sb.append(result.getPoints()).append(" ");
//                sb.append(result.getWins()).append(" ");
//                sb.append(result.getLosses()).append(" ");
//                sb.append(result.getTies()).append(" ");
//                sb.append(result.getUser().getHandicap());
//                sb.append("\r\n");
//            }
//            System.out.println(sb.toString());
        }
        registration.setScheduleState(Registration.STATE_POST_SEASON_SCHEDULED);
        this.registrationManager.saveRegistration(registration);
    }
    
//    private void createPostSeasonSchedule(Season season, SeasonResult[] results, int nMatches)
//    {
//        List<BracketEntry> bracket = this.bracketManager.getRoundOneBracketForSeason(season.getId());
//        BracketUtility.fillBracket(bracket, results);
//    }
    
    /**
     * For each registrant, update their first season, current season and season record
     * stats.
     */
    private void updateUsersSeasonInfo(List<RegistrationEntry> registrants, Season season)
    {
        for (RegistrationEntry entry : registrants)
        {
            User user = entry.getUser();
            if (null == user)
            {
                continue;
            }
            
            if (null == user.getFirstSeason())
            {
                user.setFirstSeason(season);
            }
            user.setCurrentSeason(season);
            
            //probably first we need to set wins to zero
            user.setCurrentWins(Integer.valueOf(0));
            
            updateWins(user, season.getMatches());
            user.setCurrentLosses(Integer.valueOf(0));
            user.setCurrentTies(Integer.valueOf(0));
            int seasons = user.getSeasonEntered().intValue() + 1;
            user.setSeasonEntered(Integer.valueOf(seasons));
            saveUser(user);
        }
    }
    
    private void updateWins(User user, SortedSet<Match> matches)
    {
        for (Match match : matches)
        {
            if (match.isBye())
            {
                if (user.equals(match.getGolfer1()) || user.equals(match.getGolfer2()))
                {
                    int currentWins = user.getCurrentWins().intValue() + 1;
                    int totalWins = user.getTotalWins().intValue() + 1;
                    user.setCurrentWins(Integer.valueOf(currentWins));
                    user.setTotalWins(Integer.valueOf(totalWins));
                }
            }
        }
    }
    
    private void saveUser(User user)
    {
        try
        {
            this.getUserManager().saveUser(user);
        }
        catch (UserExistsException e)
        {
            // This should never happen since we are just updating.
            this.log.error("Error saving user during scheduling.", e); //$NON-NLS-1$
        }
    }
    
    public static final class ScheduleInfo
    {
        private Long registrationId;
        private Double groupACutoff;
        private Double groupBCutoff;
        private Double groupCCutoff;
        private Double groupDCutoff;
        private Double groupECutoff;
        private int regularSeasonMatches = 4;
        private int postSeasonPlayers = 16;
        private Calendar startDate;
        
        public Long getRegistrationId() { return this.registrationId; }
        public Double getGroupACutoff() { return this.groupACutoff; }
        public Double getGroupBCutoff() { return this.groupBCutoff; }
        public Double getGroupCCutoff() { return this.groupCCutoff; }
        public Double getGroupDCutoff() { return this.groupDCutoff; }
        public Double getGroupECutoff() { return this.groupECutoff; }
        public int getRegularSeasonMatches() { return this.regularSeasonMatches; }
        public int getPostSeasonPlayers() { return this.postSeasonPlayers; }
        public Calendar getStartDate() { return this.startDate; }
        
        public void setRegistrationId(Long id) { this.registrationId = id; }
        public void setGroupACutoff(Double d) { this.groupACutoff = d; }
        public void setGroupBCutoff(Double d) { this.groupBCutoff = d; }
        public void setGroupCCutoff(Double d) { this.groupCCutoff = d; }
        public void setGroupDCutoff(Double d) { this.groupDCutoff = d; }
        public void setGroupECutoff(Double d) { this.groupECutoff = d; }
        public void setRegularSeasonMatches(int m) { this.regularSeasonMatches = m; }
        public void setPostSeasonPlayers(int p) { this.postSeasonPlayers = p; }
        public void setStartDate(Calendar cal) { this.startDate = cal; }
        
        @Override
        public String toString()
        {
            ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
            sb.append("registrationId", this.registrationId); //$NON-NLS-1$
            sb.append("groupACutoff", this.groupACutoff); //$NON-NLS-1$
            sb.append("groupBCutoff", this.groupBCutoff); //$NON-NLS-1$
            sb.append("groupCCutoff", this.groupCCutoff); //$NON-NLS-1$
            sb.append("groupDCutoff", this.groupDCutoff); //$NON-NLS-1$
            sb.append("groupECutoff", this.groupECutoff); //$NON-NLS-1$
            sb.append("regularSeasonMatches", this.regularSeasonMatches); //$NON-NLS-1$
            sb.append("postSeasonPlayers", this.postSeasonPlayers); //$NON-NLS-1$
            sb.append("startDate", this.startDate); //$NON-NLS-1$
            return sb.toString();
        }
    }
}
