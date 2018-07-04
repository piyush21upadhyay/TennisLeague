/*
 * UserFormControllerTest.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.sageconsulting.model.User;

public class UserFormControllerTest extends BaseControllerTestCase
{
    private UserFormController c;

    private MockHttpServletRequest request;

    private ModelAndView mv;

    @Override
    protected void setUp() throws Exception
    {
        // needed to initialize a user
        super.setUp();
        this.c = (UserFormController) ctx.getBean("userFormController"); //$NON-NLS-1$
    }

    @Override
    protected void tearDown()
    {
        this.c = null;
    }

    public void testCancel() throws Exception
    {
        this.log.debug("testing cancel..."); //$NON-NLS-1$
        this.request = newPost("/editUser.html"); //$NON-NLS-1$
        this.request.addParameter("cancel", ""); //$NON-NLS-1$ //$NON-NLS-2$

        this.mv = this.c.handleRequest(this.request, new MockHttpServletResponse());

        assertEquals("redirect:home.html", this.mv.getViewName()); //$NON-NLS-1$
    }

    public void testEdit() throws Exception
    {
        this.log.debug("testing edit..."); //$NON-NLS-1$
        this.request = newGet("/editUser.html"); //$NON-NLS-1$
        this.request.addParameter("username", "tcarter"); //$NON-NLS-1$ //$NON-NLS-2$

        this.mv = this.c.handleRequest(this.request, new MockHttpServletResponse());

        assertEquals("userForm", this.mv.getViewName()); //$NON-NLS-1$
        User editUser = (User)this.mv.getModel().get(this.c.getCommandName());
        assertEquals("Tom Carter", editUser.getFullName()); //$NON-NLS-1$
    }

    public void testSave() throws Exception
    {
        this.request = newPost("/editUser.html"); //$NON-NLS-1$
        // set updated properties first since adding them later will
        // result in multiple parameters with the same name getting sent
        this.user.setConfirmPassword(this.user.getPassword());
        this.user.setLastName("Updated Last Name"); //$NON-NLS-1$
        super.objectToRequestParameters(this.user, this.request);

        this.mv = this.c.handleRequest(this.request, new MockHttpServletResponse());

        this.log.debug(this.mv.getModel());
        Errors errors = (Errors) this.mv.getModel().get(BindingResult.MODEL_KEY_PREFIX + "user"); //$NON-NLS-1$
        assertNull(errors);
        assertNotNull(this.request.getSession().getAttribute("successMessages")); //$NON-NLS-1$
    }

    public void testAddWithMissingFields() throws Exception
    {
        this.request = newPost("/editUser.html"); //$NON-NLS-1$
        this.request.addParameter("firstName", "Julie"); //$NON-NLS-1$ //$NON-NLS-2$
        this.request.setRemoteUser("tcarter"); //$NON-NLS-1$

        this.mv = this.c.handleRequest(this.request, new MockHttpServletResponse());

        Errors errors = (Errors) this.mv.getModel().get(BindingResult.MODEL_KEY_PREFIX + "user"); //$NON-NLS-1$
        assertTrue(errors.getAllErrors().size() == 10);
    }

    // public void testRemove() throws Exception {
    // request = newPost("/editUser.html");
    // request.addParameter("delete", "");
    // request.addParameter("id", "2");
    //
    // mv = c.handleRequest(request, new MockHttpServletResponse());
    //        
    // assertNotNull(request.getSession().getAttribute("successMessages"));
    // }
}
