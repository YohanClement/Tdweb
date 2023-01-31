<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<html>
<head>
<title>${title}</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
<link rel="stylesheet" href="<c:url value="resources/css/Style.css"/>">

</head>
<body>
    <jsp:include page="_menu.jsp" />

    <h2><spring:message code="admin"/> Page</h2>


    <h3><spring:message code="welcome"/> : ${pageContext.request.userPrincipal.name}</h3>

    <jsp:include page="footer.jsp" /> 
</body>
</html>