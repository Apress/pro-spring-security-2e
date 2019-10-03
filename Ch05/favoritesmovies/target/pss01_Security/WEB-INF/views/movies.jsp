<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Spring Security authentication example</title>
</head>
<body>
<h2>My favorites list of movies:</h2>
<br>Il Postino
<br>La vita e' bella
<br>NottingHill
<br><br>

<a href="<c:url value="/logout" />">Logout</a>

</body>
</html>

