/*
 * PrivateMessageManagerImpl.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service.impl;

import java.util.List;

import com.sageconsulting.dao.PrivateMessageDao;
import com.sageconsulting.model.PrivateMessage;
import com.sageconsulting.service.PrivatemessageManager;

public class PrivateMessageManagerImpl extends BaseManager implements PrivatemessageManager
{

    public void setPrivateMessageDao(PrivateMessageDao pmDao)
    {
        super.setDao(pmDao);
    }

    private PrivateMessageDao getPrivateMessageDao()
    {
        return (PrivateMessageDao)this.dao;
    }

    public void deletePrivateMessage(Long id)
    {
        this.getPrivateMessageDao().deletePrivateMessage(id);
    }

    public List<PrivateMessage> getAllPrivateMessages(Long userid)
    {
        return this.getPrivateMessageDao().getAllPrivateMessages(userid);
    }

    public List<PrivateMessage> getNewPrivateMessages(Long userid)
    {
        return this.getPrivateMessageDao().getNewPrivateMessages(userid);
    }

    public PrivateMessage getPrivateMessagesByID(Long id)
    {
        return this.getPrivateMessageDao().getPrivateMessagesByID(id);
    }

    public void markPrivateMessageAsRead(Long id)
    {
        this.getPrivateMessageDao().markPrivateMessageAsRead(id);

    }

    public void sendPrivateMessage(PrivateMessage mail)
    {
        this.getPrivateMessageDao().sendPrivateMessage(mail);
    }

    public int getNumberNewMessages(Long userid)
    {
        List<PrivateMessage> list = getNewPrivateMessages(userid);
        int number = 0;
        if (list != null)
        {
            return list.size();
        }

        return number;
    }

    public List<PrivateMessage> getAllMessageFromAllUsers()
    {
        return this.getPrivateMessageDao().getAllMessageFromAllUsers();
    }

}
