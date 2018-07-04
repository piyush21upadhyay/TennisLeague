<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="courses.title"/></title>
    <meta name="menu" content="Courses"/>
</head>

<c:if test="${empty errors and empty successMessages}">

<div class="section">
	<h2 class="page-title"><fmt:message key="courses.title"/></h2>
</div>

<div class="course-section">
<c:forEach var="course" items="${courseList}">
<div class="threecol-frame">
	<h2><c:out value="${course.name}"/></h2>
	<p><fmt:message key="coursedetails.proShop"/> <c:out value="${course.proShopPhone}"/><br/></p>
	<p><fmt:message key="coursedetails.teeTime"/> <c:out value="${course.teeTimePhone}"/></p>
	<p><a class="course-link" href="coursedetails.html?id=<c:out value="${course.id}"/>"><fmt:message key="courses.viewCard"/></a></p>
	<p><a class="course-link" target="_blank" href="<c:out value="${course.webSite}"/>"><fmt:message key="courses.viewWebSite"/></a></p>
</div>
</c:forEach>
</div>

</c:if>
