<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="city.title"/></title>
    <content tag="heading"><fmt:message key="cityManage.heading"/></content>
    <meta name="menu" content="Welcome"/>
    
    <script type="text/javascript">
	$(function() 
	{
		<c:choose>
			<c:when test="${not empty cityName}">
				$("#header").html("<c:out value='${cityName.fullCityName}'/>");
			</c:when>
		</c:choose>
	});
	</script>
</head>

<div id="registerCity">
	<c:if test="${not empty errorMessage}">
	<div class="errors">
		<img src="<c:url value="/images/iconWarning.gif"/>" alt="<fmt:message key="icon.warning"/>" class="icon"/>
		<c:out value="${errorMessage}" />
	</div>
	</c:if>
	<form:form commandName="city" method="post" action="registrationCity.html" onsubmit="return onFormSubmit(this);" id="registrationCity">
		<form:hidden path="id"/>
		<form:hidden path="version"/>
		<form:hidden path="countDownDate"/>
	
		<table cellpadding="3" border="0">
		    <tr>
		    	<td><carter:label styleClass="desc" key="city.name"/></td>
		        <td><form:input path="name" id="name" cssClass="text medium" /></td>
		    </tr>
		    <tr>
		        <td><carter:label styleClass="desc" key="city.state"/></td>
		        <td><form:input path="state" id="state" cssClass="text medium" /></td>
		    </tr>
		    <tr>
		        <td><carter:label styleClass="desc" key="city.inactiveMessage"/></td>
		        <td><form:input path="inactiveMessage" id="inactiveMessage" cssClass="text medium" /></td>
			</tr>
		    <tr>
		        <td><carter:label styleClass="desc" key="city.countDownMessage"/></td>
		        <td><form:input path="countDownMessage" id="countDownMessage" cssClass="text medium" /></td>
			</tr>
			<%-- <tr>
		        <td><carter:label styleClass="desc" key="city.tickerMessage"/></td>
		        <td>
		        <c:set var="counter" value="0"/>
		        <c:forEach var="msg" items="${city.tickerMessages}" varStatus="status">
		        	<c:set var="counter" value="${counter + 1}"/>
		        	<input type="text" name="message<c:out value='${counter}' />" value="<c:out value='${msg.message}' />" class="text large" />
		        	<input type="hidden" name="messageId<c:out value='${counter}' />" value="<c:out value='${msg.id}' />"/>
		        	<br/>
		        </c:forEach>
		        </td>
			</tr>
			--%>
			<tr>
		        <td><carter:label styleClass="desc" key="city.active"/></td>
		        <td><form:checkbox path="active" id="active"/></td>
			</tr>
		    <tr>
		    	<td colspan="2" style="padding:5px 10px;">
			    	<div class="buttons">
			    		<div class="left">
					    	<carter:button onclick="return onFormSubmit(document.getElementById('registrationCity'));" key="button.save"/>
					    </div>
					    <div class="left">
					    	<carter:button onclick="document.getElementById('bCancel').value='true';document.getElementById('registrationCity').submit();return false;" key="button.cancel"/>
					    </div>
					    <c:if test="${not empty currentCity}">
					    	<carter:button onclick="document.getElementById('bDelete').value='true';document.getElementById('registrationCity').submit();return false;" key="button.delete"/>
					    </c:if>
					</div>
					<div class="clear"></div>
				    <div class="mandatory">
						<span class="asterisk">*</span> <fmt:message key="city.mandatory"/>
					</div>
					<input id="bCancel" type="hidden" name="bCancel" value="false"/>
					<input id="bDelete" type="hidden" name="bDelete" value="false"/>
			    </td>
		    </tr>
		</table>
	
	</form:form>
</div>

<script type="text/javascript">
	$("#name").focus();

	function onFormSubmit(theForm) 
	{
		if(validateCity(theForm))
		{
			return theForm.submit();
		}
		return false;
	}
</script>

<v:javascript formName="city" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script>
