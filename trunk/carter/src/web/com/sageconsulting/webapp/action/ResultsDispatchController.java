/*
 * ResultsDispatchController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.GrantedAuthority;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sageconsulting.model.Match;
import com.sageconsulting.service.MatchManager;
import com.sageconsulting.service.UserManager;
import com.sageconsulting.model.User;

public class ResultsDispatchController implements Controller {
	private static final Log log = LogFactory
			.getLog(ResultsDispatchController.class);

	private MatchManager matchManager;
	private UserManager userManager;

	public void setMatchManager(MatchManager mgr) {
		this.matchManager = mgr;
	}

	public void setUserManager(UserManager mgr) {
		this.userManager = mgr;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        Match match = getMatch(request);
        if (null == match)
        {
            return new ModelAndView("redirect:schedule.html"); //$NON-NLS-1$
        }
        else if (isAdministratorEdit(request))
        {
        	if( (request.getParameter("action") != null) && (request.getParameter("action").equals("view")) )
        		return new ModelAndView("redirect:viewresults.html?id=" + match.getId());
        	
        	return new ModelAndView("redirect:results.html?id=" + match.getId() + "&user_id=" + getUserId(request));
        }
        else if (match.getPlayed() != null)
        {
            String currIdOfUser=fetchIdOfAUsrIfItsACurrUser(request);
			return new ModelAndView("redirect:viewresults.html?id=" + match.getId() + "&currIdOfUser=" + currIdOfUser); 
        }
        return new ModelAndView("redirect:results.html?id="+match.getId()); //$NON-NLS-1$
    }

	private String fetchIdOfAUsrIfItsACurrUser(HttpServletRequest request) {
		User user = new User();

		String currentUserName = request.getRemoteUser();
		if (null != currentUserName) {
			user = this.userManager.getUserByUsername(currentUserName);
		}
		return user.getId().toString();

	}

	private Match getMatch(HttpServletRequest request) {
		Match match = null;

		Long id = getMatchId(request);
		if (null != id) {
			match = this.matchManager.getMatch(id);
		}

		return match;
	}

	private Long getMatchId(HttpServletRequest request) {
		String strId = request.getParameter("id"); //$NON-NLS-1$
		if (null != strId) {
			try {
				Long id = Long.valueOf(strId);
				return id;
			} catch (NumberFormatException e) {
				log.warn("Invalid id: " + strId); //$NON-NLS-1$
			}
		}
		return null;
	}

	private boolean isAdministratorEdit(HttpServletRequest request) {
		boolean isAdministrator = false;

		if (request.getRemoteUser() != null) {
			User currentUser = this.userManager.getUserByUsername(request
					.getRemoteUser());
			GrantedAuthority[] userAuthorities = currentUser.getAuthorities();

			for (int counter = 0; counter < userAuthorities.length; counter++) {
				String userRole = userAuthorities[counter].toString();
				if (userRole.equalsIgnoreCase("admin")) {
					isAdministrator = true;
					break;
				}
			}
		}

		return isAdministrator;
	}

	private String getUserId(HttpServletRequest request) {
		String userId = request.getParameter("user_id");
		User userToEdit = this.userManager.getUser(userId);

		return userToEdit.getId().toString();
	}
}
