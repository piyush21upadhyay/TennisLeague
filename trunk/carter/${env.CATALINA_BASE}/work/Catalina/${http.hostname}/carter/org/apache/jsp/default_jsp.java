package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class default_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(3);
    _jspx_dependants.add("/common/taglibs.jsp");
    _jspx_dependants.add("/WEB-INF/carter.tld");
    _jspx_dependants.add("/common/meta.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_005fvalue_005ftarget_005fproperty_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_005ftest;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_005fvalue_005ftarget_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_005fvalue_005ftarget_005fproperty_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_005ftest.release();
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
      com.sageconsulting.webapp.util.CustomRandBean rand = null;
      synchronized (_jspx_page_context) {
        rand = (com.sageconsulting.webapp.util.CustomRandBean) _jspx_page_context.getAttribute("rand", PageContext.PAGE_SCOPE);
        if (rand == null){
          rand = new com.sageconsulting.webapp.util.CustomRandBean();
          _jspx_page_context.setAttribute("rand", rand, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f2(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f4(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f5(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f6(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f7(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>");
      if (_jspx_meth_fmt_005fmessage_005f0(_jspx_page_context))
        return;
      out.write("</title>\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=EDGE\">\r\n");
      out.write("\r\n");
      out.write("        <!-- HTTP 1.1 -->\r\n");
      out.write("        <meta http-equiv=\"Cache-Control\" content=\"no-store\"/>\r\n");
      out.write("        <!-- HTTP 1.0 -->\r\n");
      out.write("        <meta http-equiv=\"Pragma\" content=\"no-cache\"/>\r\n");
      out.write("        <!-- Prevents caching at the Proxy Server -->\r\n");
      out.write("        <meta http-equiv=\"Expires\" content=\"0\"/>\r\n");
      out.write("        \r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/> \r\n");
      out.write("        ");
      if (_jspx_meth_c_005fset_005f8(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        <meta name=\"author\" content=\"Steve Paquin (spaquin@citygolfleague.com)\"/>\r\n");
      out.write("        <link rel=\"icon\" href=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write('"');
      out.write('/');
      out.write('>');
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function checkUserPass()\r\n");
      out.write("{\r\n");
      out.write("\t$(\"#error-msg\").css(\"display\",\"none\");\r\n");
      out.write("\tvar x=\"\";\r\n");
      out.write("\tif(document.getElementById(\"j_username\").value==\"\" && document.getElementById(\"j_password\").value==\"\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\tx=x+\"please enter your username and password.\";\r\n");
      out.write("\t}\r\n");
      out.write("\telse if ( document.getElementById(\"j_username\").value==\"\")\r\n");
      out.write("\t  {  \r\n");
      out.write("\t   x=x+\"please enter your username.\";\r\n");
      out.write("      }\r\n");
      out.write("\telse if(document.getElementById(\"j_password\").value==\"\")\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\tx=x+\"please enter your password.\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\telse \r\n");
      out.write("\t  {\r\n");
      out.write("\t     return true;\r\n");
      out.write("\t  }\r\n");
      out.write("\t\r\n");
      out.write("\tif(x!=\"\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\t$(\"#error-msg\").html(x);\r\n");
      out.write("\t\t$(\"#error-msg\").css(\"display\", \"block\");\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<script src=\"http://www.google-analytics.com/urchin.js\"\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t_uacct = \"UA-3192845-1\";\r\n");
      out.write("\turchinTracker();\r\n");
      out.write("</script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"scripts/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"scripts/login.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"scripts/intropage.js\"></script>\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!--[if lt IE 9]>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"scripts/html5.js\"></script>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<!--[if IE 7]>\r\n");
      out.write("\t<script src=\"http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE7.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/style-IE7.css\" type=\"text/css\" media=\"all\" />\r\n");
      out.write("<![endif]-->\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\t/* Safari/Chrome css hack */\r\n");
      out.write("\t@media screen and (-webkit-min-device-pixel-ratio:0)\r\n");
      out.write("\t{\r\n");
      out.write("\t\t.video-container{margin-top:0px!important;}\r\n");
      out.write("\t\t#sampleMovie{margin-top:0px!important;}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t#loading-container{\t\t\r\n");
      out.write("\t\tbackground:#000;\r\n");
      out.write("\t\twidth:99%;\r\n");
      out.write("\t\theight:100%;\r\n");
      out.write("\t\tmargin:auto;\t\r\n");
      out.write("\t\tmargin-left:-0.5px;\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\tz-index:10000;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.tagline-p\r\n");
      out.write("\t{\r\n");
      out.write("\t\tfont-family: \"avantgardemediumbt\", \"Avant_Garde_Gothic_Demibold\", Arial, sans-serif;\r\n");
      out.write("\t\tcolor:#FFFFFF; font-size:20px;\r\n");
      out.write("\t\tpadding-top:362px; \r\n");
      out.write("\t\ttext-align:middle;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\tvar vTglineHT\t= 0;\r\n");
      out.write("\t\tvar vOuterHT\t= $(\"#outer-container\").height() / 2;\r\n");
      out.write("\r\n");
      out.write("\t\tif(  vOuterHT > 38 )\r\n");
      out.write("\t\t\tvTglineHT\t= vOuterHT - 38;\r\n");
      out.write("\t\t$(\".tagline-p\").css(\"padding-top\", vTglineHT);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif ($.browser.msie) {\r\n");
      out.write("\t\t\t$(\".check-txt\").css({\r\n");
      out.write("\t\t\t\t'margin-top' : '-18px'\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$(\"#login-bottom3\").css({\r\n");
      out.write("\t\t\t\t'padding-left' : '26px',\r\n");
      out.write("\t\t\t\tclear : 'both'\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<audio id=\"beep\" controls preload=\"auto\" HIDDEN=\"TRUE\" style=\"display: none !important;\">\r\n");
      out.write("\t\t<source src=\"swf/assets/sound/rollover.mp3\" type=\"audio/mpeg\" />\r\n");
      out.write("\t\t<source src=\"swf/assets/sound/rollover.wav\" type=\"audio/wav\" />\r\n");
      out.write("\t</audio>\r\n");
      out.write("\t<div id=\"outer-container\">\r\n");
      out.write("\r\n");
      out.write("\t\t<!--// Loading container //-->\r\n");
      out.write("\t\t<div id=\"loading-container\" >\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fif_005f3(_jspx_page_context))
        return;
      out.write(" \r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fif_005f4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fif_005f5(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"main-container\">\r\n");
      out.write("\t\t\t<div id=\"main\">\r\n");
      out.write("\t\t\t\t<header>\r\n");
      out.write("\t\t\t\t\t<h3 id=\"enter-lnk\" onclick=\"_jqNavLinks(1);\">ENTER SITE</h3>\r\n");
      out.write("\t\t\t\t\t<img class=\"separator\" src=\"images/separator_bg.png\">\r\n");
      out.write("\t\t\t\t\t<h3 id=\"signup-lnk\" onclick=\"_jqNavLinks(2);\">SIGN UP</h3>\r\n");
      out.write("\t\t\t\t\t<img class=\"separator\" src=\"images/separator_bg.png\">\r\n");
      out.write("\t\t\t\t\t<h3 id=\"login-lnk\" onclick=\"_jqNavLinks(3);\">LOG IN</h3>\r\n");
      out.write("\t\t\t\t\t<img class=\"separator\" src=\"images/separator_bg.png\">\r\n");
      out.write("\t\t\t\t\t<h3 id=\"video-lnk\" onclick=\"_jqNavLinks(4);\">VIEW DEMO</h3>\r\n");
      out.write("\t\t\t\t</header>\r\n");
      out.write("\t\t\t\t<div id=\"logo\">\r\n");
      out.write("\t\t        \t<img src=\"images/logo.png\" alt=\"\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div id=\"site_content\">\r\n");
      out.write("\t\t\t\t\t<div class=\"sidebar-menu\">\r\n");
      out.write("\t\t\t\t\t\t<nav id=\"nav-common\" style=\"height:0px;width:0px;\" class=\"menubg flt\" >\r\n");
      out.write("\t\t\t\t\t\t\t<ul id=\"sidemenu-fixed\" class=\"menu flt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- Dynamic contents -->\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"login-box\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<!--<div class=\"login-txt\">Log in</div>-->\r\n");
      out.write("\t\t\t\t\t\t\t\t<form method=\"get\" style=\"padding-right:5px;\" class=\"signin\" onsubmit=\"setUserValues(this);\" action=\"j_security_check\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<fieldset class=\"textbox\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label class=\"username\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span id=\"error-msg\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input id=\"j_username\" name=\"j_username\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tautocomplete=\"off\" placeholder=\"ENTER USERNAME\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tonfocus=\"javascript:this.placeholder='';\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tonblur=\"javascript:this.placeholder='ENTER USERNAME';\" style=\"margin-bottom:4px;float:left;\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input id=\"j_password\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tname=\"j_password\" type=\"password\" placeholder=\"ENTER PASSWORD\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tonfocus=\"javascript:this.placeholder='';\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tonblur=\"javascript:this.placeholder='ENTER PASSWORD';\" style=\"float:left;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div id=\"login-bottom1\" style=\"height: 24px; width:360px; display:block;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<button class=\"submit button\" type=\"submit\" style=\"float:right; margin-top:6px;\" onclick=\"return checkUserPass();\"></button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div id=\"login-bottom2\" style=\"height:30px;display:block;margin-top:17px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span style=\"text-align:left; float:left; width:115px; color:#FFFFFF; position:relative; top:10px; font-weight:bold;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"rememberMe\" id=\"rememberMe\" value=\"true\" style=\"width:10px; margin-right:4px; margin-top:3px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"check-txt\" for=\"rememberMe\">Remember me</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"fname\" value=\"\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<p id=\"login-bottom3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tForgotten your password? Click <a id=\"forgot-lnk\" class=\"forgot\" href=\"javascript:void(0)\">here</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</fieldset>\r\n");
      out.write("\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"enter-box\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<!--<div class=\"enter-txt\">Enter site</div>-->\r\n");
      out.write("\t\t\t\t\t\t\t\t<p class=\"par-txt\">To enter City Golf League, please choose the city you'd like to view from the list below:</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul id=\"enter-city\" class=\"submenu flt\"></ul>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"signup-box\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<!--<div class=\"signup-txt\">Sign up</div>-->\r\n");
      out.write("\t\t\t\t\t\t\t\t<p class=\"par-txt\">Welcome to City Golf League, please select your city from the bellow:</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul id=\"signup-city\" class=\"submenu flt\"></ul>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</nav>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div id=\"demo-box\" class=\"video-container\">\r\n");
      out.write("\t\t\t\t\t\t<div id=\"btn_close_video\" class=\"btn_close\" title=\"Close\" onclick=\"_jqAutoCloseVideoPop(4);\"></div>\r\n");
      out.write("\t\t\t\t\t\t<video id=\"sampleMovie\" width=\"890\"\r\n");
      out.write("\t\t\t\t\t\t\tcontrols=\"controls\"\r\n");
      out.write("\t\t\t\t\t\t\tpreload=\"auto\"\r\n");
      out.write("\t\t\t\t\t\t\tonended=\"_jqListenVideoPop();\"\r\n");
      out.write("\t\t\t\t\t\t\tonclick=\"_jqNavToSignup();\">\r\n");
      out.write("\t\t\t\t\t\t\t<source src=\"swf/assets/demo/demo.m4v\" type=\"video/mp4\" />\r\n");
      out.write("\t\t\t\t\t\t\t<source src=\"swf/assets/demo/demo.ogv\" type=\"video/ogg\" />\r\n");
      out.write("\t\t\t\t\t\t</video>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_c_005fset_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.el.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.el.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_005fvalue_005ftarget_005fproperty_005fnobody.get(org.apache.taglibs.standard.tag.el.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    _jspx_th_c_005fset_005f0.setTarget("${rand}");
    _jspx_th_c_005fset_005f0.setProperty("min");
    _jspx_th_c_005fset_005f0.setValue("1");
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_005fvalue_005ftarget_005fproperty_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_005fvalue_005ftarget_005fproperty_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.el.core.SetTag _jspx_th_c_005fset_005f1 = (org.apache.taglibs.standard.tag.el.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_005fvalue_005ftarget_005fproperty_005fnobody.get(org.apache.taglibs.standard.tag.el.core.SetTag.class);
    _jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f1.setParent(null);
    _jspx_th_c_005fset_005f1.setTarget("${rand}");
    _jspx_th_c_005fset_005f1.setProperty("max");
    _jspx_th_c_005fset_005f1.setValue("4");
    int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
    if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_005fvalue_005ftarget_005fproperty_005fnobody.reuse(_jspx_th_c_005fset_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_005fvalue_005ftarget_005fproperty_005fnobody.reuse(_jspx_th_c_005fset_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.el.core.SetTag _jspx_th_c_005fset_005f2 = (org.apache.taglibs.standard.tag.el.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_005fvalue_005ftarget_005fproperty_005fnobody.get(org.apache.taglibs.standard.tag.el.core.SetTag.class);
    _jspx_th_c_005fset_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f2.setParent(null);
    _jspx_th_c_005fset_005f2.setTarget("${rand}");
    _jspx_th_c_005fset_005f2.setProperty("random");
    _jspx_th_c_005fset_005f2.setValue("0");
    int _jspx_eval_c_005fset_005f2 = _jspx_th_c_005fset_005f2.doStartTag();
    if (_jspx_th_c_005fset_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_005fvalue_005ftarget_005fproperty_005fnobody.reuse(_jspx_th_c_005fset_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_005fvalue_005ftarget_005fproperty_005fnobody.reuse(_jspx_th_c_005fset_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.el.core.SetTag _jspx_th_c_005fset_005f3 = (org.apache.taglibs.standard.tag.el.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.SetTag.class);
    _jspx_th_c_005fset_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f3.setParent(null);
    _jspx_th_c_005fset_005f3.setVar("vRandom");
    _jspx_th_c_005fset_005f3.setValue("${rand.random}");
    int _jspx_eval_c_005fset_005f3 = _jspx_th_c_005fset_005f3.doStartTag();
    if (_jspx_th_c_005fset_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.el.core.SetTag _jspx_th_c_005fset_005f4 = (org.apache.taglibs.standard.tag.el.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_005fvalue_005ftarget_005fproperty_005fnobody.get(org.apache.taglibs.standard.tag.el.core.SetTag.class);
    _jspx_th_c_005fset_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f4.setParent(null);
    _jspx_th_c_005fset_005f4.setTarget("${rand}");
    _jspx_th_c_005fset_005f4.setProperty("min");
    _jspx_th_c_005fset_005f4.setValue("1");
    int _jspx_eval_c_005fset_005f4 = _jspx_th_c_005fset_005f4.doStartTag();
    if (_jspx_th_c_005fset_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_005fvalue_005ftarget_005fproperty_005fnobody.reuse(_jspx_th_c_005fset_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_005fvalue_005ftarget_005fproperty_005fnobody.reuse(_jspx_th_c_005fset_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.el.core.SetTag _jspx_th_c_005fset_005f5 = (org.apache.taglibs.standard.tag.el.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_005fvalue_005ftarget_005fproperty_005fnobody.get(org.apache.taglibs.standard.tag.el.core.SetTag.class);
    _jspx_th_c_005fset_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f5.setParent(null);
    _jspx_th_c_005fset_005f5.setTarget("${rand}");
    _jspx_th_c_005fset_005f5.setProperty("max");
    _jspx_th_c_005fset_005f5.setValue("6");
    int _jspx_eval_c_005fset_005f5 = _jspx_th_c_005fset_005f5.doStartTag();
    if (_jspx_th_c_005fset_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_005fvalue_005ftarget_005fproperty_005fnobody.reuse(_jspx_th_c_005fset_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_005fvalue_005ftarget_005fproperty_005fnobody.reuse(_jspx_th_c_005fset_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.el.core.SetTag _jspx_th_c_005fset_005f6 = (org.apache.taglibs.standard.tag.el.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_005fvalue_005ftarget_005fproperty_005fnobody.get(org.apache.taglibs.standard.tag.el.core.SetTag.class);
    _jspx_th_c_005fset_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f6.setParent(null);
    _jspx_th_c_005fset_005f6.setTarget("${rand}");
    _jspx_th_c_005fset_005f6.setProperty("random");
    _jspx_th_c_005fset_005f6.setValue("0");
    int _jspx_eval_c_005fset_005f6 = _jspx_th_c_005fset_005f6.doStartTag();
    if (_jspx_th_c_005fset_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_005fvalue_005ftarget_005fproperty_005fnobody.reuse(_jspx_th_c_005fset_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_005fvalue_005ftarget_005fproperty_005fnobody.reuse(_jspx_th_c_005fset_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.el.core.SetTag _jspx_th_c_005fset_005f7 = (org.apache.taglibs.standard.tag.el.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.SetTag.class);
    _jspx_th_c_005fset_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f7.setParent(null);
    _jspx_th_c_005fset_005f7.setVar("vTagIndex");
    _jspx_th_c_005fset_005f7.setValue("${rand.random}");
    int _jspx_eval_c_005fset_005f7 = _jspx_th_c_005fset_005f7.doStartTag();
    if (_jspx_th_c_005fset_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f7);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.el.fmt.MessageTag _jspx_th_fmt_005fmessage_005f0 = (org.apache.taglibs.standard.tag.el.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.el.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f0.setParent(null);
    _jspx_th_fmt_005fmessage_005f0.setKey("webapp.name");
    int _jspx_eval_fmt_005fmessage_005f0 = _jspx_th_fmt_005fmessage_005f0.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.el.core.SetTag _jspx_th_c_005fset_005f8 = (org.apache.taglibs.standard.tag.el.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.get(org.apache.taglibs.standard.tag.el.core.SetTag.class);
    _jspx_th_c_005fset_005f8.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f8.setParent(null);
    _jspx_th_c_005fset_005f8.setVar("ctxPath");
    _jspx_th_c_005fset_005f8.setValue("${pageContext.request.contextPath}");
    _jspx_th_c_005fset_005f8.setScope("request");
    int _jspx_eval_c_005fset_005f8 = _jspx_th_c_005fset_005f8.doStartTag();
    if (_jspx_th_c_005fset_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fscope_005fnobody.reuse(_jspx_th_c_005fset_005f8);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    _jspx_th_c_005furl_005f0.setValue("/images/favicon.ico");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent(null);
    _jspx_th_c_005furl_005f1.setValue("/css/grid.css");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fchoose_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f0.setParent(null);
    int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
    if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('\r');
        out.write('\n');
        out.write('	');
        if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        out.write('	');
        if (_jspx_meth_c_005fotherwise_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
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
    _jspx_th_c_005fwhen_005f0.setTest("${ vRandom eq 3 }");
    int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
    if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t<link  rel=\"stylesheet\" type=\"text/css\" href=\"css/bg_white.css\">\r\n");
        out.write("\t");
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
        out.write("\t\t<link  rel=\"stylesheet\" type=\"text/css\" href=\"css/bg_regular.css\">\r\n");
        out.write("\t\t<style type=\"text/css\">\r\n");
        out.write("\t\t\t#main-container {\r\n");
        out.write("\t\t\t\twidth: 100%;\r\n");
        out.write("\t\t\t\theight: 100%;\r\n");
        out.write("\t\t\t\tmargin: auto;\r\n");
        out.write("\t\t\t\tbackground: #fff url(\"images/bg_img_");
        if (_jspx_meth_c_005fout_005f0(_jspx_th_c_005fotherwise_005f0, _jspx_page_context))
          return true;
        out.write(".jpg\") repeat center top;\r\n");
        out.write("\t\t\t\tmargin-left: -0.5px;\r\n");
        out.write("\t\t\t}\r\n");
        out.write("\t\t</style>\r\n");
        out.write("\t");
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

  private boolean _jspx_meth_c_005fout_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fotherwise_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.el.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fotherwise_005f0);
    _jspx_th_c_005fout_005f0.setValue("${vRandom}");
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.el.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.el.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.el.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    _jspx_th_c_005fif_005f0.setTest("${vTagIndex eq 1}");
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<p class=\"tagline-p\">Tour caddy optional</p>");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.el.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.el.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.el.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    _jspx_th_c_005fif_005f1.setTest("${vTagIndex eq 2}");
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<p class=\"tagline-p\">Get a birdie and the entire internet will know</p>");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.el.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.el.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.el.core.IfTag.class);
    _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f2.setParent(null);
    _jspx_th_c_005fif_005f2.setTest("${vTagIndex eq 3}");
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<p class=\"tagline-p\">We'll post your bragging rights online</p>");
        int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.el.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.el.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.el.core.IfTag.class);
    _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f3.setParent(null);
    _jspx_th_c_005fif_005f3.setTest("${vTagIndex eq 4}");
    int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
    if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<p class=\"tagline-p\">You athletic glory days are in front of you.</p>");
        int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.el.core.IfTag _jspx_th_c_005fif_005f4 = (org.apache.taglibs.standard.tag.el.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.el.core.IfTag.class);
    _jspx_th_c_005fif_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f4.setParent(null);
    _jspx_th_c_005fif_005f4.setTest("${vTagIndex eq 5}");
    int _jspx_eval_c_005fif_005f4 = _jspx_th_c_005fif_005f4.doStartTag();
    if (_jspx_eval_c_005fif_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<p class=\"tagline-p\">Prove it</p>");
        int evalDoAfterBody = _jspx_th_c_005fif_005f4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.el.core.IfTag _jspx_th_c_005fif_005f5 = (org.apache.taglibs.standard.tag.el.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.el.core.IfTag.class);
    _jspx_th_c_005fif_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f5.setParent(null);
    _jspx_th_c_005fif_005f5.setTest("${vTagIndex eq 6}");
    int _jspx_eval_c_005fif_005f5 = _jspx_th_c_005fif_005f5.doStartTag();
    if (_jspx_eval_c_005fif_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<p class=\"tagline-p\">Start beating new people</p>");
        int evalDoAfterBody = _jspx_th_c_005fif_005f5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f5);
    return false;
  }
}
