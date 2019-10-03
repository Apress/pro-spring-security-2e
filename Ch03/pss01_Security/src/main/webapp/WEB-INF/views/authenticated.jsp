<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Spring Security authentication example</title>
</head>
<body>

<h2>Welcome to Spring Security authentication example!</h2>
Your username is: <strong>${user}</strong><br>
<sec:authorize access="hasRole('ADMIN')">
    You provided Admin authentication credentials!
</sec:authorize>
<br>
<sec:authorize access="hasRole('USER')">
    You provided User authentication credentials!
</sec:authorize>

<br><br>

<a href="<c:url value="/logout" />">Logout</a>

</body>
</html>