<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="adminInbox.title"/></title>
</head>

<c:choose>
<c:when test="${not empty messages}">
<h2><fmt:message key="adminInbox.title"/></h2>
<form method="post">
		
	<display:table name="messages" id="message" pagesize="25" requestURI="">
		<display:column>
			<input type="checkbox" name="<c:out value="${message.id}"/>" value="Y"/>
		</display:column>
		<display:column titleKey="inbox.from" property="from.fullName" url="/inbox.html" paramId="msg" paramProperty="id"/>
		<display:column titleKey="adminInbox.to" property="to.fullName" url="/inbox.html" paramId="msg" paramProperty="id"/>
		<display:column titleKey="inbox.subject" property="subject" url="/inbox.html" paramId="msg" paramProperty="id"/>
		<display:column titleKey="inbox.received" property="dateSent" decorator="com.sageconsulting.webapp.decorators.MessageDateColumnDecorator" url="/inbox.html" paramId="msg" paramProperty="id"/>

		<display:setProperty name="paging.banner.placement" value="bottom" />				        
		<display:setProperty name="paging.banner.first" value='<span class="pagelinks">Page {5} of {6} [First / Prev / <a href="{3}">Next</a> / <a href="{4}">Last </a>]</span>' />				        
		<display:setProperty name="paging.banner.last" value='<span class="pagelinks">Page {5} of {6} [<a href="{1}">First</a> / <a href="{2}">Prev</a> / Next/ Last ]</span>' />				        
		<display:setProperty name="paging.banner.full" value='<span class="pagelinks">Page {5} of {6} [<a href="{1}">First</a> / <a href="{2}">Prev</a> / <a href="{3}">Next</a> / <a href="{4}">Last </a>]</span>' />
		<display:setProperty name="paging.banner.no_items_found" value="" />				        
		<display:setProperty name="paging.banner.one_item_found" value="" />				        
		<display:setProperty name="paging.banner.some_items_found" value="" />				        
		<display:setProperty name="paging.banner.all_items_found" value="" />				        
	</display:table>
	<input type="submit" name="delete" value="<fmt:message key="inbox.delete"/>">
</form>
</c:when>
<c:otherwise>
	<fmt:message key="inbox.nomessages"/>
</c:otherwise>
</c:choose>