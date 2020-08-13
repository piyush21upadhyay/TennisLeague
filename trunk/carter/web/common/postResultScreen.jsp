<%@ include file="/common/taglibs.jsp"%>
<c:if test="${empty match}">
	<c:set var="match" value="${matchParam}"/>
</c:if>

<style type="text/css">
              body{
                background: #fff;
            }
             .container{
                font-family:Arial, Helvetica, sans-serif;
                /* background: #212121;*/
            } 
            .component-page{
                /*  width: 124%;
                padding: 10px 0px;
                overflow: hidden;*/
            }
             .hd-title{
              padding-bottom: 40px;
				position: relative;
				margin-top: 50px;
				 margin-left: 25px;
            }
			.selected-country {
				width: 65%;
				/* float: left; */
				font-weight: 500;
				font-size: 15px;
				margin-right: 10px;
				transform: rotateZ(-90deg);
				position: absolute;
				left: -33%;
				padding: 10px 10px;
				bottom: 50%;
				background: #9cb23b;
				color: #fff;
				font-family: "Avant_Garde_Gothic", Arial, sans-serif;
			}
            .retiredWin{
                  width: 38%;
                 float: right;
                 margin-right: -15px;
                 margin-top:-45px;
            }
			.score-list {
				width: 90%;
				background: #fff;
				padding: 30px;
				min-height: 270px;
				margin-top: 10px;
				box-shadow: 0 .5rem 1rem rgba(0,0,0,.15)!important;
			}
            .super{
                vertical-align: super;
				 font-weight: normal;
				 font-size: 12px;
            }

			table.linescore {
				margin-right: auto;
				margin-left: 0;
				table-layout: fixed;
				width: 100% !important;
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
            .matchDate{
				float: left;
				font-weight: bold;
				font-size: 15px;
				width: 82%;
				background: #dedede;
				position: absolute;
				top: -35px;
				padding: 10px;
				left: 21px;
            }
			.match-status {
				width: 5%;
				float: left;
				font-weight: bold;
				font-size: 30px;
				/* width: 92%; */
				/* background: #dedede; */
				position: absolute;
				top: 30%;
				padding: 5px;
				right: 30px;
				color: #9cb23b;
				bottom: 0;
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

<div>
      <div class="component-page">
           <div class="row">
          <div class="hd-title col-sm-4">
              <div class="selected-country">
              <p><c:out value="${match.golfer1.currentSeason.city.name}, ${match.golfer1.currentSeason.name}"/></p>
              <%-- <p><c:out value="${user.currentWins} Wins  "/><c:out value="${user.currentLosses} Loss  "/></p> --%>
              
              </div>
              
                 <div class="matchDate">
			      <p>
			        <fmt:formatDate value="${match.played}" pattern="MMM dd, yyyy"/>
			    </p>
			    
			  </div>
              <div class="match-status">
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
				 <div class="score-list">
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
                            
                            <%-- <c:choose>
                            	<c:when test="${(null != match.score.opponentRetired) && match.score.opponentRetired == match.golfer2.id}">
									 <td> <fmt:message key="results.opponentRetired"/>
								</c:when>
								<c:otherwise> --%>
									<c:choose>
										<c:when test="${match.score.player1set3 > match.score.player2set3}"> 
											<td class="strong runs">
										</c:when>
										<c:otherwise>
											<td>
										</c:otherwise>
									</c:choose>
								<%-- </c:otherwise>
							</c:choose> --%>
							<%-- <c:if test="${(null == match.score.opponentRetired)}"> --%>
	                            <c:out value="${match.score.player1set3} "/>
	                            <c:if test="${(null != match.score.player1set3Sup) && match.score.player1set3Sup > 0}">
	                            	<span class="super"><c:out value="${match.score.player1set3Sup}"/></span>
	                            </c:if>
	                        <%-- </c:if> --%>
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
							
                            <%-- <c:choose>
                            	<c:when test="${(null != match.score.opponentRetired) && match.score.opponentRetired == match.golfer1.id}">
									<td> <fmt:message key="results.opponentRetired"/>
								</c:when>
								<c:otherwise> --%>
									<c:choose>
										<c:when test="${match.score.player2set3 > match.score.player1set3}"> 
											<td class="strong runs">
										</c:when>
										<c:otherwise>
											<td>
										</c:otherwise>
									</c:choose>
								<%-- </c:otherwise>
							</c:choose> --%>
							<%-- <c:if test="${(null == match.score.opponentRetired)}"> --%>
								<c:out value="${match.score.player2set3} "/>
								<c:if test="${(null != match.score.player2set3Sup) && match.score.player2set3Sup > 0}">
	                            	<span class="super"><c:out value="${match.score.player2set3Sup}"/></span>
	                            </c:if>
	                         <%-- </c:if> --%>
							</td>
                        </tr>
                    </tbody>
                </table>
              </div>
              <div class="retiredWin">
             
           		<c:if test="${match.opponentRetiredWin}">
                    <fmt:message key="results.opponentRetired"/>
                </c:if>
             </div>
             </div>
          </div>
      </div>
      
  </div>