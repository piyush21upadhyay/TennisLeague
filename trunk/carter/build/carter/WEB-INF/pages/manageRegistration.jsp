<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="registration.title"/></title>
    <content tag="heading"><fmt:message key="registration.heading"/></content>
    <meta name="menu" content="AdminMenu"/>
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>

	<script language="JavaScript" type="text/javascript">
		var regID = 0;
		function navigateToClear( id )
		{
			regID	= id;
			cglConfirm('Confirm Clear', 'Are you sure you want to Clear this Season?', 300, callbackClear, id);
		}

		function callbackClear( b )
		{
			var vID	= 0;
			if( b == true )
				vID	= regID;

			// Reset global id var
			regID	= 0;			

			if( vID > 0 )
				window.location.href = 'manageRegistration.html?func=clear&id=' + vID;
			else if( (b == true) && (vID == 0) )
			{
				cglAlert('Invalid Action',"Cannot find target to clear season.", 300);
				$(".ui-dialog-overlay").width(document.body.clientWidth);
			}
		}	
	</script>
</head>

<c:if test="${not empty errorMessage}">
<div class="error">
    <img src="<c:url value="/images/iconWarning.gif"/>"
        alt="<fmt:message key="icon.warning"/>" class="icon"/>
    <c:out value="${errorMessage}" escapeXml="false"/><br />
</div>
</c:if>

<h4><fmt:message key="registration.closed"/></h4>
<display:table name="closedRegistrationList" cellspacing="0" cellpadding="0" requestURI=""
    defaultsort="1" id="closedRegistration" pagesize="25" class="table" export="false">
    <display:column property="displayName" sortable="true" titleKey="registration.name" style="white-space: nowrap; width: 75%" media="html"/>
    <display:column escapeXml="true" sortable="true" title="&nbsp;" url="/registrationForm.html?func=edit" paramId="id" paramProperty="id" style="white-space: nowrap">
 		<fmt:message key="registration.edit"/>
     </display:column>
     <display:column property="scheduleState" titleKey="registration.name"
     	decorator="com.sageconsulting.webapp.decorators.RegistrationStateColumnDecorator"/>
	<display:column escapeXml="true" sortable="true" title="&nbsp;" url="/viewSeason.html" paramId="id" paramProperty="id">
	   	<c:if test="${closedRegistration.scheduleState != 0}">
		 	<fmt:message key="registration.viewSchedule"/>
		</c:if>
   	</display:column>
    <display:column escapeXml="true" sortable="true" title="&nbsp;" url="/scheduleSeason.html" paramId="id" paramProperty="id">
		<c:choose>
			<c:when test="${closedRegistration.scheduleState == 0}">
				<fmt:message key="registration.createRegularSeasonSchedule"/>
			</c:when>
			<c:when test="${closedRegistration.scheduleState == 1}">
				<fmt:message key="registration.createPostSeasonSchedule"/>
			</c:when>
		</c:choose>
	</display:column>
	
    <display:column escapeXml="true" sortable="true" title="&nbsp;" url="/underpar.html" paramId="id" paramProperty="id">
		<fmt:message key="registration.underParLeaders"/>
	</display:column>

	<%-- <c:if test="${closedRegistration.scheduleState == 2}"> --%>
		<display:column sortable="true" title="&nbsp;" style="whitespace: nowrap;">
			<a class="ie-post-link" href="#" onclick="navigateToClear(<c:out value='${closedRegistration.id}'/>)"><fmt:message key="registration.clearSeason"/></a>
		</display:column>
	<%-- </c:if> --%>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="registration.closedRegistration"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="registration.closedRegistrations"/></display:setProperty>
</display:table>

<h4><fmt:message key="registration.open"/></h4>
<display:table name="openRegistrationList" cellspacing="0" cellpadding="0" requestURI="" 
    defaultsort="1" id="closedRegistrationList" pagesize="25" class="table" export="false">
    <display:column property="displayName" sortable="true" titleKey="registration.name" style="white-space: nowrap; width: 75%" media="html"/>
    <display:column escapeXml="true" sortable="true" title="&nbsp;" url="/registrationForm.html?func=edit" paramId="id" paramProperty="id" style="white-space: nowrap">
 		<fmt:message key="registration.edit"/>
     </display:column>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="registration.openRegistration"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="registration.openRegistrations"/></display:setProperty>
</display:table>
<a href="registrationForm.html"><fmt:message key="registration.add"/></a>

