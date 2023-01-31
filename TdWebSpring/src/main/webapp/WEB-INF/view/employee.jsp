<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>liste employee</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
<script
	src="https://unpkg.com/bootstrap-table@1.21.2/dist/bootstrap-table.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap-table@1.21.2/dist/bootstrap-table.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap-table@1.16.0/dist/locale/bootstrap-table-fr-FR.min.js"></script>

<link rel="stylesheet" href="<c:url value="resources/css/Style.css"/>">

</head>
<body class="body">
	<jsp:include page="_menu.jsp" />

	<div class="container">

		<div class="card">
			<h1 class="text-center">
				<spring:message code="manage" />
			</h1>

			<a href="add"><button type="submit">
					<spring:message code="add" />
				</button></a>

			<table class="table table-bordered" data-locale='table.lang' data-toggle="table"
				data-pagination="true" data-search="true" data-page-size="5"
				data-sort-class="table-active" data-sortable="true"
				data-page-list="[5, 10, 25, 50, All]">
				<thead class="th">
					<tr>
						<th data-field="id" data-sortable="true">ID</th>
						<th data-field="firstname" data-sortable="true"><spring:message
								code="firstname" /></th>
						<th data-field="lastname" data-sortable="true"><spring:message
								code="lastname" /></th>
						<th data-field="startDate" data-sortable="true"><spring:message
								code="startDate" /></th>
						<th data-field="title" data-sortable="true"><spring:message
								code="title" /></th>
						<th><spring:message code="action" /></th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${emps}" var="e">

						<tr>
							<td>${e.empId}</td>
							<td>${e.firstName}</td>
							<td>${e.lastName}</td>
							<td><fmt:formatDate value="${e.startDate}"
									pattern="yyyy-MM-dd" /></td>
							<td>${e.title}</td>

							<td>
								<div class="d-inline">
									<form action="update" method="get">
										<button type="submit" class="btn btn-outline-primary"
											name="id" value="${e.empId}">
											<i class="bi bi-pen-fill"></i>
										</button>
									</form>
									<form action="delete" method="get">
										<button class="btn btn-outline-primary" type="submit"
											name="id" value="${e.empId}"
											onclick="return confirm('confirmez la suppression');">
											<i class="bi bi-x-square-fill"></i>
										</button>
									</form>

								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>