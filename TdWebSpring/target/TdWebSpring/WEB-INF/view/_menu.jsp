<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@page isELIgnored="false"%>

<div style="border: 1px solid #ccc; padding: 5px; margin-bottom: 20px;">

	<a href="${pageContext.request.contextPath}/welcome">Home</a> | &nbsp;

	<a href="${pageContext.request.contextPath}/userInfo">User Info</a> |
	&nbsp; <a href="${pageContext.request.contextPath}/admin">Admin</a>

	<sec:authorize access="hasRole('ADMIN')">

		<a href="${pageContext.request.contextPath}/employee">Employee</a>
	</sec:authorize>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
 
     | &nbsp;
     <a href="${pageContext.request.contextPath}/logout">Logout</a>

	</c:if>

</div>