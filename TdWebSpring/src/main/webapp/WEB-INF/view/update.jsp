<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.js"></script>

<link rel="stylesheet" href="<c:url value="resources/css/Style.css"/>">
<title>Mise a jour</title>
</head>
<body class="body">
	<jsp:include page="_menu.jsp"></jsp:include>
	<div class="container">
		<div class="card">
			<h2 class="fw-normal mb-3 pb-3 text-center">
				<spring:message code="edit" />
				${emp.lastName} ${emp.firstName}
			</h2>

			<form:form method="POST" action="update" modelAttribute="emp">
				<form:hidden path="empId" value="${emp.empId }" />

				<div class="form-outline mb-4">
					<form:label path="firstName">
						<spring:message code="firstname" />
					</form:label>
					<form:input class="form-control form-control-lg" path="firstName"
						value="${emp.firstName}" />
					<form:errors path="firstName" cssClass="error" />
				</div>

				<div class="form-outline mb-4">
					<form:label path="lastName">
						<spring:message code="lastname" />
					</form:label>
					<form:input class="form-control form-control-lg" path="lastName" value="${emp.lastName}" />
					<form:errors path="lastName" cssClass="error" />
				</div>

				<div class="form-outline mb-4">
					<form:label path="title">
						<spring:message code="title" />
					</form:label>
					<form:input class="form-control form-control-lg" path="title" value="${emp.title}" />
					<form:errors path="title" cssClass="error" />
				</div>

				<div class="form-outline mb-4">
					<form:label path="startDate">
						<spring:message code="startDate" />
					</form:label>
					<form:input class="form-control form-control-lg" type="date" path="startDate" value="${emp.startDate}" />
					<form:errors path="startDate" name="startDate" cssClass="error" />
				</div>
				
				<div class="pt-1 mb-4">
					<input class="btn btn-primary mb-4" type="submit" value="<spring:message code="send"/>" />
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>