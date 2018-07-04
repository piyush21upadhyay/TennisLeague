package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(3);
    _jspx_dependants.add("/common/taglibs.jsp");
    _jspx_dependants.add("/WEB-INF/carter.tld");
    _jspx_dependants.add("/WEB-INF/pages/include/keyInfo.html");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fformatDate_005fvalue_005ftype_005fpattern_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdisplay_005ftable_005frequestURI_005fname_005fid_005fclass_005fcellspacing_005fcellpadding;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdisplay_005fcolumn_005furl_005ftitleKey_005fproperty_005fparamProperty_005fparamId_005fdecorator_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdisplay_005fcolumn_005ftitleKey_005fstyle_005fmaxLength;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdisplay_005ftable_005fpagesize_005fname_005fid;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdisplay_005fcaption;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdisplay_005fcolumn_005ftitleKey;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdisplay_005fcolumn_005ftitleKey_005fproperty_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_005fvar;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fcarter_005fbutton_005fpage_005fkey_005ffill_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ffmt_005fformatDate_005fvalue_005ftype_005fpattern_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdisplay_005ftable_005frequestURI_005fname_005fid_005fclass_005fcellspacing_005fcellpadding = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_005furl_005ftitleKey_005fproperty_005fparamProperty_005fparamId_005fdecorator_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_005ftitleKey_005fstyle_005fmaxLength = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdisplay_005ftable_005fpagesize_005fname_005fid = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdisplay_005fcaption = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_005ftitleKey = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_005ftitleKey_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fset_005fvar = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fcarter_005fbutton_005fpage_005fkey_005ffill_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody.release();
    _005fjspx_005ftagPool_005ffmt_005fformatDate_005fvalue_005ftype_005fpattern_005fnobody.release();
    _005fjspx_005ftagPool_005fdisplay_005ftable_005frequestURI_005fname_005fid_005fclass_005fcellspacing_005fcellpadding.release();
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_005furl_005ftitleKey_005fproperty_005fparamProperty_005fparamId_005fdecorator_005fnobody.release();
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_005ftitleKey_005fstyle_005fmaxLength.release();
    _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.release();
    _005fjspx_005ftagPool_005fdisplay_005ftable_005fpagesize_005fname_005fid.release();
    _005fjspx_005ftagPool_005fdisplay_005fcaption.release();
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_005ftitleKey.release();
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_005ftitleKey_005fproperty_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fset_005fvar.release();
    _005fjspx_005ftagPool_005fcarter_005fbutton_005fpage_005fkey_005ffill_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.release();
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
      out.write("\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\t<title>");
      if (_jspx_meth_fmt_005fmessage_005f0(_jspx_page_context))
        return;
      out.write("</title>\n");
      out.write("    <meta name=\"menu\" content=\"Welcome\"/>\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"scripts/swfobject.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t\t$(document).ready(function() {\n");
      out.write("\t\t\tvar objWeather = document.getElementById(\"home-weather\");\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t// Trim whitespace from left and right sides of s.\n");
      out.write("            function trim(s) {\n");
      out.write("                return s.replace( /^\\s*/, \"\" ).replace( /\\s*$/, \"\" );\n");
      out.write("            }\n");
      out.write("\t\t\t\n");
      out.write("\t\t\ttry\n");
      out.write("\t\t  \t{\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tvar tbodyObj = document.getElementById(\"publicMessages\").children[1];\t//tbody object\n");
      out.write("\t\t\t\tvar trArray = document.getElementById(\"publicMessages\").children[1].children;\t//tr array\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tfor(i=0; i<trArray.length; i++)\n");
      out.write("\t\t\t\t{\n");
      out.write("\t\t\t\t\tsubjectTd = trArray[i].children[1];\t// subject td\n");
      out.write("\t\t\t\t\tif(trim(subjectTd.title) != '')\n");
      out.write("\t\t\t\t\t{\n");
      out.write("\t\t\t\t\t\tsubjectTd.title = trim(subjectTd.title);\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t// Select 1st row - message box \n");
      out.write("\t\t\t\tif( navigator.userAgent.match(/msie/gi) != 'MSIE' )\n");
      out.write("\t\t\t\t{\n");
      out.write("\t\t\t\t\t$(\".tbl-msg-div td a\").eq(0).css('color','#92cf51');\n");
      out.write("\t\t\t\t\t$(\".tbl-msg-div td a\").eq(1).css('color','#92cf51');\n");
      out.write("\t\t\t\t\t$(\".tbl-msg-div td a\").eq(2).css('color','#92cf51');\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tif(navigator.userAgent.match(/msie/gi) == 'MSIE')\n");
      out.write("\t\t\t\t{\n");
      out.write("\t\t\t\t\tif(tbodyObj.children.length <= 5)\n");
      out.write("\t\t\t\t\t{\n");
      out.write("\t\t\t\t\t\t$(\"#publicMessages tbody\").css('width','322px');\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t$(\".dm-link-class\").bind(\"dblclick\", function(){\n");
      out.write("\t\t\t\t\tshowMsgContents($(this), parseInt($(this).children('input[type=\"hidden\"]').val()));\n");
      out.write("\t\t\t\t\treturn false;\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t  \t}\n");
      out.write("\t\t\tcatch(err)\n");
      out.write("\t\t  \t{\n");
      out.write("\t\t\t  \t// No need to handle exception for now...\n");
      out.write("\t\t  \t}\n");
      out.write("\t\t});\n");
      out.write("\t\t\n");
      out.write("\t\tfunction showMsgContents(objLink, msgId)\n");
      out.write("\t\t{\n");
      out.write("\t\t\tif( navigator.userAgent.match(/msie/gi) != 'MSIE' )\n");
      out.write("\t\t\t{\n");
      out.write("\t\t\t\t// Manage CSS - message box \n");
      out.write("\t\t\t\t$(\".tbl-msg-div td a\").css('color','#ffffff');\t\t\t\n");
      out.write("\t\t\t\t$(objLink).css('color','#92cf51');\t\t\t\n");
      out.write("\n");
      out.write("\t\t\t\tvar vTDSibling = $(objLink).parent().siblings();\n");
      out.write("\t\t\t\t$.each(vTDSibling, function(){\n");
      out.write("\t\t\t\t\t$(this).children().css('color','#92cf51');\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t}\n");
      out.write("\n");
      out.write("\t\t\t// Ajax call\n");
      out.write("\t\t\tvar vHTML\t= reqAjax(msgId);\n");
      out.write("\t\t\t// Embed Ajax response\n");
      out.write("\t\t\t$(\"#msg-div\").html(vHTML);\t\t\t\n");
      out.write("\t\t}\n");
      out.write("\n");
      out.write("\t\tfunction reqAjax(msgId)\n");
      out.write("\t\t{\n");
      out.write("\t\t\tvar result\t= $.ajax({\n");
      out.write("\t\t\t\turl\t\t: 'msgContent.html?msg=' + msgId,\n");
      out.write("\t\t\t\tcache\t:false,\n");
      out.write("\t\t\t\tasync\t:false\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t).responseText;\t\t\t\n");
      out.write("\n");
      out.write("\t\t\treturn result.slice(result.indexOf(\"response\") + 9, result.lastIndexOf(\"response\") - 2);\n");
      out.write("\t\t}\n");
      out.write("\n");
      out.write("\t\tfunction checkAction()\n");
      out.write("\t\t{\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t}\n");
      out.write("\t</script>\n");
      out.write("\t\n");
      out.write("\t");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("\t<!--[if IE]>\n");
      out.write("\t<style type=\"text/css\">\n");
      out.write("\t    .tbl-msg-div {position:relative; height:200px; width:330px;}\n");
      out.write("\t    #home-msgbrd table.messages thead tr th {width:105px;}\t    \n");
      out.write("\t    #home-msgbrd table.messages thead tr {position:absolute; height:30px; width:320px; top: expression(this.offsetParent.scrollTop);}\n");
      out.write("\t    #home-msgbrd table.messages tbody {position:absolute; top:30px; width:338px;}\n");
      out.write("\t    #msg-div {margin:0px;}\n");
      out.write("\t    #msg {margin-bottom:8px;}\n");
      out.write("\t</style>\n");
      out.write("\t<![endif]-->\n");
      out.write("</head>\n");
      out.write("\n");
      //  c:if
      org.apache.taglibs.standard.tag.el.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.el.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.el.core.IfTag.class);
      _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f3.setParent(null);
      _jspx_th_c_005fif_005f3.setTest("${empty errors and empty successMessages}");
      int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
      if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\n");
          out.write("<div id=\"home\">\n");
          out.write("\n");
          if (_jspx_meth_c_005fchoose_005f1(_jspx_th_c_005fif_005f3, _jspx_page_context))
            return;
          out.write("\n");
          out.write("\n");
          out.write("<marquee id=\"news-ticker\" behavior=\"scroll\" scrollamount=\"3\" direction=\"left\"><p>");
          if (_jspx_meth_c_005fout_005f3(_jspx_th_c_005fif_005f3, _jspx_page_context))
            return;
          out.write("</p></marquee>\n");
          out.write("\n");
          out.write("<div id=\"twocol-left\">\n");
          out.write("\t<div class=\"std-pad\">\n");
          out.write("\t\t<h2 class=\"page-title\">");
          if (_jspx_meth_fmt_005fmessage_005f4(_jspx_th_c_005fif_005f3, _jspx_page_context))
            return;
          out.write(' ');
          if (_jspx_meth_fmt_005fmessage_005f5(_jspx_th_c_005fif_005f3, _jspx_page_context))
            return;
          out.write("</h2>\n");
          out.write("\t    <p class=\"justify\">");
          if (_jspx_meth_fmt_005fmessage_005f6(_jspx_th_c_005fif_005f3, _jspx_page_context))
            return;
          out.write("</p>\n");
          out.write("\t\t\n");
          out.write("\t\t<div id=\"birdie-challenge\" style=\"position:relative;\">\n");
          out.write("\t\t\t");
          if (_jspx_meth_c_005fif_005f4(_jspx_th_c_005fif_005f3, _jspx_page_context))
            return;
          out.write("\n");
          out.write("\t    \t<div class=\"city-name\">");
          if (_jspx_meth_c_005fout_005f4(_jspx_th_c_005fif_005f3, _jspx_page_context))
            return;
          out.write("</div>\n");
          out.write("\t    \t<div class=\"left-msg\">\n");
          out.write("\t    \t");
          if (_jspx_meth_c_005fchoose_005f2(_jspx_th_c_005fif_005f3, _jspx_page_context))
            return;
          out.write("\n");
          out.write("\t    \t</div>\n");
          out.write("\t\t\t<div class=\"left-msg\">\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_005fchoose_005f3(_jspx_th_c_005fif_005f3, _jspx_page_context))
            return;
          out.write("\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div class=\"right-msg-1\"><i>Click here to</i></div>\n");
          out.write("\t\t\t<div class=\"right-msg-2\">SIGN UP</div>\n");
          out.write("\t\t\t<div class=\"right-msg-3\">NOW</div>\n");
          out.write("\t\t\t<div class=\"right-msg-4\"><i>Tour caddie optional</i></div>\n");
          out.write("\t    </div>\n");
          out.write("\t\n");
          out.write("\t\t<div id=\"home-info\">\n");
          out.write("\t\t\t<div class=\"left\">\n");
          out.write("\t\t\t\t<img src=\"images/keyInformation.jpg\" alt=\"Key\"/>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div class=\"left\">\n");
          out.write("\t\t\t\t<h3>");
          if (_jspx_meth_fmt_005fmessage_005f7(_jspx_th_c_005fif_005f3, _jspx_page_context))
            return;
          out.write("</h3>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div class=\"clear\"></div>\n");
          out.write("\t\t\t");
          out.write("<h2 class=\"bold\">Season begins June 9th</h2>\n");
          out.write("<p>Register now for the Spokane Golf League Summer Season. Registration is just $85. Be the first to win the Tiffany Hamilton Cup trophy*! Tour Caddie optional.</p>\n");
          out.write("<h2 class=\"bold\">Registration is FREE</h2>\n");
          out.write("<p>Not sure you are ready to compete in the league, but still want a player profile page and the ability to communicate online with other members? Then register now. It's free!</p>\n");
          out.write("<h2 class=\"bold\">Compete for Weekly Prizes</h2>\n");
          out.write("<p>Compete for prizes every week in the weekly birdie contest. Total the most net birdies in a week (for your division) and win a dozen Titleist Pro VI balls! A division winner every week during the regular season.</p>\n");
          out.write("<h2 class=\"bold\">Scheduling Matches</h2>\n");
          out.write("<p>Log on to City Golf League and send your opponent a message indicating you want to schedule your match. Click on send a message under your opponent's Player Profile Page. You can access this either from the members section or by opening your schedule and clicking on your opponent's name. </p>\n");
          out.write("<h2 class=\"bold\">Handicaps up to date?</h2>\n");
          out.write("<p>Make sure both you and your opponent have current handicaps entered in the Player Profile section. This is very important as your handicap determines who receives strokes and where they are taken. <a href=\"http://www.ghin.com/lookup.aspx\" target=\"_blank\">Click here</a> to check.</p>\n");
          out.write("<h2 class=\"bold\">City Golf League Tips</h2>\n");
          out.write("<p>Every player should print the CGL Rules and keep them on hand for reference during match play. You should also print the scorecard from the City Golf League website to avoid any confusion as to who receives strokes and on what holes strokes are taken. To access the scorecard, click on Print Card under the schedule section of the website.</p>\n");
          out.write("\n");
          out.write("\t\t</div>\n");
          out.write("\t\t\n");
          out.write("\t\t<div id=\"home-msgbrd\">\n");
          out.write("\t\t\t<div class=\"left\">\n");
          out.write("\t\t\t \t<a href=\"");
          if (_jspx_meth_c_005furl_005f1(_jspx_th_c_005fif_005f3, _jspx_page_context))
            return;
          out.write("\">\n");
          out.write("\t\t\t\t\t<img src=\"images/pubMsgBrd.jpg\" alt=\"Messages\" />\n");
          out.write("\t\t\t\t</a>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div class=\"left\">\n");
          out.write("\t\t\t\t<h3>");
          if (_jspx_meth_fmt_005fmessage_005f8(_jspx_th_c_005fif_005f3, _jspx_page_context))
            return;
          out.write("</h3>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div class=\"clear\"></div>\n");
          out.write("\t\t   \t");
          //  c:choose
          org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f4 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
          _jspx_th_c_005fchoose_005f4.setPageContext(_jspx_page_context);
          _jspx_th_c_005fchoose_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
          int _jspx_eval_c_005fchoose_005f4 = _jspx_th_c_005fchoose_005f4.doStartTag();
          if (_jspx_eval_c_005fchoose_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\n");
              out.write("\t\t\t\t");
              if (_jspx_meth_c_005fwhen_005f5(_jspx_th_c_005fchoose_005f4, _jspx_page_context))
                return;
              out.write("\n");
              out.write("\t\t  \t  \t");
              //  c:otherwise
              org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f4 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
              _jspx_th_c_005fotherwise_005f4.setPageContext(_jspx_page_context);
              _jspx_th_c_005fotherwise_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f4);
              int _jspx_eval_c_005fotherwise_005f4 = _jspx_th_c_005fotherwise_005f4.doStartTag();
              if (_jspx_eval_c_005fotherwise_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\n");
                  out.write("\t\t  \t  \t\t<div class=\"tbl-msg-div\">\n");
                  out.write("\t\t\t\t\t\t");
                  //  display:table
                  org.displaytag.tags.TableTag _jspx_th_display_005ftable_005f0 = (org.displaytag.tags.TableTag) _005fjspx_005ftagPool_005fdisplay_005ftable_005frequestURI_005fname_005fid_005fclass_005fcellspacing_005fcellpadding.get(org.displaytag.tags.TableTag.class);
                  _jspx_th_display_005ftable_005f0.setPageContext(_jspx_page_context);
                  _jspx_th_display_005ftable_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fotherwise_005f4);
                  _jspx_th_display_005ftable_005f0.setName(new String("publicMessages"));
                  _jspx_th_display_005ftable_005f0.setUid("publicMessages");
                  _jspx_th_display_005ftable_005f0.setCellspacing("0");
                  _jspx_th_display_005ftable_005f0.setCellpadding("0");
                  _jspx_th_display_005ftable_005f0.setClass("messages");
                  _jspx_th_display_005ftable_005f0.setRequestURI("");
                  int _jspx_eval_display_005ftable_005f0 = _jspx_th_display_005ftable_005f0.doStartTag();
                  if (_jspx_eval_display_005ftable_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    java.lang.Object publicMessages = null;
                    java.lang.Integer publicMessages_rowNum = null;
                    if (_jspx_eval_display_005ftable_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.pushBody();
                      _jspx_th_display_005ftable_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                      _jspx_th_display_005ftable_005f0.doInitBody();
                    }
                    publicMessages = (java.lang.Object) _jspx_page_context.findAttribute("publicMessages");
                    publicMessages_rowNum = (java.lang.Integer) _jspx_page_context.findAttribute("publicMessages_rowNum");
                    do {
                      out.write("\n");
                      out.write("\t\t\t\t    \t    ");
                      if (_jspx_meth_display_005fcolumn_005f0(_jspx_th_display_005ftable_005f0, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t\t    ");
                      if (_jspx_meth_display_005fcolumn_005f1(_jspx_th_display_005ftable_005f0, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t\t    ");
                      if (_jspx_meth_display_005fcolumn_005f2(_jspx_th_display_005ftable_005f0, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\n");
                      out.write("\t\t\t\t\t\t    ");
                      if (_jspx_meth_display_005fsetProperty_005f0(_jspx_th_display_005ftable_005f0, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t\t    ");
                      if (_jspx_meth_display_005fsetProperty_005f1(_jspx_th_display_005ftable_005f0, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t\t\t");
                      if (_jspx_meth_display_005fsetProperty_005f2(_jspx_th_display_005ftable_005f0, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t\t\t");
                      if (_jspx_meth_display_005fsetProperty_005f3(_jspx_th_display_005ftable_005f0, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t\t\t");
                      if (_jspx_meth_display_005fsetProperty_005f4(_jspx_th_display_005ftable_005f0, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t\t\t");
                      if (_jspx_meth_display_005fsetProperty_005f5(_jspx_th_display_005ftable_005f0, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t\t\t");
                      if (_jspx_meth_display_005fsetProperty_005f6(_jspx_th_display_005ftable_005f0, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t\t\t");
                      if (_jspx_meth_display_005fsetProperty_005f7(_jspx_th_display_005ftable_005f0, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t\t\t");
                      if (_jspx_meth_display_005fsetProperty_005f8(_jspx_th_display_005ftable_005f0, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t\t\t");
                      if (_jspx_meth_display_005fsetProperty_005f9(_jspx_th_display_005ftable_005f0, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t\t");
                      int evalDoAfterBody = _jspx_th_display_005ftable_005f0.doAfterBody();
                      publicMessages = (java.lang.Object) _jspx_page_context.findAttribute("publicMessages");
                      publicMessages_rowNum = (java.lang.Integer) _jspx_page_context.findAttribute("publicMessages_rowNum");
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                    if (_jspx_eval_display_005ftable_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.popBody();
                    }
                  }
                  if (_jspx_th_display_005ftable_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _005fjspx_005ftagPool_005fdisplay_005ftable_005frequestURI_005fname_005fid_005fclass_005fcellspacing_005fcellpadding.reuse(_jspx_th_display_005ftable_005f0);
                    return;
                  }
                  _005fjspx_005ftagPool_005fdisplay_005ftable_005frequestURI_005fname_005fid_005fclass_005fcellspacing_005fcellpadding.reuse(_jspx_th_display_005ftable_005f0);
                  out.write("\n");
                  out.write("\t\t\t\t\t</div>\n");
                  out.write("\t\t     \t");
                  int evalDoAfterBody = _jspx_th_c_005fotherwise_005f4.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_c_005fotherwise_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f4);
                return;
              }
              _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f4);
              out.write("\n");
              out.write("\t\t   \t");
              int evalDoAfterBody = _jspx_th_c_005fchoose_005f4.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_c_005fchoose_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f4);
            return;
          }
          _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f4);
          out.write("\n");
          out.write("\t\t\t\n");
          out.write("\t\t\t");
          if (_jspx_meth_c_005fif_005f5(_jspx_th_c_005fif_005f3, _jspx_page_context))
            return;
          out.write("\n");
          out.write("\t\t   \t\n");
          out.write("\t\t   \t<a class=\"green ie-post-link\" onclick=\"checkAction();\">\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_fmt_005fmessage_005f10(_jspx_th_c_005fif_005f3, _jspx_page_context))
            return;
          out.write("\n");
          out.write("\t  \t\t</a>\n");
          out.write("\t\t</div>\n");
          out.write("\t</div>\n");
          out.write("</div>\n");
          out.write("\n");
          out.write("<div id=\"twocol-right\">\n");
          out.write("\t<div id=\"home-leaderboard\">\n");
          out.write("\t\t<h2>");
          if (_jspx_meth_fmt_005fmessage_005f11(_jspx_th_c_005fif_005f3, _jspx_page_context))
            return;
          out.write("</h2>\n");
          out.write("\t\t");
          //  c:choose
          org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f5 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
          _jspx_th_c_005fchoose_005f5.setPageContext(_jspx_page_context);
          _jspx_th_c_005fchoose_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
          int _jspx_eval_c_005fchoose_005f5 = _jspx_th_c_005fchoose_005f5.doStartTag();
          if (_jspx_eval_c_005fchoose_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\n");
              out.write("\t\t\t");
              if (_jspx_meth_c_005fwhen_005f6(_jspx_th_c_005fchoose_005f5, _jspx_page_context))
                return;
              out.write("\n");
              out.write("\t\t\t");
              //  c:otherwise
              org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f5 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
              _jspx_th_c_005fotherwise_005f5.setPageContext(_jspx_page_context);
              _jspx_th_c_005fotherwise_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f5);
              int _jspx_eval_c_005fotherwise_005f5 = _jspx_th_c_005fotherwise_005f5.doStartTag();
              if (_jspx_eval_c_005fotherwise_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\n");
                  out.write("\t\t\t\t<div>\n");
                  out.write("\t\t\t\t\t");
                  //  display:table
                  org.displaytag.tags.TableTag _jspx_th_display_005ftable_005f1 = (org.displaytag.tags.TableTag) _005fjspx_005ftagPool_005fdisplay_005ftable_005fpagesize_005fname_005fid.get(org.displaytag.tags.TableTag.class);
                  _jspx_th_display_005ftable_005f1.setPageContext(_jspx_page_context);
                  _jspx_th_display_005ftable_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fotherwise_005f5);
                  _jspx_th_display_005ftable_005f1.setUid("standings");
                  _jspx_th_display_005ftable_005f1.setName(new String("standings"));
                  _jspx_th_display_005ftable_005f1.setPagesize(10);
                  int _jspx_eval_display_005ftable_005f1 = _jspx_th_display_005ftable_005f1.doStartTag();
                  if (_jspx_eval_display_005ftable_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    java.lang.Object standings = null;
                    java.lang.Integer standings_rowNum = null;
                    if (_jspx_eval_display_005ftable_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.pushBody();
                      _jspx_th_display_005ftable_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                      _jspx_th_display_005ftable_005f1.doInitBody();
                    }
                    standings = (java.lang.Object) _jspx_page_context.findAttribute("standings");
                    standings_rowNum = (java.lang.Integer) _jspx_page_context.findAttribute("standings_rowNum");
                    do {
                      out.write("\n");
                      out.write("\t\t\t\t\t\t");
                      if (_jspx_meth_display_005fcaption_005f0(_jspx_th_display_005ftable_005f1, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t\t");
                      //  display:column
                      org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f3 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_005ftitleKey.get(org.displaytag.tags.ColumnTag.class);
                      _jspx_th_display_005fcolumn_005f3.setPageContext(_jspx_page_context);
                      _jspx_th_display_005fcolumn_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f1);
                      _jspx_th_display_005fcolumn_005f3.setTitleKey("home.position");
                      int _jspx_eval_display_005fcolumn_005f3 = _jspx_th_display_005fcolumn_005f3.doStartTag();
                      if (_jspx_eval_display_005fcolumn_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        if (_jspx_eval_display_005fcolumn_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                          out = _jspx_page_context.pushBody();
                          _jspx_th_display_005fcolumn_005f3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                          _jspx_th_display_005fcolumn_005f3.doInitBody();
                        }
                        do {
                          out.print(pageContext.getAttribute("standings_rowNum"));
                          int evalDoAfterBody = _jspx_th_display_005fcolumn_005f3.doAfterBody();
                          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                            break;
                        } while (true);
                        if (_jspx_eval_display_005fcolumn_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                          out = _jspx_page_context.popBody();
                        }
                      }
                      if (_jspx_th_display_005fcolumn_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        _005fjspx_005ftagPool_005fdisplay_005fcolumn_005ftitleKey.reuse(_jspx_th_display_005fcolumn_005f3);
                        return;
                      }
                      _005fjspx_005ftagPool_005fdisplay_005fcolumn_005ftitleKey.reuse(_jspx_th_display_005fcolumn_005f3);
                      out.write("\n");
                      out.write("\t\t\t\t\t\t");
                      if (_jspx_meth_display_005fcolumn_005f4(_jspx_th_display_005ftable_005f1, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t\t");
                      if (_jspx_meth_display_005fcolumn_005f5(_jspx_th_display_005ftable_005f1, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t\t\n");
                      out.write("\t\t\t\t\t\t");
                      if (_jspx_meth_display_005fsetProperty_005f10(_jspx_th_display_005ftable_005f1, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t\t");
                      if (_jspx_meth_display_005fsetProperty_005f11(_jspx_th_display_005ftable_005f1, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t\t");
                      if (_jspx_meth_display_005fsetProperty_005f12(_jspx_th_display_005ftable_005f1, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t\t");
                      if (_jspx_meth_display_005fsetProperty_005f13(_jspx_th_display_005ftable_005f1, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t\t");
                      if (_jspx_meth_display_005fsetProperty_005f14(_jspx_th_display_005ftable_005f1, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t\t");
                      if (_jspx_meth_display_005fsetProperty_005f15(_jspx_th_display_005ftable_005f1, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t\t");
                      if (_jspx_meth_display_005fsetProperty_005f16(_jspx_th_display_005ftable_005f1, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t\t");
                      if (_jspx_meth_display_005fsetProperty_005f17(_jspx_th_display_005ftable_005f1, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t\t");
                      if (_jspx_meth_display_005fsetProperty_005f18(_jspx_th_display_005ftable_005f1, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t\t");
                      if (_jspx_meth_display_005fsetProperty_005f19(_jspx_th_display_005ftable_005f1, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("\t\t\t\t\t");
                      int evalDoAfterBody = _jspx_th_display_005ftable_005f1.doAfterBody();
                      standings = (java.lang.Object) _jspx_page_context.findAttribute("standings");
                      standings_rowNum = (java.lang.Integer) _jspx_page_context.findAttribute("standings_rowNum");
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                    if (_jspx_eval_display_005ftable_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.popBody();
                    }
                  }
                  if (_jspx_th_display_005ftable_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _005fjspx_005ftagPool_005fdisplay_005ftable_005fpagesize_005fname_005fid.reuse(_jspx_th_display_005ftable_005f1);
                    return;
                  }
                  _005fjspx_005ftagPool_005fdisplay_005ftable_005fpagesize_005fname_005fid.reuse(_jspx_th_display_005ftable_005f1);
                  out.write("\n");
                  out.write("\t\t\t\t</div>\n");
                  out.write("\t\t\t");
                  int evalDoAfterBody = _jspx_th_c_005fotherwise_005f5.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_c_005fotherwise_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f5);
                return;
              }
              _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f5);
              out.write('\n');
              out.write('	');
              out.write('	');
              int evalDoAfterBody = _jspx_th_c_005fchoose_005f5.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_c_005fchoose_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f5);
            return;
          }
          _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f5);
          out.write("\n");
          out.write("\n");
          out.write("\t\t");
          if (_jspx_meth_c_005fset_005f0(_jspx_th_c_005fif_005f3, _jspx_page_context))
            return;
          out.write("\n");
          out.write("\n");
          out.write("\t\t");
          if (_jspx_meth_carter_005fbutton_005f0(_jspx_th_c_005fif_005f3, _jspx_page_context))
            return;
          out.write("\n");
          out.write("\n");
          out.write("\t\t<div>\n");
          out.write("\t\t\t<form id=\"leaderboard-form\" name=\"leaderboardForm\" action=\"home.html\">\n");
          out.write("\t\t\t\t<select id=\"division\" name=\"division\" onchange=\"document.leaderboardForm.submit()\" >\n");
          out.write("\t\t\t\t\t<option value=\"0\">");
          if (_jspx_meth_fmt_005fmessage_005f16(_jspx_th_c_005fif_005f3, _jspx_page_context))
            return;
          out.write("</option>\n");
          out.write("\t\t\t\t\t");
          if (_jspx_meth_c_005fforEach_005f0(_jspx_th_c_005fif_005f3, _jspx_page_context))
            return;
          out.write("\n");
          out.write("\t\t\t\t</select>\n");
          out.write("\t\t\t</form>\n");
          out.write("\t\t</div>\n");
          out.write("\t\t\n");
          out.write("\t\t<div>\n");
          out.write("\t\t\t<select id=\"matchCat\" name=\"matchCat\" >\n");
          out.write("\t\t\t\t");
          out.write("\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_005fforEach_005f1(_jspx_th_c_005fif_005f3, _jspx_page_context))
            return;
          out.write("\n");
          out.write("\t\t\t</select>\n");
          out.write("\t\t</div>\n");
          out.write("\t</div>\n");
          out.write("\n");
          out.write("\t<div id=\"home-weather\" class=\"orange-title\">\n");
          out.write("\t\t");
          if (_jspx_meth_c_005fif_005f6(_jspx_th_c_005fif_005f3, _jspx_page_context))
            return;
          out.write("\n");
          out.write("\t</div>\n");
          out.write("</div>\n");
          out.write("</div>\n");
          out.write("\n");
          int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f3);
        return;
      }
      _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f3);
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

  private boolean _jspx_meth_fmt_005fmessage_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.el.fmt.MessageTag _jspx_th_fmt_005fmessage_005f0 = (org.apache.taglibs.standard.tag.el.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.el.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f0.setParent(null);
    _jspx_th_fmt_005fmessage_005f0.setKey("home.title");
    int _jspx_eval_fmt_005fmessage_005f0 = _jspx_th_fmt_005fmessage_005f0.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f0);
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
    _jspx_th_c_005furl_005f0.setValue("/scripts/jquery.marquee.js");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
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
    _jspx_th_c_005fif_005f0.setTest("${not empty weather}");
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        if (_jspx_meth_c_005fif_005f1(_jspx_th_c_005fif_005f0, _jspx_page_context))
          return true;
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

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.el.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.el.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.el.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
    _jspx_th_c_005fif_005f1.setTest("${not empty weather.icon and not empty weather.high and not empty weather.low}");
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\tobjWeatherDiv = objWeather.children[1];\t//weather div object\n");
        out.write("\t\t\t\tobjImg = objWeatherDiv.children[0].children[0];\t//weather image object\n");
        out.write("\t\t\t\tobjImg.style.height = \"100px\";\n");
        out.write("\t\t\t\tobjImg.style.width = \"100px\";\n");
        out.write("\t\t\t\t");
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
        out.write("\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_c_005fotherwise_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t");
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
    _jspx_th_c_005fwhen_005f0.setTest("${not empty user}");
    int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
    if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\tlocation.href = 'msgboard.html?post=true';\n");
        out.write("\t\t\t\t");
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
        out.write("\n");
        out.write("\t\t\t\t\tcglAlert('Invalid Action',\"You must be logged in to post a message.\",300);\n");
        out.write("\t\t\t\t\t$(\".ui-dialog-overlay\").width(document.body.clientWidth);\n");
        out.write("\t\t\t\t");
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

  private boolean _jspx_meth_c_005fif_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.el.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.el.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.el.core.IfTag.class);
    _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f2.setParent(null);
    _jspx_th_c_005fif_005f2.setTest("${empty user}");
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t<style type=\"text/css\">\n");
        out.write("\t\t.signup-span\n");
        out.write("\t\t{\n");
        out.write("\t\t\tposition:absolute;\n");
        out.write("\t\t\tleft:22px;\n");
        out.write("\t\t\ttop:473px;\n");
        out.write("\t\t\twidth:637px;\n");
        out.write("\t\t\theight:178px;\n");
        out.write("\t\t\tz-index:1;\n");
        out.write("\t\t}\n");
        out.write("\t</style>\n");
        out.write("\t");
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

  private boolean _jspx_meth_c_005fchoose_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f1 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    int _jspx_eval_c_005fchoose_005f1 = _jspx_th_c_005fchoose_005f1.doStartTag();
    if (_jspx_eval_c_005fchoose_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('\n');
        out.write('	');
        if (_jspx_meth_c_005fwhen_005f1(_jspx_th_c_005fchoose_005f1, _jspx_page_context))
          return true;
        out.write('\n');
        out.write('	');
        if (_jspx_meth_c_005fwhen_005f2(_jspx_th_c_005fchoose_005f1, _jspx_page_context))
          return true;
        out.write('\n');
        out.write('	');
        if (_jspx_meth_c_005fotherwise_005f1(_jspx_th_c_005fchoose_005f1, _jspx_page_context))
          return true;
        out.write('\n');
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.el.core.WhenTag _jspx_th_c_005fwhen_005f1 = (org.apache.taglibs.standard.tag.el.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_005ftest.get(org.apache.taglibs.standard.tag.el.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f1);
    _jspx_th_c_005fwhen_005f1.setTest("${seasonStarted eq 1 and not empty playOffCountdownDays}");
    int _jspx_eval_c_005fwhen_005f1 = _jspx_th_c_005fwhen_005f1.doStartTag();
    if (_jspx_eval_c_005fwhen_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t<div id=\"header-home\">\n");
        out.write("\t\t\t<div id=\"header-home-text\">\n");
        out.write("\t\t\t\t<div class=\"count-down\">");
        if (_jspx_meth_fmt_005fmessage_005f1(_jspx_th_c_005fwhen_005f1, _jspx_page_context))
          return true;
        out.write("</div>\n");
        out.write("\t\t\t\t<div class=\"count-down-days\">");
        if (_jspx_meth_c_005fout_005f0(_jspx_th_c_005fwhen_005f1, _jspx_page_context))
          return true;
        out.write("</div>\n");
        out.write("\t\t\t\t<div class=\"count-down\">");
        if (_jspx_meth_fmt_005fmessage_005f2(_jspx_th_c_005fwhen_005f1, _jspx_page_context))
          return true;
        out.write("</div>\n");
        out.write("\t\t \t</div>\n");
        out.write("\t\t</div>\n");
        out.write("\t");
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

  private boolean _jspx_meth_fmt_005fmessage_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.el.fmt.MessageTag _jspx_th_fmt_005fmessage_005f1 = (org.apache.taglibs.standard.tag.el.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.el.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f1.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f1);
    _jspx_th_fmt_005fmessage_005f1.setKey("home.playoff");
    int _jspx_eval_fmt_005fmessage_005f1 = _jspx_th_fmt_005fmessage_005f1.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.el.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f1);
    _jspx_th_c_005fout_005f0.setValue("${playOffCountdownDays}");
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.el.fmt.MessageTag _jspx_th_fmt_005fmessage_005f2 = (org.apache.taglibs.standard.tag.el.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.el.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f2.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f1);
    _jspx_th_fmt_005fmessage_005f2.setKey("home.days");
    int _jspx_eval_fmt_005fmessage_005f2 = _jspx_th_fmt_005fmessage_005f2.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.el.core.WhenTag _jspx_th_c_005fwhen_005f2 = (org.apache.taglibs.standard.tag.el.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_005ftest.get(org.apache.taglibs.standard.tag.el.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f1);
    _jspx_th_c_005fwhen_005f2.setTest("${not empty countdownMessage and seasonStarted ne 2}");
    int _jspx_eval_c_005fwhen_005f2 = _jspx_th_c_005fwhen_005f2.doStartTag();
    if (_jspx_eval_c_005fwhen_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t<div id=\"header-home\">\n");
        out.write("\t\t\t<div id=\"header-home-text\">\n");
        out.write("\t\t\t\t<div class=\"count-down\">");
        if (_jspx_meth_c_005fout_005f1(_jspx_th_c_005fwhen_005f2, _jspx_page_context))
          return true;
        out.write("</div>\n");
        out.write("\t\t\t    <div class=\"count-down-days\">");
        if (_jspx_meth_c_005fout_005f2(_jspx_th_c_005fwhen_005f2, _jspx_page_context))
          return true;
        out.write("</div>\n");
        out.write("\t\t\t    <div class=\"count-down\">");
        if (_jspx_meth_fmt_005fmessage_005f3(_jspx_th_c_005fwhen_005f2, _jspx_page_context))
          return true;
        out.write("</div>\n");
        out.write("\t   \t\t</div>\n");
        out.write("\t  \t</div>\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_005ftest.reuse(_jspx_th_c_005fwhen_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_005ftest.reuse(_jspx_th_c_005fwhen_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_005fout_005f1 = (org.apache.taglibs.standard.tag.el.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_005fout_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f2);
    _jspx_th_c_005fout_005f1.setValue("${countdownMessage}");
    int _jspx_eval_c_005fout_005f1 = _jspx_th_c_005fout_005f1.doStartTag();
    if (_jspx_th_c_005fout_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_005fout_005f2 = (org.apache.taglibs.standard.tag.el.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_005fout_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f2);
    _jspx_th_c_005fout_005f2.setValue("${countdownDays}");
    int _jspx_eval_c_005fout_005f2 = _jspx_th_c_005fout_005f2.doStartTag();
    if (_jspx_th_c_005fout_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.el.fmt.MessageTag _jspx_th_fmt_005fmessage_005f3 = (org.apache.taglibs.standard.tag.el.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.el.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f3.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f2);
    _jspx_th_fmt_005fmessage_005f3.setKey("home.days");
    int _jspx_eval_fmt_005fmessage_005f3 = _jspx_th_fmt_005fmessage_005f3.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f1 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_005fotherwise_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fotherwise_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f1);
    int _jspx_eval_c_005fotherwise_005f1 = _jspx_th_c_005fotherwise_005f1.doStartTag();
    if (_jspx_eval_c_005fotherwise_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t<div id=\"header-home-none\"></div>\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_c_005fotherwise_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fotherwise_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_005fout_005f3 = (org.apache.taglibs.standard.tag.el.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_005fout_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    _jspx_th_c_005fout_005f3.setValue("${tickerMessages}");
    _jspx_th_c_005fout_005f3.setEscapeXml("false");
    int _jspx_eval_c_005fout_005f3 = _jspx_th_c_005fout_005f3.doStartTag();
    if (_jspx_th_c_005fout_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f3);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.el.fmt.MessageTag _jspx_th_fmt_005fmessage_005f4 = (org.apache.taglibs.standard.tag.el.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.el.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f4.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    _jspx_th_fmt_005fmessage_005f4.setKey("home.welcomeTo");
    int _jspx_eval_fmt_005fmessage_005f4 = _jspx_th_fmt_005fmessage_005f4.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f4);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.el.fmt.MessageTag _jspx_th_fmt_005fmessage_005f5 = (org.apache.taglibs.standard.tag.el.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.el.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f5.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    _jspx_th_fmt_005fmessage_005f5.setKey("webapp.name");
    int _jspx_eval_fmt_005fmessage_005f5 = _jspx_th_fmt_005fmessage_005f5.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f5);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.el.fmt.MessageTag _jspx_th_fmt_005fmessage_005f6 = (org.apache.taglibs.standard.tag.el.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.el.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f6.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    _jspx_th_fmt_005fmessage_005f6.setKey("home.intro");
    int _jspx_eval_fmt_005fmessage_005f6 = _jspx_th_fmt_005fmessage_005f6.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.el.core.IfTag _jspx_th_c_005fif_005f4 = (org.apache.taglibs.standard.tag.el.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.el.core.IfTag.class);
    _jspx_th_c_005fif_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    _jspx_th_c_005fif_005f4.setTest("${empty user}");
    int _jspx_eval_c_005fif_005f4 = _jspx_th_c_005fif_005f4.doStartTag();
    if (_jspx_eval_c_005fif_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t<a href=\"signup.html\"  style=\"position: absolute; z-index: 1000; left:0; top:0;\n");
        out.write("\t\t\twidth: 630px; height: 171px; background:#fff; filter: alpha(opacity=0); opacity:0; \n");
        out.write("\t\t\t-moz-opacity:0; -webkit-opacity:0;\n");
        out.write("\t\t\toutline:none;\">  &nbsp;\n");
        out.write("\t\t\t</a>\n");
        out.write("\t\t\t");
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

  private boolean _jspx_meth_c_005fout_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_005fout_005f4 = (org.apache.taglibs.standard.tag.el.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_005fout_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    _jspx_th_c_005fout_005f4.setValue("${cityName}");
    int _jspx_eval_c_005fout_005f4 = _jspx_th_c_005fout_005f4.doStartTag();
    if (_jspx_th_c_005fout_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fchoose_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f2 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    int _jspx_eval_c_005fchoose_005f2 = _jspx_th_c_005fchoose_005f2.doStartTag();
    if (_jspx_eval_c_005fchoose_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t    \t\t");
        if (_jspx_meth_c_005fwhen_005f3(_jspx_th_c_005fchoose_005f2, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_c_005fotherwise_005f2(_jspx_th_c_005fchoose_005f2, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.el.core.WhenTag _jspx_th_c_005fwhen_005f3 = (org.apache.taglibs.standard.tag.el.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_005ftest.get(org.apache.taglibs.standard.tag.el.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f2);
    _jspx_th_c_005fwhen_005f3.setTest("${not empty countdownDate}");
    int _jspx_eval_c_005fwhen_005f3 = _jspx_th_c_005fwhen_005f3.doStartTag();
    if (_jspx_eval_c_005fwhen_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("Opens for Season");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_005ftest.reuse(_jspx_th_c_005fwhen_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_005ftest.reuse(_jspx_th_c_005fwhen_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f2 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_005fotherwise_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fotherwise_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f2);
    int _jspx_eval_c_005fotherwise_005f2 = _jspx_th_c_005fotherwise_005f2.doStartTag();
    if (_jspx_eval_c_005fotherwise_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("&nbsp;");
        int evalDoAfterBody = _jspx_th_c_005fotherwise_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fotherwise_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fchoose_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f3 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    int _jspx_eval_c_005fchoose_005f3 = _jspx_th_c_005fchoose_005f3.doStartTag();
    if (_jspx_eval_c_005fchoose_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t    \t\t");
        if (_jspx_meth_c_005fwhen_005f4(_jspx_th_c_005fchoose_005f3, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_c_005fotherwise_005f3(_jspx_th_c_005fchoose_005f3, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.el.core.WhenTag _jspx_th_c_005fwhen_005f4 = (org.apache.taglibs.standard.tag.el.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_005ftest.get(org.apache.taglibs.standard.tag.el.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f3);
    _jspx_th_c_005fwhen_005f4.setTest("${not empty countdownDate}");
    int _jspx_eval_c_005fwhen_005f4 = _jspx_th_c_005fwhen_005f4.doStartTag();
    if (_jspx_eval_c_005fwhen_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t    \t\tRegistration ");
        if (_jspx_meth_fmt_005fformatDate_005f0(_jspx_th_c_005fwhen_005f4, _jspx_page_context))
          return true;
        out.write("<sup>");
        if (_jspx_meth_c_005fout_005f5(_jspx_th_c_005fwhen_005f4, _jspx_page_context))
          return true;
        out.write("</sup>\n");
        out.write("\t\t    \t\t");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_005ftest.reuse(_jspx_th_c_005fwhen_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_005ftest.reuse(_jspx_th_c_005fwhen_005f4);
    return false;
  }

  private boolean _jspx_meth_fmt_005fformatDate_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.el.fmt.FormatDateTag _jspx_th_fmt_005fformatDate_005f0 = (org.apache.taglibs.standard.tag.el.fmt.FormatDateTag) _005fjspx_005ftagPool_005ffmt_005fformatDate_005fvalue_005ftype_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.el.fmt.FormatDateTag.class);
    _jspx_th_fmt_005fformatDate_005f0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatDate_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f4);
    _jspx_th_fmt_005fformatDate_005f0.setType("date");
    _jspx_th_fmt_005fformatDate_005f0.setPattern("MMMM d");
    _jspx_th_fmt_005fformatDate_005f0.setValue("${countdownDate}");
    int _jspx_eval_fmt_005fformatDate_005f0 = _jspx_th_fmt_005fformatDate_005f0.doStartTag();
    if (_jspx_th_fmt_005fformatDate_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatDate_005fvalue_005ftype_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatDate_005fvalue_005ftype_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_005fout_005f5 = (org.apache.taglibs.standard.tag.el.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_005fout_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f4);
    _jspx_th_c_005fout_005f5.setValue("${dateSuffix}");
    int _jspx_eval_c_005fout_005f5 = _jspx_th_c_005fout_005f5.doStartTag();
    if (_jspx_th_c_005fout_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f3 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_005fotherwise_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fotherwise_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f3);
    int _jspx_eval_c_005fotherwise_005f3 = _jspx_th_c_005fotherwise_005f3.doStartTag();
    if (_jspx_eval_c_005fotherwise_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("&nbsp;");
        int evalDoAfterBody = _jspx_th_c_005fotherwise_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fotherwise_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f3);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.el.fmt.MessageTag _jspx_th_fmt_005fmessage_005f7 = (org.apache.taglibs.standard.tag.el.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.el.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f7.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    _jspx_th_fmt_005fmessage_005f7.setKey("home.keyinfo");
    int _jspx_eval_fmt_005fmessage_005f7 = _jspx_th_fmt_005fmessage_005f7.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f7);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    _jspx_th_c_005furl_005f1.setValue("msgboard.html");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f8(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.el.fmt.MessageTag _jspx_th_fmt_005fmessage_005f8 = (org.apache.taglibs.standard.tag.el.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.el.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f8.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    _jspx_th_fmt_005fmessage_005f8.setKey("home.msgbrdHeader");
    int _jspx_eval_fmt_005fmessage_005f8 = _jspx_th_fmt_005fmessage_005f8.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f8);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.el.core.WhenTag _jspx_th_c_005fwhen_005f5 = (org.apache.taglibs.standard.tag.el.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_005ftest.get(org.apache.taglibs.standard.tag.el.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f4);
    _jspx_th_c_005fwhen_005f5.setTest("${empty publicMessages}");
    int _jspx_eval_c_005fwhen_005f5 = _jspx_th_c_005fwhen_005f5.doStartTag();
    if (_jspx_eval_c_005fwhen_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t \t\t\t<div class=\"nomessages\">");
        if (_jspx_meth_fmt_005fmessage_005f9(_jspx_th_c_005fwhen_005f5, _jspx_page_context))
          return true;
        out.write("</div>\n");
        out.write("\t\t     \t");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_005ftest.reuse(_jspx_th_c_005fwhen_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_005ftest.reuse(_jspx_th_c_005fwhen_005f5);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f9(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f5, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.el.fmt.MessageTag _jspx_th_fmt_005fmessage_005f9 = (org.apache.taglibs.standard.tag.el.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.el.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f9.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f5);
    _jspx_th_fmt_005fmessage_005f9.setKey("home.noMessages");
    int _jspx_eval_fmt_005fmessage_005f9 = _jspx_th_fmt_005fmessage_005f9.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f9);
    return false;
  }

  private boolean _jspx_meth_display_005fcolumn_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f0 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_005furl_005ftitleKey_005fproperty_005fparamProperty_005fparamId_005fdecorator_005fnobody.get(org.displaytag.tags.ColumnTag.class);
    _jspx_th_display_005fcolumn_005f0.setPageContext(_jspx_page_context);
    _jspx_th_display_005fcolumn_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
    _jspx_th_display_005fcolumn_005f0.setProperty("poster.fullName");
    _jspx_th_display_005fcolumn_005f0.setTitleKey("home.from");
    _jspx_th_display_005fcolumn_005f0.setUrl("/profile.html");
    _jspx_th_display_005fcolumn_005f0.setParamId("id");
    _jspx_th_display_005fcolumn_005f0.setParamProperty("poster.id");
    _jspx_th_display_005fcolumn_005f0.setDecorator("com.sageconsulting.webapp.decorators.MessageTextColumnDecorator");
    int _jspx_eval_display_005fcolumn_005f0 = _jspx_th_display_005fcolumn_005f0.doStartTag();
    if (_jspx_th_display_005fcolumn_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_005furl_005ftitleKey_005fproperty_005fparamProperty_005fparamId_005fdecorator_005fnobody.reuse(_jspx_th_display_005fcolumn_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_005furl_005ftitleKey_005fproperty_005fparamProperty_005fparamId_005fdecorator_005fnobody.reuse(_jspx_th_display_005fcolumn_005f0);
    return false;
  }

  private boolean _jspx_meth_display_005fcolumn_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f1 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_005ftitleKey_005fstyle_005fmaxLength.get(org.displaytag.tags.ColumnTag.class);
    _jspx_th_display_005fcolumn_005f1.setPageContext(_jspx_page_context);
    _jspx_th_display_005fcolumn_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
    _jspx_th_display_005fcolumn_005f1.setTitleKey("home.subject");
    _jspx_th_display_005fcolumn_005f1.setMaxLength(25);
    _jspx_th_display_005fcolumn_005f1.setStyle("whitespace: nowrap;");
    int _jspx_eval_display_005fcolumn_005f1 = _jspx_th_display_005fcolumn_005f1.doStartTag();
    if (_jspx_eval_display_005fcolumn_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_display_005fcolumn_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_display_005fcolumn_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_display_005fcolumn_005f1.doInitBody();
      }
      do {
        out.write("\n");
        out.write("\t\t\t\t\t\t\t\t<a href=\"#\" class=\"dm-link-class\" onclick=\"return false;\"><input type=\"hidden\" value=\"");
        if (_jspx_meth_c_005fout_005f6(_jspx_th_display_005fcolumn_005f1, _jspx_page_context))
          return true;
        out.write('"');
        out.write('/');
        out.write('>');
        if (_jspx_meth_c_005fout_005f7(_jspx_th_display_005fcolumn_005f1, _jspx_page_context))
          return true;
        out.write("</a>\n");
        out.write("\t\t\t    \t\t\t");
        int evalDoAfterBody = _jspx_th_display_005fcolumn_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_display_005fcolumn_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_display_005fcolumn_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_005ftitleKey_005fstyle_005fmaxLength.reuse(_jspx_th_display_005fcolumn_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_005ftitleKey_005fstyle_005fmaxLength.reuse(_jspx_th_display_005fcolumn_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005fcolumn_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_005fout_005f6 = (org.apache.taglibs.standard.tag.el.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_005fout_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005fcolumn_005f1);
    _jspx_th_c_005fout_005f6.setValue("${publicMessages.id}");
    int _jspx_eval_c_005fout_005f6 = _jspx_th_c_005fout_005f6.doStartTag();
    if (_jspx_th_c_005fout_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005fcolumn_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_005fout_005f7 = (org.apache.taglibs.standard.tag.el.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_005fout_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005fcolumn_005f1);
    _jspx_th_c_005fout_005f7.setValue("${publicMessages.subject}");
    int _jspx_eval_c_005fout_005f7 = _jspx_th_c_005fout_005f7.doStartTag();
    if (_jspx_th_c_005fout_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f7);
    return false;
  }

  private boolean _jspx_meth_display_005fcolumn_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f2 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_005furl_005ftitleKey_005fproperty_005fparamProperty_005fparamId_005fdecorator_005fnobody.get(org.displaytag.tags.ColumnTag.class);
    _jspx_th_display_005fcolumn_005f2.setPageContext(_jspx_page_context);
    _jspx_th_display_005fcolumn_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
    _jspx_th_display_005fcolumn_005f2.setProperty("date");
    _jspx_th_display_005fcolumn_005f2.setTitleKey("home.date");
    _jspx_th_display_005fcolumn_005f2.setUrl("/home.html");
    _jspx_th_display_005fcolumn_005f2.setParamId("msg");
    _jspx_th_display_005fcolumn_005f2.setParamProperty("id");
    _jspx_th_display_005fcolumn_005f2.setDecorator("com.sageconsulting.webapp.decorators.MessageDateColumnDecorator");
    int _jspx_eval_display_005fcolumn_005f2 = _jspx_th_display_005fcolumn_005f2.doStartTag();
    if (_jspx_th_display_005fcolumn_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_005furl_005ftitleKey_005fproperty_005fparamProperty_005fparamId_005fdecorator_005fnobody.reuse(_jspx_th_display_005fcolumn_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_005furl_005ftitleKey_005fproperty_005fparamProperty_005fparamId_005fdecorator_005fnobody.reuse(_jspx_th_display_005fcolumn_005f2);
    return false;
  }

  private boolean _jspx_meth_display_005fsetProperty_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:setProperty
    org.displaytag.tags.SetPropertyTag _jspx_th_display_005fsetProperty_005f0 = (org.displaytag.tags.SetPropertyTag) _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.get(org.displaytag.tags.SetPropertyTag.class);
    _jspx_th_display_005fsetProperty_005f0.setPageContext(_jspx_page_context);
    _jspx_th_display_005fsetProperty_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
    _jspx_th_display_005fsetProperty_005f0.setName("basic.empty.showtable");
    _jspx_th_display_005fsetProperty_005f0.setValue("false");
    int _jspx_eval_display_005fsetProperty_005f0 = _jspx_th_display_005fsetProperty_005f0.doStartTag();
    if (_jspx_th_display_005fsetProperty_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f0);
    return false;
  }

  private boolean _jspx_meth_display_005fsetProperty_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:setProperty
    org.displaytag.tags.SetPropertyTag _jspx_th_display_005fsetProperty_005f1 = (org.displaytag.tags.SetPropertyTag) _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.get(org.displaytag.tags.SetPropertyTag.class);
    _jspx_th_display_005fsetProperty_005f1.setPageContext(_jspx_page_context);
    _jspx_th_display_005fsetProperty_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
    _jspx_th_display_005fsetProperty_005f1.setName("basic.msg.empty_list");
    _jspx_th_display_005fsetProperty_005f1.setValue("");
    int _jspx_eval_display_005fsetProperty_005f1 = _jspx_th_display_005fsetProperty_005f1.doStartTag();
    if (_jspx_th_display_005fsetProperty_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f1);
    return false;
  }

  private boolean _jspx_meth_display_005fsetProperty_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:setProperty
    org.displaytag.tags.SetPropertyTag _jspx_th_display_005fsetProperty_005f2 = (org.displaytag.tags.SetPropertyTag) _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.get(org.displaytag.tags.SetPropertyTag.class);
    _jspx_th_display_005fsetProperty_005f2.setPageContext(_jspx_page_context);
    _jspx_th_display_005fsetProperty_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
    _jspx_th_display_005fsetProperty_005f2.setName("paging.banner.no_items_found");
    _jspx_th_display_005fsetProperty_005f2.setValue("");
    int _jspx_eval_display_005fsetProperty_005f2 = _jspx_th_display_005fsetProperty_005f2.doStartTag();
    if (_jspx_th_display_005fsetProperty_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f2);
    return false;
  }

  private boolean _jspx_meth_display_005fsetProperty_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:setProperty
    org.displaytag.tags.SetPropertyTag _jspx_th_display_005fsetProperty_005f3 = (org.displaytag.tags.SetPropertyTag) _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.get(org.displaytag.tags.SetPropertyTag.class);
    _jspx_th_display_005fsetProperty_005f3.setPageContext(_jspx_page_context);
    _jspx_th_display_005fsetProperty_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
    _jspx_th_display_005fsetProperty_005f3.setName("paging.banner.one_item_found");
    _jspx_th_display_005fsetProperty_005f3.setValue("");
    int _jspx_eval_display_005fsetProperty_005f3 = _jspx_th_display_005fsetProperty_005f3.doStartTag();
    if (_jspx_th_display_005fsetProperty_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f3);
    return false;
  }

  private boolean _jspx_meth_display_005fsetProperty_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:setProperty
    org.displaytag.tags.SetPropertyTag _jspx_th_display_005fsetProperty_005f4 = (org.displaytag.tags.SetPropertyTag) _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.get(org.displaytag.tags.SetPropertyTag.class);
    _jspx_th_display_005fsetProperty_005f4.setPageContext(_jspx_page_context);
    _jspx_th_display_005fsetProperty_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
    _jspx_th_display_005fsetProperty_005f4.setName("paging.banner.some_items_found");
    _jspx_th_display_005fsetProperty_005f4.setValue("");
    int _jspx_eval_display_005fsetProperty_005f4 = _jspx_th_display_005fsetProperty_005f4.doStartTag();
    if (_jspx_th_display_005fsetProperty_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f4);
    return false;
  }

  private boolean _jspx_meth_display_005fsetProperty_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:setProperty
    org.displaytag.tags.SetPropertyTag _jspx_th_display_005fsetProperty_005f5 = (org.displaytag.tags.SetPropertyTag) _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.get(org.displaytag.tags.SetPropertyTag.class);
    _jspx_th_display_005fsetProperty_005f5.setPageContext(_jspx_page_context);
    _jspx_th_display_005fsetProperty_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
    _jspx_th_display_005fsetProperty_005f5.setName("paging.banner.all_items_found");
    _jspx_th_display_005fsetProperty_005f5.setValue("");
    int _jspx_eval_display_005fsetProperty_005f5 = _jspx_th_display_005fsetProperty_005f5.doStartTag();
    if (_jspx_th_display_005fsetProperty_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f5);
    return false;
  }

  private boolean _jspx_meth_display_005fsetProperty_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:setProperty
    org.displaytag.tags.SetPropertyTag _jspx_th_display_005fsetProperty_005f6 = (org.displaytag.tags.SetPropertyTag) _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.get(org.displaytag.tags.SetPropertyTag.class);
    _jspx_th_display_005fsetProperty_005f6.setPageContext(_jspx_page_context);
    _jspx_th_display_005fsetProperty_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
    _jspx_th_display_005fsetProperty_005f6.setName("paging.banner.full");
    _jspx_th_display_005fsetProperty_005f6.setValue("");
    int _jspx_eval_display_005fsetProperty_005f6 = _jspx_th_display_005fsetProperty_005f6.doStartTag();
    if (_jspx_th_display_005fsetProperty_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f6);
    return false;
  }

  private boolean _jspx_meth_display_005fsetProperty_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:setProperty
    org.displaytag.tags.SetPropertyTag _jspx_th_display_005fsetProperty_005f7 = (org.displaytag.tags.SetPropertyTag) _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.get(org.displaytag.tags.SetPropertyTag.class);
    _jspx_th_display_005fsetProperty_005f7.setPageContext(_jspx_page_context);
    _jspx_th_display_005fsetProperty_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
    _jspx_th_display_005fsetProperty_005f7.setName("paging.banner.first");
    _jspx_th_display_005fsetProperty_005f7.setValue("");
    int _jspx_eval_display_005fsetProperty_005f7 = _jspx_th_display_005fsetProperty_005f7.doStartTag();
    if (_jspx_th_display_005fsetProperty_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f7);
    return false;
  }

  private boolean _jspx_meth_display_005fsetProperty_005f8(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:setProperty
    org.displaytag.tags.SetPropertyTag _jspx_th_display_005fsetProperty_005f8 = (org.displaytag.tags.SetPropertyTag) _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.get(org.displaytag.tags.SetPropertyTag.class);
    _jspx_th_display_005fsetProperty_005f8.setPageContext(_jspx_page_context);
    _jspx_th_display_005fsetProperty_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
    _jspx_th_display_005fsetProperty_005f8.setName("paging.banner.last");
    _jspx_th_display_005fsetProperty_005f8.setValue("");
    int _jspx_eval_display_005fsetProperty_005f8 = _jspx_th_display_005fsetProperty_005f8.doStartTag();
    if (_jspx_th_display_005fsetProperty_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f8);
    return false;
  }

  private boolean _jspx_meth_display_005fsetProperty_005f9(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:setProperty
    org.displaytag.tags.SetPropertyTag _jspx_th_display_005fsetProperty_005f9 = (org.displaytag.tags.SetPropertyTag) _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.get(org.displaytag.tags.SetPropertyTag.class);
    _jspx_th_display_005fsetProperty_005f9.setPageContext(_jspx_page_context);
    _jspx_th_display_005fsetProperty_005f9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
    _jspx_th_display_005fsetProperty_005f9.setName("paging.banner.onepage");
    _jspx_th_display_005fsetProperty_005f9.setValue("");
    int _jspx_eval_display_005fsetProperty_005f9 = _jspx_th_display_005fsetProperty_005f9.doStartTag();
    if (_jspx_th_display_005fsetProperty_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f9);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.el.core.IfTag _jspx_th_c_005fif_005f5 = (org.apache.taglibs.standard.tag.el.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.el.core.IfTag.class);
    _jspx_th_c_005fif_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    _jspx_th_c_005fif_005f5.setTest("${not empty currentMessage}");
    int _jspx_eval_c_005fif_005f5 = _jspx_th_c_005fif_005f5.doStartTag();
    if (_jspx_eval_c_005fif_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t   \t\t<div class=\"clear\"></div>\n");
        out.write("\t\t\t\t<div id=\"msg-div\">\n");
        out.write("\t\t\t\t\t<div style=\"margin-bottom:8px;\">\n");
        out.write("\t\t\t\t\t\t<h2>");
        if (_jspx_meth_c_005fout_005f8(_jspx_th_c_005fif_005f5, _jspx_page_context))
          return true;
        out.write("</h2>\n");
        out.write("\t\t\t\t\t</div>\n");
        out.write("\t\t\t\t\t<div id=\"msg\">\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_c_005fout_005f9(_jspx_th_c_005fif_005f5, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t\t\t</div>\n");
        out.write("\t\t\t\t</div>\n");
        out.write("\t\t\t\t<div class=\"clear\"></div>\n");
        out.write("\t\t\t");
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

  private boolean _jspx_meth_c_005fout_005f8(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f5, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_005fout_005f8 = (org.apache.taglibs.standard.tag.el.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_005fout_005f8.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f5);
    _jspx_th_c_005fout_005f8.setValue("${currentMessage.subject}");
    int _jspx_eval_c_005fout_005f8 = _jspx_th_c_005fout_005f8.doStartTag();
    if (_jspx_th_c_005fout_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f8);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f9(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f5, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_005fout_005f9 = (org.apache.taglibs.standard.tag.el.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_005fout_005f9.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f5);
    _jspx_th_c_005fout_005f9.setValue("${currentMessage.message}");
    _jspx_th_c_005fout_005f9.setEscapeXml("false");
    int _jspx_eval_c_005fout_005f9 = _jspx_th_c_005fout_005f9.doStartTag();
    if (_jspx_th_c_005fout_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f9);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f10(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.el.fmt.MessageTag _jspx_th_fmt_005fmessage_005f10 = (org.apache.taglibs.standard.tag.el.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.el.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f10.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    _jspx_th_fmt_005fmessage_005f10.setKey("profile.postMessage");
    int _jspx_eval_fmt_005fmessage_005f10 = _jspx_th_fmt_005fmessage_005f10.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f10);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f11(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.el.fmt.MessageTag _jspx_th_fmt_005fmessage_005f11 = (org.apache.taglibs.standard.tag.el.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.el.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f11.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    _jspx_th_fmt_005fmessage_005f11.setKey("home.leaderboard");
    int _jspx_eval_fmt_005fmessage_005f11 = _jspx_th_fmt_005fmessage_005f11.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f11);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f11);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f5, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.el.core.WhenTag _jspx_th_c_005fwhen_005f6 = (org.apache.taglibs.standard.tag.el.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_005ftest.get(org.apache.taglibs.standard.tag.el.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f5);
    _jspx_th_c_005fwhen_005f6.setTest("${empty seasons or not empty hideStandings}");
    int _jspx_eval_c_005fwhen_005f6 = _jspx_th_c_005fwhen_005f6.doStartTag();
    if (_jspx_eval_c_005fwhen_005f6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t<div>\n");
        out.write("\t\t\t\t\t<table id=\"standings\">\n");
        out.write("\t\t\t\t\t<caption>");
        if (_jspx_meth_fmt_005fmessage_005f12(_jspx_th_c_005fwhen_005f6, _jspx_page_context))
          return true;
        out.write("</caption>\n");
        out.write("\t\t\t\t\t<thead>\n");
        out.write("\t\t\t\t\t\t<tr>\n");
        out.write("\t\t\t\t\t\t\t<th>");
        if (_jspx_meth_fmt_005fmessage_005f13(_jspx_th_c_005fwhen_005f6, _jspx_page_context))
          return true;
        out.write("</th>\n");
        out.write("\t\t\t\t\t\t\t<th>");
        if (_jspx_meth_fmt_005fmessage_005f14(_jspx_th_c_005fwhen_005f6, _jspx_page_context))
          return true;
        out.write("</th>\n");
        out.write("\t\t\t\t\t\t\t<th>");
        if (_jspx_meth_fmt_005fmessage_005f15(_jspx_th_c_005fwhen_005f6, _jspx_page_context))
          return true;
        out.write("</th>\n");
        out.write("\t\t\t\t\t\t</tr>\n");
        out.write("\t\t\t\t\t</thead>\n");
        out.write("\t\t\t\t\t\n");
        out.write("\t\t\t\t\t<tbody>\n");
        out.write("\t\t\t\t\t\t<tr class=\"odd\">\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t</tr>\n");
        out.write("\t\t\t\t\t\t<tr class=\"even\">\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t</tr>\n");
        out.write("\t\t\t\t\t\t<tr class=\"odd\">\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t</tr>\n");
        out.write("\t\t\t\t\t\t<tr class=\"even\">\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t</tr>\n");
        out.write("\t\t\t\t\t\t<tr class=\"odd\">\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t</tr>\n");
        out.write("\t\t\t\t\t\t<tr class=\"even\">\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t</tr>\n");
        out.write("\t\t\t\t\t\t<tr class=\"odd\">\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t</tr>\n");
        out.write("\t\t\t\t\t\t<tr class=\"even\">\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t</tr>\n");
        out.write("\t\t\t\t\t\t<tr class=\"odd\">\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t</tr>\n");
        out.write("\t\t\t\t\t\t<tr class=\"even\">\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t\t<td>-</td>\n");
        out.write("\t\t\t\t\t\t</tr>\n");
        out.write("\t\t\t\t\t</tbody>\n");
        out.write("\t\t\t\t\t</table>\n");
        out.write("\t\t\t\t</div>\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_005ftest.reuse(_jspx_th_c_005fwhen_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_005ftest.reuse(_jspx_th_c_005fwhen_005f6);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f12(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f6, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.el.fmt.MessageTag _jspx_th_fmt_005fmessage_005f12 = (org.apache.taglibs.standard.tag.el.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.el.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f12.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f6);
    _jspx_th_fmt_005fmessage_005f12.setKey("home.noLeaderboard");
    int _jspx_eval_fmt_005fmessage_005f12 = _jspx_th_fmt_005fmessage_005f12.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f12);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f12);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f13(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f6, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.el.fmt.MessageTag _jspx_th_fmt_005fmessage_005f13 = (org.apache.taglibs.standard.tag.el.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.el.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f13.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f6);
    _jspx_th_fmt_005fmessage_005f13.setKey("home.position");
    int _jspx_eval_fmt_005fmessage_005f13 = _jspx_th_fmt_005fmessage_005f13.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f13);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f13);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f14(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f6, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.el.fmt.MessageTag _jspx_th_fmt_005fmessage_005f14 = (org.apache.taglibs.standard.tag.el.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.el.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f14.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f6);
    _jspx_th_fmt_005fmessage_005f14.setKey("home.player");
    int _jspx_eval_fmt_005fmessage_005f14 = _jspx_th_fmt_005fmessage_005f14.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f14);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f14);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f15(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fwhen_005f6, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.el.fmt.MessageTag _jspx_th_fmt_005fmessage_005f15 = (org.apache.taglibs.standard.tag.el.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.el.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f15.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fwhen_005f6);
    _jspx_th_fmt_005fmessage_005f15.setKey("home.points");
    int _jspx_eval_fmt_005fmessage_005f15 = _jspx_th_fmt_005fmessage_005f15.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f15);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f15);
    return false;
  }

  private boolean _jspx_meth_display_005fcaption_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:caption
    org.displaytag.tags.CaptionTag _jspx_th_display_005fcaption_005f0 = (org.displaytag.tags.CaptionTag) _005fjspx_005ftagPool_005fdisplay_005fcaption.get(org.displaytag.tags.CaptionTag.class);
    _jspx_th_display_005fcaption_005f0.setPageContext(_jspx_page_context);
    _jspx_th_display_005fcaption_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f1);
    int _jspx_eval_display_005fcaption_005f0 = _jspx_th_display_005fcaption_005f0.doStartTag();
    if (_jspx_eval_display_005fcaption_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_display_005fcaption_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_display_005fcaption_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_display_005fcaption_005f0.doInitBody();
      }
      do {
        if (_jspx_meth_c_005fout_005f10(_jspx_th_display_005fcaption_005f0, _jspx_page_context))
          return true;
        out.write(' ');
        if (_jspx_meth_c_005fout_005f11(_jspx_th_display_005fcaption_005f0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_display_005fcaption_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_display_005fcaption_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_display_005fcaption_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fcaption.reuse(_jspx_th_display_005fcaption_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fcaption.reuse(_jspx_th_display_005fcaption_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f10(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005fcaption_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_005fout_005f10 = (org.apache.taglibs.standard.tag.el.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_005fout_005f10.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005fcaption_005f0);
    _jspx_th_c_005fout_005f10.setValue("${season.name}");
    int _jspx_eval_c_005fout_005f10 = _jspx_th_c_005fout_005f10.doStartTag();
    if (_jspx_th_c_005fout_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f10);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f11(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005fcaption_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_005fout_005f11 = (org.apache.taglibs.standard.tag.el.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_005fout_005f11.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005fcaption_005f0);
    _jspx_th_c_005fout_005f11.setValue("${season.division}");
    int _jspx_eval_c_005fout_005f11 = _jspx_th_c_005fout_005f11.doStartTag();
    if (_jspx_th_c_005fout_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f11);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f11);
    return false;
  }

  private boolean _jspx_meth_display_005fcolumn_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f4 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_005ftitleKey_005fproperty_005fnobody.get(org.displaytag.tags.ColumnTag.class);
    _jspx_th_display_005fcolumn_005f4.setPageContext(_jspx_page_context);
    _jspx_th_display_005fcolumn_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f1);
    _jspx_th_display_005fcolumn_005f4.setProperty("user.fullName");
    _jspx_th_display_005fcolumn_005f4.setTitleKey("home.player");
    int _jspx_eval_display_005fcolumn_005f4 = _jspx_th_display_005fcolumn_005f4.doStartTag();
    if (_jspx_th_display_005fcolumn_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_005ftitleKey_005fproperty_005fnobody.reuse(_jspx_th_display_005fcolumn_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_005ftitleKey_005fproperty_005fnobody.reuse(_jspx_th_display_005fcolumn_005f4);
    return false;
  }

  private boolean _jspx_meth_display_005fcolumn_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f5 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_005ftitleKey_005fproperty_005fnobody.get(org.displaytag.tags.ColumnTag.class);
    _jspx_th_display_005fcolumn_005f5.setPageContext(_jspx_page_context);
    _jspx_th_display_005fcolumn_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f1);
    _jspx_th_display_005fcolumn_005f5.setProperty("points");
    _jspx_th_display_005fcolumn_005f5.setTitleKey("home.points");
    int _jspx_eval_display_005fcolumn_005f5 = _jspx_th_display_005fcolumn_005f5.doStartTag();
    if (_jspx_th_display_005fcolumn_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_005ftitleKey_005fproperty_005fnobody.reuse(_jspx_th_display_005fcolumn_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_005ftitleKey_005fproperty_005fnobody.reuse(_jspx_th_display_005fcolumn_005f5);
    return false;
  }

  private boolean _jspx_meth_display_005fsetProperty_005f10(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:setProperty
    org.displaytag.tags.SetPropertyTag _jspx_th_display_005fsetProperty_005f10 = (org.displaytag.tags.SetPropertyTag) _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.get(org.displaytag.tags.SetPropertyTag.class);
    _jspx_th_display_005fsetProperty_005f10.setPageContext(_jspx_page_context);
    _jspx_th_display_005fsetProperty_005f10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f1);
    _jspx_th_display_005fsetProperty_005f10.setName("basic.empty.showtable");
    _jspx_th_display_005fsetProperty_005f10.setValue("false");
    int _jspx_eval_display_005fsetProperty_005f10 = _jspx_th_display_005fsetProperty_005f10.doStartTag();
    if (_jspx_th_display_005fsetProperty_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f10);
    return false;
  }

  private boolean _jspx_meth_display_005fsetProperty_005f11(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:setProperty
    org.displaytag.tags.SetPropertyTag _jspx_th_display_005fsetProperty_005f11 = (org.displaytag.tags.SetPropertyTag) _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.get(org.displaytag.tags.SetPropertyTag.class);
    _jspx_th_display_005fsetProperty_005f11.setPageContext(_jspx_page_context);
    _jspx_th_display_005fsetProperty_005f11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f1);
    _jspx_th_display_005fsetProperty_005f11.setName("basic.msg.empty_list");
    _jspx_th_display_005fsetProperty_005f11.setValue("");
    int _jspx_eval_display_005fsetProperty_005f11 = _jspx_th_display_005fsetProperty_005f11.doStartTag();
    if (_jspx_th_display_005fsetProperty_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f11);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f11);
    return false;
  }

  private boolean _jspx_meth_display_005fsetProperty_005f12(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:setProperty
    org.displaytag.tags.SetPropertyTag _jspx_th_display_005fsetProperty_005f12 = (org.displaytag.tags.SetPropertyTag) _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.get(org.displaytag.tags.SetPropertyTag.class);
    _jspx_th_display_005fsetProperty_005f12.setPageContext(_jspx_page_context);
    _jspx_th_display_005fsetProperty_005f12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f1);
    _jspx_th_display_005fsetProperty_005f12.setName("paging.banner.no_items_found");
    _jspx_th_display_005fsetProperty_005f12.setValue("");
    int _jspx_eval_display_005fsetProperty_005f12 = _jspx_th_display_005fsetProperty_005f12.doStartTag();
    if (_jspx_th_display_005fsetProperty_005f12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f12);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f12);
    return false;
  }

  private boolean _jspx_meth_display_005fsetProperty_005f13(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:setProperty
    org.displaytag.tags.SetPropertyTag _jspx_th_display_005fsetProperty_005f13 = (org.displaytag.tags.SetPropertyTag) _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.get(org.displaytag.tags.SetPropertyTag.class);
    _jspx_th_display_005fsetProperty_005f13.setPageContext(_jspx_page_context);
    _jspx_th_display_005fsetProperty_005f13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f1);
    _jspx_th_display_005fsetProperty_005f13.setName("paging.banner.one_item_found");
    _jspx_th_display_005fsetProperty_005f13.setValue("");
    int _jspx_eval_display_005fsetProperty_005f13 = _jspx_th_display_005fsetProperty_005f13.doStartTag();
    if (_jspx_th_display_005fsetProperty_005f13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f13);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f13);
    return false;
  }

  private boolean _jspx_meth_display_005fsetProperty_005f14(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:setProperty
    org.displaytag.tags.SetPropertyTag _jspx_th_display_005fsetProperty_005f14 = (org.displaytag.tags.SetPropertyTag) _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.get(org.displaytag.tags.SetPropertyTag.class);
    _jspx_th_display_005fsetProperty_005f14.setPageContext(_jspx_page_context);
    _jspx_th_display_005fsetProperty_005f14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f1);
    _jspx_th_display_005fsetProperty_005f14.setName("paging.banner.some_items_found");
    _jspx_th_display_005fsetProperty_005f14.setValue("");
    int _jspx_eval_display_005fsetProperty_005f14 = _jspx_th_display_005fsetProperty_005f14.doStartTag();
    if (_jspx_th_display_005fsetProperty_005f14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f14);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f14);
    return false;
  }

  private boolean _jspx_meth_display_005fsetProperty_005f15(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:setProperty
    org.displaytag.tags.SetPropertyTag _jspx_th_display_005fsetProperty_005f15 = (org.displaytag.tags.SetPropertyTag) _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.get(org.displaytag.tags.SetPropertyTag.class);
    _jspx_th_display_005fsetProperty_005f15.setPageContext(_jspx_page_context);
    _jspx_th_display_005fsetProperty_005f15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f1);
    _jspx_th_display_005fsetProperty_005f15.setName("paging.banner.all_items_found");
    _jspx_th_display_005fsetProperty_005f15.setValue("");
    int _jspx_eval_display_005fsetProperty_005f15 = _jspx_th_display_005fsetProperty_005f15.doStartTag();
    if (_jspx_th_display_005fsetProperty_005f15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f15);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f15);
    return false;
  }

  private boolean _jspx_meth_display_005fsetProperty_005f16(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:setProperty
    org.displaytag.tags.SetPropertyTag _jspx_th_display_005fsetProperty_005f16 = (org.displaytag.tags.SetPropertyTag) _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.get(org.displaytag.tags.SetPropertyTag.class);
    _jspx_th_display_005fsetProperty_005f16.setPageContext(_jspx_page_context);
    _jspx_th_display_005fsetProperty_005f16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f1);
    _jspx_th_display_005fsetProperty_005f16.setName("paging.banner.full");
    _jspx_th_display_005fsetProperty_005f16.setValue("");
    int _jspx_eval_display_005fsetProperty_005f16 = _jspx_th_display_005fsetProperty_005f16.doStartTag();
    if (_jspx_th_display_005fsetProperty_005f16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f16);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f16);
    return false;
  }

  private boolean _jspx_meth_display_005fsetProperty_005f17(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:setProperty
    org.displaytag.tags.SetPropertyTag _jspx_th_display_005fsetProperty_005f17 = (org.displaytag.tags.SetPropertyTag) _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.get(org.displaytag.tags.SetPropertyTag.class);
    _jspx_th_display_005fsetProperty_005f17.setPageContext(_jspx_page_context);
    _jspx_th_display_005fsetProperty_005f17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f1);
    _jspx_th_display_005fsetProperty_005f17.setName("paging.banner.first");
    _jspx_th_display_005fsetProperty_005f17.setValue("");
    int _jspx_eval_display_005fsetProperty_005f17 = _jspx_th_display_005fsetProperty_005f17.doStartTag();
    if (_jspx_th_display_005fsetProperty_005f17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f17);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f17);
    return false;
  }

  private boolean _jspx_meth_display_005fsetProperty_005f18(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:setProperty
    org.displaytag.tags.SetPropertyTag _jspx_th_display_005fsetProperty_005f18 = (org.displaytag.tags.SetPropertyTag) _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.get(org.displaytag.tags.SetPropertyTag.class);
    _jspx_th_display_005fsetProperty_005f18.setPageContext(_jspx_page_context);
    _jspx_th_display_005fsetProperty_005f18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f1);
    _jspx_th_display_005fsetProperty_005f18.setName("paging.banner.last");
    _jspx_th_display_005fsetProperty_005f18.setValue("");
    int _jspx_eval_display_005fsetProperty_005f18 = _jspx_th_display_005fsetProperty_005f18.doStartTag();
    if (_jspx_th_display_005fsetProperty_005f18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f18);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f18);
    return false;
  }

  private boolean _jspx_meth_display_005fsetProperty_005f19(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:setProperty
    org.displaytag.tags.SetPropertyTag _jspx_th_display_005fsetProperty_005f19 = (org.displaytag.tags.SetPropertyTag) _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.get(org.displaytag.tags.SetPropertyTag.class);
    _jspx_th_display_005fsetProperty_005f19.setPageContext(_jspx_page_context);
    _jspx_th_display_005fsetProperty_005f19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f1);
    _jspx_th_display_005fsetProperty_005f19.setName("paging.banner.onepage");
    _jspx_th_display_005fsetProperty_005f19.setValue("");
    int _jspx_eval_display_005fsetProperty_005f19 = _jspx_th_display_005fsetProperty_005f19.doStartTag();
    if (_jspx_th_display_005fsetProperty_005f19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f19);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fsetProperty_005fvalue_005fname_005fnobody.reuse(_jspx_th_display_005fsetProperty_005f19);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.el.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.el.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_005fvar.get(org.apache.taglibs.standard.tag.el.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    _jspx_th_c_005fset_005f0.setVar("url");
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_eval_c_005fset_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_c_005fset_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_c_005fset_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_c_005fset_005f0.doInitBody();
      }
      do {
        if (_jspx_meth_c_005furl_005f2(_jspx_th_c_005fset_005f0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_c_005fset_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_c_005fset_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_005fvar.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_005fvar.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fset_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.el.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.el.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.UrlTag.class);
    _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fset_005f0);
    _jspx_th_c_005furl_005f2.setValue("/standings.html");
    int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
    if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
    return false;
  }

  private boolean _jspx_meth_carter_005fbutton_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  carter:button
    com.sageconsulting.webapp.taglib.ButtonTag _jspx_th_carter_005fbutton_005f0 = (com.sageconsulting.webapp.taglib.ButtonTag) _005fjspx_005ftagPool_005fcarter_005fbutton_005fpage_005fkey_005ffill_005fnobody.get(com.sageconsulting.webapp.taglib.ButtonTag.class);
    _jspx_th_carter_005fbutton_005f0.setPageContext(_jspx_page_context);
    _jspx_th_carter_005fbutton_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    _jspx_th_carter_005fbutton_005f0.setPage("${url}");
    _jspx_th_carter_005fbutton_005f0.setKey("home.fullLeaderboard");
    _jspx_th_carter_005fbutton_005f0.setFill("true");
    int _jspx_eval_carter_005fbutton_005f0 = _jspx_th_carter_005fbutton_005f0.doStartTag();
    if (_jspx_th_carter_005fbutton_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fcarter_005fbutton_005fpage_005fkey_005ffill_005fnobody.reuse(_jspx_th_carter_005fbutton_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fcarter_005fbutton_005fpage_005fkey_005ffill_005fnobody.reuse(_jspx_th_carter_005fbutton_005f0);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f16(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.el.fmt.MessageTag _jspx_th_fmt_005fmessage_005f16 = (org.apache.taglibs.standard.tag.el.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.el.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f16.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    _jspx_th_fmt_005fmessage_005f16.setKey("home.chooseDivision");
    int _jspx_eval_fmt_005fmessage_005f16 = _jspx_th_fmt_005fmessage_005f16.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f16);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f16);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.el.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.el.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.get(org.apache.taglibs.standard.tag.el.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    _jspx_th_c_005fforEach_005f0.setVar("season");
    _jspx_th_c_005fforEach_005f0.setItems("${seasons}");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t\t<option value=\"");
          if (_jspx_meth_c_005fout_005f12(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write('"');
          out.write('>');
          if (_jspx_meth_c_005fout_005f13(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("</option>\n");
          out.write("\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f12(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_005fout_005f12 = (org.apache.taglibs.standard.tag.el.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_005fout_005f12.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    _jspx_th_c_005fout_005f12.setValue("${season.id}");
    int _jspx_eval_c_005fout_005f12 = _jspx_th_c_005fout_005f12.doStartTag();
    if (_jspx_th_c_005fout_005f12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f12);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f12);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f13(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_005fout_005f13 = (org.apache.taglibs.standard.tag.el.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_005fout_005f13.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    _jspx_th_c_005fout_005f13.setValue("${season.division}");
    int _jspx_eval_c_005fout_005f13 = _jspx_th_c_005fout_005f13.doStartTag();
    if (_jspx_th_c_005fout_005f13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f13);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f13);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.el.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.el.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.get(org.apache.taglibs.standard.tag.el.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    _jspx_th_c_005fforEach_005f1.setVar("matchCategory");
    _jspx_th_c_005fforEach_005f1.setItems("${matchCategories}");
    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t<option value=\"");
          if (_jspx_meth_c_005fout_005f14(_jspx_th_c_005fforEach_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f1))
            return true;
          out.write('"');
          out.write('>');
          if (_jspx_meth_c_005fout_005f15(_jspx_th_c_005fforEach_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f1))
            return true;
          out.write("</option>\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f14(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_005fout_005f14 = (org.apache.taglibs.standard.tag.el.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_005fout_005f14.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
    _jspx_th_c_005fout_005f14.setValue("${matchCategory.id}");
    int _jspx_eval_c_005fout_005f14 = _jspx_th_c_005fout_005f14.doStartTag();
    if (_jspx_th_c_005fout_005f14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f14);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f14);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f15(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_005fout_005f15 = (org.apache.taglibs.standard.tag.el.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_005fout_005f15.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
    _jspx_th_c_005fout_005f15.setValue("${matchCategory.name}");
    int _jspx_eval_c_005fout_005f15 = _jspx_th_c_005fout_005f15.doStartTag();
    if (_jspx_th_c_005fout_005f15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f15);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f15);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.el.core.IfTag _jspx_th_c_005fif_005f6 = (org.apache.taglibs.standard.tag.el.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.el.core.IfTag.class);
    _jspx_th_c_005fif_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    _jspx_th_c_005fif_005f6.setTest("${not empty weather}");
    int _jspx_eval_c_005fif_005f6 = _jspx_th_c_005fif_005f6.doStartTag();
    if (_jspx_eval_c_005fif_005f6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        if (_jspx_meth_c_005fif_005f7(_jspx_th_c_005fif_005f6, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_c_005fif_005f6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f6, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.el.core.IfTag _jspx_th_c_005fif_005f7 = (org.apache.taglibs.standard.tag.el.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.el.core.IfTag.class);
    _jspx_th_c_005fif_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f6);
    _jspx_th_c_005fif_005f7.setTest("${not empty weather.icon and not empty weather.high and not empty weather.low}");
    int _jspx_eval_c_005fif_005f7 = _jspx_th_c_005fif_005f7.doStartTag();
    if (_jspx_eval_c_005fif_005f7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t<div class=\"ldrBrdWeatherHdr\">");
        if (_jspx_meth_fmt_005fmessage_005f17(_jspx_th_c_005fif_005f7, _jspx_page_context))
          return true;
        out.write("</div>\n");
        out.write("\t\t\t<div class=\"ldrBrdWthr\">\n");
        out.write("\t\t\t\t<div class=\"ldrBrdWthrImg\">\n");
        out.write("\t\t\t\t\t<img alt=\"Weather\" src='");
        if (_jspx_meth_c_005fout_005f16(_jspx_th_c_005fif_005f7, _jspx_page_context))
          return true;
        out.write("'/>\n");
        out.write("\t\t\t\t</div>\n");
        out.write("\t\t\t\t<br/>\n");
        out.write("\t\t\t\t<div class=\"ldrBrdWthrToday\">Today</div>\n");
        out.write("\t\t\t\t<div class=\"ldrBrdWthrHiLow\">HI ");
        if (_jspx_meth_c_005fout_005f17(_jspx_th_c_005fif_005f7, _jspx_page_context))
          return true;
        out.write("F  |  LO ");
        if (_jspx_meth_c_005fout_005f18(_jspx_th_c_005fif_005f7, _jspx_page_context))
          return true;
        out.write("F</div>\n");
        out.write("\t\t\t</div>\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f7.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f7);
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f17(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f7, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.el.fmt.MessageTag _jspx_th_fmt_005fmessage_005f17 = (org.apache.taglibs.standard.tag.el.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.el.fmt.MessageTag.class);
    _jspx_th_fmt_005fmessage_005f17.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fmessage_005f17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f7);
    _jspx_th_fmt_005fmessage_005f17.setKey("home.weather");
    int _jspx_eval_fmt_005fmessage_005f17 = _jspx_th_fmt_005fmessage_005f17.doStartTag();
    if (_jspx_th_fmt_005fmessage_005f17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f17);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fmessage_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f17);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f16(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f7, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_005fout_005f16 = (org.apache.taglibs.standard.tag.el.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_005fout_005f16.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f7);
    _jspx_th_c_005fout_005f16.setValue("${weather.icon}");
    int _jspx_eval_c_005fout_005f16 = _jspx_th_c_005fout_005f16.doStartTag();
    if (_jspx_th_c_005fout_005f16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f16);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f16);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f17(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f7, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_005fout_005f17 = (org.apache.taglibs.standard.tag.el.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_005fout_005f17.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f7);
    _jspx_th_c_005fout_005f17.setValue("${weather.high}");
    int _jspx_eval_c_005fout_005f17 = _jspx_th_c_005fout_005f17.doStartTag();
    if (_jspx_th_c_005fout_005f17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f17);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f17);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f18(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f7, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_005fout_005f18 = (org.apache.taglibs.standard.tag.el.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.el.core.OutTag.class);
    _jspx_th_c_005fout_005f18.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f7);
    _jspx_th_c_005fout_005f18.setValue("${weather.low}");
    int _jspx_eval_c_005fout_005f18 = _jspx_th_c_005fout_005f18.doStartTag();
    if (_jspx_th_c_005fout_005f18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f18);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f18);
    return false;
  }
}
