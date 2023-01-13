<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8" session="false"%>

<!DOCTYPE html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet" href="Styles.css">
</head>

<body>

	<section class="vh-100" style="background-color: #9A616D;">
		<div class="container h-100">

			<div class="card-body p-4 p-lg-5 text-black">
				<c:if test="${user == null }">
					<h1 id="error">${message}</h1>
				</c:if>
				<form action="login" method="post">

					<h2 class="fw-normal mb-3 pb-3 text-center"
						style="letter-spacing: 1px;">Sign into your account</h2>

					<div class="form-outline mb-4">
						<label for="email"><b>Email</b></label> <input type="text"
							class="form-control form-control-lg" placeholder="Enter email"
							name="email" required>

					</div>

					<div class="form-outline mb-4">
						<label for="password"><b>Password</b></label> <input
							type="password" class="form-control form-control-lg"
							placeholder="Enter Password" name="password" required>
					</div>

					<div class="pt-1 mb-4">
						<button class="btn btn-primary mb-4" type="submit">Se
							connecter</button>
					</div>
				</form>
				
				<a href="/add" class="nav-link text-white">Ajouter
						un user</a>
				<c:if
					test="${user == null && message=='Incorrect login. Please check your email ans password.' }">
					<h1 id="error">${message}</h1>
				</c:if>
			</div>
		</div>

	</section>
</body>

</html>