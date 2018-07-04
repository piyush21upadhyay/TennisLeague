/*
 * LookupManagerImpl.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.sageconsulting.dao.LookupDao;
import com.sageconsulting.model.LabelValue;
import com.sageconsulting.model.Role;
import com.sageconsulting.service.LookupManager;

/**
 * Implementation of LookupManager interface to talk to the persistence layer.
 */
public class LookupManagerImpl extends BaseManager implements LookupManager
{
    private LookupDao lookupDao;

    public void setLookupDao(LookupDao theDao)
    {
        super.setDao(theDao);
        this.lookupDao = theDao;
    }

    /**
     * @see com.sageconsulting.service.LookupManager#getAllRoles()
     */
    public List<LabelValue> getAllRoles()
    {
        List<Role> roles = this.lookupDao.getRoles();
        List<LabelValue> list = new ArrayList<LabelValue>(roles.size());
        Role role = null;

        for (int i = 0; i < roles.size(); i++)
        {
            role = roles.get(i);
            list.add(new LabelValue(role.getName(), role.getName()));
        }

        return list;
    }
}
