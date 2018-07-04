<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="test.createUsers.title"/></title>
    <content tag="heading"><fmt:message key="test.createUsers.heading"/></content>
    <meta name="menu" content="Test"/>
</head>

<form:form commandName="createUserInfo" method="post" action="testCreateUsers.html" id="testCreateUsersForm">
<ul>
    <li>
        <carter:label styleClass="desc" key="test.createUsers.seasonName"/>
        <form:input path="seasonName" id="seasonName" cssClass="text medium" maxlength="50"/>
    </li>
    <li>
        <carter:label styleClass="desc" key="test.createUsers.userCount"/>
        <form:errors path="userCount" cssClass="fieldError"/>
        <form:input path="userCount" id="userCount" cssClass="text medium" maxlength="3"/>
    </li>
    <li>
        <carter:label styleClass="desc" key="test.createUsers.city"/>
        <form:errors path="city" cssClass="fieldError"/>
        <form:select path="city" id="city" cssClass="text large">
       		<c:forEach var="city" items="${cityList}">
				<option value="<c:out value='${city.id}'/>">
 					<c:out value="${city.name}"/>
				</option>
			</c:forEach>
        </form:select>
    </li>
    <li>
		<input type="submit" class="button" name="save" onclick="bCancel=false" value="<fmt:message key="button.save"/>"/>
    </li>
</ul>
</form:form>
