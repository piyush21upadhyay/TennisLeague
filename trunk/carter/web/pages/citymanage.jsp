<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="cityManage.title"/></title>
    <content tag="heading"><fmt:message key="cityManage.heading"/></content>
    <meta name="menu" content="AdminMenu"/>
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>

<div id="citymanage">
	<p class="top-msg"><fmt:message key="cityManage.cityList"/></p>
	<display:table name="cities" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="cities" pagesize="25" class="table" export="false">
	    <display:column property="name" escapeXml="true" sortable="true" titleKey="cityManage.city"
	    url="/registrationCity.html" paramId="id" paramProperty="id"/>
	    <display:column property="state" escapeXml="true" sortable="true" titleKey="cityManage.state"/>
	    <display:column sortProperty="active" sortable="true" titleKey="cityManage.active" style="width:10%; padding-left:15px">
			<input type="checkbox" disabled="disabled" <c:if test="${cities.active}">checked="checked"</c:if>/>
		</display:column>
	</display:table>
	<a style="margin-right:20px;" href="manageCourse.html"><fmt:message key="cityManage.manageCourse"/></a>
	<a href="registrationCity.html"><fmt:message key="cityManage.addNew"/></a>
</div>