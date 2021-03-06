/*
 * PrivateMessageDaoHibernate.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao.hibernate;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.sageconsulting.dao.PrivateMessageDao;
import com.sageconsulting.model.PrivateMessage;

public class PrivateMessageDaoHibernate extends BaseDaoHibernate implements PrivateMessageDao
{
    public void deletePrivateMessage(Long id)
    {
        getHibernateTemplate().delete(getPrivateMessagesByID(id));
    }

    @SuppressWarnings("unchecked")
    public List<PrivateMessage> getAllPrivateMessages(Long userid)
    {
        return getHibernateTemplate().find("from PrivateMessage where to.id = ? order by dateSent desc", userid); //$NON-NLS-1$
    }

    @SuppressWarnings("unchecked")
    public List<PrivateMessage> getNewPrivateMessages(Long userid)
    {
        return getHibernateTemplate().
            find("from PrivateMessage where to.id = ? and dateRead is null order by dateSent desc", userid); //$NON-NLS-1$
    }

    public PrivateMessage getPrivateMessagesByID(Long id)
    {
        return (PrivateMessage) getHibernateTemplate().get(PrivateMessage.class, id);
    }

    public void markPrivateMessageAsRead(Long id)
    {
        PrivateMessage message = getPrivateMessagesByID(id);
        //message.setDateRead(new Timestamp(new Date().getTime()));
        message.setDateRead(getFormattedCurrentDateTime());
        getHibernateTemplate().saveOrUpdate(message);
        getHibernateTemplate().flush();
    }
    
    private Timestamp getFormattedCurrentDateTime()
    {
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date date = new Date();
        try {
			return new Timestamp(dateFormat.parse(dateFormat.format(date)).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;

    }

    public void sendPrivateMessage(PrivateMessage mail)
    {
        getHibernateTemplate().saveOrUpdate(mail);
        getHibernateTemplate().flush();
    }

    @SuppressWarnings("unchecked")
    public List<PrivateMessage> getAllMessageFromAllUsers()
    {
        return getHibernateTemplate().find("from PrivateMessage order by dateSent DESC"); //$NON-NLS-1$
    }

}
