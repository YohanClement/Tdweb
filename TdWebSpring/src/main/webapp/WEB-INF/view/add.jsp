<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="_menu.jsp"></jsp:include>


	<form:form method="POST" action="add" modelAttribute="employee">

		<form:label path="firstName">
					firstname<%-- <spring:message code="form.zodiac.sun" /> --%>
		</form:label>
		<form:input path="firstName" value="${emp.firstName}" />
		<form:errors path="firstName" cssClass="error" />

		<form:label path="lastName">
					lastname<%-- <spring:message code="form.zodiac.sun" /> --%>
		</form:label>
		<form:input path="lastName" value="${emp.lastName}" />
		<form:errors path="lastName" cssClass="error" />

		<form:label path="title">
					title<%-- <spring:message code="form.zodiac.sun" /> --%>
		</form:label>
		<form:input path="title" value="${emp.title}" />
		<form:errors path="title" cssClass="error" />

		<form:label path="startDate">
					Start date<%-- <spring:message code="form.zodiac.sun" /> --%>
		</form:label>
		<form:input path="startDate" type="date" value="${emp.startDate}" />
		<form:errors path="startDate" cssClass="error" />

		<div class="pt-1 mb-4">
			<button class="btn btn-primary mb-4" type="submit">Add</button>
		</div>
	</form:form>
</body>
</html>