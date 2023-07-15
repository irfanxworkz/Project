<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="Simple.css">
</head>
<body>

	<nav class="navbar navbar-dark bg-dark justify-content-between">
		<a href="Evaluation.jsp" class="navbar-brand">Home</a>
	</nav>
	<h1 style="color: maroon; text-align: center;">All Student List</h1>
	<table class="table" id="customers">
		<tr >
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Comments</th>
			<th>FileName</th>
			<th>ContentType</th>
			<th>FileSize</th>
			
		</tr>
		
		<c:forEach items="${dtos }" var="dto">
			<tr>
				<td>${dto.id }</td>
				<td>${dto.name }</td>
				<td>${dto.email }</td>
				<td>${dto.mobile }</td>
				<td><a target="_blank" href="fileDownload?fileName=${dto.fileName }&contentType=${dto.contentType }">
				 ${dto.fileName }</a></td>
			</tr>
		</c:forEach>
		
	</table>

</body>
</html>