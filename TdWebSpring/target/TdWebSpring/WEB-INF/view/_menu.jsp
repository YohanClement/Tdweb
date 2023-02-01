<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page isELIgnored="false"%>

<nav class="navbar navbar-expand-lg navbar-light bg-dark">
	<span class="text-white">Yohancorp </span>&nbsp;
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">

		<a class="nav-link text-white"
			href="${pageContext.request.contextPath}/welcome"> <spring:message
				code="Home" /></a> | &nbsp; <a class="nav-link text-white"
			href="${pageContext.request.contextPath}/userInfo"><spring:message
				code="info" /></a> | &nbsp; <a class="nav-link text-white"
			href="${pageContext.request.contextPath}/admin"><spring:message
				code="admin" /></a>

		<sec:authorize access="hasRole('ADMIN')">
		| &nbsp;<a class="nav-link text-white"
				href="${pageContext.request.contextPath}/employee"><spring:message
					code="employee" /></a>
		</sec:authorize>
		<sec:authorize access="!isAuthenticated()">
     | &nbsp;
				<a class="nav-link text-white log"
				href="${pageContext.request.contextPath}/login"><spring:message
					code="login" /></a>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
     | &nbsp;
				<a class="nav-link text-white log"
				href="${pageContext.request.contextPath}/logout"><spring:message
					code="logout" /></a>
		</sec:authorize>
		<div class="lang">
			&nbsp; <a href="?lang=en"><img
				src="${pageContext.request.contextPath}/resources/img/En.png"
				width="50" height="30" /> </a> <a href="?lang=fr"><img
				src="${pageContext.request.contextPath}/resources/img/Fr.jpg"
				width="50" height="30" /> </a>
		</div>
	</div>

</nav>