<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="profile.title"/></title>
    <meta name="menu" content="Profile"/>
</head>

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
				<!-- <div>TBD</div> -->
				 <c:choose>
	    				<c:when test="${match.postSeason}">
			    			<fmt:message key="schedule.tbd"/>
	    				</c:when>
	    				<c:otherwise>
	    	    			<fmt:message key="schedule.bye"/>
	    				</c:otherwise>
	    			</c:choose> 
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
</div>