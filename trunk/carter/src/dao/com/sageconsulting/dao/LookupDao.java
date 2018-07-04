/*
 * LookupDao.java
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
 * Lookup Data Access Object (Dao) interface. This is used to lookup values in
 * the database (i.e. for drop-downs).
 */
public interface LookupDao extends Dao
{
    public List<Role> getRoles();
}
