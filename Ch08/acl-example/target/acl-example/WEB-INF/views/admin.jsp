<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/extras/spring-security">

<head>
    <title>Spring Security 5 and ACL.</title>
</head>
<body>
<h1>Welcome to Admin page: <strong>${user}</strong></h1>
<h2>You are succesfully logged as Admin!</h2>

<br/>
<p>Click <a href="/forum/posts">here</a> to manage your posts.</p>

</br>
<form action="/logout" method="post">
    <input type="submit" value="Sign Out"/>
</form>

</body>
</html>