<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="standings.title"/></title>
    <meta name="menu" content="Standings"/>
    <script type="text/javascript" src="scripts/jquery.min.js"></script>
    <script type="text/javascript">
    
    	$(function() {
        	$("#results tbody tr:first").addClass("first-row");
        	$('#command').insertBefore('#top-nav .right');
      
    	});
    </script>
</head>

<c:if test="${empty errors and empty successMessages}">

<div class="section">
	<div class="left">
		<h2 class="page-title">
			<c:choose>
				<c:when test="${empty season}">
					<c:out value="${city.name}"/> 
				</c:when>
				<c:otherwise>
					<c:out value="${season.name}"/> <%-- <span><c:out value="${season.division}"/></span> --%>
				</c:otherwise>
			</c:choose>
		</h2>
	</div>
	<div class="right">
		<form:form name="season" method="post" action="standings.html">
			<select name="seasonid" onchange="document.season.submit();">
				<option value="0"><fmt:message key="standings.choose"/></option>
				<c:forEach var="season" items="${seasons}">
					<option value="<c:out value="${season.id}"/>"<c:if test="${season.id == submittedSeason.id}">selected</c:if>>
						<c:out value="${season.name}"/>
					</option>
				</c:forEach>
			</select>
		</form:form>
	</div>
</div>

<div id="standings-container">
	<table cellspacing="0" cellpadding="0">
		<thead>
			<tr>
				<th class="first pos"><fmt:message key="standings.position"/></th>
				<th class="player"><fmt:message key="standings.player"/></th>
				<th class="course"><fmt:message key="standings.court"/></th>
				<th class="points"><fmt:message key="standings.points"/></th>
				<th class="wins"><fmt:message key="standings.wins"/></th>
				<th class="losses"><fmt:message key="standings.losses"/></th>
				<th class="last ties"><fmt:message key="standings.ties"/></th>
			</tr>
		</thead>
	</table>
	<div id="standings-scroller">
	<display:table name="results" id="results" cellspacing="0" cellpadding="0" requestURI="">
	    <display:column class="pos"><%=pageContext.getAttribute("results_rowNum")%></display:column>
	    <display:column class="player" property="user.fullName" url="/profile.html" paramId="id" paramProperty="user.id"/>
	    <display:column class="course" property="user.homeCourtText" /><!-- url="/coursedetails.html" paramId="id" paramProperty="user.homeCourse.id"/> -->
	    <display:column class="points" property="points" />
	    <display:column class="wins" property="wins" />
	    <display:column class="losses" property="losses" />
	    <display:column class="ties" property="ties"/>

	    <display:setProperty name="basic.show.header" value="false"/>
	    <display:setProperty name="basic.empty.showtable" value="false"/>
	    <display:setProperty name="basic.msg.empty_list" value="" />
		<display:setProperty name="paging.banner.no_items_found" value="" />
		<display:setProperty name="paging.banner.one_item_found" value="" />
		<display:setProperty name="paging.banner.some_items_found" value="" />
		<display:setProperty name="paging.banner.all_items_found" value="" />
		<display:setProperty name="paging.banner.full" value="" />
		<display:setProperty name="paging.banner.first" value="" />
		<display:setProperty name="paging.banner.last" value="" />
		<display:setProperty name="paging.banner.onepage" value="" />
	</display:table>
	<display:table name="emptyResults" id="results" cellspacing="0" cellpadding="0" requestURI="">
	    <display:column><%=pageContext.getAttribute("results_rowNum")%></display:column>
	    <display:column>-</display:column>
	    <display:column>-</display:column>
	    <display:column property="points"/>
	    <display:column property="wins"/>
	    <display:column property="losses"/>
	    <display:column property="ties"/>

	    <display:setProperty name="basic.show.header" value="false"/>
	    <display:setProperty name="basic.empty.showtable" value="false"/>
	    <display:setProperty name="basic.msg.empty_list" value="" />
		<display:setProperty name="paging.banner.no_items_found" value="" />
		<display:setProperty name="paging.banner.one_item_found" value="" />
		<display:setProperty name="paging.banner.some_items_found" value="" />
		<display:setProperty name="paging.banner.all_items_found" value="" />
		<display:setProperty name="paging.banner.full" value="" />
		<display:setProperty name="paging.banner.first" value="" />
		<display:setProperty name="paging.banner.last" value="" />
		<display:setProperty name="paging.banner.onepage" value="" />
	</display:table>
	</div>
</div>
<c:if test="${not empty playoffCounter and playoffStarted eq 0}">
<div class="playoffs-counter">
	<div class="playoffs-counter-number"><c:out value="${playoffCounter}"/></div>
</div>
</c:if>

</c:if>
