<%@page session="false"%>
<%@page isELIgnored="false"%>
<html>
<head>
<title>Access Denied</title>
<link rel="stylesheet" href="<c:url value="resources/css/Style.css"/>">
</head>
<body>
	<jsp:include page="_menu.jsp" />

	<h3 style="color: red;">${message}</h3>

	<jsp:include page="footer.jsp" />
</body>
</html>