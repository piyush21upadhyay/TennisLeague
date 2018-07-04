/*
 * ReloadController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sageconsulting.webapp.listener.StartupListener;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * This class is used to reload the drop-downs initialized in the
 * StartupListener.
 */
public class ReloadController implements Controller
{
    private transient final Log log = LogFactory.getLog(UserController.class);

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        if (this.log.isDebugEnabled())
        {
            this.log.debug("Entering 'execute' method"); //$NON-NLS-1$
        }

        StartupListener.setupContext(request.getSession().getServletContext());

        String referer = request.getHeader("Referer"); //$NON-NLS-1$

        if (referer != null)
        {
            this.log.info("reload complete, reloading user back to: " + referer); //$NON-NLS-1$
            List<String> messages = new ArrayList<String>();
            messages.add("Reloading options completed successfully."); //$NON-NLS-1$
            request.getSession().setAttribute("messages", messages); //$NON-NLS-1$
            response.sendRedirect(response.encodeRedirectURL(referer));
            return null;
        }
        response.setContentType("text/html"); //$NON-NLS-1$

        PrintWriter out = response.getWriter();

        out.println("<html>"); //$NON-NLS-1$
        out.println("<head>"); //$NON-NLS-1$
        out.println("<title>Context Reloaded</title>"); //$NON-NLS-1$
        out.println("</head>"); //$NON-NLS-1$
        out.println("<body bgcolor=\"white\">"); //$NON-NLS-1$
        out.println("<script type=\"text/javascript\">"); //$NON-NLS-1$
        out.println("alert('Context Reload Succeeded! Click OK to continue.');"); //$NON-NLS-1$
        out.println("history.back();"); //$NON-NLS-1$
        out.println("</script>"); //$NON-NLS-1$
        out.println("</body>"); //$NON-NLS-1$
        out.println("</html>"); //$NON-NLS-1$

        return null;
    }

}
