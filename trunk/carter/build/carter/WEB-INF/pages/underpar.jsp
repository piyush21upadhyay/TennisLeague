<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="underpar.title"/></title>
    <content tag="heading"><fmt:message key="underpar.heading"/></content>
    <meta name="menu" content="AdminMenu"/>
</head>
<body id="activeUsers"/>

<p><fmt:message key="underpar.message"/></p>

<display:table name="leaders" id="user" cellspacing="0" cellpadding="0"
    defaultsort="1" class="table" pagesize="50" requestURI="" export="true">
    <display:column property="season.name" escapeXml="true" titleKey="underpar.seasonAndCitySpecific" sortable="true"/>
	<display:column property="user.lastName" escapeXml="true" titleKey="underpar.lastName" sortable="true"/>
	<display:column property="user.firstName" escapeXml="true" titleKey="underpar.firstName" sortable="true"/>
	<display:column property="cntBirdieWeek1" escapeXml="true" titleKey="underpar.week1" sortable="true"/>
	<display:column property="cntBirdieWeek2" escapeXml="true" titleKey="underpar.week2" sortable="true"/>
	<display:column property="cntBirdieWeek3" escapeXml="true" titleKey="underpar.week3" sortable="true"/>
	<display:column property="cntBirdieWeek4" escapeXml="true" titleKey="underpar.week4" sortable="true"/>
    <display:column property="cntBirdieWeek5" escapeXml="true" titleKey="underpar.week5" sortable="true"/>
	<display:column property="cntBirdieWeek6" escapeXml="true" titleKey="underpar.week6" sortable="true"/>
	<display:column property="totBirdiePoints" escapeXml="true" titleKey="underpar.totalBirdiePoints" sortable="true"/>
    
    <display:setProperty name="paging.banner.item_name"><fmt:message key="underpar.leader"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="underpar.leaders"/></display:setProperty>
	
	<display:setProperty name="export.excel.filename" value="Birdie Tracker.xls"/>
    <display:setProperty name="export.csv.filename" value="Birdie Tracker.csv"/>
    <display:setProperty name="export.pdf.filename" value="Birdie Tracker.pdf"/>
</display:table>
