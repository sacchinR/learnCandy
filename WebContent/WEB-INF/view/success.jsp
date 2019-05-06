<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candy details</title>
<style>
	table tr td{
		padding:10px;
		border:1px solid black;
	}

</style>
</head>
<body>

<h1>Welcome</h1>
<c:choose>
	<c:when test="${check==0 }">
		<h2>Invalid Input</h2>
	</c:when>
	
	<c:otherwise>
	
	<c:url value="addCandy" var="addCandies">
		<c:param name="userId" value="${check}"></c:param>
	</c:url>
	
	
	<a href="${addCandies}">  <input type="submit" value="Add Candy"> </a><br><br>
	
	<c:if test="${msg==0 }">
			<table>
				
				<tr>
					<td>Candy Id</td>
					<td>Candy Name</td>
					<td>Candy Price</td>
					<td>Action</td>
				</tr>
				
				
					
					
						<c:forEach items="${candies}" var="candy">
						
							<c:url value="deleteCandy" var="delete">
								<c:param name="candyId" value="${candy.candy_id }">
								</c:param>
							</c:url>
						
							<tr>
								<td>${candy.candy_id}</td>
								<td>${candy.candyName }</td>
								<td>${candy.price }</td>
								<td> <a href="${delete}">Delete</a>
							</tr>
						</c:forEach>
					
					
					
			</table>
		</c:if>
		
		
			<c:if test="${msg!=0 }">
				<center>${msg }</center>
			</c:if>
			
			
		</c:otherwise>
</c:choose>
</body>
</html>