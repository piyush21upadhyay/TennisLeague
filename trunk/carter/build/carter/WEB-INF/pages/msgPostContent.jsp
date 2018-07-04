<%@ include file="/common/taglibs.jsp"%>
<response>
<c:choose>
	<c:when test="${not empty currentMessage}">
		<div id="msgheader">
			<h2><fmt:message key="inbox.msgFrom"/> <b><c:out value="${currentMessage.poster.fullName}"/></b></h2>
			<h2><fmt:message key="inbox.msgSubject"/> <b><c:out value="${currentMessage.subject}"/></b></h2>
		</div>
		<p class="msg-head"><fmt:message key="publicMessage.message"/>:</p>
		<div id="msg">
			<c:out value="${currentMessage.message}" escapeXml="false"/>
		</div>
		<c:if test="${not empty user}">
			<a class="reply-link" href="<c:url value="msgboard.html"/>?replyTo=<c:out value="${currentMessage.id}"/>"><fmt:message key="inbox.reply"/></a>
		</c:if>
	</c:when>
</c:choose>
</response>