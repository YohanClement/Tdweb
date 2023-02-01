<%@page session="false"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8"/>
<title>Access Denied</title>
<link rel="stylesheet" href="<c:url value="resources/css/Style.css"/>">
</head>
<body>
	<jsp:include page="_menu.jsp" />
	<main>
		<h3 class="text-center" style="color: red;"><spring:message code="salut"/>${message}<spring:message code="permit"/></h3>
	</main>
	<jsp:include page="footer.jsp" />
</body>
</html>