<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Style.css"/>

</head>
<body>
	<jsp:include page="_menu.jsp" />
	<main>
		<div class="container">
			<div class="card">
				<h2 class="fw-normal mb-3 pb-3 text-center"
					style="letter-spacing: 1px;">
					<spring:message code="login" />
				</h2>

				<form name='f'
					action="${pageContext.request.contextPath}/j_spring_security_check"
					method='POST'>

					<spring:message code="user"></spring:message>
					<input class="form-control form-control-lg mb-3" type='text'
						name='username' value=''>

					<spring:message code="password" />
					<input class="form-control form-control-lg" type='password'
						name='password' /> <input class="btn btn-primary mt-3"
						name="submit" type="submit" value="submit" />
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
	</main>
	<jsp:include page="footer.jsp" />
</body>
</html>