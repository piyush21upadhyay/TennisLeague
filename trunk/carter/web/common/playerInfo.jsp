<%@ include file="/common/taglibs.jsp"%>


<div class="player-info members-listing-desc memberBox-bg w-100 h-100 flu-box shadow">
	<c:choose>
		<c:when test="${empty player}">
			<div class="left heading-golfer"><h4><fmt:message key="profile.welcomeGuest"/></h4>
			<img src="<c:url value="images/guest.PNG"/>" alt="member"/></div>
		</c:when>
		<c:otherwise>
			<c:if test="${param.showProfileButton eq 'true'}">
				<div class="left">
					<table class="show-profile-info">
						<tr><td class="profile-img text-center"><img src="<c:out value="${player.icon}"/>"/></td></tr>
						<tr>
							<td align="center" style="padding: 20px 0px; text-align: center;">
								<c:set var="registered" value="false"/>							
								<c:forEach var="user" items="${registeredUserList}">
									<c:if test="${user.key eq player.id}">
										<c:set var="registered" value="true"/>
									</c:if>
								</c:forEach>
								
								<c:set var="url"><c:url value="/profile.html"/></c:set>
								<c:choose>
									<c:when test="${registered}">
										<carter:button styleClass="active-member" page="${url}" param="id=${player.id}&amp;msg=false" key="members.viewProfile"/>
									</c:when>
									<c:otherwise>
										<carter:button page="${url}" param="id=${player.id}&amp;msg=false" key="members.viewProfile"/>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td>
								<h2 class="playerINfotitle" title='<c:out value="${player.fullName}"/>'>
								<c:out value="${player.fullName}"/>	
							</h2>
							</td>
						</tr>
						<tr>
							<td align="center"><h3>&nbsp;<c:out value="${player.playerLevel}"/> Rating</h3></td>
						</tr>
						
					</table>
				</div>
			</c:if>
			<c:if test="${param.showLastLogin eq 'true'}">
				<div class="heading-golfer" style="overflow: hidden;">
					<h4>&nbsp;<strong>
					<c:choose>
						<c:when test="${player.male eq 'true'}">
							<c:out value="${player.fullName} | M"/>
						</c:when>
						<c:otherwise>
							<c:out value="${player.fullName} | F"/>
						</c:otherwise>
					</c:choose>
					</strong></h4>
					<h4>&nbsp;<c:out value="${player.address.city} , ${player.address.province}"/></h4>
				</div>
			</c:if>
		</c:otherwise>
	</c:choose>
	<div class="clear"></div>
	
	<div class="subsection p1">
	<div class="flu-box">
		<p class="overflowText"><fmt:message key="profile.homeCourt"/> <c:if test="${not empty player}"><c:out value="${player.homeCourtText}"/></c:if></p>
		<%-- <p><fmt:message key="profile.homeCourt"/> 
			<c:if test="${not empty player}"><c:out value="${homeCourt}"/></c:if>
		</p> --%>
		<c:if test="${not param.fullPlayerInfo eq 'true' and not empty currentRecord}">
			<%-- <p><fmt:message key="profile.seasonRecord"/> <c:if test="${not empty player}"><a class="green" href="<c:url value="/record.html"/>?id=<c:out value="${player.id}"/>"><c:out value="${currentRecord}"/></a></c:if></p> --%>
			<c:choose>
				<c:when test="${player.currentSeason.state == 4}">
					<p><fmt:message key="profile.seasonRecord"/> <c:if test="${not empty player}"><a class="green" href="<c:url value='/record.html'/>?id=<c:out value='${player.id}'/>">0-0</a></c:if></p>
				</c:when>
				<c:otherwise>
					<p><fmt:message key="profile.seasonRecord"/> <c:if test="${not empty player}"><a class="green" href="<c:url value="/record.html"/>?id=<c:out value="${player.id}"/>"><c:out value="${currentRecord}"/></a></c:if></p>	
				</c:otherwise>
			</c:choose>
		</c:if>
	
		
	<c:if test="${param.fullPlayerInfo eq 'true'}">
	   <div class="subsection p2">
			<p><fmt:message key="profile.memberSince"/> <c:if test="${not empty player}"><span class="green"><fmt:formatDate value="${player.dateJoined}" pattern="mm-dd-yyyy"/></span></c:if></p>
			<p><fmt:message key="profile.rating"/> <c:if test="${not empty player}"><span class="green"><c:out value="${player.playerLevel} (${player.ratedBy})"/></span></c:if></p>
			<p><fmt:message key="profile.tournamentEntered"/> <c:if test="${not empty player}"><span class="green"><c:out value="${player.seasonEntered}"/></span></c:if></p>
	   </div>
	   <div class="subsection p3">
			<p><fmt:message key="profile.tournamentStandings"/> <c:if test="${not empty player}"><a class="green" href="<c:url value="/standings.html"/>"><c:out value="${seasonPosition}"/></a></c:if></p>
			<p><fmt:message key="profile.tournamentPoints"/> <c:if test="${not empty player}"><span class="green"><c:out value="${seasonPoints}"/></span></c:if></p>
		
	   </div>
	   </div>
	   </div>
	   <div class="subsection">
	   <div class="flu-box shadow">
	   	<p><fmt:message key="profile.tournamentRecord"/> <c:if test="${not empty player}"><a class="green" href="<c:url value="/record.html"/>?id=<c:out value="${player.id}"/>"><c:out value="${currentRecord}"/></a></c:if></p>
	  <!-- Hard code --> 	<div class="winloss-sec">
	   		<i class="winBall"></i>
	   		<i class="winBall"></i>
	   		<i class="winBall"></i>
	   		<i class="lossBall"></i>
	   	</div>
	   </div>
	   </div>
	   <div class="subsection">
	   <div class="flu-box shadow">
			<p><fmt:message key="profile.cglRecord"/> <c:if test="${not empty player}"><a class="green" href="<c:url value="/record.html"/>?id=<c:out value="${player.id}"/>&func=all"><c:out value="${overallRecord}"/></a></c:if></p>
			<p><fmt:message key="profile.bestResults"/> <c:if test="${not empty player}"><span class="green">N/A<%--TODO--%></span></c:if></p>
			<%-- <p><fmt:message key="profile.careerLow"/> <c:if test="${not empty player}"><span class="green"><c:out value="${player.lowScore}"/></span></c:if></p> --%>
		
		<!-- Added by Piyush and Akash starts -->
		<div class="subsection">
			<p><fmt:message key="profile.plays"/> <c:if test="${not empty player}"><span class="green"><c:out value="${player.plays}"/></span></c:if></p>
			<p><fmt:message key="profile.matchPreference"/> <c:if test="${not empty player}">
				<span class="green">
					<c:forEach var="playingPref" items="${player.playingPreference}">
					<td>
				        <c:out value="${playingPref}" />
				    </td>
					</c:forEach>
					<%-- <c:out value="${player.playingPreference}"/> --%>
				</span></c:if>
			</p>
			<p><fmt:message key="profile.openToChallenges"/> <c:if test="${not empty player}">
				<span class="green">
				
				<c:choose>
					<c:when test="${player.openToChallenges eq false}">
						<c:out value="No"/>
					</c:when>
					<c:otherwise>
					   <c:choose>
						<c:when test="${player.onlyOpenToSameGender eq true}">
							<c:choose>
							<c:when test="${player.male eq true}">
								<c:out value="M|"/><c:forEach var="playingPref" items="${player.playingPreference}">
														<td>
				        									<c:out value="${playingPref}" />
				    									</td>
													</c:forEach>
							</c:when>
							<c:otherwise>
								<c:out value="F|"/><c:forEach var="playingPref" items="${player.playingPreference}">
														<td>
				        									<c:out value="${playingPref}" />
				    									</td>
													</c:forEach>
							</c:otherwise>
							</c:choose>
						</c:when>	
						<c:otherwise>
								<c:out value="M & F|"/><c:forEach var="playingPref" items="${player.playingPreference}">
														<td>
				        									<c:out value="${playingPref}" />
				    									</td>
													</c:forEach>
						</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
				</span></c:if>
			</p>
	   </div>
	   </div>
	   </div>
	   <div class="subsection">
	   <div class="flu-box shadow">
	   
			<p><fmt:message key="profile.percentageGamesWon"/> <c:if test="${not empty player}">
			
			
			
			<span class="chart-div-pInfo">
<svg viewBox="0 0 36 36" class="circular-chart-pInfo">
  <path class="circlepinfo"
    stroke-dasharray="<c:out value="${percentageGamesWon}"/>, 100"
    d="M18 2.0845
      a 15.9155 15.9155 0 0 1 0 31.831
      a 15.9155 15.9155 0 0 1 0 -31.831"
  />

</svg>
<span class="green"><c:out value="${percentageGamesWon}"/>%</span>
</span>
			
			
			
			
			</c:if></p>
			<%-- <p><fmt:message key="profile.percentageGamesLoss"/> <c:if test="${not empty player}"><span class="green"><c:out value="${percentageGamesLoss}"/></span></c:if></p> --%>
		
	   <!-- Added by Piyush and Akash ends -->
	</c:if>
	
	<c:if test="${param.displayScheduleLink eq 'true' and not empty player}">
		<p class="msg-link-btn">
		<a class="msg-link" href="<c:url value="/schedule.html?id="/><c:out value="${player.id}"/>">
			Schedule
		</a>
		</p>
	</c:if>
	<c:if test="${param.displayMessageLink eq 'true'}">
		<p class="msg-link-btn">
		<a class="msg-link ie-post-link" onclick="checkAccess('<c:url value="/sendMessage.html?id="/><c:out value="${player.id}"/>')">
		   Message
		</a>
		</p>
	</c:if>
	<c:if test="${not param.fullPlayerInfo eq 'true'}">
		<p class="pt-3" style="clear: both"><fmt:message key="profile.bestResults"/> <c:if test="${not empty player}"><span class="green">N/A<%--TODO--%></span></c:if></p>
	</c:if>
</div>
</div>
</div>