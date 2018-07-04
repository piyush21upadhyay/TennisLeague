/*
 * LabelValue.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.model;

import java.io.Serializable;
import java.util.Comparator;

/**
 * A simple JavaBean to represent label-value pairs. This is most commonly used
 * when constructing user interface elements which have a label to be displayed
 * to the user, and a corresponding value to be returned to the server. One
 * example is the <code>&lt;html:options&gt;</code> tag. <p/> <p/> Note: this
 * class has a natural ordering that is inconsistent with equals.
 * </p>
 * 
 * @see org.apache.struts.util.LabelValueBean
 */
public class LabelValue implements Comparable<LabelValue>, Serializable
{
    private static final long serialVersionUID = 3689355407466181430L;

    /**
     * Comparator that can be used for a case insensitive sort of
     * <code>LabelValue</code> objects.
     */
    public static final Comparator<LabelValue> CASE_INSENSITIVE_ORDER = new Comparator<LabelValue>()
    {
        public int compare(LabelValue lv1, LabelValue lv2)
        {
            String label1 = lv1.getLabel();
            String label2 = lv2.getLabel();
            return label1.compareToIgnoreCase(label2);
        }
    };

    /**
     * Default constructor.
     */
    public LabelValue()
    {
        super();
    }

    /**
     * Construct an instance with the supplied property values.
     * 
     * @param l
     *            The label to be displayed to the user.
     * @param v
     *            The value to be returned to the server.
     */
    public LabelValue(String l, String v)
    {
        this.label = l;
        this.value = v;
    }

    /**
     * The property which supplies the option label visible to the end user.
     */
    private String label = null;

    public String getLabel()
    {
        return this.label;
    }

    public void setLabel(String l)
    {
        this.label = l;
    }

    /**
     * The property which supplies the value returned to the server.
     */
    private String value = null;

    public String getValue()
    {
        return this.value;
    }

    public void setValue(String v)
    {
        this.value = v;
    }

    /**
     * Compare LabelValueBeans based on the label, because that's the human
     * viewable part of the object.
     * 
     * @see Comparable
     */
    public int compareTo(LabelValue lv)
    {
        String otherLabel = lv.getLabel();
        return this.getLabel().compareTo(otherLabel);
    }

    /**
     * Return a string representation of this object.
     */
    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer("LabelValue["); //$NON-NLS-1$
        sb.append(this.label);
        sb.append(", "); //$NON-NLS-1$
        sb.append(this.value);
        sb.append("]"); //$NON-NLS-1$
        return (sb.toString());
    }

    /**
     * LabelValueBeans are equal if their values are both null or equal.
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }

        if (!(obj instanceof LabelValue))
        {
            return false;
        }

        LabelValue bean = (LabelValue) obj;
        int nil = (this.getValue() == null) ? 1 : 0;
        nil += (bean.getValue() == null) ? 1 : 0;

        if (nil == 2)
        {
            return true;
        }
        else if (nil == 1)
        {
            return false;
        }
        else
        {
            return this.getValue().equals(bean.getValue());
        }

    }

    /**
     * The hash code is based on the object's value.
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        return (this.getValue() == null) ? 17 : this.getValue().hashCode();
    }
}
