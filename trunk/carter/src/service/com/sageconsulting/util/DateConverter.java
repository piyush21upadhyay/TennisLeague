/*
 * DateConverter.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang.StringUtils;

/**
 * This class is converts a java.util.Date to a String and a String to a
 * java.util.Date.
 */
public class DateConverter implements Converter
{

    @SuppressWarnings("unchecked")
    public Object convert(Class type, Object value)
    {
        if (value == null)
        {
            return null;
        }
        else if (type == Timestamp.class)
        {
            return convertToDate(type, value, DateUtil.getDateTimePattern());
        }
        else if (type == Date.class)
        {
            return convertToDate(type, value, DateUtil.getDatePattern());
        }
        else if (type == String.class)
        {
            return convertToString(value);
        }

        throw new ConversionException("Could not convert " + value.getClass().getName() +  //$NON-NLS-1$
            " to " + type.getName()); //$NON-NLS-1$
    }

    @SuppressWarnings("unchecked")
    protected Object convertToDate(Class type, Object value, String pattern)
    {
        DateFormat df = new SimpleDateFormat(pattern);
        if (value instanceof String)
        {
            try
            {
                if (StringUtils.isEmpty(value.toString()))
                {
                    return null;
                }

                Date date = df.parse((String) value);
                if (type.equals(Timestamp.class))
                {
                    return new Timestamp(date.getTime());
                }
                return date;
            }
            catch (Exception pe)
            {
                pe.printStackTrace();
                throw new ConversionException("Error converting String to Date"); //$NON-NLS-1$
            }
        }

        throw new ConversionException("Could not convert " + value.getClass().getName() + //$NON-NLS-1$ 
            " to " + type.getName()); //$NON-NLS-1$
    }

    protected Object convertToString(Object value)
    {

        if (value instanceof Date)
        {
            DateFormat df = new SimpleDateFormat(DateUtil.getDatePattern());
            if (value instanceof Timestamp)
            {
                df = new SimpleDateFormat(DateUtil.getDateTimePattern());
            }

            try
            {
                return df.format(value);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                throw new ConversionException("Error converting Date to String"); //$NON-NLS-1$
            }
        }
        return value.toString();
    }
}
