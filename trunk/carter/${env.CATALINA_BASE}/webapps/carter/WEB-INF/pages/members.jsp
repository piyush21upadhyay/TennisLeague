<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="members.title"/></title>
    <meta name="menu" content="Lookup"/>
</head>

<c:if test="${empty errors and empty successMessages}">

<div id="members">

<script type="text/javascript">
	$(document).ready(function() {
		var objSpan = $(".search-row .squarebutton span");
		$.each(objSpan, function(){
			$(this).css('width','52px');
		});
	});

	function checkAccess(redirectUrl){
		<c:choose>
			<c:when test="${not empty user}">
				location.href = redirectUrl;
			</c:when>
			<c:otherwise>
				cglAlert('Invalid Action',"You must be logged in to send a message",300);
				$(".ui-dialog-overlay").width(document.body.clientWidth);
			</c:otherwise>
		</c:choose>
	}
</script>

<!--[if IE]>
<style type="text/css">
    .search-col input[type="checkbox"]
	{
		margin-top:5px;
	}
</style>
<![endif]-->

<%-- I removed sorting for now because it will take a while to implement
<div id="members-sortby">
	<div id="msb-header">sort by</div>
	<div id="msb-options">
		<ul>
			<li><a href="#">last name</a></li>
			<li><a href="#">city</a></li>

			<li><a href="#">division</a></li>
			<li><a href="#">handicap</a></li>
			<li><a href="#">homecourse</a></li>
			<li><a href="#">season points</a></li>
		</ul>
	</div>
</div>
--%>

<div class="section">
	<div class="left">
		<h2 class="page-title"><fmt:message key="members.members"/></h2>
	</div>
	<div class="right">
		<form:form commandName="search" method="post" action="members.html">
		<div class="search-row">
			<div class="search-col">
				<h4><fmt:message key="members.searchBy"/></h4>
			</div>
		</div>
		<div class="search-row">
			<div class="search-col">
				<fmt:message key="members.firstname"/>
			</div>
			<div class="search-col">
				<fmt:message key="members.lastname"/>
			</div>
		</div>
		<div class="search-row">
			<div class="search-col">
				<form:input path="firstname" id="firstname" size="20" maxlength="30"/>
			</div>
			<div class="search-col">
				<form:input path="lastname" id="lastname" size="20" maxlength="30"/>
			</div>
		</div>
		<div class="search-row">
			<div class="search-col">
				<fmt:message key="members.maxHandicap"/>
			</div>
			<div class="search-col">
				<fmt:message key="members.minHandicap"/>
			</div>
		</div>
		<div class="search-row">
			<div class="search-col">
				<form:select path="maxHandicap" id="maxHandicap">
					<option> </option>
					<c:forEach var="hdcp" begin="0" end="20" step="1">
						<option<c:if test="${search.maxHandicap eq hdcp}"> selected="true"</c:if>><c:out value="${hdcp}"/></option>
					</c:forEach>
				</form:select>
			</div>
			<div class="search-col">
				<form:select path="minHandicap" id="minHandicap">
					<option> </option>
					<c:forEach var="hdcp" begin="0" end="20" step="1">
						<option<c:if test="${search.minHandicap eq hdcp}"> selected="true"</c:if>><c:out value="${hdcp}"/></option>
					</c:forEach>
				</form:select>
			</div>
		</div>
		<c:if test="${isAdministrator}">
		<div class="search-row">
			<div class="search-col">
				<fmt:message key="members.deleted"/>
			</div>
		</div>
		<div class="search-row">
			<div class="search-col">
				<input type="checkbox" name="showDeleted" id="showDeleted" value="1" <c:if test="${showDeleted}"> checked="true"</c:if>/>
			</div>
		</div>
		</c:if>
		<div class="search-row">
			<div class="search-col">
				<carter:button onclick="document.getElementById('search').submit();return false;" key="button.search"/>
			</div>
			<div class="search-col">
	    		<carter:button onclick="document.location.href='members.html';" key="button.clear"/>
			</div>
		</div>
		</form:form>
	</div>
</div>

<div class="member-section">
<c:choose>
	<c:when test="${not empty memberList}">
	<c:set var="count" value="0" scope="page" />
		<c:forEach var="member" items="${memberList}">
			<c:set var="firstName" value="${member.firstName}"/>
		    <c:set var="count" value="${count + 1}" scope="page"/>
	          <div class="threecol-scroll">
				<c:set var="player" value="${member}" scope="request"/>
				<c:set var="currentRecord" value="${member.currentRecord}" scope="request"/>
				<c:set var="registeredUserList" value="${registeredUsers}" scope="request"/>
				<c:import url="/common/playerInfo.jsp">
					<c:param name="showProfileButton" value="true"/>
					<c:param name="displayScheduleLink" value="true"/>
					<c:param name="displayMessageLink" value="true"/>
				</c:import>
			</div>
			<c:if test="${count%3==0}">
			<div style="clear:both;"></div>
			</c:if>	
		</c:forEach>
	</c:when>
	<c:otherwise>
		<div class="section"><h2><fmt:message key="members.empty"/></h2></div>
	</c:otherwise>
</c:choose>
</div>
</div>

</c:if>
