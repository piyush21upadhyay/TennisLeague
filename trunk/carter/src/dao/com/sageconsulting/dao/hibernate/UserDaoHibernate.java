/*
 * UserDaoHibernate.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UserDetailsService;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.springframework.orm.ObjectRetrievalFailureException;

import com.sageconsulting.dao.UserDao;
import com.sageconsulting.model.User;

/**
 * This class interacts with Spring's HibernateTemplate to save/delete and
 * retrieve User objects.
 */
public class UserDaoHibernate extends BaseDaoHibernate implements UserDao, UserDetailsService
{
	private static final double MIN_HANDICAP = -20.0;
	private static final double MAX_HANDICAP = 100.0;
	
    /**
     * @see com.sageconsulting.dao.UserDao#getUser(Long)
     */
    public User getUser(Long userId)
    {
        User user = (User) getHibernateTemplate().get(User.class, userId);

        if (user == null)
        {
            this.log.warn("uh oh, user '" + userId + "' not found..."); //$NON-NLS-1$ //$NON-NLS-2$
            throw new ObjectRetrievalFailureException(User.class, userId);
        }

        return user;
    }

    /**
     * @see com.sageconsulting.dao.UserDao#getUsers(com.sageconsulting.model.User)
     */
    @SuppressWarnings("unchecked")
    public List<User> getUsers(User user)
    {
        return getHibernateTemplate().find("from User u order by upper(u.username)"); //$NON-NLS-1$
    }

    /**
     * @see com.sageconsulting.dao.UserDao#saveUser(com.sageconsulting.model.User)
     */
    public void saveUser(final User user)
    {
        if (this.log.isDebugEnabled())
        {
            this.log.debug("user's id: " + user.getId()); //$NON-NLS-1$
        }

        getHibernateTemplate().saveOrUpdate(user);
        // necessary to throw a DataIntegrityViolation and catch it in UserManager
        getHibernateTemplate().flush();
    }

    /**
     * @see com.sageconsulting.dao.UserDao#removeUser(Long)
     */
    public void removeUser(Long userId)
    {
        getHibernateTemplate().delete(getUser(userId));
    }

    /**
     * @see org.acegisecurity.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    
    @SuppressWarnings("unchecked")
    public List<User> getUserByUsername2(String username) 
    
    {
    	List<User> users=null;
    	
    	try{
			users = getHibernateTemplate().find("from User where username=?", username); //$NON-NLS-1$
			if ((users == null) || users.isEmpty())
			{
				throw new UsernameNotFoundException("user '" + username + "' not found..."); //$NON-NLS-1$ //$NON-NLS-2$
			}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		
		return users;
    }
    
    @SuppressWarnings("unchecked")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        List<User> users = getHibernateTemplate().find("from User where username=?", username); //$NON-NLS-1$
        if ((users == null) || users.isEmpty())
        {
            throw new UsernameNotFoundException("user '" + username + "' not found..."); //$NON-NLS-1$ //$NON-NLS-2$
        }
        return users.get(0);
    }

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
    @SuppressWarnings("unchecked")
    public List<User> findUsers(String firstName, String lastName)
    {
        if ((null == firstName) && (null == lastName))
        {
            return new ArrayList<User>();
        }

        StringBuilder sb = new StringBuilder();
        if ((null != firstName) && (firstName.length() > 0))
        {
            sb.append("u.firstName like '").append(firstName).append("%' "); //$NON-NLS-1$ //$NON-NLS-2$
        }
        if ((null != lastName) && (lastName.length() > 0))
        {
            if (sb.length() > 0)
            {
                sb.append("and "); //$NON-NLS-1$
            }
            sb.append("u.lastName like '").append(lastName).append("%'"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        
        sb.append(" and 1 not in elements(u.roles)"); //$NON-NLS-1$
        
        if (sb.length() > 0)
        {
            sb.insert(0, "where "); //$NON-NLS-1$
        }
        sb.insert(0, "from User u "); //$NON-NLS-1$
        
        return getHibernateTemplate().find(sb.toString());
    }
    
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
    @SuppressWarnings("unchecked")
    public List<User> findUsers(String firstName, String lastName, Double minHandicap, Double maxHandicap)
    {
        if ((null == firstName) && (null == lastName) && (null == minHandicap) && (null == maxHandicap))
        {
            return new ArrayList<User>();
        }

        StringBuilder sb = new StringBuilder();
        if ((null != firstName) && (firstName.length() > 0))
        {
            sb.append("u.firstName like '").append(firstName).append("%' "); //$NON-NLS-1$ //$NON-NLS-2$
        }
        if ((null != lastName) && (lastName.length() > 0))
        {
            if (sb.length() > 0)
            {
                sb.append("and "); //$NON-NLS-1$
            }
            sb.append("u.lastName like '").append(lastName).append("%'"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        
        Double min = (null == minHandicap) ? Double.valueOf(MIN_HANDICAP) : minHandicap;
        if (sb.length() > 0)
        {
            sb.append(" and "); //$NON-NLS-1$
        }
        sb.append("u.handicap > ").append(min); //$NON-NLS-1$
        
        Double max = (null == maxHandicap) ? Double.valueOf(MAX_HANDICAP) : maxHandicap;
        sb.append(" and u.handicap < ").append(max); //$NON-NLS-1$
        
        sb.append(" and 1 not in elements(u.roles)"); //$NON-NLS-1$
        
        if (sb.length() > 0)
        {
            sb.insert(0, "where "); //$NON-NLS-1$
        }
        sb.insert(0, "from User u "); //$NON-NLS-1$
        
        return getHibernateTemplate().find(sb.toString());
    }
    
    /**
     * Find users by their name(s).  If both parameters are null then an empty list will be
     * returned.  If both are empty strings, then all users will be returned.  Otherwise
     * it will return users in which their names start with the specified strings.  Both
     * must much for there to be a match.  This will also check the handicap range.  Either
     * or both of the handicaps can be null which means it is not constrained.
     * @param cityId The id of the city to get users for.
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
    @SuppressWarnings("unchecked")
    public List<User> findUsers(Long cityId, String firstName, String lastName, Double minHandicap, Double maxHandicap)
    {
        if ((null == firstName) && (null == lastName) && (null == minHandicap) && (null == maxHandicap))
        {
            return new ArrayList<User>();
        }

        StringBuilder sb = new StringBuilder();
        if (null != cityId)
        {
        	sb.append("u.registeredCity.id=").append(cityId).append(" "); //$NON-NLS-1$ //$NON-NLS-2$
        }
        if ((null != firstName) && (firstName.length() > 0))
        {
            if (sb.length() > 0)
            {
                sb.append("and "); //$NON-NLS-1$
            }
            sb.append("u.firstName like '").append(firstName).append("%' "); //$NON-NLS-1$ //$NON-NLS-2$
        }
        if ((null != lastName) && (lastName.length() > 0))
        {
            if (sb.length() > 0)
            {
                sb.append("and "); //$NON-NLS-1$
            }
            sb.append("u.lastName like '").append(lastName).append("%'"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        
        Double min = (null == minHandicap) ? Double.valueOf(MIN_HANDICAP) : minHandicap;
        if (sb.length() > 0)
        {
            sb.append(" and "); //$NON-NLS-1$
        }
        sb.append("u.handicap > ").append(min); //$NON-NLS-1$
        
        Double max = (null == maxHandicap) ? Double.valueOf(MAX_HANDICAP) : maxHandicap;
        sb.append(" and u.handicap < ").append(max); //$NON-NLS-1$
        
        sb.append(" and 1 not in elements(u.roles)"); //$NON-NLS-1$
        
        if(minHandicap != null)
        	sb.append(" order by u.handicap asc");
        else if((maxHandicap != null) && (maxHandicap.doubleValue() != Double.valueOf(MAX_HANDICAP)))
        	sb.append(" order by u.handicap asc");
        else
        	sb.append(" order by u.firstName, u.lastName, u.handicap");
        if (sb.length() > 0)
        {
            sb.insert(0, "where "); //$NON-NLS-1$
        }
        sb.insert(0, "from User u "); //$NON-NLS-1$
        
        return getHibernateTemplate().find(sb.toString());
    }
    
    /**
     * Evict the specified user from the session cache.
     * @param user The user object to evict from the session cache
     */
    public void evictUser(User user)
    {
    	super.getHibernateTemplate().evict(user);
    }
    
    /**
     * Return true if there is already a user with the specified username and falise if not.
     * @return true if there is already a user with the specified username and false if not.
     */
    @SuppressWarnings("unchecked")
	public boolean isUsernameInUse(String username)
    {
        List<User> users = getHibernateTemplate().find("from User where username=?", username); //$NON-NLS-1$
        return users.size() > 0;
    }
    
    /**
     * Return true if there is already a user with the specified email and false if not.
     * @return true if there is already a user with the specified email and false if not.
     */
    @SuppressWarnings("unchecked")
	public boolean isEmailInUse(String email)
    {
        List<User> users = getHibernateTemplate().find("from User where email=?", email); //$NON-NLS-1$
        return users.size() > 0;
    }
    
    /**
     * Return true if there is already a user with the specified ghin number and falise if not.
     * @return true if there is already a user with the specified ghin number and false if not.
     */
    @SuppressWarnings("unchecked")
	public boolean isGhinNumberInUse(String ghin)
    {
        List<User> users = getHibernateTemplate().find("from User where ghinNumber=?", ghin); //$NON-NLS-1$
        return users.size() > 0;
    }
    
    public void updateChampionIcon(User user)
    {
    	getHibernateTemplate().saveOrUpdate(user);
    }
}
