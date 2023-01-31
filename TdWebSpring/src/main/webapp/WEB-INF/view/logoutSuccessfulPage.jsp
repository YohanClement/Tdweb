<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<link rel="stylesheet" href="<c:url value="resources/css/Style.css"/>">
<title>Logout</title>
</head>
<body>
	<jsp:include page="_menu.jsp" />

	<h1><spring:message code="success"/></h1>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>