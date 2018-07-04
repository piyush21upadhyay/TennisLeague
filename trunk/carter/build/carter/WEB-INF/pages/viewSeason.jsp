<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="viewSeason.title"/></title>
    <content tag="heading"><fmt:message key="viewSeason.heading"/></content>
    <meta name="menu" content="Welcome"/>
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>

<c:forEach var="season" items="${seasonList}">
	<c:set var="matches" value="${season.matches}" scope="request"/>
	<h4><c:out value="${season.name}"/></h4>
	<display:table name="matches" cellspacing="0" cellpadding="0" id="matche" class="table" export="false">
	    <display:column property="golfer1.fullName" titleKey="viewSeason.golfer1" style="white-space: nowrap"
	    	decorator="com.sageconsulting.webapp.decorators.MatchGolferColumnDecorator" media="html"/>
	    <display:column property="golfer2.fullName" titleKey="viewSeason.golfer2" style="white-space: nowrap"
	    	decorator="com.sageconsulting.webapp.decorators.MatchGolferColumnDecorator" media="html"/>
	    <display:column property="playBy" titleKey="viewSeason.playBy" style="white-space: nowrap"
	    	decorator="com.sageconsulting.webapp.decorators.MatchDateColumnDecorator" media="html"/>
	    <display:column property="played" titleKey="viewSeason.played" style="white-space: nowrap"
	    	decorator="com.sageconsulting.webapp.decorators.MatchDateColumnDecorator" media="html"/>
	</display:table>
</c:forEach>
