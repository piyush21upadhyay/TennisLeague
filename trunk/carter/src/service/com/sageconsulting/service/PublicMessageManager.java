/*
 * PublicMessageManager.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.service;

import java.util.List;

import com.sageconsulting.model.PublicMessage;

public interface PublicMessageManager
{
    public List<PublicMessage> getAllPublicMessages(Long cityId, Long courseId, String division);

    public List<PublicMessage> getAllPublicMessages();

    public void postPublicMessage(PublicMessage message);

    public PublicMessage getPublicMessage(Long id);

    public void removePublicMessage(Long id);
}
