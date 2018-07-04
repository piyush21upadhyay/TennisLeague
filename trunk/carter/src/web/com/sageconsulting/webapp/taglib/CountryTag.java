/*
 * CountryTag.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.taglib;

import java.io.IOException;

import java.text.Collator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.sageconsulting.model.LabelValue;

import org.displaytag.tags.el.ExpressionEvaluator;

/**
 * Tag for creating multiple &lt;select&gt; options for displaying a list of
 * country names.
 * 
 * <p>
 * <b>NOTE</b> - This tag requires a Java2 (JDK 1.2 or later) platform.
 * </p>
 * 
 * @jsp.tag name="country" bodycontent="empty"
 */
public class CountryTag extends TagSupport
{
    private static final long serialVersionUID = 3905528206810167095L;

    private String name;
    private String prompt;
    private String scope;
    private String selected;

    /**
     * @param n The name to set.
     * 
     * @jsp.attribute required="false" rtexprvalue="true"
     */
    public void setName(String n)
    {
        this.name = n;
    }

    /**
     * @param p The prompt to set.
     * @jsp.attribute required="false" rtexprvalue="true"
     */
    public void setPrompt(String p)
    {
        this.prompt = p;
    }

    /**
     * @param s The selected option.
     * @jsp.attribute required="false" rtexprvalue="true"
     */
    public void setDefault(String s)
    {
        this.selected = s;
    }

    /**
     * Property used to simply stuff the list of countries into a specified
     * scope.
     * 
     * @param s
     * 
     * @jsp.attribute required="false" rtexprvalue="true"
     */
    public void setToScope(String s)
    {
        this.scope = s;
    }

    /**
     * Process the start of this tag.
     * 
     * @return int status
     * 
     * @exception JspException
     *                if a JSP exception has occurred
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     */
    @Override
    public int doStartTag() throws JspException
    {
        ExpressionEvaluator eval = new ExpressionEvaluator(this, this.pageContext);

        if (this.selected != null)
        {
            this.selected = eval.evalString("default", this.selected); //$NON-NLS-1$
        }

        Locale userLocale = this.pageContext.getRequest().getLocale();
        List<LabelValue> countries = this.buildCountryList(userLocale);

        if (this.scope != null)
        {
            if (this.scope.equals("page")) //$NON-NLS-1$
            {
                this.pageContext.setAttribute(this.name, countries);
            }
            else if (this.scope.equals("request")) //$NON-NLS-1$
            {
                this.pageContext.getRequest().setAttribute(this.name, countries);
            }
            else if (this.scope.equals("session")) //$NON-NLS-1$
            {
                this.pageContext.getSession().setAttribute(this.name, countries);
            }
            else if (this.scope.equals("application")) //$NON-NLS-1$
            {
                this.pageContext.getServletContext().setAttribute(this.name, countries);
            }
            else
            {
                throw new JspException("Attribute 'scope' must be: page, request, session or application"); //$NON-NLS-1$
            }
        }
        else
        {
            StringBuffer sb = new StringBuffer();
            sb.append("<select name=\"" + this.name + "\" id=\"" +  //$NON-NLS-1$ //$NON-NLS-2$
                this.name + "\" class=\"select\">\n"); //$NON-NLS-1$

            if (this.prompt != null)
            {
                sb.append("    <option value=\"\" selected=\"selected\">"); //$NON-NLS-1$
                sb.append(eval.evalString("prompt", this.prompt) + "</option>\n"); //$NON-NLS-1$ //$NON-NLS-2$
            }

            for (Iterator<LabelValue> i = countries.iterator(); i.hasNext();)
            {
                LabelValue country = i.next();
                sb.append("    <option value=\"" + country.getValue() + "\""); //$NON-NLS-1$ //$NON-NLS-2$

                if ((this.selected != null) && this.selected.equals(country.getValue()))
                {
                    sb.append(" selected=\"selected\""); //$NON-NLS-1$
                }

                sb.append(">" + country.getLabel() + "</option>\n"); //$NON-NLS-1$ //$NON-NLS-2$
            }

            sb.append("</select>"); //$NON-NLS-1$

            try
            {
                this.pageContext.getOut().write(sb.toString());
            }
            catch (IOException io)
            {
                throw new JspException(io);
            }
        }

        return super.doStartTag();
    }

    /**
     * Release aquired resources to enable tag reusage.
     * 
     * @see javax.servlet.jsp.tagext.Tag#release()
     */
    @Override
    public void release()
    {
        super.release();
    }

    /**
     * Build a List of LabelValues for all the available countries. Uses the two
     * letter uppercase ISO name of the country as the value and the localized
     * country name as the label.
     * 
     * @param locale
     *            The Locale used to localize the country names.
     * 
     * @return List of LabelValues for all available countries.
     */
    protected List<LabelValue> buildCountryList(Locale locale)
    {
        final String EMPTY = ""; //$NON-NLS-1$
        //final Locale[] available = Locale.getAvailableLocales();
        final Locale[] available = { Locale.US, Locale.CANADA, Locale.UK };

        List<LabelValue> countries = new ArrayList<LabelValue>();

        for (Locale element : available)
        {
            final String iso = element.getCountry();
            final String countryName = element.getDisplayCountry(locale);

            if (!EMPTY.equals(iso) && !EMPTY.equals(countryName))
            {
                LabelValue country = new LabelValue(countryName, iso);

                if (!countries.contains(country))
                {
                    countries.add(new LabelValue(countryName, iso));
                }
            }
        }

        Collections.sort(countries, new LabelValueComparator(locale));

        return countries;
    }

    /**
     * Class to compare LabelValues using their labels with locale-sensitive
     * behaviour.
     */
    public class LabelValueComparator implements Comparator<LabelValue>
    {
        private Collator c;

        /**
         * Creates a new LabelValueComparator object.
         * 
         * @param locale
         *            The Locale used for localized String comparison.
         */
        public LabelValueComparator(Locale locale)
        {
            this.c = Collator.getInstance(locale);
        }

        /**
         * Compares the localized labels of two LabelValues.
         * 
         * @param o1
         *            The first LabelValue to compare.
         * @param o2
         *            The second LabelValue to compare.
         * 
         * @return The value returned by comparing the localized labels.
         */
        public final int compare(LabelValue lhs, LabelValue rhs)
        {
            return this.c.compare(lhs.getLabel(), rhs.getLabel());
        }
    }
}
