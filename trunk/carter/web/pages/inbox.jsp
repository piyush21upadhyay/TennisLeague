<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="inbox.title"/></title>
    <meta name="menu" content="Profile"/>
</head>

<c:if test="${not empty pageContext.request.remoteUser}">
<div class="msgboard-section">
	<div id="inbox" class="col-12">
	<div class="d-flex justify-content-between heading-golfer">
	<span class="pt-10"> <fmt:message key="inbox.inbox"/> </span> <span><img src="images/inbox.png" alt="msg"> </span>
	</div>
		
		
		<!-- as per latest design not required --> <!-- <div class="left"><h3><c:out value="${newMessageCount}"/> <fmt:message key="inbox.unread"/></h3></div> -->
		<div class="clear"></div>
		<form id="msgForm" method="post" action="<c:url value="/inbox.html"/>">
		<display:table name="messages" id="message" cellspacing="0" cellpadding="0" pagesize="10" requestURI="" class="messages">
		    <display:column>
		        <input type="checkbox" name="msgDelete" value="<c:out value="${message.id}"/>"/>
		    </display:column>
			<c:choose>			
				<c:when test="${empty message.dateRead}">
				    <display:column property="from.fullName" titleKey="inbox.from" url="/inbox.html" paramId="msg" paramProperty="id" class="unread"/>
				    <display:column property="subject" titleKey="inbox.subject" url="/inbox.html" paramId="msg" paramProperty="id" class="unread"/>
				    <display:column property="dateSent" titleKey="inbox.date" decorator="com.sageconsulting.webapp.decorators.MessageDateColumnDecorator" class="unread"/>
				</c:when>
				<c:otherwise>
				    <display:column property="from.fullName" titleKey="inbox.from" url="/inbox.html" paramId="msg" paramProperty="id"/>
				    <display:column property="subject" titleKey="inbox.subject" url="/inbox.html" paramId="msg" paramProperty="id"/>
				    <display:column property="dateSent" titleKey="inbox.date" decorator="com.sageconsulting.webapp.decorators.MessageDateColumnDecorator"/>
				</c:otherwise>
			</c:choose>
	
		    <display:setProperty name="paging.banner.item_name"><fmt:message key="inbox.message"/></display:setProperty>
		    <display:setProperty name="paging.banner.items_name"><fmt:message key="inbox.messages"/></display:setProperty>
		    <display:setProperty name="basic.empty.showtable" value="true"/>
		    <display:setProperty name="basic.msg.empty_list" value="" />
		    <display:setProperty name="basic.msg.empty_list_row" value="" />
			<display:setProperty name="paging.banner.placement" value="bottom" />
			<display:setProperty name="paging.banner.no_items_found"><fmt:message key="inbox.noMessages"/></display:setProperty>
			<display:setProperty name="paging.banner.one_item_found" value="" />
			<display:setProperty name="paging.banner.some_items_found"><fmt:message key="inbox.someMessages"/></display:setProperty>
			<display:setProperty name="paging.banner.all_items_found" value="" />
			<display:setProperty name="paging.banner.full"><fmt:message key="inbox.full"/></display:setProperty>
			<display:setProperty name="paging.banner.first"><fmt:message key="inbox.first"/></display:setProperty>
			<display:setProperty name="paging.banner.last"><fmt:message key="inbox.last"/></display:setProperty>
			<display:setProperty name="paging.banner.onepage" value="" />
		</display:table>
		<div class="col-12 text-right del_btn_pg">
		<carter:button onclick="document.getElementById('bDelete').value='true';return onFormSubmit(document.getElementById('msgForm'));" key="button.delete"/>
		<input type="hidden" id="bDelete" name="bDelete" value="false"/>
		</div>
		</form>
	</div>
	
	<div id="inbox-message" class="col-12">
	
	<c:choose>
	
	<c:when test="${not empty sentMessage}">
	<div id="msgheader">
	<h2><fmt:message key="sendMsg.sent"/></h2>
	<h3><c:out value="${sentMessage}"/></h3>
	</div>
    </c:when>
	
	<c:otherwise>
	<c:if test="${not empty currentMessage}">
		
			<div id="msgheader">
				<h2><fmt:message key="inbox.msgFrom"/> <strong><c:out value="${currentMessage.from.fullName}"/></strong></h2>
				<h2><fmt:message key="inbox.msgSubject"/> <strong><c:out value="${currentMessage.subject}"/></strong></h2>
			</div>
			<p class="msg-head"><fmt:message key="publicMessage.message"/>:</p>
			<div id="msg">
				<c:out value="${currentMessage.message}" escapeXml="false"/>
			</div>
			<a class="reply-link" href="<c:url value="sendMessage.html"/>?replyTo=<c:out value="${currentMessage.id}"/>"><fmt:message key="inbox.reply"/></a>
		
	</c:if>
	</c:otherwise>
	</c:choose>
	</div>
	<div class="clear"></div>	
</div>

<script type="text/javascript">
<!--
    function onFormSubmit(theForm) {
        if (!hasSelected(theForm)) {
            cglAlert('<fmt:message key="inbox.delete"/>','<fmt:message key="inbox.noSelection"/>',400);
            return false;
        }
   	    cglConfirm('<fmt:message key="inbox.delete"/>','<fmt:message key="inbox.confirmDelete"/>',400,confirmDelete,theForm);
   	    return false;
   	}
	function confirmDelete(confirmed, theForm) {
		if (confirmed) theForm.submit();
	}
   	function hasSelected(theForm) {
   	   	var inputs = theForm.getElementsByTagName('input');
   	   	for (var i=0; i<inputs.length; i++) {
			if (inputs[i].checked)
				return true;
  	   	}
  	   	return false;
   	}
-->
</script>
</c:if>