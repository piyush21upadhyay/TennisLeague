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
			<c:when test="${user.currentSeason.state == 4 and empty matches}">0-0-0</c:when>
			<c:otherwise>	
				<c:out value="${user.currentWins}"/>-<c:out value="${user.currentLosses}"/>-<c:out value="${user.currentTies}"/>
			</c:otherwise>
		</c:choose>	
		</p>
		<c:if test="${not empty user.currentSeason}">
			<p class="season"><c:out value="${user.address.city}, ${user.currentSeason.name}"/></p>
			
			<%-- <p class="division"><c:out value="${user.currentSeason.division}"/></p> --%>
		</c:if>
	</div>
</div>
<div class="clear"></div>

<div  class="section">
<c:choose>
<c:when test="${user.currentSeason.state != 4}">
	<c:out value="${user.currentWins} Wins  "/><c:out value="${user.currentLosses} Loss  "/><c:out value="${user.currentTies} Ties"/>
</c:when>
</c:choose>
<p style="text-transform: uppercase;"><c:out value="${user.firstName}"/><br><c:out value="${user.lastName}"/></p>

<div class="square" style="width:27px;height: 27px;Background-color: #9dc227;">7</div>

</div>

<%--
<c:if test="${empty matches}">
	<div class="message"><fmt:message key="record.noMatches"/></div>
</c:if>
 --%>

<%--
<c:if test="${not empty matches}">
 --%>
<div class="record-section">
  <div class="record-section-container">

	<c:forEach var="match" items="${matches}">
		<div class="match">
		    <p>
				<%-- <c:choose>
					<c:when test="${match.result.tie}">
				        <c:out value="${match.course.name}"/> / <fmt:formatDate value="${match.played}" pattern="MMM dd, yyyy"/> / 
						<c:choose>
							<c:when test="${match.puttoffWinner ne null}">
								<c:out value="${match.puttoffWinner.fullName}"/> <fmt:message key="results.wonInPuttoff"/>
							</c:when>
							<c:otherwise>
								<fmt:message key="results.draw"/>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:when test="${match.defaultWin}">
				        <c:out value="${match.course.name}"/> / <fmt:formatDate value="${match.played}" pattern="MMM dd, yyyy"/> / 
						<c:out value="${match.defaultWinner.fullName}"/> <fmt:message key="results.defaultWin"/>
					</c:when>
					<c:when test="${match.bye}">
						<c:out value="${match.golfer1.fullName}"/> <fmt:message key="results.hadABye"/>
					</c:when>
					<c:otherwise>
				        <c:out value="${match.course.name}"/> / <fmt:formatDate value="${match.played}" pattern="MMM dd, yyyy"/> / 
						<c:out value="${match.result.winner.fullName}"/>
						<fmt:message key="results.wins"/>
						<c:out value="${match.result.holesWon}"/> &amp; <c:out value="${match.result.holesRemaining}"/>
					</c:otherwise>
				</c:choose> --%>
				
				<!-- Changes done by Piyush & Akash -->
				</p>
				<%-- <div class="left">
					<p>
						<img src="<c:url value="${match.golfer1.icon}"/>" alt="member" width="22"/>
							<c:out value="${match.golfer1.fullName}"/>
					</p>
					<p>
						<img src="<c:url value="${match.golfer2.icon}"/>" alt="member" width="22"/>
							<c:out value="${match.golfer2.fullName}"/>
					</p>
				</div> --%>
				
				<!-- Changes done by Piyush & Akash Ends-->

			<c:if test="${isAdministrator}">
				<c:set var="url"><c:url value="/resultsdispatch.html"/></c:set>
				<carter:button page="${url}" param="id=${match.id}&amp;user_id=${user.id}" key="button.edit"/>
			</c:if>
			<c:if test="${not match.defaultWin and not match.bye}">
				<c:set var="matchParam" value="${match}" scope="request"/>
				<c:import url="/common/matchCard.jsp"/>
				<div class="clear"></div>
			</c:if>
		</div>
	</c:forEach>
  </div>
</div>

<div class="legend-section">	
<c:import url="/common/legend.jsp">
	<c:param name="layout" value="vertical"/>
</c:import>
</div>

<%--
</c:if>
 --%>
