<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="coursedetails.title"/></title>
    <meta name="menu" content="Courses"/>
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/${appConfig["csstheme"]}/scorecard1.css'/>" />
</head>

<c:if test="${empty errors and empty successMessages}">

<div class="section">
	<div class="left">
		<h2 class="page-title">
			<c:out value="${course.name}"/>&nbsp;
			<a class="course-link" target="_blank" href="<c:out value="${course.webSite}"/>"><fmt:message key="coursedetails.website"/></a>
		</h2>
	</div>
	<div class="right course-phones">
		<h2><fmt:message key="coursedetails.proShop"/> <c:out value="${course.proShopPhone}"/></h2>
		<h2><fmt:message key="coursedetails.teeTime"/> <c:out value="${course.teeTimePhone}"/></h2>
	</div>
</div>
<div class="clear"></div>

<div class="section">
	<div class="card">
		<div class="top-row">
			<div class="first"><fmt:message key="coursedetails.hole"/></div>
			<c:forEach var="hole" begin="1" end="9" step="1">
				<div class="hole"><c:out value="${hole}"/></div>
			</c:forEach>
			<div class="nine"><fmt:message key="coursedetails.out"/></div>
			<c:forEach var="hole" begin="10" end="18" step="1">
				<div class="hole"><c:out value="${hole}"/></div>
			</c:forEach>
			<div class="nine"><fmt:message key="coursedetails.in"/></div>
			<div class="last"><fmt:message key="coursedetails.total"/></div>
		</div>
		<div class="clear"></div>
		<div class="row">
			<div class="first"><fmt:message key="coursedetails.yardage"/></div>
			<c:forEach var="hole" begin="0" end="8" step="1">
				<div class="hole"><c:out value="${course.mensYardages[hole]}"/></div>
			</c:forEach>
			<div class="nine"><c:out value="${course.mensYardageOut}"/></div>
			<c:forEach var="hole" begin="9" end="17" step="1">
				<div class="hole"><c:out value="${course.mensYardages[hole]}"/></div>
			</c:forEach>
			<div class="nine"><c:out value="${course.mensYardageIn}"/></div>
			<div class="last"><c:out value="${course.mensYardageTotal}"/></div>
		</div>
		<div class="clear"></div>
		<div class="row">
			<div class="first"><fmt:message key="coursedetails.handicap"/></div>
			<c:forEach var="hole" begin="0" end="8" step="1">
				<div class="hole"><c:out value="${course.mensHandicaps[hole]}"/></div>
			</c:forEach>
			<div class="nine">&nbsp;</div>
			<c:forEach var="hole" begin="9" end="17" step="1">
				<div class="hole"><c:out value="${course.mensHandicaps[hole]}"/></div>
			</c:forEach>
			<div class="nine">&nbsp;</div>
			<div class="last cat1Total">&nbsp;</div>
		</div>
		<div class="clear"></div>
		<div class="row">
			<div class="first"><fmt:message key="coursedetails.mpar"/></div>
			<c:forEach var="hole" begin="0" end="8" step="1">
				<div class="hole"><c:out value="${course.mensPars[hole]}"/></div>
			</c:forEach>
			<div class="nine"><c:out value="${course.mensParOut}"/></div>
			<c:forEach var="hole" begin="9" end="17" step="1">
				<div class="hole"><c:out value="${course.mensPars[hole]}"/></div>
			</c:forEach>
			<div class="nine"><c:out value="${course.mensParIn}"/></div>
			<div class="last"><c:out value="${course.mensParTotal}"/></div>
		</div>
		<div class="clear"></div>
		<div class="row">
			<div class="first"><fmt:message key="coursedetails.yardage"/></div>
			<c:forEach var="hole" begin="0" end="8" step="1">
				<div class="hole"><c:out value="${course.womensYardages[hole]}"/></div>
			</c:forEach>
			<div class="nine"><c:out value="${course.womensYardageOut}"/></div>
			<c:forEach var="hole" begin="9" end="17" step="1">
				<div class="hole"><c:out value="${course.womensYardages[hole]}"/></div>
			</c:forEach>
			<div class="nine"><c:out value="${course.womensYardageIn}"/></div>
			<div class="last"><c:out value="${course.womensYardageTotal}"/></div>
		</div>
		<div class="clear"></div>
		<div class="row">
			<div class="first"><fmt:message key="coursedetails.handicap"/></div>
			<c:forEach var="hole" begin="0" end="8" step="1">
				<div class="hole"><c:out value="${course.womensHandicaps[hole]}"/></div>
			</c:forEach>
			<div class="nine">&nbsp;</div>
			<c:forEach var="hole" begin="9" end="17" step="1">
				<div class="hole"><c:out value="${course.womensHandicaps[hole]}"/></div>
			</c:forEach>
			<div class="nine">&nbsp;</div>
			<div class="last">&nbsp;</div>
		</div>
		<div class="clear"></div>
		<div class="bottom-row">
			<div class="first"><fmt:message key="coursedetails.wpar"/></div>
			<c:forEach var="hole" begin="0" end="8" step="1">
				<div class="hole"><c:out value="${course.womensPars[hole]}"/></div>
			</c:forEach>
			<div class="nine"><c:out value="${course.womensParOut}"/></div>
			<c:forEach var="hole" begin="9" end="17" step="1">
				<div class="hole"><c:out value="${course.womensPars[hole]}"/></div>
			</c:forEach>
			<div class="nine"><c:out value="${course.womensParIn}"/></div>
			<div class="last"><c:out value="${course.womensParTotal}"/></div>
		</div>
		<div class="clear"></div>
		<div class="rating">
			<span><fmt:message key="coursedetails.rating"/>&nbsp;</span><fmt:message key="coursedetails.mens"/> <c:out value="${course.mensRating}"/>/<c:out value="${course.mensSlope}"/>&nbsp;&nbsp;<fmt:message key="coursedetails.womens"/> <c:out value="${course.womensRating}"/>/<c:out value="${course.womensSlope}"/>
		</div>
	</div>
</div>

</c:if>
