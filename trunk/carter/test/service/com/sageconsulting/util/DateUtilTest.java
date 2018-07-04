/*
 * DateUtilTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.util;

import java.util.Date;
import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateUtilTest extends TestCase
{
    // ~ Instance fields
    // ========================================================

    private final Log log = LogFactory.getLog(DateUtilTest.class);

    // ~ Constructors
    // ===========================================================

    public DateUtilTest(String name)
    {
        super(name);
    }

    // public void testGetInternationalDatePattern() {
    // LocaleContextHolder.setLocale(new Locale("nl"));
    // assertEquals("dd-MMM-yyyy", DateUtil.getDatePattern());
    //       
    // LocaleContextHolder.setLocale(Locale.FRANCE);
    // assertEquals("dd/MM/yyyy", DateUtil.getDatePattern());
    //        
    // LocaleContextHolder.setLocale(Locale.GERMANY);
    // assertEquals("dd.MM.yyyy", DateUtil.getDatePattern());
    //        
    // // non-existant bundle should default to default locale
    // LocaleContextHolder.setLocale(new Locale("fi"));
    // String fiPattern = DateUtil.getDatePattern();
    // LocaleContextHolder.setLocale(Locale.getDefault());
    // String defaultPattern = DateUtil.getDatePattern();
    //        
    // assertEquals(defaultPattern, fiPattern);
    // }

    public void testGetDate() throws Exception
    {
        if (this.log.isDebugEnabled())
        {
            this.log.debug("db date to convert: " + new Date()); //$NON-NLS-1$
        }

        String date = DateUtil.getDate(new Date());

        if (this.log.isDebugEnabled())
        {
            this.log.debug("converted ui date: " + date); //$NON-NLS-1$
        }

        assertTrue(date != null);
    }

    public void testGetDateTime()
    {
        if (this.log.isDebugEnabled())
        {
            this.log.debug("entered 'testGetDateTime' method"); //$NON-NLS-1$
        }
        String now = DateUtil.getTimeNow(new Date());
        assertTrue(now != null);
        this.log.debug(now);
    }

    public static void main(String[] args)
    {
        junit.textui.TestRunner.run(DateUtilTest.class);
    }
}
