<!DOCTYPE html>

<%@ include file="/common/taglibs.jsp"%>
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title><decorator:title/> | <fmt:message key="webapp.name"/></title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/${appConfig["csstheme"]}/reset.css'/>" />
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/${appConfig["csstheme"]}/main.css'/>" />
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/${appConfig["csstheme"]}/jquery.ui.core.css'/>" />
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/${appConfig["csstheme"]}/jquery.ui.theme.css'/>" />
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/${appConfig["csstheme"]}/jquery.ui.dialog.css'/>" />

<authz:authorize ifAllGranted="admin">
		<script type="text/javascript" src="<c:url value='/scripts/chrome.js'/>"></script>
</authz:authorize>
        <script type="text/javascript" src="<c:url value='/scripts/jquery-1.2.6.js'/>"></script>
        <!-- jQuery CDN - Slim version (=without AJAX) -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="" crossorigin="anonymous"></script>
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
        <script type="text/javascript" src="<c:url value='/scripts/jquery-ui-personalized-1.6rc4.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
        <decorator:head/>
    </head>
<body<decorator:getProperty property="body.id" writeEntireProperty="true"/><decorator:getProperty property="body.class" writeEntireProperty="true"/>>

<div class="wrapper">
<div id="sidebar">
        <div class="sidebar-header"> 
        <a href="#"><img src="images/open-tennis-logo.png" class="img-responsive" alt="Play Open Tennis"></a>
        </div>
        <div id="main-nav">
		<jsp:include page="/common/menu.jsp"/>
		</div>
 </div>       
<div id="container">
	     <nav class="navbar navbar-expand-lg">
            <div class="container-fluid">
	<c:set var="currentMenu" scope="request"><decorator:getProperty property="meta.menu"/></c:set>
	<div class="page_title">                
	<button type="button" id="sidebarCollapse" class="btn">
                <i class="fa fa-align-left"></i>
            </button>
	<div id="header"><c:out value="${city.fullCityName}"/></div>
	</div>	
	<div id="top-nav"><jsp:include page="/common/header.jsp"/></div>
	
</div>
</nav>
<div class="page-container col-sm-9">
	<%-- START PAGE CONENT --%>
    <%@ include file="/common/messages.jsp" %>
    <decorator:body/>
	<%-- END PAGE CONENT --%>	


</div>	
	<div id="footer">
		<jsp:include page="/common/footer.jsp"/>
		<span class="copyright">Open Play Tennis Copyright <img style="max-width:19px" class="align-middle" alt="copyright"  src="images/copyright-guidelines.png"> 2020. All rights reserved</span>
	</div>
</div>
</div>
<script type="text/javascript">
	function showLink(link)
	{
		window.open(link);
	}
		$(document).ready(function() {
		$("#main-nav a").each(function() {   
	    if (this.href == window.location.href) {
	        $(this).addClass("active");
	    }
	    });
	    
	    });
	    
	    $(document).ready(function () {
		    /* $('#sidebarCollapse').on('click', function () {
		        $('#sidebar').toggleClass('active');
		    }); */
		    
	    	$('#sidebarCollapse').click( function () {
		        $('#sidebar').toggleClass('active');
		    });
		});
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
<script type="text/javascript">
var newTitle = $('.page-title');
$(".navbar .page_title #header").before(newTitle);
</script>

</body>
