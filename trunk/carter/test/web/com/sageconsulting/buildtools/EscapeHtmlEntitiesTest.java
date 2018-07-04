/*
 * EscapeHtmlEntitiesTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.buildtools;

import java.io.StringReader;

import junit.framework.TestCase;

import org.apache.tools.ant.util.FileUtils;

/**
 * Testcase to verify EscapeHtmlEntities filter.
 */
public class EscapeHtmlEntitiesTest extends TestCase
{

    /**
     * Test Unicode->Entity escaping.
     * 
     * @throws Exception
     */
    public void testEscape() throws Exception
    {
        StringReader str = new StringReader("\u00E4\u00FC\u00F6\u00DF-\u00D6\u00F3"); //$NON-NLS-1$
        EscapeHtmlEntities boot = new EscapeHtmlEntities();
        EscapeHtmlEntities filter = (EscapeHtmlEntities) boot.chain(str);
        filter.setMode(EscapeHtmlEntities.ESCAPE);
        String result = FileUtils.readFully(filter, 200);
        assertEquals("&auml;&uuml;&ouml;&szlig;-&Ouml;&oacute;", result); //$NON-NLS-1$
    }

    /**
     * Test Entity->Unicode unescaping.
     * 
     * @throws Exception
     */
    public void testUnescape() throws Exception
    {
        StringReader str = new StringReader("&auml;&uuml;&ouml;&szlig;-&Ouml;&oacute;&noentity;"); //$NON-NLS-1$
        EscapeHtmlEntities boot = new EscapeHtmlEntities();
        EscapeHtmlEntities filter = (EscapeHtmlEntities) boot.chain(str);
        filter.setMode(EscapeHtmlEntities.UNESCAPE);
        String result = FileUtils.readFully(filter, 200);
        assertEquals("\u00E4\u00FC\u00F6\u00DF-\u00D6\u00F3&noentity;", result); //$NON-NLS-1$
    }
}
