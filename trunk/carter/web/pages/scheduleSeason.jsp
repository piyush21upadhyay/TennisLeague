<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="scheduleSeason.title"/></title>
    <content tag="heading"><fmt:message key="scheduleSeason.heading"/></content>
    <meta name="menu" content="Admin"/>
</head>

<spring:bind path="schedule.*">
    <c:if test="${not empty status.errorMessages}">
    <div class="error">
        <c:forEach var="error" items="${status.errorMessages}">
            <img src="<c:url value="/images/iconWarning.gif"/>"
                alt="<fmt:message key="icon.warning"/>" class="icon"/>
            <c:out value="${error}" escapeXml="false"/><br />
        </c:forEach>
    </div>
    </c:if>
</spring:bind>

<c:if test="${registration.scheduleState == 0}">
	<h4><fmt:message key="scheduleSeason.registrants"/></h4>
	<display:table name="registrantList" cellspacing="0" cellpadding="0" requestURI="" 
	    defaultsort="2" id="registrantList" class="table" export="false">
	    <display:column sortable="true" property="user.fullName" titleKey="scheduleSeason.name" url="/profile.html" paramId="id" paramProperty="id" style="white-space: nowrap" media="html"/>
	    <display:column sortable="true" titleKey="scheduleSeason.handicap" style="white-space: nowrap" media="html">
			<c:choose>
				<c:when test="${registrantList.user.handicap lt 0}">
					<c:out value="+"/><c:out value="${0 - registrantList.user.handicap}"/>
				</c:when>
				<c:otherwise>
					<c:out value="${registrantList.user.handicap}"/>
				</c:otherwise>
			</c:choose>
		</display:column>
	
	    <display:setProperty name="paging.banner.item_name"><fmt:message key="scheduleSeason.member"/></display:setProperty>
	    <display:setProperty name="paging.banner.items_name"><fmt:message key="scheduleSeason.members"/></display:setProperty>
	</display:table>
	
	<form:form commandName="schedule" method="post" action="scheduleSeason.html" onsubmit="return onFormSubmit(this)" id="scheduleSeason">
	<form:hidden path="registrationId"/>
	<ul>
	    <li>
	        <carter:label styleClass="desc" key="scheduleSeason.cutoff1"/>
	        <form:errors path="groupACutoff" cssClass="fieldError"/>
	        <form:input path="groupACutoff" id="groupACutoff" cssClass="text medium" maxlength="50"/>
	    </li>
	    <li>
	        <carter:label styleClass="desc" key="scheduleSeason.cutoff2"/>
	        <form:errors path="groupBCutoff" cssClass="fieldError"/>
	        <form:input path="groupBCutoff" id="groupBCutoff" cssClass="text medium" maxlength="50"/>
	    </li>
	    <li>
	        <carter:label styleClass="desc" key="scheduleSeason.cutoff3"/>
	        <form:errors path="groupCCutoff" cssClass="fieldError"/>
	        <form:input path="groupCCutoff" id="groupCCutoff" cssClass="text medium" maxlength="50"/>
	    </li>
	    <li>
	        <carter:label styleClass="desc" key="scheduleSeason.cutoff4"/>
	        <form:errors path="groupDCutoff" cssClass="fieldError"/>
	        <form:input path="groupDCutoff" id="groupDCutoff" cssClass="text medium" maxlength="50"/>
	    </li>
	    <li>
	        <carter:label styleClass="desc" key="scheduleSeason.cutoff5"/>
	        <form:errors path="groupECutoff" cssClass="fieldError"/>
	        <form:input path="groupECutoff" id="groupECutoff" cssClass="text medium" maxlength="50"/>
	    </li>
	    <li>
	        <carter:label styleClass="desc" key="scheduleSeason.seasonMatches"/>
	        <form:errors path="regularSeasonMatches" cssClass="fieldError"/>
	        <form:input path="regularSeasonMatches" id="regularSeasonMatches" cssClass="text medium" maxlength="50"/>
	    </li>
	    <li>
	        <carter:label styleClass="desc" key="scheduleSeason.postSeasonPlayers"/>
	        <form:errors path="postSeasonPlayers" cssClass="fieldError"/>
	        <form:select path="postSeasonPlayers" id="postSeasonPlayers" cssClass="text medium">
	        	<form:option value="16">16</form:option>
	        </form:select>
	    </li>
	    <li class="buttonBar bottom">
		    <input type="submit" class="button" name="save" onclick="bCancel=false" value="<fmt:message key="button.save"/>"/>
		    <input type="submit" class="button" name="cancel" onclick="bCancel=true" value="<fmt:message key="button.cancel"/>"/>
	    </li>
	</ul>
	
	</form:form>
</c:if>

<c:if test="${registration.scheduleState == 1}">
	<h4><fmt:message key="scheduleSeason.seasonsHeading"/></h4>
	<display:table name="seasonList" cellspacing="0" cellpadding="0" requestURI="" 
	    defaultsort="2" defaultorder="descending" id="seasons" class="table" export="false">
	    <display:column sortable="true" property="name" titleKey="scheduleSeason.name" style="white-space: nowrap" media="html"/>
	
	    <display:setProperty name="paging.banner.item_name"><fmt:message key="scheduleSeason.season"/></display:setProperty>
	    <display:setProperty name="paging.banner.items_name"><fmt:message key="scheduleSeason.season"/></display:setProperty>
	</display:table>

	<form:form commandName="schedule" method="post" action="scheduleSeason.html" onsubmit="return onFormSubmit(this)" id="scheduleSeason">
	<form:hidden path="registrationId"/>
	<ul>
	    <li class="buttonBar bottom">
		    <input type="submit" class="button" name="save" onclick="bCancel=false" value="<fmt:message key="button.save"/>"/>
		    <input type="submit" class="button" name="cancel" onclick="bCancel=true" value="<fmt:message key="button.cancel"/>"/>
	    </li>
	</ul>
	
	</form:form>
</c:if>

<script type="text/javascript">
$("#groupACutoff").focus();
</script>

<v:javascript formName="scheduleSeason" staticJavascript="false"/>
<!-- script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script-->

