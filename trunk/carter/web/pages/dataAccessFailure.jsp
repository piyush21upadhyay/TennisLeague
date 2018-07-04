<%@ include file="/common/taglibs.jsp" %>

<head>
	<title>Data Access Error</title>
	<content tag="heading">Data Access Failure</content>
</head>

<p>
    <c:out value="${requestScope.exception.message}"/>
</p>

<!--
<% 
Exception ex = (Exception) request.getAttribute("exception");
ex.printStackTrace(new java.io.PrintWriter(out)); 
%>
-->

<a href="home.html" onclick="history.back();return false">&#171; Back</a>
