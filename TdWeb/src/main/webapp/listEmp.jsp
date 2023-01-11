<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list employee</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<link rel="stylesheet" href="Styles.css">

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link deco" href="logout">Déconnexion</a></li>
		</ul>
	</nav>

	<table class="table table-bordered table-striped">
		<thead class="thead thead-dark">
			<tr>
				<td>ID</td>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Start Date</td>
				<td>Role Name</td>
				<td>Email</td>
				<td colspan="2">Action</td>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${users}" var="u">

				<tr>
					<td>${u.iduser}</td>
					<td>${u.firstname}</td>
					<td>${u.lastname}</td>
					<td>${u.creationDate}</td>
					<td>${u.email}</td>
					<td>${u.rolename}</td>

					<td><form action="change" method="get">
							<button type="submit" class="btn btn-primary" name="id"
								value="${u.iduser}">
								<i class="bi bi-pen-fill"></i>
							</button>
						</form></td>
					<td><form action="delete" method="get">
							<button class="btn btn-primary" type="submit" name="id"
								value="${u.iduser}">
								<i class="bi bi-x-square-fill"></i>
							</button>
						</form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>