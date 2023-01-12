<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link text-white"
					href="tab">Liste des employ�s</a></li>
				<li class="nav-item"><a class="nav-link text-white"
					href="AppEmp.jsp">Ajouter un employ�</a></li>
			</ul>
		</div>
		<a href="logout" class="btn btn-primary">Logout</a>

	</nav>
	<h2 class="fw-normal mb-3 pb-3 text-center">Editer le profil de
		l'employ� ${user.lastname} ${user.firstname}</h2>

	<form action="change" method="post">

		<input type="hidden" class="form-control" id="formGroupExampleInput"
			placeholder="id" name="id" value="${id}">


		<div class="form-outline mb-4">
			<label><b>Firstname</b></label> <input type="text"
				class="form-control" placeholder="firstname" name="firstname"
				value="${user.firstname}">
		</div>

		<div class="form-outline mb-4">
			<label for="lastname"><b>Lastname</b></label> <input type="text"
				class="form-control form-control-lg" placeholder='lastname'
				name="lastname" value="${user.lastname}">
		</div>

		<div class="form-outline mb-4">
			<label for="rolename"><b>Role Name</b></label> <input type="text"
				class="form-control form-control-lg" placeholder="rolename"
				name="rolename" value="${user.rolename}">
		</div>

		<div>
			<label for="start"><b>Start date:</b></label> <input type="date" value="${user.creationDate }"
				name="date" >
		</div>

		<div class="form-outline mb-4">
			<label for="email"><b>Email</b></label> <input type="text"
				class="form-control form-control-lg" placeholder="email"
				name="email" value="${user.email}">
		</div>

		<div class="form-outline mb-4">
			<label for="password"><b>Password</b></label> <input type="password"
				class="form-control form-control-lg" placeholder="password"
				name="password" value="${user.password}">
		</div>

		<div class="pt-1 mb-4">
			<button class="btn btn-primary mb-4" type="submit" name="id"
				value="${id}">Enregistrer</button>
		</div>
	</form>
</body>


</body>
</html>