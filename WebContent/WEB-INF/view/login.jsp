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
<form:form action="checklogin" method="post" modelAttribute="login">
Email Id:<form:input path="email"/><br><Br>
password:<form:input path="password"/><br><br>
<form:hidden path="username"/>
<form:hidden path="petname"/>
<input type="submit" value="Login"/>
</form:form>

</body>
</html>