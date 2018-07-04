<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="results.title"/></title>
    <meta name="menu" content="PostResults"/>
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/${appConfig["csstheme"]}/scorecard2.css'/>" />
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/${appConfig["csstheme"]}/jquery.ui.datepicker.css'/>" />
<c:if test="${enterScores}">
	<script type="text/javascript">
	$(function() {
		$("#played").datepicker({showOn: 'button', buttonImage: 'images/calendar-icon.jpg', buttonImageOnly: true});
		
		//fix for safari
		if(window.devicePixelRatio)
		{
			$(".ui-datepicker-trigger").css({
				width: 26,
				height: 21
			});
		}
	});
	
	function checkFields()
	{
		var currentDate = new Date();
		var strDate = $("#played").val();
		
		var dtPattern = /^(0[1-9]|1[0-2])[/](0[1-9]|[12][0-9]|3[0-1])[/](19|20)\d\d$/;
		var result = dtPattern.test(strDate);
		
		if(result)
		{
			var mon = parseInt(strDate.substring(0, 2), 10);
			var dt = parseInt(strDate.substring(3, 5), 10);
			var yr = parseInt(strDate.substring(6, 10), 10);
			var playedDate = new Date(yr, mon-1, dt);
			
			if (playedDate > currentDate)
				cglAlert('Invalid Action',"Played date should be current or past date",300);
			else
			{
				document.getElementById('bVerify').value = 'true';
				document.getElementById('matchForm').submit();
			}	
		}
		else
			cglAlert('Invalid Action',"Played date should be in 'mm/dd/yyyy' format.",300);
	}
	</script>
</c:if>
</head>

<c:if test="${not empty match}">

	<div class="section">
		<div class="left">
			<h2><fmt:message key="results.header"/></h2>
			
			<c:if test="${not enterScores}">
			    <p>
			        <c:out value="${match.course.name}"/>
			    </p>
			    <p>
					<fmt:formatDate value="${match.played}" pattern="MMM dd, yyyy"/>
				</p>
				<p>
					<c:choose>
						<c:when test="${match.result.tie}">
							<fmt:message key="results.draw"/>
						</c:when>
						<c:when test="${match.defaultWin}">
							<c:out value="${match.defaultWinner.fullName}"/> <fmt:message key="results.defaultWin"/>
						</c:when>
						<c:otherwise>
							<c:out value="${match.result.winner.fullName}"/>
							<fmt:message key="results.wins"/>
							<c:out value="${match.result.holesWon}"/> &amp; <c:out value="${match.result.holesRemaining}"/>
						</c:otherwise>
					</c:choose>
				</p>
			</c:if>
			
			<spring:bind path="match.*">
			    <c:if test="${not empty status.errorMessages}">
			    <div class="error">
			        <c:forEach var="error" items="${status.errorMessages}">
			            <img src="<c:url value="/images/iconWarning.gif"/>"
			                alt="<fmt:message key="icon.warning"/>" class="icon"/>
			            <c:out value="${error}" escapeXml="false"/>
			        </c:forEach>
			    </div>
			    </c:if>
			</spring:bind>
		</div>
	</div>
	
	<c:choose>
	<c:when test="${enterScores}">
		<form:form commandName="match" method="post" action="results.html" id="matchForm">
			<form:hidden path="id"/>
				<form:hidden path="version"/>

			<div class="section">
				<div id="played-info">
					<label for="course"><fmt:message key="results.course"/></label>
			        <form:select path="course" id="course">
			       		<c:choose>
							<c:when test="${isAdministrator}">
							<c:forEach var="course" items="${Allcourse}">
                            <option value="<c:out value='${course.id}'/>" 
                            <c:if test="${courseList.id== course.id}">selected</c:if>>
                            <c:out value="${course.name}"/>
                            </option>
                            </c:forEach>
							</c:when>
							<c:otherwise>
								<c:forEach var="course" items="${courseList}">
									<option value="<c:out value='${course.id}'/>"
										<c:if test="${match.golfer1.homeCourse.id == course.id}"><c:out escapeXml="false" value=" selected='selected'"/></c:if>><c:out value="${course.name}"/>
									</option>
								</c:forEach>
							</c:otherwise>
						</c:choose>
			        </form:select>
					<label for="played"><fmt:message key="results.datePlayed"/></label>
					<input type="text" id="played" name="played" maxlength="12"
						value="<fmt:formatDate value="${match.played}" pattern="MM/dd/yyyy"/>"/>
				</div>
			</div>
			<div class="section">
				<div class="card">
						<div class="top-row entry-row-top">
							<div class="first"><fmt:message key="results.hole"/></div>
							<c:forEach var="hole" begin="1" end="9" step="1">
								<div class="hole"><c:out value="${hole}"/></div>
							</c:forEach>
							<div class="nine">&nbsp;</div>
							<c:forEach var="hole" begin="10" end="17" step="1">
									<div class="hole"><c:out value="${hole}"/></div>
							</c:forEach>
							<div class="hole last-short">18</div>
						</div>
						<div class="clear"></div>
	
					<div class="entry-row-one">
						<div class="first"><c:out value="${match.golfer1.displayName}"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player1Hole1Score" onkeyup="autotab(this,document.getElementById('score.player1Hole2Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player1Hole2Score" onkeyup="autotab(this,document.getElementById('score.player1Hole3Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player1Hole3Score" onkeyup="autotab(this,document.getElementById('score.player1Hole4Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player1Hole4Score" onkeyup="autotab(this,document.getElementById('score.player1Hole5Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player1Hole5Score" onkeyup="autotab(this,document.getElementById('score.player1Hole6Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player1Hole6Score" onkeyup="autotab(this,document.getElementById('score.player1Hole7Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player1Hole7Score" onkeyup="autotab(this,document.getElementById('score.player1Hole8Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player1Hole8Score" onkeyup="autotab(this,document.getElementById('score.player1Hole9Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player1Hole9Score" onkeyup="autotab(this,document.getElementById('score.player1Hole10Score'))"/></div>
						<div class="nine">&nbsp;</div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player1Hole10Score" onkeyup="autotab(this,document.getElementById('score.player1Hole11Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player1Hole11Score" onkeyup="autotab(this,document.getElementById('score.player1Hole12Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player1Hole12Score" onkeyup="autotab(this,document.getElementById('score.player1Hole13Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player1Hole13Score" onkeyup="autotab(this,document.getElementById('score.player1Hole14Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player1Hole14Score" onkeyup="autotab(this,document.getElementById('score.player1Hole15Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player1Hole15Score" onkeyup="autotab(this,document.getElementById('score.player1Hole16Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player1Hole16Score" onkeyup="autotab(this,document.getElementById('score.player1Hole17Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player1Hole17Score" onkeyup="autotab(this,document.getElementById('score.player1Hole18Score'))"/></div>
						<div class="hole last-short"><form:input maxlength="2" cssClass="holescore" path="score.player1Hole18Score" onkeyup="autotab(this,document.getElementById('score.player2Hole1Score'))"/></div>
					</div>
					<div class="clear"></div>
					
					<div class="entry-row-two">
						<div class="first"><c:out value="${match.golfer2.displayName}"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player2Hole1Score" onkeyup="autotab(this,document.getElementById('score.player2Hole2Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player2Hole2Score" onkeyup="autotab(this,document.getElementById('score.player2Hole3Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player2Hole3Score" onkeyup="autotab(this,document.getElementById('score.player2Hole4Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player2Hole4Score" onkeyup="autotab(this,document.getElementById('score.player2Hole5Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player2Hole5Score" onkeyup="autotab(this,document.getElementById('score.player2Hole6Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player2Hole6Score" onkeyup="autotab(this,document.getElementById('score.player2Hole7Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player2Hole7Score" onkeyup="autotab(this,document.getElementById('score.player2Hole8Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player2Hole8Score" onkeyup="autotab(this,document.getElementById('score.player2Hole9Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player2Hole9Score" onkeyup="autotab(this,document.getElementById('score.player2Hole10Score'))"/></div>
						<div class="nine">&nbsp;</div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player2Hole10Score" onkeyup="autotab(this,document.getElementById('score.player2Hole11Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player2Hole11Score" onkeyup="autotab(this,document.getElementById('score.player2Hole12Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player2Hole12Score" onkeyup="autotab(this,document.getElementById('score.player2Hole13Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player2Hole13Score" onkeyup="autotab(this,document.getElementById('score.player2Hole14Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player2Hole14Score" onkeyup="autotab(this,document.getElementById('score.player2Hole15Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player2Hole15Score" onkeyup="autotab(this,document.getElementById('score.player2Hole16Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player2Hole16Score" onkeyup="autotab(this,document.getElementById('score.player2Hole17Score'))"/></div>
						<div class="hole"><form:input maxlength="2" cssClass="holescore" path="score.player2Hole17Score" onkeyup="autotab(this,document.getElementById('score.player2Hole18Score'))"/></div>
						<div class="hole last-short"><form:input maxlength="2" cssClass="holescore" path="score.player2Hole18Score" onkeyup="autotab(this,document.getElementById('postButton'))"/></div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<div class="clear"></div>
			<div id="result-members">
				<div class="threecol">
					<h3><fmt:message key="results.homePlayer"/></h3>
					<div class="player-info">
						<div class="left"><img src="<c:url value="${match.golfer1.icon}"/>" alt="member"/></div>
						<div class="left">
							<h2>&nbsp;<strong><c:out value="${match.golfer1.displayName}"/></strong></h2>
						</div>
						<div class="right">
							<c:set var="url"><c:url value="/profile.html"/></c:set>
							<carter:button page="${url}" param="id=${match.golfer1.id}&amp;msg=false" key="members.profile"/>
						</div>
						<div style="clear:both">
							<h3><c:out value="${match.golfer1.currentSeason.division}"/></h3>
							<p><fmt:message key="members.homeCourse"/> <a class="course-link" href="<c:url value="/coursedetails.html?id="/><c:out value="${match.golfer1.homeCourse.id}"/>"><c:out value="${match.golfer1.homeCourse.name}"/></a></p>
							<p><fmt:message key="members.handicap"/>
							<c:choose>
								<c:when test="${match.golfer1.handicap lt 0}">
									<c:out value="+"/><c:out value="${0 - match.golfer1.handicap}"/>
								</c:when>
								<c:otherwise>
									<c:out value="${match.golfer1.handicap}"/>
								</c:otherwise>
							</c:choose>
							</p>
							<p><fmt:message key="members.seasonRecord"/> <a href="<c:url value="/record.html?id="/><c:out value="${match.golfer1.id}"/>"><c:out value="${match.golfer1.currentWins}"/>-<c:out value="${match.golfer1.currentLosses}"/>-<c:out value="${match.golfer1.currentTies}"/></a></p>
							<p>
							<a class="msg-link" href="<c:url value="/schedule.html?id="/><c:out value="${match.golfer1.id}"/>">
								<fmt:message key="members.schedule">
									<fmt:param value="${match.golfer1.firstName}"/>
								</fmt:message>
							</a>
							</p>
						</div>
					</div>
			    </div>
				<div class="threecol">
					<h3><fmt:message key="results.awayPlayer"/></h3>
					<div class="player-info">
						<div class="left"><img src="<c:url value="${match.golfer2.icon}"/>" alt="member"/></div>
						<div class="left">
							<h2>&nbsp;<strong><c:out value="${match.golfer2.displayName}"/></strong></h2>
						</div>
						<div class="right">
							<c:set var="url"><c:url value="/profile.html"/></c:set>
							<carter:button page="${url}" param="id=${match.golfer2.id}&amp;msg=false" key="members.profile"/>
						</div>
						<div style="clear:both">
							<h3><c:out value="${match.golfer2.currentSeason.division}"/></h3>
							<p><fmt:message key="members.homeCourse"/> <a class="course-link" href="<c:url value="/coursedetails.html?id="/><c:out value="${match.golfer2.homeCourse.id}"/>"><c:out value="${match.golfer2.homeCourse.name}"/></a></p>
							<p><fmt:message key="members.handicap"/>
							<c:choose>
								<c:when test="${match.golfer2.handicap lt 0}">
									<c:out value="+"/><c:out value="${0 - match.golfer2.handicap}"/>
								</c:when>
								<c:otherwise>
									<c:out value="${match.golfer2.handicap}"/>
								</c:otherwise>
							</c:choose>
							</p>
							<p><fmt:message key="members.seasonRecord"/> <a href="<c:url value="/record.html?id="/><c:out value="${match.golfer2.id}"/>"><c:out value="${match.golfer2.currentWins}"/>-<c:out value="${match.golfer2.currentLosses}"/>-<c:out value="${match.golfer2.currentTies}"/></a></p>
							<p>
							<a class="msg-link" href="<c:url value="/schedule.html?id="/><c:out value="${match.golfer2.id}"/>">
								<fmt:message key="members.schedule">
									<fmt:param value="${match.golfer2.firstName}"/>
								</fmt:message>
							</a>
							</p>
						</div>
					</div>
			    </div>
			</div>
			<div class="section">
				<div class="buttons">
					<div class="left">
						<carter:button onclick="checkFields();" key="button.post" name="postButton"/>
					</div>
					<div class="left">
						<carter:button onclick="document.getElementById('bCancel').value='true';document.getElementById('matchForm').submit();return false;" key="button.cancel"/>
					</div>
					<div class="clear"></div>
					<div>
						<a class="msg-link" onclick="document.getElementById('bDefault').value='true';document.getElementById('matchForm').submit();return false;" href="javascript:{}"><fmt:message key="button.default"/></a>
					</div>
					<input id="bCancel" type="hidden" name="bCancel" value="false"/>
					<input id="bDefault" type="hidden" name="bDefault" value="false"/>
					<input id="bVerify" type="hidden" name="bVerify" value="false"/>
					<c:if test="${isAdministrator}">
					<input id="user_id" type="hidden" name="user_id" value="<c:out value='${user.id}'/>"/>
					</c:if>
					<div class="clear"></div>
				</div>
			</div>
		</form:form>
			
		<script type="text/javascript">
			<!--
			$("#score\\.player1Hole1Score").focus();
		    function autotab(src,dest)
		    {
		    	if ((src.value.length==1 && src.value[0]!='1') || src.value.length>1) dest.focus();
		    }
		    -->
		</script>
	</c:when>
<c:otherwise>
	<c:if test="${not match.defaultWin}">
	<div class="section">
		<c:import url="/common/matchCard.jsp"/>
		<div class="right">
			<c:import url="/common/legend.jsp"/>
		</div>
	</div>
	<div class="clear"></div>
	</c:if>
	
	<div class="section">
		<form:form commandName="match" method="post" action="results.html" id="matchForm">
		<form:hidden path="id"/>
		<form:hidden path="version"/>
	        <input type="hidden" id="course" name="course" value="<c:out value="${match.course.id}"/>" />
			<input type="hidden" id="played" name="played"
				value="<fmt:formatDate pattern="MM/dd/yyyy" value="${match.played}"/>"/>
			<c:if test="${not match.defaultWin}">
			<form:hidden path="score.player1Hole1Par"/>
			<form:hidden path="score.player1Hole2Par"/>
			<form:hidden path="score.player1Hole3Par"/>
			<form:hidden path="score.player1Hole4Par"/>
			<form:hidden path="score.player1Hole5Par"/>
			<form:hidden path="score.player1Hole6Par"/>
			<form:hidden path="score.player1Hole7Par"/>
			<form:hidden path="score.player1Hole8Par"/>
			<form:hidden path="score.player1Hole9Par"/>
			<form:hidden path="score.player1Hole10Par"/>
			<form:hidden path="score.player1Hole11Par"/>
			<form:hidden path="score.player1Hole12Par"/>
			<form:hidden path="score.player1Hole13Par"/>
			<form:hidden path="score.player1Hole14Par"/>
			<form:hidden path="score.player1Hole15Par"/>
			<form:hidden path="score.player1Hole16Par"/>
			<form:hidden path="score.player1Hole17Par"/>
			<form:hidden path="score.player1Hole18Par"/>
			
			<form:hidden path="score.player1Hole1Stroke"/>
			<form:hidden path="score.player1Hole2Stroke"/>
			<form:hidden path="score.player1Hole3Stroke"/>
			<form:hidden path="score.player1Hole4Stroke"/>
			<form:hidden path="score.player1Hole5Stroke"/>
			<form:hidden path="score.player1Hole6Stroke"/>
			<form:hidden path="score.player1Hole7Stroke"/>
			<form:hidden path="score.player1Hole8Stroke"/>
			<form:hidden path="score.player1Hole9Stroke"/>
			<form:hidden path="score.player1Hole10Stroke"/>
			<form:hidden path="score.player1Hole11Stroke"/>
			<form:hidden path="score.player1Hole12Stroke"/>
			<form:hidden path="score.player1Hole13Stroke"/>
			<form:hidden path="score.player1Hole14Stroke"/>
			<form:hidden path="score.player1Hole15Stroke"/>
			<form:hidden path="score.player1Hole16Stroke"/>
			<form:hidden path="score.player1Hole17Stroke"/>
			<form:hidden path="score.player1Hole18Stroke"/>
			
			<form:hidden path="score.player1Hole1Score"/>
			<form:hidden path="score.player1Hole2Score"/>
			<form:hidden path="score.player1Hole3Score"/>
			<form:hidden path="score.player1Hole4Score"/>
			<form:hidden path="score.player1Hole5Score"/>
			<form:hidden path="score.player1Hole6Score"/>
			<form:hidden path="score.player1Hole7Score"/>
			<form:hidden path="score.player1Hole8Score"/>
			<form:hidden path="score.player1Hole9Score"/>
			<form:hidden path="score.player1Hole10Score"/>
			<form:hidden path="score.player1Hole11Score"/>
			<form:hidden path="score.player1Hole12Score"/>
			<form:hidden path="score.player1Hole13Score"/>
			<form:hidden path="score.player1Hole14Score"/>
			<form:hidden path="score.player1Hole15Score"/>
			<form:hidden path="score.player1Hole16Score"/>
			<form:hidden path="score.player1Hole17Score"/>
			<form:hidden path="score.player1Hole18Score"/>
			
			<form:hidden path="score.player2Hole1Par"/>
			<form:hidden path="score.player2Hole2Par"/>
			<form:hidden path="score.player2Hole3Par"/>
			<form:hidden path="score.player2Hole4Par"/>
			<form:hidden path="score.player2Hole5Par"/>
			<form:hidden path="score.player2Hole6Par"/>
			<form:hidden path="score.player2Hole7Par"/>
			<form:hidden path="score.player2Hole8Par"/>
			<form:hidden path="score.player2Hole9Par"/>
			<form:hidden path="score.player2Hole10Par"/>
			<form:hidden path="score.player2Hole11Par"/>
			<form:hidden path="score.player2Hole12Par"/>
			<form:hidden path="score.player2Hole13Par"/>
			<form:hidden path="score.player2Hole14Par"/>
			<form:hidden path="score.player2Hole15Par"/>
			<form:hidden path="score.player2Hole16Par"/>
			<form:hidden path="score.player2Hole17Par"/>
			<form:hidden path="score.player2Hole18Par"/>
			
			<form:hidden path="score.player2Hole1Stroke"/>
			<form:hidden path="score.player2Hole2Stroke"/>
			<form:hidden path="score.player2Hole3Stroke"/>
			<form:hidden path="score.player2Hole4Stroke"/>
			<form:hidden path="score.player2Hole5Stroke"/>
			<form:hidden path="score.player2Hole6Stroke"/>
			<form:hidden path="score.player2Hole7Stroke"/>
			<form:hidden path="score.player2Hole8Stroke"/>
			<form:hidden path="score.player2Hole9Stroke"/>
			<form:hidden path="score.player2Hole10Stroke"/>
			<form:hidden path="score.player2Hole11Stroke"/>
			<form:hidden path="score.player2Hole12Stroke"/>
			<form:hidden path="score.player2Hole13Stroke"/>
			<form:hidden path="score.player2Hole14Stroke"/>
			<form:hidden path="score.player2Hole15Stroke"/>
			<form:hidden path="score.player2Hole16Stroke"/>
			<form:hidden path="score.player2Hole17Stroke"/>
			<form:hidden path="score.player2Hole18Stroke"/>
			
			<form:hidden path="score.player2Hole1Score"/>
			<form:hidden path="score.player2Hole2Score"/>
			<form:hidden path="score.player2Hole3Score"/>
			<form:hidden path="score.player2Hole4Score"/>
			<form:hidden path="score.player2Hole5Score"/>
			<form:hidden path="score.player2Hole6Score"/>
			<form:hidden path="score.player2Hole7Score"/>
			<form:hidden path="score.player2Hole8Score"/>
			<form:hidden path="score.player2Hole9Score"/>
			<form:hidden path="score.player2Hole10Score"/>
			<form:hidden path="score.player2Hole11Score"/>
			<form:hidden path="score.player2Hole12Score"/>
			<form:hidden path="score.player2Hole13Score"/>
			<form:hidden path="score.player2Hole14Score"/>
			<form:hidden path="score.player2Hole15Score"/>
			<form:hidden path="score.player2Hole16Score"/>
			<form:hidden path="score.player2Hole17Score"/>
			<form:hidden path="score.player2Hole18Score"/>
			
			<form:hidden path="score.stroke1"/>
			<form:hidden path="score.stroke2"/>
			<form:hidden path="score.stroke3"/>
			<form:hidden path="score.stroke4"/>
			<form:hidden path="score.stroke5"/>
			<form:hidden path="score.stroke6"/>
			<form:hidden path="score.stroke7"/>
			<form:hidden path="score.stroke8"/>
			<form:hidden path="score.stroke9"/>
			<form:hidden path="score.stroke10"/>
			<form:hidden path="score.stroke11"/>
			<form:hidden path="score.stroke12"/>
			<form:hidden path="score.stroke13"/>
			<form:hidden path="score.stroke14"/>
			<form:hidden path="score.stroke15"/>
			<form:hidden path="score.stroke16"/>
			<form:hidden path="score.stroke17"/>
			<form:hidden path="score.stroke18"/>
			
			<form:hidden path="score.score1"/>
			<form:hidden path="score.score2"/>
			<form:hidden path="score.score3"/>
			<form:hidden path="score.score4"/>
			<form:hidden path="score.score5"/>
			<form:hidden path="score.score6"/>
			<form:hidden path="score.score7"/>
			<form:hidden path="score.score8"/>
			<form:hidden path="score.score9"/>
			<form:hidden path="score.score10"/>
			<form:hidden path="score.score11"/>
			<form:hidden path="score.score12"/>
			<form:hidden path="score.score13"/>
			<form:hidden path="score.score14"/>
			<form:hidden path="score.score15"/>
			<form:hidden path="score.score16"/>
			<form:hidden path="score.score17"/>
			<form:hidden path="score.score18"/>
			
			<form:hidden path="score.golfer1Handicap"/>
			<form:hidden path="score.golfer2Handicap"/>
			</c:if>
			
			<c:if test="${match.defaultWin}">
				<input type="hidden" name="defaultWin" value="true"/>
			</c:if>
			
			<div class="left">
				<c:if test="${(null != match.bracketEntry) && match.result.tie}">
			       	<div style="margin-bottom:12px;">
			       		<carter:label styleClass="desc" key="results.extraholes"/>
			       		<form:errors path="puttoffWinner" cssClass="fieldError"/>
						<input type="radio" name="puttoffWinner" value="<c:out value="${match.golfer1.id}"/>"/><c:out value="${match.golfer1.fullName}"/>
			       		<input type="radio" name="puttoffWinner" value="<c:out value="${match.golfer2.id}"/>"/><c:out value="${match.golfer2.fullName}"/>
			   		</div>
				</c:if>
				<div class="buttons">
					<div class="left">
						<carter:button onclick="document.getElementById('bSave').value='true';document.getElementById('matchForm').submit();return true;" key="button.save"/>
					</div>
					<div class="left">
						<carter:button onclick="document.getElementById('bBack').value='true';document.getElementById('matchForm').submit();return false;" key="button.back"/>
					</div>
					<input id="bBack" type="hidden" name="bBack" value="false"/>
					<input id="bSave" type="hidden" name="bSave" value="false"/>
					<c:if test="${isAdministrator}">
					<input id="user_id" type="hidden" name="user_id" value="<c:out value='${user.id}'/>"/>
					</c:if>
					<div class="clear"></div>
					<p><fmt:message key="results.verifyMessage"/></p>
			    </div>
	        </div>
		</form:form>
	</div>
</c:otherwise>
</c:choose>

</c:if>