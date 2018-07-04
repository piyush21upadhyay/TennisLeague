/*
 * LookupManager.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service;

import java.util.List;

import com.sageconsulting.dao.LookupDao;
import com.sageconsulting.model.LabelValue;

/**
 * Business Service Interface to talk to persistence layer and retrieve values
 * for drop-down choice lists.
 */
public interface LookupManager extends Manager
{
    public void setLookupDao(LookupDao dao);

    /**
     * Retrieves all possible roles from persistence layer
     * 
     * @return List
     */
    public List<LabelValue> getAllRoles();
}
