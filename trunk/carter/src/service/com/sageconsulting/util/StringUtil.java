/*
 * StringUtil.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.util;

import java.security.MessageDigest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * String Utility Class This is used to encode passwords programmatically
 */
public class StringUtil
{
    private final static Log log = LogFactory.getLog(StringUtil.class);

    /**
     * Encode a string using algorithm specified in web.xml and return the
     * resulting encrypted password. If exception, the plain credentials string
     * is returned
     * 
     * @param password
     *            Password or other credentials to use in authenticating this
     *            username
     * @param algorithm
     *            Algorithm used to do the digest
     * 
     * @return encypted password based on the algorithm.
     */
    public static String encodePassword(String password, String algorithm)
    {
        byte[] unencodedPassword = password.getBytes();

        MessageDigest md = null;

        try
        {
            // first create an instance, given the provider
            md = MessageDigest.getInstance(algorithm);
        }
        catch (Exception e)
        {
            log.error("Exception: " + e); //$NON-NLS-1$

            return password;
        }

        md.reset();

        // call the update method one or more times
        // (useful when you don't know the size of your data, eg. stream)
        md.update(unencodedPassword);

        // now calculate the hash
        byte[] encodedPassword = md.digest();

        StringBuffer buf = new StringBuffer();

        for (byte element : encodedPassword)
        {
            if ((element & 0xff) < 0x10)
            {
                buf.append("0"); //$NON-NLS-1$
            }

            buf.append(Long.toString(element & 0xff, 16));
        }

        return buf.toString();
    }
}
