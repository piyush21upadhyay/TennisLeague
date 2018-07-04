/*
 * RoleDaoHibernate.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao.hibernate;

import java.util.List;

import com.sageconsulting.dao.RoleDao;
import com.sageconsulting.model.Role;

/**
 * This class interacts with Spring's HibernateTemplate to save/delete and
 * retrieve Role objects.
 */
public class RoleDaoHibernate extends BaseDaoHibernate implements RoleDao
{

    @SuppressWarnings("unchecked")
    public List<Role> getRoles(Role role)
    {
        return getHibernateTemplate().find("from Role"); //$NON-NLS-1$
    }

    public Role getRole(Long roleId)
    {
        return (Role) getHibernateTemplate().get(Role.class, roleId);
    }

    @SuppressWarnings("unchecked")
    public Role getRoleByName(String rolename)
    {
        List<Role> roles = getHibernateTemplate().find("from Role where name=?", rolename); //$NON-NLS-1$
        if (roles.isEmpty())
        {
            return null;
        }
        return roles.get(0);
    }

    public void saveRole(Role role)
    {
        getHibernateTemplate().saveOrUpdate(role);
    }

    public void removeRole(String rolename)
    {
        Object role = getRoleByName(rolename);
        getHibernateTemplate().delete(role);
    }

}
