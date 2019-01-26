<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="registration.title"/></title>
    <content tag="heading"><fmt:message key="registration.heading"/></content>
    <meta name="menu" content="Welcome"/>
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/${appConfig["csstheme"]}/jquery.ui.datepicker.css'/>" />

	<script type="text/javascript">
	$(function() {
		$("#earlyRegistrationStart").datepicker({showOn: 'button', buttonImage: 'images/calendar-icon.jpg', buttonImageOnly: true});
	});
	$(function() {
		$("#regularRegistrationStart").datepicker({showOn: 'button', buttonImage: 'images/calendar-icon.jpg', buttonImageOnly: true});
	});
	$(function() {
		$("#seasonStart").datepicker({showOn: 'button', buttonImage: 'images/calendar-icon.jpg', buttonImageOnly: true});
		var objRegEndElem = $("#registrationEnd");
		var objSeasonElem = $("#seasonStart");
		
		if(objRegEndElem.val() != '')
		{
			curDateStr = trim(objRegEndElem.val());
			dateArr = curDateStr.split("/");
			endRegDate = new Date(dateArr[2],(dateArr[0] - 1),dateArr[1]);
			endRegDate.setDate( endRegDate.getDate() - 1 );
			
			dateStr = endRegDate.getDate();
			monthStr = (endRegDate.getMonth() + 1);
			yearStr = endRegDate.getFullYear();
			
			if(dateStr < 10)
				dateStr = "0" + dateStr;
			if(monthStr < 10)
				monthStr = "0" + monthStr;
			fullDateStr = monthStr + "/" + dateStr + "/" + yearStr;
			objSeasonElem.val(fullDateStr);
		}
			
	});
	
	<c:if test="${empty registration.city}">
	$(function() {
		var objSel = document.getElementById("city.name");
		var cityId = objSel.options[0].value;
		var reqUrl = 'jsonState.html?cityId=' + cityId;
		// Ajax call for getting message contents
		result = reqAjax(reqUrl);
		begin = result.indexOf("response") + 9;
		end = result.lastIndexOf("response") - 2;
		state = trim(result.slice(begin,end));
		document.getElementById("city.state").value = state;
	});
	</c:if>
	</script>
</head>

<spring:bind path="registration.*">
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

<form:form commandName="registration" method="post" action="registrationForm.html" id="registrationForm">
<form:hidden path="id"/>
<form:hidden path="version"/>
<form:hidden path="scheduleState"/>
<ul>
	<c:set var="editFlow" value="${isEditSeasonRequest}"/>
    <% System.out.println("The value of editFlow var is::"+pageContext.findAttribute("editFlow") ); %>
		<input type="hidden" name="editFlowHidden" id="editFlowHidden" value="<%=pageContext.findAttribute("editFlow")%>" />
		<li>
        <carter:label styleClass="desc" key="registration.name"/>
        <form:errors path="displayName" cssClass="fieldError"/>
        <form:input path="displayName" id="displayName" cssClass="text medium" maxlength="50"/>
    </li>
    <li>
        <carter:label styleClass="desc" key="registration.city"/>
        <form:errors path="city" cssClass="fieldError"/>
        <form:select path="city" id="city.name" cssClass="text large" cssStyle="width:115px;" onchange="getStateName(this);">
       		<c:forEach var="city" items="${cityList}">
				<option value="<c:out value='${city.id}'/>"<c:if test="${registration.city.id eq city.id}"> selected="true"</c:if>>
 					<c:out value="${city.name}"/>
				</option>
			</c:forEach>
        </form:select>
        <c:choose>
        	<c:when test="${not empty registration.city}">
        		<input type="text" id="city.state" value="<c:out value="${registration.city.state}"/>" style="display:none;">
        	</c:when>
        	<c:otherwise>
        		<input type="text" id="city.state" value="" style="display:none;">
        	</c:otherwise>
        </c:choose>
    </li>
    <li>
    	<carter:label styleClass="desc" key="registration.earlyRegistrationStart"/>
        <form:errors path="earlyRegistrationStart" cssClass="fieldError" id="earlyRegistrationStart"/>
		<spring:bind path="registration.earlyRegistrationStart">
			<input type="text" id="earlyRegistrationStart" name="earlyRegistrationStart" value="<c:out value="${status.value}"/>" size="12"/>
		</spring:bind>
	</li>
    <li>
    	<carter:label styleClass="desc" key="registration.regularRegistrationStart"/>
        <form:errors path="regularRegistrationStart" cssClass="fieldError" id="regularRegistrationStart"/>
		<spring:bind path="registration.regularRegistrationStart">
			<input type="text" id="regularRegistrationStart" name="regularRegistrationStart" value="<c:out value="${status.value}"/>" size="12"/>
		</spring:bind>
	</li>
    <li>
    	<carter:label styleClass="desc" key="registration.registrationEnd"/>
        <form:errors path="registrationEnd" cssClass="fieldError" id="registrationEnd"/>
		<input type="text" id="seasonStart" value="" size="12"/>
		<spring:bind path="registration.registrationEnd">
			<input type="hidden" id="registrationEnd" name="registrationEnd" value="<c:out value="${status.value}"/>" size="12"/>
		</spring:bind>
	</li>
	<li>
        <carter:label styleClass="desc" key="registration.earlyRegistrationFee"/>($)
        <form:errors path="earlyRegistrationFee" cssClass="fieldError"/>
        <form:input path="earlyRegistrationFee" id="earlyRegistrationFee" cssClass="text medium" maxlength="20"/>
    </li>
    <li>
        <carter:label styleClass="desc" key="registration.regularRegistrationFee"/>($)
        <form:errors path="regularRegistrationFee" cssClass="fieldError"/>
        <form:input path="regularRegistrationFee" id="regularRegistrationFee" cssClass="text medium" maxlength="20"/>
    </li>
    <!-- New changes for registering a season by Piyush/Akash starts-->
    <li>
        <carter:label styleClass="desc" key="registration.secondEventFee"/>($)
        <form:errors path="secondEventFee" cssClass="fieldError"/>
        <form:input path="secondEventFee" id="secondEventFee" cssClass="text medium" maxlength="20"/>
    </li>
    <li>
        <carter:label styleClass="desc" key="registration.thirdEventFee"/>($)
        <form:errors path="thirdEventFee" cssClass="fieldError"/>
        <form:input path="thirdEventFee" id="thirdEventFee" cssClass="text medium" maxlength="20"/>
    </li>
    
    <!-- 
    <%-- below code would remove the fields from the screen at call of edit function--%>
     <c:if test="${empty editFlow}">
    	<li>
        <carter:label styleClass="desc" key="registration.playingPreference"/>
        <form:errors path="playingPreference" cssClass="fieldError"/>
        
			<form:checkbox path="playingPreference" value="Singles" id="singles"/><fmt:message key="userForm.singles"/> 
			<form:checkbox path="playingPreference" value="Doubles" id="doubles"/><fmt:message key="userForm.doubles"/>
			<form:checkbox path="playingPreference" value="Mixed Doubles" id="mixedDoubles"/><fmt:message key="userForm.mixedDoubles"/>
    </li>
    
    
    <li>
        <carter:label styleClass="desc" key="registration.playerLevel"/>
        <form:errors path="playerLevel" cssClass="fieldError"/>
        
      
					<form:checkbox path="playerLevel" value="2.5" id="2_5"/><fmt:message key="userForm.level2_5"/>
					<form:checkbox path="playerLevel" value="3.0" id="3_0"/><fmt:message key="userForm.level3_0"/>
					<form:checkbox path="playerLevel" value="3.5" id="3_5"/><fmt:message key="userForm.level3_5"/>
					<form:checkbox path="playerLevel" value="4.0" id="4_0"/><fmt:message key="userForm.level4_0"/>
					<form:checkbox path="playerLevel" value="4.5" id="4_5"/><fmt:message key="userForm.level4_5"/>
					<form:checkbox path="playerLevel" value="5.0" id="5_0"/><fmt:message key="userForm.level5_0"/>
        
        
    </li>
    <li>
        <carter:label styleClass="desc" key="registration.gender"/>
        <form:errors path="gender" cssClass="fieldError"/>
      
					<form:checkbox path="gender" value="Men's" id="male"/><fmt:message key="userForm.male"/>
					<form:checkbox path="gender" value="Women's" id="female"/><fmt:message key="userForm.female"/>
    </li>
    </c:if>
     -->
     <li>
        <carter:label styleClass="desc" key="registration.playingPreference"/>
        <form:errors path="playingPreference" cssClass="fieldError"/>
		
		<c:set var="editFlow" value="${isEditSeasonRequest}"/>
         <% System.out.println(pageContext.findAttribute("editFlow") ); %>
        
        <c:choose>
			<c:when test="${not empty editFlow and editFlow eq 'true'}">
				<form:checkbox path="playingPreference" value="Singles" id="singles" disabled="true"/><fmt:message key="userForm.singles"/>
				<form:checkbox path="playingPreference" value="Doubles" id="doubles" disabled="true"/><fmt:message key="userForm.doubles"/>
				<form:checkbox path="playingPreference" value="Mixed Doubles" id="mixedDoubles" disabled="true"/><fmt:message key="userForm.mixedDoubles"/>
			</c:when> 
		<c:otherwise>
			<form:checkbox path="playingPreference" value="Singles" id="singles"/><fmt:message key="userForm.singles"/> 
			<form:checkbox path="playingPreference" value="Doubles" id="doubles"/><fmt:message key="userForm.doubles"/>
			<form:checkbox path="playingPreference" value="Mixed Doubles" id="mixedDoubles"/><fmt:message key="userForm.mixedDoubles"/>
		</c:otherwise>
		</c:choose>
		
		
    </li>
    
    
    <li>
        <carter:label styleClass="desc" key="registration.playerLevel"/>
        <form:errors path="playerLevel" cssClass="fieldError"/>
        
        <c:choose>
        	<c:when test="${not empty editFlow and editFlow eq 'true'}">
       				<form:checkbox path="playerLevel" value="2.5" id="2_5" disabled="true"/><fmt:message key="userForm.level2_5"/>
					<form:checkbox path="playerLevel" value="3.0" id="3_0" disabled="true"/><fmt:message key="userForm.level3_0"/>
					<form:checkbox path="playerLevel" value="3.5" id="3_5" disabled="true"/><fmt:message key="userForm.level3_5"/>
					<form:checkbox path="playerLevel" value="4.0" id="4_0" disabled="true"/><fmt:message key="userForm.level4_0"/>
					<form:checkbox path="playerLevel" value="4.5" id="4_5" disabled="true"/><fmt:message key="userForm.level4_5"/>
					<form:checkbox path="playerLevel" value="5.0" id="5_0" disabled="true"/><fmt:message key="userForm.level5_0"/>
        	</c:when>
        	<c:otherwise>
					<form:checkbox path="playerLevel" value="2.5" id="2_5"/><fmt:message key="userForm.level2_5"/>
					<form:checkbox path="playerLevel" value="3.0" id="3_0"/><fmt:message key="userForm.level3_0"/>
					<form:checkbox path="playerLevel" value="3.5" id="3_5"/><fmt:message key="userForm.level3_5"/>
					<form:checkbox path="playerLevel" value="4.0" id="4_0"/><fmt:message key="userForm.level4_0"/>
					<form:checkbox path="playerLevel" value="4.5" id="4_5"/><fmt:message key="userForm.level4_5"/>
					<form:checkbox path="playerLevel" value="5.0" id="5_0"/><fmt:message key="userForm.level5_0"/>
        	</c:otherwise>
        </c:choose>
        
    </li>
    <li>
        <carter:label styleClass="desc" key="registration.gender"/>
        <form:errors path="gender" cssClass="fieldError"/>
        <c:choose>
        	<c:when test="${not empty editFlow and editFlow eq 'true'}">
       				<form:checkbox path="gender" value="Men's" id="male" disabled="true"/><fmt:message key="userForm.male"/>
					<form:checkbox path="gender" value="Women's" id="female" disabled="true"/><fmt:message key="userForm.female"/>
        	</c:when>
        	<c:otherwise>
					<form:checkbox path="gender" value="Men's" id="male"/><fmt:message key="userForm.male"/>
					<form:checkbox path="gender" value="Women's" id="female"/><fmt:message key="userForm.female"/>
        	</c:otherwise>
        </c:choose>
		
    </li>
    <!-- New changes for registering a season by Piyush/Akash ends-->
    <li class="buttonBar bottom">
	    <input type="button" class="button" name="save" onclick="return onFormSubmit(document.getElementById('registrationForm'));" value="<fmt:message key="button.save"/>"/>
	    <input type="button" class="button" name="cancel" onclick="document.getElementById('bCancel').value='true'; document.getElementById('registrationForm').submit(); return false;" value="<fmt:message key="button.cancel"/>"/>
	    <input type="hidden" name="bCancel" id="bCancel" value="false" />
    </li>
</ul>

</form:form>

<h4><fmt:message key="registration.registrants"/></h4>
<display:table name="registrantList" cellspacing="0" cellpadding="0" requestURI="" 
    defaultsort="1" id="registrantList" class="table" export="false">
    <display:column sortable="true" property="user.fullName" titleKey="registration.name" url="/profile.html" paramId="id" paramProperty="id" style="white-space: nowrap" media="html"/>
    <display:setProperty name="paging.banner.item_name"><fmt:message key="registration.member"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="registration.members"/></display:setProperty>
</display:table>

<script type="text/javascript">
$("#displayName").focus();

function onFormSubmit(theForm)
{
	// set hidden field value
	var objRegEnd = $("#registrationEnd");
	var objSeason = $("#seasonStart");
	
	if(objSeason.val() != '')
	{
		curDateStr = trim(objSeason.val());
		dateArr = curDateStr.split("/");
		endRegDate = new Date(dateArr[2],(dateArr[0] - 1),dateArr[1]);
		endRegDate.setDate( endRegDate.getDate() + 1 );
		dateStr = endRegDate.getDate();
		monthStr = (endRegDate.getMonth() + 1);
		yearStr = endRegDate.getFullYear();
		
		if(dateStr < 10)
			dateStr = "0" + dateStr;
		if(monthStr < 10)
			monthStr = "0" + monthStr;
		fullDateStr = monthStr + "/" + dateStr + "/" + yearStr;
		objRegEnd.val(fullDateStr);
	}
	/**Added by Piyush and Akash as to get the value of a disbaled attribute/readonly could have worked too but getting error saying 
		"Attribute readonly invalid for tag checkbox according to TLD", so remove the disabled attribute when submitting the form***/
		enableChekboxesBeforeSubmit();
	/*****/
	
	if(validateRegistration(theForm))
	{
		document.getElementById('bCancel').value='false';
		return theForm.submit();
	}
	return false;
}

function getStateName(selectObj)
{
	cityId = selectObj.options[selectObj.selectedIndex].value;
	var state = "";
	
	if(cityId != '')
	{
		var reqUrl = 'jsonState.html?cityId=' + cityId;
		
		// Ajax call for getting message contents
		result = reqAjax(reqUrl);
		
		begin = result.indexOf("response") + 9;
		end = result.lastIndexOf("response") - 2;
		state = trim(result.slice(begin,end));
		document.getElementById("city.state").value = state;
	}
}

function reqAjax( pURL )
{
	var vResult = $.ajax({
		url: pURL,
		cache: false,
		async: false
	}).responseText;

   return vResult;
}

//Trim whitespace from left and right sides of s.
function trim(s) 
{
    return s.replace( /^\s*/, "" ).replace( /\s*$/, "" );
}

function enableChekboxesBeforeSubmit(){
	$("#singles").removeAttr("disabled");
	$("#doubles").removeAttr("disabled");
	$("#mixedDoubles").removeAttr("disabled");
	
	$("#2_5").removeAttr("disabled");
	$("#3_0").removeAttr("disabled");
	$("#3_5").removeAttr("disabled");
	$("#4_0").removeAttr("disabled");
	$("#4_5").removeAttr("disabled");
	$("#5_0").removeAttr("disabled");
	
	$("#male").removeAttr("disabled");
	$("#female").removeAttr("disabled");
}
</script>

<v:javascript formName="registration" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script>

