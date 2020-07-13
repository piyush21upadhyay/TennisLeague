<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="courts.title"/></title>
    <meta name="menu" content="Courts"/>
</head>

<c:if test="${empty errors and empty successMessages}">

<div class="section">
	<h2 class="page-title"><fmt:message key="courts.title"/></h2>
</div>

<div class="court-section col-sm-12">
<c:choose>
    <c:when test="${isAdmin}">
    	<form:form commandName="courtListWrapper" method="post" id="courts" action="editCourts.html">
		<div class="row">
    		<c:forEach var="court" items="${courtListWrapper.courtList}" varStatus="status">
    		<div class="threecol-frame col-sm-4">
			    <div class="shadow-sm grey-box">
    				<p><label for="name"><fmt:message key="courtDetails.name"/></label>
    					<form:input path="courtList[${status.index}].name" id="name" cssClass="longBox" maxlength="30"/></p>
    				<p><label for="courtAddress"><fmt:message key="courtDetails.address"/></label>
    					<form:input path="courtList[${status.index}].courtAddress" id="courtAddress" cssClass="longBox" maxlength="30"/></p>
    				<p><label for="cities"><fmt:message key="courtDetails.city"/></label>
    					<form:input path="courtList[${status.index}].courtCity" id="cities" cssClass="longBox" maxlength="30"/></p>
    					
    				<p><label for="courtState"><fmt:message key="courtDetails.state"/></label>	
					<form:select path="courtList[${status.index}].courtState" id="courtState" cssClass="sixcol">
					 	<c:forEach var="state" items="${stateList}">
							<option value="<c:out value='${state}'/>" <c:if test="${state == courtList[status.index].courtState}">selected</c:if>>
								 <c:out value="${state}"/>
							</option>
						</c:forEach>
					</form:select></p>
					
					
					 <p><label><fmt:message key="userForm.isCourtLighted"/></label>
				 	<form:select path="courtList[${status.index}].isCourtLighted" id="isCourtLighted" cssClass="sixcol">
						<option value="no" <c:if test="${courtList[status.index].isCourtLighted == 'no'}">selected</c:if>><fmt:message key="userForm.no"/></option>
						<option value="yes" <c:if test="${courtList[status.index].isCourtLighted == 'yes'}">selected</c:if>><fmt:message key="userForm.yes"/></option>
					</form:select> </p>
					
					<p><label><fmt:message key="userForm.numberOfCourts"/></label>
					 <form:select path="courtList[${status.index}].numberOfCourts" id="numberOfCourts" cssClass="sixcol">
					 	<c:forEach var="court" items="${numberOfCourts}">
							<option value="<c:out value='${court}'/>" <c:if test="${court == courtList[status.index].numberOfCourts}">selected</c:if>>
								 <c:out value="${court}"/>
							</option>
						</c:forEach>
					</form:select></p>
					
					
					<p><label><fmt:message key="userForm.hoursOpen"/></label>
				 	<form:select path="courtList[${status.index}].openCourtMeridiem" id="openCourtMeridiem" cssClass="sixcol">
						<option value="AM" <c:if test="${courtList[status.index].openCourtMeridiem == 'AM'}">selected</c:if>><fmt:message key="userForm.am"/></option>
						<option value="PM" <c:if test="${courtList[status.index].openCourtMeridiem == 'PM'}">selected</c:if>><fmt:message key="userForm.pm"/></option>
					</form:select>
					 <form:select path="courtList[${status.index}].openCourtHour" id="openCourtHour" cssClass="sixcol">
					 	<c:forEach var="hour" items="${hoursList}">
							<option value="<c:out value='${hour}'/>" <c:if test="${hour == courtList[status.index].openCourtHour}">selected</c:if>>
								<c:out value="${hour}"/>
							</option>
						</c:forEach>
					</form:select></p>
				
				<p><label><fmt:message key="userForm.hoursClose"/></label>
				 <form:select path="courtList[${status.index}].closeCourtMeridiem" id="closeCourtMeridiem" cssClass="sixcol">
					<option value="AM" <c:if test="${courtList[status.index].closeCourtMeridiem == 'AM'}">selected</c:if>><fmt:message key="userForm.am"/></option>
					<option value="PM" <c:if test="${courtList[status.index].closeCourtMeridiem == 'PM'}">selected</c:if>><fmt:message key="userForm.pm"/></option>
				</form:select>
				 <form:select path="courtList[${status.index}].closeCourtHour" id="closeCourtHour" cssClass="sixcol">
				 	<c:forEach var="hour" items="${hoursList}">
						<option value="<c:out value='${hour}'/>" <c:if test="${hour == courtList[status.index].closeCourtHour}">selected</c:if>>
							<c:out value="${hour}"/>
						</option>
					</c:forEach>
				</form:select></p>
					
    				<p><label for="courtVerified"><fmt:message key="courtDetails.verified"/></label>
    					<form:checkbox path="courtList[${status.index}].courtVerified" id="courtVerified"/></p>
    		</div>
			</div>
    		</c:forEach>
			</div>
    		 <div class="section">
	    		<div class="buttons">
					<div class="left submit-btn">
						<carter:button onclick="return onFormSubmit(document.getElementById('courts'));" key="button.save"/>
					</div>
					<div class="left cancel-btn">
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
    	</div>
    	<script type="text/javascript">
			function onFormSubmit(theForm) { // need to add validations of a form
				return theForm.submit();
			}
		</script>
    
   </c:when>
   <c:otherwise>
   		<c:choose>
   			<c:when test="${not empty courtList}">
   				<c:forEach var="court" items="${courtList}">
					<div class="threecol-frame col-sm-4">
					 <div class="shadow-sm grey-box">
						<h2><c:out value="${court.name}"/></h2>
						<p><fmt:message key="courtDetails.address"/> <c:out value="${court.courtAddress}"/><br/></p>
						<p><fmt:message key="courtDetails.city"/><c:out value="${court.courtCity}"/></p>
						<p><fmt:message key="courtDetails.state"/> <c:out value="${court.courtState}"/></p>
						<p><fmt:message key="courtDetails.noOfCourts"/> <c:out value="${court.numberOfCourts}"/></p>
						<p><fmt:message key="courtDetails.lighted"/> <c:out value="${court.isCourtLighted}"/></p>
						<p><fmt:message key="courtDetails.hours"/> <c:out value="${court.openCourtHour}"/> <c:out value="${court.openCourtMeridiem}"/>-<c:out value="${court.closeCourtHour}"/><c:out value="${court.closeCourtMeridiem}"/></p>
					</div>
					</div>
			</c:forEach>
   			</c:when>
   			<c:otherwise>
	   			<c:forEach begin="1" end="9" varStatus="loop">
	   			<div class="row">
	   				<div class="threecol-frame col-sm-4">
						 <div class="shadow-sm grey-box">
							<p><fmt:message key="courtDetails.address"/><c:out value="Piyush"/> <br/></p>
							<p><fmt:message key="courtDetails.city"/></p>
							<p><fmt:message key="courtDetails.state"/></p>
							<p><fmt:message key="courtDetails.noOfCourts"/></p>
							<p><fmt:message key="courtDetails.lighted"/></p>
							<p><fmt:message key="courtDetails.hours"/></p>
						</div>
					</div>
				</div>
				</c:forEach>
   			</c:otherwise>
   		</c:choose>
	</c:otherwise>
</c:choose>
</div>
</c:if>