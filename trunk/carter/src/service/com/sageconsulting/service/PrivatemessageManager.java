/*
 * PrivatemessageManager.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service;

import java.util.List;

import com.sageconsulting.model.PrivateMessage;

public interface PrivatemessageManager extends Manager
{
    public List<PrivateMessage> getAllPrivateMessages(Long userid);

    public PrivateMessage getPrivateMessagesByID(Long id);

    public List<PrivateMessage> getNewPrivateMessages(Long userid);

    public void markPrivateMessageAsRead(Long id);

    public void deletePrivateMessage(Long id);

    public void sendPrivateMessage(PrivateMessage mail);

    public int getNumberNewMessages(Long userid);

    public List<PrivateMessage> getAllMessageFromAllUsers();
}
