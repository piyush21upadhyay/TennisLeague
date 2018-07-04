/*
 * StringUtilTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.util;

import junit.framework.TestCase;

public class StringUtilTest extends TestCase
{
    public StringUtilTest(String name)
    {
        super(name);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception
    {
        super.tearDown();
    }

    public void testEncodePassword() throws Exception
    {
        String password = "test1234"; //$NON-NLS-1$
        String encrypted = "9bc34549d565d9505b287de0cd20ac77be1d3f2c"; //$NON-NLS-1$
        assertEquals(StringUtil.encodePassword(password, "SHA"), encrypted); //$NON-NLS-1$
    }

    public static void main(String[] args)
    {
        junit.textui.TestRunner.run(StringUtilTest.class);
    }
}
