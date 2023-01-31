<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<title>Login</title>
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

	<!-- /login?error=true -->

	<h2 class="fw-normal mb-3 pb-3 text-center"
		style="letter-spacing: 1px;"><spring:message code="login" /></h2>

	<div class="container">
		<div class="card">
			<form name='f'
				action="${pageContext.request.contextPath}/j_spring_security_check"
				method='POST'>
				<table>
					<tr>
						<td><spring:message code="user"></spring:message></td>
						<td><input class="form-control form-control-lg" type='text'
							name='username' value=''></td>
					</tr>
					<tr>
						<td><spring:message code="password" /></td>
						<td><input class="form-control form-control-lg"
							type='password' name='password' /></td>
					</tr>
					<tr>
						<td><input class="btn btn-primary" name="submit"
							type="submit" value="submit" /></td>
					</tr>
				</table>
			</form>

			<c:if test="${param.error == 'true'}">
				<div style="color: red; margin: 10px 0px;">

					<spring:message code="failed" />
					<br />
					<spring:message code="reason" />
					: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

				</div>
			</c:if>

		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>