/*
 * UserDao.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao;

import java.util.List;

import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UsernameNotFoundException;

import com.sageconsulting.model.User;

/**
 * User Data Access Object (Dao) interface.
 */
public interface UserDao extends Dao
{
    /**
     * Gets users information based on user id.
     * 
     * @param userId
     *            the user's id
     * @return user populated user object
     */
    public User getUser(Long userId);

    /**
     * Gets users information based on login name.
     * 
     * @param username
     *            the user's username
     * @return userDetails populated userDetails object
     */
    public List<User> getUserByUsername2(String username);
    public List<User> getUserByUsernameOrEmail(String username);
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    /**
     * Gets a list of users based on parameters passed in.
     * 
     * @return List populated list of users
     */
    public List<User> getUsers(User user);

    /**
     * Saves a user's information
     * 
     * @param user
     *            the object to be saved
     */
    public void saveUser(User user);

    /**
     * Removes a user from the database by id
     * 
     * @param userId
     *            the user's id
     */
    public void removeUser(Long userId);
    
    /**
     * Find users by their name(s).  If both parameters are null then an empty list will be
     * returned.  If both are empty strings, then all users will be returned.  Otherwise
     * it will return users in which their names start with the specified strings.  Both
     * must much for there to be a match.
     * @param firstName The first name to search on.  This will find any first name that
     * starts with the specified value (case insensitive).  If it is null or empty it will
     * be ignored.
     * @param firstName The last name to search on.  This will find any last name that
     * starts with the specified value (case insensitive).  If it is null or empty it will
     * be ignored.
     * @return The list of users that match the specified criteria.
     */
    public List<User> findUsers(String firstName, String lastName);
    
    /**
     * Find users by their name(s).  If both parameters are null then an empty list will be
     * returned.  If both are empty strings, then all users will be returned.  Otherwise
     * it will return users in which their names start with the specified strings.  Both
     * must much for there to be a match.  This will also check the handicap range.  Either
     * or both of the handicaps can be null which means it is not constrained.
     * @param firstName The first name to search on.  This will find any first name that
     * starts with the specified value (case insensitive).  If it is null or empty it will
     * be ignored.
     * @param firstName The last name to search on.  This will find any last name that
     * starts with the specified value (case insensitive).  If it is null or empty it will
     * be ignored.
     * @param maxHandicap Don't find users with a handicap greater than specified.
     * @param minHandicap Don't find users with a handicap less than specified.
     * @return The list of users that match the specified criteria.
     */
    public List<User> findUsers(String firstName, String lastName, Double minHandicap, Double maxHandicap);
    
    /**
     * Find users by their name(s).  If both parameters are null then an empty list will be
     * returned.  If both are empty strings, then all users will be returned.  Otherwise
     * it will return users in which their names start with the specified strings.  Both
     * must much for there to be a match.  This will also check the handicap range.  Either
     * or both of the handicaps can be null which means it is not constrained.
     * @param cityId The id of the city the users must be from.
     * @param firstName The first name to search on.  This will find any first name that
     * starts with the specified value (case insensitive).  If it is null or empty it will
     * be ignored.
     * @param firstName The last name to search on.  This will find any last name that
     * starts with the specified value (case insensitive).  If it is null or empty it will
     * be ignored.
     * @param maxHandicap Don't find users with a handicap greater than specified.
     * @param minHandicap Don't find users with a handicap less than specified.
     * @return The list of users that match the specified criteria.
     */
    public List<User> findUsers(Long cityId, String firstName, String lastName, Double minHandicap, Double maxHandicap);
    
    /**
     * Evict the specified user from the session cache.
     * @param user The user object to evict from the session cache
     */
    public void evictUser(User user);
    
    /**
     * Return true if there is already a user with the specified username and falise if not.
     * @return true if there is already a user with the specified username and false if not.
     */
    public boolean isUsernameInUse(String username);
    
    /**
     * Return true if there is already a user with the specified email and falise if not.
     * @return true if there is already a user with the specified email and false if not.
     */
    public boolean isEmailInUse(String email);
    
    /**
     * Return true if there is already a user with the specified ghin number and falise if not.
     * @return true if there is already a user with the specified ghin number and false if not.
     */
    public boolean isGhinNumberInUse(String ghin);
    public void updateChampionIcon(User user);

	/**
	 * @param cityId
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param rating
	 * @param minRating
	 * @param maxRating
	 * @param dexterity
	 * @param matchPreference
	 * @param tournamentEntry
	 * @return
	 */
	public List<User> findUsers(Long cityId, String firstName, String lastName,
			String gender, Double rating, Double minRating, Double maxRating,
			String dexterity, String matchPreference, String tournamentEntry,String orderBy);
	
	public List<User> findUsers(Long cityId, Long courtId);
}
