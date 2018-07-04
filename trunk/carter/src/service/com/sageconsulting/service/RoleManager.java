/*
 * RoleManager.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service;

import com.sageconsulting.model.Role;

import java.util.List;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 */
public interface RoleManager extends Manager
{
    public List<Role> getRoles(Role role);

    public Role getRole(String rolename);

    public void saveRole(Role role);

    public void removeRole(String rolename);
}
