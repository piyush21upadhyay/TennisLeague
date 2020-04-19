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
<c:choose>
    <c:when test="${isAdmin}">
    	<form:form commandName="courtListWrapper" method="post" id="courts" action="editCourts.html">
    		<c:forEach var="court" items="${courtListWrapper.courtList}" varStatus="status">
    		<div class="threecol-frame">
    				<p><label for="name"><fmt:message key="courtDetails.name"/></label>
    					<form:input path="courtList[${status.index}].name" id="name" cssClass="longBox" maxlength="30"/></p>
    				<p><label for="courtAddress"><fmt:message key="courtDetails.address"/></label>
    					<form:input path="courtList[${status.index}].courtAddress" id="courtAddress" cssClass="longBox" maxlength="30"/></p>
    				<p><label for="cities"><fmt:message key="courtDetails.city"/></label>
    					<form:input path="courtList[${status.index}].cities[0].name" id="cities" cssClass="longBox" maxlength="30"/></p>
    				<p><label for="courtState"><fmt:message key="courtDetails.state"/></label>
    					<form:input path="courtList[${status.index}].courtState" id="courtState" /></p>
    				 <p><label for="lighted"><fmt:message key="courtDetails.lighted"/></label>
    					<form:input path="courtList[${status.index}].isCourtLighted" id="isCourtLighted" /></p>
    					
    					
    				<%-- <p><label for="noOfCourts"><fmt:message key="courtDetails.noOfCourts"/></label>
    					<form:input path="courtList[${status.index}].numberOfCourts" id="numberOfCourts" /></p>	 --%>
    					
					
					 <label><fmt:message key="userForm.isCourtLighted"/></label>
				 	<form:select path="courtList[${status.index}].isCourtLighted" id="isCourtLighted" cssClass="sixcol">
					 	<option value="No" selected>
					 		<c:out value="${courtList[status.index].isCourtLighted}"/>
					 	</option>
						<option value="no"><fmt:message key="userForm.no"/></option>
						<option value="yes"><fmt:message key="userForm.yes"/></option>
					</form:select> 
					
					<label><fmt:message key="userForm.numberOfCourts"/></label>
					 <form:select path="courtList[${status.index}].numberOfCourts" id="numberOfCourts" cssClass="sixcol">
					 	<option value="courtList[${status.index}].numberOfCourts" selected>
					 		<c:out value="${courtList[status.index].numberOfCourts}"/>
					 	</option>
					 	<c:forEach var="court" items="${numberOfCourts}">
							<option value="<c:out value='${court}'/>" <%-- <c:if test="${court == "courtList[${status.index}].numberOfCourts"}">selected</c:if> --%>>
								 <c:out value="${court}"/>
							</option>
						</c:forEach>
					</form:select>
					
					
					<label><fmt:message key="userForm.hoursOpen"/></label>
				 	<form:select path="courtList[${status.index}].openCourtMeridiem" id="openCourtMeridiem" cssClass="sixcol">
					 	<option value="courtList[${status.index}].openCourtMeridiem" selected>
					 		<c:out value="${courtList[status.index].openCourtMeridiem}"/>
					 	</option>
						<option value="AM"><fmt:message key="userForm.am"/></option>
						<option value="PM"><fmt:message key="userForm.pm"/></option>
					</form:select>
				 <form:select path="courtList[${status.index}].openCourtHour" id="openCourtHour" cssClass="sixcol">
				 	<option value="courtList[${status.index}].openCourtHour" selected>
				 		<c:out value="${courtList[status.index].openCourtHour}"/>
				 	</option>
				 	<c:forEach var="hour" items="${hoursList}">
						<option value="<c:out value='${hour}'/>" >
							<c:out value="${hour}"/>
						</option>
					</c:forEach>
				</form:select>
				
				<label><fmt:message key="userForm.hoursClose"/></label>
				 <form:select path="courtList[${status.index}].closeCourtMeridiem" id="closeCourtMeridiem" cssClass="sixcol">
				 	<option value="courtList[${status.index}].closeCourtMeridiem" selected>
				 		<c:out value="${courtList[status.index].closeCourtMeridiem}"/>
				 	</option>
					<option value="AM"><fmt:message key="userForm.am"/></option>
					<option value="PM"><fmt:message key="userForm.pm"/></option>
				</form:select>
				 <form:select path="courtList[${status.index}].closeCourtHour" id="closeCourtHour" cssClass="sixcol">
				 	<option value="courtList[${status.index}].closeCourtHour" selected>
				 		<c:out value="${courtList[status.index].closeCourtHour}"/>
				 	</option>
				 	<c:forEach var="hour" items="${hoursList}">
						<option value="<c:out value='${hour}'/>" >
							<c:out value="${hour}"/>
						</option>
					</c:forEach>
				</form:select>
					
    				<p><label for="courtVerified"><fmt:message key="courtDetails.verified"/></label>
    					<form:checkbox path="courtList[${status.index}].courtVerified" id="courtVerified"/></p>
    		</div>
    		</c:forEach>
    		 <div class="section">
	    		<div class="buttons">
					<div class="left">
						<carter:button onclick="return onFormSubmit(document.getElementById('courts'));" key="button.save"/>
					</div>
					<div class="left">
						<carter:button onclick="document.getElementById('bCancel').value='true';document.getElementById('courts').submit();return false;" key="button.cancel"/>
					</div>
					<input id="bCancel" type="hidden" name="bCancel" value="false"/>
					<div class="clear"></div>
				</div>
			 </div>
		    <div class="section">
				<spring:bind path="courtListWrapper.*">
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
			</div>
    	</form:form>
    	
    	<script type="text/javascript">
			function onFormSubmit(theForm) { // need to add validations of a form
				return theForm.submit();
			}
		</script>
    
   </c:when>
   <c:otherwise>

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
				<p><fmt:message key="courtDetails.verified"/> <c:out value="${court.courtVerified}"/></p>
			</div>
	</c:forEach>

	</c:otherwise>
</c:choose>

</div>

</c:if>