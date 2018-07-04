/*
 * CurrencyConverter.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.util;

import java.text.DecimalFormat;
import java.text.ParseException;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This class is converts a Double to a double-digit String (and vise-versa) by
 * BeanUtils when copying properties. Registered for use in BaseAction.
 */
public class CurrencyConverter implements Converter
{
    protected final Log log = LogFactory.getLog(CurrencyConverter.class);

    protected final DecimalFormat formatter = new DecimalFormat("###,###.00"); //$NON-NLS-1$

    /**
     * Convert a String to a Double and a Double to a String
     * 
     * @param type the class type to output
     * @param value the object to convert
     * @return object the converted object (Double or String)
     */
    @SuppressWarnings("unchecked")
    public final Object convert(final Class type, final Object value)
    {
        // for a null value, return null
        if (value == null)
        {
            return null;
        }
        if (value instanceof String)
        {
            if (this.log.isDebugEnabled())
            {
                this.log.debug("value (" + value + ") instance of String"); //$NON-NLS-1$ //$NON-NLS-2$
            }

            try
            {
                if (StringUtils.isBlank(String.valueOf(value)))
                {
                    return null;
                }

                if (this.log.isDebugEnabled())
                {
                    this.log.debug("converting '" + value + "' to a decimal"); //$NON-NLS-1$ //$NON-NLS-2$
                }

                // formatter.setDecimalSeparatorAlwaysShown(true);
                Number num = this.formatter.parse(String.valueOf(value));

                return new Double(num.doubleValue());
            }
            catch (ParseException pe)
            {
                pe.printStackTrace();
            }
        }
        else if (value instanceof Double)
        {
            if (this.log.isDebugEnabled())
            {
                this.log.debug("value (" + value + ") instance of Double"); //$NON-NLS-1$ //$NON-NLS-2$
                this.log.debug("returning double: " + this.formatter.format(value)); //$NON-NLS-1$
            }

            return this.formatter.format(value);
        }

        throw new ConversionException("Could not convert " + value + " to " + type.getName() + "!"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }
}
