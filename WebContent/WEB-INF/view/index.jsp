<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form method="get" action="store" modelAttribute="register">
Username: <form:input path="username"/><br><br>
Password:<form:input path="password"/><br><br>
Email id:<form:input path="email"/><br><br>
Pet Name:<form:input path="petname"/><br><br>

<input type="submit" value="Reg"/>
</form:form>
<br><br>
Already have account?<br><br>
<form action="login" method="get">
<input type="submit" value="Login">

</form>


</body>
</html>