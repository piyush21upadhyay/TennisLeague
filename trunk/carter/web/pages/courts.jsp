<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="courts.title"/></title>
    <meta name="menu" content="Courts"/>
</head>

<c:if test="${empty errors and empty successMessages}">

<div class="section">
	<h2 class="page-title"><fmt:message key="courts.title"/></h2>
</div>

<div class="court-section">
<c:forEach var="court" items="${courtList}">
<div class="threecol-frame">
	<h2><c:out value="${court.name}"/></h2>
	<p><fmt:message key="courtDetails.address"/> <c:out value="${court.courtAddress}"/><br/></p>
	<p><fmt:message key="courtDetails.city"/> 
		<c:forEach var="city" items="${court.cities}">
			<c:out value="${city.name}"/>
		</c:forEach>
	<p><fmt:message key="courtDetails.state"/> <c:out value="${court.courtState}"/></p>
	<p><fmt:message key="courtDetails.noOfCourts"/> <c:out value="${court.numberOfCourts}"/></p>
	<p><fmt:message key="courtDetails.lighted"/> <c:out value="${court.isCourtLighted}"/></p>
	<p><fmt:message key="courtDetails.hours"/> <c:out value="${court.openCourtHour}"/> <c:out value="${court.openCourtMeridiem}"/>-<c:out value="${court.closeCourtHour}"/><c:out value="${court.closeCourtMeridiem}"/></p>
	<p><fmt:message key="courtDetails.verified"/> <c:out value="${court.isCourtVerifiedByAdmin}"/></p>
</div>
</c:forEach>
</div>

<!-- Below section is displayed when admin logs in and some courts for that city are in non verified mode--Starts -->
<c:if test="${isAdmin}">
<form:form commandName="editCourt" method="post" id="editCourt" action="/editCourt.html">
	<div class="court-section">
		<c:forEach var="court" items="${courtList}">
			<div class="threecol-frame">
				<label for="name"><fmt:message key="courtDetails.name"/></label><form:input path="name" id="name" cssClass="longBox" maxlength="30"/>
			</div>
		</c:forEach>
	</div>
</form:form>
</c:if>

<!-- Below section is displayed when admin logs in and some courts for that city are in non verified mode--Ends -->
</c:if>
