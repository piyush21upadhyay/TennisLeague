/*
 * PublicMessageManagerImpl.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service.impl;

import java.util.List;

import com.sageconsulting.dao.PublicMessageDao;
import com.sageconsulting.model.PublicMessage;
import com.sageconsulting.service.PublicMessageManager;

public class PublicMessageManagerImpl extends BaseManager implements PublicMessageManager
{

    private PublicMessageDao getPublicMessageDao()
    {
        return (PublicMessageDao) this.dao;
    }

    public void setPublicMessageDao(PublicMessageDao publicMessageDao)
    {
        super.setDao(publicMessageDao);
    }

    public List<PublicMessage> getAllPublicMessages(Long cityId, Long courseId, String division)
    {
        // TODO Auto-generated method stub
        return this.getPublicMessageDao().getAllPublicMessages(cityId, courseId, division);
    }

    public void postPublicMessage(PublicMessage publicMessage)
    {
        // TODO Auto-generated method stub
        this.getPublicMessageDao().postPublicMessage(publicMessage);
    }

    public PublicMessage getPublicMessage(Long id)
    {
        // TODO Auto-generated method stub
        return getPublicMessageDao().getPublicMessage(id);
    }

    public void removePublicMessage(Long id)
    {
        // TODO Auto-generated method stub
        this.getPublicMessageDao().removePublicMessage(id);
    }

    public List<PublicMessage> getAllPublicMessages()
    {
        // TODO Auto-generated method stub
        return this.getPublicMessageDao().getAllPublicMessages();
    }

}
