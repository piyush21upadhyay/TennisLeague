<%@ include file="/common/taglibs.jsp"%>

<c:if test="${not empty city}">

<script type="text/javascript">
	$(function(){
		var objAnc = $(".tbl-msg-div td a");
		$.each(objAnc, function(){
			if( $(this).attr("href") == '/carter/msgboard.html' )
			{
				$(this).addClass("custom-txt-dec");
				$(this).removeAttr("href");					
			}
		});
		
		var tbodyObj = document.getElementById("message").children[1];	//tbody object
		var trArray = document.getElementById("message").children[1].children;	//tr array
		
		if(navigator.userAgent.match(/msie/gi) == 'MSIE')
		{
			if(tbodyObj.children.length > 5)
			{
				<c:if test="${not empty showDeleteBtn}">
				$("#message tbody").css("width","465px");
				</c:if>
			}
			else
			{
				<c:if test="${empty showDeleteBtn}">
				var vTrSibling = $("#message thead tr th");
				$.each(vTrSibling, function(){
					$(this).css('width','115px');
				});
				
				var vTdSibling = $("#message tbody tr td");
				$.each(vTdSibling, function(){
					$(this).css('width','115px');
					$(this).css('overflow','hidden');
				});
				</c:if>
			}
		}
		
		for(i=0; i<trArray.length; i++)
		{
			<c:choose>
			<c:when test="${not empty showDeleteBtn or not empty admin}">
				subjectTd = trArray[i].children[2];	// subject td
			</c:when>
			<c:otherwise>
				subjectTd = trArray[i].children[1];	// subject td
			</c:otherwise>
			</c:choose>
			
			if(trim(subjectTd.title) != '')
			{
				subjectTd.title = trim(subjectTd.title);
			}
		}
		
		// Trim whitespace from left and right sides of s.
        function trim(s) {
            return s.replace( /^\s*/, "" ).replace( /\s*$/, "" );
        }
	});

	function showMsgPostContents(objLink, msgId)
	{
		// Manage place holders
		$("#inbox-message").remove();
		$("#form-div").remove();
		if($("#sent-message").css("display"))
			$("#sent-message").remove();

		// Fill the place holder
		$("#inbox").after('<div id="inbox-message" class="col-sm-12"></div><div class="clear></div>');

		if( navigator.userAgent.match(/msie/gi) != 'MSIE' )
		{
			// Manage CSS - message box 
			$(".tbl-msg-div td a").css('color','#ffffff');			
			$(objLink).css('color','#92cf51');			

			var vTDSibling = $(objLink).parent().siblings();
			$.each(vTDSibling, function(){
				$(this).children().css('color','#92cf51');
			});
		}

		// Ajax call
		var vHTML	= reqAjax(msgId);
		// Embed Ajax response
		$("#inbox-message").html(vHTML);			
	}

	function reqAjax(msgId)
	{
		var result	= $.ajax({
			url		: 'msgPostContent.html?msg=' + msgId,
			cache	:false,
			async	:false
			}
		).responseText;

		return result.slice(result.indexOf("response") + 9, result.lastIndexOf("response") - 2);
	}

	function checkPostAccess(msgUrl)
	{
		<c:choose>
			<c:when test="${not empty user}">
				location.href = msgUrl;
			</c:when>
			<c:otherwise>
				cglAlert('Invalid Action',"You must be logged in to post a message.",300);
				$(".ui-dialog-overlay").width(document.body.clientWidth);
			</c:otherwise>
		</c:choose>
	}
</script>

<!--[if IE]>
<style type="text/css">
	.tbl-msg-div {position:relative; height:200px; }

	<c:choose>
		<c:when test="${not empty showDeleteBtn}">
			#inbox table.messages thead tr {position:absolute; height:30px; width:448px; top:expression(this.offsetParent.scrollTop);}
			#inbox table.messages thead tr th {width:111px;}
			#inbox table.messages tbody tr td {width:112px;}
			#inbox table.messages tbody {position:absolute; top:30px; width:450px; height:150px;}
		</c:when>
		<c:otherwise>
			#inbox table.messages thead tr {position:absolute; height:30px; width:470px; top: expression(this.offsetParent.scrollTop);}
			#inbox table.messages thead tr th {width:111px;}
			#inbox table.messages tbody tr td {width:110px;}
			#inbox table.messages tbody {position:absolute; top:30px; width:370px; height:140px;}
		</c:otherwise>
	</c:choose>
</style>
<![endif]-->

<style type="text/css">
	.custom-txt-dec{text-decoration:none;}

	/* Safari/Chrome css hack */
	@media screen and (-webkit-min-device-pixel-ratio:0)
	{
		.span-spacer
		{
			height:10px;
			width:96%;
		}
	}
</style>
<h2 class="page-title">Home</h2>
<div class="msgboard-section">
<div class="row">
	<div id="inbox" class="col-sm-12">
		<!--div class="left"><img src="images/ppMessage.jpg" alt="msg"/></div-->
		<div class="heading-golfer">
				<h4><fmt:message key="profile.messageBoard"/></h4>
					<img src="images/public-bd-icon.png" alt="Messages">
			</div>
	   	<div class="clear"></div>
		<form method="post" name="deletemsg" id="deleteMsg" action="<c:url value="msgboard.html"/>">
			<div class="tbl-msg-div shadow">
			<display:table name="messages" id="message" cellspacing="0" cellpadding="0" class="messages" requestURI="">
				<c:choose>
					<c:when test="${not empty admin}">
						<display:column>
				        	<input type="checkbox" name="msgDelete" value="<c:out value="${message.messageMap.id}"/>"/>
				    	</display:column>
					</c:when>
					<c:when test="${not empty message.htmlValue}">
						<display:column>
				        	<input type="checkbox" name="msgDelete" value="<c:out value="${message.htmlValue}"/>"/>
				    	</display:column>
					</c:when>
					<c:when test="${not empty showDeleteBtn}">
						<display:column></display:column>
					</c:when>
				</c:choose>
				
			    <display:column property="messageMap.poster.fullName" titleKey="inbox.from" url="/profile.html" paramId="id" paramProperty="messageMap.poster.id"/>
			    <display:column titleKey="inbox.subject" maxLength="25" style="whitespace: nowrap;">
					<a href="#" onclick="showMsgPostContents(this,<c:out value='${message.messageMap.id}'/>); return false;"><c:out value="${message.messageMap.subject}"/></a>
				</display:column>
				<display:column property="messageMap.date" titleKey="inbox.date" url="/msgboard.html" decorator="com.sageconsulting.webapp.decorators.MessageDateColumnDecorator"/>
		
			    <display:setProperty name="paging.banner.item_name"><fmt:message key="inbox.message"/></display:setProperty>
			    <display:setProperty name="paging.banner.items_name"><fmt:message key="inbox.messages"/></display:setProperty>
			    <display:setProperty name="basic.empty.showtable" value="true"/>
			    <display:setProperty name="basic.msg.empty_list" value="" />
			    <display:setProperty name="basic.msg.empty_list_row" value="" />
				<display:setProperty name="paging.banner.placement" value="bottom" />
				<display:setProperty name="paging.banner.no_items_found"><fmt:message key="msgboard.noMessages"/></display:setProperty>
				<display:setProperty name="paging.banner.one_item_found" value="" />
				<display:setProperty name="paging.banner.some_items_found"><fmt:message key="inbox.someMessages"/></display:setProperty>
				<display:setProperty name="paging.banner.all_items_found" value="" />
				<display:setProperty name="paging.banner.full"><fmt:message key="inbox.full"/></display:setProperty>
				<display:setProperty name="paging.banner.first"><fmt:message key="inbox.first"/></display:setProperty>
				<display:setProperty name="paging.banner.last"><fmt:message key="inbox.last"/></display:setProperty>
				<display:setProperty name="paging.banner.onepage" value="" />
			</display:table>
			</div>
           
			<c:choose>
				<c:when test="${not empty user}">
					<a class="msg-post-btn" href="<c:url value="msgboard.html"/>?post=true"><fmt:message key="msgboard.post"/></a>
				</c:when>
				<c:otherwise>
					<fmt:message key="msgboard.login"/>
				</c:otherwise>
			</c:choose>
			<c:if test="${not empty admin or not empty showDeleteBtn}">
			<div class="send-btn">
				<carter:button onclick="document.getElementById('bDelete').value='true';document.getElementById('deleteMsg').submit(); return false;" key="button.delete"/>
				<input type="hidden" id="bDelete" name="bDelete" value="false"/>
				</div>
			</c:if>
		</form>
    </div>

	<!--------------------------->
	<!--// DIV PLACE HOLDERS //-->
	<!--------------------------->

	<c:choose>
		<c:when test="${not empty currentMessage}">
			<div id="inbox-message" class="col-sm-6">
				<div id="msgheader" class="grey-box shadow">
				<div class="heading-golfer">
					<h4>Write Your Message</h4>
					<img src="images/public-bd-icon.png" alt="Messages">
			    </div>
					<h2><fmt:message key="inbox.msgFrom"/> <b><c:out value="${currentMessage.poster.fullName}"/></b></h2>
					<h2><fmt:message key="inbox.msgSubject"/> <b><c:out value="${currentMessage.subject}"/></b></h2>
				</div>
				<div class="grey-box shadow">
					<div class="heading-golfer">
					<h4>Write Your Message</h4>
					<img src="images/public-bd-icon.png" alt="Messages">
			    </div>
				<p class="msg-head"><fmt:message key="publicMessage.message"/>:</p>
				<div id="msg">
					<c:out value="${currentMessage.message}" escapeXml="false"/>
				</div>
				</div>
				<c:if test="${not empty user}">
				<div class="reply-post-link">
					<a class="reply-link" href="<c:url value="msgboard.html"/>?replyTo=<c:out value="${currentMessage.id}"/>"><fmt:message key="inbox.reply"/></a>
					</div>
				</c:if>
				</div>
			<div class="clear"></div>
		</c:when>
		
		<c:when test="${not empty user and post}">
			<div id="form-div" class="col-sm-12">
				<div class="heading-golfer">
					<h4><fmt:message key="sendMsg.create"/></h4>
					<img src="images/public-bd-icon.png" alt="Messages">
				</div>
				<div class="post">
					<form:form commandName="publicMessage" id="msgForm">
						<div class="row">
							<div class="col-6">
						<!-- this needs to be TO as per design  hard code-->		<div class="sub-container grey-box shadow">
								    <label for="subject">To</label>
									<div class="sub-input">
								    <form:input id="subject" path="subject" cssClass="longBox" maxlength="50"/>
									</div>
								</div>
							</div>
							<div class="col-6">
								<div class="sub-container grey-box shadow">
								    <label for="subject"><fmt:message key="sendMsg.subject"/></label>
									<div class="sub-input">
								    <form:input id="subject" path="subject" cssClass="longBox" maxlength="50"/>
									</div>
								</div>
							</div>
						</div>
					
					
					   <div class="msginput-container grey-box shadow"> 
						<label for="msginput"><fmt:message key="sendMsg.message"/></label>
					    <form:textarea path="message" cssClass="emailMessage" id="msginput"/>
						</div>
					    <div class="buttons">
					    	<div class="send-btn">
								<carter:button onclick="return onFormSubmit(document.getElementById('msgForm'));" key="button.send"/>
					    	</div>
					    	<div class="bcancel-btn">
								<carter:button onclick="document.getElementById('bCancel').value='true';document.getElementById('msgForm').submit();return false;" key="button.cancel"/>
						    </div>
							<input id="bCancel" type="hidden" name="bCancel" value="false"/>
					    </div>
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
				    	    if (validatePublicMessage(theForm))
				    	        return theForm.submit();
				    	    return false;
				    	}
					</script>
				    <v:javascript formName="publicMessage" staticJavascript="false"/>
				    <script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script>
			    </div>
			</div>
		</c:when>
		
		<c:when test="${not empty sentMessage}">
			<div id="sent-message" class="col-sm-6">
				<h3><c:out value="${sentMessage}"/></h3>
			</div>
		</c:when>
	</c:choose>
</div>
</div>
</c:if>