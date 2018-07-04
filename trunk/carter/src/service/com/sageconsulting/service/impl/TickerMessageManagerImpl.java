/*
 * TickerMessageManagerImpl.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service.impl;

import java.util.List;

import com.sageconsulting.dao.TickerMessageDao;
import com.sageconsulting.model.TickerMessage;
import com.sageconsulting.service.TickerMessageManager;

public class TickerMessageManagerImpl extends BaseManager implements TickerMessageManager
{
    public void setTickerMessageDao(TickerMessageDao cdao)
    {
        super.setDao(cdao);
    }
    
    private TickerMessageDao getTickerMessageDao()
    {
        return (TickerMessageDao)super.dao;
    }
    
    public TickerMessage getTickerMessage(Long id)
    {
        return getTickerMessageDao().getTickerMessage(id);
    }

    public List<TickerMessage> getTickerMessagesForCity(Long cityId)
    {
        return getTickerMessageDao().getTickerMessagesForCity(cityId);
    }

    public void saveTickerMessage(TickerMessage msg)
    {
        getTickerMessageDao().saveTickerMessage(msg);
    }

    public void removeTickerMessage(Long id)
    {
        getTickerMessageDao().removeTickerMessage(id);
    }
}
