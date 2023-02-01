<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />

<title>Access Denied</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>

<link rel="stylesheet" href='<c:url value="resources/css/Style.css"/>' />
</head>

<body>
	<jsp:include page="_menu.jsp" />

	<main>
		<h3 class="text-center" style="color: red;">
			<spring:message code="salut" />
			${message}
			<spring:message code="permit" />
		</h3>
	</main>
	<jsp:include page="footer.jsp" />

</body>
</html>