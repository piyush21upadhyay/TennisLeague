/*
 * DateConverterTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;

import junit.framework.TestCase;

public class DateConverterTest extends TestCase
{
    private DateConverter converter = new DateConverter();

    public void testInternationalization() throws Exception
    {
        List<Locale> locales = new ArrayList<Locale>()
        {
            private static final long serialVersionUID = 1L;
            {
                add(Locale.US);
                add(Locale.GERMANY);
                add(Locale.FRANCE);
                add(Locale.CHINA);
                add(Locale.ITALY);
            }
        };
        for (Iterator<Locale> localeIter = locales.iterator(); localeIter.hasNext();)
        {
            Locale locale = localeIter.next();
            LocaleContextHolder.setLocale(locale);
            testConvertStringToDate();
            testConvertDateToString();
            testConvertStringToTimestamp();
            testConvertTimestampToString();
        }
    }

    public void testConvertStringToDate() throws Exception
    {
        Date today = new Date();
        Calendar todayCalendar = new GregorianCalendar();
        todayCalendar.setTime(today);
        String datePart = DateUtil.convertDateToString(today);

        Date date = (Date) this.converter.convert(Date.class, datePart);

        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        assertEquals(todayCalendar.get(Calendar.YEAR), cal.get(Calendar.YEAR));
        assertEquals(todayCalendar.get(Calendar.MONTH), cal.get(Calendar.MONTH));
        assertEquals(todayCalendar.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.DAY_OF_MONTH));
    }

    public void testConvertDateToString() throws Exception
    {
        Calendar cal = new GregorianCalendar(2005, 00, 16);
        String date = (String) this.converter.convert(String.class, cal.getTime());
        assertEquals(DateUtil.convertDateToString(cal.getTime()), date);
    }

    public void testConvertStringToTimestamp() throws Exception
    {
        Date today = new Date();
        Calendar todayCalendar = new GregorianCalendar();
        todayCalendar.setTime(today);
        String datePart = DateUtil.convertDateToString(today);

        Timestamp time = (Timestamp) this.converter.convert(Timestamp.class, datePart + " 01:02:03.4"); //$NON-NLS-1$
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(time.getTime());
        assertEquals(todayCalendar.get(Calendar.YEAR), cal.get(Calendar.YEAR));
        assertEquals(todayCalendar.get(Calendar.MONTH), cal.get(Calendar.MONTH));
        assertEquals(todayCalendar.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.DAY_OF_MONTH));
    }

    public void testConvertTimestampToString() throws Exception
    {
        Timestamp timestamp = Timestamp.valueOf("2005-03-10 01:02:03.4"); //$NON-NLS-1$
        String time = (String) this.converter.convert(String.class, timestamp);
        assertEquals(DateUtil.getDateTime(DateUtil.getDateTimePattern(), timestamp), time);
    }

}
