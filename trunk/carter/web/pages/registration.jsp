<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="registrationEntry.title"/></title>
    <meta name="menu" content="Welcome"/>
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>

<div class="section">

<c:if test="${not empty seasonList or not empty registeredSeason}">
	<h2><fmt:message key="registrationEntry.heading"/></h2>
	<c:if test="${not empty seasonList}">
		<c:if test="${empty verifySeason}">
		<p class="reg-msg"><fmt:message key="registrationEntry.registrationMsg"/></p>
		</c:if>
	</c:if>
</c:if>

<form:form commandName="registrationEntry" method="post" action="registration.html" id="registrationForm">
<form:hidden path="id"/>
<form:hidden path="version"/>
<input type="hidden" name="from" value="<c:out value="${param.from}"/>"/>

<c:choose>
	<c:when test="${not empty seasonList}">
		<c:choose>
			<c:when test="${empty verifySeason}">
				<div class="regsection">
			        <label for=""><fmt:message key="registrationEntry.season"/></label>
			        <form:select path="registration" id="registration" cssClass="text large">
			       		<c:forEach var="season" items="${seasonList}">
							<option value="<c:out value='${season.id}'/>">
			 					<c:out value="${season.displayName}"/>
							</option>
						</c:forEach>
			        </form:select>
	
			    	<span class="cost">
			    		<fmt:message key="registrationEntry.cost"/>
			    		<strong><fmt:formatNumber type="currency" value="${amount}" /></strong>
			    	</span>
			    	
			    	<span>
			    		<!-- <img src="images/credit_cards.png" alt="credit cards"/> -->
			    		<img src="images/visa.jpg" alt="visa"/>
			    		<img src="images/master.jpg" alt="master" style="margin-left:10px;"/>
			    		<img src="images/amex.jpg" alt="amex" style="margin-left:10px;"/>
			    		<img src="images/discover.jpg" alt="discover" style="margin-left:10px;"/>
			    	</span>
			    	
			    	<h3 class="top-msg">
			    		<fmt:message key="registrationEntry.creditCardInfo"/>
			    	</h3>

					<div class="col">
						<fieldset>
					        <legend><fmt:message key="registrationEntry.nameOfCardHodler"/></legend>
							
							<div>
						        <label for="firstName"><fmt:message key="registrationEntry.firstName"/></label>
						        <form:input path="firstName" id="firstName" cssClass="text medium" maxlength="40"/>
							</div>
			
							<div>
						        <label for="lastName"><fmt:message key="registrationEntry.lastName"/></label>
						        <form:input path="lastName" id="lastName" cssClass="text medium" maxlength="40"/>
							</div>
			
							<div>
						        <label for="cardNumber"><fmt:message key="registrationEntry.cardNumber"/></label>
						        <form:input path="cardNumber" id="cardNumber" cssClass="text medium" maxlength="16"/>
							</div>
					        
					        <div class="dblrow">
				                <label for="cardExpiration"><fmt:message key="registrationEntry.cardExpiration"/></label>
						        <form:input path="cardExpiration" id="cardExpiration" cssClass="text medium" maxlength="5"/>
					        </div>
					        
					        <div class="dblrow">
				                <label for="securityCode"><fmt:message key="registrationEntry.securityCode"/></label>
						        <form:input path="securityCode" id="securityCode" cssClass="text medium" maxlength="5"/>
					        </div>
				        </fieldset>
			        </div>
			        
			        <div class="col">
			        	<fieldset>
			        		<legend><fmt:message key="registrationEntry.billingAddress"/></legend>

					        <div>
						        <label for="billingAddress.address"><fmt:message key="registrationEntry.billingAddress.address"/></label>
						        <form:input path="billingAddress.address" id="billingAddress.address" cssClass="text medium" maxlength="40"/>
					        </div>
			
					        <div>
						        <label for="billingAddress.city"><fmt:message key="registrationEntry.billingAddress.city"/></label>
						        <form:input path="billingAddress.city" id="billingAddress.city" cssClass="text medium" maxlength="40"/>
					        </div>
			
					        <div>
						        <label for="billingAddress.province"><fmt:message key="registrationEntry.billingAddress.province"/></label>
								<carter:state name="billingAddress.province" prompt="" default="${registrationEntry.billingAddress.province}"/>
					        </div>
					        
					        <div>
				                <label for="billingAddress.postalCode"><fmt:message key="registrationEntry.billingAddress.postalCode"/></label>
						        <form:input path="billingAddress.postalCode" id="billingAddress.postalCode" cssClass="text medium" maxlength="5"/>
					        </div>
					        
					        <div>
				                <label for="billingAddress.country"><fmt:message key="registrationEntry.billingAddress.country"/></label>
					            <carter:country name="billingAddress.country" prompt="" default="${registrationEntry.billingAddress.country}"/>
					        </div>
					        
							<div class="buttons">
								<div class="left">
									<carter:button onclick="document.getElementById('bRegister').value='true';return onFormSubmit(document.getElementById('registrationForm'));" key="button.register"/>
								</div>
								<div class="left">
									<carter:button onclick="document.getElementById('bCancel').value='true';document.getElementById('registrationForm').submit();return false;" key="button.registerLater"/>
								</div>
								<input id="bRegister" type="hidden" name="bRegister" value="false"/>
								<input id="bCancel" type="hidden" name="bCancel" value="false"/>
				            </div>
			        	</fieldset>
			        </div>
			        
			        <div class="col">
			        	<!-- (c) 2005, 2012. Authorize.Net is a registered trademark of CyberSource Corporation -->
			        	<div class="AuthorizeNetSeal seal">
			        		<script type="text/javascript" language="javascript">
			        			var ANS_customer_id="d87450a0-b28d-40ae-bc26-888fb22a1ebf";
			        		</script>
			        		<script type="text/javascript" language="javascript" src="//verify.authorize.net/anetseal/seal.js" ></script>
			        	</div> 
			        </div>
			        
			        <div class="clear"></div>

					<spring:bind path="registrationEntry.*">
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
		        </div>
		        
		        <script type="text/javascript">
					$(function(){
						$("#cardNumber").attr("autocomplete","off");
						$("#cardExpiration").attr("autocomplete","off");
						$("#securityCode").attr("autocomplete","off");
					});
				</script>
			</c:when>
			<c:otherwise>
				<div class="regsection">
		    		<h3 class="top-msg" style="margin-bottom:40px;">
		    			<fmt:message key="registrationEntry.verifySeason"/>
		    		</h3>
		    		<div class="conf-col">
		    			<div class="header"><fmt:message key="registrationEntry.yourDetails"/></div>
		    			<h3>
		    				<c:choose>
		    					<c:when test="${registrationEntry.user.male}">Mr.&nbsp;</c:when>
		    					<c:otherwise>Miss&nbsp;</c:otherwise>
		    				</c:choose>
		    				<c:out value="${registrationEntry.firstName}"/>&nbsp;<c:out value="${registrationEntry.lastName}"/>
		    			</h3>
		    		</div>
		    		<div class="conf-col">
		    			<div class="header"><fmt:message key="registrationEntry.billingAddress"/></div>
		    			<h3><c:out value="${registrationEntry.billingAddress.address}"/></h3>
		    			<h3><c:out value="${registrationEntry.billingAddress.city}"/></h3>
		    			<h3><c:out value="${registrationEntry.billingAddress.province}"/></h3>
		    			<h3><c:out value="${registrationEntry.billingAddress.postalCode}"/></h3>
		    		</div>
		    		<div class="clear"></div>
		    		<div class="conf-col" style="height:70px;">
		    			<div class="header"><fmt:message key="registrationEntry.amountPaid"/></div>
		    			<h3><fmt:formatNumber type="currency" value="${amount}" /></h3>
		    		</div>
					<div class="conf-col" style="height:70px;">
		    			<div class="header"><fmt:message key="registrationEntry.season"/></div>
		    			<h3><c:out value="${verifySeason}"/></h3>
		    		</div>
		    		<div class="clear"></div>
		    		<div class="conf-col">
		    			<div class="header"><fmt:message key="registrationEntry.payment"/></div>
		    			<h3><fmt:message key="registrationEntry.paymentForm"/></h3>
		    			<h3><fmt:message key="registrationEntry.accountNumber"/></h3>
		    			<h3><fmt:message key="registrationEntry.expiration"/></h3>
		    		</div>
					<div class="conf-col">
		    			<div class="header">&nbsp;</div>
		    			<h3><c:out value="${acctType}"/></h3>
		    			<h3><c:out value="${cardNumber}"/></h3>
		    			<h3><c:out value="${verifyExpiration}"/></h3>
		    		</div>
		    		<div class="clear"></div>

					<div class="conf-col" style="height:30px;">
					    <div>
				    		<img id="processing" src="<c:url value="images/ball-in-hole.gif"/>" alt="processing" style="visibility:hidden;"/>
			    		</div>
					</div>
					<div class="conf-col" style="height:30px;">
					
				        <form:hidden id="firstName" path="firstName"/>
				        <form:hidden id="lastName" path="lastName"/>
				        <form:hidden id="registration" path="registration"/>
				        <form:hidden id="cardNumber" path="cardNumber"/>
				        <form:hidden id="cardExpiration" path="cardExpiration"/>
				        <form:hidden id="securityCode" path="securityCode"/>
				        <form:hidden id="billingAddress.address" path="billingAddress.address"/>
				        <form:hidden id="billingAddress.city" path="billingAddress.city"/>
				        <form:hidden id="billingAddress.province" path="billingAddress.province"/>
				        <form:hidden id="billingAddress.postalCode" path="billingAddress.postalCode"/>
				        <form:hidden id="billingAddress.country" path="billingAddress.country"/>
						<div class="buttons">
							<div class="left">
								<carter:button onclick="document.getElementById('bBack').value='true';document.getElementById('registrationForm').submit();return false;" key="button.back"/>
							</div>
							<div class="left">
								<carter:button onclick="showProcImg();document.getElementById('bVerify').value='true';document.getElementById('registrationForm').submit();return false;" key="button.process"/>
							</div>
							<input id="bVerify" type="hidden" name="bVerify" value="false"/>
							<input id="bBack" type="hidden" name="bBack" value="false"/>
			            </div>
						<script type="text/javascript">
						<!--
						    function showProcImg()
						    {
						    	var img = document.getElementById("processing");
						    	img.style.visibility = "visible";
						    }
						-->
						</script>
					</div>
					<img alt="CGL Logo" src="images/CGL-logo.gif">
		    	</div>
			</c:otherwise>
		</c:choose>
	</c:when>
	<c:otherwise>
		<c:if test="${not empty registeredSeason}">
			<div class="regsection">
	    		<h3 class="top-msg">
	    			<fmt:message key="registrationEntry.thankYou"/>
	    		</h3>
	    		<p class="thankyou-msg"><fmt:message key="registrationEntry.thankYouMsg"/></p>
	    		<div class="conf-col">
	    			<div class="header"><fmt:message key="registrationEntry.yourDetails"/></div>
	    			<h3>
	    				<c:choose>
	    					<c:when test="${registrationEntry.user.male}">Mr&nbsp;</c:when>
	    					<c:otherwise>Miss&nbsp;</c:otherwise>
	    				</c:choose>
	    				<c:out value="${registrationEntry.firstName}"/>&nbsp;<c:out value="${registrationEntry.lastName}"/>
	    			</h3>
	    		</div>
	    		<div class="conf-col">
	    			<div class="header"><fmt:message key="registrationEntry.billingAddress"/></div>
	    			<h3><c:out value="${registrationEntry.billingAddress.address}"/></h3>
	    			<h3><c:out value="${registrationEntry.billingAddress.city}"/></h3>
	    			<h3><c:out value="${registrationEntry.billingAddress.province}"/></h3>
	    			<h3><c:out value="${registrationEntry.billingAddress.postalCode}"/></h3>
	    		</div>
	    		<div class="clear"></div>
	    		<div class="conf-col" style="height:70px;">
	    			<div class="header"><fmt:message key="registrationEntry.amountPaid"/></div>
	    			<h3><fmt:formatNumber type="currency" value="${amount}" /></h3>
	    		</div>
				<div class="conf-col" style="height:70px;">
	    			<div class="header"><fmt:message key="registrationEntry.season"/></div>
	    			<h3><c:out value="${verifySeason}"/></h3>
	    		</div>
	    		<div class="clear"></div>
	    		<div class="conf-col">
	    			<div class="header"><fmt:message key="registrationEntry.payment"/></div>
	    			<h3><fmt:message key="registrationEntry.paymentForm"/></h3>
	    			<h3><fmt:message key="registrationEntry.accountNumber"/></h3>
	    			<h3><fmt:message key="registrationEntry.expiration"/></h3>
	    		</div>
				<div class="conf-col">
	    			<div class="header">&nbsp;</div>
	    			<h3><c:out value="${acctType}"/></h3>
	    			<h3><c:out value="${cardNumber}"/></h3>
	    			<h3><c:out value="${verifyExpiration}"/></h3>
	    		</div>
	    		<div class="clear"></div>

				<div id="print">
					<div>
						<carter:button onclick="window.print();" key="registrationEntry.printConfirmation"/>
					</div>
					<div>
						<c:set var="url"><c:url value="/profile.html"/></c:set>
						<carter:button page="${url}" key="registrationEntry.continue"/>
					</div>
				</div>
				<img alt="CGL Logo" src="images/CGL-logo.gif">
	    	</div>
		</c:if>
	</c:otherwise>
</c:choose>

</form:form>
</div>

<script type="text/javascript">
$("#registration").focus();

function onFormSubmit(theForm) {
	
	//if(validateRegistrationEntry(theForm))
		//return theForm.submit();
	
	return theForm.submit();
}
</script>

<v:javascript formName="registrationEntry" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script>

