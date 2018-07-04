/*
 * PublicMessageDaoHibernate.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.dao.hibernate;

import java.util.List;

import com.sageconsulting.dao.PublicMessageDao;
import com.sageconsulting.model.PublicMessage;

public class PublicMessageDaoHibernate extends BaseDaoHibernate implements PublicMessageDao
{

    @SuppressWarnings("unchecked")
    public List<PublicMessage> getAllPublicMessages(Long cityId, Long courseId, String division)
    {
    	// TODO: this needs to be updated to take into account division and home course
        return getHibernateTemplate().find(
            "from PublicMessage m where m.city.id = ? order by date DESC", //$NON-NLS-1$
            new Object[] { cityId });

    }

    @SuppressWarnings("unchecked")
    public List<PublicMessage> getAllPublicMessages()
    {
        return getHibernateTemplate().find("from PublicMessage m order by date DESC"); //$NON-NLS-1$

    }

    public void postPublicMessage(PublicMessage message)
    {
        getHibernateTemplate().save(message);
        getHibernateTemplate().flush();

    }

    public PublicMessage getPublicMessage(Long id)
    {
        return (PublicMessage) getHibernateTemplate().get(PublicMessage.class, id);
    }

    public void removePublicMessage(Long id)
    {
        getHibernateTemplate().delete(getPublicMessage(id));

    }
}
