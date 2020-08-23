<%@ include file="/common/taglibs.jsp"%>
<head>
    <title><fmt:message key="sendMsg.title"/></title>
    <meta name="menu" content="Lookup"/>
    
    <style type="text/css">
	/* Safari/Chrome css hack */
	@media screen and (-webkit-min-device-pixel-ratio:0)
	{
		.td-spacer{width:10px;}
	}
	</style>
</head>

<c:if test="${not empty member}">

<div class="msgboard-section">
	<div class="left">
		<h2><fmt:message key="sendMsg.header"/></h2>
		<div class="msguser sentMsgSection">
			<c:set var="player" value="${member}" scope="request"/>
			<c:set var="msgLink" value="${not empty sentMessage}"/>
			<c:import url="/common/playerInfo.jsp">
				<c:param name="showProfileButton" value="true"/>
				<c:param name="displayScheduleLink" value="true"/>
				<c:param name="displayMessageLink" value="${msgLink}"/>
			</c:import>
		</div>
	</div>

	<div class="right mr-compose">
		<c:choose>
			<c:when test="${not empty sentMessage}">
				<h2><fmt:message key="sendMsg.sent"/></h2>
			</c:when>
			<c:otherwise>
				<h2><fmt:message key="sendMsg.create"/></h2>
				
				<spring:bind path="privateMessage.*">
				    <c:if test="${not empty status.errorMessages}">
				    <div class="error">
				        <c:forEach var="error" items="${status.errorMessages}">
				            <img src="<c:url value="/images/iconWarning.gif"/>"
				                alt="<fmt:message key="icon.warning"/>" class="icon"/>
				            <c:out value="${error}" escapeXml="false"/><br />
				        </c:forEach>
				    </div>
				    </c:if>
				</spring:bind>
			</c:otherwise>
		</c:choose>

		<div class="compose">
			<c:choose>
				<c:when test="${not empty sentMessage}">
					<h3><c:out value="${sentMessage}"/></h3>
				</c:when>
				<c:otherwise>
				
					<form:form commandName="privateMessage" id="msgForm">
						<form:hidden path="to"/>
						<table>
							<tr>
								<td>
									<label for="to"><fmt:message key="sendMsg.to"/></label>
									<input type="text" class="longBox" value="<c:out value="${member.fullName}"/>" disabled="true" id="to"/>
								</td>
								<td class="td-spacer"></td>
								<td>
									<label for="subject"><fmt:message key="sendMsg.subject"/></label>
									<form:input id="subject" path="subject" cssClass="longBox" maxlength="60"/>
								</td>
							</tr>
							<tr>
								<td colspan="3">
									<label for="message"><fmt:message key="sendMsg.message"/></label>
					    			<form:textarea path="message" cssClass="emailMessage" id="message" />
								</td>
							</tr>
							<tr>
								<td colspan="3">
									<div class="buttons">
								    	<div class="left">
											<carter:button onclick="return onFormSubmit(document.getElementById('msgForm'));" key="button.send"/>
								    	</div>
								    	<div class="left">
											<carter:button onclick="document.getElementById('bCancel').value='true';document.getElementById('msgForm').submit();return false;" key="button.cancel"/>
									    </div>
										<input id="bCancel" type="hidden" name="bCancel" value="false"/>
								    </div>
								</td>
							</tr>
						</table>
					    <div class="clear"></div>
				    </form:form>
					<script type="text/javascript">
						if ($("#subject:first").val() == "") {
							$("#subject").focus();
						} else {
							focusMessage();
						}
						function focusMessage() {
							var ctrl = document.getElementById("message");
							if (ctrl.setSelectionRange) {
								ctrl.setSelectionRange(0,0);
							} else if (ctrl.createTextRange) {
								var range = ctrl.createTextRange();
								range.collapse(true);
								range.moveEnd('character', 0);
								range.moveStart('character', 0);
								range.select();
							}
							ctrl.focus();
						}
					    function onFormSubmit(theForm) {
				    	    if (validatePrivateMessage(theForm))
				    	        return theForm.submit();
				    	    return false;
				    	}
					</script>
				    <v:javascript formName="privateMessage" staticJavascript="false"/>
				    <script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
</c:if>
