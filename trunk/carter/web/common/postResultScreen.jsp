<%@ include file="/common/taglibs.jsp"%>
<c:if test="${empty match}">
	<c:set var="match" value="${matchParam}"/>
</c:if>

<style type="text/css">
            body{
                background: #eee
            }
             .container{
                font-family:Arial, Helvetica, sans-serif;
                 background: #212121;
            } 
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
                font-size: 55px;
                vertical-align: super;
                position: relative;
                 /* top: -20px; */
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
              <p><c:out value="${match.golfer1.currentSeason.city.name}, ${match.golfer1.currentSeason.name}"/></p>
              <%-- <p><c:out value="${user.currentWins} Wins  "/><c:out value="${user.currentLosses} Loss  "/></p> --%>
              
              </div>
              
              <div class="score-list">
              <div class="char">
          <%--     <%! 
              int player1Wins=0;
              int player2Wins=0;
              String winLose="";
              %>
				<c:choose>
					<c:when test="${match.score.player1set1 > match.score.player2set1}">
					<% player1Wins++; %>
					</c:when>
					<c:otherwise>
					<% player2Wins++; %>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${match.score.player1set2 > match.score.player2set2}">
					<% player1Wins++; %>
					</c:when>
					<c:otherwise>
					<% player2Wins++; %>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${match.score.player1set3 > match.score.player2set3}">
					<% player1Wins++; %>
					</c:when>
					<c:otherwise>
					<% player2Wins++; %>
					</c:otherwise>
				</c:choose>
				
				<% 
				if(player1Wins > player2Wins)
					winLose = "W";
				else
					winLose = "L";
				%>
				<%= winLose %>  --%>
				
				
				<c:choose>
					<c:when test="${user.id == match.result.winner.id}">
					<%= "W" %> 
					</c:when>
					<c:otherwise>
					<%= "L" %> 
					</c:otherwise>
				</c:choose>
				
				

				</div>
                    <table class="centerAlign linescore">
                        <tbody>
                        <tr>
                            <td class="  leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer1.icon}"/>" alt="flag"><c:out value="${match.golfer1.fullName}"/></td>
        					<c:choose>
								<c:when test="${match.score.player1set1 > match.score.player2set1}"> 
									<td class="strong runs">
								</c:when>
								<c:otherwise>
									<td>
								</c:otherwise>
							</c:choose>
                            <c:out value="${match.score.player1set1} "/>
                            <c:if test="${(null != match.score.player1set1Sup) && match.score.player1set1Sup > 0}">
                            	<span class="super"><c:out value="${match.score.player1set1Sup}"/></span>
                            </c:if>
                            </td>
                            
                            <c:choose>
								<c:when test="${match.score.player1set2 > match.score.player2set2}"> 
									<td class="strong runs">
								</c:when>
								<c:otherwise>
									<td>
								</c:otherwise>
							</c:choose>
                            <c:out value="${match.score.player1set2} "/>
                            <c:if test="${(null != match.score.player1set2Sup) && match.score.player1set2Sup > 0}">
                            	<span class="super"><c:out value="${match.score.player1set2Sup}"/></span>
                            </c:if>
                            </td>
                            
                            <c:choose>
                            	<c:when test="${(null != match.score.opponentRetired) && match.score.opponentRetired == match.golfer2.id}">
									 <td> <fmt:message key="results.opponentRetired"/>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${match.score.player1set3 > match.score.player2set3}"> 
											<td class="strong runs">
										</c:when>
										<c:otherwise>
											<td>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
							<c:if test="${(null == match.score.opponentRetired)}">
	                            <c:out value="${match.score.player1set3} "/>
	                            <c:if test="${(null != match.score.player1set3Sup) && match.score.player1set3Sup > 0}">
	                            	<span class="super"><c:out value="${match.score.player1set3Sup}"/></span>
	                            </c:if>
	                        </c:if>
                            </td>
                        </tr>
                      	<tr>
                            <td class="  leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}"/></td>
                           <c:choose>
								<c:when test="${match.score.player2set1 > match.score.player1set1}"> 
									<td class="strong runs">
								</c:when>
								<c:otherwise>
									<td>
								</c:otherwise>
							</c:choose>
							<c:out value="${match.score.player2set1} "/> 
							 <c:if test="${(null != match.score.player2set1Sup) && match.score.player2set1Sup > 0}">
                            	<span class="super"><c:out value="${match.score.player2set1Sup}"/></span>
                            </c:if>
							</td>
							
                            <c:choose>
								<c:when test="${match.score.player2set2 > match.score.player1set2}"> 
									<td class="strong runs">
								</c:when>
								<c:otherwise>
									<td>
								</c:otherwise>
							</c:choose>
							<c:out value="${match.score.player2set2} "/>
							<c:if test="${(null != match.score.player2set2Sup) && match.score.player2set2Sup > 0}">
                            	<span class="super"><c:out value="${match.score.player2set2Sup}"/></span>
                            </c:if>
							</td>
							
                            <c:choose>
                            	<c:when test="${(null != match.score.opponentRetired) && match.score.opponentRetired == match.golfer1.id}">
									<td> <fmt:message key="results.opponentRetired"/>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${match.score.player2set3 > match.score.player1set3}"> 
											<td class="strong runs">
										</c:when>
										<c:otherwise>
											<td>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
							<c:if test="${(null == match.score.opponentRetired)}">
								<c:out value="${match.score.player2set3} "/>
								<c:if test="${(null != match.score.player2set3Sup) && match.score.player2set3Sup > 0}">
	                            	<span class="super"><c:out value="${match.score.player2set3Sup}"/></span>
	                            </c:if>
	                         </c:if>
							</td>
                        </tr>
                    </tbody>
                </table>
              </div>
          </div>
      </div>
      
  </div>
