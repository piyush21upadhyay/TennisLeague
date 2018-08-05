<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="courts.title"/></title>
    <meta name="menu" content="Courts"/>
</head>

<c:if test="${empty errors and empty successMessages}">

<div class="section">
	<h2 class="page-title"><fmt:message key="courts.title"/></h2>
</div>

<div class="court-section">
<c:forEach var="court" items="${courtList}">
<div class="threecol-frame">
	<h2><c:out value="${court.name}"/></h2>
	<p><fmt:message key="courtDetails.address"/> <c:out value="${court.courtAddress}"/><br/></p>
	<p><fmt:message key="courtDetails.phoneNumber"/> <c:out value="${court.courtPhone}"/></p>
	<%-- <p><a class="course-link" target="_blank" href="<c:out value="${court.webSite}"/>"><fmt:message key="courses.viewWebSite"/></a></p> --%>
</div>
</c:forEach>
</div>

</c:if>
