<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="test.title"/></title>
	<content tag="heading"><fmt:message key="test.heading"/></content>
    <meta name="menu" content="Test"/>
</head>

<p><fmt:message key="test.message"/></p>

<div class="separator"></div>

<ul class="glassList">
    <li>
        <a href="<c:url value="/testCreateUsers.html"/>"><fmt:message key="test.createUsers"/></a>
    </li>
    <li>
        <a href="<c:url value="/testPlayRegularSeason.html"/>"><fmt:message key="test.playRegularSeason"/></a>
    </li>
    <li>
        <a href="<c:url value="/testPlayPostSeason.html"/>"><fmt:message key="test.playPostSeason"/></a>
    </li>
</ul>
