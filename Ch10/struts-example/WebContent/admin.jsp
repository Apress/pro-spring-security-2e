 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
 <%@page import="java.security.Principal" %>  
 <html>  
 <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Hello Spring Security and Struts 2 page</title>
</head>
 <body>  
      <h3>Congratulations ${username}! You accessed your first Spring Security and Struts 2 Application!</h3>       
      <c:url value="/logout" var="logoutUrl" />
      <a href="${logoutUrl}">Log Out</a>
 </body>  
 </html>  