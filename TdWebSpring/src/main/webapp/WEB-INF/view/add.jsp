<%@ page language="java" contentType="text/html"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<meta charset="UTF-8"/>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.js"></script>

<link rel="stylesheet" href="<c:url value="resources/css/Style.css"/>">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="_menu.jsp"></jsp:include>
	<main>
		<div class="container">
			<div class="card">
				<form:form method="POST" action="add" modelAttribute="employee">
					<h2 class="fw-normal text-center">
						<spring:message code="add.title" />
					</h2>

					<div class="form-outline mb-4">
						<form:label path="firstName">
							<spring:message code="firstname" />
						</form:label>
						<form:input class="form-control form-control-lg" path="firstName"
							value="${emp.firstName}" min=3 max=45 />
						<form:errors path="firstName" cssClass="error" />
					</div>

					<div class="form-outline mb-4">
						<form:label path="lastName">
							<spring:message code="lastname" />
						</form:label>
						<form:input class="form-control form-control-lg" path="lastName"
							value="${emp.lastName}" min=3 max=45 />
						<form:errors path="lastName" cssClass="error" />
					</div>


					<div class="form-outline mb-4">
						<form:label path="title">
							<spring:message code="title" />
						</form:label>
						<form:input class="form-control form-control-lg" path="title"
							value="${emp.title}" min=3 max=45 />
						<form:errors path="title" cssClass="error" />
					</div>

					<div class="form-outline mb-4">
						<form:label path="startDate">
							<spring:message code="startDate" />
						</form:label>
						<form:input class="form-control form-control-lg" path="startDate"
							type="date" value="${emp.startDate}" />
						<form:errors path="startDate" cssClass="error" />
					</div>

					<div class="pt-1 mb-4">
						<button class="btn btn-primary mb-4" type="submit">Add</button>
					</div>
				</form:form>
			</div>
		</div>
	</main>
	<jsp:include page="footer.jsp" />
</body>
</html>