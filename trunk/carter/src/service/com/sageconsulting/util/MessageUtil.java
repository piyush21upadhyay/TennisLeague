/*
 * MessageUtil.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.util;


public class MessageUtil
{
    
	/**
	 * Add a prefix to the subject of a message if it isn't already there and return it.
	 * @param oldSubject The original subject.
	 * @param prefix The prefix to add to it.
	 * @return The updated subject line.
	 */
    public static String getSubject(String oldSubject, String prefix)
    {
    	if (oldSubject.startsWith(prefix))
    	{
    		return oldSubject;
    	}
    	return prefix + oldSubject;
    }
    
    /**
     * Quote a message for "reply to" functionality.
     * @param msg The message to quote.
     * @return The quoted message.
     */
    public static String quotePreviousMessage(String msg)
    {
        String token = "> "; //$NON-NLS-1$
        StringBuilder sb = new StringBuilder(msg);
        sb.insert(0, "\r\n\r\n\r\n"); //$NON-NLS-1$
        int curIndex = 5;
        while (curIndex >= 0)
        {
            sb.insert(curIndex+1, token);
            curIndex = sb.indexOf("\n", curIndex+1); //$NON-NLS-1$
        }
        return sb.toString();
    }
}
