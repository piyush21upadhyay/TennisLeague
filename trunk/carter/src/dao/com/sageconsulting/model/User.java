/*
 * User.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.userdetails.UserDetails;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * This class is used to generate Spring Validation rules as well as the
 * Hibernate mapping file.
 * 
 * @hibernate.class table="user"
 */
public class User extends BaseObject implements Serializable, UserDetails
{
    private static final long serialVersionUID = 3832626162173359411L;

    private Long id;
    private Integer version;
    private String username; // required
    private String password; // required
    private String confirmPassword;
    private String firstName; // required
    private String lastName; // required
    private boolean male = true;
    private Address address = new Address();
    private String homePhone;
    private String cellPhone;
    private int preferredPhone = 1;
    private String email; // required; unique
    private String passwordHint;
    private City registeredCity;
    private String referral;
    private String icon = "images/teeOff-icon.jpg"; //$NON-NLS-1$
    private Season firstSeason;
    private Date dateJoined;
    private Date lastLogin;
    private Set<Role> roles = new HashSet<Role>();
    private boolean enabled;
    private boolean accountExpired;
    private boolean accountLocked;
    private boolean credentialsExpired;
    
    private Season currentSeason;
    private Integer currentWins = Integer.valueOf(0);
    private Integer currentLosses = Integer.valueOf(0);
    private Integer currentTies = Integer.valueOf(0);
    private Integer totalWins = Integer.valueOf(0);
    private Integer totalLosses = Integer.valueOf(0);
    private Integer totalTies = Integer.valueOf(0);
    private Integer bestResult = Integer.valueOf(0);
    private Season bestResultSeason;
    private Integer lowScore;
    private Integer seasonEntered = Integer.valueOf(0);
    private boolean accountDeleted;
    private Double playerLevel=Double.valueOf(2.5);
    private String ratedBy;
    private String plays;
    private String[] playingPreference;
    private boolean openToChallenges = true;
    private boolean onlyOpenToSameGender = true;
    private String opponentSkillLevel="onlyMyRating";
    private String racquet;
    private String tennisString;
    private String shoes;
    private String selectCourt;
    private String homeCourtText; 
    private String courtAddress;
    private String courtCity;
    private String courtState;
    private Long courtId;
    private String isCourtLighted;
    private String numberOfCourts;
    private String openCourtMeridiem;
    private String openCourtHour;
    private String closeCourtMeridiem;
    private String closeCourtHour;
    private boolean courtVerified = false;
    
	public User()
    {
        // nothing to do
    }

    public User(String uname)
    {
        this.username = uname;
    }
    
    /**
     * @hibernate.property column="court_address" not-null="true"
     */
    public String getCourtAddress() {
		return courtAddress;
	}

    /**
     * @spring.validator type="required"
     */
	public void setCourtAddress(String courtAddress) {
		this.courtAddress = courtAddress;
	}

    /**
     * @hibernate.id column="id" generator-class="native" unsaved-value="null"
     */
    public Long getId()
    {
        return this.id;
    }

    /**
     * @hibernate.property length="50" not-null="true" unique="true"
     */
    public String getUsername()
    {
        return this.username;
    }

    /**
     * @hibernate.property column="password" not-null="true"
     */
    public String getPassword()
    {
        return this.password;
    }

    public String getConfirmPassword()
    {
        return this.confirmPassword;
    }

    /**
     * @hibernate.property column="first_name" not-null="true" length="50"
     */
    public String getFirstName()
    {
        return this.firstName;
    }

    /**
     * @hibernate.property column="last_name" not-null="true" length="50"
     */
    public String getLastName()
    {
        return this.lastName;
    }

    /**
     * Returns the full name.
     */
    public String getFullName()
    {
        return this.firstName + ' ' + this.lastName;
    }
    
    public String getDisplayName()
    {
    	return this.lastName + ' ' + this.firstName.charAt(0);
    }
    
    public String getCurrentRecord()
    {
        return getRecord(getCurrentWins(), getCurrentLosses()/*, getCurrentTies()*/);
    }
    
    public String getOverallRecord()
    {
        return getRecord(getTotalWins(), getTotalLosses()/*, getTotalTies()*/);
    }
    
    private String getRecord(Integer wins, Integer losses/*, Integer ties*/)
    {
        StringBuilder sb = new StringBuilder(wins.toString()).append('-').append(losses)/*.
            append('-').append(ties)*/;
        return sb.toString();
    }
    
    /**
     * 
     * @return
     * @hibernate.property column="male"
     */
    public boolean getMale()
    {
        return this.male;
    }

    /**
     * @hibernate.component
     */
    public Address getAddress()
    {
        return this.address;
    }

    /**
     * @hibernate.property name="email" not-null="true" unique="true"
     */
    public String getEmail()
    {
        return this.email;
    }

    /**
     * @hibernate.property column="home_phone" not-null="false"
     */
    public String getHomePhone()
    {
        return this.homePhone;
    }

    /**
     * @hibernate.property column="cell_phone" not-null="false"
     */
    public String getCellPhone()
    {
        return this.cellPhone;
    }

    /**
     * @hibernate.property column="preferred_phone" not-null="false"
     */
    public int getPreferredPhone()
    {
        return this.preferredPhone;
    }

    /**
     * @hibernate.property column="password_hint" not-null="false"
     */
    public String getPasswordHint()
    {
        return this.passwordHint;
    }
    
    /**
     * Get the users chosen home course.
     * @return The user's home course.
     * @hibernate.many-to-one column="registered_city" cascade="none" not-null="true" lazy="false"
     */
    public City getRegisteredCity()
    {
        return this.registeredCity;
    }
    
    /**
     * Get the users chosen home course.
     * @return The user's home course.
     * @hibernate.many-to-one column="home_course" cascade="none" 
     *//*
    public Course getHomeCourt()
    {
        return this.homeCourt;
    }*/
    
    /**
     * How the user initially heard about city golf league.
     * @return How the user initially heard about city golf league.
     * @hibernate.property column="referral" not-null="true"
     */
    public String getReferral()
    {
        return this.referral;
    }
    
    /**
     * The icon to display for a user.  If null a default is chosen.
     * @return The icon to display for the user.
     * @hibernate.property column="icon" not-null="true"
     */
    public String getIcon()
    {
        return this.icon;
    }
    
    /**
     * Get the first season that the user played.
     * @return The first season that the user played.
     * @hibernate.many-to-one column="first_season" not-null="false" cascade="all"
     */
    public Season getFirstSeason()
    {
        return this.firstSeason;
    }
    
    /**
     * Get the date that the user joined.
     * @return The date that the user joined.
     * @hibernate.property column="date_joined" not-null="true"
     */
    public Date getDateJoined()
    {
        return this.dateJoined;
    }
    
    /**
     * Get the date of the user's last login.
     * @return The date of the user's last login.
     * @hibernate.property column="last_login" not-null="false"
     */
    public Date getLastLogin()
    {
        return this.lastLogin;
    }

    /**
     * @hibernate.set table="user_role" cascade="save-update" lazy="false"
     * @hibernate.collection-key column="user_id"
     * @hibernate.collection-many-to-many class="com.sageconsulting.model.Role" column="role_id"
     */
    public Set<Role> getRoles()
    {
        return this.roles;
    }

    /**
     * Adds a role for the user
     * 
     * @param role
     */
    public void addRole(Role role)
    {
        getRoles().add(role);
    }

    /**
     * @see org.acegisecurity.userdetails.UserDetails#getAuthorities()
     */
    public GrantedAuthority[] getAuthorities()
    {
        return this.roles.toArray(new GrantedAuthority[0]);
    }

    /**
     * @hibernate.version
     */
    public Integer getVersion()
    {
        return this.version;
    }

    /**
     * @hibernate.property column="account_enabled" type="yes_no"
     */
    public boolean isEnabled()
    {
        return this.enabled;
    }
    
    public boolean isAccountDeleted()
    {
    	return !isEnabled();
    }

    /**
     * @hibernate.property column="account_expired" not-null="true"
     *                     type="yes_no"
     */
    public boolean isAccountExpired()
    {
        return this.accountExpired;
    }

    /**
     * @see org.acegisecurity.userdetails.UserDetails#isAccountNonExpired()
     */
    public boolean isAccountNonExpired()
    {
        return !isAccountExpired();
    }

    /**
     * @hibernate.property column="account_locked" not-null="true" type="yes_no"
     */
    public boolean isAccountLocked()
    {
        return this.accountLocked;
    }

    /**
     * @see org.acegisecurity.userdetails.UserDetails#isAccountNonLocked()
     */
    public boolean isAccountNonLocked()
    {
        return !isAccountLocked();
    }

    /**
     * @hibernate.property column="credentials_expired" not-null="true"
     *                     type="yes_no"
     */
    public boolean isCredentialsExpired()
    {
        return this.credentialsExpired;
    }

    /**
     * @see org.acegisecurity.userdetails.UserDetails#isCredentialsNonExpired()
     */
    public boolean isCredentialsNonExpired()
    {
        return !this.credentialsExpired;
    }
    
    /**
     * @hibernate.many-to-one column="current_season" cascade="none" not-null="false"
     */
    public Season getCurrentSeason()
    {
        return this.currentSeason;
    }
    
    /**
     * @hibernate.property column="current_wins" not-null="true"
     */
    public Integer getCurrentWins()
    {
        return this.currentWins;
    }
    
    /**
     * @hibernate.property column="current_losses" not-null="true"
     */
    public Integer getCurrentLosses()
    {
        return this.currentLosses;
    }
    
    /**
     * @hibernate.property column="current_ties" not-null="true"
     */
    public Integer getCurrentTies()
    {
        return this.currentTies;
    }
    
    public int getCurrentPoints()
    {
    	int seasonPoints = 0;
    	if(null != this.currentSeason)
    	{
	    	SortedSet<Match> matches = this.currentSeason.getMatches();
	    	if(null != matches)
	    	{
	    		for(Match match : matches)
		    	{
		    		if(match.getPlayed() != null)
		    		{
			    		boolean isStraightWin = false;
			    		boolean isStraightLose = false;
			    		int numberOfSetsWon = 0;
			    		int pointsForMatch = 0;
			    		if(null != match.getDefaultWinner() && this.id == match.getDefaultWinner().getId())
			    		{
			    			pointsForMatch += 2;
			    		}
			    		else if(null != match.getScore().getOpponentRetired() 
			    				&& (this.id == match.getGolfer1().getId() || this.id == match.getGolfer2().getId()))
			    		{
			    			if(!this.id.equals(match.getScore().getOpponentRetired()))
			    				pointsForMatch += 3;
			    		}
			    		else if(match.getGolfer1().getId() == this.id)
			    		{
				    		if(match.getScore().getPlayer1set1() > match.getScore().getPlayer2set1()){
				    			pointsForMatch += 1;
				    			if(match.getScore().getPlayer1set2() > match.getScore().getPlayer2set2())
				    			{
				    				pointsForMatch +=3;
				    				isStraightWin = true;
				    			}
				    			numberOfSetsWon++;
				    		}
				    		if(match.getScore().getPlayer1set2() > match.getScore().getPlayer2set2() && !isStraightWin)
			    			{
			    				pointsForMatch +=1;
			    				numberOfSetsWon++;
			    			}
				    		if(numberOfSetsWon == 0)
				    		{
				    			isStraightLose = true;
				    		}
				    		if(match.getScore().getPlayer1set3() > match.getScore().getPlayer2set3() && !isStraightWin && !isStraightLose)
				    		{
				    			pointsForMatch += 1;
				    			numberOfSetsWon++;
				    		}
				    		if(numberOfSetsWon > 1)
				    			pointsForMatch += 1;
			    		}
			    		else if(match.getGolfer2().getId() == this.id )
			    		{
			    			if(match.getScore().getPlayer2set1() > match.getScore().getPlayer1set1()){
				    			pointsForMatch += 1;
				    			if(match.getScore().getPlayer2set2() > match.getScore().getPlayer1set2())
				    			{
				    				pointsForMatch +=3;
				    				isStraightWin = true;
				    			}
				    			numberOfSetsWon++;
				    		}
			    			if(match.getScore().getPlayer2set2() > match.getScore().getPlayer1set2() && !isStraightWin)
			    			{
			    				pointsForMatch +=1;
			    				numberOfSetsWon++;
			    			}
			    			if(numberOfSetsWon == 0)
				    		{
				    			isStraightLose = true;
				    		}
				    		if(match.getScore().getPlayer2set3() > match.getScore().getPlayer1set3() && !isStraightWin && !isStraightLose)
				    		{
				    			pointsForMatch += 1;
				    			numberOfSetsWon++;
				    		}
				    		if(numberOfSetsWon > 1)
				    			pointsForMatch += 1;
			    		}
			    			seasonPoints += pointsForMatch; 
		    		}
		    		else if(match.isBye())
		    		{
		    			if((null != match.getGolfer1() && this.id == match.getGolfer1().getId()) 
		    					|| (null != match.getGolfer2() && this.id == match.getGolfer2().getId()))
		    				seasonPoints += 2;
		    		}
		    		
		    	}
	    	}
    }
    	
    	return seasonPoints;
    }
    
    public String getGamesWonPercentage()
    {
    	double wonPercentage = 0.0;
    	if(null != this.currentSeason)
    	{
	    	SortedSet<Match> matches = this.currentSeason.getMatches();
	    	if(null != matches)
	    	{
	    		int numOfWinGames = 0;
	    		int numOfLossGames = 0;
	    		for(Match match : matches)
		    	{
	    			
		    		if(match.getPlayed() != null)
		    		{
		    			//System.out.println("Match Details : "+match.getId()+" "+match.getPlayed()+" "+match.getGolfer1().getId()+" "+match.getGolfer2().getId());
			    		if(match.getGolfer1().getId() == this.id)
			    		{
			    			numOfWinGames = numOfWinGames + match.getScore().getPlayer1set1() + match.getScore().getPlayer1set2() + match.getScore().getPlayer1set3();
			    			numOfLossGames = numOfLossGames + match.getScore().getPlayer2set1() + match.getScore().getPlayer2set2() + match.getScore().getPlayer2set3();
			    				
			    		}
			    		else if(match.getGolfer2().getId() == this.id )
			    		{
			    			numOfWinGames = numOfWinGames + match.getScore().getPlayer2set1() + match.getScore().getPlayer2set2() + match.getScore().getPlayer2set3();
			    			numOfLossGames = numOfLossGames + match.getScore().getPlayer1set1() + match.getScore().getPlayer1set2() + match.getScore().getPlayer1set3();
	    				} 
		    		}
		    		
		    	}
	    		int totalGamesPlayed = numOfWinGames + numOfLossGames;
	    		if(totalGamesPlayed != 0)
					wonPercentage = (double)(numOfWinGames*100)/totalGamesPlayed;
	    	}
    	}
    	String wonPercentageStr = wonPercentage+"";
    	if(wonPercentageStr.indexOf(".") > 0 && wonPercentageStr.substring(wonPercentageStr.indexOf(".")).length() > 3)
    		return wonPercentageStr.substring(0, wonPercentageStr.indexOf(".")+3)+"%";
    	else
    		return wonPercentageStr+"%";
    
    }
    
    public String getGamesLossPercentage()
    {
    	double lossPercentage = 0.0;
    	if(null != this.currentSeason)
    	{
	    	SortedSet<Match> matches = this.currentSeason.getMatches();
	    	if(null != matches)
	    	{
	
	    		int numOfWinGames = 0;
	    		int numOfLossGames = 0;
	    		for(Match match : matches)
		    	{
		    		if(match.getPlayed() != null)
		    		{
			    		if(match.getGolfer1().getId() == this.id)
			    		{
			    			numOfWinGames = numOfWinGames + match.getScore().getPlayer1set1() + match.getScore().getPlayer1set2() + match.getScore().getPlayer1set3();
			    			numOfLossGames = numOfLossGames + match.getScore().getPlayer2set1() + match.getScore().getPlayer2set2() + match.getScore().getPlayer2set3();
			    				
			    		}
			    		else if(match.getGolfer2().getId() == this.id )
			    		{
			    			numOfWinGames = numOfWinGames + match.getScore().getPlayer2set1() + match.getScore().getPlayer2set2() + match.getScore().getPlayer2set3();
			    			numOfLossGames = numOfLossGames + match.getScore().getPlayer1set1() + match.getScore().getPlayer1set2() + match.getScore().getPlayer1set3();
	    				} 
		    		}
		    		
		    	}
	    		int totalGamesPlayed = numOfWinGames + numOfLossGames;
	    		if(totalGamesPlayed != 0)
	    			lossPercentage = (double)(numOfLossGames*100)/totalGamesPlayed;
	    	}
    	}
    	
    	String lossPercentageStr = lossPercentage+"";
    	if(lossPercentageStr.indexOf(".") > 0 && lossPercentageStr.substring(lossPercentageStr.indexOf(".")).length() > 3)
    		return lossPercentageStr.substring(0, lossPercentageStr.indexOf(".")+3)+"%";
    	else
    		return lossPercentageStr+"%";
    
    }
    
    /**
     * @hibernate.property column="total_wins" not-null="true"
     */
    public Integer getTotalWins()
    {
        return this.totalWins;
    }
    
    /**
     * @hibernate.property column="total_losses" not-null="true"
     */
    public Integer getTotalLosses()
    {
        return this.totalLosses;
    }
    
    /**
     * @hibernate.property column="total_ties" not-null="true"
     */
    public Integer getTotalTies()
    {
        return this.totalTies;
    }
    
    /**
     * Return the user's best result from any season.  Values are:
     * <ul>
     *   <li>0 - Never made playoffs (bestResultSeason will be null)</li>
     *   <li>1 - Champion</li>
     *   <li>2 - Runner Up</li>
     *   <li>3 - Semifinalist</li>
     *   <li>4 - Quarterfinalist</li>
     *   <li>5 - Made playoffs</li>
     * </ul>
     * @hibernate.property column="best_result" not-null="true"
     */
    public Integer getBestResult()
    {
        return this.bestResult;
    }

    /**
     * Which season did the user achieve their best result.  This will be null if they 
     * never made the playoffs.
     * @hibernate.many-to-one column="best_result_season" cascade="none" not-null="false"
     */
    public Season getBestResultSeason()
    {
        return this.bestResultSeason;
    }
    
    /**
     * @hibernate.property column="low_score" not-null="false"
     */
    public Integer getLowScore()
    {
        return this.lowScore;
    }
    
    /**
     * @hibernate.property column="seasons_entered" not-null="true"
     */
    public Integer getSeasonEntered()
    {
        return this.seasonEntered;
    }
    
        
    /**
     * @hibernate.property column="player_level" not-null="true"
     */
    public Double getPlayerLevel() {
		return playerLevel;
	}
    
    /**
     * @hibernate.property column="ratedby" not-null="true"
     */
	public String getRatedBy() {
		return ratedBy;
	}

	/**
     * @hibernate.property column="homecourt" not-null="true"
     *//*
	public String getHomeCourt() {
		return homeCourt;
	}*/

	/**
     * @hibernate.property column="plays" not-null="true"
     */
	public String getPlays() {
		return plays;
	}

	/**
     * @hibernate.property column="playing_preference" 
     */
	public String[] getPlayingPreference() {
		return playingPreference;
	}

	/**
     * @hibernate.property column="opentochallenges" not-null="true"
     */
	public boolean isOpenToChallenges() {
		return openToChallenges;
	}
	
	/**
     * @hibernate.property column="playwithonlysamegender" not-null="true"
     */
	public boolean isOnlyOpenToSameGender() {
		return onlyOpenToSameGender;
	}


	/**
     * @hibernate.property column="opponent_skilllevel" not-null="false"
     */
	public String getOpponentSkillLevel() {
		return opponentSkillLevel;
	}

	/**
     * @hibernate.property column="racket" not-null="true"
     */
	public String getRacquet() {
		return racquet;
	}

	/**
     * @hibernate.property column="tennisstring" not-null="true"
     */
	public String getTennisString() {
		return tennisString;
	}

	/**
     * @hibernate.property column="shoes" not-null="true"
     */
	public String getShoes() {
		return shoes;
	}
	
	public void setId(Long userId)
    {
        this.id = userId;
    }

    /**
     * @spring.validator type="required"
     */
    public void setUsername(String name)
    {
        this.username = name;
    }

    /**
     * @spring.validator type="required"
     * @spring.validator type="twofields" msgkey="errors.twofields"
     * @spring.validator-args arg1resource="user.password"
     * @spring.validator-args arg1resource="user.confirmPassword"
     * @spring.validator-var name="secondProperty" value="confirmPassword"
     */
    public void setPassword(String pwd)
    {
        this.password = pwd;
    }

    /**
     * @spring.validator type="required"
     */
    public void setConfirmPassword(String confirm)
    {
        this.confirmPassword = confirm;
    }

    /**
     * @spring.validator type="required"
     */
    public void setFirstName(String first)
    {
        this.firstName = first;
    }

    /**
     * @spring.validator type="required"
     */
    public void setLastName(String last)
    {
        this.lastName = last;
    }
    
    public void setMale(boolean b)
    {
        this.male = b;
    }

    /**
     * @spring.validator type="required"
     */
    public void setAddress(Address addr)
    {
        this.address = addr;
    }

    /**
     * @spring.validator type="required"
     * @spring.validator type="email"
     */
    public void setEmail(String mail)
    {
        this.email = mail;
    }


    /**
     * @spring.validator type="onefield" msgkey="errors.onefield"
     * @spring.validator-args arg1resource="user.homePhone"
     * @spring.validator-args arg1resource="user.cellPhone"
     * @spring.validator-var name="secondProperty" value="cellPhone"
     * @spring.validator type="mask" msgkey="errors.phone"
     * @spring.validator-var name="mask" value="${phone}"
     */
    public void setHomePhone(String phoneNumber)
    {
        this.homePhone = phoneNumber;
    }

    /**
     * @spring.validator type="mask" msgkey="errors.phone"
     * @spring.validator-var name="mask" value="${phone}"
     */
    public void setCellPhone(String phoneNumber)
    {
        this.cellPhone = phoneNumber;
    }

    public void setPreferredPhone(int preferred)
    {
        this.preferredPhone = preferred;
    }

    /**
     * @spring.validator type="required"
     */
    public void setPasswordHint(String hint)
    {
        this.passwordHint = hint;
    }
    
    public void setFirstSeason(Season season)
    {
        this.firstSeason = season;
    }
    
    public void setDateJoined(Date joined)
    {
        this.dateJoined = joined;
    }
    
    public void setLastLogin(Date login)
    {
        this.lastLogin = login;
    }
    
    public void setRegisteredCity(City c)
    {
        this.registeredCity = c;
    }
    
    
    /*public void setHomeCourt(Course court)
    {
        this.homeCourt = court;
    }*/
    
    /**
     * @spring.validator type="required"
     */
    public void setReferral(String ref)
    {
        this.referral = ref;
    }
    
    /**
     * @spring.validator type="required"
     */
    public void setIcon(String ico)
    {
        this.icon = ico;
    }

    public void setRoles(Set<Role> userRoles)
    {
        this.roles = userRoles;
    }

    public void setVersion(Integer ver)
    {
        this.version = ver;
    }

    public void setEnabled(boolean accountEnabled)
    {
        this.enabled = accountEnabled;
    }
    
    public void setAccountDeleted(boolean accountDeleted)
    {
        this.accountDeleted = accountDeleted;
    }
    
    
   
    public void setPlayerLevel(Double playerLevel) {
		this.playerLevel = playerLevel;
	}
    
   
	public void setRatedBy(String ratedBy) {
		this.ratedBy = ratedBy;
	}
	
	/**
     * @spring.validator type="required"
     *//*
	public void setHomeCourt(String homeCourt) {
		this.homeCourt = homeCourt;
	}*/

	
	public void setPlays(String plays) {
		this.plays = plays;
	}

	
	public void setPlayingPreference(String[] playingPreference) {
		this.playingPreference = playingPreference;
	}

	
	public void setOpenToChallenges(boolean openToChallenges) {
		this.openToChallenges = openToChallenges;
	}


	public void setOnlyOpenToSameGender(boolean onlyOpenToSameGender) {
		this.onlyOpenToSameGender = onlyOpenToSameGender;
	}
	

	/**Removed the validator for now, as need to think more as how to make it dependent on Open To Challeneges**/
	public void setOpponentSkillLevel(String opponentSkillLevel) {
		this.opponentSkillLevel = opponentSkillLevel;
	}


	public void setRacquet(String racquet) {
		this.racquet = racquet;
	}

	public void setTennisString(String tennisString) {
		this.tennisString = tennisString;
	}

	public void setShoes(String shoes) {
		this.shoes = shoes;
	}

	/**
     * Convert user roles to LabelValue objects for convenience.
     */
    public List<LabelValue> getRoleList()
    {
        List<LabelValue> userRoles = new ArrayList<LabelValue>();

        if (this.roles != null)
        {
            for (Iterator<Role> it = this.roles.iterator(); it.hasNext();)
            {
                Role role = it.next();

                // convert the user's roles to LabelValue Objects
                userRoles.add(new LabelValue(role.getName(), role.getName()));
            }
        }

        return userRoles;
    }

    public void setAccountExpired(boolean expired)
    {
        this.accountExpired = expired;
    }

    public void setAccountLocked(boolean locked)
    {
        this.accountLocked = locked;
    }

    public void setCredentialsExpired(boolean expired)
    {
        this.credentialsExpired = expired;
    }
    
    public void setCurrentSeason(Season s)
    {
        this.currentSeason = s;
    }
    
    public void setCurrentWins(Integer i)
    {
        this.currentWins = i;
    }
    
    public void setCurrentLosses(Integer i)
    {
        this.currentLosses = i;
    }
    
    public void setCurrentTies(Integer i)
    {
        this.currentTies = i;
    }
    
    public void setTotalWins(Integer i)
    {
        this.totalWins = i;
    }
    
    public void setTotalLosses(Integer i)
    {
        this.totalLosses = i;
    }
    
    public void setTotalTies(Integer i)
    {
        this.totalTies = i;
    }
    
    public void setBestResult(Integer r)
    {
        this.bestResult = r;
    }
    
    public void setBestResultSeason(Season s)
    {
        this.bestResultSeason = s;
    }
    
    public void setLowScore(Integer s)
    {
        this.lowScore = s;
    }
    
    public void setSeasonEntered(Integer e)
    {
        this.seasonEntered = e;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof User))
        {
            return false;
        }

        final User user = (User) o;

        if (this.username != null ? !this.username.equals(user.getUsername()) : user.getUsername() != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        return (this.username != null ? this.username.hashCode() : 0);
    }

    @Override
    public String toString()
    {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).
            append("username", this.username). //$NON-NLS-1$
            append("enabled", this.enabled). //$NON-NLS-1$
            append("accountExpired", this.accountExpired). //$NON-NLS-1$
            append("credentialsExpired", this.credentialsExpired). //$NON-NLS-1$
            append("accountLocked", this.accountLocked). //$NON-NLS-1$
            append("homeCourt", this.homeCourtText).
            append("referral", this.referral);
        
        /* Some properties are set for exporting user data to excel,pdf, or xml */
        sb.append("registeredCity", this.registeredCity);
        sb.append("lastName", this.lastName);
        sb.append("firstName", this.firstName);
        sb.append("password", this.password);
        sb.append("email", this.email);
        sb.append("email", this.email);
        sb.append("address", this.address);
        sb.append("cellPhone", this.cellPhone);
        sb.append("homePhone", this.homePhone);
        sb.append("playerLevel", this.playerLevel);
        sb.append("homeCourt", this.homeCourtText);
        sb.append("dateJoined", this.dateJoined);
        sb.append("seasonEntered", this.seasonEntered);
        sb.append("currentSeason", this.currentSeason);
        sb.append("lowScore", this.lowScore);
        sb.append("accountDeleted", this.isAccountDeleted());
        
        GrantedAuthority[] auths = this.getAuthorities();
        if (auths != null)
        {
            sb.append("Granted Authorities: "); //$NON-NLS-1$

            for (int i=0; i<auths.length; i++)
            {
                if (i > 0)
                {
                    sb.append(", "); //$NON-NLS-1$
                }
                sb.append(auths[i].toString());
            }
        }
        else
        {
            sb.append("No Granted Authorities"); //$NON-NLS-1$
        }
        return sb.toString();
    }

    
    /**
     * @hibernate.property column="home_court" not-null="true"
     */
	public String getHomeCourtText() {
		return homeCourtText;
	}

	 /**
     * @spring.validator type="required"
     */
	public void setHomeCourtText(String homeCourtText) {
		this.homeCourtText = homeCourtText;
	}

	/**
     * @hibernate.property column="court_city" not-null="true"
     */
	public String getCourtCity() {
		return courtCity;
	}

	/**
     * @spring.validator type="required"
     */
	public void setCourtCity(String courtCity) {
		this.courtCity = courtCity;
	}

	/**
     * @hibernate.property column="court_state" not-null="true"
     */
	public String getCourtState() {
		return courtState;
	}

	/**
     * @spring.validator type="required"
     */
	public void setCourtState(String courtState) {
		this.courtState = courtState;
	}

	/**
     * @hibernate.property column="court_id" not-null="true"
     */
	public Long getCourtId() {
		return courtId;
	}

	public void setCourtId(Long courtId) {
		this.courtId = courtId;
	}
	
	/**
     * @hibernate.property column="court_lighted" not-null="false"
     */
	
	public String getIsCourtLighted() {
		return isCourtLighted;
	}
	
	public void setIsCourtLighted(String isCourtLighted) {
		this.isCourtLighted = isCourtLighted;
	}

	/**
     * @hibernate.property column="numberOfCourts" not-null="false"
     */
	public String getNumberOfCourts() {
		return numberOfCourts;
	}


	public void setNumberOfCourts(String numberOfCourts) {
		this.numberOfCourts = numberOfCourts;
	}

	/**
     * @hibernate.property column="openCourtMeridiem" not-null="false"
     */
	public String getOpenCourtMeridiem() {
		return openCourtMeridiem;
	}
	public void setOpenCourtMeridiem(String openCourtMeridiem) {
		this.openCourtMeridiem = openCourtMeridiem;
	}

	/**
     * @hibernate.property column="openCourtHour" not-null="false"
     */
	public String getOpenCourtHour() {
		return openCourtHour;
	}

	public void setOpenCourtHour(String openCourtHour) {
		this.openCourtHour = openCourtHour;
	}

	/**
     * @hibernate.property column="closeCourtMeridiem" not-null="false"
     */
	public String getCloseCourtMeridiem() {
		return closeCourtMeridiem;
	}

	public void setCloseCourtMeridiem(String closeCourtMeridiem) {
		this.closeCourtMeridiem = closeCourtMeridiem;
	}
	/**
     * @hibernate.property column="closeCourtHour" not-null="false"
     */
	public String getCloseCourtHour() {
		return closeCourtHour;
	}

	public void setCloseCourtHour(String closeCourtHour) {
		this.closeCourtHour = closeCourtHour;
	}

	/**
     * @hibernate.property column="court_verified" not-null="true"
     */
	public boolean isCourtVerified() {
		return courtVerified;
	}

	public void setCourtVerified(boolean courtVerified) {
		this.courtVerified = courtVerified;
	}

	public String getSelectCourt() {
		return selectCourt;
	}

	public void setSelectCourt(String selectCourt) {
		this.selectCourt = selectCourt;
	}

}
