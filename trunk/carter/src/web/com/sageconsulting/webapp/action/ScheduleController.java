/*
 * ScheduleController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.GrantedAuthority;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sageconsulting.Constants;
import com.sageconsulting.model.City;
import com.sageconsulting.model.Match;
import com.sageconsulting.model.Season;
import com.sageconsulting.model.User;
import com.sageconsulting.service.MatchManager;
import com.sageconsulting.service.SeasonManager;
import com.sageconsulting.service.UserManager;
import com.sageconsulting.util.SeasonInfo;
import com.sageconsulting.util.SeasonResult;

public class ScheduleController extends ApplicationObjectSupport implements Controller
{
	private UserManager userManager;
	private MatchManager matchManager;
	private SeasonManager seasonManager;

	public void setUserManager(UserManager mgr)
	{
		this.userManager = mgr;
	}

	public void setMatchManager(MatchManager mgr)
	{
		this.matchManager = mgr;
	}

	public void setSeasonManager(SeasonManager mgr)
	{
		this.seasonManager = mgr;
	}

	protected SeasonManager getSeasonManager() {
		return this.seasonManager;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView view = new ModelAndView();

		City city = (City) request.getSession().getAttribute(
				Constants.CITY_TOKEN);
		if (null == city) {
			String msg = getMessageSourceAccessor().getMessage(
					"errors.noCity", request.getLocale()); //$NON-NLS-1$
			view.addObject("successMessages", new String[] { msg });//$NON-NLS-1$
			return view;
		}

		User user = getUser(request);
		if (null != user) {
			List<MatchInfo> list = getMatchInfoList(getMatches(request), user);

			view.addObject("user", user); //$NON-NLS-1$

			if (!list.isEmpty()) {
				view.addObject("matchList", list); //$NON-NLS-1$
			}

			if (request.getRemoteUser() != null)
				view.addObject("currentUser", isCurrentUser(request, user));

			view.addObject("isAdmin", isAdminUser(request));
			if (user.getCurrentSeason() != null) {
				if (user.getCurrentSeason().getState().intValue() == Season.STATE_POST_SEASON) {
					view.addObject("postSeasonSchedule", "post");
					SeasonResult[] result = getSeasonResults(user
							.getCurrentSeason());

					Map<Integer, Integer> RankUserId = new HashMap<Integer, Integer>();
					int i = 1;
					for (SeasonResult sr : result) {
						RankUserId.put(i, sr.getUser().getId().intValue());
						i++;
						if (i == 17)
							break;
					}

					Map<Integer,Integer> matchAndHomePlayer = new HashMap<Integer, Integer>();

					for (MatchInfo matchlist : list) {

						Integer key1 = null;
						Integer key2 = null;
						for (Map.Entry<Integer, Integer> entry : RankUserId
								.entrySet()) {
							
							if(matchlist.getGolfer1()!=null && matchlist.getGolfer2()!=null)
							{
								if (matchlist.getGolfer1().getId().intValue() == entry
										.getValue()) {
									key1 = (Integer) entry.getKey();

								}

								if (matchlist.getGolfer2().getId().intValue() == entry
										.getValue()) {
									key2 = (Integer) entry.getKey();

								}
						    }

						}

						if(key1!=null && key2!=null)
						{
						if (key1 < key2) {
							matchAndHomePlayer.put(matchlist.getId().intValue(), matchlist
									.getGolfer1().getId().intValue());
						} else {
							matchAndHomePlayer.put(matchlist.getId().intValue(), matchlist
									.getGolfer2().getId().intValue());
						}
						}
					}
					view.addObject("matchAndHomePlayer", matchAndHomePlayer);
				} else {
					view.addObject("postSeasonSchedule", null);
				}
			}

		} else {
			//String msg = getMessageSourceAccessor().getMessage("schedule.mustLogin", request.getLocale()); //$NON-NLS-1$
			//view.addObject("successMessages", new String[] { msg });//$NON-NLS-1$
			return view;
		}

		return view;
	}

	private List<Match> getMatches(HttpServletRequest request) {
		User user = getUser(request);
		if (null != user) {
			return this.matchManager.getMatchesForGolfer(user.getId());
		}
		return new ArrayList<Match>(0);
	}

	private User getUser(HttpServletRequest request) {
		Long id = getIdParameter(request);
		if (null != id) {
			User user = this.userManager.getUser(id.toString());
			if (null != user) {
				return user;
			}
		}

		// No passed in id so just use the current user
		String username = request.getRemoteUser();
		if (null == username) {
			return null;
		}
		return this.userManager.getUserByUsername(username);
	}

	private Long getIdParameter(HttpServletRequest request) {
		Long id = null;
		String idParam = request.getParameter("id"); //$NON-NLS-1$
		if (null != idParam) {
			try {
				id = Long.valueOf(idParam);
			} catch (NumberFormatException e) {
				// Don't worry about it. Just return null below.
			}
		}
		return id;
	}

	private List<MatchInfo> getMatchInfoList(List<Match> matches,
			User currentUser) {
		List<MatchInfo> list = new ArrayList<MatchInfo>(matches.size());

		if ((currentUser.getCurrentSeason() == null)
				|| (currentUser.getCurrentSeason().getState().intValue() == Season.STATE_CLEAR))
			return list;

		if (currentUser.getCurrentSeason().getState().intValue() == Season.STATE_POST_SEASON) {
			// get only post season matches.
			for (Match match : matches) {
				MatchInfo matchInfo = new MatchInfo(currentUser, match);

				if (matchInfo.isPostSeason()) {
					if (match.getBracketEntry().getSeasonId().longValue() == currentUser
							.getCurrentSeason().getId().longValue())
						list.add(matchInfo);
				}
			}
		} else if (currentUser.getCurrentSeason().getState().intValue() == Season.STATE_REGULAR_SEASON) {
			// get only regular season matches.
			for (Match match : matches) {
				MatchInfo matchInfo = new MatchInfo(currentUser, match);
				boolean response = isCurrentSeasonMatch(match,
						currentUser.getCurrentSeason());
				if (response)
					list.add(matchInfo);
			}
		}
		return list;
	}

	private boolean isAdminUser(HttpServletRequest request) {
		boolean isAdminRole = false;

		if (request.getRemoteUser() != null) {
			User currentUser = this.userManager.getUserByUsername(request
					.getRemoteUser());
			GrantedAuthority[] userAuthorities = currentUser.getAuthorities();

			for (int counter = 0; counter < userAuthorities.length; counter++) {
				String userRole = userAuthorities[counter].toString();
				if (userRole.equalsIgnoreCase("admin")) {
					isAdminRole = true;
					break;
				}
			}
		}

		return isAdminRole;
	}

	private boolean isCurrentUser(HttpServletRequest request, User user) {
		String currentUserName = request.getRemoteUser();
		if ((null == user) || (null == currentUserName)) {
			return false;
		}

		return user.getUsername().equals(currentUserName);
	}

	private boolean isCurrentSeasonMatch(Match match, Season currentSeason) {
		boolean response = false;
		SortedSet<Match> matches = currentSeason.getMatches();

		for (Match seasonMatch : matches) {
			if (seasonMatch.equals(match)) {
				response = true;
				break;
			}
		}
		return response;
	}

	private SeasonResult[] getSeasonResults(Season season) {
		return SeasonInfo.getSortedSeasonResults(getSeasonManager(),
				season.getId());
	}
}
