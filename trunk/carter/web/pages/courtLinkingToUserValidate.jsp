<%@ include file="/common/taglibs.jsp"%>

<response>
<c:choose>
	<c:when test="${not empty usersAssociatedWithThisCourt}">
		<c:out value="${usersAssociatedWithThisCourt}" escapeXml="false"/>
	</c:when>
</c:choose>
</response>