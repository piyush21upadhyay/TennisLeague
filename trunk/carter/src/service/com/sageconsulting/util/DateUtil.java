/*
 * DateUtil.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sageconsulting.Constants;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * Date Utility Class This is used to convert Strings to Dates and Timestamps
 */
public class DateUtil
{
    private static Log log = LogFactory.getLog(DateUtil.class);

    private static String defaultDatePattern = null;

    private static String timePattern = "HH:mm"; //$NON-NLS-1$
    
    public static final long MS_IN_DAY = 86400000;


    /**
     * Return default datePattern (MM/dd/yyyy)
     * 
     * @return a string representing the date pattern on the UI
     */
    public static String getDatePattern()
    {
        Locale locale = LocaleContextHolder.getLocale();
        try
        {
            defaultDatePattern = ResourceBundle.getBundle(Constants.BUNDLE_KEY, locale).getString("date.format"); //$NON-NLS-1$
        }
        catch (MissingResourceException mse)
        {
            defaultDatePattern = "MM/dd/yyyy"; //$NON-NLS-1$
        }

        return defaultDatePattern;
    }

    public static String getDateTimePattern()
    {
        return DateUtil.getDatePattern() + " HH:mm:ss.S"; //$NON-NLS-1$
    }

    /**
     * This method attempts to convert an Oracle-formatted date in the form
     * dd-MMM-yyyy to mm/dd/yyyy.
     * 
     * @param aDate
     *            date from database as a string
     * @return formatted string for the ui
     */
    public static final String getDate(Date aDate)
    {
        SimpleDateFormat df = null;
        String returnValue = ""; //$NON-NLS-1$

        if (aDate != null)
        {
            df = new SimpleDateFormat(getDatePattern());
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * This method generates a string representation of a date/time in the
     * format you specify on input
     * 
     * @param aMask
     *            the date pattern the string is in
     * @param strDate
     *            a string representation of a date
     * @return a converted Date object
     * @see java.text.SimpleDateFormat
     * @throws ParseException
     */
    public static final Date convertStringToDate(String aMask, String strDate) throws ParseException
    {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(aMask);

        if (log.isDebugEnabled())
        {
            log.debug("converting '" + strDate + "' to date with mask '" + aMask + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        }

        try
        {
            date = df.parse(strDate);
        }
        catch (ParseException pe)
        {
            // log.error("ParseException: " + pe);
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return (date);
    }

    /**
     * This method returns the current date time in the format: MM/dd/yyyy HH:MM
     * a
     * 
     * @param theTime
     *            the current time
     * @return the current date/time
     */
    public static String getTimeNow(Date theTime)
    {
        return getDateTime(timePattern, theTime);
    }

    /**
     * This method returns the current date in the format: MM/dd/yyyy
     * 
     * @return the current date
     * @throws ParseException
     */
    public static Calendar getToday() throws ParseException
    {
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat(getDatePattern());

        // This seems like quite a hack (date -> string -> date),
        // but it works ;-)
        String todayAsString = df.format(today);
        Calendar cal = new GregorianCalendar();
        cal.setTime(convertStringToDate(todayAsString));

        return cal;
    }

    /**
     * This method generates a string representation of a date's date/time in
     * the format you specify on input
     * 
     * @param aMask
     *            the date pattern the string is in
     * @param aDate
     *            a date object
     * @return a formatted string representation of the date
     * 
     * @see java.text.SimpleDateFormat
     */
    public static final String getDateTime(String aMask, Date aDate)
    {
        SimpleDateFormat df = null;
        String returnValue = ""; //$NON-NLS-1$

        if (aDate == null)
        {
            log.error("aDate is null!"); //$NON-NLS-1$
        }
        else
        {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * This method generates a string representation of a date based on the
     * System Property 'dateFormat' in the format you specify on input
     * 
     * @param aDate
     *            A date to convert
     * @return a string representation of the date
     */
    public static final String convertDateToString(Date aDate)
    {
        return getDateTime(getDatePattern(), aDate);
    }

    /**
     * This method converts a String to a date using the datePattern
     * 
     * @param strDate
     *            the date to convert (in format MM/dd/yyyy)
     * @return a date object
     * 
     * @throws ParseException
     */
    public static Date convertStringToDate(String strDate) throws ParseException
    {
        Date aDate = null;

        try
        {
            if (log.isDebugEnabled())
            {
                log.debug("converting date with pattern: " + getDatePattern()); //$NON-NLS-1$
            }

            aDate = convertStringToDate(getDatePattern(), strDate);
        }
        catch (ParseException pe)
        {
            log.error("Could not convert '" + strDate + "' to a date, throwing exception"); //$NON-NLS-1$ //$NON-NLS-2$
            pe.printStackTrace();
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return aDate;
    }
    
    /**
     * Compute the number of days from today to the specified date.  Return 0 if the day
     * is already past.
     * @param d The date to compute the number of days to.
     * @return The number of days to the specified date or 0 if the date is past.
     */
    public static int computeDaysToDate(Date d)
    {
        /* Possibly erroneous code */
        /* 
	        Date now = new Date();
	        long today = now.getTime() / MS_IN_DAY;
	        long future = d.getTime() / MS_IN_DAY;
	        return (int)Math.max(0, future-today);
        */
		Calendar startDate = Calendar.getInstance();
		startDate.setTime(new Date());
		
		Calendar endDate = Calendar.getInstance();
		endDate.setTime(d);
		int daysBetween = 0;
		
		while (startDate.before(endDate)) {
			startDate.add(Calendar.DAY_OF_MONTH, 1);
			daysBetween++;
		}
		
		return daysBetween;
    }
    
    /**
     * Returns the suffix for date, like 'st', 'th', 'nd', etc.
     * @param d The date for which suffix is to be determined.
     * @return The suffix string to be used for date.
     */
    public static String getDateSuffix(Date d)
    {
    	String suffix = "";
    	String dateStr = convertDateToString(d);
    	
    	if(dateStr != null)
    	{
    		//date in MM/dd/yyyy format
    		String date = dateStr.substring(3, 5);
    		
    		try
    		{
    			String datePart = String.valueOf(Integer.parseInt(date));
    			char numChar1 = '0';
    			char numChar2 = ' ';
    			if(datePart.length() > 1)
    			{
    				numChar1 = datePart.charAt(0);
    				numChar2 = datePart.charAt(1);
    			}
    			else
    				numChar2 = datePart.charAt(0);
    			
    			switch(numChar2)
				{
					case '1':
						suffix = "st";
						break;
					case '2':
						suffix = "nd";
						break;
					case '3':
						suffix = "rd";
						break;
					default:
						suffix = "th";
				}
    			if(numChar1 == '1')
    				suffix = "th";
    		}
    		catch(NumberFormatException exp)
    		{
    			// Nothing to do here.
    		}
    	}
    	
    	return suffix;
    }

}
