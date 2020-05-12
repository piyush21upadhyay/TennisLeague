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
		
		 $('#sortByFirstNameId').click(function(){
				 $("#sortingParameter").val("firstName");
				 $('input[name="sortingParameter"]').val("firstName");
				 $('#search').submit();
		    });
		 
		 $('#sortByLastNameId').click(function(){
				 $("#sortingParameter").val("lastName");
				 $('#search').submit();
		    });
		    $(".player-info").each(function() {
			  $(".left",this).prependTo($(".subsection .flu-box",this));
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
	<div class="membersLeft">
		<h2 class="page-title"><fmt:message key="members.members"/></h2>
		<div class="search-row">
			<!--div class="search-col">
				<h4><fmt:message key="members.searchBy"/></h4>
			</div-->
		</div>
	</div>
	<div class="col-sm-12 shadow-sm grey-box">
	
		<form:form commandName="search" method="post" action="members.html">
		<div class="row">
		<!-- Search By First Name/Last Name/Gender starts -->
		<input type="hidden" name="sortingParameter" id="sortingParameter">
		<div class="col-sm-3">
		<div class="row">
		<div class="search-row col-sm-4">
			<div class="search-col">
				<a  href="#" id="sortByFirstNameId"><fmt:message key="members.firstname"/></a>
			</div>
			<div class="search-col">
				<a  href="#" id="sortByLastNameId"><fmt:message key="members.lastname"/></a>
			</div>
			<div class="search-col">
				<fmt:message key="members.gender"/>
			</div>
				<div class="search-col">
				<fmt:message key="members.dexterity"/>
			</div>
		</div>
		<div class="search-row col-sm-8">
			<div class="search-col">
				<form:input path="firstname" id="firstname" size="10" maxlength="10"/>
			</div>
			<div class="search-col">
				<form:input path="lastname" id="lastname" size="10" maxlength="10"/>
			</div>
			<div class="search-col">
				<form:select path="gender" id="gender">
					<option> </option>
					<c:forEach var="gndr" items="${gender}">
						<option<c:if test="${search.gender eq gndr}"> selected="true"</c:if>><c:out value="${gndr}"/></option>
					</c:forEach>
				</form:select>
			</div>
					<div class="search-col">
				<form:select path="dexterity" id="dexterity">
					<option> </option>
					<c:forEach var="dexterity" items="${dexterities}">
						<option<c:if test="${search.dexterity eq dexterity}"> selected="true"</c:if>><c:out value="${dexterity}"/></option>
					</c:forEach>
				</form:select>
			</div>
		</div>
		</div>
		</div>
		<!-- Search By First Name/Last Name/Gender ends -->
		
		<!-- Search By Dexterity/Match Preference starts -->
		<div class="col-sm-3">
		<div class="row">
		<div class="search-row col-sm-12">
		
			<div class="search-col text-center">
				<fmt:message key="members.matchPreference"/>
			</div>
		
		</div>
		<div class="search-row col-sm-12 match-list">
	
			<div class="search-col match-col">
				<%-- <form:select path="matchPreference" id="matchPreference">
					<option> </option> --%>
					<c:forEach var="matchPreference" items="${matchPreferences}">
						<%-- <option<c:if test="${search.matchPreference eq matchPreference}"> selected="true"</c:if>><c:out value="${matchPreference}"/></option> --%>
						<div class="list-view-match text-left">
						<form:checkbox path="matchPreference" value="${matchPreference}" /> 
						<label class="checkboxlabel" ><c:out value="${matchPreference}"/>
						</label>
						</div>
					</c:forEach>
				<%-- </form:select> --%>
			</div>
		
		</div>
		</div>
		</div>
		<!-- Search By Dexterity/Match Preference ends -->
		
		<!-- Search By Rating starts -->
		<div class="col-sm-3">
		<div class="row">
		<div class="search-row col-sm-6">
			<div class="search-col">
				<fmt:message key="members.tournamentEntry"/>
			</div>
			<div class="search-col">
				<fmt:message key="members.minRating"/>
			</div>
			<div class="search-col">
				<fmt:message key="members.rating"/>
			</div>
			<div class="search-col">
				<fmt:message key="members.maxRating"/>
			</div>
		</div>
		<div class="search-row col-sm-6">
			<div class="search-col">
				<form:input path="tournamentEntry" id="tournamentEntry" size="20" maxlength="30"/>
			</div>
			<div class="search-col">
				<form:select path="minRating" id="minRating">
					<option> </option>
					<c:forEach var="rating" items="${playerRatings}">
						<option<c:if test="${search.minRating eq rating}"> selected="true"</c:if>><c:out value="${rating}"/></option>
					</c:forEach>
				</form:select>
			</div>
			<div class="search-col">
				<form:select path="rating" id="rating">
					<option> </option>
					<c:forEach var="rat" items="${playerRatings}">
						<option<c:if test="${search.rating eq rat}"> selected="true"</c:if>><c:out value="${rat}"/></option>
					</c:forEach>
				</form:select>
			</div>
			<div class="search-col">
				<form:select path="maxRating" id="maxRating">
					<option> </option>
					<c:forEach var="rating" items="${playerRatings}">
						<option<c:if test="${search.maxRating eq rating}"> selected="true"</c:if>><c:out value="${rating}"/></option>
					</c:forEach>
				</form:select>
			</div>
		</div>
		</div>
		</div>
		<!-- Search By Rating ends -->
	<div class="col-sm-3">
		<c:if test="${isAdministrator}">
		<div class="search-row">
			<div class="search-col">
				<fmt:message key="members.deleted"/>
				<input type="checkbox" name="showDeleted" id="showDeleted" value="1" <c:if test="${showDeleted}"> checked="true"</c:if>/>
			</div>
		</div>
		
		<!--div class="search-row">
			<div class="search-col">
				
			</div>
		</div-->
		</c:if>
		<div class="search-row member-btn">
			<div class="search-col green-btn">
				<carter:button onclick="document.getElementById('search').submit();return false;" key="button.search"/>
			</div>
			<div class="search-col white-btn">
	    		<carter:button onclick="document.location.href='members.html';" key="button.clear"/>
			</div>
		</div>
		</div>
		</div>
		</form:form>
		
	</div>
</div>

<div class="member-section">
<div class="row">
<c:choose>
	<c:when test="${not empty memberList}">
	<c:set var="count" value="0" scope="page" />
		<c:forEach var="member" items="${memberList}">
			   
	          <div class="col-sm-4">
			<c:set var="firstName" value="${member.firstName}"/>
		    <c:set var="count" value="${count + 1}" scope="page"/>
				<c:set var="player" value="${member}" scope="request"/>
				<c:set var="currentRecord" value="${member.currentRecord}" scope="request"/>
				<c:set var="registeredUserList" value="${registeredUsers}" scope="request"/>
				<c:import url="/common/playerInfo.jsp">
					<c:param name="showProfileButton" value="true"/>
					<c:param name="displayScheduleLink" value="true"/>
					<c:param name="displayMessageLink" value="true"/>
				</c:import>
			</div>
			<c:if test="${count%4==0}">
			</c:if>	
		</c:forEach>
	</c:when>
	<c:otherwise>
		<div class="section"><h2><fmt:message key="members.empty"/></h2></div>
	</c:otherwise>
</c:choose>
</div>
</div>
</div>

</c:if>