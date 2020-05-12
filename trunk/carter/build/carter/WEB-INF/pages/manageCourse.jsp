<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="manageCourse.title"/></title>
    <content tag="heading"><fmt:message key="manageCourse.heading"/></content>
    <meta name="menu" content="AdminMenu"/>
</head>

<div id="manageCourse">
	<p class="top-msg"><fmt:message key="manageCourse.courseList"/></p>
	
	<c:choose>
		<c:when test="${not empty courses}">
			<display:table name="courses" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="courses" pagesize="25" class="table" export="false">
			    <display:column property="name" escapeXml="true" sortable="true" titleKey="manageCourse.course"
			    url="/editCourse.html" paramId="id" paramProperty="id"/>
			    <display:column property="proShopPhone" escapeXml="true" sortable="true" titleKey="manageCourse.proShopPhone"/>
			    <display:column property="teeTimePhone" escapeXml="true" sortable="true" titleKey="manageCourse.teeTimePhone"/>
			</display:table><br/>
		</c:when>
		<c:otherwise>
			<p>No Courts are registered with this city.</p><br/>
		</c:otherwise>
	</c:choose>
	<a style="margin-right:20px;" href="citymanage.html"><fmt:message key="manageCourse.back"/></a>
	<a href="editCourse.html"><fmt:message key="manageCourse.addNew"/></a>
</div>