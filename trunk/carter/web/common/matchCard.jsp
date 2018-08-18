<%@ include file="/common/taglibs.jsp"%>
<c:if test="${empty match}">
	<c:set var="match" value="${matchParam}"/>
</c:if>

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
              <p><c:out value="${user.currentSeason.city.name}, ${user.currentSeason.name}"/></p>
              <p><c:out value="${user.currentWins} Wins  "/><c:out value="${user.currentLosses} Loss  "/></p>
              </div>
              <div class="score-list">
                    <table class="centerAlign linescore">
                        <tbody>
                        <tr>
                            <td class="  leftAlign strong"><c:out value="${user.firstName}"/></td>
        
                            <td class="strong runs"><c:out value="${match.score.player1set1} "/><span class="super">7</span></td>
                            <td><c:out value="${match.score.player1set2} "/></td>
                            <td><c:out value="${match.score.player1set3} "/></td>
                        </tr>
                      <tr>
                            <td class="leftAlign strong"><c:out value="${user.lastName}"/></td>
                            <td><c:out value="${match.score.player2set1} "/> <span class="super">4</span></td>
                            <td class="strong runs"><c:out value="${match.score.player2set2} "/></td>
                            <td><c:out value="${match.score.player2set3} "/></td>
                        </tr>
                    </tbody>
                </table>
              </div>
          </div>
      </div>
      <div class="component-page">
      
      <!-- Match 1 Set 1 starts -->
		<div class="column-3">
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
	<!-- Match 1 Set 3 ends -->
	</div>
      
      <!-- Dynamic done upto here, Need more clarity to do further -->
       
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
                                                      
                        </tr>
                      <tr>
                            <td class="  leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}"/></td>
                            <td>6  </td>
                                                       
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
                                                      
                        </tr>
                      <tr>
                            <td class="  leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}"/></td>
                            <td>6  </td>
                                                       
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
                                                      
                        </tr>
                      <tr>
                            <td class="  leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}"/></td>
                            <td>6  </td>
                                                       
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
                                                      
                        </tr>
                      <tr>
                            <td class="  leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}"/></td>
                            <td>6  </td>
                                                      
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
                                                      
                        </tr>
                      <tr>
                            <td class="  leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}"/></td>
                            <td>6  </td>
                                                      
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
                                                     
                        </tr>
                      <tr>
                            <td class="  leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}"/></td>
                            <td>6  </td>
                                                       
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
                                                      
                        </tr>
                      <tr>
                            <td class="  leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}"/></td>
                            <td>6  </td>
                                                    
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
                                                     
                        </tr>
                      <tr>
                            <td class="  leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}"/></td>
                            <td>6  </td>
                                                       
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
                                                      
                        </tr>
                      <tr>
                            <td class="  leftAlign strong"><img class="flag-icon" src="<c:url value="${match.golfer2.icon}"/>" alt="flag"><c:out value="${match.golfer2.fullName}"/></td>
                            <td>6  </td>
                                                       
                        </tr>
                    </tbody>
                </table>
            </div> 
      </div> 
  </div>
