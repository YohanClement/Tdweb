<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.js"></script>
  
  <link rel="stylesheet" href="Styles.css">
</head>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	

			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="tab">Employee</a></li>
				<li class="nav-item"><a class="nav-link" href="AppEmp.html">Ajouter
						un employee</a></li>
				<li class="nav-item"><a class="nav-link deco" href="logout">Déconnexion</a></li>
			</ul>
		
	</nav>
	<h1>${message}</h1>
</body>
</html>