<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="record.title"/></title>
    <meta name="menu" content="Profile"/>
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/${appConfig["csstheme"]}/scorecard2.css'/>" />
</head>

<div class="section">
	<div class="left userInfo">
		<p class="user"><c:out value="${user.fullName}"/>&nbsp;&nbsp;
		<c:choose>
			<c:when test="${user.currentSeason.state == 4 and empty matches}">0-0</c:when>
			<c:otherwise>	
				<c:out value="${user.currentWins}"/>-<c:out value="${user.currentLosses}"/><%-- -<c:out value="${user.currentTies}"/> --%>
			</c:otherwise>
		</c:choose>	
		</p>
		<%-- <c:if test="${not empty user.currentSeason}">
			<p class="season"><c:out value="${user.address.city}, ${user.currentSeason.name}"/></p>
		</c:if> --%>
	</div>
</div>
<div class="clear"></div>

<div class="record-section">
  <div class="record-section-container">

	<c:forEach var="match" items="${matches}">
		<div class="match">

			<c:if test="${isAdministrator}">
				<c:set var="url"><c:url value="/resultsdispatch.html"/></c:set>
				<carter:button page="${url}" param="id=${match.id}&amp;user_id=${user.id}" key="button.edit"/>
			</c:if>
			<%-- <c:if test="${not match.defaultWin and not match.bye}"> --%>
				<c:set var="matchParam" value="${match}" scope="request"/>
				<c:import url="/common/matchCard.jsp"/>
				<div class="clear"></div>
			<%-- </c:if> --%>
		</div>
	</c:forEach>
  </div>
</div>
