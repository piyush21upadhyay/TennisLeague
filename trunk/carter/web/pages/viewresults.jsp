<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="viewresults.title"/></title>
    <meta name="menu" content="PostResults"/>
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/${appConfig["csstheme"]}/scorecard2.css'/>" />
</head>
<!-- <h2 class="page-title"> Schedule</h2> -->
<div class="section">
	<div class="left userInfo">
		<h2><fmt:message key="viewresults.header"/></h2>
	    <p class="user">
	        <c:out value="${match.course.name}"/>
	    </p>
	   <%--  <p class="season">
			<fmt:formatDate value="${match.played}" pattern="MMM dd, yyyy"/>
		</p> --%>
		<p class="division" style="color: #fff">
			<c:choose>
				<c:when test="${match.defaultWin}">
					<c:out value="${match.defaultWinner.fullName}"/> <fmt:message key="results.defaultWin"/>
				</c:when>
				<c:when test="${(null != match.score.opponentRetired)}">
					<c:out value="${match.result.winner.fullName}"/> <fmt:message key="results.wins"/> <fmt:message key="results.opponentRetired"/>
				</c:when>
				<c:otherwise>
					<c:out value="${match.result.winner.fullName}"/> <fmt:message key="results.wins"/>
					<c:out value="${winningCount}"/> - <c:out value="${loosingCount}"/>
				</c:otherwise>
			</c:choose>
		</p>
		<c:if test="${match.result.tie}">
			<p class="division"><fmt:message key="results.draw"/></p>
		</c:if>
	</div>
	<div class="clear"></div>
</div>

<c:if test="${not match.defaultWin}">
	<div class="section">
		<div class="left">
			<c:set var="fromScheduleViewResultLink" value="true" scope="request"/>
			<c:import url="/common/matchCard.jsp"/>
		</div>
	</div>
	<div class="clear"></div>
</c:if>
	
<div class="section">
	<div id="view-back">
		<carter:button onclick="history.go(-1);return false;" key="button.back"/>
	</div>
</div>
	