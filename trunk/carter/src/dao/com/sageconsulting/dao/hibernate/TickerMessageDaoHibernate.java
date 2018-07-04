/*
 * TickerMessageDaoHibernate.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao.hibernate;

import java.util.List;

import com.sageconsulting.dao.TickerMessageDao;
import com.sageconsulting.model.TickerMessage;

public class TickerMessageDaoHibernate extends BaseDaoHibernate implements TickerMessageDao
{
    public TickerMessage getTickerMessage(Long id)
    {
        return (TickerMessage)getHibernateTemplate().get(TickerMessage.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<TickerMessage> getTickerMessagesForCity(Long cityId)
    {
        return getHibernateTemplate().find("from TickerMessage tm where tm.city.id = ? order by tm.id", cityId); //$NON-NLS-1$
    }

    public void saveTickerMessage(TickerMessage msg)
    {
        getHibernateTemplate().saveOrUpdate(msg);
    }

    public void removeTickerMessage(Long id)
    {
        getHibernateTemplate().delete(getTickerMessage(id));
    }
}
