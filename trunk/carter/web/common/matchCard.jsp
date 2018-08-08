<%@ include file="/common/taglibs.jsp"%>
<c:if test="${empty match}">
	<c:set var="match" value="${matchParam}"/>
</c:if>
<%-- <div class="card-small">
<div class="card">
	<div class="top-row">
		<div class="first"><fmt:message key="results.hole"/></div>
		<c:choose>
			<c:when test="${match.score.stroke1 eq 0}"><c:set var="cssclass" value="hole"/></c:when>
			<c:when test="${match.score.stroke1 eq 1 or match.score.stroke1 eq -1}"><c:set var="cssclass" value="hole stroke"/></c:when>
			<c:otherwise><c:set var="cssclass" value="hole stroke2"/></c:otherwise>
		</c:choose>
		<div class="<c:out value="${cssclass}"/>">1</div>
		<c:choose>
			<c:when test="${match.score.stroke2 eq 0}"><c:set var="cssclass" value="hole"/></c:when>
			<c:when test="${match.score.stroke2 eq 1 or match.score.stroke2 eq -1}"><c:set var="cssclass" value="hole stroke"/></c:when>
			<c:otherwise><c:set var="cssclass" value="hole stroke2"/></c:otherwise>
		</c:choose>
		<div class="<c:out value="${cssclass}"/>">2</div>
		<c:choose>
			<c:when test="${match.score.stroke3 eq 0}"><c:set var="cssclass" value="hole"/></c:when>
			<c:when test="${match.score.stroke3 eq 1 or match.score.stroke3 eq -1}"><c:set var="cssclass" value="hole stroke"/></c:when>
			<c:otherwise><c:set var="cssclass" value="hole stroke2"/></c:otherwise>
		</c:choose>
		<div class="<c:out value="${cssclass}"/>">3</div>
		<c:choose>
			<c:when test="${match.score.stroke4 eq 0}"><c:set var="cssclass" value="hole"/></c:when>
			<c:when test="${match.score.stroke4 eq 1 or match.score.stroke4 eq -1}"><c:set var="cssclass" value="hole stroke"/></c:when>
			<c:otherwise><c:set var="cssclass" value="hole stroke2"/></c:otherwise>
		</c:choose>
		<div class="<c:out value="${cssclass}"/>">4</div>
		<c:choose>
			<c:when test="${match.score.stroke5 eq 0}"><c:set var="cssclass" value="hole"/></c:when>
			<c:when test="${match.score.stroke5 eq 1 or match.score.stroke5 eq -1}"><c:set var="cssclass" value="hole stroke"/></c:when>
			<c:otherwise><c:set var="cssclass" value="hole stroke2"/></c:otherwise>
		</c:choose>
		<div class="<c:out value="${cssclass}"/>">5</div>
		<c:choose>
			<c:when test="${match.score.stroke6 eq 0}"><c:set var="cssclass" value="hole"/></c:when>
			<c:when test="${match.score.stroke6 eq 1 or match.score.stroke6 eq -1}"><c:set var="cssclass" value="hole stroke"/></c:when>
			<c:otherwise><c:set var="cssclass" value="hole stroke2"/></c:otherwise>
		</c:choose>
		<div class="<c:out value="${cssclass}"/>">6</div>
		<c:choose>
			<c:when test="${match.score.stroke7 eq 0}"><c:set var="cssclass" value="hole"/></c:when>
			<c:when test="${match.score.stroke7 eq 1 or match.score.stroke7 eq -1}"><c:set var="cssclass" value="hole stroke"/></c:when>
			<c:otherwise><c:set var="cssclass" value="hole stroke2"/></c:otherwise>
		</c:choose>
		<div class="<c:out value="${cssclass}"/>">7</div>
		<c:choose>
			<c:when test="${match.score.stroke8 eq 0}"><c:set var="cssclass" value="hole"/></c:when>
			<c:when test="${match.score.stroke8 eq 1 or match.score.stroke8 eq -1}"><c:set var="cssclass" value="hole stroke"/></c:when>
			<c:otherwise><c:set var="cssclass" value="hole stroke2"/></c:otherwise>
		</c:choose>
		<div class="<c:out value="${cssclass}"/>">8</div>
		<c:choose>
			<c:when test="${match.score.stroke9 eq 0}"><c:set var="cssclass" value="hole"/></c:when>
			<c:when test="${match.score.stroke9 eq 1 or match.score.stroke9 eq -1}"><c:set var="cssclass" value="hole stroke"/></c:when>
			<c:otherwise><c:set var="cssclass" value="hole stroke2"/></c:otherwise>
		</c:choose>
		<div class="<c:out value="${cssclass}"/>">9</div>
		<div class="nine">&nbsp;</div>
		<c:choose>
			<c:when test="${match.score.stroke10 eq 0}"><c:set var="cssclass" value="hole"/></c:when>
			<c:when test="${match.score.stroke10 eq 1 or match.score.stroke10 eq -1}"><c:set var="cssclass" value="hole stroke"/></c:when>
			<c:otherwise><c:set var="cssclass" value="hole stroke2"/></c:otherwise>
		</c:choose>
		<div class="<c:out value="${cssclass}"/>">10</div>
		<c:choose>
			<c:when test="${match.score.stroke11 eq 0}"><c:set var="cssclass" value="hole"/></c:when>
			<c:when test="${match.score.stroke11 eq 1 or match.score.stroke11 eq -1}"><c:set var="cssclass" value="hole stroke"/></c:when>
			<c:otherwise><c:set var="cssclass" value="hole stroke2"/></c:otherwise>
		</c:choose>
		<div class="<c:out value="${cssclass}"/>">11</div>
		<c:choose>
			<c:when test="${match.score.stroke12 eq 0}"><c:set var="cssclass" value="hole"/></c:when>
			<c:when test="${match.score.stroke12 eq 1 or match.score.stroke12 eq -1}"><c:set var="cssclass" value="hole stroke"/></c:when>
			<c:otherwise><c:set var="cssclass" value="hole stroke2"/></c:otherwise>
		</c:choose>
		<div class="<c:out value="${cssclass}"/>">12</div>
		<c:choose>
			<c:when test="${match.score.stroke13 eq 0}"><c:set var="cssclass" value="hole"/></c:when>
			<c:when test="${match.score.stroke13 eq 1 or match.score.stroke13 eq -1}"><c:set var="cssclass" value="hole stroke"/></c:when>
			<c:otherwise><c:set var="cssclass" value="hole stroke2"/></c:otherwise>
		</c:choose>
		<div class="<c:out value="${cssclass}"/>">13</div>
		<c:choose>
			<c:when test="${match.score.stroke14 eq 0}"><c:set var="cssclass" value="hole"/></c:when>
			<c:when test="${match.score.stroke14 eq 1 or match.score.stroke14 eq -1}"><c:set var="cssclass" value="hole stroke"/></c:when>
			<c:otherwise><c:set var="cssclass" value="hole stroke2"/></c:otherwise>
		</c:choose>
		<div class="<c:out value="${cssclass}"/>">14</div>
		<c:choose>
			<c:when test="${match.score.stroke15 eq 0}"><c:set var="cssclass" value="hole"/></c:when>
			<c:when test="${match.score.stroke15 eq 15 or match.score.stroke15 eq -1}"><c:set var="cssclass" value="hole stroke"/></c:when>
			<c:otherwise><c:set var="cssclass" value="hole stroke2"/></c:otherwise>
		</c:choose>
		<div class="<c:out value="${cssclass}"/>">15</div>
		<c:choose>
			<c:when test="${match.score.stroke16 eq 0}"><c:set var="cssclass" value="hole"/></c:when>
			<c:when test="${match.score.stroke16 eq 1 or match.score.stroke16 eq -1}"><c:set var="cssclass" value="hole stroke"/></c:when>
			<c:otherwise><c:set var="cssclass" value="hole stroke2"/></c:otherwise>
		</c:choose>
		<div class="<c:out value="${cssclass}"/>">16</div>
		<c:choose>
			<c:when test="${match.score.stroke17 eq 0}"><c:set var="cssclass" value="hole"/></c:when>
			<c:when test="${match.score.stroke17 eq 1 or match.score.stroke17 eq -1}"><c:set var="cssclass" value="hole stroke"/></c:when>
			<c:otherwise><c:set var="cssclass" value="hole stroke2"/></c:otherwise>
		</c:choose>
		<div class="<c:out value="${cssclass}"/>">17</div>
		<c:choose>
			<c:when test="${match.score.stroke18 eq 0}"><c:set var="cssclass" value="hole"/></c:when>
			<c:when test="${match.score.stroke18 eq 1 or match.score.stroke18 eq -1}"><c:set var="cssclass" value="hole stroke"/></c:when>
			<c:otherwise><c:set var="cssclass" value="hole stroke2"/></c:otherwise>
		</c:choose>
		<div class="<c:out value="${cssclass}"/> last-short">18</div>
	</div>
	<div class="clear"></div>
	<div class="row">
		<div class="first"><fmt:message key="coursedetails.mpar"/></div>
		<c:forEach var="hole" begin="0" end="8" step="1">
			<div class="hole"><c:out value="${match.course.mensPars[hole]}"/></div>
		</c:forEach>
		<div class="nine">&nbsp;</div>
		<c:forEach var="hole" begin="9" end="17" step="1">
			<div class="hole"><c:out value="${match.course.mensPars[hole]}"/></div>
		</c:forEach>
	</div>
	<div class="clear"></div>
	<div class="row">
		<c:set var="userCssClass" value="first nostroke-player"/>
		<c:set var="nameCssClass" value="nostroke-player-name"/>
		<c:set var="hdcpCssClass" value="nostroke-player-hdcp"/>
		<c:if test="${match.score.golfer1Handicap gt match.score.golfer2Handicap}">
			<c:set var="userCssClass" value="first stroke-player"/>
			<c:set var="nameCssClass" value="stroke-player-name"/>
			<c:set var="hdcpCssClass" value="stroke-player-hdcp"/>
		</c:if>
		<div class="<c:out value="${userCssClass}"/>">
			<span class="<c:out value="${nameCssClass}"/>"><c:out value="${match.golfer1.displayName}"/></span> <span class="<c:out value="${hdcpCssClass}"/>">(<c:out value="${match.score.golfer1Handicap}"/>)</span>
		</div>
		<div class="<c:out value="${match.score.player1Hole1CSSClass}"/>"><c:out value="${match.score.player1Hole1Score}"/></div>
		<div class="<c:out value="${match.score.player1Hole2CSSClass}"/>"><c:out value="${match.score.player1Hole2Score}"/></div>
		<div class="<c:out value="${match.score.player1Hole3CSSClass}"/>"><c:out value="${match.score.player1Hole3Score}"/></div>
		<div class="<c:out value="${match.score.player1Hole4CSSClass}"/>"><c:out value="${match.score.player1Hole4Score}"/></div>
		<div class="<c:out value="${match.score.player1Hole5CSSClass}"/>"><c:out value="${match.score.player1Hole5Score}"/></div>
		<div class="<c:out value="${match.score.player1Hole6CSSClass}"/>"><c:out value="${match.score.player1Hole6Score}"/></div>
		<div class="<c:out value="${match.score.player1Hole7CSSClass}"/>"><c:out value="${match.score.player1Hole7Score}"/></div>
		<div class="<c:out value="${match.score.player1Hole8CSSClass}"/>"><c:out value="${match.score.player1Hole8Score}"/></div>
		<div class="<c:out value="${match.score.player1Hole9CSSClass}"/>"><c:out value="${match.score.player1Hole9Score}"/></div>
		<div class="nine">&nbsp;</div>
		<div class="<c:out value="${match.score.player1Hole10CSSClass}"/>"><c:out value="${match.score.player1Hole10Score}"/></div>
		<div class="<c:out value="${match.score.player1Hole11CSSClass}"/>"><c:out value="${match.score.player1Hole11Score}"/></div>
		<div class="<c:out value="${match.score.player1Hole12CSSClass}"/>"><c:out value="${match.score.player1Hole12Score}"/></div>
		<div class="<c:out value="${match.score.player1Hole13CSSClass}"/>"><c:out value="${match.score.player1Hole13Score}"/></div>
		<div class="<c:out value="${match.score.player1Hole14CSSClass}"/>"><c:out value="${match.score.player1Hole14Score}"/></div>
		<div class="<c:out value="${match.score.player1Hole15CSSClass}"/>"><c:out value="${match.score.player1Hole15Score}"/></div>
		<div class="<c:out value="${match.score.player1Hole16CSSClass}"/>"><c:out value="${match.score.player1Hole16Score}"/></div>
		<div class="<c:out value="${match.score.player1Hole17CSSClass}"/>"><c:out value="${match.score.player1Hole17Score}"/></div>
		<div class="<c:out value="${match.score.player1Hole18CSSClass}"/> last-short"><c:out value="${match.score.player1Hole18Score}"/></div>
	</div>
	<div class="clear"></div>
	<div class="row womens-par">
		<div class="first"><fmt:message key="coursedetails.wpar"/></div>
		<c:forEach var="hole" begin="0" end="8" step="1">
			<div class="hole"><c:out value="${match.course.womensPars[hole]}"/></div>
		</c:forEach>
		<div class="nine">&nbsp;</div>
		<c:forEach var="hole" begin="9" end="17" step="1">
			<div class="hole"><c:out value="${match.course.womensPars[hole]}"/></div>
		</c:forEach>
	</div>
	<div class="clear"></div>
	<div class="row">
		<c:set var="userCssClass" value="first nostroke-player"/>
		<c:set var="nameCssClass" value="nostroke-player-name"/>
		<c:set var="hdcpCssClass" value="nostroke-player-hdcp"/>
		<c:if test="${match.score.golfer2Handicap gt match.score.golfer1Handicap}">
			<c:set var="userCssClass" value="first stroke-player"/>
			<c:set var="nameCssClass" value="stroke-player-name"/>
			<c:set var="hdcpCssClass" value="stroke-player-hdcp"/>
		</c:if>
		<div class="<c:out value="${userCssClass}"/>">
			<span class="<c:out value="${nameCssClass}"/>"><c:out value="${match.golfer2.displayName}"/></span> <span class="<c:out value="${hdcpCssClass}"/>">(<c:out value="${match.score.golfer2Handicap}"/>)</span>
		</div>
		<div class="<c:out value="${match.score.player2Hole1CSSClass}"/>"><c:out value="${match.score.player2Hole1Score}"/></div>
		<div class="<c:out value="${match.score.player2Hole2CSSClass}"/>"><c:out value="${match.score.player2Hole2Score}"/></div>
		<div class="<c:out value="${match.score.player2Hole3CSSClass}"/>"><c:out value="${match.score.player2Hole3Score}"/></div>
		<div class="<c:out value="${match.score.player2Hole4CSSClass}"/>"><c:out value="${match.score.player2Hole4Score}"/></div>
		<div class="<c:out value="${match.score.player2Hole5CSSClass}"/>"><c:out value="${match.score.player2Hole5Score}"/></div>
		<div class="<c:out value="${match.score.player2Hole6CSSClass}"/>"><c:out value="${match.score.player2Hole6Score}"/></div>
		<div class="<c:out value="${match.score.player2Hole7CSSClass}"/>"><c:out value="${match.score.player2Hole7Score}"/></div>
		<div class="<c:out value="${match.score.player2Hole8CSSClass}"/>"><c:out value="${match.score.player2Hole8Score}"/></div>
		<div class="<c:out value="${match.score.player2Hole9CSSClass}"/>"><c:out value="${match.score.player2Hole9Score}"/></div>
		<div class="nine">&nbsp;</div>
		<div class="<c:out value="${match.score.player2Hole10CSSClass}"/>"><c:out value="${match.score.player2Hole10Score}"/></div>
		<div class="<c:out value="${match.score.player2Hole11CSSClass}"/>"><c:out value="${match.score.player2Hole11Score}"/></div>
		<div class="<c:out value="${match.score.player2Hole12CSSClass}"/>"><c:out value="${match.score.player2Hole12Score}"/></div>
		<div class="<c:out value="${match.score.player2Hole13CSSClass}"/>"><c:out value="${match.score.player2Hole13Score}"/></div>
		<div class="<c:out value="${match.score.player2Hole14CSSClass}"/>"><c:out value="${match.score.player2Hole14Score}"/></div>
		<div class="<c:out value="${match.score.player2Hole15CSSClass}"/>"><c:out value="${match.score.player2Hole15Score}"/></div>
		<div class="<c:out value="${match.score.player2Hole16CSSClass}"/>"><c:out value="${match.score.player2Hole16Score}"/></div>
		<div class="<c:out value="${match.score.player2Hole17CSSClass}"/>"><c:out value="${match.score.player2Hole17Score}"/></div>
		<div class="<c:out value="${match.score.player2Hole18CSSClass}"/> last-short"><c:out value="${match.score.player2Hole18Score}"/></div>
	</div>
	<div class="clear"></div>
	<div class="standings-row">
		<div class="first">
			<fmt:message key="results.standing"/>
		</div>
		<c:choose>
			<c:when test="${match.score.score1 eq 0}">
				<div class="hole"><fmt:message key="results.allsquare"/></div>
			</c:when>
			<c:when test="${match.score.score1 gt 0}">
				<div class="hole">+<c:out value="${match.score.score1}"/></div>
			</c:when>
			<c:otherwise>
				<div class="hole"><c:out value="${match.score.score1}"/></div>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${match.score.score2 eq 0}">
				<div class="hole"><fmt:message key="results.allsquare"/></div>
			</c:when>
			<c:when test="${match.score.score2 gt 0}">
				<div class="hole">+<c:out value="${match.score.score2}"/></div>
			</c:when>
			<c:otherwise>
				<div class="hole"><c:out value="${match.score.score2}"/></div>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${match.score.score3 eq 0}">
				<div class="hole"><fmt:message key="results.allsquare"/></div>
			</c:when>
			<c:when test="${match.score.score3 gt 0}">
				<div class="hole">+<c:out value="${match.score.score3}"/></div>
			</c:when>
			<c:otherwise>
				<div class="hole"><c:out value="${match.score.score3}"/></div>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${match.score.score4 eq 0}">
				<div class="hole"><fmt:message key="results.allsquare"/></div>
			</c:when>
			<c:when test="${match.score.score4 gt 0}">
				<div class="hole">+<c:out value="${match.score.score4}"/></div>
			</c:when>
			<c:otherwise>
				<div class="hole"><c:out value="${match.score.score4}"/></div>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${match.score.score5 eq 0}">
				<div class="hole"><fmt:message key="results.allsquare"/></div>
			</c:when>
			<c:when test="${match.score.score5 gt 0}">
				<div class="hole">+<c:out value="${match.score.score5}"/></div>
			</c:when>
			<c:otherwise>
				<div class="hole"><c:out value="${match.score.score5}"/></div>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${match.score.score6 eq 0}">
				<div class="hole"><fmt:message key="results.allsquare"/></div>
			</c:when>
			<c:when test="${match.score.score6 gt 0}">
				<div class="hole">+<c:out value="${match.score.score6}"/></div>
			</c:when>
			<c:otherwise>
				<div class="hole"><c:out value="${match.score.score6}"/></div>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${match.score.score7 eq 0}">
				<div class="hole"><fmt:message key="results.allsquare"/></div>
			</c:when>
			<c:when test="${match.score.score7 gt 0}">
				<div class="hole">+<c:out value="${match.score.score7}"/></div>
			</c:when>
			<c:otherwise>
				<div class="hole"><c:out value="${match.score.score7}"/></div>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${match.score.score8 eq 0}">
				<div class="hole"><fmt:message key="results.allsquare"/></div>
			</c:when>
			<c:when test="${match.score.score8 gt 0}">
				<div class="hole">+<c:out value="${match.score.score8}"/></div>
			</c:when>
			<c:otherwise>
				<div class="hole"><c:out value="${match.score.score8}"/></div>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${match.score.score9 eq 0}">
				<div class="hole"><fmt:message key="results.allsquare"/></div>
			</c:when>
			<c:when test="${match.score.score9 gt 0}">
				<div class="hole">+<c:out value="${match.score.score9}"/></div>
			</c:when>
			<c:otherwise>
				<div class="hole"><c:out value="${match.score.score9}"/></div>
			</c:otherwise>
		</c:choose>
		<div class="nine">&nbsp;</div>
		<c:choose>
			<c:when test="${match.score.score10 eq 0}">
				<div class="hole"><fmt:message key="results.allsquare"/></div>
			</c:when>
			<c:when test="${match.score.score10 gt 0}">
				<div class="hole">+<c:out value="${match.score.score10}"/></div>
			</c:when>
			<c:otherwise>
				<div class="hole"><c:out value="${match.score.score10}"/></div>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${match.score.score11 eq 0}">
				<div class="hole"><fmt:message key="results.allsquare"/></div>
			</c:when>
			<c:when test="${match.score.score11 gt 0}">
				<div class="hole">+<c:out value="${match.score.score11}"/></div>
			</c:when>
			<c:otherwise>
				<div class="hole"><c:out value="${match.score.score11}"/></div>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${match.score.score12 eq 0}">
				<div class="hole"><fmt:message key="results.allsquare"/></div>
			</c:when>
			<c:when test="${match.score.score12 gt 0}">
				<div class="hole">+<c:out value="${match.score.score12}"/></div>
			</c:when>
			<c:otherwise>
				<div class="hole"><c:out value="${match.score.score12}"/></div>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${match.score.score13 eq 0}">
				<div class="hole"><fmt:message key="results.allsquare"/></div>
			</c:when>
			<c:when test="${match.score.score13 gt 0}">
				<div class="hole">+<c:out value="${match.score.score13}"/></div>
			</c:when>
			<c:otherwise>
				<div class="hole"><c:out value="${match.score.score13}"/></div>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${match.score.score14 eq 0}">
				<div class="hole"><fmt:message key="results.allsquare"/></div>
			</c:when>
			<c:when test="${match.score.score14 gt 0}">
				<div class="hole">+<c:out value="${match.score.score14}"/></div>
			</c:when>
			<c:otherwise>
				<div class="hole"><c:out value="${match.score.score14}"/></div>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${match.score.score15 eq 0}">
				<div class="hole"><fmt:message key="results.allsquare"/></div>
			</c:when>
			<c:when test="${match.score.score15 gt 0}">
				<div class="hole">+<c:out value="${match.score.score15}"/></div>
			</c:when>
			<c:otherwise>
				<div class="hole"><c:out value="${match.score.score15}"/></div>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${match.score.score16 eq 0}">
				<div class="hole"><fmt:message key="results.allsquare"/></div>
			</c:when>
			<c:when test="${match.score.score16 gt 0}">
				<div class="hole">+<c:out value="${match.score.score16}"/></div>
			</c:when>
			<c:otherwise>
				<div class="hole"><c:out value="${match.score.score16}"/></div>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${match.score.score17 eq 0}">
				<div class="hole"><fmt:message key="results.allsquare"/></div>
			</c:when>
			<c:when test="${match.score.score17 gt 0}">
				<div class="hole">+<c:out value="${match.score.score17}"/></div>
			</c:when>
			<c:otherwise>
				<div class="hole"><c:out value="${match.score.score17}"/></div>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${match.score.score18 eq 0}">
				<div class="hole last-short"><fmt:message key="results.allsquare"/></div>
			</c:when>
				<c:when test="${match.score.score18 gt 0}">
					<div class="hole last-short">+<c:out value="${match.score.score18}"/></div>
			</c:when>
			<c:otherwise>
				<div class="hole last-short"><c:out value="${match.score.score18}"/></div>
			</c:otherwise>
		</c:choose>
	</div>
</div>
</div>
 --%>
 
 <%-- <div class="left">
					<p>
						<img src="<c:url value="${match.golfer1.icon}"/>" alt="member" width="22"/>
							<c:out value="${match.golfer1.fullName}"/>
							<c:out value="${match.score.player1set1}"/>
							
							<img src="<c:url value="${match.golfer1.icon}"/>" alt="member" width="22"/>
							<c:out value="${match.golfer1.fullName}"/>
							<c:out value="${match.score.player1set2}"/>
							
							<img src="<c:url value="${match.golfer1.icon}"/>" alt="member" width="22"/>
							<c:out value="${match.golfer1.fullName}"/>
							<c:out value="${match.score.player1set3}"/>
					</p>
					<p>
						<img src="<c:url value="${match.golfer2.icon}"/>" alt="member" width="22"/>
							<c:out value="${match.golfer2.fullName}"/>
							<c:out value="${match.score.player2set1}"/>
							
						<img src="<c:url value="${match.golfer2.icon}"/>" alt="member" width="22"/>
							<c:out value="${match.golfer2.fullName}"/>
							<c:out value="${match.score.player2set2}"/>
							
						<img src="<c:url value="${match.golfer2.icon}"/>" alt="member" width="22"/>
							<c:out value="${match.golfer2.fullName}"/>
							<c:out value="${match.score.player2set3}"/>
					</p>
</div> --%>

<style type="text/css">
            body{
                background: #eee
            }
            /* .container{
                font-family:Arial, Helvetica, sans-serif;
                 background: #fff;
            } */
            .component-page{
                  width: 100%;
                padding: 10px 0px;
                overflow: hidden;
            }
             .hd-title{
                   width: 100%;
                    text-align: right;
                    overflow: hidden;
                    padding-bottom: 40px
            }
            .selected-country{
                    width: 30%;
                    float: left;
                    font-weight: bold;
                    font-size: 20px;
                    margin-right: 10px;
            }
            .score-list{
                  width: 65%;
                 float: right;
            }
            .super{
                vertical-align: super;
				 font-weight: normal;
				 font-size: 12px;
            }

            table.linescore {
                margin-right: auto;
                margin-left: 0;
                table-layout: fixed
            }

            table.linescore td {
                padding: .5em
            }

            table.linescore td {
                border: thin solid #ddd;
                font-weight: 700;
                text-align: right
            }

            table.linescore td.firstChild,table.linescore td:first-child {
                text-align: left;
                text-transform: uppercase
            }

            table.linescore td.firstChild,table.linescore td:first-child,table.linescore th.firstChild,table.linescore th:first-child {
                padding-right: 1.5em
            }

            table.linescore .runs {
                background-color: #9dc227;
            }
            .flag-icon{
                margin-right: 10px;
                width: 20px;
    			height: 20px; 
            }
            .char{
                font-size: 40px;
                vertical-align: super;
                position: relative;
                 top: -20px;
                float: left; 
                font-style: italic;
                    width: 12%;            
            }  
            .score-table{
                table-layout: auto;
                float: left;
                margin-left: 10px;
                background: #f8f8f8;
                width: 85%;
                color:#000000;    
                
            } 
             .score-table td {
                padding: .5em
            }

            table.score-table td {
                border: thin solid #ddd;
                font-weight: 700;
                text-align: left;
            }

            table.score-table td.firstChild {
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
            .trophy table{
                width: 50%;
            }
                
  
</style>

<div class="container">
      <div class="component-page">
          <div class="hd-title">
              <div class="selected-country">
              <p>PORTLAND Spring 2018 </p>
              <p>2 Wins 1 loss </p>
              </div>
              <div class="score-list">
                    <table class="centerAlign linescore">
                        <tbody>
                        <tr>
                            <td class="  leftAlign strong">Ankit</td>
        
                            <td class="strong runs">7 <span class="super">7</span></td>
                            <td>4</td>
                            <td>6</td>
                        </tr>
                      <tr>
                            <td class="leftAlign strong">Tomar</td>
                            <td>6  <span class="super">4</span></td>
                            <td class="strong runs">6</td>
                            <td>4</td>
                        </tr>
                    </tbody>
                </table>
              </div>
          </div>
      </div>
      <div class="component-page">
        <div class="column-3">
          <div class="char"> W </div>
                 <table class="centerAlign score-table">
                        <tbody>
                        <tr>
                            <td class=" leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer1.icon}"/>" alt="flag"><c:out value="${match.golfer1.fullName}"/></td>
                            <td>7 </td>
                            <td>4</td>
                          
                        </tr>
                      <tr>
                            <td class="  leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}"/></td>
                            <td>6  </td>
                            <td>6</td>
                           
                        </tr>
                    </tbody>
                </table>
            </div> 
      <div class="column-3">
          <div class="char"> W </div>
                 <table class="centerAlign score-table">
                        <tbody>
                        <tr>
                            <td class=" leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer1.icon}"/>" alt="flag"><c:out value="${match.golfer1.fullName}"/></td>
                            <td>7 </td>
                            <td>4</td>
                          
                        </tr>
                      <tr>
                            <td class="  leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}"/></td>
                            <td>6  </td>
                            <td>6</td>
                           
                        </tr>
                    </tbody>
                </table>
            </div>  
             <div class="column-3">
          <div class="char"> L </div>
                 <table class="centerAlign score-table">
                        <tbody>
                        <tr>
                            <td class=" leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer1.icon}"/>" alt="flag"><c:out value="${match.golfer1.fullName}"/></td>
                            <td>7 </td>
                            <td>4</td>
                          
                        </tr>
                      <tr>
                            <td class="  leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}"/></td>
                            <td>6  </td>
                            <td>6</td>
                           
                        </tr>
                    </tbody>
                </table>
            </div> 
      </div> 
      <div class="component-page">
          <div class="trophy">
                    <table class="centerAlign">
                        <tbody>
                        <tr>
                             <td style="text-align: right; font-weight: bold;">
                                  <p>PORTLAND Spring 2018</p> 
                                   <p>5 Wins 1 loss</p> 
                                   <p>Champion </p>
                             </td>
                            <td class=" leftAlign strong">
                               <img src="images/trophy.png" alt="trophy" width="60" height="60">
                             </td>
                        </tr>
                    </tbody>
                </table>
          </div>
      </div>   
         <div class="component-page">
        <div class="column-3">
          <div class="char"> L </div>
                 <table class="centerAlign score-table">
                        <tbody>
                        <tr>
                            <td class=" leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer1.icon}"/>" alt="flag"><c:out value="${match.golfer1.fullName}"/></td>
                            <td>7 </td>
                            <td>4</td>
                          
                        </tr>
                      <tr>
                            <td class="  leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}"/></td>
                            <td>6  </td>
                            <td>6</td>
                           
                        </tr>
                    </tbody>
                </table>
            </div> 
      <div class="column-3">
          <div class="char"> W </div>
                 <table class="centerAlign score-table">
                        <tbody>
                        <tr>
                            <td class=" leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer1.icon}"/>" alt="flag"><c:out value="${match.golfer1.fullName}"/></td>
                            <td>7 </td>
                            <td>4</td>
                          
                        </tr>
                      <tr>
                            <td class="  leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}"/></td>
                            <td>6  </td>
                            <td>6</td>
                           
                        </tr>
                    </tbody>
                </table>
            </div>  
             <div class="column-3">
          <div class="char"> W </div>
                 <table class="centerAlign score-table">
                        <tbody>
                        <tr>
                            <td class=" leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer1.icon}"/>" alt="flag"><c:out value="${match.golfer1.fullName}"/></td>
                            <td>7 </td>
                            <td>4</td>
                          
                        </tr>
                      <tr>
                            <td class="  leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}"/></td>
                            <td>6  </td>
                            <td>6</td>
                           
                        </tr>
                    </tbody>
                </table>
            </div> 
      </div> 
         <div class="component-page">
        <div class="column-3">
          <div class="char"> W </div>
                 <table class="centerAlign score-table">
                        <tbody>
                        <tr>
                            <td class=" leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer1.icon}"/>" alt="flag"><c:out value="${match.golfer1.fullName}"/></td>
                            <td>7 </td>
                            <td>4</td>
                          
                        </tr>
                      <tr>
                            <td class="  leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}"/></td>
                            <td>6  </td>
                            <td>6</td>
                           
                        </tr>
                    </tbody>
                </table>
            </div> 
      <div class="column-3">
          <div class="char"> W </div>
                 <table class="centerAlign score-table">
                        <tbody>
                        <tr>
                            <td class=" leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer1.icon}"/>" alt="flag"><c:out value="${match.golfer1.fullName}"/></td>
                            <td>7 </td>
                            <td>4</td>
                          
                        </tr>
                      <tr>
                            <td class="  leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}"/></td>
                            <td>6  </td>
                            <td>6</td>
                           
                        </tr>
                    </tbody>
                </table>
            </div>  
             <div class="column-3">
          <div class="char"> W </div>
                 <table class="centerAlign score-table">
                        <tbody>
                        <tr>
                            <td class=" leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer1.icon}"/>" alt="flag"><c:out value="${match.golfer1.fullName}"/></td>
                            <td>7 </td>
                            <td>4</td>
                          
                        </tr>
                      <tr>
                            <td class="  leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}"/></td>
                            <td>6  </td>
                            <td>6</td>
                           
                        </tr>
                    </tbody>
                </table>
            </div> 
      </div> 
        <h3 style="text-align:center;text-transform: uppercase;font-weight: bold;">Playoffs</h3>
         <div class="component-page">
        <div class="column-3">
          <div class="char"> W </div>
                 <table class="centerAlign score-table">
                        <tbody>
                        <tr>
                            <td class=" leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer1.icon}"/>" alt="flag"><c:out value="${match.golfer1.fullName}"/></td>
                            <td>7 </td>
                            <td>4</td>
                          
                        </tr>
                      <tr>
                            <td class="  leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}"/></td>
                            <td>6  </td>
                            <td>6</td>
                           
                        </tr>
                    </tbody>
                </table>
            </div> 
      <div class="column-3">
          <div class="char"> W </div>
                 <table class="centerAlign score-table">
                        <tbody>
                        <tr>
                            <td class=" leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer1.icon}"/>" alt="flag"><c:out value="${match.golfer1.fullName}"/></td>
                            <td>7 </td>
                            <td>4</td>
                          
                        </tr>
                      <tr>
                            <td class="  leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}"/></td>
                            <td>6  </td>
                            <td>6</td>
                           
                        </tr>
                    </tbody>
                </table>
            </div>  
             <div class="column-3">
          <div class="char"> W </div>
                 <table class="centerAlign score-table">
                        <tbody>
                        <tr>
                            <td class=" leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer1.icon}"/>" alt="flag"><c:out value="${match.golfer1.fullName}"/></td>
                            <td>7 </td>
                            <td>4</td>
                          
                        </tr>
                      <tr>
                            <td class="  leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}"/></td>
                            <td>6  </td>
                            <td>6</td>
                           
                        </tr>
                    </tbody>
                </table>
            </div> 
      </div> 
  </div>
