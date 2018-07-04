/*
 * UnderParLeaderManager.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service;

import java.util.List;

import com.sageconsulting.model.UnderParLeader;

public interface UnderParLeaderManager
{
    public List<UnderParLeader> getUnderParLeaders(Long registrationId);
}
