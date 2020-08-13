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
		 $("#match-date-picker").datepicker({
			maxDate: new Date(),
		    onSelect: function(dateText) {
		      $('#played').val(dateText);
		    }
		  });
		
		//fix for safari
		if(window.devicePixelRatio)
		{
			$(".ui-datepicker-trigger").css({
				width: 26,
				height: 21
			});
		}
		
		// on page load, check for opponent retired
		//boxDisable();
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
		
		var isOpponentRetired = $('#opponentRetired').is(':checked'); 
		var isValid = new Boolean(true);
		var showAlert = new Boolean(true);
		//alert("player1set1=="+player1set1);
		//setTheScoresToZeroIfFieldsAreMadeBlank(player1set1,player2set1,player1set2,player2set2,player1set3,player2set3,player1set1sup);
		if(isOpponentRetired){
			// logic has to be applied when checkbox will be checked
			//alert(isOpponentRetired);
				if(player1set1 == 0 &&  player2set1 == 0 && player1set2 == 0 && player2set2 == 0)
				{
					cglAlert('Invalid Action',"Please enter a valid score for Opponent Retired.",300);
					return;
				}
				if(player1set1 > 7 || player2set1 > 7 || player1set2 > 7 || player2set2 > 7 || player1set3 > 6 || player2set3 > 6)
				{
					cglAlert('Invalid Action',"Please enter a valid score for Opponent Retired.",300);
					return;
				}
			
				// set 1 validate
				if(player1set1 > player2set1 && (player1set2 > 0 || player2set2 > 0))
					isValid = checkValidScores(player1set1,player2set1,player1set1sup,player2set1sup,showAlert);
				else if(player2set1 > player1set1 && (player1set2 > 0 || player2set2 > 0))
					isValid = checkValidScores(player2set1,player1set1,player2set1sup,player1set1sup,showAlert);
				else if(player1set2 > 0 || player2set2 > 0)
				{
					cglAlert('Invalid Action',"Please enter a valid score for Opponent Retired.",300);
					return;
				}
				//alert(isValid);
				
				if(!isValid)
					return;
				
				//set 2 validate
				if(player1set2 > player2set2 && (player1set3 > 0 || player2set3 > 0))
					isValid = checkValidScores(player1set2,player2set2,player1set2sup,player2set2sup,showAlert);
				else if(player2set2 > player1set2 && (player1set3 > 0 || player2set3 > 0))
					isValid = checkValidScores(player2set2,player1set2,player2set2sup,player1set2sup,showAlert);
				else if(player1set3 > 0 || player2set3 > 0)
				{
					cglAlert('Invalid Action',"Please enter a valid score for Opponent Retired.",300);
					return;
				}
				
				if(!isValid)
					return;
				
				var areFirstTwoSetsWon = new Boolean(false);
				areFirstTwoSetsWon=areTheFirstTwoSetsWon(player1set1,player2set1,player1set2,player2set2);
				
				if(areFirstTwoSetsWon)
				{
					showAlert = false;
					// again check set 2 scores are valid for straight win, if its a valid score then its
					// a straight win and is not valid for Opponent Retired scenario.
					if(player1set2 > player2set2)
						isValid = checkValidScores(player1set2,player2set2,player1set2sup,player2set2sup,showAlert);
					else if(player2set2 > player1set2)
						isValid = checkValidScores(player2set2,player1set2,player2set2sup,player1set2sup,showAlert);
					
					if(isValid)
					{
						cglAlert('Invalid Action',"This is a staright win, not valid for Opponet Retired",300);
						return;
					}
				}
				
				 if(player1set3 == 6)
				{
					if(player1set3 - player2set3 > 1)
						{
						cglAlert('Invalid Action',"Please enter a valid score for Opponent Retired.",300);
						return;
						}
				}
				else if(player2set3 == 6)
				{
					if(player2set3 - player1set3 > 1)
					{
						cglAlert('Invalid Action',"Please enter a valid score for Opponent Retired.",300);
						return;
					}
				} 
				
		}else{
			
			if(player1set1 > 7 || player2set1 > 7 || player1set2 > 7 || player2set2 > 7 || player1set3 > 7 || player2set3 > 7)
			{
				cglAlert('Invalid Action',"Please enter a valid score.Valid scores are:\n 6 6 6 6 6 6 7 7\n 0 1 2 3 4 5 6\n\nTiebreaker is first to 7 by 2",300);
				return;
			}
			
			// set 1 validate
			if(player1set1 > player2set1)
				isValid = checkValidScores(player1set1,player2set1,player1set1sup,player2set1sup,showAlert);
			else if(player2set1 > player1set1)
				isValid = checkValidScores(player2set1,player1set1,player2set1sup,player1set1sup,showAlert);
			else
			{
				cglAlert('Invalid Action',"Please enter a valid score.Valid scores are:\n 6 6 6 6 6 6 7 7\n 0 1 2 3 4 5 6\n\nTiebreaker is first to 7 by 2Valid scores are:\n 6 6 6 6 6 6 7 7\n0 1 2 3 4 5 6",300);
				return;
			}
			
			
			if(!isValid)
				return;
			
			// set 2 validate
			if(player1set2 > player2set2)
				isValid = checkValidScores(player1set2,player2set2,player1set2sup,player2set2sup,showAlert);
			else if(player2set2 > player1set2)
				isValid = checkValidScores(player2set2,player1set2,player2set2sup,player1set2sup,showAlert);
			else
			{
				cglAlert('Invalid Action',"Please enter a valid score.Valid scores are:\n 6 6 6 6 6 6 7 7\n 0 1 2 3 4 5 6\n\nTiebreaker is first to 7 by 2",300);
				return;
			}
			
			
			if(!isValid)
				return;
			
			var areFirstTwoSetsWon = new Boolean(false);
			areFirstTwoSetsWon=areTheFirstTwoSetsWon(player1set1,player2set1,player1set2,player2set2);
			//alert("areFirstTwoSetsWon::"+areFirstTwoSetsWon);
			
			if(!areFirstTwoSetsWon){
				// set 3 validate
				if(player1set3 > player2set3)
					isValid = checkValidScores(player1set3,player2set3,player1set3sup,player2set3sup,showAlert);
				else if(player2set3 > player1set3)
					isValid = checkValidScores(player2set3,player1set3,player2set3sup,player1set3sup,showAlert);
				else
				{
					cglAlert('Invalid Action',"Please enter a valid score.Valid scores are:\n 6 6 6 6 6 6 7 7\n 0 1 2 3 4 5 6\n\nTiebreaker is first to 7 by 2",300);
					return;
				}
				
				if(!isValid)
					return;
			}else{
				//show the error message if user enters any value>0 to third set
				if(player1set3>0 || player2set3>0 ||player1set3sup>0 || player2set3sup>0){
					cglAlert('Invalid Action',"The third set value should be zero as its a straight set win.",300);
					return;
				}
			}
		}
		
		
		document.getElementById('bVerify').value = 'true';
		document.getElementById('matchForm').submit();
		
	}
	
	function areTheFirstTwoSetsWon(player1set1,player2set1,player1set2,player2set2){
		//alert("hello");
		if((player1set1>player2set1 && player1set2>player2set2) || (player2set1>player1set1 && player2set2>player1set2))
			return true;
	}
	
	function boxDisable(){
		//var isOpponentRetired = $("#opponentRetired").val();
		var isOpponentRetired = $('#opponentRetired').is(':checked'); 
		if(isOpponentRetired){
			$('#player1set3').attr("disabled", true);
			$('#player2set3').attr("disabled", true);
			$('#player1set3sup').attr("disabled", true);
			$('#player2set3sup').attr("disabled", true); 
		}
		else{
			$('#player1set3').attr("disabled", false);
			$('#player2set3').attr("disabled", false);
			$('#player1set3sup').attr("disabled", false);
			$('#player2set3sup').attr("disabled", false); 
		}
	}
	
	function checkValidScores(player1score, player2score, player1tiescore, player2tiescore, doShowAlert)
	{
		if(player1score=='' || player2score=='' || player1tiescore=='' ||player2tiescore==''){
			if(doShowAlert)
				cglAlert('Invalid Action',"The value of the score box cannot be empty.",300);
			return false;
		}
		
		if(player1score < 6)
		{
			if(doShowAlert)
				cglAlert('Invalid Action',"Please enter a valid score.Valid scores are:\n 6 6 6 6 6 6 7 7\n 0 1 2 3 4 5 6\n\nTiebreaker is first to 7 by 2",300);
			return false;
		}
		
		if(player1score == 7 && player2score == 6)
		{
			if(player1tiescore < 7)
			{
				if(doShowAlert)
					cglAlert('Invalid Action',"Please enter a valid tie braker score.",300);
				return false;
			}
			if(player1tiescore - player2tiescore < 2)
			{
				if(doShowAlert)
					cglAlert('Invalid Action',"Please enter a valid tie braker score.",300);
				return false;
			}
			if(player1tiescore > 7 && (player1tiescore - player2tiescore > 2))
			{
				if(doShowAlert)
					cglAlert('Invalid Action',"Please enter a valid tie braker score.",300);
				return false;
			}
			
		}
		else
		{
			if(player1tiescore != 0 || player2tiescore != 0)
			{
				if(doShowAlert)
					cglAlert('Invalid Action',"Please enter a valid score.Valid scores are:\n 6 6 6 6 6 6 7 7\n 0 1 2 3 4 5 6\n\nTiebreaker is first to 7 by 2",300);
				return false;
			}
		}
		
		if((player1score - player2score) < 2)
		{
			if(player1score != 7 || player2score != 6)
			{
				if(doShowAlert)
					cglAlert('Invalid Action',"Please enter a valid score.Valid scores are:\n 6 6 6 6 6 6 7 7\n 0 1 2 3 4 5 6\n\nTiebreaker is first to 7 by 2",300);
				return false;
			}
		}
		else if((player1score - player2score) > 1)
		{
			
			if(player1score == 7 && player2score != 5)
			{
				if(doShowAlert)
					cglAlert('Invalid Action',"Please enter a valid score.Valid scores are:\n 6 6 6 6 6 6 7 7\n 0 1 2 3 4 5 6\n\nTiebreaker is first to 7 by 2",300);
				return false;
			}
		}
		
		return true;
	}
	
	</script>
</c:if>

<style type="text/css">
				body{
					background: #fff;
				}
				.container{
					font-family:Arial, Helvetica, sans-serif;
					/* background: #fff;*/
				}
				.component-page{
					 width: 100%;
					padding: 10px 0px;
					/*overflow: hidden;*/
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
				div#ui-datepicker-div {
					display: block !important;
				    width: 400px;
				    height: 300px;
				    background: #fff;
				    border: none;
				    box-shadow: 0 .5rem 1rem rgba(0,0,0,.15)!important;
				    padding: 0 !important;
				    border-radius: 0;
				}
				.ui-datepicker-header {
				    padding: 20px;
				    background: #dedede !important;
				    border-radius: 0px;
				    border: none;
				    color: #666666;
				    font-size: 20px;
				    font-weight: normal;
				}
				.ui-datepicker .ui-datepicker-prev span {
				    top: 200%;
				    left: 20px;
				}
				.ui-datepicker .ui-datepicker-next span {
				    top: 200%;
				    right: 20px;
				}
				.ui-state-default, .ui-widget-content .ui-state-default {
				    background: none;
				    border: none;
				    /* padding: 11px; */
				}
				a.ui-state-default.ui-state-highlight.ui-state-active {
				    background: #dedede;
				    border-radius: 25px;
				    width: 30px;
				    height: 30px;
				    padding: 5px 2px;
				}
				.ui-datepicker td {
				    padding: 10px;
				}
				.ui-state-disabled td {}
				td.ui-datepicker-today {
				    /* width: 40px !important; */
				}
				table.ui-datepicker-calendar thead tr {
				    padding: 20px 0px !important;
				}
				.ui-datepicker th {
				    padding: 10px 0px 10px!important;
				    font-size: 16px;
				    font-weight: normal;
				}
				table.ui-datepicker-calendar {
				}
				.ui-datepicker { width:inherit;}
</style>
</head>

<c:if test="${not empty match}">

	<div class="section section-post">
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
						<c:when test="${(null != match.score.opponentRetired)}">
							<c:out value="${match.result.winner.fullName}"/> <fmt:message key="results.wins"/> <fmt:message key="results.opponentRetired"/>
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
			<h2 class="page-title"> Schedule</h2>
            <div class="row">    
				<div class="section col-sm-4">
					<div id="played-info">
						<div class=" heading-golfer">
			               <label for="played"><fmt:message key="results.datePlayed"/></label><img src="images/date-played.png" alt=""> 
						</div>
	
						 <input type="hidden" id="played" name="played" maxlength="12"
							value="<fmt:formatDate value="${match.played}" pattern="MM/dd/yyyy"/>"/> 
						
						<div id="match-date-picker"></div>
					</div> 
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
							<p class="textAlign"><img style="width: 50px;" src="<c:out value="${match.golfer1.icon}"/>"/><b><c:out value="${match.golfer1.displayName}"/> &nbsp;</b></p>
							<p class="textAlign"><img style="width: 50px;" src="<c:out value="${match.golfer2.icon}"/>"/><b><c:out value="${match.golfer2.displayName}"/> &nbsp;</b></p>
		 				</div>
		 				
		 				
					
						<div class="onecolw oneBigBox">
		 					<fieldset>
		 						<form:input cssClass="num-input" maxlength="1" path="score.player1set1" id="player1set1" onkeyup="autotab(this,document.getElementById('score.player1set1'))"/>
		 						<form:input cssClass="num-input" maxlength="1" path="score.player2set1" id="player2set1" onkeyup="autotab(this,document.getElementById('score.player2set1'))"/>
		 					</fieldset>
		 				</div>
		 				<div class="onecolw oneSmallBox">
		 					<fieldset>
		 						<form:input cssClass="super-input" maxlength="2" path="score.player1set1Sup" id="player1set1sup" onkeyup="autotab(this,document.getElementById('score.player1set1Sup'))"/>
		 						<form:input cssClass="super-input-bottom" maxlength="2" path="score.player2set1Sup" id="player2set1sup" onkeyup="autotab(this,document.getElementById('score.player2set1Sup'))"/>
		 					</fieldset>
		 				</div>
		 				
		 				<div class="onecolw oneBigBox">
		 					<fieldset>
		 						<form:input cssClass="num-input" maxlength="1" path="score.player1set2" id="player1set2" onkeyup="autotab(this,document.getElementById('score.player1set2'))"/>
		 						<form:input cssClass="num-input" maxlength="1" path="score.player2set2" id="player2set2" onkeyup="autotab(this,document.getElementById('score.player2set2'))"/>
		 					</fieldset>
		 				</div>
		 				<div class="onecolw oneSmallBox">
		 					<fieldset>
		 						<form:input cssClass="super-input" maxlength="2" path="score.player1set2Sup" id="player1set2sup" onkeyup="autotab(this,document.getElementById('score.player1set2Sup'))"/>
		 						<form:input cssClass="super-input-bottom" maxlength="2" path="score.player2set2Sup" id="player2set2sup" onkeyup="autotab(this,document.getElementById('score.player2set2Sup'))"/>
		 					</fieldset>
		 				</div>
		 				
		 				<div class="onecolw oneBigBox">
		 					<fieldset>
		 						<form:input cssClass="num-input" maxlength="1" path="score.player1set3" id="player1set3" onkeyup="autotab(this,document.getElementById('score.player1set3'))"/>
		 						<form:input cssClass="num-input" maxlength="1" path="score.player2set3" id="player2set3" onkeyup="autotab(this,document.getElementById('score.player2set3'))"/>
		 					</fieldset>
		 				</div>
		 				<div class="onecolw oneSmallBox">
		 					<fieldset>
		 						<form:input cssClass="super-input" maxlength="2" path="score.player1set3Sup" id="player1set3sup" onkeyup="autotab(this,document.getElementById('score.player1set3Sup'))"/>
		 						<form:input cssClass="super-input-bottom" maxlength="2" path="score.player2set3Sup" id="player2set3sup" onkeyup="autotab(this,document.getElementById('score.player2set3Sup'))"/>
		 					</fieldset>
		 				</div>
	 				</div>
					<div class="shadow opponentSection">
								<!-- Changes for Opponent Required -->
		 				<div class="onecolw">
		 					<fieldset>
		 						<form:checkbox path="score.opponentRetired" value="1" id="opponentRetired" /> 
		 						<label class="checkboxlabel"><fmt:message key="results.opponentRetired"/></label>
		 					</fieldset>
						</div>
						<div class="onecolw">
							<a class="msg-link"
								onclick="document.getElementById('bDefault').value='true';document.getElementById('matchForm').submit();return false;"
								href="javascript:{}"><fmt:message key="button.default" /></a>
						</div>
					</div>
				</div>
				</div>
			</div>
			<!-- Changes done by Akash & Piyush Ends -->
			<div class="clear"></div>
			<div class="section" style="margin-top: 40px">
				<div class="buttons">
			
					<div class="cancel-btn left">
						<carter:button onclick="document.getElementById('bCancel').value='true';document.getElementById('matchForm').submit();return false;" key="button.cancel"/>
					</div>
					<div class="post-btn left">
						<carter:button onclick="checkFields();" key="button.post" name="postButton"/>
					</div>
					<div class="clear"></div>
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
				<form:hidden path="score.opponentRetired"/>
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
					<div class="left post-btn">
						<carter:button onclick="document.getElementById('bSave').value='true';document.getElementById('matchForm').submit();return true;" key="button.save"/>
					</div>
					<div class="left cancel-btn">
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