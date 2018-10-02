<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="champions.title"/></title>
    <meta name="menu" content="Champions"/>
</head>

<c:if test="${empty errors and empty successMessages}">

<div class="section">
	<div class="left">
		<h2 class="page-title"><fmt:message key="champions.title"/> <c:out value="${year}"/></h2>
	</div>
		<div class="right">
		<form name="chooseYear" action="champions.html">
		<select id="changeYear" name="changeYear" onchange="document.chooseYear.submit();">
			<option><fmt:message key="champions.changeYear"/></option>
			<c:forEach var="year" items="${years}">
				<option value="<c:out value="${year}"/>"><c:out value="${year}"/></option>
			</c:forEach>
	      </select>
	    </form>
	</div>
</div>
<div class="clear"></div>


<div class="champion-section">

<c:choose>
	<c:when test="${empty champions}">
		<script type="text/javascript">
			function showPopupMsg()
			{
				var alertMsg = "";
				var alertHeader = "";
				
				var num = Math.floor((Math.random() * 100) + 1);
				
				if((num > 1) && (num <= 13))
				{
					alertHeader = "TEE OFF";
					alertMsg = "<span class='span-green font-2 span-align-right'>TOUR<br/>CADDIE</span><br/><span class='font-1 span-align-right'>OPTIONAL</span>";
				}
				else if((num > 13) && (num <= 20))
				{
					alertHeader = "TEE OFF";
					alertMsg = "<span class='font-3 span-align-right'>WE&#39;LL POST YOUR<br/>BRAGGING RIGHTS<br/>ONLINE</span>";
				}
				else if((num > 20) && (num <= 28))
				{
					alertHeader = "TEE OFF";
					alertMsg = "<span class='span-align-right span-green font-2'>BRAGGING<br/>RIGHTS</span><br/><span class='font-1'>FOREVER</span>";
				}
				else if((num > 28) && (num <= 37))
				{
					alertHeader = "TEE OFF";
					alertMsg = "<span class='span-align-right font-3'>WHEN YOU GET<br/>A BIRDIE THE<br/>ENTIRE INTERNET<br/>WILL KNOW</span>";
				}
				else if((num > 37) && (num <= 44))
				{
					alertHeader = "YOU: get in the game";
					alertMsg = "<span class='span-align-right span-green font-1'>WORDWIDE</span><br/><span class='span-align-right font-3'>BRAGGING<br/>RIGHTS</span>";
				}
				else if((num > 44) && (num <= 51))
				{
					alertHeader = "YOU: get in the game";
					alertMsg = "<span class='span-green font-3'>BRAGGING<br/>RIGHTS</span><br/><span class='span-align-right font-1'>FOREVER</span>";
				}
				else if((num > 51) && (num <= 59))
				{
					alertHeader = "YOU: get in the game";
					alertMsg = "<span class='font-1'>ETERNAL</span><br/><span class='span-green span-align-right font-3'>BRAGGING<br/>RIGHTS</span>";
				}
				else if((num > 59) && (num <= 71))
				{
					alertHeader = "YOU:";
					alertMsg = "<span class='span-align-right font-1'>BRING YOUR <span class='span-green'>BIG<br/>STICKS</span></span>";
				}
				else if((num > 71) && (num <= 85))
				{
					alertHeader = "YOU:";
					alertMsg = "<span class='span-align-right font-1'>PROVE<br/>IT</span>";
				}
				else
				{
					alertHeader = "TEE OFF";
					alertMsg = "<span class='span-align-right font-3'>YOUR<br/>ATHLETIC GLORY<br/>DAYS ARE IN<br/>FRONT OF YOU</span>";
				}
					
				cglAlert(alertHeader, alertMsg, 300);
				
				$(".ui-dialog-overlay").width(document.body.clientWidth);
				
				/* alert dialog header div css settings */
				$(".ui-dialog-titlebar").css({
					padding: '0.2em 0.3em 0.2em 1em'
				});
				
				/* alert dialog header span css settings */
				$("#ui-dialog-title-cgl-alert").css({
					width: 260,
					'text-align': 'center',
					'font-size': 20,
					'margin-bottom': 0
			   	});
			}
		</script>
		<div class="threecol-frame">
			<div>
				<div class="left"><img src="images/trophy-icon.gif" alt="member"/></div>
				<div class="left">
					<h2>&nbsp;<strong>Division Winner</strong></h2>
				</div>

				<div class="right">
					
					<div class="buttonwrapper"><a onclick="showPopupMsg();" class="squarebutton ie-post-link"><span>Profile</span></a></div>
				</div>
				<div class="clear"></div>
				<p class="champ-info">City Champion</p>
	        	<p class="champ-info">Summer 2009 Division One</p>
				<p>Home Court: <a onclick="showPopupMsg();" class="course-link ie-post-link">Some Golf Course</a></p>

				<!-- <p>USGA Handicap: 10.7</p> -->
				<p>Rating: 5.0</p>
				<p>Season Record: <a onclick="showPopupMsg();" class="ie-post-link">0-0-0</a></p>
			</div>
		</div>
	
		<div class="threecol-frame">
			<div>
				<div class="left"><img src="images/trophy-icon.gif" alt="member"/></div>
				<div class="left">
					<h2>&nbsp;<strong>Division Winner</strong></h2>
				</div>

				<div class="right">
					
					<div class="buttonwrapper"><a onclick="showPopupMsg();" class="squarebutton ie-post-link"><span>Profile</span></a></div>
				</div>
				<div class="clear"></div>
				<p class="champ-info">City Champion</p>
	        	<p class="champ-info">Summer 2009 Division One</p>
				<p>Home Court: <a onclick="showPopupMsg();" class="course-link ie-post-link">Some Golf Course</a></p>

				<!-- <p>USGA Handicap: 10.7</p> -->
				<p>Rating: 5.0</p>
				<p>Season Record: <a onclick="showPopupMsg();" class="ie-post-link">0-0-0</a></p>
			</div>
		</div>

	
		<div class="threecol-frame">
			<div>
				<div class="left"><img src="images/trophy-icon.gif" alt="member"/></div>
				<div class="left">
					<h2>&nbsp;<strong>Division Winner</strong></h2>
				</div>

				<div class="right">
					
					<div class="buttonwrapper"><a onclick="showPopupMsg();" class="squarebutton ie-post-link"><span>Profile</span></a></div>
				</div>
				<div class="clear"></div>
				<p class="champ-info">City Champion</p>
	        	<p class="champ-info">Summer 2009 Division One</p>
				<p>Home Court: <a onclick="showPopupMsg();" class="course-link ie-post-link">Some Golf Course</a></p>

				<!-- <p>USGA Handicap: 10.7</p> -->
				<p>Rating: 5.0</p>
				<p>Season Record: <a onclick="showPopupMsg();" class="ie-post-link">0-0-0</a></p>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<c:forEach var="champion" items="${champions}">
			<div class="threecol-frame">
				<div>
					<div class="left"><img width="42" src="<c:url value="${champion.player.icon}"/>" alt="member"/></div>
					<div class="left">
						<h2>&nbsp;<strong><c:out value="${champion.player.fullName}"/><c:out value="${champion.player.playerLevel}"/></strong></h2>
					</div>
					<div class="right">
						<c:set var="url"><c:url value="/profile.html"/></c:set>
						<carter:button page="${url}" param="id=${champion.player.id}&amp;msg=false" key="members.profile"/>
					</div>
					<div class="clear"></div>
					<p class="champ-info"><fmt:message key="champions.cityChampion"/></p>
		        	<p class="champ-info"><c:out value="${champion.season}"/> <c:out value="${champion.division}"/></p>
					<p><fmt:message key="members.homeCourt"/> <a class="course-link" href="<c:url value="/coursedetails.html?id="/><c:out value="${champion.homeCourt.id}"/>"><c:out value="${champion.homeCourt.name}"/></a></p>
					<%-- <p><fmt:message key="members.handicap"/> <c:out value="${champion.player.handicap}"/></p> --%>
					<p><fmt:message key="members.rating"/> <c:out value="${champion.player.playerLevel}"/></p>
					<p><fmt:message key="members.seasonRecord"/> <a href="<c:url value="/record.html?id="/><c:out value="${champion.player.id}"/>"><c:out value="${champion.record}"/></a></p>
				</div>
			</div>
		</c:forEach>
	</c:otherwise>
</c:choose>

</div>

</c:if>