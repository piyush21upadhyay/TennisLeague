<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="userForm.title"/></title>
	<content tag="heading"><fmt:message key="userForm.heading"/></content>
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>

<%-- <c:if test="${not empty courseList}"> --%>

<div class="section">
	<div class="left">
		<h2 class="page-title"><fmt:message key="userForm.title"/> <span><fmt:message key="userForm.heading"/></span></h2>
	</div>
	<!--div class="right">
		<fmt:message key="userForm.message"/>
	</div-->
</div>
<div class="clear"></div>
<div class="shadow-sm grey-box editerForm">
<form:form commandName="user" method="post" id="edituser">
<div class="edituser-section">
	<form:hidden path="id"/>
	<form:hidden path="version"/>
	<form:hidden path="registeredCity"/>
	<form:hidden path="firstSeason"/>
	<form:hidden path="dateJoined"/>
	<form:hidden path="lastLogin"/>
	<%--<form:hidden path="referral" id="referralInfo"/> --%>
	<form:hidden path="currentSeason"/>
	<form:hidden path="currentWins"/>
	<form:hidden path="currentLosses"/>
	<form:hidden path="currentTies"/>
	<form:hidden path="totalWins"/>
	<form:hidden path="totalLosses"/>
	<form:hidden path="totalTies"/>
	<form:hidden path="bestResult"/>
	<form:hidden path="bestResultSeason"/>
	<form:hidden path="lowScore"/>
	<form:hidden path="seasonEntered"/>
	<%-- <form:hidden path="playerLevel"/> --%>
	<c:if test="${cookieLogin == 'true'}">
		<form:hidden path="password"/>
		<form:hidden path="confirmPassword"/>
	</c:if>
	<div class="row">
	<!--first section-->
	<div class="col-sm-12 col-lg-3">
     <fieldset>  
			<legend><fmt:message key="userForm.accountinfo"/></legend>
			<div class="floating-label-wrap">
				<form:input path="username" id="username" cssClass="longBox floating-label-field floating-label-field--s3" maxlength="30"/>
				<label for="username" class="floating-label"><fmt:message key="userForm.username"/><span class="mandatory">*</span></label>
			</div>
			<div class="floating-label-wrap">
			<form:password path="password" id="password" cssClass="longBox floating-label-field floating-label-field--s3" maxlength="30"/>
			<label class="floating-label" for="password"><fmt:message key="userForm.password"/><span class="mandatory">*</span></label>
			</div>
			<div class="floating-label-wrap">
			<form:password path="confirmPassword" id="confirmPassword" cssClass="longBox floating-label-field floating-label-field--s3" maxlength="30"/>
			<label class="floating-label" for="confirmPassword"><fmt:message key="userForm.confirmpassword"/><span class="mandatory">*</span></label>
			</div>
			<div class="floating-label-wrap">
			<form:input path="passwordHint" id="passwordHint" cssClass="longBox floating-label-field floating-label-field--s3" maxlength="30"/> 
			<label class="floating-label" for="passwordHint"><fmt:message key="userForm.passwordhint"/><span class="mandatory">*</span></label>
			</div>
			<div class="floating-label-wrap">
			<form:input path="email" id="email" cssClass="longBox floating-label-field floating-label-field--s3" maxlength="30"/>
			<label class="floating-label" for="email"><fmt:message key="userForm.email"/><span class="mandatory">*</span></label>
			</div>
			<div class="styled-input">
			<label for="playerLevel"><fmt:message key="userForm.playerLevel"/></label>
			 <form:select path="playerLevel" id="playerLevel" cssClass="preferredPhone">
				<form:option value="2.5"><fmt:message key="userForm.level2_5"/></form:option>
				<form:option value="3.0"><fmt:message key="userForm.level3_0"/></form:option>
				<form:option value="3.5"><fmt:message key="userForm.level3_5"/></form:option>
				<form:option value="4.0"><fmt:message key="userForm.level4_0"/></form:option>
				<form:option value="4.5"><fmt:message key="userForm.level4_5"/></form:option>
				<form:option value="5.0"><fmt:message key="userForm.level5_0"/></form:option>
			</form:select> 
			</div>
			<div class="styled-input">
			<label for="ratedBy"><fmt:message key="userForm.ratedBy"/></label>
			<form:select path="ratedBy" id="ratedBy" cssClass="preferredPhone">
				<form:option value="USTA Rated"><fmt:message key="userForm.ustaRated"/></form:option>
				<form:option value="Self"><fmt:message key="userForm.selfRated"/></form:option>
			</form:select>	
			</div>
			<div class="clear"></div>
	</fieldset>
</div>
 	<!-- end first section-->
      <!--second section--> 
      <div class="col-sm-12 col-lg-3">
	<fieldset>
		<legend><fmt:message key="userForm.personalinfo"/></legend>
		<div class="floating-label-wrap">
		<form:input path="firstName" id="firstName" cssClass="longBox floating-label-field floating-label-field--s3" maxlength="50"/> 
		<label for="firstName" class="floating-label"><fmt:message key="userForm.firstname"/><span class="mandatory">*</span></label>
		</div>
	<div class="floating-label-wrap">
		<form:input path="lastName" id="lastName" cssClass="longBox floating-label-field floating-label-field--s3" maxlength="50"/> 
			<label for="lastName" class="floating-label"><fmt:message key="userForm.lastname"/><span class="mandatory">*</span></label>
		</div>
		<div class="floating-label-wrap">
		<form:input path="homePhone" id="homePhone" cssClass="longBox floating-label-field floating-label-field--s3" maxlength="30"/>
		<label for="homePhone" class="floating-label"><fmt:message key="userForm.homephone"/></label> 
		</div>
		<div class="floating-label-wrap">
		<form:input path="cellPhone" id="cellPhone" cssClass="longBox floating-label-field floating-label-field--s3" maxlength="30"/>
			<label for="cellPhone" class="floating-label"><fmt:message key="userForm.cellphone"/></label>
		
		</div>
		
		<div class="styled-input">
		<label for="preferredPhone" class="anchor"><fmt:message key="userForm.preferredphone"/></label>
		<form:select path="preferredPhone" id="preferredPhone" cssClass="preferredPhone">
			<form:option value="1"><fmt:message key="userForm.homephone"/></form:option>
			<form:option value="2"><fmt:message key="userForm.cellphone"/></form:option>
		</form:select>
		
		</div>
		<div class="checkbox-dropdown floating-label-wrap">
		  	<label><fmt:message key="userForm.sex"/></label>
		  <ul class="checkbox-dropdown-list">
		   <li>
				<form:radiobutton path="male" value="true" id="male" /> 
					<label class="radiolabel" for="male"><fmt:message key="userForm.male"/></label>
				</li>
				<li>
				<form:radiobutton path="male" value="false" id="female"/> <label class="radiolabel" for="female"><fmt:message key="userForm.female"/></label>
				</li>
		  </ul>
		</div>
		
		<div class="styled-input">
		<label><fmt:message key="userForm.plays"/></label>
		<form:select path="plays" id="plays" cssClass="preferredPhone">
			<form:option value="Right Handed"><fmt:message key="userForm.rightHandedPlay"/></form:option>
			<form:option value="Left Handed"><fmt:message key="userForm.leftHandedPlay"/></form:option>
		</form:select>
		
		</div>
		<div style="clear:both"></div>
		<div class="checkbox-dropdown floating-label-wrap">
  		<label  class="anchor1"><fmt:message key="userForm.playingPreference"/><span class="mandatory">*</span></label>
		  <ul class="checkbox-dropdown-list">
		   <li><form:checkbox path="playingPreference" value="Singles" id="singles"/>
			<label class="checkboxlabel"><fmt:message key="userForm.singles"/></label>
			</li>
			<li>
			<form:checkbox path="playingPreference" value="Doubles" id="doubles"/>
			<label class="checkboxlabel"><fmt:message key="userForm.doubles"/></label>
			</li>
			<li>
			<form:checkbox path="playingPreference" value="Mixeddoubles" id="mixedDoubles"/>
			<label class="checkboxlabel"><fmt:message key="userForm.mixedDoubles"/></label>
			</li>  
		  </ul>
	</div>


			<div class="styled-input">
			 <label><fmt:message key="userForm.openToChallenges"/></label>
		 <form:select path="openToChallenges" id="openToChallenges" cssClass="openToChallenges" onchange="showOppSkillLevelOptions()">
			<form:option value="no"><fmt:message key="userForm.no"/></form:option>
			<form:option value="yes"><fmt:message key="userForm.yes"/></form:option>
		</form:select>
		</div>
		<div class="styled-input">				
	     <label><fmt:message key="userForm.onlyOpenToSameGender"/></label>
		 <form:select path="onlyOpenToSameGender" id="onlyOpenToSameGender" cssClass="onlyOpenToSameGender">
			<form:option value="yes"><fmt:message key="userForm.yes"/></form:option>
			<form:option value="no"><fmt:message key="userForm.no"/></form:option>
		</form:select>
		</div>
			<div id="opponentSkillLevelDiv">
			<input type="checkbox" name="checkdrop" value="dropdown1" /> <label for="opponentSkillLevel"><fmt:message key="userForm.opponentSkillLevel"/><span class="mandatory">*</span></label> 
				<div class="dropdown" >
				<ul class="category_filters" id="dropdown1" >
				<li><form:radiobutton path="opponentSkillLevel" value="onlyMyRating" /> <label class="radiolabel" for="userForm.skillLevel1"><fmt:message key="userForm.skillLevel1"/></label></li>
				<li><form:radiobutton path="opponentSkillLevel" value="within0.5Rating"/> <label class="radiolabel" for="userForm.skillLevel2"><fmt:message key="userForm.skillLevel2"/></label></li>
				<li><form:radiobutton path="opponentSkillLevel" value="anyRating"/> <label class="radiolabel" for="userForm.skillLevel3"><fmt:message key="userForm.skillLevel3"/></label></li>
		        <li><form:radiobutton path="opponentSkillLevel" value="onlyPlayUp"/> <label class="radiolabel" for="userForm.skillLevel4"><fmt:message key="userForm.skillLevel4"/></label></li>
				</ul>
				</div>
			</div>
	</fieldset>

		
	</div> 
	  <!--end second section-->
      <!--third section-->
        <div class="col-sm-12 col-lg-3">
		<fieldset>
			<legend><fmt:message key="userForm.address"/></legend>
			<div class="floating-label-wrap">
			<form:input path="address.address" id="address.address" cssClass="longBox floating-label-field floating-label-field--s3" maxlength="30"/> 
			<label for="address.address" class="floating-label"><fmt:message key="userForm.line1"/><span class="mandatory">*</span></label>
					
			</div>
			<div class="floating-label-wrap">
			<form:input path="address.city" id="address.city" cssClass="longBox floating-label-field floating-label-field--s3" maxlength="30"/> 
			<label for="address.city" class="floating-label"><fmt:message key="userForm.city"/><span class="mandatory">*</span></label>
				
			</div>
			<div class="styled-input">
			<label for="address.province"><fmt:message key="userForm.state"/><span class="mandatory">*</span></label>
			<carter:state name="address.province" prompt="" default="${user.address.province}"/>
			</div>
			<div class="floating-label-wrap">
			<form:input path="address.postalCode" id="address.postalCode" cssClass="longBox floating-label-field floating-label-field--s3" maxlength="10"/>
			<label for="address.postalCode" class="floating-label"><fmt:message key="userForm.zip"/><span class="mandatory">*</span></label>
				
			</div>
			<div class="styled-input">
			<label for="address.country"><fmt:message key="userForm.country"/></label>
            <carter:country name="address.country" prompt="" default="${user.address.country}"/>		
			</div>
            
            <!-- <label>Date</label>
            <input type="date" id="todayDate" /> -->
			<div class="styled-input">
			<label for="dateJoined"><fmt:message key="userForm.joiningDate"/></label>  
            <form:input path="dateJoined" id="todayDate" />	
			</div>
		</fieldset>
	</div>
      <!--end thrid section-->
      <!--fourth section-->
      <div class="edituser-section col-sm-12 col-lg-3">

		<fieldset>
			<legend><fmt:message key="userForm.courtSelection"/></legend>
			<div class="floating-label-wrap">
				<form:input path="homeCourtText" id="homeCourtText" cssClass="longBox floating-label-field floating-label-field--s3" maxlength="30"/>
				<label for="homeCourtText" class="floating-label"><fmt:message key="userForm.homeCourt"/><span class="mandatory">*</span></label>
				</div>
			<div class="floating-label-wrap">

				<form:input path="courtAddress" id="courtAddress" cssClass="longBox floating-label-field floating-label-field--s3" maxlength="30"/>
					<label for="courtAddress" class="floating-label"><fmt:message key="userForm.courtAddress"/><span class="mandatory">*</span></label>
			</div>
			
			<div class="floating-label-wrap">	
			
			<form:input path="courtCity" id="courtCity" cssClass="longBox floating-label-field floating-label-field--s3" maxlength="30"/> 
			<label for="courtCity" class="floating-label"><fmt:message key="userForm.city"/><span class="mandatory">*</span></label>
			</div>
				
			<div class="styled-input">
			<label for="courtState"><fmt:message key="userForm.state"/><span class="mandatory">*</span></label>
			<carter:state name="courtState" prompt="" default="${user.address.province}"/>
			</div>
			
		</fieldset>
		<fieldset class="equip">    
            <!--label><span class="mandatory">*</span>all mandatory except equipment</label-->
            <legend for="equipment"><fmt:message key="userForm.equipment"/></legend>
			
			<div class="floating-label-wrap">
			<form:input path="racquet" id="racquet" cssClass="longBox floating-label-field floating-label-field--s3" maxlength="30"/> 
			      <label for="racquet" class="floating-label"><fmt:message key="userForm.racquet"/></label>
			 </div>
			
			<div class="floating-label-wrap">
			<form:input path="tennisString" id="tennisString" cssClass="longBox floating-label-field floating-label-field--s3" maxlength="30"/> 
			<label for="tennisString" class="floating-label"><fmt:message key="userForm.string"/></label>
			</div>
			<div class="floating-label-wrap">
			<form:input path="shoes" id="shoes" cssClass="longBox floating-label-field floating-label-field--s3" maxlength="30"/>
			<label for="shoes" class="floating-label"><fmt:message key="userForm.shoes"/></label>
			</div> 
		</fieldset>
		
				<fieldset class="other-info">
			<legend><fmt:message key="userForm.otherInformation"/></legend>
			
			<div class="styled-input">
			<label for="referral"><fmt:message key="userForm.howfound"/></label>
			<form:select path="referral" id="referral">
				<option value=''><fmt:message key="userForm.defaultOptionText"/></option>
				<c:forEach var="referral" items="${referrals}">
					<option value="<c:out value='${referral}'/>" <c:if test="${referral == user.referral}">selected</c:if>>
						<c:out value="${referral}"/>
					</option>
				</c:forEach>
			</form:select>
			</div>
		</fieldset>
	<!--fourth-->

</div>
      
      <!--end fourth section-->
</div>
<div class="section signup-section ">
	<fieldset>
		<legend><fmt:message key="userForm.appearance"/><label for="firsticon">(<fmt:message key="userForm.icon"/>)</label></legend>
		
		<div class="signup-icon">
			<div><img src="images/icon-1.png" alt="ballHoppers"/></div>
			<div class="icon-input"><form:radiobutton path="icon" value="images/BallHoppers.gif" id="firsticon"/></div>
		</div>
		<div class="signup-icon">
			<div><img src="images/icon-2.png" alt="singlesRacquet" /></div>
			<div class="icon-input"><form:radiobutton path="icon" value="images/SinglesRacquet.gif"/></div>
		</div>
		<div class="signup-icon">
			<div><img src="images/icon-3.png" alt="tennisBall" /></div>
			<div class="icon-input"><form:radiobutton path="icon" value="images/TennisBall.gif"/></div>
		</div>
		<div class="signup-icon">
			<div><img src="images/icon-4.png" alt="racquets" /></div>
			<div class="icon-input"><form:radiobutton path="icon" value="images/Racquets.gif"/></div>
		</div>
		<div class="signup-icon">
			<div><img src="images/icon-5.png" alt="footwear" /></div>
			<div class="icon-input"><form:radiobutton path="icon" value="images/Footwear.gif"/></div>
		</div>
		
		<c:if test="${(isAdministrator) && userId ne adminId }">
		<div class="signup-icon">
			<div><img src="images/icon-6.png" alt="trophy" width="40" height="40"/></div>
			<div class="icon-input"><form:radiobutton path="icon" value="images/icon-7.png"/></div>
		</div>
		</c:if>
	</fieldset>
</div>

<c:choose>
    <c:when test="${isAdministrator}">
		<div class="section">
	    	<div class="threecolww">
	        <fieldset>
	            <legend><fmt:message key="userForm.accountSettings"/></legend>
	            <label for="enabled" class="choice"><fmt:message key="user.enabled"/></label>
	            <form:checkbox path="enabled" id="enabled"/>
	
	            <label for="accountExpired" class="choice"><fmt:message key="userForm.accountExpired"/></label>
	            <form:checkbox path="accountExpired" id="accountExpired"/>
	
	            <label for="accountLocked" class="choice"><fmt:message key="userForm.accountLocked"/></label>
	            <form:checkbox path="accountLocked" id="accountLocked"/>
	
	            <label for="credentialsExpired" class="choice"><fmt:message key="userForm.credentialsExpired"/></label>
	            <form:checkbox path="credentialsExpired" id="credentialsExpired"/>
	        </fieldset>
	        </div>
	        <div class="threecolww">
		        <fieldset class="pickList">
		            <legend><fmt:message key="userForm.assignRoles"/></legend>
		            <div>
		            	<div class="pick-available">
		                    <carter:label key="userForm.availableRoles" colon="false" styleClass="required"/>
		               	</div>
		               	<div class="pick-buttons">&nbsp;</div>
		               	<div class="pick-selected">
	                        <carter:label key="userForm.userRoles" colon="false" styleClass="required"/>
		               	</div>
		               	<div class="clear"></div>
		                <c:set var="leftList" value="${availableRoles}" scope="request"/>
		                <c:set var="rightList" value="${user.roleList}" scope="request"/>
		                <c:import url="/common/pickList.jsp">
		                    <c:param name="listCount" value="1"/>
		                    <c:param name="leftId" value="availableRoles"/>
		                    <c:param name="rightId" value="userRoles"/>
		                </c:import>
		               	<div class="clear"></div>
			        </div>
		        </fieldset>
	        </div>
		</div>
	    <div class="clear"></div>
    </c:when>
    <c:when test="${not empty user.username}">
		<div class="section">
	        <c:forEach var="role" items="${user.roleList}" varStatus="status">
	            <input type="hidden" name="userRoles" value="<c:out value="${role.label}"/>"/>
	        </c:forEach>
	        <form:hidden path="enabled"/>
	        <form:hidden path="accountExpired"/>
	        <form:hidden path="accountLocked"/>
	        <form:hidden path="credentialsExpired"/>
		</div>
    </c:when>
</c:choose>

<div class="section">   
	<div class="buttons">
		<div class="right green-btn">
			<carter:button onclick="return onFormSubmit(document.getElementById('edituser'));" key="button.save"/>
		</div>
		<div class="right white-btn">
			<carter:button onclick="document.getElementById('bCancel').value='true';document.getElementById('edituser').submit();return false;" key="button.cancel"/>
		</div>
		<c:if test="${(isAdministrator || isUser) && (not empty user.enabled and user.enabled)}">
		<div class="left">
			<carter:button onclick="cglConfirm('Delete user', 'Are you sure you want to delete your account?', 300, callbackResponse);" key="button.delete"/>
		</div>
		</c:if>
		<input id="bCancel" type="hidden" name="bCancel" value="false"/>
		<input id="bDelete" type="hidden" name="bDelete" value="false"/>
		<div class="clear"></div>
	</div>
	<div class="mandatory">
		<span class="asterisk">*</span> <span class="mandatory-msg"><fmt:message key="userForm.mandatory"/></span>
	</div>
</div>


<div class="section">
	<spring:bind path="user.*">
		<c:if test="${not empty status.errorMessages}">
			<div class="error">    
				<c:forEach var="error" items="${status.errorMessages}">
					<img src="<c:url value="/images/iconWarning.gif"/>" alt="<fmt:message key="icon.warning"/>" class="icon" />
					<c:out value="${error}" escapeXml="false"/><br />
				</c:forEach>
			</div>
		</c:if>
	</spring:bind>
</div>
</form:form>
</div>
<script type="text/javascript">

$(function(){
	$("#username").focus();
	jqFormatPhone($("#homePhone"));
	jqFormatPhone($("#cellPhone"));
	
	$("#homePhone").blur(function(){
		jqFormatPhone($(this));
	});
	
	$("#cellPhone").blur(function(){
		jqFormatPhone($(this));
	});
});
/*added by preety*/



/*ended by preety*/

/* This is here so we can exclude the selectAll call when roles is hidden  */
function onFormSubmit(theForm) {
<c:if test="${isAdministrator}">
    selectAll('userRoles');
</c:if>
	if(validateUser(theForm))
	{
		ajaxRes = validateDuplicateEmail();
		
		if(ajaxRes == 'true')
		{
			var txt = "The email <i>" + $("#email").val() + "</i> is already being used by someone else.";
			cglAlert('Invalid Action', txt, 300);
			return false;
		}
		
		ajaxRes = ajaxRes && validateDuplicateUsername();
		if(ajaxRes == 'true')
		{
			var txt = "The username <i>" + $("#username").val() + "</i> is already being used by someone else.";
			cglAlert('Invalid Action', txt, 300);
			return false;
		}
		return theForm.submit();
	}
	
    return false;
}

function validateDuplicateEmail() 
{
	var email = $("#email").val();
	var userId = $("#id").val();
	var result = "";
	var boolValue = false;
	if(email != '')
	{
		var reqUrl = 'emailValidate.html?id=' + userId + '&email=' + email;
		// Ajax call for getting message contents
		result = reqAjax(reqUrl);
		
		begin = result.indexOf("response") + 9;
		end = result.lastIndexOf("response") - 2;
		boolValue = result.slice(begin,end); 
	}
	return trim(boolValue);
}

function validateDuplicateUsername()
{
	var username = $("#username").val();
	var userId = $("#id").val();
	var result = "";
	var boolValue = false;
	if(username != '')
	{
		var reqUrl = 'emailValidate.html?id=' + userId + '&username=' + username;
		// Ajax call for getting message contents
		result = reqAjax(reqUrl);
		
		begin = result.indexOf("response") + 9;
		end = result.lastIndexOf("response") - 2;
		boolValue = result.slice(begin,end); 
	}
	return trim(boolValue);
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

function callbackResponse( response )
{
	if(response)
	{
		<c:if test="${isAdministrator}">
		    selectAll('userRoles');
		</c:if>
		document.getElementById('bDelete').value='true';
		document.getElementById('edituser').submit();	
	}
}

function jqFormatPhone( obj )
{
	var vPhone = $.trim($(obj).val());
	var vFMPTmp = "";
	var vFMPhone = "";
	var vSymbolArray = [')','(','-','#',' '];
	
	for( var i = 0; i < vPhone.length; i++ )
	{
		if( vSymbolArray.indexOf($.trim(vPhone.charAt(i))) < 0 )
			vFMPTmp = vFMPTmp + '' + $.trim(vPhone.charAt(i));
	}
	
	for( var j = 0; j < vFMPTmp.length; j++ )
	{
		if( j == 0 )
			vFMPhone = "(" + $.trim(vFMPTmp.charAt(j));
		else if( j == 2 )
			vFMPhone = vFMPhone + '' + $.trim(vFMPTmp.charAt(j)) + ')';
		else if( (j == 3) || (j == 6) )
			vFMPhone = vFMPhone + ' '+  $.trim(vFMPTmp.charAt(j));
		else
			vFMPhone = vFMPhone + '' + $.trim(vFMPTmp.charAt(j));
   	}
	$(obj).val(vFMPhone);
}

function showOppSkillLevelOptions(){
	var openToChallenges=$('#openToChallenges').val();
	
	if('yes' == openToChallenges){
		$('#opponentSkillLevelDiv').show();
	}else{
		$('#opponentSkillLevelDiv').hide();
	}
}

$(document).ready( function() {
    var now = new Date();
    var day = ("0" + now.getDate()).slice(-2);
    var month = ("0" + (now.getMonth() + 1)).slice(-2);
    var today = now.getFullYear()+"-"+(month)+"-"+(day) ;
    $('#todayDate').val(today);
	$('#todayDate').attr("disabled", true) 
	
	$('#opponentSkillLevelDiv').hide();
	
		$(".checkbox-dropdown").click(function () {
	    $(this).toggleClass("is-active");
	});
	
	$(".checkbox-dropdown ul").click(function(e) {
	    e.stopPropagation();
	});

$('.floating-label-wrap').each(function(){
  var inputText = $(this).find('.longBox').attr("name");
  //console.log(name);
  $(this).find('input').attr('placeholder',inputText);
});

	
 });
 
 $(document).ready(function(){
         $('input[name=checkdrop]').click(function() {
		  if (this.checked) {
		    //uncheck all other checkbox
		    $('input[name=checkdrop]').not(this).prop('checked', false);
		    //hide all dropdown first
		    $('.dropdown').hide();
		    //show the checked one
		    $('#' + this.value).parent().show();
		  } else {
		    $('#' + this.value).parent().hide();
		  }
		});	
 });
 
</script>


<v:javascript formName="user" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script>

<%-- </c:if> --%>