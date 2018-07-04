/*
 * TimestampConverter.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.lang.StringUtils;

/**
 * This class is converts a java.util.Date to a String and a String to a
 * java.util.Date for use as a Timestamp. It is used by BeanUtils when copying
 * properties.
 */
public class TimestampConverter extends DateConverter
{
    public static final String TS_FORMAT = DateUtil.getDatePattern() + " HH:mm:ss.S"; //$NON-NLS-1$

    @SuppressWarnings("unchecked")
    protected Object convertToDate(Class type, Object value)
    {
        DateFormat df = new SimpleDateFormat(TS_FORMAT);
        if (value instanceof String)
        {
            try
            {
                if (StringUtils.isEmpty(value.toString()))
                {
                    return null;
                }

                return df.parse((String) value);
            }
            catch (Exception pe)
            {
                throw new ConversionException("Error converting String to Timestamp"); //$NON-NLS-1$
            }
        }

        throw new ConversionException("Could not convert " + value.getClass().getName() +  //$NON-NLS-1$
            " to " + type.getName()); //$NON-NLS-1$
    }

    @Override
    protected Object convertToString(Object value)
    {
        DateFormat df = new SimpleDateFormat(TS_FORMAT);
        if (value instanceof Date)
        {
            try
            {
                return df.format(value);
            }
            catch (Exception e)
            {
                throw new ConversionException("Error converting Timestamp to String"); //$NON-NLS-1$
            }
        }

        return value.toString();
    }
}
