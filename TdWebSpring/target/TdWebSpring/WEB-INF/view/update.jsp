<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

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

				<form:label path="firstName">
					firstname<%-- <spring:message code="form.zodiac.sun" /> --%>
				</form:label>
				<form:input path="firstName" value="${emp.firstName}"/>
				<form:errors path="firstName" cssClass="error" />
				
				<form:label path="lastName">
					lastname<%-- <spring:message code="form.zodiac.sun" /> --%>
				</form:label>
				<form:input path="lastName" value="${emp.lastName}"/>
				<form:errors path="lastName" cssClass="error" />

				<form:label path="title">
					title<%-- <spring:message code="form.zodiac.sun" /> --%>
				</form:label>
				<form:input path="title" value="${emp.title}"/>
				<form:errors path="title" cssClass="error" />

				<form:label path="startDate">
					Start date<%-- <spring:message code="form.zodiac.sun" /> --%>
				</form:label>
				<form:input path="startDate" value="${emp.startDate}"/>
				<form:errors path="startDate" cssClass="error" />

				<div class="pt-1 mb-4">
					<button class="btn btn-primary mb-4" type="submit" value="S'enregistrer"></button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>