<%@ include file="/common/taglibs.jsp"%>

<response>
<c:choose>
	<c:when test="${not empty isExistingEmail}">
		<c:out value="${isExistingEmail}" escapeXml="false"/>
	</c:when>
	<c:when test="${not empty isExistingUserName}">
		<c:out value="${isExistingUserName}" escapeXml="false"/>
	</c:when>
</c:choose>
</response>