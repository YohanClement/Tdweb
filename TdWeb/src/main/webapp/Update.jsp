<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.js"></script>

<link rel="stylesheet" href="Styles.css">
<title>Mise a jour</title>
</head>
<body>
	<h2 class="fw-normal mb-3 pb-3 text-center">
		Editer le profil de l'employé
		<c:out value="${user.firstname} ${user.lastname"></c:out>
		}
	</h2>

	<form action="change" method="post">
	
		<div class="form-outline mb-4">
			<label for="firstname"><b>Firstname</b></label> <input type="text"
				class="form-control form-control-lg" name="firstname" value='<c:out value="${user.firstname}"></c:out>'>
		</div>

		<div class="form-outline mb-4">
			<label for="lastname"><b>Lastname</b></label> <input type="text"
				class="form-control form-control-lg" name="lastname" value='<c:out value="${user.lastname}"></c:out>'>
		</div>

		<div class="form-outline mb-4">
			<label for="rolename"><b>Role Name</b></label> <input type="text"
				class="form-control form-control-lg" name="rolename" value='<c:out value="${user.rolename}"></c:out>'>
		</div>

		<div class="form-outline mb-4">
			<label for="email"><b>Email</b></label> <input type="text"
				class="form-control form-control-lg" placeholder="Enter email"
				name="email" value='<c:out value="${user.email}"></c:out>'>
		</div>

		<div class="form-outline mb-4">
			<label for="password"><b>Password</b></label> <input type="password"
				class="form-control form-control-lg" placeholder="Enter Password"
				name="password" value='<c:out value="${user.password}"></c:out>'>
		</div>

		<div class="pt-1 mb-4">
			<button class="btn btn-primary mb-4" type="submit">Enregistrer</button>
		</div>
	</form>
</body>


</body>
</html>