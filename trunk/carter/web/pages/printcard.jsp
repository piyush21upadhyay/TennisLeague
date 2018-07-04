<%@ include file="/common/taglibs.jsp"%><head>
	<title><fmt:message key="printcard.title"/></title>
    <meta name="menu" content="Schedule"/>
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/${appConfig["csstheme"]}/scorecard-print.css'/>

" />
</head>

<c:if test="${empty errors and empty successMessages}">

<div class="section">
	<div class="left">
		<h2 class="page-title">
			<c:out value="${match.course.name}"/>&nbsp;
			<span><fmt:message key="printcard.playby"/> <fmt:formatDate pattern="MMM dd, yyyy" value="${match.playBy}"/><span>
		</h2>
	</div>
	<div class="right">
		<form:form commandName="course" method="post" action="printcard.html" id="printCard" name="printCard">
			<input type="hidden" id="match" name="match" value="<c:out value="${match.id}"/>"/>
		    <select id="course" name="course" onChange="document.printCard.submit();">
		    	<option value="-1"><fmt:message key="printcard.changeCourse"/></option>
		   		<c:forEach var="golfCourse" items="${courseList}">
					<option value="<c:out value='${golfCourse.id}'/>">
						<c:out value="${golfCourse.name}"/>
					</option>
				</c:forEach>
		    </select>
		    <!--
		    <input type="submit" class="button" id="ok" name="verify" onclick="bCancel=false" value="<fmt:message key="printcard.change"/>"/>
		    -->
		</form:form>
	</div>
</div>

<div id="printcard" class="section">
	<div class="card">
		<div class="top-row">
			<div class="first"><fmt:message key="coursedetails.hole"/></div>
			<c:forEach var="hole" begin="1" end="9" step="1">
				<div class="hole"><c:out value="${hole}"/></div>
			</c:forEach>
			<div class="nine"><fmt:message key="coursedetails.out"/></div>
			<c:forEach var="hole" begin="10" end="18" step="1">
				<div class="hole"><c:out value="${hole}"/></div>
			</c:forEach>
			<div class="nine"><fmt:message key="coursedetails.in"/></div>
			<div class="last"><fmt:message key="coursedetails.total"/></div>
		</div>
		<div class="clear"></div>
		<div class="row">
			<div class="first"><fmt:message key="coursedetails.yardage"/></div>
			<c:forEach var="hole" begin="0" end="8" step="1">
				<div class="hole"><c:out value="${match.course.mensYardages[hole]}"/></div>
			</c:forEach>
			<div class="nine"><c:out value="${match.course.mensYardageOut}"/></div>
			<c:forEach var="hole" begin="9" end="17" step="1">
				<div class="hole"><c:out value="${match.course.mensYardages[hole]}"/></div>
			</c:forEach>
			<div class="nine"><c:out value="${match.course.mensYardageIn}"/></div>
			<div class="last"><c:out value="${match.course.mensYardageTotal}"/></div>
		</div>
		<div class="row">
			<div class="first"><fmt:message key="coursedetails.handicap"/></div>
			<c:forEach var="hole" begin="0" end="8" step="1">
				<div class="hole"><c:out value="${match.course.mensHandicaps[hole]}"/></div>
			</c:forEach>
			<div class="nine">&nbsp;</div>
			<c:forEach var="hole" begin="9" end="17" step="1">
				<div class="hole"><c:out value="${match.course.mensHandicaps[hole]}"/></div>
			</c:forEach>
			<div class="nine">&nbsp;</div>
			<div class="last">&nbsp;</div>
		</div>
		<div class="clear"></div>
		<div class="row">
			<div class="first"><fmt:message key="coursedetails.mpar"/></div>
			<c:forEach var="hole" begin="0" end="8" step="1">
				<div class="hole"><c:out value="${match.course.mensPars[hole]}"/></div>
			</c:forEach>
			<div class="nine"><c:out value="${match.course.mensParOut}"/></div>
			<c:forEach var="hole" begin="9" end="17" step="1">
				<div class="hole"><c:out value="${match.course.mensPars[hole]}"/></div>
			</c:forEach>
			<div class="nine"><c:out value="${match.course.mensParIn}"/></div>
			<div class="last"><c:out value="${match.course.mensParTotal}"/></div>
		</div>
		<div class="clear"></div>
		<div class="row">
			<div class="first">
				<c:out value="${match.golfer1.fullName}"/> (<c:choose>
								<c:when test="${match.score.golfer1Handicap lt 0}">
									<c:out value="+"/><c:out value="${0 - match.score.golfer1Handicap}"/>
								</c:when>
								<c:otherwise>
									<c:out value="${match.score.golfer1Handicap}"/>
								</c:otherwise>
							</c:choose>)
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke1 lt -1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke1 lt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke2 lt -1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke2 lt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke3 lt -1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke3 lt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke4 lt -1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke4 lt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke5 lt -1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke5 lt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke6 lt -1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke6 lt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke7 lt -1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke7 lt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke8 lt -1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke8 lt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke9 lt -1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke9 lt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="nine">&nbsp;</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke10 lt -1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke10 lt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke11 lt -1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke11 lt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke12 lt -1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke12 lt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke13 lt -1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke13 lt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke14 lt -1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke14 lt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke15 lt -1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke15 lt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke16 lt -1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke16 lt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke17 lt -1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke17 lt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke18 lt -1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke18 lt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="nine">&nbsp;</div>
			<div class="last">&nbsp;</div>
		</div>
		<div class="clear"></div>
	    <div class="row">
	    	<div class="first">&nbsp;</div>
			<div class="hole">&nbsp;</div>
	        <div class="hole">&nbsp;</div>
	        <div class="hole">&nbsp;</div>
	        <div class="hole">&nbsp;</div>
	        <div class="hole">&nbsp;</div>
	        <div class="hole">&nbsp;</div>
	        <div class="hole">&nbsp;</div>
	        <div class="hole">&nbsp;</div>
	        <div class="hole">&nbsp;</div>
	        <div class="nine">&nbsp;</div>
	        <div class="hole">&nbsp;</div>
	        <div class="hole">&nbsp;</div>
	        <div class="hole">&nbsp;</div>
	        <div class="hole">&nbsp;</div>
	        <div class="hole">&nbsp;</div>
	        <div class="hole">&nbsp;</div>
	        <div class="hole">&nbsp;</div>
	        <div class="hole">&nbsp;</div>
	        <div class="hole">&nbsp;</div>
			<div class="nine">&nbsp;</div>
	        <div class="last">&nbsp;</div>
	    </div> 
		<div class="clear"></div>
		<div class="row">
			<div class="first">
				<c:out value="${match.golfer2.fullName}"/> (<c:choose>
								<c:when test="${match.score.golfer2Handicap lt 0}">
									<c:out value="+"/><c:out value="${0 - match.score.golfer2Handicap}"/>
								</c:when>
								<c:otherwise>
									<c:out value="${match.score.golfer2Handicap}"/>
								</c:otherwise>
							</c:choose>)
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke1 gt 1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke1 gt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke2 gt 1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke2 gt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke3 gt 1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke3 gt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke4 gt 1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke4 gt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke5 gt 1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke5 gt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke6 gt 1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke6 gt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke7 gt 1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke7 gt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke8 gt 1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke8 gt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke9 gt 1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke9 gt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="nine">&nbsp;</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke10 gt 1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke10 gt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke11 gt 1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke11 gt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke12 gt 1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke12 gt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke13 gt 1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke13 gt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke14 gt 1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke14 gt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke15 gt 1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke15 gt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke16 gt 1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke16 gt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke17 gt 1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke17 gt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="hole">
				<c:choose>
					<c:when test="${match.score.stroke18 gt 1}">
						<div class="dotted dotted2">&nbsp;</div>
					</c:when>
					<c:when test="${match.score.stroke18 gt 0}">
						<div class="dotted">&nbsp;</div>
					</c:when>
				</c:choose>
			</div>
			<div class="nine">&nbsp;</div>
			<div class="last">&nbsp;</div>
		</div>
		<div class="clear"></div>
		<div class="row">
			<div class="first"><fmt:message key="coursedetails.yardage"/></div>
			<c:forEach var="hole" begin="0" end="8" step="1">
				<div class="hole"><c:out value="${match.course.womensYardages[hole]}"/></div>
			</c:forEach>
			<div class="nine"><c:out value="${match.course.womensYardageOut}"/></div>
			<c:forEach var="hole" begin="9" end="17" step="1">
				<div class="hole"><c:out value="${match.course.womensYardages[hole]}"/></div>
			</c:forEach>
			<div class="nine"><c:out value="${match.course.womensYardageIn}"/></div>
			<div class="last"><c:out value="${match.course.womensYardageTotal}"/></div>
		</div>
		<div class="clear"></div>
		<div class="row">
			<div class="first"><fmt:message key="coursedetails.handicap"/></div>
			<c:forEach var="hole" begin="0" end="8" step="1">
				<div class="hole"><c:out value="${match.course.womensHandicaps[hole]}"/></div>
			</c:forEach>
			<div class="nine">&nbsp;</div>
			<c:forEach var="hole" begin="9" end="17" step="1">
				<div class="hole"><c:out value="${match.course.womensHandicaps[hole]}"/></div>
			</c:forEach>
			<div class="nine">&nbsp;</div>
			<div class="last">&nbsp;</div>
		</div>
		<div class="clear"></div>
		<div class="row bottom-row">
			<div class="first"><fmt:message key="coursedetails.wpar"/></div>
			<c:forEach var="hole" begin="0" end="8" step="1">
				<div class="hole"><c:out value="${match.course.womensPars[hole]}"/></div>
			</c:forEach>
			<div class="nine"><c:out value="${match.course.womensParOut}"/></div>
			<c:forEach var="hole" begin="9" end="17" step="1">
				<div class="hole"><c:out value="${match.course.womensPars[hole]}"/></div>
			</c:forEach>
			<div class="nine"><c:out value="${match.course.womensParIn}"/></div>
			<div class="last"><c:out value="${match.course.womensParTotal}"/></div>
		</div>
		<div class="clear"></div>
		<div class="scorerRow">
			<div class="scorer"><fmt:message key="printcard.scorer"/></div>
			<div class="attest"><fmt:message key="printcard.attest"/></div>
			<div class="date"><fmt:message key="printcard.date"/></div>
		</div>
		<div class="clear"></div>
		        
		<div id="stroke">
			<div class="dotted" style="display:inline-block;">&nbsp;</div>&nbsp;<fmt:message key="printcard.strokeHole"/>
		</div>
	</div>
	<div class="clear">&nbsp;</div>
	<div id="print-instr"><fmt:message key="printcard.instr"/></div>
	<carter:button onclick="window.print();" key="printcard.print"/>
	
</div>

</c:if>