/*
 * UserManager.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service;

import java.util.List;

import org.acegisecurity.userdetails.UsernameNotFoundException;

import com.sageconsulting.dao.UserDao;
import com.sageconsulting.model.User;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 */
public interface UserManager
{

    public void setUserDao(UserDao userDao);

    /**
     * Retrieves a user by userId. An exception is thrown if user not found
     * 
     * @param userId
     * @return User
     */
    public User getUser(String userId);

    /**
     * Finds a user by their username.
     * 
     * @param username
     * @return User a populated user object
     */
    public List<User> getUserByUsername1(String username);
    public User getUserByUsername(String username) throws UsernameNotFoundException;

    /**
     * Retrieves a list of users, filtering with parameters on a user object
     * 
     * @param user
     *            parameters to filter on
     * @return List
     */
    public List<User> getUsers(User user);

    /**
     * Saves a user's information
     * 
     * @param user
     *            the user's information
     * @throws UserExistsException
     */
    public void saveUser(User user) throws UserExistsException;

    /**
     * Removes a user from the database by their userId
     * 
     * @param userId
     *            the user's id
     */
    public void removeUser(String userId);
    
    /**
     * Find all users matching the first and last name passed in.
     * @param firstName The first name (can be partial).
     * @param lastName The last name (can be partial).
     * @return The list of users that match the seearch criteria.
     */
    public List<User> findUsers(String firstName, String lastName);
        
    /**
     * Find all users matching the first and last name passed and handicap in the specified range.
     * @param firstName The first name (can be partial).
     * @param lastName The last name (can be partial).
     * @param minHandicap The minimum handicap to display.
     * @param maxHandicap The maximum handicatp to display
     * @return The list of users that match the seearch criteria.
     */
    public List<User> findUsers(String firstName, String lastName, Double minHandicap, Double maxHandicap);
    
    /**
     * Find all users in a given city matching the first and last name passed and handicap in the specified range.
     * @param cityId The id of the city to find users for.
     * @param firstName The first name (can be partial).
     * @param lastName The last name (can be partial).
     * @param minHandicap The minimum handicap to display.
     * @param maxHandicap The maximum handicatp to display
     * @return The list of users that match the seearch criteria.
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

	public List<User> findTotalUsers(Long cityId, String firstname, String lastname,
			String gender, Double rating, Double minRating, Double maxRating,
			String dexterity, String matchPreference, String tournamentEntry, String orderBy);
}
