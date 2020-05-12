<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="schedule.title"/></title>
    <meta name="menu" content="Schedule"/>
</head>

<c:if test="${empty errors and empty successMessages}">

<div id="schedule">
<h2 class="page-title"> Schedule</h2>
<div id="onecol">

	<c:if test="${not empty user}">
		<div id="schedule-header">
			<h2 class="page-title"><c:out value="${user.fullName}"/></h2>
			<%-- <h4><c:out value="${user.currentSeason.division}"/></h4> --%>
			<h4 class="division"><c:out value="${user.currentSeason.name}"/></h4>
		</div>
	</c:if>

<script type="text/javascript">
	function showAlertMsg(){
		cglAlert("Invalid Action","You must be one of the players in the match to post results.",300);
	}
	
	function checkUserAccess(matchId)
	{
		<c:choose>
    		<c:when test="${not empty currentUser and currentUser}">
   			location.href = "resultsdispatch.html?id=" + matchId;
			</c:when>
			<c:otherwise>
			showAlertMsg();
			</c:otherwise>
		</c:choose>
	}
</script>

<c:choose>
<c:when test="${not empty matchList}">

	<display:table class="schedule" name="matchList" id="match" export="false">
	    <display:column titleKey="schedule.opponent" class="opponent">
	    	<c:choose>
	    		<c:when test="${not empty match.golfer2}">
	    			<a href="profile.html?id=<c:out value="${match.golfer2.id}"/>"><c:out value="${match.golfer2.fullName}"/></a>
	    		</c:when>
	    		<c:otherwise>
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
	    </display:column>

		<c:choose>
			<c:when test="${not empty postSeasonSchedule}">
				<display:column titleKey="schedule.location">
					<c:forEach var="MatchNHome" items="${matchAndHomePlayer }">
						<c:choose>
							<c:when test="${MatchNHome.key eq match.id}">
								<c:choose>
									<c:when test="${MatchNHome.value eq user.id }">
										<fmt:message key="schedule.home"/>
									</c:when>
									<c:otherwise>
										<fmt:message key="schedule.away"/>
									</c:otherwise>
								</c:choose>
							</c:when>
						</c:choose>
					</c:forEach>
				</display:column>
			</c:when>
			<c:otherwise>
				<display:column property="home" titleKey="schedule.location"
					decorator="com.sageconsulting.webapp.decorators.HomeAwayColumnDecorator" media="html"/>
			</c:otherwise>
		</c:choose>
		<display:column property="playBy" titleKey="schedule.playBy"
			decorator="com.sageconsulting.webapp.decorators.MatchDateColumnDecorator"/>
		<display:column titleKey="schedule.played">
			<c:choose>
				<c:when test="${empty match.played and not empty match.golfer2}">
					<a href="printcard.html?match=<c:out value="${match.id}"/>"><fmt:message key="schedule.printcard"/></a>
				</c:when>
				<c:when test="${empty match.played and empty match.golfer2}">
			 		-
			 	</c:when>
	    		<c:otherwise>
	    			<fmt:formatDate pattern="MMM dd, yyyy" value="${match.played}"/>
	    		</c:otherwise>
	    	</c:choose>
	    </display:column>
	    <display:column escapeXml="false" titleKey="schedule.results">
	    	<c:choose>
		    	<c:when test="${empty match.played and not empty match.golfer2}">
	    			<a class="ie-post-link" onclick="checkUserAccess(<c:out value='${match.id}'/>);"><fmt:message key="schedule.postresults"/></a>
			 	</c:when>
		    	<c:when test="${empty match.played and empty match.golfer2}">
			 		-
			 	</c:when>
			 	<c:otherwise>
	    			<a href="resultsdispatch.html?id=<c:out value="${match.id}"/><c:if test="${not empty isAdmin and isAdmin}">&user_id=<c:out value="${user.id}"/>&action=view</c:if>"><fmt:message key="schedule.viewresults"/></a>
			 	</c:otherwise>
			 </c:choose>
	     </display:column>
			    
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
	
	<carter:button onclick="window.print();" key="schedule.print"/>

</c:when>

<c:otherwise>

<div id="schedule-none"><fmt:message key="schedule.noMatches"/></div>
	
<table class="schedule" id="match">
	<thead>
		<tr>
			<th class="opp"><fmt:message key="schedule.opponent"/></th>
			<th><fmt:message key="schedule.location"/></th>
			<th><fmt:message key="schedule.playBy"/></th>
			<th><fmt:message key="schedule.played"/></th>
			<th><fmt:message key="schedule.results"/></th>
		</tr>
	</thead>
	<tbody>
		<tr>
		<td colspan="5"> &nbsp;</td>
		</tr>
		<tr class="odd">
			<td>-</td>
			<td>-</td>
			<td>-</td>
			<td><a href="#"><fmt:message key="schedule.printcard"/></a></td>
			<td><a class="ie-post-link" onclick="showAlertMsg();"><fmt:message key="schedule.postresults"/></a></td>
		</tr>
		<tr class="even">
			<td>-</td>
			<td>-</td>
			<td>-</td>
			<td><a href="#"><fmt:message key="schedule.printcard"/></a></td>
			<td><a class="ie-post-link" onclick="showAlertMsg();"><fmt:message key="schedule.postresults"/></a></td>
		</tr>
		<tr class="odd">
			<td>-</td>
			<td>-</td>
			<td>-</td>
			<td><a href="#"><fmt:message key="schedule.printcard"/></a></td>
			<td><a class="ie-post-link" onclick="showAlertMsg();"><fmt:message key="schedule.postresults"/></a></td>
		</tr>
		<tr class="even">
			<td>-</td>
			<td>-</td>
			<td>-</td>
			<td><a href="#"><fmt:message key="schedule.printcard"/></a></td>
			<td><a class="ie-post-link" onclick="showAlertMsg();"><fmt:message key="schedule.postresults"/></a></td>
		</tr>
	</tbody>
</table>
<c:if test="${empty user}">
	<div class="message"><fmt:message key="schedule.mustLogin"/></div>
</c:if>
</c:otherwise>
</c:choose>
</div>
</div>
</c:if>