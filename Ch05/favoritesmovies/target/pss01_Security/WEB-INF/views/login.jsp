
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Spring Security Custom Login Form</title>
</head>
<body onload='document.loginForm.username.focus();'>

<h1>Spring Security Custom Login Form:</h1>

<div id="login-box">

    <h2>Login with Username and Password</h2>


    <% if(request.getParameter("error") != null){
        out.println("ERROR LOGIN");
    }
    %>

    <c:url value="/login" var="loginUrl"/>
    <form action="${loginUrl}" method="post" default-target-url='/movies'>
        <table>
            <tr>
                <td>User:</td>
                <td><input type='text' name='username' value=''></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password' /></td>
            </tr>
            <tr>
                <td>Remember Me:</td>
                <td><input type="checkbox" name="remember-me" /></td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit"
                                       value="submit" /></td>
            </tr>
        </table>
    </form>

</div>

</body>
</html>