<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
<script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
<script
	src="https://unpkg.com/bootstrap-table@1.21.2/dist/bootstrap-table.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap-table@1.21.2/dist/bootstrap-table.min.css">


<link rel="stylesheet" href="Styles.css">

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<span>YohanCorp</span>
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
					href="AppEmp.html">Ajouter un.e employé.e</a></li>
			</ul>
			<div class="dropdown">
				<span>Mouse over me</span>
				<div class="dropdown-content">
					<a href="AjoutUSer.html">Ajouter un user</a> 
					<a href="tabu">Liste des Users</a>
				</div>
			</div>
		</div>
		${message} <a href="logout" class="btn btn-primary">Logout</a>

	</nav>
	<h1>Gestion des employées</h1>
	<div class="container">

		<table class="table table-bordered" data-toggle="table"
			data-pagination="true" data-search="true" data-page-size="5"
			data-page-list="[5, 10, 25, 50, All]">
			<thead class="th">
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Start Date</th>
					<th>Email</th>
					<th>Role Name</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${users}" var="u">

					<tr>
						<td>${u.iduser}</td>
						<td>${u.firstname}</td>
						<td>${u.lastname}</td>
						<td><fmt:parseDate value="${u.creationDate}"
								pattern="dd/mm/yyyy" /></td>
						<td>${u.email}</td>
						<td>${u.rolename}</td>

						<td>
							<div class="d-inline">
								<form action="change" method="get">
									<button type="submit" class="btn btn-outline-primary" name="id"
										value="${u.iduser}">
										<i class="bi bi-pen-fill"></i>
									</button>
								</form>
								<form action="delete" method="get">
									<button class="btn btn-outline-primary" type="submit" name="id"
										value="${u.iduser}"
										onclick="return confirm('Are you sure you want to delete this item?');">
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
</body>
</html>