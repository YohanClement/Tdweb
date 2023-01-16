<%@ page language="java" contentType="text/html; charset=ISO-8859-1" session="false"
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
					href="tab">Liste des employés</a></li>
				<li class="nav-item"><a class="nav-link text-white"
					href="AppEmp.html">Ajouter un employé</a></li>
			</ul>
		</div>
		<a href="logout" class="btn btn-primary">Logout</a>

	</nav>
	<h2 class="fw-normal mb-3 pb-3 text-center">Editer le profil de
		l'employé ${user.lastname} ${user.firstname}</h2>

	<form action="change" method="post">

		<input type="hidden" class="form-control" id="formGroupExampleInput"
			placeholder="id" name="id" value="${id}">


		<div class="form-outline mb-4">
			<label><b>Prénom</b></label> <input type="text"
				class="form-control" name="firstname"
				value="${user.firstname}">
		</div>

		<div class="form-outline mb-4">
			<label for="lastname"><b>Nom de famille</b></label> <input type="text"
				class="form-control form-control-lg" 
				name="lastname" value="${user.lastname}">
		</div>

		<div class="form-outline mb-4">
			<label for="rolename"><b>Poste</b></label> <input type="text"
				class="form-control form-control-lg" 
				name="rolename" value="${user.rolename}">
		</div>

		<div>
			<label for="start"><b>Date de création</b></label> <input type="date"
				value="${user.creationDate }" name="date">
		</div>

		<div>
			<label for="email"><b>Email</b></label> <input type="text"
				class="form-control form-control-lg" 
				name="email" value="${user.email}">
		</div>
		
		<div>
			<label for="password"><b>mot de passe</b></label> <input type="password"
				class="form-control form-control-lg" 
				name="email" value="${user.password}">
		</div>

		<div class="pt-1 mb-4">
			<button class="btn btn-primary mb-4" type="submit" name="id"
				value="${id}">Enregistrer</button>
		</div>
	</form>
</body>


</body>
</html>