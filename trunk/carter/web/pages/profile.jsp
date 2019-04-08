<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="profile.title"/></title>
    <meta name="menu" content="Profile"/>
</head>

<!--[if IE]>
<style type="text/css">
    .tbl-msg-div 
    {
        position:relative;
        height:115px;
        width:260px;
    }

    #message thead tr{
        position:absolute;
        height:30px;
        width:234px;
        top: expression(this.offsetParent.scrollTop);
    }
    
    #publicMessages thead tr{
        position:absolute;
        height:30px;
        width:234px;
        top: expression(this.offsetParent.scrollTop);
    }
    
    #profile table.messages thead tr th{
        width:117px;
    }
	    
    #message tbody
    {
    	position:absolute;
    	top:30px;
    	width:250px;
    	height:80px;
    }
    
    #publicMessages tbody
    {
    	position:absolute;
    	top:30px;
    	width:250px;
    	height:80px;
    }
    
   	#public-message thead tr{
	    position:absolute;
	    height:30px;
	    width:234px;
	    top: expression(this.offsetParent.scrollTop);
	}
	#public-message tbody
	{
		position:absolute;
		top:30px;
		width:250px;
		height:80px;
	}

    
    <c:choose>
    	<c:when test="${empty privateMessages}">
    	#private-message thead tr{
	        position:absolute;
	        height:30px;
	        width:234px;
	        top: expression(this.offsetParent.scrollTop);
	    }
    	
    	#private-message tbody
	    {
	    	position:absolute;
	    	top:30px;
	    	width:250px;
	    	height:80px;
	    }
    	</c:when>
    </c:choose>
</style>
<![endif]-->

<div id="profile">

<script type="text/javascript">
	function checkMrAccess(msgUrl)
	{
		<c:choose>
			<c:when test="${not empty currentUser}">
				location.href = msgUrl;
			</c:when>
			<c:otherwise>
				cglAlert('Invalid Action',"You must be a member and logged in to send messages.",300);
				$(".ui-dialog-overlay").width(document.body.clientWidth);
			</c:otherwise>
		</c:choose>
	}
</script>

<div class="threecol">
	<c:set var="player" value="${user}" scope="request"/>
	<c:import url="/common/playerInfo.jsp">
		<c:param name="fullPlayerInfo" value="true"/>
		<c:param name="showLastLogin" value="true"/>
		<c:param name="displayScheduleLink" value="false"/>
	</c:import>
</div>
            
 <div class="threecol">
   	<c:if test="${not empty user}">
   		<div class="left">
	   		<a href="<c:url value="schedule.html"/>?id=<c:out value="${user.id}"/>">
				<img src="images/ppGolfTee.jpg" alt="tee" />
			</a>
		</div>
		<div class="profile-caption"><h4><fmt:message key="profile.upcomingMatches"/></h4></div>
		<div class="clear">&nbsp;</div>
		<c:if test="${empty matches}">
			<p><fmt:message key="profile.noMatches"/></p>
		</c:if>
	</c:if>
	<c:forEach var="match" items="${matches}">
		<c:set var="opponent" value="${match.golfer1}"/>
		<c:if test="${match.golfer1 eq user}">
			<c:set var="opponent" value="${match.golfer2}"/>
		</c:if>
		<p><fmt:formatDate value="${match.playBy}" pattern="MMM d"/></p>
		<c:choose>
			<c:when test="${not empty opponent}">
				<div>
					<a class="green" href="<c:url value="/profile.html?id="/><c:out value="${opponent.id}"/>"><c:out value="${opponent.fullName}"/></a> <fmt:message key="profile.at"/> 
					<a class="course-link" href="<c:url value="/coursedetails.html?id="/><c:out value="${opponent.homeCourtText}"/>"><c:out value="${opponent.homeCourtText}"/></a>
				</div>
			</c:when>
			<c:otherwise>
				<div>TBD</div>
				<%-- <c:choose>
	    				<c:when test="${match.postSeason}">
			    			<fmt:message key="schedule.tbd"/>
	    				</c:when>
	    				<c:otherwise>
	    	    			<fmt:message key="schedule.bye"/>
	    				</c:otherwise>
	    			</c:choose> --%>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:choose>
   	<c:when test="${empty user}">
   		<div class="left">
			<img src="images/ppGolfTee.jpg" alt="tee" />
		</div>
		<div class="profile-caption"><h4><fmt:message key="profile.upcomingMatches"/></h4></div>
		<div class="clear">&nbsp;</div>
		<p><fmt:message key="profile.noMatches"/></p>
		
		<c:choose>
			<c:when test="${ not empty openRegistrationForVisitor }">
				<div>
			   		<a title="Go to Payment page" href="signup.html">
			   			<img class="tee-off-img" src="<c:url value="images/teeOffBanner.png"/>" alt="register" />
			   		</a>
			   		<div class="subsection">
						<c:set var="url"><c:url value="/signup.html"/></c:set>
						<carter:button page="${url}" key="profile.registration"/>
			    	</div>
			   	</div>
			</c:when>
			<c:otherwise>
				<div class="regbanner">
			    	<div>
			    		<a title="Go to Signup page" href="signup.html">
			    			<img class="tee-off-img" src="<c:url value="images/signupBanner.png"/>" alt="sign up" />
			    		</a>
			    	</div>
			    	<div class="subsection">
						<c:set var="url"><c:url value="/signup.html"/></c:set>
						<carter:button page="${url}" key="profile.signup"/>
			    	</div>
			    </div>
			</c:otherwise>
		</c:choose>
		
	</c:when>
	<%-- <c:when test="${not empty openRegistrations}">
		<div class="subsection">
			<fmt:message key="profile.register">
				<fmt:param><c:url value="registration.html"/></fmt:param>
			</fmt:message>
		</div>
	</c:when> --%>
	<c:when test="${not empty user}">
		<p>
			<a class="msg-link" href="<c:url value="/schedule.html?id="/><c:out value="${user.id}"/>">
			<fmt:message key="members.schedule">
				<fmt:param value="${user.firstName}"/>
			</fmt:message>
			</a>
		</p>
	</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test="${not empty openRegistrations and empty registeredSeason}">
			<c:if test="${isCurrentUser}">
			<div>
		   		<a title="Go to Payment page" href="registration.html">
		   			<img class="tee-off-img" src="<c:url value="images/teeOffBanner.png"/>" alt="register" />
		   		</a>
		   		<div class="subsection">
					<c:set var="url"><c:url value="/registration.html"/></c:set>
					<carter:button page="${url}" key="profile.registration"/>
		    	</div>
		   	</div>
		   	</c:if>
     	</c:when>
     	<c:when test="${not empty seasonStarted and !seasonStarted}">
			<div>
		   		<img class="tee-off-img" src="<c:url value="images/yourTeeOffBanner.png"/>" alt="Your tee box, schedule coming soon." />
		   	</div>
     	</c:when>
     </c:choose>
</div>
            
<div class="threecol">
	<!-- Added by Piyush/Akash starts -->
	<div class="profile-caption"><h4><fmt:message key="profile.equipment"/></h4></div>
	<div class="clear">&nbsp;</div>
	<div class="subsection">
		<p><fmt:message key="profile.racquet"/> <c:if test="${not empty user}"><span class="green"><c:out value="${user.racquet}"/></span></c:if></p>
		<p><fmt:message key="profile.strings"/> <c:if test="${not empty user}"><span class="green"><c:out value="${user.tennisString}"/></span></c:if></p>
		<p><fmt:message key="profile.shoes"/> <c:if test="${not empty user}"><span class="green"><c:out value="${user.shoes}"/></span></c:if></p>
   </div>
	<!-- Added by Piyush/Akash ends -->
	<div class="left">
		<c:if test="${isCurrentUser}">
			<a href="<c:url value="inbox.html"/>">
		</c:if>
		<img src="images/ppMessage.jpg" alt="msg" />
		<c:if test="${isCurrentUser}">
			</a>
		</c:if>
	</div>
	<div class="profile-caption"><h4><fmt:message key="profile.inbox"/></h4></div>
	<div class="clear">&nbsp;</div>
	<c:choose>
		<c:when test="${empty privateMessages}">
			<div class="tbl-msg-div">
			<table cellspacing="0" cellpadding="0" class="messages" id="private-message"><thead><tr><th>From</th><th>Subject</th></tr></thead><tbody><tr class="odd"><td>&nbsp;</td><td>&nbsp;</td></tr><tr class="even"><td>&nbsp;</td><td>&nbsp;</td></tr><tr class="odd"><td>&nbsp;</td><td>&nbsp;</td></tr></tbody></table>
			</div>
		</c:when>
		<c:otherwise>
			<div class="tbl-msg-div">
			<display:table name="privateMessages" id="message" cellspacing="0" cellpadding="0" class="messages" requestURI="">
				
					<c:choose>
						<c:when test="${isCurrentUser}">
						<c:choose>
						<c:when test="${empty message.dateRead}">
						<display:column titleKey="profile.from" decorator="com.sageconsulting.webapp.decorators.MessageTextColumnDecorator" class="unread">
							<a href="<c:url value="profile.html"/>?id=<c:out value="${message.from.id}"/>" title="<c:out value="${message.from.fullName}"/>">
								<c:out value="${message.from.fullName}"/>
							</a>
						</display:column>
						<display:column titleKey="profile.subject" decorator="com.sageconsulting.webapp.decorators.MessageTextColumnDecorator" class="unread">
						<a href="<c:url value="inbox.html"/>?msg=<c:out value="${message.id}"/>" title="<c:out value="${message.subject}"/>">
								<c:out value="${message.subject}"/>
						</a>
						</display:column>
						</c:when>
						<c:otherwise>
						<display:column titleKey="profile.from" decorator="com.sageconsulting.webapp.decorators.MessageTextColumnDecorator">
							<a href="<c:url value="profile.html"/>?id=<c:out value="${message.id}"/>" title="<c:out value="${message.from.fullName}"/>">
								<c:out value="${message.from.fullName}"/>
							</a>
						</display:column>
						
						<display:column titleKey="profile.subject" decorator="com.sageconsulting.webapp.decorators.MessageTextColumnDecorator">
						<a href="<c:url value="inbox.html"/>?msg=<c:out value="${message.id}"/>" title="<c:out value="${message.subject}"/>">
								<c:out value="${message.subject}"/>
						</a>
						</display:column>
						</c:otherwise>
						</c:choose>
						</c:when>
						<c:otherwise>
						    <display:column titleKey="profile.from" decorator="com.sageconsulting.webapp.decorators.MessageTextColumnDecorator">
							<c:out value="${message.from.fullName}"/>
							</display:column>
							<display:column titleKey="profile.subject" decorator="com.sageconsulting.webapp.decorators.MessageTextColumnDecorator">
							<c:out value="${message.subject}"/>
							</display:column>
						</c:otherwise>	
					</c:choose>
				

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
   	<div>
	   	<c:if test="${not empty user and not isCurrentUser}">
		    <a class="green ie-post-link" onclick="checkMrAccess('<c:url value="sendMessage.html"/>?id=<c:out value="${user.id}"/>');">
			    <fmt:message key="profile.leave"/> <c:out value="${user.firstName}"/> <fmt:message key="profile.amessage"/>
		    </a>
	    </c:if>
	</div>
 
 	<div class="clear">&nbsp;</div>
 	<div class="left">
	 	<a href="<c:url value="msgboard.html"/>">
	   		<img src="images/ppMessage.jpg" alt="msg"/>
	   	</a>
   	</div>
   	<div class="profile-caption"><h4><fmt:message key="profile.messageBoard"/></h4></div>
   	<div class="clear">&nbsp;</div>
   	<c:choose>
		<c:when test="${empty publicMessages}">
			<div class="tbl-msg-div">
			<table cellspacing="0" cellpadding="0" class="messages" id="public-message"><thead><tr><th>From</th><th>Subject</th></tr></thead><tbody><tr class="odd"><td>&nbsp;</td><td>&nbsp;</td></tr><tr class="even"><td>&nbsp;</td><td>&nbsp;</td></tr><tr class="odd"><td>&nbsp;</td><td>&nbsp;</td></tr></tbody></table>
			</div>
     	</c:when>
  	  	<c:otherwise>
  	  		<div class="tbl-msg-div">
			<display:table name="publicMessages" id="publicMessages" cellspacing="0" cellpadding="0" class="messages" requestURI="">
			    <display:column property="poster.fullName" titleKey="profile.from" url="/profile.html" paramId="id" paramProperty="poster.id" decorator="com.sageconsulting.webapp.decorators.MessageTextColumnDecorator"/>
			    <display:column property="subject" titleKey="profile.subject" url="/msgboard.html" paramId="msg" paramProperty="id" decorator="com.sageconsulting.webapp.decorators.MessageTextColumnDecorator"/>

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
   <div class="public-post">
   	  <a class="green ie-post-link" onclick="checkMrAccess('<c:url value="msgboard.html"/>?post=true');">
   		<fmt:message key="profile.postMessage"/>
   	  </a>
    </div>
    
    <c:if test="${isCurrentUser}">
			<c:set var="url"><c:url value="/editprofile.html"/></c:set>
			<carter:button page="${url}" key="profile.edit"/>
	</c:if>
</div>

<!-- <div class="section birdies" <c:if test="${isAdmin}">style="margin-top:-40px;" </c:if>>
	<div class="left">
		<img src="images/birdie-icon.jpg" alt="birdies" />
	</div>
	<div class="profile-caption"><h4><fmt:message key="profile.birdiePoints"/></h4></div>
	
	<div id="birdie-info-div">
		<c:if test="${isCurrentUser}">
			<c:set var="url"><c:url value="/editprofile.html"/></c:set>
			<carter:button page="${url}" key="profile.edit"/>
		</c:if>
		<div id="birdie-info">
			<table id="birdie-tbl">
				<tr>
					<td><fmt:message key="profile.birdie"/> = </td>
					<td><img alt="birdie" src="images/birdie_icon.png"></td>
					<td class="points">1 point</td>
				</tr>
				<tr>
					<td><fmt:message key="profile.eagle"/> = </td>
					<td><img alt="birdie" src="images/eagle_icon.png"></td>
					<td class="points">2 point</td>
				</tr>
				<tr>
					<td><fmt:message key="profile.dbleagle"/> = </td>
					<td><img alt="birdie" src="images/double_eagle_icon.png" style="margin-left:5px;"></td>
					<td class="points">3 point</td>
				</tr>
			</table>
		</div>
	</div>
	
	<div class="clear">&nbsp;</div>
	<div class="subsection">
		<div class="total"><fmt:message key="profile.weeklyTotal"/></div> 
		<div class="points"><c:out value="${curBirdieCount + 2*curEagleCount + 3*curDoubleEagleCount}"/> <fmt:message key="profile.points"/></div>
		<div class="clear"></div>
		<div class="images">
	    	<c:if test="${curBirdieCount > 0}">
		    	<c:forEach var="i" begin="0" end="${curBirdieCount-1}" step="1">
		    		<img src="<c:url value="images/birdie_icon.png"/>" alt="birdie" title="<fmt:message key="profile.birdie"/>"/>
		    	</c:forEach>
	    	</c:if>
	    	<c:if test="${curEagleCount > 0}">
		    	<c:forEach var="i" begin="0" end="${curEagleCount-1}" step="1">
		    		<img src="<c:url value="images/eagle_icon.png"/>" alt="eagle" title="<fmt:message key="profile.eagle"/>"/>
		    	</c:forEach>
	    	</c:if>
	    	<c:if test="${curDoubleEagleCount > 0}">
		    	<c:forEach var="i" begin="0" end="${curDoubleEagleCount-1}" step="1">
		    		<img src="<c:url value="images/double_eagle_icon.png"/>" alt="double eagle" title="<fmt:message key="profile.dbleagle"/>"/>
		    	</c:forEach>
	    	</c:if>
    	</div>
	</div>
	<div class="clear"></div>
    <div class="subsection">
		<div class="total"><fmt:message key="profile.seasonTotal"/></div> 
		<div class="points"><c:out value="${birdieCount + 2*eagleCount + 3*doubleEagleCount}"/> <fmt:message key="profile.points"/></div>
		<div class="clear"></div>
		<div class="images">
	    	<c:if test="${birdieCount > 0}">
		    	<c:forEach var="i" begin="0" end="${birdieCount-1}" step="1">
		    		<img src="<c:url value="images/birdie_icon.png"/>" alt="birdie" title="<fmt:message key="profile.birdie"/>"/>
		    	</c:forEach>
	    	</c:if>
	    	<c:if test="${eagleCount > 0}">
		    	<c:forEach var="i" begin="0" end="${eagleCount-1}" step="1">
		    		<img src="<c:url value="images/eagle_icon.png"/>" alt="eagle" title="<fmt:message key="profile.eagle"/>"/>
		    	</c:forEach>
	    	</c:if>
	    	<c:if test="${doubleEagleCount > 0}">
		    	<c:forEach var="i" begin="0" end="${doubleEagleCount-1}" step="1">
		    		<img src="<c:url value="images/double_eagle_icon.png"/>" alt="double eagle" title="<fmt:message key="profile.dbleagle"/>"/>
		    	</c:forEach>
	    	</c:if>
	    </div>
	</div>
</div> -->

</div>