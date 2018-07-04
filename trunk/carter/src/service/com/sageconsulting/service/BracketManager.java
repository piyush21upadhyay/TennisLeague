/*
 * BracketManager.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service;

import java.util.List;

import com.sageconsulting.model.BracketEntry;
import com.sageconsulting.model.Match;

public interface BracketManager
{
    public BracketEntry getBracketEntry(Long id);
    public void saveBracket(List<BracketEntry> bracket);
    public List<BracketEntry> getRoundOneBracketForSeason(Long seasonId);
    public void saveBracketEntry(BracketEntry entry);
    public  List<BracketEntry> getRound(Match match);
    public List<BracketEntry> getRound(Long seasonId);
}
