<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="playoffs.title"/></title>
    <meta name="menu" content="Playoffs"/>
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
					<c:out value="${season.name}"/> <span><c:out value="${season.division}"/></span>
				</c:otherwise>
			</c:choose>
		</h2>
	</div>
	<div class="right">
		<%-- <form:form name="season" method="post" action="playoffs.html">
			<select name="seasonid" onchange="document.season.submit();">
				<option value="0"><fmt:message key="playoffs.choose"/></option>
				<c:forEach var="season" items="${seasons}">
					<option value="<c:out value="${season.id}"/>"><c:out value="${season.name}"/> <c:out value="${season.division}"/></option>
				</c:forEach>
			</select>
		</form:form> --%>
		<select id="matchCat" name="matchCat" >
				<option value="0"><fmt:message key="playoffs.chooseCategory"/></option> 
				<c:forEach var="matchCategory" items="${matchCategories}">
					<option value="<c:out value="${matchCategory.id}"/>"><c:out value="${matchCategory.name}"/></option>
				</c:forEach>
			</select>
	</div>
</div>

<div id="bracket-container">
	<div id="bracket">
		<div id="trophy"></div>
		<div id="r1m1p1"><a href="<c:url value="profile.html?id="/><c:out value="${r1m1p1id}"/>"><c:out value="${r1m1p1}"/></a></div>
		<div id="r1m1p2"><a href="<c:url value="profile.html?id="/><c:out value="${r1m1p2id}"/>"><c:out value="${r1m1p2}"/></a></div>
		<div id="r1m2p1"><a href="<c:url value="profile.html?id="/><c:out value="${r1m2p1id}"/>"><c:out value="${r1m2p1}"/></a></div>
		<div id="r1m2p2"><a href="<c:url value="profile.html?id="/><c:out value="${r1m2p2id}"/>"><c:out value="${r1m2p2}"/></a></div>
		<div id="r1m3p1"><a href="<c:url value="profile.html?id="/><c:out value="${r1m3p1id}"/>"><c:out value="${r1m3p1}"/></a></div>
		<div id="r1m3p2"><a href="<c:url value="profile.html?id="/><c:out value="${r1m3p2id}"/>"><c:out value="${r1m3p2}"/></a></div>
		<div id="r1m4p1"><a href="<c:url value="profile.html?id="/><c:out value="${r1m4p1id}"/>"><c:out value="${r1m4p1}"/></a></div>
		<div id="r1m4p2"><a href="<c:url value="profile.html?id="/><c:out value="${r1m4p2id}"/>"><c:out value="${r1m4p2}"/></a></div>
		<div id="r1m5p1"><a href="<c:url value="profile.html?id="/><c:out value="${r1m8p1id}"/>"><c:out value="${r1m8p1}"/></a></div>
		<div id="r1m5p2"><a href="<c:url value="profile.html?id="/><c:out value="${r1m8p2id}"/>"><c:out value="${r1m8p2}"/></a></div>
		<div id="r1m6p1"><a href="<c:url value="profile.html?id="/><c:out value="${r1m7p1id}"/>"><c:out value="${r1m7p1}"/></a></div>
		<div id="r1m6p2"><a href="<c:url value="profile.html?id="/><c:out value="${r1m7p2id}"/>"><c:out value="${r1m7p2}"/></a></div>
		<div id="r1m7p1"><a href="<c:url value="profile.html?id="/><c:out value="${r1m5p1id}"/>"><c:out value="${r1m5p1}"/></a></div>
		<div id="r1m7p2"><a href="<c:url value="profile.html?id="/><c:out value="${r1m5p2id}"/>"><c:out value="${r1m5p2}"/></a></div>
		<div id="r1m8p1"><a href="<c:url value="profile.html?id="/><c:out value="${r1m6p1id}"/>"><c:out value="${r1m6p1}"/></a></div>
		<div id="r1m8p2"><a href="<c:url value="profile.html?id="/><c:out value="${r1m6p2id}"/>"><c:out value="${r1m6p2}"/></a></div>
		<div id="r2m1p1"><c:out value="${r2m1p1}"/></div>
		<div id="r2m1p2"><c:out value="${r2m1p2}"/></div>
		<div id="r2m2p1"><c:out value="${r2m2p1}"/></div>
		<div id="r2m2p2"><c:out value="${r2m2p2}"/></div>
		<div id="r2m3p1"><c:out value="${r2m4p2}"/></div>
		<div id="r2m3p2"><c:out value="${r2m4p1}"/></div>
		<div id="r2m4p1"><c:out value="${r2m3p1}"/></div>
		<div id="r2m4p2"><c:out value="${r2m3p2}"/></div>
		<div id="r3m1p1"><c:out value="${r3m1p1}"/></div>
		<div id="r3m1p2"><c:out value="${r3m1p2}"/></div>
		<div id="r3m2p1"><c:out value="${r3m2p2}"/></div>
		<div id="r3m2p2"><c:out value="${r3m2p1}"/></div>
		<div id="r4m1p1"><c:out value="${r4m1p1}"/></div>
		<div id="r4m1p2"><c:out value="${r4m1p2}"/></div>
		<div id="champion">
			<div class="name"><c:out value="${champion}"/></div>
			<div class="label">City Champion</div>
		</div>
	</div>
</div>

</c:if>