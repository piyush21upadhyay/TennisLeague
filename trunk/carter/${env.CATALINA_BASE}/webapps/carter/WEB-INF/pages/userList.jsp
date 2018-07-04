<%@ include file="/common/taglibs.jsp"%><head>
    <title><fmt:message key="userList.title"/></title>
    <meta name="menu" content="AdminMenu"/>
</head>

<script type="text/javascript">
	function deleteUser(isConfirmed, userId)
	{
		if(isConfirmed)
		{
			$("#userId").val(userId);
			$("#action").val("delete");
			document.userForm.submit();
		}
	}
</script>

<form style="display:none;" method="post" id="userForm" name="userForm" action="users.html">
	<input type="hidden" name="id" id="userId" value="0" />
	<input type="hidden" name="action" id="action" value="none" />
</form>

<div id="page-admin-users" class="page-admin">
	<c:set var="buttons">
		<input type="button" style="margin-right: 5px"
			onclick="location.href='<c:url value="/editUser.html?method=Add&from=list"/>'"
			value="<fmt:message key="button.add"/>"/>

		<input type="button" onclick="location.href='<c:url value="/home.html"/>'"
			value="<fmt:message key="button.done"/>"/>
	</c:set>

	<c:out value="${buttons}" escapeXml="false" />

	<display:table name="userList" cellspacing="0" cellpadding="0" requestURI="" 
		defaultsort="1" id="users" pagesize="25" class="table" export="true">
		<display:column property="registeredCity.name" titleKey="user.registeredCity.name" media="csv xml excel pdf"/>
		<display:column property="lastName" titleKey="user.lastName" media="csv xml excel pdf"/>
		<display:column property="firstName" titleKey="user.firstName" media="csv xml excel pdf"/>
		<display:column property="username" escapeXml="true" sortable="true" titleKey="user.username" style="width: 25%"
			url="/edituser.html" paramId="usr" paramProperty="username"/>
		<display:column property="password" titleKey="user.password" media="csv xml excel pdf"/>
		<display:column property="fullName" escapeXml="true" sortable="true" titleKey="activeUsers.fullName" style="width: 34%" media="html"/>
		<display:column property="email" sortable="true" titleKey="user.email" style="width: 25%" autolink="true" media="html"/>
		<display:column property="email" titleKey="user.email" media="csv xml excel pdf"/>
		<display:column property="address.address" titleKey="user.address.address" media="csv xml excel pdf"/>
		<display:column property="address.city" titleKey="user.address.city" media="csv xml excel pdf"/>
		<display:column property="address.province" titleKey="user.address.province" media="csv xml excel pdf"/>
		<display:column property="address.postalCode" titleKey="user.address.postalCode" media="csv xml excel pdf"/>
		<display:column property="cellPhone" titleKey="user.cellPhone" media="csv xml excel pdf"/>
		<display:column property="homePhone" titleKey="user.homePhone" media="csv xml excel pdf"/>
		<display:column property="handicap" titleKey="user.handicap" media="csv xml excel pdf"/>
		<display:column property="dateJoined" format="{0,date,dd-MM-yyyy}" titleKey="user.dateJoined" media="csv xml excel pdf"/>
		<display:column property="seasonEntered" titleKey="user.seasonEntered" media="csv xml excel pdf"/>
		<display:column property="currentSeason.name" titleKey="user.lastSeason" media="csv xml excel pdf"/>
		<display:column property="homeCourse.name" titleKey="user.homeCourse.name" media="csv xml excel pdf"/>
		<display:column property="referral" nulls="true" titleKey="user.otherInfo" media="csv xml excel pdf"/>
		
		<display:column sortProperty="enabled" sortable="true" titleKey="user.enabled" style="width: 11%; padding-left: 15px" media="html">
			<input type="checkbox" disabled="disabled" <c:if test="${users.enabled}">checked="checked"</c:if>/>
		</display:column>
		
		<c:if test="${users.enabled}">
		<display:column>
			<a class="ie-post-link" onclick="cglConfirm('Confirm Delete','Are you sure you want to delete this User?', 300 , deleteUser, <c:out value='${users.id}'/>);">Delete</a>
		</display:column>
		</c:if>
		<display:column property="accountDeleted" titleKey="user.deletedMembership" media="csv xml excel pdf"/>

		<display:setProperty name="paging.banner.item_name" value="user"/>
		<display:setProperty name="paging.banner.items_name" value="users"/>

		<display:setProperty name="export.excel.filename" value="User List.xls"/>
		<display:setProperty name="export.csv.filename" value="User List.csv"/>
		<display:setProperty name="export.pdf.filename" value="User List.pdf"/>
	</display:table>

	<c:out value="${buttons}" escapeXml="false" />
</div>