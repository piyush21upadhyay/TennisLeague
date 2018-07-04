<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="course.title"/></title>
    <content tag="heading"><fmt:message key="course.heading"/></content>
    <meta name="menu" content="Courses"/>
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/${appConfig["csstheme"]}/scorecard1.css'/>" />
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>

<spring:bind path="course.*">
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

<form:form commandName="course" method="post" action="editCourse.html" onsubmit="return onFormSubmit(this)" id="courseForm">
<form:hidden path="id"/>
<form:hidden path="version"/>

	<div>
       	<div>
       		<carter:label key="course.name"/>
       		<form:errors path="name" cssClass="fieldError"/>
	        <form:input path="name" id="name" cssClass="text medium"/>
   		</div>
       	<div>
       		<carter:label key="course.webSite"/>
       		<form:errors path="webSite" cssClass="fieldError"/>
	        <form:input path="webSite" id="webSite" cssClass="text medium"/>
   		</div>
  	</div>
	<div>
       	<div>
       		<carter:label key="course.proShopPhone"/>
       		<form:errors path="proShopPhone" cssClass="fieldError"/>
	        <form:input path="proShopPhone" id="proShopPhone" cssClass="text medium"/>
   		</div>
       	<div>
       		<carter:label key="course.teeTimePhone"/>
       		<form:errors path="teeTimePhone" cssClass="fieldError"/>
	        <form:input path="teeTimePhone" id="teeTimePhone" cssClass="text medium"/>
   		</div>
	</div>
	<fieldset class="pickList">
		<legend><fmt:message key="course.cities"/></legend>
		<div>
			<div class="pick-available">
		        <carter:label key="course.availableCities" colon="false" styleClass="required"/>
			</div>
           	<div class="pick-buttons">&nbsp;</div>
           	<div class="pick-selected">
	            <carter:label key="course.cities" colon="false" styleClass="required"/>
           	</div>
           	<div class="clear"></div>
            <c:set var="leftList" value="${cityList}" scope="request"/>
            <c:set var="rightList" value="${course.cityList}" scope="request"/>
            <c:import url="/common/pickList.jsp">
                 <c:param name="listCount" value="1"/>
                 <c:param name="leftId" value="cityList"/>
                 <c:param name="rightId" value="courseCities"/>
  	        </c:import>
           	<div class="clear"></div>
        </div>
 	</fieldset>
	<div>
       	<div>
       		<carter:label key="course.mensSlope"/>
       		<form:errors path="mensSlope" cssClass="fieldError"/>
	        <form:input path="mensSlope" id="mensSlope" cssClass="text medium"/>
   		</div>
       	<div>
       		<carter:label key="course.mensRating"/>
       		<form:errors path="mensRating" cssClass="fieldError"/>
	        <form:input path="mensRating" id="mensRating" cssClass="text medium"/>
   		</div>
   	</div>
  	<div>
  		<carter:label key="course.mensTeeName"/>
  		<form:errors path="mensTeeName" cssClass="fieldError"/>
    	<form:input path="mensTeeName" id="mensTeeName" cssClass="text medium"/>
	</div>
 	<div>
		<carter:label key="course.mensHandicaps"/>
		<table class="coursecard">
			<tr>
				<td><form:input maxlength="2" path="mensHole1Handicap"/></td>
				<td><form:input maxlength="2" path="mensHole2Handicap"/></td>
				<td><form:input maxlength="2" path="mensHole3Handicap"/></td>
				<td><form:input maxlength="2" path="mensHole4Handicap"/></td>
				<td><form:input maxlength="2" path="mensHole5Handicap"/></td>
				<td><form:input maxlength="2" path="mensHole6Handicap"/></td>
				<td><form:input maxlength="2" path="mensHole7Handicap"/></td>
				<td><form:input maxlength="2" path="mensHole8Handicap"/></td>
				<td><form:input maxlength="2" path="mensHole9Handicap"/></td>
				<td><form:input maxlength="2" path="mensHole10Handicap"/></td>
				<td><form:input maxlength="2" path="mensHole11Handicap"/></td>
				<td><form:input maxlength="2" path="mensHole12Handicap"/></td>
				<td><form:input maxlength="2" path="mensHole13Handicap"/></td>
				<td><form:input maxlength="2" path="mensHole14Handicap"/></td>
				<td><form:input maxlength="2" path="mensHole15Handicap"/></td>
				<td><form:input maxlength="2" path="mensHole16Handicap"/></td>
				<td><form:input maxlength="2" path="mensHole17Handicap"/></td>
				<td><form:input maxlength="2" path="mensHole18Handicap"/></td>
			</tr>
		</table>
	</div>
	<div>
		<carter:label key="course.mensPars"/>
		<table class="coursecard">
			<tr>
				<td><form:input maxlength="1" path="mensHole1Par"/></td>
				<td><form:input maxlength="1" path="mensHole2Par"/></td>
				<td><form:input maxlength="1" path="mensHole3Par"/></td>
				<td><form:input maxlength="1" path="mensHole4Par"/></td>
				<td><form:input maxlength="1" path="mensHole5Par"/></td>
				<td><form:input maxlength="1" path="mensHole6Par"/></td>
				<td><form:input maxlength="1" path="mensHole7Par"/></td>
				<td><form:input maxlength="1" path="mensHole8Par"/></td>
				<td><form:input maxlength="1" path="mensHole9Par"/></td>
				<td><form:input maxlength="1" path="mensHole10Par"/></td>
				<td><form:input maxlength="1" path="mensHole11Par"/></td>
				<td><form:input maxlength="1" path="mensHole12Par"/></td>
				<td><form:input maxlength="1" path="mensHole13Par"/></td>
				<td><form:input maxlength="1" path="mensHole14Par"/></td>
				<td><form:input maxlength="1" path="mensHole15Par"/></td>
				<td><form:input maxlength="1" path="mensHole16Par"/></td>
				<td><form:input maxlength="1" path="mensHole17Par"/></td>
				<td><form:input maxlength="1" path="mensHole18Par"/></td>
			</tr>
		</table>
	</div>
	<div>
		<carter:label key="course.mensYardages"/>
		<table class="coursecard">
			<tr>
				<td><form:input maxlength="3" path="mensHole1Yardage"/></td>
				<td><form:input maxlength="3" path="mensHole2Yardage"/></td>
				<td><form:input maxlength="3" path="mensHole3Yardage"/></td>
				<td><form:input maxlength="3" path="mensHole4Yardage"/></td>
				<td><form:input maxlength="3" path="mensHole5Yardage"/></td>
				<td><form:input maxlength="3" path="mensHole6Yardage"/></td>
				<td><form:input maxlength="3" path="mensHole7Yardage"/></td>
				<td><form:input maxlength="3" path="mensHole8Yardage"/></td>
				<td><form:input maxlength="3" path="mensHole9Yardage"/></td>
				<td><form:input maxlength="3" path="mensHole10Yardage"/></td>
				<td><form:input maxlength="3" path="mensHole11Yardage"/></td>
				<td><form:input maxlength="3" path="mensHole12Yardage"/></td>
				<td><form:input maxlength="3" path="mensHole13Yardage"/></td>
				<td><form:input maxlength="3" path="mensHole14Yardage"/></td>
				<td><form:input maxlength="3" path="mensHole15Yardage"/></td>
				<td><form:input maxlength="3" path="mensHole16Yardage"/></td>
				<td><form:input maxlength="3" path="mensHole17Yardage"/></td>
				<td><form:input maxlength="3" path="mensHole18Yardage"/></td>
			</tr>
		</table>
	</div>
	<div>
       	<div>
       		<carter:label key="course.womensSlope"/>
       		<form:errors path="womensSlope" cssClass="fieldError"/>
	        <form:input path="womensSlope" id="womensSlope" cssClass="text medium"/>
   		</div>
       	<div>
       		<carter:label key="course.womensRating"/>
       		<form:errors path="womensRating" cssClass="fieldError"/>
	        <form:input path="womensRating" id="womensRating" cssClass="text medium"/>
   		</div>
   	</div>
	<div>
		<carter:label key="course.womensTeeName"/>
		<form:errors path="womensTeeName" cssClass="fieldError"/>
        <form:input path="womensTeeName" id="womensTeeName" cssClass="text medium"/>
	</div>
	<div>
		<carter:label key="course.womensHandicaps"/>
		<table class="coursecard">
			<tr>
				<td><form:input maxlength="2" path="womensHole1Handicap"/></td>
				<td><form:input maxlength="2" path="womensHole2Handicap"/></td>
				<td><form:input maxlength="2" path="womensHole3Handicap"/></td>
				<td><form:input maxlength="2" path="womensHole4Handicap"/></td>
				<td><form:input maxlength="2" path="womensHole5Handicap"/></td>
				<td><form:input maxlength="2" path="womensHole6Handicap"/></td>
				<td><form:input maxlength="2" path="womensHole7Handicap"/></td>
				<td><form:input maxlength="2" path="womensHole8Handicap"/></td>
				<td><form:input maxlength="2" path="womensHole9Handicap"/></td>
				<td><form:input maxlength="2" path="womensHole10Handicap"/></td>
				<td><form:input maxlength="2" path="womensHole11Handicap"/></td>
				<td><form:input maxlength="2" path="womensHole12Handicap"/></td>
				<td><form:input maxlength="2" path="womensHole13Handicap"/></td>
				<td><form:input maxlength="2" path="womensHole14Handicap"/></td>
				<td><form:input maxlength="2" path="womensHole15Handicap"/></td>
				<td><form:input maxlength="2" path="womensHole16Handicap"/></td>
				<td><form:input maxlength="2" path="womensHole17Handicap"/></td>
				<td><form:input maxlength="2" path="womensHole18Handicap"/></td>
			</tr>
		</table>
	</div>
	<div>
		<carter:label key="course.womensPars"/>
		<table class="coursecard">
			<tr>
				<td><form:input maxlength="1" path="womensHole1Par"/></td>
				<td><form:input maxlength="1" path="womensHole2Par"/></td>
				<td><form:input maxlength="1" path="womensHole3Par"/></td>
				<td><form:input maxlength="1" path="womensHole4Par"/></td>
				<td><form:input maxlength="1" path="womensHole5Par"/></td>
				<td><form:input maxlength="1" path="womensHole6Par"/></td>
				<td><form:input maxlength="1" path="womensHole7Par"/></td>
				<td><form:input maxlength="1" path="womensHole8Par"/></td>
				<td><form:input maxlength="1" path="womensHole9Par"/></td>
				<td><form:input maxlength="1" path="womensHole10Par"/></td>
				<td><form:input maxlength="1" path="womensHole11Par"/></td>
				<td><form:input maxlength="1" path="womensHole12Par"/></td>
				<td><form:input maxlength="1" path="womensHole13Par"/></td>
				<td><form:input maxlength="1" path="womensHole14Par"/></td>
				<td><form:input maxlength="1" path="womensHole15Par"/></td>
				<td><form:input maxlength="1" path="womensHole16Par"/></td>
				<td><form:input maxlength="1" path="womensHole17Par"/></td>
				<td><form:input maxlength="1" path="womensHole18Par"/></td>
			</tr>
		</table>
	</div>
	<div>
		<carter:label key="course.womensYardages"/>
		<table class="coursecard">
			<tr>
				<td><form:input maxlength="3" path="womensHole1Yardage"/></td>
				<td><form:input maxlength="3" path="womensHole2Yardage"/></td>
				<td><form:input maxlength="3" path="womensHole3Yardage"/></td>
				<td><form:input maxlength="3" path="womensHole4Yardage"/></td>
				<td><form:input maxlength="3" path="womensHole5Yardage"/></td>
				<td><form:input maxlength="3" path="womensHole6Yardage"/></td>
				<td><form:input maxlength="3" path="womensHole7Yardage"/></td>
				<td><form:input maxlength="3" path="womensHole8Yardage"/></td>
				<td><form:input maxlength="3" path="womensHole9Yardage"/></td>
				<td><form:input maxlength="3" path="womensHole10Yardage"/></td>
				<td><form:input maxlength="3" path="womensHole11Yardage"/></td>
				<td><form:input maxlength="3" path="womensHole12Yardage"/></td>
				<td><form:input maxlength="3" path="womensHole13Yardage"/></td>
				<td><form:input maxlength="3" path="womensHole14Yardage"/></td>
				<td><form:input maxlength="3" path="womensHole15Yardage"/></td>
				<td><form:input maxlength="3" path="womensHole16Yardage"/></td>
				<td><form:input maxlength="3" path="womensHole17Yardage"/></td>
				<td><form:input maxlength="3" path="womensHole18Yardage"/></td>
			</tr>
		</table>
	</div>
	<input type="submit" class="button" name="save" onclick="bCancel=false" value="<fmt:message key="button.save"/>"/>
</form:form>

<script type="text/javascript">
$("#name").focus();

function onFormSubmit(theForm) {
    selectAll('courseCities');
}
</script>

