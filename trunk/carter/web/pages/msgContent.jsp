<%@ include file="/common/taglibs.jsp"%>

<response>
<c:choose>
	<c:when test="${not empty currentMessage}">
		<div style="margin-bottom:8px;">
			<h2><c:out value="${currentMessage.subject}"/></h2>
		</div>
		<div id="msg">
			<c:out value="${currentMessage.message}" escapeXml="false"/>
		</div>
	</c:when>
</c:choose>
</response>