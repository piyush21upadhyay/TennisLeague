<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title><decorator:title/> | <fmt:message key="webapp.name"/></title>

        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/${appConfig["csstheme"]}/reset.css'/>" />
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/${appConfig["csstheme"]}/main.css'/>" />
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/${appConfig["csstheme"]}/jquery.ui.core.css'/>" />
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/${appConfig["csstheme"]}/jquery.ui.theme.css'/>" />
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/${appConfig["csstheme"]}/jquery.ui.dialog.css'/>" />

<authz:authorize ifAllGranted="admin">
		<script type="text/javascript" src="<c:url value='/scripts/chrome.js'/>"></script>
</authz:authorize>
        <script type="text/javascript" src="<c:url value='/scripts/jquery-1.2.6.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/scripts/jquery-ui-personalized-1.6rc4.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
        <decorator:head/>
    </head>
<body<decorator:getProperty property="body.id" writeEntireProperty="true"/><decorator:getProperty property="body.class" writeEntireProperty="true"/>>

<div id="container">
	
	<c:set var="currentMenu" scope="request"><decorator:getProperty property="meta.menu"/></c:set>
	<div id="top-nav"><jsp:include page="/common/header.jsp"/></div>
	
	<div id="header"><c:out value="${city.fullCityName}"/></div>
	<div id="main-nav">
		<jsp:include page="/common/menu.jsp"/>
	</div>

	<%-- START PAGE CONENT --%>
    <%@ include file="/common/messages.jsp" %>
    <decorator:body/>
	<%-- END PAGE CONENT --%>	

	<div id="footer">
		<jsp:include page="/common/footer.jsp"/>
		<span class="copyright">City Golf League, LLC &copy; 2012</span>
	</div>
</div>

<script type="text/javascript">
	function showLink(link)
	{
		window.open(link);
	}
</script>

<authz:authorize ifAllGranted="admin">
<script type="text/javascript">
cssdropdown.startchrome("main-nav")
</script>
</authz:authorize>
<script type="text/javascript">
<!--
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
-->
</script>
<script type="text/javascript">
<!--
try {
  var pageTracker = _gat._getTracker("UA-34480500-1");
  pageTracker._trackPageview();
} catch(err) {}
-->
</script>
</body>
</html>
