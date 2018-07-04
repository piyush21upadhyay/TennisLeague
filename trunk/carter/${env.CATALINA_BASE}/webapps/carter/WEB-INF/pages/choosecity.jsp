<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="choosecity.title"/></title>
	<content tag="heading"><fmt:message key="choosecity.heading"/></content>
    <meta name="menu" content="Courses"/>
</head>

<p><fmt:message key="choosecity.message"/></p>

<ul>
   	<c:forEach var="city" items="${availableCities}">
    	<li>
			<a href="choosecity.html?id=<c:out value="${city.id}"/>">
				<c:out value="${city}"/>
			</a>
	    </li>
	</c:forEach>
</ul>
