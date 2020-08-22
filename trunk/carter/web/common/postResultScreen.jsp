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
            }
			.selected-country {
				width: 195px;
			    /* float: left; */
			    font-weight: 500;
			    font-size: 15px;
			    margin-right: 0;
			    transform: rotateZ(-90deg);
			    position: absolute;
			    left: -120px;
			    padding: 10px 10px;
			    bottom: 76px;
			    background: #9cb23b;
			    color: #fff;
			}
			.mt-40{margin: 40px 50px 0 60px;}
            .retiredWin{
                  width: 38%;
                 float: right;
                 margin-right: -15px;
                 margin-top:-45px;
            }
			.score-list {
				width:100%;
				background: #fff;
				padding: 30px;
				min-height: 210px; 
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
               /* border: thin solid #ddd;*/
                font-weight: 700;
                text-align: right
            }

            table.linescore td.firstChild,table.linescore td:first-child {
                text-align: left;
              
            }

            table.linescore td.firstChild,table.linescore td:first-child,table.linescore th.firstChild,table.linescore th:first-child {
                padding-right: 1.5em
            }

            
            .flag-icon{
                margin-right: 10px;
                width: 40px;
    			height: 40px; 
    			vertical-align:middle;
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
					display:inline-block;
				font-weight: bold;
				font-size: 15px;
				width:100%;
				background: #dedede;
				position: absolute;
				top: -40px;
				padding: 15px;
				left: 0px;
            }
			.match-status {
				font-weight: bold;
				font-size: 30px; 
				position: absolute;
				top: 50%;
				padding: 5px;
				right:-45px;
				color: #9cb23b;
				 transform:translateY(-50%)
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
            
            table.centerAlign.linescore tr td:first-child{width:200px;}
  
</style>

<div>
      <div class="component-page">
           <div class="row mt-5 ">
          <div class="hd-title  col-lg-6">
          <div class=" position-relative mt-40">
              <div class="selected-country">
              <p><c:out value="${seasonName}"/></p>
              
               <%-- original code  <p><c:out value="${match.golfer1.currentSeason.city.name}, ${match.golfer1.currentSeason.name}"/></p>  --%>
              <%-- <p><c:out value="${user.currentWins} Wins  "/><c:out value="${user.currentLosses} Loss  "/></p> --%>
              
              </div>
              
                 <div class="matchDate">
			      <p>
			        <fmt:formatDate value="${match.played}" pattern="MMM dd, yyyy"/>   <c:out value="${tournamentName}"/>
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
                    <table class="centerAlign linescore ">
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
                            <span><c:out value="${match.score.player1set1} "/></span>
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
                            <span><c:out value="${match.score.player1set2} "/></span>
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
							 <c:if test="${(null != match.score.player1set3) && match.score.player1set3 > 0}">
	                            <span><c:out value="${match.score.player1set3} "/></span>
	                         </c:if>
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
							<span><c:out value="${match.score.player2set1} "/></span> 
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
							<span><c:out value="${match.score.player2set2} "/></span>
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
							<c:if test="${(null != match.score.player2set3) && match.score.player2set3 > 0}">
								<span><c:out value="${match.score.player2set3} "/></span>
							 </c:if>
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
      
  </div>