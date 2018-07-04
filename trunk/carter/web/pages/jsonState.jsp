<%@ include file="/common/taglibs.jsp"%>

<response>
<c:choose>
	<c:when test="${not empty state}">
		<c:out value="${state}" escapeXml="false"/>
	</c:when>
</c:choose>
</response>