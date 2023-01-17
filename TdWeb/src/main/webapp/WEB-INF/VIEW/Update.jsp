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
<body class="body">
	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<span class="text-white mx-2">YohanCorp</span>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link text-white"
					href="tab">Accueil</a></li>
				<li class="nav-item"><a class="nav-link text-white"
					href="AppEmp.html">Ajouter un employé</a></li>
			</ul>
		</div>
		<a href="logout" class="btn btn-primary">Logout</a>

	</nav>
	<div class="container">
		<div class="card">
			<h2 class="fw-normal mb-3 pb-3 text-center">Editer le profil de
				l'employé ${emp.lastName} ${emp.firstName}</h2>

			<form action="update" method="post">

				<input type="hidden" class="form-control" id="formGroupExampleInput"
					placeholder="id" name="id" value="${id}">


				<div class="form-outline mb-4">
					<label><b>Prénom</b></label> <input type="text"
						class="form-control" placeholder="firstname" name="firstname"
						value="${emp.firstName}">
				</div>

				<div class="form-outline mb-4">
					<label for="lastname"><b>Nom de Famille</b></label> <input
						type="text" class="form-control form-control-lg"
						placeholder="lastname" name="lastname" value="${emp.lastName}">
				</div>

				<div class="form-outline mb-4">
					<label for="rolename"><b>Titre du poste</b></label> <input
						type="text" class="form-control form-control-lg"
						placeholder="rolename" name="rolename" value="${emp.title}">
				</div>

				<div>
					<label for="start"><b>Date d'entrée:</b></label> <input type="date"
						value="${emp.startDate }" name="date">
				</div>

				<div class="pt-1 mb-4">
					<button class="btn btn-primary mb-4" type="submit" name="id"
						value="${id}">S'enregistrer</button>
				</div>
			</form>
		</div>
	</div>
</body>


</body>
</html>