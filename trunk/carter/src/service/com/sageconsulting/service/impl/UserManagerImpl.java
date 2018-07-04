/*
 * UserManagerImpl.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service.impl;

import java.util.List;

import org.acegisecurity.userdetails.UsernameNotFoundException;
import com.sageconsulting.dao.UserDao;
import com.sageconsulting.model.User;
import com.sageconsulting.service.UserExistsException;
import com.sageconsulting.service.UserManager;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * Implementation of UserManager interface.
 * </p>
 */
public class UserManagerImpl extends BaseManager implements UserManager
{
    private UserDao userDao;

    /**
     * Set the Dao for communication with the data layer.
     * 
     * @param uDao
     */
    public void setUserDao(UserDao uDao)
    {
        super.setDao(uDao);
        this.userDao = uDao;
    }

    /**
     * @see com.sageconsulting.service.UserManager#getUser(java.lang.String)
     */
    public User getUser(String userId)
    {
        return this.userDao.getUser(new Long(userId));
    }

    /**
     * @see com.sageconsulting.service.UserManager#getUsers(com.sageconsulting.model.User)
     */
    public List<User> getUsers(User user)
    {
        return this.userDao.getUsers(user);
    }

    /**
     * @see com.sageconsulting.service.UserManager#saveUser(com.sageconsulting.model.User)
     */
    public void saveUser(User user) throws UserExistsException
    {
        // if new user, lowercase userId
        if (user.getVersion() == null)
        {
            user.setUsername(user.getUsername().toLowerCase());
        }
        try
        {
            this.userDao.saveUser(user);
        }
        catch (DataIntegrityViolationException e)
        {
            throw new UserExistsException("User '" + user.getUsername() + "' already exists!"); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * @see com.sageconsulting.service.UserManager#removeUser(java.lang.String)
     */
    public void removeUser(String userId)
    {
        if (this.log.isDebugEnabled())
        {
            this.log.debug("removing user: " + userId); //$NON-NLS-1$
        }

        this.userDao.removeUser(new Long(userId));
    }

    public List<User> getUserByUsername1(String username) 
    {
        return  this.userDao.getUserByUsername2(username);
    }

    public User getUserByUsername(String username) throws UsernameNotFoundException
    {
        return (User) this.userDao.loadUserByUsername(username);
    }
    
    public List<User> findUsers(String firstName, String lastName)
    {
        return this.userDao.findUsers(firstName, lastName);
    }
    
    public List<User> findUsers(String firstName, String lastName, Double minHandicap, Double maxHandicap)
    {
        return this.userDao.findUsers(firstName, lastName, minHandicap, maxHandicap);
    }
    
    /**
     * Find all users in a given city matching the first and last name passed and handicap in the specified range.
     * @param cityId The id of the city to find users for.
     * @param firstName The first name (can be partial).
     * @param lastName The last name (can be partial).
     * @param minHandicap The minimum handicap to display.
     * @param maxHandicap The maximum handicatp to display
     * @return The list of users that match the seearch criteria.
     */
    public List<User> findUsers(Long cityId, String firstName, String lastName, Double minHandicap, Double maxHandicap)
    {
    	return this.userDao.findUsers(cityId, firstName, lastName, minHandicap, maxHandicap);
    }
    
    /**
     * Evict the specified user from the session cache.
     * @param user The user object to evict from the session cache
     */
    public void evictUser(User user)
    {
    	this.userDao.evictUser(user);
    }
    
    /**
     * Return true if there is already a user with the specified username and falise if not.
     * @return true if there is already a user with the specified username and false if not.
     */
    public boolean isUsernameInUse(String username)
    {
    	return this.userDao.isUsernameInUse(username);
    }
    
    /**
     * Return true if there is already a user with the specified email and falise if not.
     * @return true if there is already a user with the specified email and false if not.
     */
    public boolean isEmailInUse(String email)
    {
    	return this.userDao.isEmailInUse(email);
    }
    
    /**
     * Return true if there is already a user with the specified ghin number and falise if not.
     * @return true if there is already a user with the specified ghin number and false if not.
     */
    public boolean isGhinNumberInUse(String ghin)
    {
    	return this.userDao.isGhinNumberInUse(ghin);
    }
    
    public void updateChampionIcon(User user)
    {
        this.userDao.updateChampionIcon(user);
    }
}
