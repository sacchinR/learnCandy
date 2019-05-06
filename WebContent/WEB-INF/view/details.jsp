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

<form:form method="get" action="storeCandy" modelAttribute="candy">
	Candy Name:<form:input path="candyName"/><br><br>
	Price     :<form:input path="price"/><br><br>
	<form:hidden path="userId"/>
	<input type="submit" value="Store Candy"/>
	
</form:form>

</body>
</html>