/*
 * MembersController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.sageconsulting.Constants;
import com.sageconsulting.model.City;
import com.sageconsulting.model.Court;

public class CourtFormController extends BaseFormController {
	private static final String CMD_NAME = "editCourt"; 

	public CourtFormController() {
		setCommandName(CMD_NAME);
		setCommandClass(Court.class);
	}

	@Override
	public ModelAndView showForm(HttpServletRequest request,
			HttpServletResponse response, BindException errors)
			throws Exception {
		City city = (City) request.getSession().getAttribute(
				Constants.CITY_TOKEN);
		ModelAndView view = new ModelAndView();

		if (null == city) {
			String msg = getMessageSourceAccessor().getMessage(
					"errors.noCity", request.getLocale()); 
			view.addObject("successMessages", new String[] { msg });
			return view;
		}

		return getModelAndView(city, (Court) getCommand(request), request);
	}

	@Override
	public ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		City city = (City) request.getSession().getAttribute(
				Constants.CITY_TOKEN);
		return getModelAndView(city, (Court) command, request);
	}

	private ModelAndView getModelAndView(City city, Court command,
			HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		view.addObject(CMD_NAME, command);

		return view;
	}

	@Override
	public Object formBackingObject(HttpServletRequest request)
			throws Exception {
		return null;
	}

}
