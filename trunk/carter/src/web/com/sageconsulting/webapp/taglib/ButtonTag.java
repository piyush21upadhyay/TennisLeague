/*
 * ButtonTag.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

/**
 * This class is used to generate a styled button using html and css
 * using a <button> tag.
 * 
 * <p>
 * It is designed to be used as follows:
 * 
 * <pre>
 * &lt;tag:button key=&quot;userForm.username&quot; page="/page.html" param="id=5"/&gt;
 * </pre>
 * 
 * @jsp.tag name="button" bodycontent="empty"
 */
public class ButtonTag extends BaseResourceTag
{
	private static final long serialVersionUID = -5814629717405482145L;
	
	private String pageEL;
	private String paramEL;
	private String fillEL;
	private String nameEL;
	private String onclick;
	private String styleClass;

	@Override
	public int doStartTag() throws JspException
	{
        String text = getResourceString();
		StringBuilder button = new StringBuilder();
		button.append("<div class=\"buttonwrapper\">"); //$NON-NLS-1$
		button.append("<a href=\""); //$NON-NLS-1$
		if (null == this.pageEL)
		{
			button.append("javascript:{}"); //$NON-NLS-1$
		}
		else
		{
	        Object page = ExpressionEvaluatorManager.evaluate("page", this.pageEL, //$NON-NLS-1$
            	String.class, this, super.pageContext );
			button.append(page);
			
			if (null != this.paramEL)
			{
		        Object param = ExpressionEvaluatorManager.evaluate("param", this.paramEL, //$NON-NLS-1$
	                String.class, this, super.pageContext );
		        button.append("?").append(param); //$NON-NLS-1$
			}
		}
		button.append("\" "); //$NON-NLS-1$
		
		if (null != this.nameEL)
		{
			button.append("id=\"").append(this.nameEL).append("\" "); //$NON-NLS-1$ //$NON-NLS-2$
			button.append("name=\"").append(this.nameEL).append("\" "); //$NON-NLS-1$ //$NON-NLS-2$
		}
		
		if (null != this.onclick)
		{
			button.append("onclick=\"").append(this.onclick).append("\" "); //$NON-NLS-1$ //$NON-NLS-2$
		}
		
		if (null != this.styleClass)
			button.append("class=\"").append(this.styleClass);
		else
			button.append("class=\"squarebutton"); //$NON-NLS-1$
		if ((null != this.fillEL) && (this.fillEL.equals(("true")))) //$NON-NLS-1$
		{
			button.append(" fill"); //$NON-NLS-1$
		}
		button.append("\">"); //$NON-NLS-1$
		button.append("<span>").append(text).append("</span></a></div>"); //$NON-NLS-1$ //$NON-NLS-2$
		
        try
        {
        	this.pageContext.getOut().write(button.toString());
        }
        catch (IOException io)
        {
            io.printStackTrace();
            throw new JspException("Error writing label: " + io.getMessage()); //$NON-NLS-1$
        }

        // Continue processing this page
        return (SKIP_BODY);
	}
	
    /**
     * @jsp.attribute required="false" rtexprvalue="true"
     */
	public void setPage(String p)
	{
		this.pageEL = p;
	}
	
    /**
     * @jsp.attribute required="false" rtexprvalue="true"
     */
	public void setParam(String p)
	{
		this.paramEL = p;
	}
	
	/**
	 * @jsp.attribute requred="false" rtexprvavlue="false"
	 */
	public void setFill(String f)
	{
		this.fillEL = f;
	}
	
	/**
	 * @jsp.attribute requred="false" rtexprvavlue="false"
	 */
	public void setName(String n)
	{
		this.nameEL = n;
	}
	
    /**
     * @jsp.attribute required="false" rtexprvalue="true"
     */
	public void setOnclick(String o)
	{
		this.onclick = o;
	}
	
	/**
     * @jsp.attribute required="false" rtexprvalue="true"
     */
	public void setStyleClass(String c)
	{
		this.styleClass = c;
	}

    /**
     * Release all allocated resources.
     */
    @Override
    public void release()
    {
        super.release();
        this.pageEL = null;
        this.paramEL = null;
        this.fillEL = null;
        this.onclick = null;
        this.styleClass = null;
    }
}
