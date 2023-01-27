<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.js"></script>

<link rel="stylesheet" href="Styles.css">
<title>Mise a jour</title>
</head>
<body class="body">
	<jsp:include page="_menu.jsp"></jsp:include>
	<div class="container">
		<div class="card">
			<h2 class="fw-normal mb-3 pb-3 text-center">Editer le profil de
				l'employé ${emp.lastName} ${emp.firstName}</h2>

			<form:form method="POST" action="update" modelAttribute="emp">

				<input type="hidden" class="form-control" id="formGroupExampleInput"
					placeholder="id" name="id" value="${id}">


				<form:label path="firstname">
					<%-- <spring:message code="form.zodiac.sun" /> --%>
				</form:label>
				<form:input path="firstname" />
				<form:errors path="firstname" cssClass="error" />
				
				<form:label path="lastname">
					<%-- <spring:message code="form.zodiac.sun" /> --%>
				</form:label>
				<form:input path="lastname" />
				<form:errors path="lastname" cssClass="error" />

				<form:label path="title">
					<%-- <spring:message code="form.zodiac.sun" /> --%>
				</form:label>
				<form:input path="title" />
				<form:errors path="title" cssClass="error" />

				<form:label path="startDate">
					<%-- <spring:message code="form.zodiac.sun" /> --%>
				</form:label>
				<form:input path="startDate" />
				<form:errors path="startDate" cssClass="error" />

				<div class="pt-1 mb-4">
					<input class="btn btn-primary mb-4" type="submit" value="S'enregistrer"/>
				</div>
			</form:form>
		</div>
	</div>
</body>


</body>
</html>