<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminPanel</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="Parking.css">

</head>
<header>
	<div class="fixed-header">
		<nav class="navbar navbar-dark bg-secondary justify-content-between">
			<img src="images/ParkingLogo.jpg" alt="" width="30" height="30"> 
		    <a  href="Admin.jsp" class="btn btn-info" type="button">Admin</a>
			<a href="" class="btn btn-info" type="button" style="vertical-align: left">User</a>
		</nav>	
	</div>	
</header>
<body>
	<div class="container">
			<h1 style="color: maroon; text-align: center;">All Contact List</h1>
		<table class="table" id="customers">
			<tr >
				<th>Location</th>
				<th>Type</th>
				<th>Classification</th>
				<th>Terms</th>
				<th>Price</th>
				<th>Discount</th>
				
			</tr>
			
			<c:forEach items="${add }" var="dto">
				<tr>
					<td>${dto.location }</td>
					<td>${dto.type }</td>
					<td>${dto.classification }</td>
					<td>${dto.terms }</td>
					<td>${dto.price }</td>
					 <td>${dto.discount }</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
</body>
<div class="fixed-footer">
	 <footer class="bg-secondary text-white" style="margin-top: 547px;">
	    <div class="text-center p-3" style="background-color: secondary;">
	      © 2023 Copyright:
	      <a class="text-white" href="https://irfan.xworkz@gmail.com/">irfan.xworkz@gmail.com</a>
	    </div>
	  </footer>
</div>	  
</html>