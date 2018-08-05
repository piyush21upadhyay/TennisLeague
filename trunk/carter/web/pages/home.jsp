<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="home.title"/></title>
    <meta name="menu" content="Welcome"/>
    <script type="text/javascript" src="<c:url value='/scripts/jquery.marquee.js'/>"></script>
    <script type="text/javascript" src="scripts/swfobject.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			var objWeather = document.getElementById("home-weather");
			
			// Trim whitespace from left and right sides of s.
            function trim(s) {
                return s.replace( /^\s*/, "" ).replace( /\s*$/, "" );
            }
			
			try
		  	{
				<c:if test="${not empty weather}"><c:if test="${not empty weather.icon and not empty weather.high and not empty weather.low}">
				objWeatherDiv = objWeather.children[1];	//weather div object
				objImg = objWeatherDiv.children[0].children[0];	//weather image object
				objImg.style.height = "100px";
				objImg.style.width = "100px";
				</c:if></c:if>
				
				var tbodyObj = document.getElementById("publicMessages").children[1];	//tbody object
				var trArray = document.getElementById("publicMessages").children[1].children;	//tr array
				
				for(i=0; i<trArray.length; i++)
				{
					subjectTd = trArray[i].children[1];	// subject td
					if(trim(subjectTd.title) != '')
					{
						subjectTd.title = trim(subjectTd.title);
					}
				}
				
				// Select 1st row - message box 
				if( navigator.userAgent.match(/msie/gi) != 'MSIE' )
				{
					$(".tbl-msg-div td a").eq(0).css('color','#92cf51');
					$(".tbl-msg-div td a").eq(1).css('color','#92cf51');
					$(".tbl-msg-div td a").eq(2).css('color','#92cf51');
				}
				
				if(navigator.userAgent.match(/msie/gi) == 'MSIE')
				{
					if(tbodyObj.children.length <= 5)
					{
						$("#publicMessages tbody").css('width','322px');
					}
				}
				
				$(".dm-link-class").bind("dblclick", function(){
					showMsgContents($(this), parseInt($(this).children('input[type="hidden"]').val()));
					return false;
				});
		  	}
			catch(err)
		  	{
			  	// No need to handle exception for now...
		  	}
		});
		
		function showMsgContents(objLink, msgId)
		{
			if( navigator.userAgent.match(/msie/gi) != 'MSIE' )
			{
				// Manage CSS - message box 
				$(".tbl-msg-div td a").css('color','#ffffff');			
				$(objLink).css('color','#92cf51');			

				var vTDSibling = $(objLink).parent().siblings();
				$.each(vTDSibling, function(){
					$(this).children().css('color','#92cf51');
				});
			}

			// Ajax call
			var vHTML	= reqAjax(msgId);
			// Embed Ajax response
			$("#msg-div").html(vHTML);			
		}

		function reqAjax(msgId)
		{
			var result	= $.ajax({
				url		: 'msgContent.html?msg=' + msgId,
				cache	:false,
				async	:false
				}
			).responseText;			

			return result.slice(result.indexOf("response") + 9, result.lastIndexOf("response") - 2);
		}

		function checkAction()
		{
			<c:choose>
				<c:when test="${not empty user}">
					location.href = 'msgboard.html?post=true';
				</c:when>
				<c:otherwise>
					cglAlert('Invalid Action',"You must be logged in to post a message.",300);
					$(".ui-dialog-overlay").width(document.body.clientWidth);
				</c:otherwise>
			</c:choose>
		}
	</script>
	
	<c:if test="${empty user}">
	<style type="text/css">
		.signup-span
		{
			position:absolute;
			left:22px;
			top:473px;
			width:637px;
			height:178px;
			z-index:1;
		}
	</style>
	</c:if>

	<!--[if IE]>
	<style type="text/css">
	    .tbl-msg-div {position:relative; height:200px; width:330px;}
	    #home-msgbrd table.messages thead tr th {width:105px;}	    
	    #home-msgbrd table.messages thead tr {position:absolute; height:30px; width:320px; top: expression(this.offsetParent.scrollTop);}
	    #home-msgbrd table.messages tbody {position:absolute; top:30px; width:338px;}
	    #msg-div {margin:0px;}
	    #msg {margin-bottom:8px;}
	</style>
	<![endif]-->
</head>

<c:if test="${empty errors and empty successMessages}">

<div id="home">

<c:choose>
	<c:when test="${seasonStarted eq 1 and not empty playOffCountdownDays}">
		<div id="header-home">
			<div id="header-home-text">
				<div class="count-down"><fmt:message key="home.playoff" /></div>
				<div class="count-down-days"><c:out value="${playOffCountdownDays}"/></div>
				<div class="count-down"><fmt:message key="home.days"/></div>
		 	</div>
		</div>
	</c:when>
	<c:when test="${not empty countdownMessage and seasonStarted ne 2}">
		<div id="header-home">
			<div id="header-home-text">
				<div class="count-down"><c:out value="${countdownMessage}"/></div>
			    <div class="count-down-days"><c:out value="${countdownDays}"/></div>
			    <div class="count-down"><fmt:message key="home.days"/></div>
	   		</div>
	  	</div>
	</c:when>
	<c:otherwise>
		<div id="header-home-none"></div>
	</c:otherwise>
</c:choose>

<marquee id="news-ticker" behavior="scroll" scrollamount="3" direction="left"><p><c:out value="${tickerMessages}" escapeXml="false"/></p></marquee>

<div id="twocol-left">
	<div class="std-pad">
		<h2 class="page-title"><fmt:message key="home.welcomeTo"/> <fmt:message key="webapp.name"/></h2>
	    <p class="justify"><fmt:message key="home.intro"/></p>
		
		<div id="birdie-challenge" style="position:relative;">
			<c:if test="${empty user}">
			<a href="signup.html"  style="position: absolute; z-index: 1000; left:0; top:0;
			width: 630px; height: 171px; background:#fff; filter: alpha(opacity=0); opacity:0; 
			-moz-opacity:0; -webkit-opacity:0;
			outline:none;">  &nbsp;
			</a>
			</c:if>
	    	<div class="city-name"><c:out value="${cityName}"/></div>
	    	<div class="left-msg">
	    	<c:choose>
	    		<c:when test="${not empty countdownDate}">Opens for Season</c:when>
				<c:otherwise>&nbsp;</c:otherwise>
			</c:choose>
	    	</div>
			<div class="left-msg">
				<c:choose>
		    		<c:when test="${not empty countdownDate}">
		    		Registration <fmt:formatDate type="date" pattern="MMMM d" value="${countdownDate}" /><sup><c:out value="${dateSuffix}" /></sup>
		    		</c:when>
					<c:otherwise>&nbsp;</c:otherwise>
				</c:choose>
			</div>
			<div class="right-msg-1"><i>Click here to</i></div>
			<div class="right-msg-2">SIGN UP</div>
			<div class="right-msg-3">NOW</div>
			<div class="right-msg-4"><i>Tour caddie optional</i></div>
	    </div>
	
		<div id="home-info">
			<div class="left">
				<img src="images/keyInformation.jpg" alt="Key"/>
			</div>
			<div class="left">
				<h3><fmt:message key="home.keyinfo"/></h3>
			</div>
			<div class="clear"></div>
			<%@ include file="include/keyInfo.html"%>
		</div>
		
		<div id="home-msgbrd">
			<div class="left">
			 	<a href="<c:url value="msgboard.html"/>">
					<img src="images/pubMsgBrd.jpg" alt="Messages" />
				</a>
			</div>
			<div class="left">
				<h3><fmt:message key="home.msgbrdHeader"/></h3>
			</div>
			<div class="clear"></div>
		   	<c:choose>
				<c:when test="${empty publicMessages}">
		 			<div class="nomessages"><fmt:message key="home.noMessages"/></div>
		     	</c:when>
		  	  	<c:otherwise>
		  	  		<div class="tbl-msg-div">
						<display:table name="publicMessages" id="publicMessages" cellspacing="0" cellpadding="0" class="messages" requestURI="">
				    	    <display:column property="poster.fullName" titleKey="home.from" url="/profile.html" paramId="id" paramProperty="poster.id" decorator="com.sageconsulting.webapp.decorators.MessageTextColumnDecorator"/>
						    <display:column titleKey="home.subject" maxLength="25" style="whitespace: nowrap;">
								<a href="#" class="dm-link-class" onclick="return false;"><input type="hidden" value="<c:out value='${publicMessages.id}'/>"/><c:out value="${publicMessages.subject}"/></a>
			    			</display:column>
						    <display:column property="date" titleKey="home.date" url="/home.html" paramId="msg" paramProperty="id" decorator="com.sageconsulting.webapp.decorators.MessageDateColumnDecorator"/>
			
						    <display:setProperty name="basic.empty.showtable" value="false"/>
						    <display:setProperty name="basic.msg.empty_list" value="" />
							<display:setProperty name="paging.banner.no_items_found" value="" />
							<display:setProperty name="paging.banner.one_item_found" value="" />
							<display:setProperty name="paging.banner.some_items_found" value="" />
							<display:setProperty name="paging.banner.all_items_found" value="" />
							<display:setProperty name="paging.banner.full" value="" />
							<display:setProperty name="paging.banner.first" value="" />
							<display:setProperty name="paging.banner.last" value="" />
							<display:setProperty name="paging.banner.onepage" value="" />
						</display:table>
					</div>
		     	</c:otherwise>
		   	</c:choose>
			
			<c:if test="${not empty currentMessage}">
		   		<div class="clear"></div>
				<div id="msg-div">
					<div style="margin-bottom:8px;">
						<h2><c:out value="${currentMessage.subject}"/></h2>
					</div>
					<div id="msg">
						<c:out value="${currentMessage.message}" escapeXml="false"/>
					</div>
				</div>
				<div class="clear"></div>
			</c:if>
		   	
		   	<a class="green ie-post-link" onclick="checkAction();">
				<fmt:message key="profile.postMessage"/>
	  		</a>
		</div>
	</div>
</div>

<div id="twocol-right">
	<div id="home-leaderboard">
		<h2><fmt:message key="home.leaderboard"/></h2>
		<c:choose>
			<c:when test="${empty seasons or not empty hideStandings}">
				<div>
					<table id="standings">
					<caption><fmt:message key="home.noLeaderboard"/></caption>
					<thead>
						<tr>
							<th><fmt:message key="home.position"/></th>
							<th><fmt:message key="home.player"/></th>
							<th><fmt:message key="home.points"/></th>
						</tr>
					</thead>
					
					<tbody>
						<tr class="odd">
							<td>-</td>
							<td>-</td>
							<td>-</td>
						</tr>
						<tr class="even">
							<td>-</td>
							<td>-</td>
							<td>-</td>
						</tr>
						<tr class="odd">
							<td>-</td>
							<td>-</td>
							<td>-</td>
						</tr>
						<tr class="even">
							<td>-</td>
							<td>-</td>
							<td>-</td>
						</tr>
						<tr class="odd">
							<td>-</td>
							<td>-</td>
							<td>-</td>
						</tr>
						<tr class="even">
							<td>-</td>
							<td>-</td>
							<td>-</td>
						</tr>
						<tr class="odd">
							<td>-</td>
							<td>-</td>
							<td>-</td>
						</tr>
						<tr class="even">
							<td>-</td>
							<td>-</td>
							<td>-</td>
						</tr>
						<tr class="odd">
							<td>-</td>
							<td>-</td>
							<td>-</td>
						</tr>
						<tr class="even">
							<td>-</td>
							<td>-</td>
							<td>-</td>
						</tr>
					</tbody>
					</table>
				</div>
			</c:when>
			<c:otherwise>
				<div>
					<display:table id="standings" name="standings" pagesize="10">
						<display:caption><c:out value="${season.name}"/> <c:out value="${season.division}"/></display:caption>
						<display:column titleKey="home.position"><%=pageContext.getAttribute("standings_rowNum")%></display:column>
						<display:column property="user.fullName" titleKey="home.player"/>
						<display:column property="points" titleKey="home.points"/>
						
						<display:setProperty name="basic.empty.showtable" value="false"/>
						<display:setProperty name="basic.msg.empty_list" value="" />
						<display:setProperty name="paging.banner.no_items_found" value="" />
						<display:setProperty name="paging.banner.one_item_found" value="" />
						<display:setProperty name="paging.banner.some_items_found" value="" />
						<display:setProperty name="paging.banner.all_items_found" value="" />
						<display:setProperty name="paging.banner.full" value="" />
						<display:setProperty name="paging.banner.first" value="" />
						<display:setProperty name="paging.banner.last" value="" />
						<display:setProperty name="paging.banner.onepage" value="" />
					</display:table>
				</div>
			</c:otherwise>
		</c:choose>

		<c:set var="url"><c:url value="/standings.html"/></c:set>

		<carter:button page="${url}" key="home.fullLeaderboard" fill="true"/>

		<%-- <div>
			<form id="leaderboard-form" name="leaderboardForm" action="home.html">
				<select id="division" name="division" onchange="document.leaderboardForm.submit()" >
					<option value="0"><fmt:message key="home.chooseDivision"/></option>
					<c:forEach var="season" items="${seasons}">
						<option value="<c:out value="${season.id}"/>"><c:out value="${season.division}"/></option>
					</c:forEach>
				</select>
			</form>
		</div> --%>
		
		<br>
		
		<div>
			<select id="matchCat" name="matchCat" >
				<%-- <option value="0"><fmt:message key="home.chooseDivision"/></option> --%>
				<c:forEach var="matchCategory" items="${matchCategories}">
					<option value="<c:out value="${matchCategory.id}"/>"><c:out value="${matchCategory.name}"/></option>
				</c:forEach>
			</select>
		</div>
	</div>
<%-- This is out until we get sponsors
	<div id="home-sponsors" class="orange-title">
			<div class="ldrBrdSponsorsHdr"><fmt:message key="home.sponsors"/></div>
			<div class="ldrBrdSpnsrs"><img src="images/adidas.gif" alt="TODO"/><br/>
			
				<img src="images/mLogo.gif" alt="Logo"/>
			</div>
			    
	</div>
--%>
	<div id="home-weather" class="orange-title">
		<c:if test="${not empty weather}"><c:if test="${not empty weather.icon and not empty weather.high and not empty weather.low}">
			<div class="ldrBrdWeatherHdr"><fmt:message key="home.weather"/></div>
			<div class="ldrBrdWthr">
				<div class="ldrBrdWthrImg">
					<img alt="Weather" src='<c:out value="${weather.icon}"/>'/>
				</div>
				<br/>
				<div class="ldrBrdWthrToday">Today</div>
				<div class="ldrBrdWthrHiLow">HI <c:out value="${weather.high}"/>F  |  LO <c:out value="${weather.low}"/>F</div>
			</div>
		</c:if></c:if>
	</div>
</div>
</div>

</c:if>