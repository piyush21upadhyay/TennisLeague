/*
 * RoleManagerImpl.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service.impl;

import java.util.List;

import com.sageconsulting.dao.RoleDao;
import com.sageconsulting.model.Role;
import com.sageconsulting.service.RoleManager;

/**
 * Implementation of RoleManager interface.
 * </p>
 */
public class RoleManagerImpl extends BaseManager implements RoleManager
{
    private RoleDao roleDao;

    public void setRoleDao(RoleDao rDao)
    {
        super.setDao(rDao);
        this.roleDao = rDao;
    }

    public List<Role> getRoles(Role role)
    {
        return this.roleDao.getRoles(role);
    }

    public Role getRole(String rolename)
    {
        return this.roleDao.getRoleByName(rolename);
    }

    public void saveRole(Role role)
    {
        this.roleDao.saveRole(role);
    }

    public void removeRole(String rolename)
    {
        this.roleDao.removeRole(rolename);
    }
}
