<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list employee</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<link rel="stylesheet" href="Styles.css">

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<a class="navbar-brand" href="#"><span>YohanCorp</span></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link text-white"
					href="tab">Liste des employés</a></li>
				<li class="nav-item"><a class="nav-link text-white"
					href="AppEmp.html">Ajouter un employé</a></li>
			</ul>
		</div>
		<span>${message}</span>
		<a href="logout" class="btn btn-primary">Logout</a>

	</nav>
	<div class="container">
	<h1>Gestion des employées</h1>
		<table class="table table-bordered">
			<thead class="thead thead-dark">
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Start Date</th>
					<th>Role Name</th>
					<th>Email</th>
					<th colspan="2">Action</th>
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

						<td>

							<form action="delete" method="get">
								<button class="btn btn-primary" type="submit" name="id"
									value="${u.iduser}"
									onclick="return confirm('Are you sure you want to delete this item?');">
									<i class="bi bi-x-square-fill"></i>
								</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


</body>
</html>