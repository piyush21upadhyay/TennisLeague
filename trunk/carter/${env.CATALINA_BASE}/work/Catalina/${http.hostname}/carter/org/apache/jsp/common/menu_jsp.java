package org.apache.jsp.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
        if (_jspx_meth_menu_005fdisplayMenu_005f3(_jspx_th_menu_005fuseMenuDisplayer_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_menu_005fdisplayMenu_005f4(_jspx_th_menu_005fuseMenuDisplayer_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_menu_005fdisplayMenu_005f5(_jspx_th_menu_005fuseMenuDisplayer_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_menu_005fdisplayMenu_005f6(_jspx_th_menu_005fuseMenuDisplayer_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_menu_005fdisplayMenu_005f7(_jspx_th_menu_005fuseMenuDisplayer_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_menu_005fdisplayMenu_005f8(_jspx_th_menu_005fuseMenuDisplayer_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("<hr>\r\n");
        out.write("<div class=\"second-menu\">\r\n");
        if (_jspx_meth_menu_005fdisplayMenu_005f9(_jspx_th_menu_005fuseMenuDisplayer_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_menu_005fdisplayMenu_005f10(_jspx_th_menu_005fuseMenuDisplayer_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_menu_005fdisplayMenu_005f11(_jspx_th_menu_005fuseMenuDisplayer_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        if (_jspx_meth_menu_005fdisplayMenu_005f12(_jspx_th_menu_005fuseMenuDisplayer_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("</div>\r\n");
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
    _jspx_th_menu_005fdisplayMenu_005f0.setName("Welcome");
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
    _jspx_th_menu_005fdisplayMenu_005f1.setName("Profile");
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
    _jspx_th_menu_005fdisplayMenu_005f2.setName("Schedule");
    int _jspx_eval_menu_005fdisplayMenu_005f2 = _jspx_th_menu_005fdisplayMenu_005f2.doStartTag();
    if (_jspx_th_menu_005fdisplayMenu_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f2);
    return false;
  }

  private boolean _jspx_meth_menu_005fdisplayMenu_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_menu_005fuseMenuDisplayer_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:displayMenu
    net.sf.navigator.taglib.el.DisplayMenuTag _jspx_th_menu_005fdisplayMenu_005f3 = (net.sf.navigator.taglib.el.DisplayMenuTag) _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.get(net.sf.navigator.taglib.el.DisplayMenuTag.class);
    _jspx_th_menu_005fdisplayMenu_005f3.setPageContext(_jspx_page_context);
    _jspx_th_menu_005fdisplayMenu_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_menu_005fuseMenuDisplayer_005f0);
    _jspx_th_menu_005fdisplayMenu_005f3.setName("Lookup");
    int _jspx_eval_menu_005fdisplayMenu_005f3 = _jspx_th_menu_005fdisplayMenu_005f3.doStartTag();
    if (_jspx_th_menu_005fdisplayMenu_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f3);
    return false;
  }

  private boolean _jspx_meth_menu_005fdisplayMenu_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_menu_005fuseMenuDisplayer_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:displayMenu
    net.sf.navigator.taglib.el.DisplayMenuTag _jspx_th_menu_005fdisplayMenu_005f4 = (net.sf.navigator.taglib.el.DisplayMenuTag) _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.get(net.sf.navigator.taglib.el.DisplayMenuTag.class);
    _jspx_th_menu_005fdisplayMenu_005f4.setPageContext(_jspx_page_context);
    _jspx_th_menu_005fdisplayMenu_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_menu_005fuseMenuDisplayer_005f0);
    _jspx_th_menu_005fdisplayMenu_005f4.setName("Courts");
    int _jspx_eval_menu_005fdisplayMenu_005f4 = _jspx_th_menu_005fdisplayMenu_005f4.doStartTag();
    if (_jspx_th_menu_005fdisplayMenu_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f4);
    return false;
  }

  private boolean _jspx_meth_menu_005fdisplayMenu_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_menu_005fuseMenuDisplayer_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:displayMenu
    net.sf.navigator.taglib.el.DisplayMenuTag _jspx_th_menu_005fdisplayMenu_005f5 = (net.sf.navigator.taglib.el.DisplayMenuTag) _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.get(net.sf.navigator.taglib.el.DisplayMenuTag.class);
    _jspx_th_menu_005fdisplayMenu_005f5.setPageContext(_jspx_page_context);
    _jspx_th_menu_005fdisplayMenu_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_menu_005fuseMenuDisplayer_005f0);
    _jspx_th_menu_005fdisplayMenu_005f5.setName("Standings");
    int _jspx_eval_menu_005fdisplayMenu_005f5 = _jspx_th_menu_005fdisplayMenu_005f5.doStartTag();
    if (_jspx_th_menu_005fdisplayMenu_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f5);
    return false;
  }

  private boolean _jspx_meth_menu_005fdisplayMenu_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_menu_005fuseMenuDisplayer_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:displayMenu
    net.sf.navigator.taglib.el.DisplayMenuTag _jspx_th_menu_005fdisplayMenu_005f6 = (net.sf.navigator.taglib.el.DisplayMenuTag) _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.get(net.sf.navigator.taglib.el.DisplayMenuTag.class);
    _jspx_th_menu_005fdisplayMenu_005f6.setPageContext(_jspx_page_context);
    _jspx_th_menu_005fdisplayMenu_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_menu_005fuseMenuDisplayer_005f0);
    _jspx_th_menu_005fdisplayMenu_005f6.setName("Playoffs");
    int _jspx_eval_menu_005fdisplayMenu_005f6 = _jspx_th_menu_005fdisplayMenu_005f6.doStartTag();
    if (_jspx_th_menu_005fdisplayMenu_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f6);
    return false;
  }

  private boolean _jspx_meth_menu_005fdisplayMenu_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_menu_005fuseMenuDisplayer_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:displayMenu
    net.sf.navigator.taglib.el.DisplayMenuTag _jspx_th_menu_005fdisplayMenu_005f7 = (net.sf.navigator.taglib.el.DisplayMenuTag) _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.get(net.sf.navigator.taglib.el.DisplayMenuTag.class);
    _jspx_th_menu_005fdisplayMenu_005f7.setPageContext(_jspx_page_context);
    _jspx_th_menu_005fdisplayMenu_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_menu_005fuseMenuDisplayer_005f0);
    _jspx_th_menu_005fdisplayMenu_005f7.setName("Champions");
    int _jspx_eval_menu_005fdisplayMenu_005f7 = _jspx_th_menu_005fdisplayMenu_005f7.doStartTag();
    if (_jspx_th_menu_005fdisplayMenu_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f7);
    return false;
  }

  private boolean _jspx_meth_menu_005fdisplayMenu_005f8(javax.servlet.jsp.tagext.JspTag _jspx_th_menu_005fuseMenuDisplayer_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:displayMenu
    net.sf.navigator.taglib.el.DisplayMenuTag _jspx_th_menu_005fdisplayMenu_005f8 = (net.sf.navigator.taglib.el.DisplayMenuTag) _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.get(net.sf.navigator.taglib.el.DisplayMenuTag.class);
    _jspx_th_menu_005fdisplayMenu_005f8.setPageContext(_jspx_page_context);
    _jspx_th_menu_005fdisplayMenu_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_menu_005fuseMenuDisplayer_005f0);
    _jspx_th_menu_005fdisplayMenu_005f8.setName("AdminMenu");
    int _jspx_eval_menu_005fdisplayMenu_005f8 = _jspx_th_menu_005fdisplayMenu_005f8.doStartTag();
    if (_jspx_th_menu_005fdisplayMenu_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f8);
    return false;
  }

  private boolean _jspx_meth_menu_005fdisplayMenu_005f9(javax.servlet.jsp.tagext.JspTag _jspx_th_menu_005fuseMenuDisplayer_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:displayMenu
    net.sf.navigator.taglib.el.DisplayMenuTag _jspx_th_menu_005fdisplayMenu_005f9 = (net.sf.navigator.taglib.el.DisplayMenuTag) _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.get(net.sf.navigator.taglib.el.DisplayMenuTag.class);
    _jspx_th_menu_005fdisplayMenu_005f9.setPageContext(_jspx_page_context);
    _jspx_th_menu_005fdisplayMenu_005f9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_menu_005fuseMenuDisplayer_005f0);
    _jspx_th_menu_005fdisplayMenu_005f9.setName("About");
    int _jspx_eval_menu_005fdisplayMenu_005f9 = _jspx_th_menu_005fdisplayMenu_005f9.doStartTag();
    if (_jspx_th_menu_005fdisplayMenu_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f9);
    return false;
  }

  private boolean _jspx_meth_menu_005fdisplayMenu_005f10(javax.servlet.jsp.tagext.JspTag _jspx_th_menu_005fuseMenuDisplayer_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:displayMenu
    net.sf.navigator.taglib.el.DisplayMenuTag _jspx_th_menu_005fdisplayMenu_005f10 = (net.sf.navigator.taglib.el.DisplayMenuTag) _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.get(net.sf.navigator.taglib.el.DisplayMenuTag.class);
    _jspx_th_menu_005fdisplayMenu_005f10.setPageContext(_jspx_page_context);
    _jspx_th_menu_005fdisplayMenu_005f10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_menu_005fuseMenuDisplayer_005f0);
    _jspx_th_menu_005fdisplayMenu_005f10.setName("Rules");
    int _jspx_eval_menu_005fdisplayMenu_005f10 = _jspx_th_menu_005fdisplayMenu_005f10.doStartTag();
    if (_jspx_th_menu_005fdisplayMenu_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f10);
    return false;
  }

  private boolean _jspx_meth_menu_005fdisplayMenu_005f11(javax.servlet.jsp.tagext.JspTag _jspx_th_menu_005fuseMenuDisplayer_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:displayMenu
    net.sf.navigator.taglib.el.DisplayMenuTag _jspx_th_menu_005fdisplayMenu_005f11 = (net.sf.navigator.taglib.el.DisplayMenuTag) _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.get(net.sf.navigator.taglib.el.DisplayMenuTag.class);
    _jspx_th_menu_005fdisplayMenu_005f11.setPageContext(_jspx_page_context);
    _jspx_th_menu_005fdisplayMenu_005f11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_menu_005fuseMenuDisplayer_005f0);
    _jspx_th_menu_005fdisplayMenu_005f11.setName("Contact");
    int _jspx_eval_menu_005fdisplayMenu_005f11 = _jspx_th_menu_005fdisplayMenu_005f11.doStartTag();
    if (_jspx_th_menu_005fdisplayMenu_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f11);
      return true;
    }
    _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f11);
    return false;
  }

  private boolean _jspx_meth_menu_005fdisplayMenu_005f12(javax.servlet.jsp.tagext.JspTag _jspx_th_menu_005fuseMenuDisplayer_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:displayMenu
    net.sf.navigator.taglib.el.DisplayMenuTag _jspx_th_menu_005fdisplayMenu_005f12 = (net.sf.navigator.taglib.el.DisplayMenuTag) _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.get(net.sf.navigator.taglib.el.DisplayMenuTag.class);
    _jspx_th_menu_005fdisplayMenu_005f12.setPageContext(_jspx_page_context);
    _jspx_th_menu_005fdisplayMenu_005f12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_menu_005fuseMenuDisplayer_005f0);
    _jspx_th_menu_005fdisplayMenu_005f12.setName("Cities");
    int _jspx_eval_menu_005fdisplayMenu_005f12 = _jspx_th_menu_005fdisplayMenu_005f12.doStartTag();
    if (_jspx_th_menu_005fdisplayMenu_005f12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f12);
      return true;
    }
    _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f12);
    return false;
  }
}
