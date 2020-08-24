<%@ include file="/common/taglibs.jsp"%>
<c:if test="${empty match}">
	<c:set var="match" value="${matchParam}"/>
</c:if>

<style type="text/css">
            body{
                background: #fff;
            }
            /* .container{
                font-family:Arial, Helvetica, sans-serif;
                 background: #fff;
            } */
            .component-page{
                 /* width: 124%;
                padding: 10px 0px;
                overflow: hidden;*/
            }
             .hd-title{
              padding-bottom: 40px;
            }
			.score-list {
				width:100%;
				background: #fff;
				padding: 30px;
				min-height: 210px; 
				box-shadow: 0 .5rem 1rem rgba(0,0,0,.15)!important;
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
            .mt-40{margin: 40px 50px 0 60px;}
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
            .retiredWin{
                  width: 38%;
                 float: right;
                 margin-right: -15px;
                 margin-top:-35px;
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
                width: 100%;
            }

            table.linescore td {
                padding: .5em
            }

            table.linescore td {
               
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
                
            table.centerAlign.linescore tr td:first-child { width: 140px;}
             .score-list span {border:1px solid #ccc; border-radius:3px; display:inline-block; padding:15px 20px; }
              @media only screen and (min-width:992px) and (max-width:1160px){
                .score-list{padding:30px 10px;}
                 table.centerAlign.linescore tr td:first-child { width: 80px;}
                }
  
</style>
<h2 class="page-title"> Schedule</h2>
<div class="">
      <div class="component-page">
      
	      <div class="row mt-5 ">
          <div class="hd-title col-lg-6">
          <div class=" position-relative mt-40">
              <div class="selected-country">
              <p><c:out value="${seasonName}"/></p>
              <%-- <p><c:out value="${user.currentWins} Wins  "/><c:out value="${user.currentLosses} Loss  "/></p> --%>
              </div>
                <div class="matchDate">
				<div class="match-date"> 
				<c:choose>
					<c:when test="${not empty match.played}">
						<!-- Played on :  --> <fmt:formatDate pattern="MMM dd, yyyy" value="${match.played}"/>  <c:out value="${tournamentName}"/> 
					</c:when>
					<c:when test="${empty match.played and empty match.golfer2}">
						Played By : <fmt:formatDate pattern="MMM dd, yyyy" value="${match.playBy}"/>
					</c:when>
					<c:otherwise>
						
					</c:otherwise>
				</c:choose>
				</div>
			  </div>
             <div class="match-status">
	              <c:choose>
	              		<c:when test="${not empty user}">
	              			<c:choose>
								<c:when test="${user.id == match.result.winner.id}">
								<%= "W" %> 
								</c:when>
								<c:otherwise>
								<%= "L" %> 
								</c:otherwise>
								</c:choose>
						</c:when>
						<c:otherwise>
							<c:choose>
								<%-- <c:when test="${match.golfer1.id == match.result.winner.id}"> --%>
								<c:when test="${currIdOfUser == match.result.winner.id}">
									<%= "W" %> 
								</c:when>
								<c:otherwise>
								<%= "L" %> 
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
              </div>
              
              <c:choose>
				<c:when test="${match.defaultWin}">
					<c:choose>
						<c:when test="${user.id == match.result.winner.id}">
							<div class="score-list">
              					<p><fmt:message key="record.defaultWin"/></p>
              				</div>
              			</c:when>
              			<c:otherwise>
              				<div class="score-list">
              					<p><fmt:message key="record.defaultLoss"/></p>
              				</div>
              			</c:otherwise>
              		</c:choose>
              	</c:when>
              	<c:when test="${match.bye}">
					<div class="score-list">
              			<p><fmt:message key="record.byeWin"/></p>
              		</div>
              	</c:when>
              	<c:otherwise>
              		<div class="score-list">
                    	<table class="centerAlign linescore">
                        	<tbody>
                        	<tr>
                            	<td class="  leftAlign strong"><c:out value="${match.golfer1.fullName}"/>
                            	<%-- <img src="<c:url value="${match.golfer1.icon}"/>"/> --%>
                            	</td>
        							<c:choose>
										<c:when test="${match.score.player1set1 > match.score.player2set1}"> 
											<td class="strong runs">
										</c:when>
										<c:otherwise>
											<td>
										</c:otherwise>
									</c:choose>
                            				<span class="position-relative"><c:out value="${match.score.player1set1} "/> <sup class="abs_sup_span"><c:out value="${match.score.player1set1Sup}"/></sup></span>
                            			<c:if test="${(null != match.score.player1set1Sup) && match.score.player1set1Sup > 0}">
                            				 
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
                            				<span class="position-relative"><c:out value="${match.score.player1set2} "/> <sup class="abs_sup_span"><c:out value="${match.score.player1set2Sup}"/></sup></span>
                            				<c:if test="${(null != match.score.player1set2Sup) && match.score.player1set2Sup > 0}">
                            					
                            				</c:if>
                            				</td>
                            
                            		<c:choose>
										<c:when test="${match.score.player1set3 > match.score.player2set3}"> 
											<td class="strong runs">
										</c:when>
										<c:otherwise>
											<td>
										</c:otherwise>
									</c:choose>
                            				<c:if test="${(null != match.score.player1set3) && match.score.player1set3 > 0}">
	                            				<span class="position-relative"><c:out value="${match.score.player1set3} "/> <sup class="abs_sup_span"><c:out value="${match.score.player1set3Sup}"/></sup></span>
	                         				</c:if>
                            				</td>
                        	</tr>
                      		<tr>
                            	   <td class="  leftAlign strong"><c:out value="${match.golfer2.fullName}"/></td>
                           		<c:choose>
									<c:when test="${match.score.player2set1 > match.score.player1set1}"> 
										<td class="strong runs">
									</c:when>
								<c:otherwise>
										<td>
								</c:otherwise>
								</c:choose>
									<span class="position-relative"><c:out value="${match.score.player2set1} "/> <sup class="abs_sup_span"><c:out value="${match.score.player2set1Sup}"/></sup></span>
							 			<c:if test="${(null != match.score.player2set1Sup) && match.score.player2set1Sup > 0}">
                            			
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
									<span class="position-relative"><c:out value="${match.score.player2set2} "/><sup class="abs_sup_span"><c:out value="${match.score.player2set2Sup}"/></sup></span>
									<c:if test="${(null != match.score.player2set2Sup) && match.score.player2set2Sup > 0}">
                            			
                            		</c:if>
									</td>
							
                            	<c:choose>
									<c:when test="${match.score.player2set3 > match.score.player1set3}"> 
										<td class="strong runs">
									</c:when>
									<c:otherwise>
										<td>
									</c:otherwise>
								</c:choose>
									<c:if test="${(null != match.score.player2set3) && match.score.player2set3 > 0}">
										<span class="position-relative"><c:out value="${match.score.player2set3} "/> <sup class="abs_sup_span"><c:out value="${match.score.player2set3Sup}"/></sup></span>
							 		</c:if>
									<c:if test="${(null != match.score.player2set3Sup) && match.score.player2set3Sup > 0}">
                            			
                            		</c:if>
									</td>
                        </tr>
                    </tbody>
                </table>
              </div>
              </c:otherwise>
             </c:choose>
             
             <div class="retiredWin">
             
           		<c:if test="${match.opponentRetiredWin}">
                    <fmt:message key="results.opponentRetired"/>
                </c:if>
             
             </div>
              
             </div> 
             </div> 
          </div>
      </div>
      <!-- <div class="component-page"> -->
  
 <!-- Code commented as per requirement given by the PPT named 'Changes 3_3_2019' ends --> 
      <!-- Match 1 Set 1 starts -->
<%-- 		<!--<div class="column-3">
			<div class="char">
				<c:choose>
					<c:when test="${match.score.player1set1 > match.score.player2set1}"> W </c:when>
					<c:otherwise>L</c:otherwise>
				</c:choose>

			</div>
			<table class="centerAlign score-table">
				<tbody>
					<tr>
						<td class=" leftAlign strong">
							<img class="flag-icon" src="<c:url value="${match.golfer1.icon}"/>" alt="flag"><c:out value="${match.golfer1.fullName}" />
						</td>
						<td><c:out value="${match.score.player1set1} " /></td>

					</tr>
					<tr>
						<td class="  leftAlign strong">
							<img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}" />
						</td>
						<td><c:out value="${match.score.player2set1} " /></td>

					</tr>
				</tbody>
			</table>
		</div>
	<!-- Match 1 Set 1 ends -->
	
	<!-- Match 1 Set 2 starts -->
		<div class="column-3">
			<div class="char">
				<c:choose>
					<c:when test="${match.score.player1set2 > match.score.player2set2}"> W </c:when>
					<c:otherwise>L</c:otherwise>
				</c:choose>
			</div>
			<table class="centerAlign score-table">
				<tbody>
					<tr>
						<td class=" leftAlign strong">
							<img class="flag-icon" src="<c:url value="${match.golfer1.icon}"/>" alt="flag"><c:out value="${match.golfer1.fullName}" />
						</td>
						<td><c:out value="${match.score.player1set2} " /></td>
					</tr>
					<tr>
						<td class="  leftAlign strong">
							<img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}" />
						</td>
						<td><c:out value="${match.score.player2set2} " /></td>
					</tr>
				</tbody>
			</table>
		</div>
	<!-- Match 1 Set 2 ends -->
	
	<!-- Match 1 Set 3 starts -->
		<div class="column-3">
			<div class="char">
				<c:choose>
					<c:when test="${match.score.player1set3 > match.score.player2set3}"> W </c:when>
					<c:otherwise>L</c:otherwise>
				</c:choose>
			</div>
			<table class="centerAlign score-table">
				<tbody>
					<tr>
						<td class=" leftAlign strong">
							<img class="flag-icon" src="<c:url value="${match.golfer1.icon}"/>" alt="flag"><c:out value="${match.golfer1.fullName}" />
						</td>
						<td><c:out value="${match.score.player1set3} " /></td>
					</tr>
					
					<tr>
						<td class="  leftAlign strong">
							<img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}" />
						</td>
						<td><c:out value="${match.score.player2set3} " /></td>

					</tr>
				</tbody>
			</table>
		</div>
	</div> --%>
	<!-- Match 1 Set 3 ends -->
      
<!-- Code commented as per requirement given by the PPT named 'Changes 3_3_2019' ends -->
  </div>