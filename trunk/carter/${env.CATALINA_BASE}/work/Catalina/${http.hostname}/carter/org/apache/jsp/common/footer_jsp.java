package org.apache.jsp.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/common/taglibs.jsp");
    _jspx_dependants.add("/WEB-INF/carter.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fmenu_005fuseMenuDisplayer_005fpermissions_005fname_005fconfig;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fmenu_005fuseMenuDisplayer_005fpermissions_005fname_005fconfig = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fmenu_005fuseMenuDisplayer_005fpermissions_005fname_005fconfig.release();
    _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"/error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_menu_005fuseMenuDisplayer_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_menu_005fuseMenuDisplayer_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:useMenuDisplayer
    net.sf.navigator.taglib.el.UseMenuDisplayerTag _jspx_th_menu_005fuseMenuDisplayer_005f0 = (net.sf.navigator.taglib.el.UseMenuDisplayerTag) _005fjspx_005ftagPool_005fmenu_005fuseMenuDisplayer_005fpermissions_005fname_005fconfig.get(net.sf.navigator.taglib.el.UseMenuDisplayerTag.class);
    _jspx_th_menu_005fuseMenuDisplayer_005f0.setPageContext(_jspx_page_context);
    _jspx_th_menu_005fuseMenuDisplayer_005f0.setParent(null);
    _jspx_th_menu_005fuseMenuDisplayer_005f0.setName("Velocity");
    _jspx_th_menu_005fuseMenuDisplayer_005f0.setConfig("WEB-INF/classes/cssHorizontalMenu.vm");
    _jspx_th_menu_005fuseMenuDisplayer_005f0.setPermissions("rolesAdapter");
    int _jspx_eval_menu_005fuseMenuDisplayer_005f0 = _jspx_th_menu_005fuseMenuDisplayer_005f0.doStartTag();
    if (_jspx_eval_menu_005fuseMenuDisplayer_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_menu_005fdisplayMenu_005f0(_jspx_th_menu_005fuseMenuDisplayer_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_menu_005fdisplayMenu_005f1(_jspx_th_menu_005fuseMenuDisplayer_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_menu_005fdisplayMenu_005f2(_jspx_th_menu_005fuseMenuDisplayer_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        int evalDoAfterBody = _jspx_th_menu_005fuseMenuDisplayer_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_menu_005fuseMenuDisplayer_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fmenu_005fuseMenuDisplayer_005fpermissions_005fname_005fconfig.reuse(_jspx_th_menu_005fuseMenuDisplayer_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fmenu_005fuseMenuDisplayer_005fpermissions_005fname_005fconfig.reuse(_jspx_th_menu_005fuseMenuDisplayer_005f0);
    return false;
  }

  private boolean _jspx_meth_menu_005fdisplayMenu_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_menu_005fuseMenuDisplayer_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:displayMenu
    net.sf.navigator.taglib.el.DisplayMenuTag _jspx_th_menu_005fdisplayMenu_005f0 = (net.sf.navigator.taglib.el.DisplayMenuTag) _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.get(net.sf.navigator.taglib.el.DisplayMenuTag.class);
    _jspx_th_menu_005fdisplayMenu_005f0.setPageContext(_jspx_page_context);
    _jspx_th_menu_005fdisplayMenu_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_menu_005fuseMenuDisplayer_005f0);
    _jspx_th_menu_005fdisplayMenu_005f0.setName("Feedback");
    int _jspx_eval_menu_005fdisplayMenu_005f0 = _jspx_th_menu_005fdisplayMenu_005f0.doStartTag();
    if (_jspx_th_menu_005fdisplayMenu_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f0);
    return false;
  }

  private boolean _jspx_meth_menu_005fdisplayMenu_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_menu_005fuseMenuDisplayer_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:displayMenu
    net.sf.navigator.taglib.el.DisplayMenuTag _jspx_th_menu_005fdisplayMenu_005f1 = (net.sf.navigator.taglib.el.DisplayMenuTag) _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.get(net.sf.navigator.taglib.el.DisplayMenuTag.class);
    _jspx_th_menu_005fdisplayMenu_005f1.setPageContext(_jspx_page_context);
    _jspx_th_menu_005fdisplayMenu_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_menu_005fuseMenuDisplayer_005f0);
    _jspx_th_menu_005fdisplayMenu_005f1.setName("Privacy");
    int _jspx_eval_menu_005fdisplayMenu_005f1 = _jspx_th_menu_005fdisplayMenu_005f1.doStartTag();
    if (_jspx_th_menu_005fdisplayMenu_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f1);
    return false;
  }

  private boolean _jspx_meth_menu_005fdisplayMenu_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_menu_005fuseMenuDisplayer_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:displayMenu
    net.sf.navigator.taglib.el.DisplayMenuTag _jspx_th_menu_005fdisplayMenu_005f2 = (net.sf.navigator.taglib.el.DisplayMenuTag) _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.get(net.sf.navigator.taglib.el.DisplayMenuTag.class);
    _jspx_th_menu_005fdisplayMenu_005f2.setPageContext(_jspx_page_context);
    _jspx_th_menu_005fdisplayMenu_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_menu_005fuseMenuDisplayer_005f0);
    _jspx_th_menu_005fdisplayMenu_005f2.setName("Terms");
    int _jspx_eval_menu_005fdisplayMenu_005f2 = _jspx_th_menu_005fdisplayMenu_005f2.doStartTag();
    if (_jspx_th_menu_005fdisplayMenu_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f2);
    return false;
  }
}
