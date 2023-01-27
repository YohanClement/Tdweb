<%@page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	errorPage="error.jsp" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page isELIgnored="false"%>
<html>
<head>
<title>${title}</title>
</head>
<body>
	<jsp:include page="_menu.jsp" />


	<h1>Message : ${message}</h1>

	<div class="container">

		<div class="card">
			<h1 class="text-center">Gestion des employé.e.s</h1>
			<table class="table table-bordered" data-toggle="table"
				data-pagination="true" data-search="true" data-page-size="5"
				data-sort-class="table-active" data-sortable="true"
				data-page-list="[5, 10, 25, 50, All]">
				<thead class="th">
					<tr>
						<th data-field="id" data-sortable="true">ID</th>
						<th data-field="firstname" data-sortable="true">Prénom</th>
						<th data-field="lastname" data-sortable="true">Nom de famille</th>
						<th data-field="startDate" data-sortable="true">Date d'entrée</th>
						<th data-field="title" data-sortable="true">Titre</th>
						<th>Gestion</th>

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
									<c:if test="${me.droit == 'admin'}">
										<form action="deleteE" method="get">
											<button class="btn btn-outline-primary" type="submit"
												name="id" value="${e.empId}"
												onclick="return confirm('confirmez la suppression');">
												<i class="bi bi-x-square-fill"></i>
											</button>
										</form>
									</c:if>
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