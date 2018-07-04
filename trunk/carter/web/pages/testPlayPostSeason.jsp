<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="test.playPostSeason.title"/></title>
    <content tag="heading"><fmt:message key="test.playPostSeason.heading"/></content>
    <meta name="menu" content="Test"/>
</head>

<form:form commandName="playSeasonInfo" method="post" action="testPlayPostSeason.html" id="testPlaySeasonForm">
<ul>
    <li>
        <carter:label styleClass="desc" key="test.playPostSeason.season"/>
        <form:errors path="season" cssClass="fieldError"/>
        <form:select path="season" id="season" cssClass="text large">
       		<c:forEach var="season" items="${seasonList}">
				<option value="<c:out value='${season.id}'/>">
 					<c:out value="${season.name}"/>
				</option>
			</c:forEach>
        </form:select>
    </li>
    <li>
		<input type="submit" class="button" name="save" onclick="bCancel=false" value="<fmt:message key="button.save"/>"/>
    </li>
</ul>
</form:form>
