package com.sageconsulting.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sageconsulting.service.CourseManager;

public class ManageCourseController implements Controller
{
	private static final Log log = LogFactory.getLog(ManageCourseController.class);
    private CourseManager courseManager;
    
    public void setCourseManager(CourseManager mgr)
    {
        this.courseManager = mgr;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
		if (log.isDebugEnabled())
        {
            log.debug("entering 'handleRequest' method...");
        }
		
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("courses", this.courseManager.getCourses());
		return modelView;
    }
}
