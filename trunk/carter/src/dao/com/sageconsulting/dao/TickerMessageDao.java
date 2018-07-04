/*
 * TickerMessageDao.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao;

import java.util.List;

import com.sageconsulting.model.TickerMessage;

public interface TickerMessageDao extends Dao
{
    public TickerMessage getTickerMessage(Long id);
    
    public List<TickerMessage> getTickerMessagesForCity(Long cityId);

    public void saveTickerMessage(TickerMessage msg);
    
    public void removeTickerMessage(Long id);
}
