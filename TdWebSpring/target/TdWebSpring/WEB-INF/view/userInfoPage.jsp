<%@page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	errorPage="error.jsp" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>${title}</title>
</head>
<body>
	<jsp:include page="_menu.jsp" />


	<h1>Message : ${message}</h1>


</body>
</html>