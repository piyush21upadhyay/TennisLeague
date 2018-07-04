/*
 * Controller file
 * Author : Wasim Ilias
 * Date : 2012-07-12
 * 
*/

package com.sageconsulting.webapp.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sageconsulting.model.Registration;
import com.sageconsulting.model.User;
import com.sageconsulting.service.RegistrationManager;
import com.sageconsulting.service.UserManager;

/**
 * Controller class for congratulations page after user signs up.
 */
public class CongratsMessageController implements Controller
{
	private UserManager userManager;
	private RegistrationManager registrationManager;
	
	public void setUserManager(UserManager mgr)
    {
        this.userManager = mgr;
    }
	
	public void setRegistrationManager(RegistrationManager mgr)
    {
    	this.registrationManager = mgr;
    }
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
		ModelAndView view = new ModelAndView();
        User user = this.userManager.getUserByUsername(request.getRemoteUser());
        
        if (null != user)
        {
        	String fullName = user.getFirstName() + " " + user.getLastName();
        	view.addObject("user", user);
            view.addObject("fullName", fullName);
            view.addObject("openRegistrations", this.getOpenRegistrations(user));
        }
        return view;
    }
	
	private List<Registration> getOpenRegistrations(User user)
	{
		if (null != user)
		{
			return this.registrationManager.getOpenRegistrationsForCity(user.getRegisteredCity().getId());
		}
		return null;
	}
}
