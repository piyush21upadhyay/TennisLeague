package org.apache.jsp.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/common/taglibs.jsp");
    _jspx_dependants.add("/WEB-INF/carter.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fmenu_005fuseMenuDisplayer_005fpermissions_005fname_005fconfig;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fcarter_005fconstants_005fscope_005fnobody;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fmenu_005fuseMenuDisplayer_005fpermissions_005fname_005fconfig = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fcarter_005fconstants_005fscope_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fmenu_005fuseMenuDisplayer_005fpermissions_005fname_005fconfig.release();
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_005ftest.release();
    _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
    _005fjspx_005ftagPool_005fcarter_005fconstants_005fscope_005fnobody.release();
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
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_menu_005fuseMenuDisplayer_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      //  carter:constants
      com.sageconsulting.webapp.taglib.ConstantsTag _jspx_th_carter_005fconstants_005f0 = (com.sageconsulting.webapp.taglib.ConstantsTag) _005fjspx_005ftagPool_005fcarter_005fconstants_005fscope_005fnobody.get(com.sageconsulting.webapp.taglib.ConstantsTag.class);
      _jspx_th_carter_005fconstants_005f0.setPageContext(_jspx_page_context);
      _jspx_th_carter_005fconstants_005f0.setParent(null);
      _jspx_th_carter_005fconstants_005f0.setScope("request");
      int _jspx_eval_carter_005fconstants_005f0 = _jspx_th_carter_005fconstants_005f0.doStartTag();
      if (_jspx_th_carter_005fconstants_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fcarter_005fconstants_005fscope_005fnobody.reuse(_jspx_th_carter_005fconstants_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fcarter_005fconstants_005fscope_005fnobody.reuse(_jspx_th_carter_005fconstants_005f0);
      java.lang.String BUNDLE_KEY = null;
      java.lang.String ENC_ALGORITHM = null;
      java.lang.String ENCRYPT_PASSWORD = null;
      java.lang.String FILE_SEP = null;
      java.lang.String USER_HOME = null;
      java.lang.String CONFIG = null;
      java.lang.String PREFERRED_LOCALE_KEY = null;
      java.lang.String USER_KEY = null;
      java.lang.String USER_LIST = null;
      java.lang.String REGISTERED = null;
      java.lang.String ADMIN_ROLE = null;
      java.lang.String USER_ROLE = null;
      java.lang.String USER_ROLES = null;
      java.lang.String AVAILABLE_ROLES = null;
      java.lang.String AVAILABLE_CITIES = null;
      java.lang.String CITY_TOKEN = null;
      java.lang.String CSS_THEME = null;
      BUNDLE_KEY = (java.lang.String) _jspx_page_context.findAttribute("BUNDLE_KEY");
      ENC_ALGORITHM = (java.lang.String) _jspx_page_context.findAttribute("ENC_ALGORITHM");
      ENCRYPT_PASSWORD = (java.lang.String) _jspx_page_context.findAttribute("ENCRYPT_PASSWORD");
      FILE_SEP = (java.lang.String) _jspx_page_context.findAttribute("FILE_SEP");
      USER_HOME = (java.lang.String) _jspx_page_context.findAttribute("USER_HOME");
      CONFIG = (java.lang.String) _jspx_page_context.findAttribute("CONFIG");
      PREFERRED_LOCALE_KEY = (java.lang.String) _jspx_page_context.findAttribute("PREFERRED_LOCALE_KEY");
      USER_KEY = (java.lang.String) _jspx_page_context.findAttribute("USER_KEY");
      USER_LIST = (java.lang.String) _jspx_page_context.findAttribute("USER_LIST");
      REGISTERED = (java.lang.String) _jspx_page_context.findAttribute("REGISTERED");
      ADMIN_ROLE = (java.lang.String) _jspx_page_context.findAttribute("ADMIN_ROLE");
      USER_ROLE = (java.lang.String) _jspx_page_context.findAttribute("USER_ROLE");
      USER_ROLES = (java.lang.String) _jspx_page_context.findAttribute("USER_ROLES");
      AVAILABLE_ROLES = (java.lang.String) _jspx_page_context.findAttribute("AVAILABLE_ROLES");
      AVAILABLE_CITIES = (java.lang.String) _jspx_page_context.findAttribute("AVAILABLE_CITIES");
      CITY_TOKEN = (java.lang.String) _jspx_page_context.findAttribute("CITY_TOKEN");
      CSS_THEME = (java.lang.String) _jspx_page_context.findAttribute("CSS_THEME");
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
        out.write("\r\n");
        out.write("<div class=\"right\">\r\n");
        out.write("\t<div id=\"links\">\r\n");
        out.write("\t\t<a class=\"ie-post-link\" onclick=\"showLink('http://www.facebook.com/pages/City-Golf-League/348284351925121');\">\r\n");
        out.write("\t\t\t<i class=\"fa fa-facebook\"></i>\r\n");
        out.write("\t\t</a>\r\n");
        out.write("\t\t<a class=\"ie-post-link\" onclick=\"showLink('https://twitter.com/CityGolfLeague');\">\r\n");
        out.write("\t\t\t<i class=\"fa fa-twitter\"></i>\r\n");
        out.write("\t\t</a>\r\n");
        out.write("\t\t<a href=\"\" target=\"_blank\"><i class=\"fa fa-instagram\"></i></a>\r\n");
        out.write("\t</div>\r\n");
        out.write("\t<div style=\"display:inline-block;\">\r\n");
        out.write("\t");
        if (_jspx_meth_c_005fchoose_005f0(_jspx_th_menu_005fuseMenuDisplayer_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t</div>\r\n");
        out.write("</div>\r\n");
        out.write("\r\n");
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

  private boolean _jspx_meth_c_005fchoose_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_menu_005fuseMenuDisplayer_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_menu_005fuseMenuDisplayer_005f0);
    int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
    if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t");
        if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t");
        if (_jspx_meth_c_005fwhen_005f1(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t");
        if (_jspx_meth_c_005fotherwise_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        out.write('	');
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.el.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.el.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_005ftest.get(org.apache.taglibs.standard.tag.el.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    _jspx_th_c_005fwhen_005f0.setTest("${empty pageContext.request.remoteUser}");
    int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
    if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t<div id=\"signup-nav\">");
        if (_jspx_meth_menu_005fdisplayMenu_005f0(_jspx_th_c_005fwhen_005f0, _jspx_page_context))
          return true;
        out.write("</div>\r\n");
        out.write("\t\t\t<div id=\"login-nav\">");
        if (_jspx_meth_menu_005fdisplayMenu_005f1(_jspx_th_c_005fwhen_005f0, _jspx_page_context))
          return true;
        out.write("</div>\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
    return false;
  }

  private boolean _jspx_meth_menu_005fdisplayMenu_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:displayMenu
    net.sf.navigator.taglib.el.DisplayMenuTag _jspx_th_menu_005fdisplayMenu_005f0 = (net.sf.navigator.taglib.el.DisplayMenuTag) _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.get(net.sf.navigator.taglib.el.DisplayMenuTag.class);
    _jspx_th_menu_005fdisplayMenu_005f0.setPageContext(_jspx_page_context);
    _jspx_th_menu_005fdisplayMenu_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f0);
    _jspx_th_menu_005fdisplayMenu_005f0.setName("Signup");
    int _jspx_eval_menu_005fdisplayMenu_005f0 = _jspx_th_menu_005fdisplayMenu_005f0.doStartTag();
    if (_jspx_th_menu_005fdisplayMenu_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f0);
    return false;
  }

  private boolean _jspx_meth_menu_005fdisplayMenu_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:displayMenu
    net.sf.navigator.taglib.el.DisplayMenuTag _jspx_th_menu_005fdisplayMenu_005f1 = (net.sf.navigator.taglib.el.DisplayMenuTag) _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.get(net.sf.navigator.taglib.el.DisplayMenuTag.class);
    _jspx_th_menu_005fdisplayMenu_005f1.setPageContext(_jspx_page_context);
    _jspx_th_menu_005fdisplayMenu_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f0);
    _jspx_th_menu_005fdisplayMenu_005f1.setName("Login");
    int _jspx_eval_menu_005fdisplayMenu_005f1 = _jspx_th_menu_005fdisplayMenu_005f1.doStartTag();
    if (_jspx_th_menu_005fdisplayMenu_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.el.core.WhenTag _jspx_th_c_005fwhen_005f1 = (org.apache.taglibs.standard.tag.el.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_005ftest.get(org.apache.taglibs.standard.tag.el.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    _jspx_th_c_005fwhen_005f1.setTest("${not empty errorStatusCode}");
    int _jspx_eval_c_005fwhen_005f1 = _jspx_th_c_005fwhen_005f1.doStartTag();
    if (_jspx_eval_c_005fwhen_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t");
        out.write("\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_005ftest.reuse(_jspx_th_c_005fwhen_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_005ftest.reuse(_jspx_th_c_005fwhen_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_005fotherwise_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fotherwise_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    int _jspx_eval_c_005fotherwise_005f0 = _jspx_th_c_005fotherwise_005f0.doStartTag();
    if (_jspx_eval_c_005fotherwise_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t<div id=\"logout-nav\">");
        if (_jspx_meth_menu_005fdisplayMenu_005f2(_jspx_th_c_005fotherwise_005f0, _jspx_page_context))
          return true;
        out.write("</div>\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_c_005fotherwise_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fotherwise_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
    return false;
  }

  private boolean _jspx_meth_menu_005fdisplayMenu_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fotherwise_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:displayMenu
    net.sf.navigator.taglib.el.DisplayMenuTag _jspx_th_menu_005fdisplayMenu_005f2 = (net.sf.navigator.taglib.el.DisplayMenuTag) _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.get(net.sf.navigator.taglib.el.DisplayMenuTag.class);
    _jspx_th_menu_005fdisplayMenu_005f2.setPageContext(_jspx_page_context);
    _jspx_th_menu_005fdisplayMenu_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fotherwise_005f0);
    _jspx_th_menu_005fdisplayMenu_005f2.setName("Logout");
    int _jspx_eval_menu_005fdisplayMenu_005f2 = _jspx_th_menu_005fdisplayMenu_005f2.doStartTag();
    if (_jspx_th_menu_005fdisplayMenu_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fmenu_005fdisplayMenu_005fname_005fnobody.reuse(_jspx_th_menu_005fdisplayMenu_005f2);
    return false;
  }
}
