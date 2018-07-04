/*
 * StateTag.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.displaytag.tags.el.ExpressionEvaluator;

import com.sageconsulting.model.LabelValue;

/**
 * Tag for creating multiple &lt;select&gt; options for displaying a list of
 * stage names.
 * 
 * <p>
 * <b>NOTE</b> - This tag requires a Java2 (JDK 1.2 or later) platform.
 * </p>
 * 
 * @jsp.tag name="state" bodycontent="empty"
 */
public class StateTag extends TagSupport
{
	private static final long serialVersionUID = 4947665517880507778L;

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
     * Property used to simply stuff the list of states into a specified
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

        LabelValue[] states = this.getStateList();

        if (this.scope != null)
        {
            if (this.scope.equals("page")) //$NON-NLS-1$
            {
                this.pageContext.setAttribute(this.name, states);
            }
            else if (this.scope.equals("request")) //$NON-NLS-1$
            {
                this.pageContext.getRequest().setAttribute(this.name, states);
            }
            else if (this.scope.equals("session")) //$NON-NLS-1$
            {
                this.pageContext.getSession().setAttribute(this.name, states);
            }
            else if (this.scope.equals("application")) //$NON-NLS-1$
            {
                this.pageContext.getServletContext().setAttribute(this.name, states);
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

            for (LabelValue state : states)
            {
                sb.append("    <option value=\"" + state.getValue() + "\""); //$NON-NLS-1$ //$NON-NLS-2$

                if ((this.selected != null) && this.selected.equals(state.getValue()))
                {
                    sb.append(" selected=\"selected\""); //$NON-NLS-1$
                }

                sb.append(">" + state.getLabel() + "</option>\n"); //$NON-NLS-1$ //$NON-NLS-2$
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
     * Build a List of LabelValues for all the available states. Uses the two
     * letter uppercase ISO name of the state as the value and the 
     * state name as the label.
     * 
     * 
     * @return List of LabelValues for all available states.
     */
    protected LabelValue[] getStateList()
    {
        LabelValue states []= new LabelValue[] { 
			new LabelValue("Alabama", "AL"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Alaska", "AK"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Arizona", "AZ"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Arkansas", "AR"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("California", "CA"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Colorado", "CO"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Connecticut", "CT"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Delaware", "DE"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("District Of Columbia", "DC"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Florida", "FL"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Georgia", "GA"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Hawaii", "HI"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Idaho", "ID"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Illinois", "IL"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Indiana", "IN"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Iowa", "IA"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Kansas", "KS"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Kentucky", "KY"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Louisiana", "LA"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Maine", "ME"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Maryland", "MD"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Massachusetts", "MA"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Michigan", "MI"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Minnesota", "MN"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Mississippi", "MS"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Missouri", "MO"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Montana", "MT"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Nebraska", "NE"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Nevada", "NV"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("New Hampshire", "NH"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("New Jersey", "NJ"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("New Mexico", "NM"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("New York", "NY"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("North Carolina", "NC"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("North Dakota", "ND"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Ohio", "OH"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Oklahoma", "OK"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Oregon", "OR"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Pennsylvania", "PA"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Rhode Island", "RI"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("South Carolina", "SC"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("South Dakota", "SD"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Tennessee", "TN"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Texas", "TX"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Utah", "UT"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Vermont", "VT"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Virginia", "VA"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Washington", "WA"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("West Virginia", "WV"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Wisconsin", "WI"), //$NON-NLS-1$ //$NON-NLS-2$
			new LabelValue("Wyoming", "WY") //$NON-NLS-1$ //$NON-NLS-2$
        };
        
        return states;
    }
}
