<%@ include file="/common/taglibs.jsp"%>

<c:set var="errorStatusCode" value="403" scope="request"/>
<page:applyDecorator name="default">

<title><fmt:message key="403.title"/></title>

<div id="successMessages" class="message" style="background-image: none; background-color: transparent;">
	<img class="icon" alt="Information" src="/carter/images/iconInformation.gif"/>
	<fmt:message key="403.message"><fmt:param><c:url value="/"/></fmt:param></fmt:message>
	<div class="err-space"></div>
</div>

</page:applyDecorator>