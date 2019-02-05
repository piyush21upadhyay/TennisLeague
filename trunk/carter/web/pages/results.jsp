<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="results.title"/></title>
    <meta name="menu" content="PostResults"/>
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/${appConfig["csstheme"]}/scorecard2.css'/>" />
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/${appConfig["csstheme"]}/jquery.ui.datepicker.css'/>" />
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/${appConfig["csstheme"]}/main.css'/>" />
<c:if test="${enterScores}">
	<script type="text/javascript">
	$(function() {
		$("#player1set1").focus();
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
	
	$(".inputs").keyup(function () {
        if (this.value.length == this.maxLength) {
          $(this).next('.inputs').focus();
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
			{
				cglAlert('Invalid Action',"Played date should be current or past date",300);
				return;
			}
		}
		else
			cglAlert('Invalid Action',"Played date should be in 'mm/dd/yyyy' format.",300);
		
		
		var player1set1 = $("#player1set1").val();
		var player2set1 = $("#player2set1").val();
		var player1set2 = $("#player1set2").val();
		var player2set2 = $("#player2set2").val();
		var player1set3 = $("#player1set3").val();
		var player2set3 = $("#player2set3").val();
		
		var player1set1sup = $("#player1set1sup").val();
		var player2set1sup = $("#player2set1sup").val();
		var player1set2sup = $("#player1set2sup").val();
		var player2set2sup = $("#player2set2sup").val();
		var player1set3sup = $("#player1set3sup").val();
		var player2set3sup = $("#player2set3sup").val();
		
		var isValid = new Boolean(true);
		
		if(player1set1 > 7 || player2set1 > 7 || player1set2 > 7 || player2set2 > 7 || player1set3 > 7 || player2set3 > 7)
		{
			cglAlert('Invalid Action',"Please enter a valid score.",300);
			return;
		}
		
		// set 1 validate
		if(player1set1 > player2set1)
			isValid = checkValidScores(player1set1,player2set1,player1set1sup,player2set1sup);
		else if(player2set1 > player1set1)
			isValid = checkValidScores(player2set1,player1set1,player2set1sup,player1set1sup);
		else
		{
			cglAlert('Invalid Action',"Please enter a valid score.",300);
			return;
		}
		
		
		if(!isValid)
			return;
		
		// set 2 validate
		if(player1set2 > player2set2)
			isValid = checkValidScores(player1set2,player2set2,player1set2sup,player2set2sup);
		else if(player2set2 > player1set2)
			isValid = checkValidScores(player2set2,player1set2,player2set2sup,player1set2sup);
		else
		{
			cglAlert('Invalid Action',"Please enter a valid score.",300);
			return;
		}
		
		
		if(!isValid)
			return;
		
		// set 3 validate
		if(player1set3 > player2set3)
			isValid = checkValidScores(player1set3,player2set3,player1set3sup,player2set3sup);
		else if(player2set3 > player1set3)
			isValid = checkValidScores(player2set3,player1set3,player2set3sup,player1set3sup);
		else
		{
			cglAlert('Invalid Action',"Please enter a valid score.",300);
			return;
		}
		
		if(!isValid)
			return;
		
		document.getElementById('bVerify').value = 'true';
		document.getElementById('matchForm').submit();
		
	}
	
	function checkValidScores(player1score, player2score, player1tiescore, player2tiescore)
	{
		if(player1score < 6)
		{
			cglAlert('Invalid Action',"Please enter a valid score.",300);
			return false;
		}
		
		if(player1score == 7 && player2score == 6)
		{
			if(player1tiescore < 7)
			{
				cglAlert('Invalid Action',"Please enter a valid tie braker score.",300);
				return false;
			}
			if(player1tiescore - player2tiescore < 2)
			{
				cglAlert('Invalid Action',"Please enter a valid tie braker score.",300);
				return false;
			}
			if(player1tiescore > 7 && (player1tiescore - player2tiescore > 2))
			{
				cglAlert('Invalid Action',"Please enter a valid tie braker score.",300);
				return false;
			}
			
		}
		else
		{
			if(player1tiescore != 0 || player2tiescore != 0)
			{
				cglAlert('Invalid Action',"Please enter a valid score.",300);
				return false;
			}
		}
		
		if((player1score - player2score) < 2)
		{
			if(player1score != 7 || player2score != 6)
			{
				cglAlert('Invalid Action',"Please enter a valid score.",300);
				return false;
			}
		}
		else if((player1score - player2score) > 1)
		{
			if(player1score == 7 && player2score != 5)
			{
				cglAlert('Invalid Action',"Please enter a valid score.",300);
				return false;
			}
		}
		
		return true;
	}
	
	</script>
</c:if>

<style type="text/css">
				body{
					background: #eee
				}
				.container{
					font-family:Arial, Helvetica, sans-serif;
					 background: #fff;
				}
				.component-page{
					  width: 100%;
					padding: 10px 0px;
					overflow: hidden;
				}
	 
				table.entering td {
					border: none;
					font-weight: 700;
					text-align: left;
				}

				table.entering td.firstChild {
					text-align: left;
					text-transform: uppercase
				} 
				.column-3 {
					width: 31%;
					float: left;
					margin-right: 20px;
				}
				.column-3:last-child {
					margin-right: 0px;
				}
				.entering-details{
					 margin: 20px 0px;   
				}
				 .entering-details th{
					 margin: 20px 0px;
				 }
				  .entering-details td{
					 padding: 10px;
				 }
				  .entering-details  input[type="text"], .entering-details input[type="date"] {
					padding: 6px;
					border: 1px solid #d7d7d7;
					color: #474747;
				}
				.entering {
					margin: 20px 0px;
				}  
				.entering tr {
					line-height: 60px;
				}  

				 .num-input{
					width: 40px;
					height: 40px;
					line-height: 14px;
					font-size: 14px;
					font-weight: normal;
					text-align: center;
					border: 1px solid #d7d7d7;
					margin: 8px;
				}

				  .super-input {
					vertical-align: super;
					position: relative;
					top: -10px;
					margin-right: 10px;
					width: 20px;
					margin-top: 18px;
				}
				
				.super-input input{
				   width: 30px;
				   height: 30px;
					line-height: 14px;
					font-size: 12px;
					font-weight: normal;
					text-align: center;
					border: 1px solid #d7d7d7;
				}
				
				.super-input-bottom {
					vertical-align: super;
					position: relative;
					top: -10px;
					margin-right: 10px;
					width: 20px;
					margin-top: 38px;
				}
				
				.super-input-bottom input{
				   width: 30px;
				   height: 30px;
					line-height: 14px;
					font-size: 12px;
					font-weight: normal;
					text-align: center;
					border: 1px solid #d7d7d7;
				}
				
				.onecolw {
					float:left;
					width:30px;
					margin:0 5px 10px;
					padding:10px;
					font-size:12px;
					color:#fff;
					line-height:20px;
				}
				
				.namecolw {
					float:left;
					width:30px;
					margin:0 5px 10px;
					padding:10px;
					font-size:12px;
					color:#fff;
					line-height:20px;
				}
				
				.textAlign {
					width: 70px;
				    height: 40px;
				    margin-top: 17px;
				    text-align: center;
				}

</style>
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
							<%-- <c:out value="${match.result.winner.currentWins}"/>-<c:out value="${match.result.winner.currentLosses}"/> --%>
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
	
	<!-- Post Results Screen starts -->
	<c:choose>
	<c:when test="${enterScores}">
		<form:form commandName="match" method="post" action="results.html" id="matchForm">
			<form:hidden path="id"/>
				<form:hidden path="version"/>

			<div class="section">
				<div id="played-info">
					<%-- <label for="course"><fmt:message key="results.course"/></label>
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
							<!-- TODO: Akash -->
							<c:otherwise>
								<c:forEach var="course" items="${courseList}">
									<option value="<c:out value='${course.id}'/>"
										<c:if test="${match.golfer1.homeCourse.id == course.id}"><c:out escapeXml="false" value=" selected='selected'"/></c:if>><c:out value="${course.name}"/>
									</option>
								</c:forEach>
							</c:otherwise>
						</c:choose>
			        </form:select>--%>
					<label for="played"><fmt:message key="results.datePlayed"/></label>
					<input type="text" id="played" name="played" maxlength="12"
						value="<fmt:formatDate value="${match.played}" pattern="MM/dd/yyyy"/>"/>
				</div> 
			</div>
			
			<!-- Changes done by Akash & Piyush -->
			<div class="section">
				<div class="card">
				<div class="edituser-section">
					<div class="namecolw">
						<p class="textAlign"><b><c:out value="${match.golfer1.displayName}"/> &nbsp;</b></p>
						<p class="textAlign"><b><c:out value="${match.golfer2.displayName}"/> &nbsp;</b></p>
	 				</div>
	 				
	 				
				
					<div class="onecolw">
	 					<fieldset>
	 						<form:input cssClass="num-input" maxlength="1" path="score.player1set1" id="player1set1" onkeyup="autotab(this,document.getElementById('score.player1set1'))"/>
	 						<form:input cssClass="num-input" maxlength="1" path="score.player2set1" id="player2set1" onkeyup="autotab(this,document.getElementById('score.player2set1'))"/>
	 					</fieldset>
	 				</div>
	 				<div class="onecolw">
	 					<fieldset>
	 						<form:input cssClass="super-input" maxlength="2" path="score.player1set1Sup" id="player1set1sup" onkeyup="autotab(this,document.getElementById('score.player1set1Sup'))"/>
	 						<form:input cssClass="super-input-bottom" maxlength="2" path="score.player2set1Sup" id="player2set1sup" onkeyup="autotab(this,document.getElementById('score.player2set1Sup'))"/>
	 					</fieldset>
	 				</div>
	 				
	 				<div class="onecolw">
	 					<fieldset>
	 						<form:input cssClass="num-input" maxlength="1" path="score.player1set2" id="player1set2" onkeyup="autotab(this,document.getElementById('score.player1set2'))"/>
	 						<form:input cssClass="num-input" maxlength="1" path="score.player2set2" id="player2set2" onkeyup="autotab(this,document.getElementById('score.player2set2'))"/>
	 					</fieldset>
	 				</div>
	 				<div class="onecolw">
	 					<fieldset>
	 						<form:input cssClass="super-input" maxlength="2" path="score.player1set2Sup" id="player1set2sup" onkeyup="autotab(this,document.getElementById('score.player1set2Sup'))"/>
	 						<form:input cssClass="super-input-bottom" maxlength="2" path="score.player2set2Sup" id="player2set2sup" onkeyup="autotab(this,document.getElementById('score.player2set2Sup'))"/>
	 					</fieldset>
	 				</div>
	 				
	 				<div class="onecolw">
	 					<fieldset>
	 						<form:input cssClass="num-input" maxlength="1" path="score.player1set3" id="player1set3" onkeyup="autotab(this,document.getElementById('score.player1set3'))"/>
	 						<form:input cssClass="num-input" maxlength="1" path="score.player2set3" id="player2set3" onkeyup="autotab(this,document.getElementById('score.player2set3'))"/>
	 					</fieldset>
	 				</div>
	 				<div class="onecolw">
	 					<fieldset>
	 						<form:input cssClass="super-input" maxlength="2" path="score.player1set3Sup" id="player1set3sup" onkeyup="autotab(this,document.getElementById('score.player1set3Sup'))"/>
	 						<form:input cssClass="super-input-bottom" maxlength="2" path="score.player2set3Sup" id="player2set3sup" onkeyup="autotab(this,document.getElementById('score.player2set3Sup'))"/>
	 					</fieldset>
	 				</div>
 				</div>
			</div>
			</div>
			<!-- Changes done by Akash & Piyush Ends -->
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
							<p><fmt:message key="members.homeCourt"/> <a class="course-link" href="<c:url value="/coursedetails.html?id="/><c:out value="${match.golfer1.homeCourtText}"/>"><c:out value="${match.golfer1.homeCourtText}"/></a></p>
							
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
							<p><fmt:message key="members.homeCourt"/> <a class="course-link" href="<c:url value="/coursedetails.html?id="/><c:out value="${match.golfer2.homeCourtText}"/>"><c:out value="${match.golfer2.homeCourtText}"/></a></p>
							
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
<!-- Post Results Screen ends -->
		</form:form>
			
	</c:when>
<c:otherwise>
	<c:if test="${not match.defaultWin}">
	<div class="section">
		<c:import url="/common/postResultScreen.jsp"/>
		<%-- <div class="right">
			<c:import url="/common/legend.jsp"/>
		</div> --%>
	</div>
	<div class="clear"></div>
	</c:if>
	
	<div class="section">
		<form:form commandName="match" method="post" action="results.html" id="matchForm">
		<form:hidden path="id"/>
		<form:hidden path="version"/>
	        <%-- <input type="hidden" id="course" name="course" value="<c:out value="${match.course.id}"/>" /> --%>
			<input type="hidden" id="played" name="played"
				value="<fmt:formatDate pattern="MM/dd/yyyy" value="${match.played}"/>"/>
			<c:if test="${not match.defaultWin}">
				<form:hidden path="score.player1set1"/>
				<form:hidden path="score.player1set2"/>
				<form:hidden path="score.player1set3"/>
				<form:hidden path="score.player2set1"/>
				<form:hidden path="score.player2set2"/>
				<form:hidden path="score.player2set3"/>
				
				<form:hidden path="score.player1set1Sup"/>
				<form:hidden path="score.player1set2Sup"/>
				<form:hidden path="score.player1set3Sup"/>
				<form:hidden path="score.player2set1Sup"/>
				<form:hidden path="score.player2set2Sup"/>
				<form:hidden path="score.player2set3Sup"/>
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