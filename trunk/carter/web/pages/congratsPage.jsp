<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="congrats.pageTitle"/></title>
    <meta name="menu" content="Welcome"/>
    
    <script type="text/javascript">
		$(function(){
			<c:choose>
			<c:when test="${not empty openRegistrations}">
			setInterval(function(){
				location.href = 'registration.html';
			}, 3500);
			</c:when>
			<c:otherwise>
			setInterval(function(){
				location.href = 'profile.html';
			}, 3500);
			</c:otherwise>
			</c:choose>
		});
	</script>
</head>

<div id="congrats">
	<c:if test="${not empty user}">
	<div id="congrats-msg-div">
		<span class="left">
    		<img src="images/guest.PNG" alt="congrats"/>
    	</span>
		
		<p class="large-txt">
			<span id="congrats-txt">
				<fmt:message key="congrats.successText"/>
			</span>
			<c:out value="${fullName}"/>
		</p>
		<div id="congrats-msg">
		   <div class="row">
			<span class="col-sm-6"><fmt:message key="congrats.successMessage"/></span>
			<span class="col-sm-6">Tour Caddie Optional</span>
			</div>
		</div>
	</div>
	
	<div id="congrats-nav">
		<div id="upper-msg-container">
		<c:choose>
			<c:when test="${not empty openRegistrations}">
				<div class="left congrats-para-div">
					<fmt:message key="congrats.seasonAvailableTxt" />
				</div>
			    <div id="upper-btn">
			    	<c:set var="url"><c:url value="/registration.html"/></c:set>
			        <carter:button page="${url}" key="button.register"/>
			    </div>
			</c:when>
			<c:otherwise>
				<div id="no-msg-div">
					No Seasons are currently open for registration in your city.<br>
					You will be notified before the Start of the next season.
				</div>
			</c:otherwise>
		</c:choose>
		</div>
		
		<div id="upper-msg-container">
			<div class="left congrats-para-div">
				<fmt:message key="congrats.profileTxt" />
			</div>
			<div id="lower-btn">
				<c:set var="url"><c:url value="/profile.html"/></c:set>
				<carter:button page="${url}" key="button.profile"/>
			</div>
		</div>
	</div>
	</c:if>
</div>
