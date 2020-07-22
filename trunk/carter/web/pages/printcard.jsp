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
		//$("#player1set1").val("");
		$("#played").datepicker({showOn: 'button', buttonImage: 'images/calendar-icon.jpg', buttonImageOnly: true});
		
		//fix for safari
		if(window.devicePixelRatio)
		{
			$(".ui-datepicker-trigger").css({
				width: 26,
				height: 21
			});
		}
		
		// on page load, check for opponent retired
		boxDisable();
	});
	
	$(".inputs").keyup(function () {
        if (this.value.length == this.maxLength) {
          $(this).next('.inputs').focus();
        }
  });
	
	
	</script>
</c:if>

<style type="text/css">
							body{
					background: #fff;
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
					top: -20px;
					margin-right: 10px;
					width: 20px;
					margin-top: 38px;
					 text-align: center;
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
					float: left;
					width: 60px;
					margin: 10px 0px 10px;
					padding: 10px 0px;
					font-size: 12px;
					color: #fff;
					line-height: 20px;
				}
				
				.namecolw {
					float:left;
					width:33%;
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
	<%-- <c:choose>
	<c:when test="${enterScores}"> --%>
		<form:form commandName="match" method="post" action="results.html" id="matchForm">
			<form:hidden path="id"/>
				<form:hidden path="version"/>
          <h2 class="page-title"> Schedule</h2>
		  <div class="row">   
			<div class="section col-sm-4">
			     <div class="heading-golfer">
				  <div id="played-info">
					<label for="played"><fmt:message key="results.datePlayed"/>
					</label><img src="images/date-played.png" alt="">
					</div>	
				</div> 
				<input type="text" id="played" name="played" maxlength="12"	value=""/>
			</div>
			
			<!-- Changes done by Akash & Piyush -->
			<div class="section col-sm-8">
			<div class=" heading-golfer">
	               <label> Post Scores
					</label>
						<img src="images/score.png" alt=""> 
						</div>
				<div class="card">
				<div class="edituser-section">
					<div class="namecolw">
						<p class="textAlign"><b><c:out value="${match.golfer1.displayName}"/> &nbsp;</b></p>
						<p class="textAlign"><b><c:out value="${match.golfer2.displayName}"/> &nbsp;</b></p>
	 				</div>
	 				
	 				
				
					<div class="onecolw oneBigBox">
	 					<fieldset>
	 						<!-- <input cssClass="num-input" maxlength="1" id="player1set1"> -->
	 						<form:input cssClass="num-input" maxlength="1" path="score.opponentRetired" id="player1set1" />
	 						<form:input cssClass="num-input" maxlength="1" path="score.opponentRetired" id="player2set1" />
	 					</fieldset>
	 				</div>
	 				<div class="onecolw oneSmallBox">
	 					<fieldset>
	 						<form:input cssClass="super-input" maxlength="2" path="score.opponentRetired" id="player1set1sup" />
	 						<form:input cssClass="super-input-bottom" maxlength="2" path="score.opponentRetired" id="player2set1sup" />
	 					</fieldset>
	 				</div>
	 				
	 				<div class="onecolw oneBigBox">
	 					<fieldset>
	 						<form:input cssClass="num-input" maxlength="1" path="score.opponentRetired" id="player1set2" />
	 						<form:input cssClass="num-input" maxlength="1" path="score.opponentRetired" id="player2set2" />
	 					</fieldset>
	 				</div>
	 				<div class="onecolw oneSmallBox">
	 					<fieldset>
	 						<form:input cssClass="super-input" maxlength="2" path="score.opponentRetired" id="player1set2sup" />
	 						<form:input cssClass="super-input-bottom" maxlength="2" path="score.opponentRetired" id="player2set2sup" />
	 					</fieldset>
	 				</div>
	 				
	 				<div class="onecolw oneBigBox">
	 					<fieldset>
	 						<form:input cssClass="num-input" maxlength="1" path="score.opponentRetired" id="player1set3" />
	 						<form:input cssClass="num-input" maxlength="1" path="score.opponentRetired" id="player2set3" />
	 					</fieldset>
	 				</div>
	 				<div class="onecolw oneSmallBox">
	 					<fieldset>
	 						<form:input cssClass="super-input" maxlength="2" path="score.opponentRetired" id="player1set3sup" />
	 						<form:input cssClass="super-input-bottom" maxlength="2" path="score.opponentRetired" id="player2set3sup"/>
	 					</fieldset>
	 				</div>
	 	
 				</div>
				<div class="shadow opponentSection">
			     <!-- Changes for Opponent Required -->
	 				<div class="onecolw">
	 					<fieldset>
	 						<form:checkbox path="score.opponentRetired" value="1" id="opponentRetired" onclick="boxDisable();"/> 
	 						<label class="checkboxlabel"><fmt:message key="results.opponentRetired"/></label>
	 					</fieldset>
	 				</div>
				</div>
			</div>
			</div>
			</div>
			<!-- Changes done by Akash & Piyush Ends -->
			<div class="clear"></div>
			<div id="result-members">
			    <div class="row">
				<div class="col-sm-3">
					<h3><fmt:message key="results.homePlayer"/></h3>
					<div class="player-info">
						<div class="left"><img src="<c:url value="${match.golfer1.icon}"/>" alt="member"/></div>
						<div class="center">
							<h2 class="center">&nbsp;<strong><c:out value="${match.golfer1.displayName}"/></strong></h2>
						</div>
						<div class="center profile-btn">
							<c:set var="url"><c:url value="/profile.html"/></c:set>
							<carter:button page="${url}" param="id=${match.golfer1.id}&amp;msg=false" key="members.profile"/>
						</div>
						<div style="clear:both">
							<h4 class="center" style="padding: 10px 0px;"><c:out value="${match.golfer1.currentSeason.division}"/></h4>
							<p class="center"><fmt:message key="members.homeCourt"/> <a class="course-link" href="<c:url value="/coursedetails.html?id="/><c:out value="${match.golfer1.homeCourtText}"/>"><c:out value="${match.golfer1.homeCourtText}"/></a></p>
							
							<p class="center"><fmt:message key="members.seasonRecord"/> <a href="<c:url value="/record.html?id="/><c:out value="${match.golfer1.id}"/>"><c:out value="${match.golfer1.currentWins}"/>-<c:out value="${match.golfer1.currentLosses}"/></a></p>
							<p class="center">
							<a class="msg-link" href="<c:url value="/schedule.html?id="/><c:out value="${match.golfer1.id}"/>">
								<fmt:message key="members.schedule">
									<fmt:param value="${match.golfer1.firstName}"/>
								</fmt:message>
							</a>
							</p>
						</div>
					</div>
			    </div>
				<div class="col-sm-3">
					<h3><fmt:message key="results.awayPlayer"/></h3>
					<div class="player-info">
						<div class="left"><img src="<c:url value="${match.golfer2.icon}"/>" alt="member"/></div>
						<div class="center">
							<h2 class="center">&nbsp;<strong><c:out value="${match.golfer2.displayName}"/></strong></h2>
						</div>
						<div class="center profile-btn">
							<c:set var="url"><c:url value="/profile.html"/></c:set>
							<carter:button page="${url}" param="id=${match.golfer2.id}&amp;msg=false" key="members.profile"/>
						</div>
						<div class="center" style="clear:both">
							<h4 class="center" style="padding: 10px 0px;"><c:out value="${match.golfer2.currentSeason.division}"/></h4>
							<p class="center"><fmt:message key="members.homeCourt"/> <a class="course-link" href="<c:url value="/coursedetails.html?id="/><c:out value="${match.golfer2.homeCourtText}"/>"><c:out value="${match.golfer2.homeCourtText}"/></a></p>
							
							<p class="center"><fmt:message key="members.seasonRecord"/> <a href="<c:url value="/record.html?id="/><c:out value="${match.golfer2.id}"/>"><c:out value="${match.golfer2.currentWins}"/>-<c:out value="${match.golfer2.currentLosses}"/></a></p>
							<p class="center">
							<a class="msg-link center" href="<c:url value="/schedule.html?id="/><c:out value="${match.golfer2.id}"/>">
								<fmt:message key="members.schedule">
									<fmt:param value="${match.golfer2.firstName}"/>
								</fmt:message>
							</a>
							</p>
						</div>
					</div>
			    </div>
				</div>
			</div>
			<div class="section" style="margin-top: 40px">
				<div class="buttons">
					
					<div class="post-btn left" >
						<carter:button onclick="window.print();" key="schedule.print"/>
					</div>
					<!-- <br></br> -->
					<div class="right" >
						<hr width="120px" ><p align="center"><c:out value="${match.golfer1.firstName}"/>'s Signature</p>
					</div>
					<div class="right" >
						<hr width="120px"><p align="center"><c:out value="${match.golfer2.firstName}"/>'s Signature</p>
					</div>
					<div class="clear"></div>
					<c:if test="${isAdministrator}">
					<input id="user_id" type="hidden" name="user_id" value="<c:out value='${user.id}'/>"/>
					</c:if>
					<div class="clear"></div>
				</div>
			</div>
<!-- Post Results Screen ends -->
		</form:form>

</c:if>