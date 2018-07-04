/*
 * RoleDao.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao;

import java.util.List;

import com.sageconsulting.model.Role;

/**
 * Role Data Access Object (DAO) interface.
 */
public interface RoleDao extends Dao
{
    /**
     * Gets role information based on rolename
     * 
     * @param rolename
     *            the rolename
     * @return role populated role object
     */
    public Role getRoleByName(String rolename);

    /**
     * Gets a list of roles based on parameters passed in.
     * 
     * @return List populated list of roles
     */
    public List<Role> getRoles(Role role);

    /**
     * Saves a role's information
     * 
     * @param role
     *            the object to be saved
     */
    public void saveRole(Role role);

    /**
     * Removes a role from the database by name
     * 
     * @param rolename
     *            the role's rolename
     */
    public void removeRole(String rolename);
}
