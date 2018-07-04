<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="WEB-INF/classes/cssHorizontalMenu.vm" permissions="rolesAdapter">
<div class="left">
<menu:displayMenu name="About"/>
<menu:displayMenu name="Rules"/>
<menu:displayMenu name="Contact"/>
<menu:displayMenu name="Cities"/>
</div>

<div class="right">
	<div id="links">
		<a class="ie-post-link" onclick="showLink('https://twitter.com/CityGolfLeague');">
			<img src="images/twitter_link.png">
		</a>
		<a class="ie-post-link" onclick="showLink('http://www.facebook.com/pages/City-Golf-League/348284351925121');">
			<img src="images/facebook_link.png">
		</a>
	</div>
	
	<div style="display:inline-block;">
	<c:choose>
		<c:when test="${empty pageContext.request.remoteUser}">
			<div id="signup-nav"><menu:displayMenu name="Signup"/></div>
			<div id="login-nav"><menu:displayMenu name="Login"/></div>
		</c:when>
		<c:when test="${not empty errorStatusCode}">
			<%-- Don't display anything here for error pages --%>
		</c:when>
		<c:otherwise>
			<div id="logout-nav"><menu:displayMenu name="Logout"/></div>
		</c:otherwise>
	</c:choose>
	</div>
</div>

</menu:useMenuDisplayer>

<%-- Put constants into request scope --%>
<carter:constants scope="request"/>