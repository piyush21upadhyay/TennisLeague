<%@ include file="/common/taglibs.jsp"%>

<div class="player-info">
	<c:choose>
		<c:when test="${empty player}">
			<div class="left"><img src="<c:url value="images/maleGolfer-icon.gif"/>" alt="member"/></div>
			<div class="left"><h4><fmt:message key="profile.welcomeGuest"/></h4></div>
		</c:when>
		<c:otherwise>
			<div class="left"><img src="<c:url value="${player.icon}"/>" alt="member" width="42"/></div>
			<c:if test="${param.showProfileButton eq 'true'}">
				<div class="left">
					<table>
						<tr>
							<td colspan="2">
								<h2 style="height:16px; margin-bottom:8px; overflow:hidden; width:200px; word-wrap:break-word;" title='<c:out value="${player.fullName}"/>'><c:out value="${player.fullName}"/></h2>
							</td>
						</tr>
						<tr>
							<td>
								<c:if test="${not empty player.currentSeason}">
									<h3>&nbsp;<c:out value="${player.currentSeason.division}"/></h3>
								</c:if>
							</td>
							<td>
							<c:set var="registered" value="false"/>							
							<c:forEach var="user" items="${registeredUserList}">
								<c:if test="${user.key eq player.id}">
									<c:set var="registered" value="true"/>
								</c:if>
							</c:forEach>
							
							<c:set var="url"><c:url value="/profile.html"/></c:set>
							<c:choose>
								<c:when test="${registered}">
									<carter:button styleClass="squarebutton-register" page="${url}" param="id=${player.id}&amp;msg=false" key="members.profile"/>
								</c:when>
								<c:otherwise>
									<carter:button page="${url}" param="id=${player.id}&amp;msg=false" key="members.profile"/>
								</c:otherwise>
							</c:choose>
							</td>
						</tr>
					</table>
				</div>
			</c:if>
			<c:if test="${param.showLastLogin eq 'true'}">
				<div class="left">
					<h2>&nbsp;<strong><c:out value="${player.fullName}"/></strong></h2>
					<h4>&nbsp;<fmt:message key="profile.lastlogin"/>
					<c:choose>
						<c:when test="${not empty lastLogin}">
							<fmt:formatDate pattern="MMMMM d" value="${lastLogin}" />
						</c:when>
						<c:otherwise>
							<fmt:formatDate pattern="MMMMM d" value="${player.lastLogin}" />
						</c:otherwise>
					</c:choose>
					</h4>
				</div>
			</c:if>
		</c:otherwise>
	</c:choose>
	<div class="clear"></div>
	
	<div class="subsection">
		<p><fmt:message key="profile.homeCourse"/> <c:if test="${not empty player}"><a class="course-link" href="<c:url value="/coursedetails.html?id="/><c:out value="${player.homeCourse.id}"/>"><c:out value="${player.homeCourse.name}"/></a></c:if></p>
		<p><fmt:message key="profile.handicap"/> <c:if test="${not empty player}">
			<span class="green">
			<c:choose>
				<c:when test="${player.handicap lt 0}">
					<c:out value="+"/><c:out value="${0 - player.handicap}"/>
				</c:when>
				<c:otherwise>
					<c:out value="${player.handicap}"/>
				</c:otherwise>
			</c:choose>
			</span></c:if></p>
		<c:if test="${param.fullPlayerInfo eq 'true'}">
			<p><fmt:message key="profile.division"/> <c:if test="${not empty player}"><span class="green"><c:out value="${currentDivision}"/></span></c:if></p>
		</c:if>
		<c:if test="${not param.fullPlayerInfo eq 'true' and not empty currentRecord}">
			<%-- <p><fmt:message key="profile.seasonRecord"/> <c:if test="${not empty player}"><a class="green" href="<c:url value="/record.html"/>?id=<c:out value="${player.id}"/>"><c:out value="${currentRecord}"/></a></c:if></p> --%>
			<c:choose>
				<c:when test="${player.currentSeason.state == 4}">
					<p><fmt:message key="profile.seasonRecord"/> <c:if test="${not empty player}"><a class="green" href="<c:url value='/record.html'/>?id=<c:out value='${player.id}'/>">0-0-0</a></c:if></p>
				</c:when>
				<c:otherwise>
					<p><fmt:message key="profile.seasonRecord"/> <c:if test="${not empty player}"><a class="green" href="<c:url value="/record.html"/>?id=<c:out value="${player.id}"/>"><c:out value="${currentRecord}"/></a></c:if></p>	
				</c:otherwise>
			</c:choose>
		</c:if>
	</div>
		
	<c:if test="${param.fullPlayerInfo eq 'true'}">
	   <div class="subsection">
			<p><fmt:message key="profile.memberSince"/> <c:if test="${not empty player}"><span class="green"><fmt:formatDate value="${player.dateJoined}" pattern="yyyy"/></span></c:if></p>
			<p><fmt:message key="profile.seasonsEntered"/> <c:if test="${not empty player}"><span class="green"><c:out value="${player.seasonEntered}"/></span></c:if></p>
	   </div>
	   <div class="subsection">
			<p><fmt:message key="profile.seasonStandings"/> <c:if test="${not empty player}"><a class="green" href="<c:url value="/standings.html"/>"><c:out value="${seasonPosition}"/></a></c:if></p>
			<p><fmt:message key="profile.seasonPoints"/> <c:if test="${not empty player}"><span class="green"><c:out value="${seasonPoints}"/></span></c:if></p>
			<p><fmt:message key="profile.seasonRecord"/> <c:if test="${not empty player}"><a class="green" href="<c:url value="/record.html"/>?id=<c:out value="${player.id}"/>"><c:out value="${currentRecord}"/></a></c:if></p>
	   </div>
	   <div class="subsection">
			<p><fmt:message key="profile.cglRecord"/> <c:if test="${not empty player}"><a class="green" href="<c:url value="/record.html"/>?id=<c:out value="${player.id}"/>&func=all"><c:out value="${overallRecord}"/></a></c:if></p>
			<p><fmt:message key="profile.bestResults"/> <c:if test="${not empty player}"><span class="green">N/A<%--TODO--%></span></c:if></p>
			<p><fmt:message key="profile.careerLow"/> <c:if test="${not empty player}"><span class="green"><c:out value="${player.lowScore}"/></span></c:if></p>
		</div>
	</c:if>
	
	<c:if test="${param.displayScheduleLink eq 'true' and not empty player}">
		<p>
		<a class="msg-link" href="<c:url value="/schedule.html?id="/><c:out value="${player.id}"/>">
			<fmt:message key="members.schedule">
				<fmt:param value="${player.firstName}"/>
			</fmt:message>
		</a>
		</p>
	</c:if>
	<c:if test="${param.displayMessageLink eq 'true'}">
		<p>
		<a class="msg-link ie-post-link" onclick="checkAccess('<c:url value="/sendMessage.html?id="/><c:out value="${player.id}"/>');">
			<fmt:message key="members.view">
				<fmt:param value="${player.firstName}"/>
			</fmt:message>
		</a>
		</p>
	</c:if>
	<c:if test="${not param.fullPlayerInfo eq 'true'}">
		<p><fmt:message key="profile.bestResults"/> <c:if test="${not empty player}"><span class="green">N/A<%--TODO--%></span></c:if></p>
	</c:if>
</div>