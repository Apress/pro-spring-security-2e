<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Hello Spring Security page</title>
</head>
<body>
<h2>Hello Spring Security!</h2><br>
<a href="<c:url value="/admin" />">Login as Admin</a>
</body>
</html>